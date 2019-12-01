package Chapter3_function_homework

/**
  * 5.定义一个操作符+%，将一个给定的百分比添加到某个值。举例来说120 +% 10 = 132
  * 由于操作符是方法而不是函数,需要提供一个implicit。
  */

object OperatorDefine{
  // 使用隐式类重载运算符
  implicit class PlusPercentage(private val toAdd: Double){
    def +% (percentage:Double): Double = toAdd * (100+percentage) / 100
  }

  def main(args: Array[String]): Unit = {
    val toAdd = 120
    val percentage = 10
    println(s"$toAdd +% $percentage = ${toAdd +% percentage}")
  }
}