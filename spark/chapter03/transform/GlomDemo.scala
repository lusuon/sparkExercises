

import org.apache.spark.sql.SparkSession

object GlomDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("GlomDemo").master("local").getOrCreate()
    val sc = spark.sparkContext

    val a = sc.parallelize(1 to 100, 3)
    a.glom.collect
  }
}
