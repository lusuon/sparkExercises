package scala.Chapter3_function_homework

/**
  * 1.将给定的程序改为高阶函数的形式
  */

object MyModule{
  def abs(n:Int):Int = {
    if(n<0) -n
    else n
  }
  private def formatAbs(x:Int) = {
    val msg = "The absolute value of $d is %d"
    msg.format(x,abs(x))
  }

  def highLevelFunc(func:(Int) => Int, funcName:String,input:Int) = {
    s"The $funcName of $input is:${func(input)}" // 输入待使用函数及名称，给出结果
  }

  def main(args: Array[String]): Unit = {
    println(formatAbs(-42))
    println(highLevelFunc(abs,"abs",-42))
  }
}