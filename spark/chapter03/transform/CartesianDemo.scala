

import org.apache.spark.sql.SparkSession

object CartesianDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("CartesianDemo").master("local").getOrCreate()
    val sc = spark.sparkContext

    val x = sc.parallelize(List(1,2,3,4,5))
    val y = sc.parallelize(List(6,7,8,9,10))

    x.cartesian(y).collect.foreach(println)
  }
}
