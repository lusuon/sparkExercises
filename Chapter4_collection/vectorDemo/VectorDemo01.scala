package com.esoft.vectorDemo

object VectorDemo01 {

  def main(args: Array[String]): Unit = {
    // 1.创建Vector对象
    val v1 = Vector(1, 2, 3)

    //2. 索引 Vector
    println(v1(0))

    // 遍历
    for( ele <- v1 ){
      print(ele + "")
    }
    //4. 倒转 Vector
    var v2 = Vector(1.1, 2.2, 3.3, 4.4)
    for( ele <- v2.reverse ){
      print(ele + " ")
    }
    println

    // 使用 reverse 之后只是产生了一个新的Vector， 原 Vector 并不会改变
    for( ele <- v2 ){
      print(ele + " ")
    }
    println


    //5. 第一个元素
    println("v2.head = " + v2.head)


    //6. 除首元素之外的所有元素
    println("v2.tail = " + v2.tail)

    //7. 排序
    var v3 = Vector(10, 33, 27, 14, 35, 19, 42, 44)
    for( ele <- v3.sorted ){
      print(ele + " ")
    }
    println
  }
}
