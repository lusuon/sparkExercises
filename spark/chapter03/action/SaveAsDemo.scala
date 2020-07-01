

import org.apache.spark.sql.SparkSession

object SaveAsDemo {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("SaveAsDemo").master("local").getOrCreate()
    val sc = spark.sparkContext

    val a = sc.parallelize(1 to 10000, 3)
    a.saveAsTextFile("D:\\output\\mydata_a")
    import org.apache.hadoop.io.compress.GzipCodec
    a.saveAsTextFile("D:\\output\\mydata_b", classOf[GzipCodec])

    val x = sc.parallelize(1 to 100, 3)
    x.saveAsObjectFile("D:\\output\\objFile")
    val y = sc.objectFile[Int]("objFile")
    y.collect

    val v = sc.parallelize(Array(("owl",3), ("gnu",4), ("dog",1), ("cat",2), ("ant",5)), 2)
    v.saveAsSequenceFile("D:\\output\\hd_seq_file")

    // saveAsHadoopFile saveAsHadoopDataset saveAsNewAPIHadoopFile
  }
}
