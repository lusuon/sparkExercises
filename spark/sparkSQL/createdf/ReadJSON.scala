


import org.apache.spark.SparkContext
import org.apache.spark.sql.{SQLContext, SparkSession}

/**
  * 读取json 文件，直接生成DF
  */
object ReadJSON {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local").appName("ReadJSON").getOrCreate()
    spark.sparkContext.setLogLevel("error")
    val df1 = spark.read.format("json").load(SQLConstants.root + "people.json")
    df1.show()
    val df2 = spark.read.json(SQLConstants.root + "people.json")
    df2.show()
  }

}
