

import org.apache.spark.Partitioner
import org.apache.spark.sql.SparkSession

object PartitionByDemo {

  def myfunc(index: Int, iter: Iterator[(Int, Int)]) : Iterator[String] = {
    iter.map(x => "[partID:" +  index + ", val: " + x + "]")
  }

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("PartitionByDemo").master("local").getOrCreate()
    val sc = spark.sparkContext

    val a = sc.parallelize(1 to 10, 2)
    val b = a.map(x => (x, x))
    b.mapPartitionsWithIndex[String](myfunc).collect()

    val c = b.partitionBy(new MyPartioner)

    c.mapPartitionsWithIndex[String](myfunc).collect()
  }

}

class MyPartioner extends Partitioner {
  override def numPartitions = 2

  override def getPartition(key: Any) = key.toString.toInt%2

}
