package com.esoft.func.GenericFunc

/**
  * Created by Administrator on 2017/6/4.
  */
object GenericFuncDemo {

  def showTime[R](block: => R): R = {
     val begin = System.nanoTime()
     val result = block
     val endTime = System.nanoTime()
     println(s" cost time:${endTime - begin} ns" )
     result
  }

  def main(args: Array[String]) {
     showTime(dd(100))

  }
  private def dd(n: Int) : IndexedSeq[Int]= {
    //累计循环的每一个值放到一个集合里面返回
    for(i <- 0 until n) yield i
  }

}
