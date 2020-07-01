


import org.apache.spark.sql.SparkSession

object CreateWithReflect {
  case class User(userID: Long, gender: String, age: Int, occupation: String, zipcode: Int)
  val root = "D:\\data\\sparkSQL\\"
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("CreateWithReflect").master("local").getOrCreate()
    val usersRdd = spark.sparkContext.textFile(SQLConstants.root + "/ml-1m/users.dat")
    val userRDD = usersRdd.map(_.split("::")).map(p => User(p(0).toLong, p(1).trim,
      p(2).toInt, p(3), p(4).toInt))
    import spark.implicits._
    //rdd 的泛型是User，转为DF 表头自动带出来
    val userDataFrame = userRDD.toDF()
    userDataFrame.show()
    userDataFrame.take(10)
    userDataFrame.count()
  }
}
