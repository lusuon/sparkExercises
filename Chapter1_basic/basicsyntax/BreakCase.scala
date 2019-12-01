package Chapter1_basic.basicsyntax
import scala.collection.mutable
import scala.util.control.Breaks._
/**
  * Created by taos on 2017/4/12.
  */
class BreakCase {

  def canBreak(n: Int): Unit = {
    breakable {
      while(true){
        break()
      }

      for(i <- 0 to 100){
        if(i == n) break()
        println(i)
      }
      println(".....")
    }
  }

}
object BreakCase {
  def main(args: Array[String]): Unit = {
    val t = new BreakCase
    t.canBreak(50)

    var  temp =  scala.io.StdIn.readInt()  //输入循环的次数

    while(temp > 0) {
      println(temp)
      temp -= 1
    }

    val map = mutable.HashMap[Int,Int]()
  }

}