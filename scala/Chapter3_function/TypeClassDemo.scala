package scala.Chapter1_basic.func

/**
  * Created by taos on 2017/11/14.
  */

class Boy(val name: String, val age: Int) extends Comparable[Boy] {
  override def compareTo(o: Boy): Int = {
    if(this.age > o.age) 1
    else -1
  }

  override def toString = s"Boy($name, $age)"
}
object TypeClassDemo {
  def main(args: Array[String]): Unit = {
    val array = Array[Boy](new Boy("li",2), new Boy("wang",3))
    val sort = array.sorted
    println(sort.toBuffer)
  }
}
