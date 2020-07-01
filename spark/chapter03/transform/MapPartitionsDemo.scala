

import org.apache.spark.sql.SparkSession

object MapPartitionsDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("MapPartitions").master("local").getOrCreate()
    val sc = spark.sparkContext
    val a = sc.parallelize(1 to 9, 3)
    def myfunc[T](iter: Iterator[T]) : Iterator[(T, T)] = {
      var res = List[(T, T)]()
      var pre = iter.next
      while (iter.hasNext)
      {
        val cur = iter.next;
        res .::= (pre, cur)
        pre = cur;
      }
      res.iterator
    }
    a.mapPartitions(myfunc).collect
  }
}
