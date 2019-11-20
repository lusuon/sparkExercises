package com.esoft.classDemo

/**
  * Created by Administrator on 2017/10/17.
  */
class CheckSumAccumulator {

  private var sum = 0
  def add(b: Byte) { sum += b}
  def checksum(): Int = ~(sum & 0XFF) + 1

}

object T1 {
  def main(args: Array[String]): Unit = {
    val sum = 1
    println(sum & 0xFF)
  }
}
