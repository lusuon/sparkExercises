

import org.apache.spark.sql.SparkSession

object MapDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("MapPartitions").master("local").getOrCreate()
    val sc = spark.sparkContext

    val a = sc.parallelize(List("dog", "salmon", "salmon", "rat", "elephant"), 3)
    val b = a.map(_.length)
    val c = a.zip(b)
    c.collect
  }
}
