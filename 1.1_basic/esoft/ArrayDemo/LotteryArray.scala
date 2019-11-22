package com.esoft.ArrayDemo

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

/**
  * Created by taos on 2017/4/22.
  */
object LotteryArray {
  def main(args: Array[String]) {
    val lottery = new Array[Int](7)
    for(i <- 0 to 6){
      val buyNum =StdIn.readInt
      lottery(i) = buyNum
    }
    lottery foreach println
  val lottery1 = new ArrayBuffer[Int]()
    for(i <- 0 to 6){
      val buyNum = StdIn.readInt()
      lottery1 += buyNum
    }
    lottery1 foreach println
  }
}
