package scala.Chapter1_basic.func.anonymous

/**
  * Created by Administrator on 2017/6/3.
  */
object AnonymousFunc {
  //tripler 等同于下面的函数定义，
  // 第一种方式通过匿名函数的方式定义函数
  val tripler = (x: Double) => 3.0*x
//show 没有参数列表，则调用时一定不能写括号
  //def show:Unit = println(".........")
  def triple(x: Double):Double = {
    3*x
  }
  val format = (x: Double) => println(f"$x%1.5f")
  def main(args: Array[String]) {
    val result: Array[Double] = Array(1.1,3.1,5).map(tripler)
    result.foreach(format)
    //show()
  }

}
