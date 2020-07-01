package scala.Chapter1_basic.patternMatch.extractor

/**
  * Created by Administrator on 2017/10/16.
  */
object ExtractorDemo {

  case class Student(name: String, age: Int)
  def main(args: Array[String]): Unit = {
      val sss = Array(0,1,3)
      extractorMatch(sss)
      extractorMM(Student("李磊",2))
    val list = List(1,2,3)
    list match {
      case Append(x,y) => println(x.toString() + y)
    }
  }
  def extractorMatch(array: Array[Int]) = array match {
    case Array(0, tail) => print(tail)
    case _ => println("............")
  }

  def extractorMM(it: Student) = it match {
    case Student("李磊",age) => println(age)
    case  _ => println("none")
  }


}

object Append {
  def unapply[A](l: List[A]) = {
    Some(l.init, l.last)
  }
}
