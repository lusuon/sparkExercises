

import org.apache.spark.sql.SparkSession

/**
  * 参照：http://spark.apache.org/docs/2.3.1/sql-programming-guide.html#hive-tables
  */
object CreateWithHive {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("")
      .master("local")
      .enableHiveSupport()
      .getOrCreate()
    import spark.implicits._
    import spark.sql

    /*sql("CREATE TABLE IF NOT EXISTS src (key INT, value STRING) USING hive")
    sql("LOAD DATA LOCAL INPATH " + SQLConstants.root + "kv1.txt' INTO TABLE src")*/
    sql("SELECT * FROM dataanalysis.tenmindata limit 10").show()
  }
}
