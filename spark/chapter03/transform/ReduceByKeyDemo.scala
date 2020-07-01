

import org.apache.spark.sql.SparkSession

object ReduceByKeyDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("ReduceByKeyDemo").master("local").getOrCreate()
    val sc = spark.sparkContext

    val a = sc.parallelize(List("dog", "cat", "owl", "gnu", "ant"), 2)
    val b = a.map(x => (x.length, x))
    b.reduceByKey(_ + _).collect

    val c = sc.parallelize(List("dog", "tiger", "lion", "cat", "panther", "eagle"), 2)
    val d = a.map(x => (x.length, x))
    d.reduceByKey(_ + _).collect
  }
}
