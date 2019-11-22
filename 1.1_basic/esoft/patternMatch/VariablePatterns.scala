package com.esoft.patternMatch

/**
 * @author taoshi
 * 变量模式(variable patterns)
 * 确切的说单纯的变量模式没有匹配判断的过程，只是把传入的对象给起了一个新的变量名。
 */
object VariablePatterns {
   def main(args: Array[String]): Unit= {
      println("输入点啥：")
      var temp = scala.io.StdIn.readLine()
      temp match {
        case whateverName => println(whateverName)
      }
   }
}