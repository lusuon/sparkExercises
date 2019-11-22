/**
 4.通过把 scala.math.Ordered[Point] 混入 java.awt.Point 的方式，定义 OrderedPoint 类，
按照词典的编辑方式排序，也就是说，如果x < x ` 或者 x = x ` 或者 y < y` 则(x, y) < (x’y`)
*/

import java.awt.{Point}
import scala.math.Ordered

class OrderedPoint(point: Point) extends Point with Ordered[Point]{
  override def compare(that: Point): Int = {
    if (point.x > that.x || (point.x == that.x && point.y > that.y)) 1
    else if (point.x == that.x && point.y == that.y) 0
    else -1
  }
}

object OrderedPoint{

  def main(args: Array[String]): Unit = {
    val p1 = new Point(0,0)
    val p2 = new Point(100,0)
    val p3 = new Point(0,100)
    val p4 = new Point(100,100)
    var points:Array[OrderedPoint] = Array(new OrderedPoint(p1),new OrderedPoint(p2),new OrderedPoint(p3),new OrderedPoint(p4))
    println(s"Sort points:${points.mkString("")}")
    points = points.sorted
    println(s"Sorted:${points.mkString("")}")
  }
}