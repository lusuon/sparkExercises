

import org.apache.spark.{SparkConf, SparkContext}

object JoinDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Spark Pi").setMaster("local")
    val sc = new SparkContext(conf)
    val visits = sc.parallelize(List(
      ("index.html", "1.2.3.4"),
      ("about.html", "3.4.5.6"),
      ("index.html", "1.3.3.1")
    ))
    val pageNames = sc.parallelize(List(
      ("index.html", "Home"), ("about.html", "About")
    ))

    val rdd1 = visits.join(pageNames)
    val rdd2 = visits.cogroup(pageNames)
  }
}
