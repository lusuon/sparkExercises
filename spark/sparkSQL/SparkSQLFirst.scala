

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by taos on 2017/6/8.
  */
object SparkSQLFirst {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("SparkSQLFirst").setMaster("local")
    val sc = new SparkContext(conf)
    import org.apache.spark.sql._
    val sqlContext = new SQLContext(sc)
    val root  =  SparkSQLFirst.getClass.getResource("/")
    //读取json 文件
    val df = sqlContext.read.format("json")
      .option("samplingRadio","0.1")//设置参数，只读取10%数据
      .load(root + "people.json")

    df.write.format("parquet")
      .mode("append")
      //.partitionBy("") 根据某个字段分区
      .saveAsTable("fasterData")
  }
}
