package com.esoft.listopt

object FoldDemo01 {

  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4,5)
    val a = list.fold(10)(_*_)
    println(a)

    // 10 - 1 = 9
    // 9 - 2 = 7
    // 7 - 3 = 4
    // 4 - 4 = 0
    // 0 - 5 = -5
    val b = list.foldLeft(10)(_-_)
    println(b)

    // 5 - 10 = -5
    // 4 - (-5) = 9
    // 3 - 9 = -6
    // 2 - (-6) = 8
    // 1 - 8 = -7
    val c = list.foldRight(10)(_-_)
    println(c)
  }
}
