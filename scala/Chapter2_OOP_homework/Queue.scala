/**
  *  5.尝试设计一套特质，灵活的改动整数队列。队列有两种操作：put把整数放入队列，get从尾
  * 部取出它们。队列是先进先出的，get应该依照入队列的顺序取数据。
  *  提示：可以用mutable.ArrayBuffer 模拟队列
  *  在报告中体现出类的线性化特性，要求扩展类实现如下三个功能
  *  1.Doubling 把放到队列中的数字翻倍
  *  2.Incrementing 把放到队列的数据增加1
  *  3.过滤掉队列中的负数
  */
import scala.collection.mutable.ArrayBuffer

trait Doubling extends ArrayBuffer[Int]{
  def doubling()={
    this.map( _ * 2 ) // 原地修改数组，元素乘以2
  }
}

trait Incrementing extends ArrayBuffer[Int]{
  def increase() = {
    this.map( _ + 1 )
  } // 原地修改数组，递增1
}

trait FilterNegative extends ArrayBuffer[Int]{
  def filterNegative() ={
    this.filter( _  >= 0 ) // 原地过滤数组，保留非负数
  }
}

class MyQueue extends Doubling with Incrementing with FilterNegative{
  def put(i:Int) = this+=i // 实现队列入队，直接增加
  def get() = this.remove(0) // 实现出队，移除头部
}

object MyQueue{
  def main(args: Array[String]): Unit = {
    var myQueue = new MyQueue
    myQueue++ArrayBuffer(-5,-4,-3,-3,-2,-1,0,1,2,3,4,5)
    println(s"Queue initialized:$myQueue")
    myQueue.doubling()
    println(s"After doubling:$myQueue")
    myQueue.increase()
    println(s"After increase:$myQueue")
    myQueue.filterNegative()
    println(s"After filtering negative:$myQueue")
    myQueue.put(100)
    println(s"100 added to the queue:$myQueue")
    println(s"${myQueue.get()} removed from queue:$myQueue")
    println(s"${myQueue.get()} removed from queue:$myQueue")
  }

}