

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.distributed.{IndexedRow, IndexedRowMatrix, RowMatrix}
import org.apache.spark.rdd.RDD
object IndexedRowMatix {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("IndexRowMatix").setMaster("local")
    val sc = new SparkContext(conf)

    val rows:RDD[IndexedRow] = sc.parallelize(
      Seq(
        IndexedRow(0, Vectors.dense(1.0, 10.0, 100.0)),
        IndexedRow(1, Vectors.dense(2.0, 20.0, 200.0)),
        IndexedRow(2, Vectors.dense(3.0, 30.0, 300.0))
      )
    )

    val matrix: IndexedRowMatrix = new IndexedRowMatrix(rows)

    // Get its size
    val m = matrix.numRows()
    val n = matrix.numCols()
    println(s"m:$m, n:$n")

    val rowMat: RowMatrix = matrix.toRowMatrix()
    println(rowMat)


  }
}
