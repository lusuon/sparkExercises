/**
 4.通过把 scala.math.Ordered[Point] 混入 java.awt.Point 的方式，定义 OrderedPoint 类，
按照词典的编辑方式排序，也就是说，如果x < x ` 或者 x = x ` 或者 y < y` 则(x, y) < (x’y`)
*/

import java.awt.{Point}
import scala.math.Ordered

class OrderedPoint(x:Int,y:Int) extends Point(x,y) with Ordered[Point]{
  override def toString: String = s"(${x},${y})"
  override def compare(that: Point): Int = {
    if (x > that.x || (x == that.x && y > that.y)) 1
    else if (x == that.x && y == that.y) 0
    else -1
  }
}

object OrderedPoint{
  def apply(x: Int, y: Int): OrderedPoint = new OrderedPoint(x, y)
  def main(args: Array[String]): Unit = {
    val p1 = OrderedPoint(100,0)
    val p2 = OrderedPoint(100,100)
    val p3 = OrderedPoint(0,0)
    val p4 = OrderedPoint(0,100)
    val points:Array[OrderedPoint] = Array(p1,p2,p3,p4)
    println(s"Points to sort:${points.mkString("")}")
    println(s"Sorted:${points.sorted.mkString("")}")
  }
}