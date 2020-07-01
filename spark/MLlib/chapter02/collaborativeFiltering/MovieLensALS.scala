

import java.util.Random

import org.apache.spark.mllib.recommendation.{ALS, MatrixFactorizationModel, Rating}
import org.apache.spark.rdd._
import org.apache.spark.{SparkConf, SparkContext}

object MovieLensALS {

  def main(args: Array[String]) {
    var dataPath = "D:\\data\\sparkmllib\\als\\"
    val conf = new SparkConf().setAppName("MovieLensALS")
      .set("spark.executor.memory", "6G")
      .set("spark.driver.memory", "2G")
      .set("spark.driver.extraJavaOptions", "-Xss60M")
    if(args.length > 0) {
      dataPath = args(0)
    } else {
      conf.setMaster("local[*]")
    }

    val movieLensHomeDir = dataPath

    if(!new java.io.File(movieLensHomeDir + "/sample_movielens_ratings.txt").exists) {
      println("File rating.dat is not exist under directory:" + movieLensHomeDir)
      System.exit(1)
    }

    if(!new java.io.File(movieLensHomeDir + "/sample_movielens_movies.txt").exists) {
      println("File movies.dat is not exist under directory:" + movieLensHomeDir)
      System.exit(1)
    }
    
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")

    // load ratings and movie titles
    val ratings = sc.textFile(movieLensHomeDir + "/sample_movielens_ratings.txt").map { line =>
      val fields = line.split("::")
      // format: (timestamp % 10, Rating(userId, movieId, rating))
      (fields(3).toLong % 10, Rating(fields(0).toInt, fields(1).toInt, fields(2).toDouble))
    }

    val movies = sc.textFile(movieLensHomeDir + "/sample_movielens_movies.txt").map { line =>
      val fields = line.split("::")
      // format: (movieId, movieName)
      (fields(0).toInt, fields(1))
    }.collect.toMap

    // 总数据条数
    val numRatings = ratings.count
    // 总用户数量
    val numUsers = ratings.map(_._2.user).distinct.count
    // 总电影数量
    val numMovies = ratings.map(_._2.product).distinct.count
    println("Got " + numRatings + " ratings from "
        + numUsers + " users on " + numMovies + " movies.")

    // sample a subset of most rated movies for rating elicitation
    // 评分数量最多的topk条电影的ID
    val mostRatedMovieIds = ratings.map(_._2.product) // extract movie ids
        .countByValue      // 统计每部电影的评分数量
        .toSeq             // convert map to Seq
        .sortBy(- _._2)    // 按照评分数量倒序排序
        .take(50)          // take 50 most rated
        .map(_._1)         // get their ids
    val random = new Random(0)
    // 随机提取出部分电影ID数据，并获取电影名称(ID,影片名称)
    val selectedMovies = mostRatedMovieIds.filter(x => random.nextDouble() < 0.2)
        .map(x => (x, movies(x)))
        .toSeq

    // elicitate ratings
    val myRatings = elicitateRatings(selectedMovies)
    val myRatingsRDD = sc.parallelize(myRatings, 1)

    // split ratings into train (60%), validation (20%), and test (20%) based on the
    // last digit of the timestamp, add myRatings to train, and cache them

    val numPartitions = 20
    val splits = ratings.randomSplit(Array(0.6, 0.2, 0.2), seed = 11L)
    val training = splits(0).values.union(myRatingsRDD).repartition(numPartitions).persist()
    val validation = splits(1).values.repartition(numPartitions).persist()
    val test = splits(2).values.repartition(numPartitions).persist()
    /*val training = ratings.filter(x => x._1 < 6)
        .values
        .union(myRatingsRDD)
        .repartition(numPartitions)
        .persist
    val validation = ratings.filter(x => x._1 >= 6 && x._1 < 8)
        .values
        .repartition(numPartitions)
        .persist
    val test = ratings.filter(x => x._1 >= 8).values.persist*/

    val numTraining = training.count
    val numValidation = validation.count
    val numTest = test.count

    println("Training: " + numTraining + ", validation: " + numValidation + ", test: " + numTest)

    // train models and evaluate them on the validation set

    val ranks = List(8, 12)
    val lambdas = List(0.1, 10.0)
    val numIters = List(10, 20)
    var bestModel: Option[MatrixFactorizationModel] = None
    var bestValidationRmse = Double.MaxValue
    var bestRank = 0
    var bestLambda = -1.0
    var bestNumIter = -1
    for (rank <- ranks; lambda <- lambdas; numIter <- numIters) {
      /**
        * 1.rank:要使用的特征个数，根据数据的分散情况测试出来的值，特征向量维度，如果这个值太小你和的就会不够，误差就很大。
        * 如果这个值很大，会导致模型泛化能力较差；所以就需要自己把握一个度，一般情况下10~1000都是可以的。
        *
        * 2.iterations:迭代次数，这个数值的越大肯定是越精确，但是设置的大就意味着耗时。
        *
        * 3.lambda:如果设置很大就可以防止过拟合的问题，如果设置的很小，其实可以理解为直接设置为0.
        * 那么就不会有防止过拟合的功能了。怎么设置呢？
        * 可以从0.0001,0.0003,0.001,0.003,0.01,0.03,0.1,0.3,1,3,10这样类设置。
        * 先大概看下哪个值比较好，然后哪个比较好的值(比如0.01)前后再设置一个范围，
        * 比如(0.003,0.3)之间，间隔设置小一点，即：0.003,0.005,0.007.....
        * 当然，如果机器性能特别好，而且时间也足够，可以设置从0~100，间隔很小去尝试。
        */
      val model = ALS.train(training, rank, numIter, lambda)
      val validationRmse = computeRmse(model, validation, numValidation)
      println("RMSE (validation) = " + validationRmse + " for the model trained with rank = "
          + rank + ", lambda = " + lambda + ", and numIter = " + numIter + ".")
      if (validationRmse < bestValidationRmse) {
        bestModel = Some(model)
        bestValidationRmse = validationRmse
        bestRank = rank
        bestLambda = lambda
        bestNumIter = numIter
      }
    }

    // evaluate the best model on the test set

    val testRmse = computeRmse(bestModel.get, test, numTest)

    println("The best model was trained with rank = " + bestRank + " and lambda = " + bestLambda
        + ", and numIter = " + bestNumIter + ", and its RMSE on the test set is " + testRmse + ".")

    // create a naive baseline and compare it with the best model
    val meanRating = training.union(validation).map(_.rating).mean
    val baselineRmse = math.sqrt(test.map(x => (meanRating - x.rating) * (meanRating - x.rating))
        .reduce(_ + _) / numTest)
    val improvement = (baselineRmse - testRmse) / baselineRmse * 100
    println("The best model improves the baseline by " + "%1.2f".format(improvement) + "%.")

    // make personalized recommendations

    val myRatedMovieIds = myRatings.map(_.product).toSet
    val candidates = sc.parallelize(movies.keys.filter(!myRatedMovieIds.contains(_)).toSeq)
    val recommendations = bestModel.get
        .predict(candidates.map((0, _)))
        .collect
        .sortBy(- _.rating)
        .take(50)

    var i = 1
    println("Movies recommended for you:")
    recommendations.foreach { r =>
      println("%2d".format(i) + ": " + movies(r.product))
      i += 1
    }

    // clean up
    sc.stop()
  }

