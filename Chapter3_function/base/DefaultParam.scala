package Chapter1_basic.func.base

/**
  * 默认参数
  * 带名参数
  */
object DefaultParam {

  def decord(str : String, left: String = "[", right: String = "]"): Unit = {
    println(left + str + right)
  }

  def main(args: Array[String]): Unit = {
    decord("hello")
    decord("Hello", "<<<")
    decord(str="hello", left="<", right = ">")
  }

}
