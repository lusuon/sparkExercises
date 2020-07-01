package scala.Chapter1_basic.QA
import scala.Predef

/**
  * Created by Administrator on 2017/6/2.
  */
object BMICalculator {

  def main(args: Array[String]): Unit = {
//    val aa = Array(1,2,3)
//    var lbs = 150.0
//    val height = 68.0
//    val weightStatus = {
//      val bmi = lbs/(height * height) * 703.07
//      if(bmi < 18.5) "Underweight"
//      else if(bmi < 25) "Normal weight"
//      else "Overweight"
//    }
    //第一个参数是个 bool 值，断言失败只会笼统的抛出java.lang.AssertionError 异常，并不区分是在检验方法参数还是中间运算结果。严谨来说我们会希望参数检查不通过时抛出 java.lang.IllegalArgumentException;
    // 而中间运算结果的断言不过希望抛出 java.lang.AssertionError, 最好是 java.lang.IllegalStateException。
//    val a: Int = 10
    val normal = bmiStatus(75, 1.83)
    assert("Normal weight"== normal,"Expected Normal Weight, Got "+ normal)

    val overweight = bmiStatus(100, 1.60)
    assert("over weight"== overweight,"Expected Over Weight, Got "+ overweight)

    val underWeight = bmiStatus(50, 1.83)
    assert("under Weight"== underWeight,"Expected underWeight, Got "+ underWeight)
  }

  def bmiStatus(weight: Double, Height: Double): String = {
    val bmi = weight/ (Height * Height)
    println(bmi)
    if(bmi < 18.5) "under Weight"
    else if(bmi < 24) "Normal weight"
    else "over weight"
  }

}
