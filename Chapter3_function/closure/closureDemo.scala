package Chapter1_basic.func.closure

/**
  * Created by taos
  * 闭包：函数在变量不处于其有效作用域时，还能够对变量进行访问，即为闭包
  */
object closureDemo {
  //
  def getGreetingFunc(msg: String) =
    (name: String) => println(msg + ", " + name)
  //柯里化形式
  //def getGreetingFunc(msg: String)(name: String) = println(msg + ", " + name)

  def main(args: Array[String]) {
    val greetingFuncHello = getGreetingFunc("hello")
    val greetingFuncHi = getGreetingFunc("hi")

    greetingFuncHello("scala")
    greetingFuncHi("java")
    //柯里化函数的调用方式
    //getGreetingFunc("hello")("world")
  }
}
