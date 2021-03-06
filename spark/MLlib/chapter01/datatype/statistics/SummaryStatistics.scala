

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.mllib.stat.{MultivariateStatisticalSummary, Statistics}
import org.apache.spark.rdd.RDD

/**
  * 摘要统计Demo
  *
  */
object SummaryStatistics {

  def main(args: Array[String]): Unit = {
    val conf =  new SparkConf().setMaster("local").setAppName("SummaryStatistics")
    val sc = new SparkContext(conf)
    //val root = SummaryStatistics.getClass.getResource("/")
    val root = "D:\\data\\sparkmllib\\"
    val rdd = sc.textFile(root + "correlations.csv")
    val observations: RDD[Vector] = rdd.filter(_.split(",")(0) != "NumPregnancies").map {
      line =>
        val array = line.split(",")
        val dArray = array.map(_.toDouble)
        Vectors.dense(dArray)
    }
    // Compute column summary statistics.
    val summary: MultivariateStatisticalSummary = Statistics.colStats(observations)
    println(summary.mean) // a dense vector containing the mean value for each column
    println(summary.variance) // 列方差
    println(summary.numNonzeros) // number of nonzeros in each column

    Thread.sleep(100000000)
  }
}
