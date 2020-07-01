

import org.apache.spark.mllib.recommendation.{ALS, Rating}
import org.apache.spark.{SparkConf, SparkContext}

object ALSDemo {

  def main(args: Array[String]): Unit = {
    val conf =  new SparkConf().setAppName("ALSDemo").setMaster("local")
    val sc = new SparkContext(conf)
    val root = "D:\\data\\sparkmllib\\"
    val data = sc.textFile(root + "als/test.data")
    val ratings = data.map(_.split(",") match {case Array(user, item, rate)=>
      Rating(user.toInt, item.toInt, rate.toDouble)
    })

    val rank = 10
    val numIterations = 10
    val model = ALS.train(ratings, rank, numIterations, 0.01)

    // Evaluate the model on rating data
    val usersProducts = ratings.map{
      case Rating(user, product, rate) => (user, product)
    }

    val predictions = model.predict(usersProducts).map{
      case Rating(user, product, rate) => ((user, product), rate)
    }

    val ratesAndPreds = ratings.map{
      case Rating(user, product, rate) => ((user, product), rate)
    }.join(predictions)

    val MSE = ratesAndPreds.map{
      case ((user, product), (r1, r2)) => val err = (r1 - r2); err * err
    }.mean()
    println("Mean squared Error = " + MSE)

    /*model.save(sc, "target/tmp/myCollaborativeFilter")
    val sameModel = MatrixFactorizationModel.load(sc, "target/tmp/myCollaborativeFilter")*/
  }
}
