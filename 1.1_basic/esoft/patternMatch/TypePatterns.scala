package com.esoft.patternMatch

/**
 * @author taoshi
 */
object TypePatterns {
  
  def main(args: Array[String]): Unit = {
    println(foo(List("STRING")))
  }
  
  def foo(a: Any): String = a match {
    //non-variable type argument String in type pattern List[String] 
    //(the underlying of List[String]) is unchecked since it is eliminated by erasure
    //只能检查包装，检查不了里面的货物一次 下面这行应当这样写List[_]
    case a: List[Int] => "OK"
    case _ => "fail"
  }
}