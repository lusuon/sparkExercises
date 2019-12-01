import java.awt.Point


import scala.math.Ordered

class OrderPoint(x: Int, y: Int) extends Point(x, y) with Ordered[Point] {
    override def compare(that: Point): Int = {
        if (x <= that.x | y < that.y) {
            1
        } else {
            0
        }
    }
}

object OrderPoint {
    val p1 = new OrderPoint(2, 1)
    val p2 = new OrderPoint(2, 2)

    def main(args: Array[String]): Unit = {
        if (p1.compareTo(p2) > 0) {
            println("p1 < p2")
        } else {
            println("p1 > p2")
        }
    }
}
