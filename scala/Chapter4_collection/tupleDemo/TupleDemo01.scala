package com.esoft.tupleDemo

object TupleDemo01 {

  def main(args: Array[String]): Unit = {
    //创建元组:Tuple5
    val t1 = (1,2,3,"Hello",4)
    println(t1)

    // 访问元组中的元素(索引从1开始)
    println(t1._4)
    // 访问元组中的元素(索引从0开始)
    println(t1.productElement(4))
    // 遍历元组中的元素
    for(item <- t1.productIterator) {
      print(s"item=$item \t")
    }
  }
}
