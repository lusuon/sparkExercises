package com.esoft.func.recursion

/**
  * Created by taos on 2017/11/10.
  */
object Fab {
  def main(args: Array[String]): Unit = {
    println(fib(1))
  }
def fib(n: Int): Int = {
  @scala.annotation.tailrec
  def loop(n: Int, prev: Int, curr: Int):Int =
      if(n == 1) prev
      else if(n == 2) curr
      else loop(n -1, curr, prev + curr)
  loop(n, 0, 1)
}

}
