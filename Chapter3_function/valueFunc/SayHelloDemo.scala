package Chapter1_basic.func.valueFunc

/**
  * Created by taos on 2017/4/22.
  */
object SayHelloDemo {
  // 这是一个method
  def sayHello(name: String) { println("Hello, " + name) }

  def main(args: Array[String]) {
    // 将method转换为function
    val sayHelloFunc = sayHello _
    sayHelloFunc("leo")
  }
}
