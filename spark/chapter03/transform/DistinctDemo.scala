

import org.apache.spark.sql.SparkSession

object DistinctDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("SubstractDemo").master("local").getOrCreate()
    val sc = spark.sparkContext
    val c = sc.parallelize(List("Gnu", "Cat", "Rat", "Dog", "Gnu", "Rat"), 2)
    c.distinct.collect

    val a = sc.parallelize(List(1,2,3,4,5,6,7,8,9,10,1))
    a.distinct(2).partitions.length

    a.distinct(3).partitions.length
  }
}
