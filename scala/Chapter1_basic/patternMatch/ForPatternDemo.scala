package scala.Chapter1_basic.patternMatch

/**
  * Created by taos
  * 产生出来的不能匹配模式的值将被丢弃
  */
object ForPatternDemo {
  def main(args: Array[String]): Unit = {
    val list = List(Some("apple"), None, Some("orange"))
    matchIt(list)
  }

  def matchIt(list: List[Option[String]]):Unit = {
    for(Some(fruit) <- list) println(fruit)
  }
}
