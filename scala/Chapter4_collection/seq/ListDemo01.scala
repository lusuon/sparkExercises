package com.esoft.seq

object ListDemo01 {

  def main(args: Array[String]): Unit = {
    // 创建不可变的List
    val list1 = List(1,2,3)
    // Nil也是个List
    val list2 = Nil
    println(list2)

    // 创建list
    val list3 = List(1 to 10:_*)
    println(list3)
  }
}
