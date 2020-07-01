

/**
  * 1.local vector是spark提供的向量类型，不同于scala的Vector，由整数类型的索引和double类型的数值组成。
  * 2.Vector分为两种类型：密集和稀疏Vector.
  *
  */

import org.apache.spark.mllib.linalg.{Vector, Vectors}
object LocalVector {

  def main(args: Array[String]): Unit = {
    // Create a dense vector (1.0, 0.0, 3.0).
    val dv: Vector = Vectors.dense(1.0, 0.0, 3.0)

    // Create a sparse vector (1.0, 0.0, 3.0) by specifying its indices
    // and values corresponding to nonzero entries.
    val sv1: Vector = Vectors.sparse(3, Array(0, 2), Array(1.0, 3.0))

    // Create a sparse vector (1.0, 0.0, 3.0) by specifying its nonzero entries.
    val sv2: Vector = Vectors.sparse(3, Seq((0, 1.0), (2, 3.0)))

    // Creates a vector of all zeros.
    val sv3: Vector = Vectors.zeros(3)

    sv2.foreachActive((x:Int, y:Double)=>println(s"$x \t $y"))

    sv2.toArray

    sv2.toDense


  }
}
