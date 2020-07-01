

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Dataset, SQLContext}

/**
  * Created by taos on 2017/6/10.
  */
object OOP {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("OOP")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    val root = "D:\\data\\"
    val dataframe = sqlContext.read.json(root + "people.json")
    import sqlContext.implicits._
    //映射为ds 对象，通过Person 对象的
    val ds: Dataset[Person] = dataframe.as[Person]
    val hist = ds.groupBy("name").count()
    hist.show()
    val hist1 = ds.groupBy("name").agg("age" -> "max")
    hist1.show()
    ds.groupBy("name").avg("age").show()
    ds.groupBy("name").sum("age").show()
  }
}