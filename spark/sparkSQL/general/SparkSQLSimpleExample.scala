

import org.apache.spark._
import org.apache.spark.sql.types.{StringType, StructField, StructType}

object SparkSQLSimpleExample {
  case class User(userID: String, gender: String, age: String, occupation: String, zipcode: String)

  def main(args: Array[String]) {
    var dataPath = "data/ml-1m"
    val conf = new SparkConf().setAppName("SparkSQLSimpleExample")
    if(args.length > 0) {
      dataPath = args(0)
    } else {
      conf.setMaster("local[1]")
    }
//spark 2.x 写法
//    val spark = SparkSession
//        .builder()
//        .appName("SparkSQLSimpleExample")
//        .config(conf)
//        .getOrCreate()

//    val sc = spark.sparkContext

      val sc =  new SparkContext(conf)

    /**
     * Create RDDs
     */
    val DATA_PATH = SparkSQLSimpleExample.getClass.getResource("/")
    val usersRdd = sc.textFile(DATA_PATH + "/ml-1m/users.dat")

    /**
     * Method 1: 通过显式为RDD注入schema，将其变换为DataFrame
     */
    import org.apache.spark.sql._
    val sqlContext = new SQLContext(sc)
    val userRDD = usersRdd.map(_.split("::")).map(p => User(p(0), p(1), p(2), p(3), p(4)))
    import sqlContext.implicits._
    val userDataFrame = userRDD.toDF()
    userDataFrame.take(10)
    userDataFrame.count()

    /**
     * Method 2: 通过反射方式，为RDD注入schema，将其变换为DataFrame
     */
    val schemaString = "userID gender age occupation zipcode"
    val schema = StructType(schemaString.split(" ").map(fieldName => StructField(fieldName, StringType, true)))
    val userRDD2 = usersRdd.map(_.split("::")).map(p => Row(p(0), p(1).trim, p(2).trim, p(3).trim, p(4).trim))
    val userDataFrame2 = sqlContext.createDataFrame(userRDD2, schema)
    userDataFrame2.take(10)
    userDataFrame2.count()
    userDataFrame2.write.mode(SaveMode.Overwrite).json("/tmp/user.json")
    userDataFrame2.write.mode(SaveMode.Overwrite).parquet("/tmp/user.parquet")
    //userDataFrame2.limit(10).write.json("/tmp/user.json")

    /**
     * 读取json格式数据1： read.format("json").load(...)
     */
    val userJsonDF = sqlContext.read.format("json").load("/tmp/user.json")
    userJsonDF.take(10)

    /**
     * 读取json格式数据2： read.json(...)
     */
    val userJsonDF2 = sqlContext.read.json("/tmp/user.json")
    userJsonDF2.take(10)


    /**
     * 读取parquet格式数据1： read.format("parquet").load(...)
     */
    val userParquetDF = sqlContext.read.format("parquet").load("/tmp/user.parquet")
    userParquetDF.take(10)

    /**
     * 读取parquet格式数据2： read.parquet(...)
     */
    val userParquetDF2 = sqlContext.read.parquet("/tmp/user.parquet")
    userParquetDF2.take(10)

    /**
     * 读取parquet格式数据2： read.parquet(...)
     */
    val ratingsRdd = sc.textFile(DATA_PATH + "ratings.dat")

    val ratingSchemaString = "userID movieID Rating Timestamp"
    val ratingSchema = StructType(ratingSchemaString.split(" ")
        .map(fieldName => StructField(fieldName, StringType, true)))
    val ratingRDD = ratingsRdd.map(_.split("::")).map(p => Row(p(0), p(1).trim, p(2).trim, p(3).trim))
    val ratingDataFrame = sqlContext.createDataFrame(ratingRDD, ratingSchema)

    val mergedDataFrame = ratingDataFrame.filter("movieID = 2116").
        join(userDataFrame, "userID").
        select("gender", "age").
        groupBy("gender", "age").
        count

    val mergedDataFrame2 = ratingDataFrame.filter("movieID = 2116").
        join(userDataFrame, userDataFrame("userID") === ratingDataFrame("userID"), "inner").
        select("gender", "age").
        groupBy("gender", "age").
        count

    mergedDataFrame.collect().foreach(println(_))

    userDataFrame.registerTempTable("users")
    val groupedUsers = sqlContext.sql("select gender, age, count(*) as n from users group by gender, age")
    groupedUsers.show()

    userDataFrame.map { u =>
      (u.getAs[String]("userID").toLong, u.getAs[String]("age").toInt + 1)
    }.take(10).foreach(println)

    sc.stop()
  }
}