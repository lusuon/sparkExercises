

import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by taos on 2017/6/26.
object WordCountWithSQL {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setMaster("local[4]").setAppName("WordCountWithSQL") //设置APP 的name，设置Local 模式的CPU资源
    val sc = new SparkContext(conf)
    //从本地磁盘读取wordCount.txt 这个文件
    val rdd = sc.textFile("hdfs://hadoop1:9000/out/wordCount.txt")
    val result = rdd.flatMap(line => line.split(" "))
    val sqlContext = new SQLContext(sc)
    val hiveContext = new org.apache.spark.sql.hive.HiveContext(sc)
    val wordDataFrame = sqlContext.createDataFrame(result.map(Row(_)),
      StructType(Seq(StructField("word", StringType, nullable = true)))
    )
    wordDataFrame.registerTempTable("word_table")
    val list = hiveContext.sql("SELECT row_number() over(order by count(word) desc) rank,word,count(word) count FROM word_table GROUP BY word LIMIT 5")
    list.show()
  }
}

  */