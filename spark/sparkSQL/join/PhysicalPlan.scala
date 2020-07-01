

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext

object PhysicalPlan {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("PhysicalPlan").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    val root = "D:\\data\\"
    val studentDF = sqlContext.read.format("json").load(root + "student.json")
    val studentCourse = sqlContext.read.format("json").load(root + "studentCourse.json")
    val result = studentDF.alias("a").join(studentCourse.alias("b"),
      studentDF("course") === studentCourse("course"), "inner")
      .where("a.course = 'eng'").select(studentCourse.col("teacher"))
    result.show()
  }
}
