package scala.Chapter1_basic.basicsyntax

import scala.io.StdIn._
/**
  * Created by taos on 2017/4/19.
  */
object BasicType {

  def main(args: Array[String]): Unit = {
    val n = 2
    val random = n to 3
    //从控制台接收Int 型参数 利用implicit 使得函数特别简单优雅
    var num = readInt
    println(num)
  }

}
