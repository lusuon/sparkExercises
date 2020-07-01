

import org.apache.spark.sql.SparkSession

/**
  * Aggregates the values of each partition.
  * The aggregation variable within each partition is initialized with zeroValue.
  *
  * def fold(zeroValue: T)(op: (T, T) => T): T
  *
*/
object FoldDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("FoldDemo").master("local").getOrCreate()
    val sc = spark.sparkContext
    val a = sc.parallelize(List(1,2,3), 3)
    a.fold(0)(_ + _)
    a.fold(1)(_ + _)
  }
}
