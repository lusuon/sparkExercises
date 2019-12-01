package Chapter1_basic.patternMatch

/**
 * @author taosh
 * 常量模式(constant patterns) 包含常量变量和常量字面量
 */
object ConstantPatterns {
  
  def main(args: Array[String]): Unit = {
    println(foo("ESOFT"))
    println(foo("ESOF1"))
  }
  
  def foo(s: String): String = s match {
    case "ESOFT" => "HBD BigData"
    case _ => "I don't know "
  }
  
}