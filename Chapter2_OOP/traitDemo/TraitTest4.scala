package Chapter1_basic.traitDemo

import scala.collection.mutable.ArrayBuffer
// 作业
abstract class Queue2 {
  println("查看调用顺序Queue")
  def get:Int
  def put(num:Int)
}
trait Doubling extends Queue2 {
  println("查看调用顺序Doubling")
  abstract override def put(x: Int) { super.put(2*x) }
}
trait Incrementing extends Queue2 {
  println("查看调用顺序Incrementing")
  abstract override def put(x: Int) { super.put(x+1) }
}
trait Filtering extends Queue2 {
  println("查看调用顺序Filtering")
  abstract override def put(x: Int){
    if(x >= 0) super.put(x)
  }
}
class NewQueue extends Queue2{
  println("查看调用顺序NewQueue")
  private val numArrayBuffer = new ArrayBuffer[Int]
  def get() = numArrayBuffer.remove(0)
  def put(x: Int) = {
    numArrayBuffer += x
  }
}

object TraitTest4 extends App {
//  val queue = new NewQueue with Doubling
//  queue.put(1)
//  println(queue.get())

  val queue2 = new NewQueue with Doubling with Incrementing
  queue2.put(10)
  println(queue2.get())
}
