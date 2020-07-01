

import org.apache.spark.sql.SparkSession

object MapValuesDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("MapValuesDemo").master("local").getOrCreate()
    val sc = spark.sparkContext
    val a = sc.parallelize(List("dog", "tiger", "lion", "cat", "panther", "eagle"), 2)
    val b = a.map(x => (x.length, x))
    b.mapValues("x" + _ + "x").collect
  }
}
