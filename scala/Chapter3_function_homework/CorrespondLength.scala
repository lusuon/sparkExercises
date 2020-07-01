package scala.Chapter3_function_homework

/**
  * 2..用correspond方法判断:
  *     某字符串数组内所有元素的长度是否和某个给定的整数数组一致  */

object correspondLength{
  def main(args: Array[String]) {
    val stringArr = Array("a", "ab","abc","abcd","abcde")
    val lenArr = Array(1,2,3,4,6)
    //比较两个序列是否在某个对比条件下相同
    println(s"String Array:             ${stringArr.mkString(" ")}")
    println(s"Their length are:         ${stringArr.map(_.length).mkString(" ")}")
    println(s"The int array to compare: ${lenArr.mkString(" ")}")
    // map生成字符串数组长度，以供correspond
    println(s"${stringArr.map(_.length).corresponds(lenArr)(_.equals(_))}")
  }
}
