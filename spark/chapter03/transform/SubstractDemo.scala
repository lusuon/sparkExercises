

import org.apache.spark.sql.SparkSession

object SubstractDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("SubstractDemo").master("local").getOrCreate()
    val sc = spark.sparkContext
    val a = sc.parallelize(1 to 9, 3)
    val b = sc.parallelize(1 to 3, 3)
    val c = a.subtract(b)
    c.collect
  }
}
