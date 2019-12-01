package Chapter3_function_homework

/**
4.写一个递归函数，来获取第n个斐波那契数，
前两个斐波那契数0 和 1，第n个数总是等于前 两个数的和——序列开始为0,1,1,2,3,5.
请定义尾递归函数 def fib(n: Int): Int
  */

import scala.annotation.tailrec

object TailFib{
  def fib(n:Int)={ //包装
    @tailrec // 检查尾递归
    def f(n: Int, prev: Int, curr: Int):Int =
      if(n == 1) prev
      else if(n == 2) curr
      else f(n -1, curr, prev + curr) // 前两项相加
    f(n, 0, 1)
  }

  def main(args: Array[String]): Unit = {
    print(fib(99999999)) // 非尾递归必定stack overflow
  }
}