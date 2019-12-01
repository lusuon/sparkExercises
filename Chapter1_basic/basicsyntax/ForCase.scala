package Chapter1_basic.basicsyntax

/**
  * Created by taos on 2017/4/12.
  */
class ForCase {

  def simpleFor(a: Int*): Unit ={
    for(i <- a) println(i)
  }

  def simpleForBoundary(endBoundary: Int): Unit = {
      for(i <- 0 to endBoundary) {
        print(i)
      }
    print("\n")
      for(i <- 0 until endBoundary) {
        print(i)
      }
  }

  def doubleFor(): Unit ={
    // 嵌套循环
    for(i <- 1 to 3; j <- 1 to 3 if i != j){ //if(i != j) 够简略
      println(s"i is $i" + s" j is $j")
    }
  }

}

//object ForCase1 {
//  def simpleFor(a: Int*): Unit ={
//    for(i <- a) println(i)
//  }
//  def main(args: Array[String]) {
//    ForCase1.simpleFor(1,2,3,4,5,6)
//  }
//}

object ForTestor{
  def main(args: Array[String]): Unit = {
    val caseSample = new ForCase
    caseSample.simpleFor(1,2,3,4,5,6,7)

    caseSample.doubleFor()
  }

}
