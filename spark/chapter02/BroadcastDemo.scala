

import org.apache.spark.sql.SparkSession
import scala.math.random

object BroadcastDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("BroadcastDemo").master("local").getOrCreate()
    val sc = spark.sparkContext
    val broadcastVar = sc.broadcast(Array(1, 2, 3))
    println(broadcastVar.value.foreach(println))

    println(sc.parallelize(1 to 10000, 10).map(f1).reduce(_ + _))

    def f1(num:Int):Int = {
      if(broadcastVar.value.contains((random*10).toInt)) 1 else 0
    }
  }
}
