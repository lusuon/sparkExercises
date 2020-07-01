

import org.apache.spark.sql.SparkSession

/***
  * Similar to collect, but works on key-value RDDs
  * and converts them into Scala maps to preserve their key-value structure.
  *
  * def collectAsMap(): Map[K, V]
  */
object CollectAsMapDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("CollectAsMapDemo").master("local").getOrCreate()
    val sc = spark.sparkContext
    val a = sc.parallelize(List(1, 2, 1, 3), 1)
    val b = a.zip(a)
    b.collectAsMap
  }
}
