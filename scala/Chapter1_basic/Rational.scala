package com.esoft

/**
  * Created by taos on 2017/10/13.
  */
class Rational(n: Int, d: Int) {
  require(d != 0)
  val num: Int = n
  val denom: Int = d
  override def toString = n + "/" + d
  def add(that: Rational): Rational =
      new Rational(n* that.denom + that.num * d, d * that.denom )
}


object Testor{
  def main(args: Array[String]): Unit = {
     println (new Rational(1,2).add(new Rational(2,3)).toString)
  }
}
