package com.esoft

/**
  * Created by TAOS on 2017/10/13.
  */
class RationalV2(n: Int, d: Int) {
  require(d != 0)
  val g = gcd(n, d)
  val num: Int = n/g
  val denom: Int = d/g
  override def toString = n + "/" + d

  def +(that: RationalV2): RationalV2 =
     new RationalV2(num * that.denom + that.num * denom, denom * that.denom)

  def gcd(a: Int, b: Int): Int =
      if(b == 0) a else gcd(b, a % b)

}
object TestorV2 {
  def main(args: Array[String]): Unit = {
    println((new RationalV2(3,6) + new RationalV2(1,5)).toString)
  }
}