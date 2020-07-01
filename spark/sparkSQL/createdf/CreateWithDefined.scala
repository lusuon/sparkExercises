


import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types._

object CreateWithDefined {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("CreateWithDefined").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("WARN")
    val usersRdd = spark.sparkContext.textFile(SQLConstants.root + "/ml-1m/users.dat")
      .map(_.split("::"))
      .map(p => Row(p(0).toLong, p(1).trim,p(2).toInt, p(3), p(4).toInt))
    val fields = Array(StructField("userID", LongType, true)
      ,StructField("gender", StringType, true)
      ,StructField("age", IntegerType, true)
      ,StructField("occupation", StringType, true)
      ,StructField("zipcode", IntegerType, true))
    val schema = StructType(fields)
    val userDF = spark.createDataFrame(usersRdd, schema)
    userDF.show()
  }

}
