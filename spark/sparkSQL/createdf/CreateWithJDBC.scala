

import java.util.Properties

import org.apache.spark.sql.{DataFrame, SparkSession}

object CreateWithJDBC {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("CreateWithJDBC").master("local").getOrCreate()
    val properties = new Properties()
    properties.setProperty("user","hive")
    properties.put("password","123456")
    val url = "jdbc:mysql://172.16.29.61:3306/pms"
    val df: DataFrame = spark.read.jdbc(url,"sys_log",properties)
    df.select(df("id"), df("type"), df("title"), df("remote_addr")).limit(10).show()
  }
}
