package com.esoft.viewCollection

import scala.collection.SeqView

/**
  * Created by taos on 2017/4/25.
  */
object ViewCollection {

  def main(args: Array[String]) {
    val a = List(1,2,3,4) map { i => i + 1}
    println(a)

    //增加toList方法这时候视图不得不构造一个新集合，因此被推迟的map
    //函数这次执行了
    val lazyList = (List(1,2,3,4).view map{i => i + 1})
    println(lazyList)
    println(lazyList.toList)

    val lazyListV = List(4,5,6).view.force.map(i => i + 1)
    println(lazyListV)
  }
}
