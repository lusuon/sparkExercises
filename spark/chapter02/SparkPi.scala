

import org.apache.spark.{SparkConf, SparkContext}

import scala.math.random

object SparkPi {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Spark Pi").setMaster("local")
    val spark = new SparkContext(conf)
    val slices = if (args.length > 0) args(0).toInt else 10
    //如果100000L * slices 大于int 最大值，就取Int 最大值
    val n = math.min(100000L * slices, Int.MaxValue).toInt // avoid overflow
    val count = spark.parallelize(1 until n, slices).map { i =>
      //random 是 0~1,x 和 y 是 -1 ~ 1 之间
      val x = random * 2 - 1
      val y = random * 2 - 1
      //到原点距离小于1 是在圆内
      if (x*x + y*y < 1) 1 else 0
    }.repartition(1).reduce(_ + _)
    //4 除以 正方形内的点/ 圆内的点
    println("Pi is roughly " + 4.0 * count / (n - 1)) // 1 until n 所以是n -1
    Thread.sleep(100000000)
    spark.stop()
  }
}