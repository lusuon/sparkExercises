

import org.apache.spark.sql.SparkSession

/**
  * A very powerful set of functions that allow grouping up to 3 key-value RDDs
  * together using their keys.
  */
object CogroupDemo {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("CogroupDemo").master("local").getOrCreate()
    val sc = spark.sparkContext
    val a = sc.parallelize(List(1, 2, 1, 3), 1)
    val b = a.map((_, "b"))
    val c = a.map((_, "c")).union(b)
    b.cogroup(c).collect

    val d = a.map((_, "d"))
    b.cogroup(c, d).collect

    val x = sc.parallelize(List((1, "apple"), (2, "banana"), (3, "orange"), (4, "kiwi")), 2)
    val y = sc.parallelize(List((5, "computer"), (1, "laptop"), (1, "desktop"), (4, "iPad")), 2)
    x.cogroup(y).collect

    // 等价于cogroup
    x.groupWith(y).collect()

  }
}
