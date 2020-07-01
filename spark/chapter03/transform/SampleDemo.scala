

import org.apache.spark.sql.SparkSession

object SampleDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("TaskSample").master("local").getOrCreate()
    val sc = spark.sparkContext
    val a = sc.parallelize(1 to 10000, 3)
    a.sample(false, 0.1, 0).count

    a.sample(true, 0.3, 0).count

    a.sample(true, 0.3, 13).count
  }

}
