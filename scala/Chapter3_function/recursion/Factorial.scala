package scala.Chapter1_basic.func.recursion

/**
  * Created by taos on 2017/4/18.
  */
object Factorial {
  //非尾递归
  //@scala.annotation.tailrec
  def f(n: BigInt): BigInt = {
    if(n <= 1) 1
    else n* f(n-1)
  }
//  factorial(5)
//  5 * factorial(4)
//  5 * (4 * factorial(3))
//  5 * (4 * (3 * factorial(2)))
//  5 * (4 * (3 * (2 * factorial(1))))
//  5 * (4 * (3 * (2 * 1)))
//  120
  //改造为尾递归形式如下
  @scala.annotation.tailrec
  def factorialTailrec(n: BigInt, acc: BigInt): BigInt = {
    if(n <= 1) acc
    else factorialTailrec(n -1, acc* n)
  }

  //局部函数，使得函数包装的更为精美
  def factorial(n: Int): Int = {
    @scala.annotation.tailrec
    def go(n: Int, acc: Int) :Int ={
      if(n == 1) acc
      else go(n -1, n * acc)
    }
    go(n, 1)
  }

  def main(args: Array[String]): Unit = {
//    factorialTailrec(5, 1)  // 开始
//
//    factorialTailrec(4, 5)  // 1 * 5 = 5
//
//    factorialTailrec(3, 20) // 5 * 4 = 20
//
//    factorialTailrec(2, 60) // 20 * 3 = 60

    println(factorialTailrec(5, 1)) // 60 * 2 = 120

    println(factorial(5))

  }

}
