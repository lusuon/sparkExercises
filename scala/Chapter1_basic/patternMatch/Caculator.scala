package scala.Chapter1_basic.patternMatch

/**
  * Created by taos on 2017/10/16.
  */
object Caculator {
  def mean(xs: Seq[Double]): Double =
      if(xs.isEmpty)
         throw  new ArithmeticException("mean of empty list!")
      else xs.sum / xs.length

  def main(args: Array[String]): Unit = {
    val xs = Seq()
    mean(xs)
    println("end ~")
  }
}
