

import org.apache.spark.sql.SparkSession
/*
object JoinDemo {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("JoinDemo").master("local").getOrCreate()
    val sc = spark.sparkContext
    val a = sc.parallelize(List("dog", "salmon", "salmon", "rat", "elephant"), 3)
    val b = a.keyBy(_.length)
    val c = sc.parallelize(List("dog","cat","gnu","salmon","rabbit","turkey","wolf","bear","bee"), 3)
    val d = c.keyBy(_.length)
    b.join(d).collect
  }
}
*/