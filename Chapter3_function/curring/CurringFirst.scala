package Chapter1_basic.func.curring

/**
  * Created by taos
  */
object CurringFirst {
  def mulOneAtTime(x: Int) = (y: Int) => x * y

  def curry[A,B,C](f:(A,B) => C): A => (B => C) = a => b => f(a, b)

  def curry2:(Int, Int)=>Int = (x:Int, y:Int) => (x * y)

  def curry3:(Int)=>((Int)=>Int) = (x:Int) =>(y:Int) => x*y

  def main(args: Array[String]) {
    println(mulOneAtTime(2)(3))
    println(curry((x:Int, y:Int)=> x*y)(2)(3))
    println(curry2(3,4))
    println(curry3(3)(4))
  }
}
