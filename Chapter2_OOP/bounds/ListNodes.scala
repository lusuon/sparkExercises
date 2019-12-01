package Chapter1_basic.bounds
import scala.util.control.Breaks._
/**
  * Created by taos on 2017/11/8.
  */
object ListNodes {
  def main(args: Array[String]): Unit = {
   breakable {
      var n = 10
      while(n > 5) {
        if(n == 7) break;
        println(n)
        n -= 1
      }
   }

    breakable {
      var n = 10
      while(n > 5) {
        if(n == 7) break;
        println(n)
        n -= 1
      }
    }
     println(".......")
//      for(c <- "Hello World") {
//        if(n == 5) break;
//        print(c)
//        n -= 1

    }
//  }
}
case class ListNode[+T](h: T, t: ListNode[T]) {
  def head: T = h
  def tail: ListNode[T] = t
  //
//  def prepend(elem: T): ListNode[T] =
//    ListNode(elem, this)
}
