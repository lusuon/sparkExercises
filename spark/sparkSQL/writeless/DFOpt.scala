

import breeze.linalg.sum
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext

/**
  * Created by Administrator on 2017/6/10.
  */
object DFOpt {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("DFOpt").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    val root = SQLOpt.getClass.getResource("/")
    val studentDF = sqlContext.read.format("json").load(root + "student.json")
    //按name 分组，求平均分
    //Using DataFrame
    val resultDF = studentDF.groupBy("name")
      .agg(Map("score" -> "avg"))
    resultDF.show()
  }

}
