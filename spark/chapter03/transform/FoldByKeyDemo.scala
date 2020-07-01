

import org.apache.spark.sql.SparkSession

/**
  * Very similar to fold, but performs the folding separately for each key of the RDD.
  * This function is only available if the RDD consists of two-component tuples.
  *
  * def foldByKey(zeroValue: V)(func: (V, V) => V): RDD[(K, V)]
  * def foldByKey(zeroValue: V, numPartitions: Int)(func: (V, V) => V): RDD[(K, V)]
  * def foldByKey(zeroValue: V, partitioner: Partitioner)(func: (V, V) => V): RDD[(K, V)]
  */
object FoldByKeyDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("FoldByKeyDemo").master("local").getOrCreate()
    val sc = spark.sparkContext

    val a = sc.parallelize(List("dog", "cat", "owl", "gnu", "ant"), 2)
    val b = a.map(x => (x.length, x))
    b.foldByKey("")(_ + _).collect

    val c = sc.parallelize(List("dog", "tiger", "lion", "cat", "panther", "eagle"), 2)
    val d = c.map(x => (x.length, x))
    d.foldByKey("")(_ + _).collect
  }
}
