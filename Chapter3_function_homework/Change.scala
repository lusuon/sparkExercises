package Chapter3_function_homework

/**
  * 假设某国的货币有若干面值，现给一张大面值的货币要兑换成零钱，问有多少种兑换方式。 用尾递归实现。
  * */

import scala.annotation.tailrec

object Change{
  val canChange = Array(1,5,10,20,50,100)
  var count = 0
  def change(rest:Int,toChange: List): Unit ={
    if (rest < 0) return
    else if (rest == 0) count += 1
    else
  }
  /*
  def change(money: Int, coins: List[Int] = List(1,5,10,20,50,100)): Int = {
    if (money == 0) 1 // 恰好凑出
    else if (coins.size == 0 || money < 0) 0 // 凑过头了，失败
    else change(money, coins.tail) + change(money - coins.head, coins)
    //由于加法的存在，需要等待前者的调用结束，不是真正的尾递归，无法通过@tailrec
  }
   */
  // 344
  def main(args: Array[String]): Unit = {
    println(change(6)) //1+5 ,6*1
    println(change(11)) // 1+10,1+5*2,1*6+5,1*11
  }

}