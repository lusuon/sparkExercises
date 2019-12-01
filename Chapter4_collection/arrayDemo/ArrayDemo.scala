package com.esoft.arrayDemo

object ArrayDemo {

  def main(args: Array[String]): Unit = {
    // 定义一个长度为10的不可变长数组。
    val a = new Array[Int](10)
    // 通过(索引)方式赋值。
    a(0) = 10
    for(i <- a) {
      print(s"$i,")
    }
    println()
    // 给初值时不用new,实际调用的半生类的apply方法。
    val b = Array(1,2,3,4,5)
    println(b.toList)

    // 泛型为Any类型的数组可以存放任意类型数据。
    val c = Array[Any](1,2,3,"Hello")
    println(c.toList)

    // 定义2行3列的多维数组
    val d = Array.ofDim[Int](2,3)
    d(0)(0) = 8
    for(item <- d){
      for(col <- item) print(col + "\t")
      println()
    }
  }
}
