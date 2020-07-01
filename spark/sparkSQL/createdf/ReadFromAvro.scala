

import org.apache.spark.sql.{SparkSession}

object ReadFromAvro {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("").master("local").getOrCreate()
    val df1 = spark.read.format("com.databricks.spark.avro").load(SQLConstants.root +"users.avro")
    df1.show()
  }

}
