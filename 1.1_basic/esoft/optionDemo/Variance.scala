package com.esoft.optionDemo

/**
  * Created by taos on 2017/11/6.
  */
object Variance {

  def main(args: Array[String]): Unit = {
    val seq = Seq()
    println(varianceD(seq))
  }
  def varianceD(xs: Seq[Double]): Option[Double] = {
    val m = xs.sum / xs.length
    val result = xs.map{
      line => math.pow(line - m,2)
    }
    Some(result.sum / result.length)
  }


}
