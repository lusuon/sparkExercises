package scala.Chapter1_basic.patternMatch.sequence

/**
  * Created by Administrator on 2017/10/16.
  */
object SequencePatterns {
  def main(args: Array[String]): Unit = {
    val x = List(0,1,2)
    x match {
      case List(0, _, _) => println("a three-element list with 0 as the first element")
      case List(0, _*) => println("a list beginning with 1, having any number of elements")
     // case Vector(1, _*) => "a vector starting with 1, having any number of elements"
    }

  }

}
