package Chapter1_basic.patternMatch.extractor

/**
  * Created by taos on 2017/4/21.
  */
object Square {
  //unapply方法通常被称为提取方法，这里提取的是一个容器，里面有z的开方
  //Option 是一种容器，有两个子类Some 和 None 要么有值，要么啥都没有
  def unapply(z: Double): Option[Double] = Some(math.sqrt(z))
}

object SquareTestor{
  def main(args: Array[String]) {
    val number = 36.0
//    println(Square.unapply(number))
//    这样我们无需显式调用unapply方法，而把是它用在pattern match中，让编译器替我们调用它。
    number match {
        //通过StringContext 方法拼接字符串
      case Square(n) => println(s"square root of $number is $n")
      case _=>  println("nothing matched")
    }
  }

}
