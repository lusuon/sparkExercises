package com.esoft.listopt

object ScanDemo01 {

  def main(args: Array[String]): Unit = {
    val i8 = (1 to 5).scanLeft(5)(_-_)
    println(i8)

    // 1 -3 = -2
    // 2 - (-2) = 4
    // 3 - 4 = -1
    // 4 - (-1) = 5
    // 5 - 5 = 0
    val i9 = (1 to 5).scanRight(0)(_-_)
    println(i9)
  }
}
