package scala.Chapter1_basic.func.sam
/**
  * Created by taos
  */

object RunnableContext {
  implicit def makeRunnable(f: () => Unit): Runnable = new Runnable {
    override def run(): Unit = f()
  }
}
object ThreadDemo {
  //scala 可以在任意位置引用包
  import RunnableContext._
  def main(args: Array[String]) {
    //这样可以和java 互相调用啊
    val f = () => println("f...")
    val f1:()=>Unit = {()=>println("f1...")}
    val f2 = new Function0[Unit] {
      override def apply(): Unit = {
        println("f2...")
      }
    }

    val t = new Thread(f2)
    t.run()
  }
}


