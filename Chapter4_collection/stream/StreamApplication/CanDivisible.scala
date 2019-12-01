package com.esoft.stream.StreamApplication

import scala.collection.mutable.ListBuffer
import scala.util.Random

/**
  * Created by taos
  * 需要在50个随机数中找到前两个可以被3整除的数字
  */
object CanDivisible {
  // 显然可以实现这个功能，但是方法被执行了50次
  def canDivisibleBy(n: Int) = {
    val isDivisible = n % 3 == 0
    //println(s"$n $isDivisible")
    isDivisible
  }
  //创建一个可变的List，开始遍历随机数，找到能被3整除的就把它塞进可变List里面去，找够了两个就返回。
  //可以看到，运算量确实变少了，找够了两个就直接收工了。
  //但是这实在很糟糕，显式使用了return同时还引入了可变量。
  def first2UsingMutable(randomList :List[Int]): List[Int] = {
    val result = ListBuffer[Int]()
    randomList.foreach(n => {
      if (n % 3 == 0) result.append(n)
      if (result.size == 2) return result.toList
    })
    result.toList
  }


  def main(args: Array[String]) {
    def randomList: List[Int] = (1 to 50).map(_ => Random.nextInt(100)).toList
    //从符合条件的集合里面拿俩
    val result01 = randomList.filter(canDivisibleBy).take(2) //①
    result01 foreach println

    val result02: List[Int] = first2UsingMutable(randomList)
    result02 foreach println

    val result03 = randomList.toStream.filter(canDivisibleBy).take(2).toList
    result03 foreach println

  }

}
