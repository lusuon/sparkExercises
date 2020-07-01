


import org.apache.spark.sql.{SQLContext, SparkSession}
object ReadFromParquet {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("ReadFromParquet").master("local").getOrCreate()
    val df1 = spark.read.format("parquet").load(SQLConstants.root +"users.parquet")
    df1.show()
    val df2 = spark.read.parquet(SQLConstants.root +"users.parquet")
    df2.show()
  }
}
