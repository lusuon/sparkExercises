

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Dataset, SparkSession}

object DataSetDemo {

  def main(args: Array[String]): Unit = {
    /*val conf = new SparkConf().setMaster("local").setAppName("ReadFromParquet")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)*/
    val spark = SparkSession.builder().appName("").master("local")
      .getOrCreate()
    val dataframe = spark.read.json(SQLConstants.root + "people.json")
    import spark.implicits._
    //映射为ds 对象，通过Person 对象的
    val ds: Dataset[Person] = dataframe.as[Person]
    //p.page 类型是确定的， 而 dataframe.filter("salary > 1000").show() 在运行时才能发觉异常
    val dsNew = ds.filter(p => p.age > 25)
    dsNew.show()
    //转换回来，泛型还在
    val rdd: RDD[Person] = dsNew.rdd
    //ds.filter(p => p.salary > 12500) 编译出错    

    val nbaPerdata = spark.read.option("header", "true")
      .option("inferSchema", "true")
      .csv(SQLConstants.root + "basketball\\leagues_NBA_1970_per_game_per_game.csv")
    nbaPerdata.show(10)
  }

}
case class Person(name: String, age: Long)