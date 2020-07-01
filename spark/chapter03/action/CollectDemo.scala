

import org.apache.spark.sql.SparkSession

/**
  * Converts the RDD into a Scala array and returns it.
  * If you provide a standard map-function (i.e. f = T -> U)
  * it will be applied before inserting the values into the result array.
  *
  * def collect(): Array[T]
  * def collect[U: ClassTag](f: PartialFunction[T, U]): RDD[U]
  * def toArray(): Array[T]
  */
object CollectDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("CollectDemo").master("local").getOrCreate()
    val sc = spark.sparkContext
    val c = sc.parallelize(List("Gnu", "Cat", "Rat", "Dog", "Gnu", "Rat"), 2)
    c.collect
  }
}
