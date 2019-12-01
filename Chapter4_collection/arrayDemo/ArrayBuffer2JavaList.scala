package com.esoft.arrayDemo

import scala.collection.mutable._

object ArrayBuffer2JavaList {

  def main(args: Array[String]): Unit = {
    val arr = ArrayBuffer("1", "2", "3")
    /*
    implicit def bufferAsJavaList[A](b: mutable.Buffer[A]): ju.List[A] = b match {
    case JListWrapper(wrapped) => wrapped
    case _ => new MutableBufferWrapper(b)
     */
    // scala的ArrayBuffer转java的List
    import scala.collection.JavaConversions.bufferAsJavaList
    val javaArr = new ProcessBuilder(arr)
    val arrList = javaArr.command()
    println(arrList)

    import scala.collection.JavaConversions.asScalaBuffer
    // java的list转scala数组
    val scalaArr:Buffer[String] = arrList
    scalaArr.append("Hello")
    println(scalaArr)

  }
}
