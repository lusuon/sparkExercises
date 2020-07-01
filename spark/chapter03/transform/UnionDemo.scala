

import org.apache.spark.sql.SparkSession

object UnionDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("UnionDemo").master("local").getOrCreate()
    val sc = spark.sparkContext

    val a = sc.parallelize(1 to 3, 1)
    val b = sc.parallelize(5 to 7, 1)

    (a ++ b).collect
    a union b collect
  }
}
