

import org.apache.spark.sql.SparkSession

object PersistDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("PersistDemo").master("local").getOrCreate()
    val sc = spark.sparkContext
    val c = sc.parallelize(List("Gnu", "Cat", "Rat", "Dog", "Gnu", "Rat"), 2)
    c.getStorageLevel

    c.cache
    c.getStorageLevel
  }
}
