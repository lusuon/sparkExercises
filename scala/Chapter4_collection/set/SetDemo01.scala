package com.esoft.set

import scala.collection.mutable

object SetDemo01 {

  def main(args: Array[String]): Unit = {
    // 不可变
    val set01 = Set(1,2,3,4,5,6,6,8,1,1,1,1)
    println(set01)

    // 可变
    val set02 = mutable.Set(1,2,"Hello")
    println(set02)

    // 添加元素
    //set01.add(4) // 不可变，报错。
    set02.add(3)
    set02 += 4
    set02.+= (5)

    // 删除元素
    set02 -= 2
    println(set02 - 3)
    set02.remove("Hello")
    println(set02)

    // 遍历set
    for(x <- set02) println(x)

    // 判断set是否包含某元素
    println(set02(5))

    // 合并set集合
    val set03 = Set(1,2,3,4)
    val set04 = Set(4,5,6,7)
    println(set03 ++ set04)
    println(set03 -- set04)

    // 求交集、并集合差集
    println(set03 & set04)// 或者"intersect"
    println(set03 | set04)// 或者"union"
    println(set03 &~ set04)// 或者"diff"
  }

}
