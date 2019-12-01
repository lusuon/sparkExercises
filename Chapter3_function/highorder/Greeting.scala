package Chapter1_basic.func.highorder

/**
  * Created by taos
  * 高阶函数允许将函数作为参数传递给另外一个函数
  * 函数也可以作为返回值
  */
object Greeting {
  def greet(func:(String) => Unit, name: String) = func(name)
  //getGreetFunc 的反回值是一个(name: String) => Unit 的函数
  def getGreetFunc(msg: String) = (name: String) => println(name)

  def main(args: Array[String]) {
    val sayHelloFunc = (name: String) => println("Hello" + name)
    greet(sayHelloFunc, " high order function")
    getGreetFunc(msg = "hello")("name")

  }
}
