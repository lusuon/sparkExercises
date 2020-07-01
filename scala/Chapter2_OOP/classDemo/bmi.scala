package scala.Chapter1_basic.classDemo

/**
  * Created by thinkpad on 2017/11/3.
  */
class bmi(val kg:Int,val m:Int) {
  val age: Int = 10
  def this(kg1:Int ,m1:Int, age: Int){
    this(kg1,m1)
  }
  def bmi(): Unit ={
    var bmi = this.kg/(this.m/100.0)
    if (bmi < 18.5){
      print("轻");
    }else if (bmi>=18.5 || bmi<=24){
      print("正常");
    }else{
      print("重");
    }
  }
}

object t {
  def main(args: Array[String]): Unit = {
     val b = new bmi(19,20,8)
  }
}
