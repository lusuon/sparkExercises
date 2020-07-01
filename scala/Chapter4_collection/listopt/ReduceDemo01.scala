package com.esoft.listopt

object ReduceDemo01 {

  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4,5)

    // 1 + 2 = 3
    // 3 + 3 = 6
    // 6 + 4 = 10
    // 10 + 5 = 15
    val a = list.reduceLeft(_ + _)
    println(a)
    // 4 + 5 = 9
    // 3 + 9 = 12
    // 2 + 12 = 14
    // 1 + 14 = 15
    val b = list.reduceRight(_ + _)
    println(b)

    // val list = List(1,2,3,4,5)
    // 1 -2 = -1
    // -1 - 3 = -4
    // -4 - 4 = -8
    // -8 - 5 = -13
    val c = list.reduceLeft(_ - _)
    println(c)

    // val list = List(1,2,3,4,5)

    // 4 - 5 = -1
    // 3 - (-1) = 4
    // 2 - 4 = -2
    // 1- (-2)= 3
    val d = list.reduceRight(_ - _)
    println(d)

    val e = list.par.reduceLeft(_ - _)
    println(e)
  }

}
