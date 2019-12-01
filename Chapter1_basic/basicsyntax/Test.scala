package Chapter1_basic.basicsyntax

/**
  * Created by Administrator on 2017/6/2.
  */
object Test {

  def main(args: Array[String]): Unit = {
    test(printHaha)
  }
  def test(f:()=>Unit):Unit ={
    f
  }
  def printHaha(){
    println("haha")
  }

}