  /** Compute RMSE (Root Mean Squared Error). */
  def computeRmse(model: MatrixFactorizationModel, data: RDD[Rating], n: Long) = {
    val predictions: RDD[Rating] = model.predict(data.map(x => (x.user, x.product)))
    val predictionsAndRatings = predictions.map(x => ((x.user, x.product), x.rating))
        .join(data.map(x => ((x.user, x.product), x.rating)))
        .values
    math.sqrt(predictionsAndRatings.map(x => (x._1 - x._2) * (x._1 - x._2)).reduce(_ + _) / n)
  }

  /** Elicitate ratings from command-line. */
  def elicitateRatings(movies: Seq[(Int, String)]) = {
    val prompt = "Please rate the following movie (1-5 (best), or 0 if not seen):"
    println(prompt)
    val ratings = movies.flatMap { x =>
      var rating: Option[Rating] = None
      var valid = false
      while (!valid) {
        print(x._2 + ": ")
        try {
          val r = Console.readInt
          if (r < 0 || r > 5) {
            println(prompt)
          } else {
            valid = true
            if (r > 0) {
              rating = Some(Rating(0, x._1, r))
            }
          }
        } catch {
          case e: Exception => println(prompt)
        }
      }
      rating match {
        case Some(r) => Iterator(r)
        case None => Iterator.empty
      }
    }
    if(ratings.isEmpty) {
      error("No rating provided!")
    } else {
      ratings
    }
  }
}
