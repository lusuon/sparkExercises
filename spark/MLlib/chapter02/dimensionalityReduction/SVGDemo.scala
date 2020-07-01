

import org.apache.spark.mllib.linalg.{Matrix, SingularValueDecomposition, Vector, Vectors}
import org.apache.spark.mllib.linalg.distributed.RowMatrix
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by taos on 2017/6/20.
  */
object SVGDemo {
  def main(args: Array[String]): Unit = {
    val conf =  new SparkConf().setAppName("PCADemo").setMaster("local")
    val sc = new SparkContext(conf)
    val data = Array(
      Vectors.sparse(5, Seq((1, 1.0), (3, 7.0))),
      Vectors.dense(2.0, 0.0, 3.0, 4.0, 5.0),
      Vectors.dense(4.0, 0.0, 0.0, 6.0, 7.0))

    val dataRDD = sc.parallelize(data, 2)

    val mat: RowMatrix = new RowMatrix(dataRDD)

    // Compute the top 5 singular values and corresponding singular vectors.
    val svd: SingularValueDecomposition[RowMatrix, Matrix] = mat.computeSVD(5, computeU = true)
    val U: RowMatrix = svd.U  // The U factor is a RowMatrix.
    U.rows.foreach(println)
    val s: Vector = svd.s  // 奇异值The singular values are stored in a local dense vector.
    println(s)
    val V: Matrix = svd.V  // The V factor is a local dense matrix.
    val it = V.rowIter
    while(it.hasNext) {
      println(it.next())
    }
  }
}
