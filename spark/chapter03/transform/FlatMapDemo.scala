

import org.apache.spark.sql.SparkSession

object FlatMapDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("MapPartitions").master("local").getOrCreate()
    val sc = spark.sparkContext

    val a = sc.parallelize(1 to 10, 5)
    a.flatMap(1 to _).collect

    sc.parallelize(List(1, 2, 3), 2).flatMap(x => List(x, x, x)).collect

    val x  = sc.parallelize(1 to 10, 3)
    x.flatMap(List.fill(scala.util.Random.nextInt(10))(_)).collect
  }
}
