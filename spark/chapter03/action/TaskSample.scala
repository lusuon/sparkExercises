

import org.apache.spark.sql.SparkSession

object TaskSample {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("TaskSample").master("local").getOrCreate()
    val sc = spark.sparkContext
    val x = sc.parallelize(1 to 1000, 3)
    x.takeSample(true, 100, 1)
  }
}
