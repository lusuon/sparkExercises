

import org.apache.spark.mllib.feature.PCA
import org.apache.spark.mllib.linalg.{Matrix, Vectors}
import org.apache.spark.mllib.linalg.distributed.RowMatrix
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object PCADemo {
  def main(args: Array[String]): Unit = {
    val conf =  new SparkConf().setAppName("PCADemo").setMaster("local")
    val sc = new SparkContext(conf)
    val data = Array(
      Vectors.sparse(5, Seq((1, 1.0), (3, 7.0))),
      Vectors.dense(2.0, 0.0, 3.0, 4.0, 5.0),
      Vectors.dense(4.0, 0.0, 0.0, 6.0, 7.0))

    val dataRDD = sc.parallelize(data, 2)

    val mat: RowMatrix = new RowMatrix(dataRDD)

    // Compute the top 4 principal components.
    // Principal components are stored in a local dense matrix.
    val pc: Matrix = mat.computePrincipalComponents(4)

    // Project the rows to the linear space spanned by the top 4 principal components.
    val projected: RowMatrix = mat.multiply(pc)

    val dataLabelPoint: RDD[LabeledPoint] = sc.parallelize(Seq(
      new LabeledPoint(0, Vectors.dense(1, 0, 0, 0, 1)),
      new LabeledPoint(1, Vectors.dense(1, 1, 0, 1, 0)),
      new LabeledPoint(1, Vectors.dense(1, 1, 0, 0, 0)),
      new LabeledPoint(0, Vectors.dense(1, 0, 0, 0, 0)),
      new LabeledPoint(1, Vectors.dense(1, 1, 0, 0, 0))))

    // Compute the top 5 principal components.
    val pca = new PCA(3).fit(dataLabelPoint.map(_.features))
    println(pca.pc)
    // Project vectors to the linear space spanned by the top 5 principal
    // components, keeping the label
    val projectedLast = dataLabelPoint.map(p => p.copy(features = pca.transform(p.features)))
    projectedLast.collect().foreach(println(_))
  }

}
