package scala.Chapter1_basic.bounds

import scala.runtime.RichInt

/**
  * Created by taos on 2017/4/13.
  */
object UpperBounds {

  def main(args: Array[String]): Unit = {
//    val p = new Pair1("1","2")
//    println(p.showSmaller)

    //此处使用Int 类型构建pair 对象不可以，原因是Int类型没有直接实现Comparable 接口
//    val p1 = new Pair1(1,2)
//    println(p.showSmaller)
  }

}
//定义上界Upper bounds
class Pair1[T <: Comparable[T]] (val first: T, val second: T) {

  def showSmaller = if(first.compareTo(second) < 0) first else second
}
