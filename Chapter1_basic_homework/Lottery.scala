package Chapter1_basic_homework

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn._
import scala.util.Random

object Lottery {
  def main(args: Array[String]): Unit = {
    var order = new ArrayBuffer[Int]()
    val validRange = 1 to 35
    while (order.length != 7){
      println(s"输入值为1-35的彩票号，已填入${order.length}个数字，还有${7-order.length}个")
      val l = readLine()
      if(l.forall(i => Character.isDigit(i))){
        val num = Integer.valueOf(l)
        if (validRange.contains(num) & !order.contains(num)) order.addOne(num)
        else println(s"请输入有效不重复的整数，在1-35间")
      }
      else println(s"请输入数字")
    }
    // 用随机种子方便测试，生成：24, 4, 30, 29, 18, 3, 17
    val r = new Random(1)
    val res : Seq[Int] = r.shuffle(validRange).take(7)
    println(s"开奖结果： ${res.mkString(" ")} ，你中了：${order.intersect(res).mkString(" ")}")
  }
}
