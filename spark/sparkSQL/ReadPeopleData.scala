

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object ReadPeopleData {
  def main(args: Array[String]): Unit = {
    /*val conf = new SparkConf().setAppName("ReadPeopleData").setMaster("local")
    val sc = new SparkContext(conf)
    // sc is an existing SparkContext.
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)*/
    val spark = SparkSession.builder().master("local").appName("ReadPeopleData").getOrCreate()
    // A JSON dataset is pointed to by path.
    // The path can be either a single text file or a directory storing text files.
    val path  =  ReadPeopleData.getClass.getResource("/")
    val people = spark.read.json(path + "people.json")
    // The inferred schema can be visualized using the printSchema() method.
    people.printSchema()
    // root
    //  |-- age: integer (nullable = true)
    //  |-- name: string (nullable = true)

    // Register this DataFrame as a table.
    people.registerTempTable("people")

    // SQL statements can be run by using the sql methods provided by sqlContext.
    val teenagers = spark.sql("SELECT name FROM people WHERE age >= 13 AND age <= 19")
    teenagers.show()
    // Alternatively, a DataFrame can be created for a JSON dataset represented by
    // an RDD[String] storing one JSON object per string.
    val anotherPeopleRDD = spark.sparkContext.parallelize(
      """{"name":"Yin","address":{"city":"Columbus","state":"Ohio"}}""" :: Nil)
    val anotherPeople = spark.read.json(anotherPeopleRDD)
  }
}
