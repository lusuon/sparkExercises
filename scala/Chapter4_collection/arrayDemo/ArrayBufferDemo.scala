package com.esoft.arrayDemo

import scala.collection.mutable.ArrayBuffer
/**
 * @author taoshi
 */
object ArrayBufferDemo {
  
  def main(args: Array[String]): Unit = {
    val a = new ArrayBuffer[Int]()

    val b = ArrayBuffer[Int]()

    val arrayB = ArrayBuffer(1,3,4,5,-1,2)

    //在末尾添加元素
    arrayB += 2;
    //同时在尾端添加多个元素
    arrayB += (2,3,4,32)
    //可以用 ++=操作符追加任何集合
    arrayB ++= Array(2,43,88,66)
    //移除最后二加一个元素
    val arrayC = ArrayBuffer[Int](1,3,4,5,-1,2)
    println(arrayC.mkString)
    //排个顺序
    val arrayE = arrayC.sortWith(_<_)
    printlnValue(arrayE)
    //将指定下标的元素从 arrayBuffer 中删除，并返回该元素
    //val temp = arrayC.remove(3)
    val tempT = arrayC.remove(2, 4)
    printlnValue(arrayC)
    //从第几个开始remove remove 几个
    //arrayC.remove(2, 4)
   // printlnValue(arrayD)
  }
  
  def printlnValue[A](collect: ArrayBuffer[A]) = {
    for(i <- collect){
      println(i)
    }
  }
  
}