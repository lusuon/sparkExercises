

import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SQLContext, SaveMode, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

object CreateSchema {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("CreateSchema").setMaster("local")
    val sc = new SparkContext(conf)

    val spark = SparkSession.builder().master("local[4]").appName("CreateSchema").getOrCreate()

    val sqlContext = new SQLContext(sc)
    val schemaString = "userID gender age occupation zipcode"
    val schema = StructType(schemaString.split(" ").map(fieldName =>
      StructField(fieldName, StringType, true)))

    val root = CreateSchema.getClass.getResource("/")
    val usersRdd = sc.textFile(root + "/ml-1m/users.dat")
    val userRDD2 = usersRdd.map(_.split("::")).map(p => Row(p(0), p(1).trim, p(2).trim,
      p(3).trim, p(4).trim))
    val userDataFrame2 = sqlContext.createDataFrame(userRDD2, schema)
    userDataFrame2.take(10)
    userDataFrame2.count()
    userDataFrame2.write.mode(SaveMode.Overwrite).json("/tmp/user.json")
    userDataFrame2.write.mode(SaveMode.Overwrite).parquet("/tmp/user.parquet")

  }
}
