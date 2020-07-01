

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext

/**
  * Created by taos on 2017/6/10.
  */
object RDDOpt {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("DFOpt").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    val root = SQLOpt.getClass.getResource("/")
    val studentDF = sqlContext.read.format("json").load(root + "student.json")
    studentDF.show()
//    +---+-------+------+-----+
//    |age| course|  name|score|
//    +---+-------+------+-----+
//    | 20|    eng|  Andy|   98|
//      | 20|chinese|  Andy|   93|
//      | 20|   math|  Andy|   88|
//      | 19|   math|Justin|   82|
//      | 19|    eng|Justin|   91|
//      | 19|chinese|Justin|   73|
//      | 19|   math|  jams|   88|
//      | 19|    eng|  jams|   90|
//      | 19|chinese|  jams|   71|
//      +---+-------+------+-----+
    val rdd = studentDF.rdd
   // rdd.take(2)
    val r = rdd.map{line =>
      (line(2).toString,(line(3).toString.toInt, 1))
    }.reduceByKey((x,y) => (x._1 + y._1, x._2 + y._2)).map(x => (x._1,x._2._1 / x._2._2))
    r.collect foreach println
  }

}
