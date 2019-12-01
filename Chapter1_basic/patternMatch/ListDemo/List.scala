package ListDemo

/**
  * Created by taos on 2017/11/1.
  */
sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]
object List{
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }
  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }
  def apply[A](as: A*): List[A] =
     if(as.isEmpty) Nil
     else Cons(as.head, apply(as.tail:_ *))
  def tail[A](list: List[A]):List[A] = list match {
    case Nil => Nil
    case Cons(_, xs) => xs
  }
  //删除元素中前N 个元素，时间开销只需与drop元素个数成正比
  def drop[A](l: List[A], n: Int): List[A] = {
    if(n <= 0) l
    else l match {
      case Nil => Nil
      case Cons(_, xs) => drop(xs, n -1)
    }
  }

//  def dropWhile[A](l: List[A], f:  A=> Boolean): List[A] = {
//
//  }

}
object Testor {
  def main(args: Array[String]): Unit = {
    println(List.sum(List(100,200)))
    println(List.product(List(10,20)))
    println(List.apply(1,2,3))
  }
}