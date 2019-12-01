package Chapter1_basic.func.implicitDemo

/**
  * 隐式转换函数与函数名无关，只与函数签名(函数参数类型，函数的返回值类型)有关
  * 隐式转换函数可以有多个(隐式转换列表)，但是需要保证当前环境下只有一个隐式函数被识别。
  */
object ImplicitDemo01 {

  def main(args: Array[String]): Unit = {
    // 编写一个隐式函数转成Double->Int转换
    implicit def f1(d:Double) :Int = {d.toInt}
    //implicit def f2(d:Double) :Int = {d.toInt}
    implicit def f3(d:Float) :Int = {d.toInt}
    val num:Int = 3.5 //底层编译 f1$1(3.5)
    val num1:Int = 3.5f
    println(num)

  }
}
