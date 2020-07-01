

import org.apache.spark.sql.SparkSession

/**
  * This function provides the well-known reduce functionality in Spark.
  * Please note that any function f you provide,
  * should be commutative in order to generate reproducible results.
  *
  * def reduce(f: (T, T) => T): T
  */
object ReduceDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("ReduceDemo").master("local").getOrCreate()
    val sc = spark.sparkContext

    val a = sc.parallelize(1 to 100, 3)
    a.reduce(_ + _)
  }

}
