

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.linalg.distributed.{CoordinateMatrix, IndexedRow, MatrixEntry}
import org.apache.spark.rdd.RDD

/**
  * 坐标矩阵CoordinateMatrix是一个基于矩阵项构成的RDD的分布式矩阵。
  * 每一个矩阵项MatrixEntry都是一个三元组：(i: Long, j: Long, value: Double)，
  * 其中i是行索引，j是列索引，value是该位置的值。
  * 坐标矩阵一般在矩阵的两个维度都很大，且矩阵非常稀疏的时候使用。
  */
object CoordinateMatix {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("CoordinateMatrix").setMaster("local")
    val sc = new SparkContext(conf)
    /**
      *  CoordinateMatrix实例可通过RDD[MatrixEntry]实例来创建，
      *  其中每一个矩阵项都是一个(rowIndex, colIndex, elem)的三元组
      *  1 2
      *  3 5
      */
    val entries: RDD[MatrixEntry] = sc.parallelize(
      Seq(
        MatrixEntry(0, 0, 1),
        MatrixEntry(0, 1, 2),
        MatrixEntry(1, 0, 3),
        MatrixEntry(1, 1, 5))
    )
    // Create a CoordinateMatrix from an RDD[MatrixEntry].
    val mat: CoordinateMatrix = new CoordinateMatrix(entries)

    // Get its size.
    val m = mat.numRows()
    val n = mat.numCols()
    println(m)
    println(n)
    // Convert it to an IndexRowMatrix whose rows are sparse vectors.
    val indexedRowMatrix = mat.toIndexedRowMatrix()
  }
}
