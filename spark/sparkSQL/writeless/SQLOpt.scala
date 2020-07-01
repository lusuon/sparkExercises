

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext

/**
  * Created by taos on 2017/6/10.
  * 求每个同学的平均成绩
  */
object SQLOpt {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("SQLOpt").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    val root = SQLOpt.getClass.getResource("/")
    val studentDF = sqlContext.read.format("json").load(root + "student.json")
    studentDF.show(10)
    studentDF.registerTempTable("student")
    val resultDF = sqlContext
      .sql("select name, avg(score) from student group by name")
    resultDF.show()
  }
}
