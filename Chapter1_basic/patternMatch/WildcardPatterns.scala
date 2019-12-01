package Chapter1_basic.patternMatch

/**
 * @author taoshi
 * 通配符用下划线表示："_" ，可以理解成一个特殊的变量或占位符。
        单纯的通配符模式通常在模式匹配的最后一行出现，case _ => 它可以匹配任何对象，用于处理所有其它匹配不成功的情况。
        通配符模式也常和其他模式组合使用：
 */
object WildcardPatterns {
  
  def main(args: Array[String]): Unit={
     println(wildcardMatch(Array(1,2,3)))
     println(wildcardMatch(Array(1,2,4)))
  }
  
  def wildcardMatch(array: Array[Int]): String = array match{
    case Array(_,_,3) => "succ"
    case _ => "fail"
  }
  
}