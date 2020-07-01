

import org.apache.spark.sql.SparkSession

object CombineByKeyDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("CombineByKey").master("local").getOrCreate()
    val sc = spark.sparkContext

    val a = sc.parallelize(List("dog","cat","gnu","salmon","rabbit","turkey","wolf","bear","bee"), 3)
    val b = sc.parallelize(List(1,1,2,2,2,1,2,2,2), 3)
    val c = b.zip(a)
    val d = c.combineByKey(List(_), (x:List[String], y:String) => y :: x, (x:List[String], y:List[String]) => x ::: y)
    d.collect
  }
}
