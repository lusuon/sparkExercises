

import org.apache.spark.sql.SparkSession

object AccumulatorsDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("AccumulatorsDemo").master("local").getOrCreate()
    val sc = spark.sparkContext
    val person_num = sc.longAccumulator("person_num")
    val total_score = sc.doubleAccumulator("total_score")
    val topK = sc.collectionAccumulator[Double]("topK")
    val rdd = sc.parallelize(Seq(
      ("zhangsan", 89.1),
      ("lisi", 90.2),
      ("wangwu", 78.5)
    )).map(x => {println(x);person_num.add(1);total_score.add(x._2);topK.add(x._2);x}).collect()

    println(s"person_num=${person_num.value}")
    println(s"total_score=${total_score.value}")
    println(s"topK=${topK.value}")
  }

}
