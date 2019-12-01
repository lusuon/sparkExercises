package Chapter1_basic.basicsyntax.condition

/**
  * Created by Administrator on 2017/6/2.
  */
object BMIDemo {

  def main(args: Array[String]) {
    val lbs = 150.0
    val height = 1.83
    val weightStatus = {
      val bmi = lbs/(height * height)
      val result = if(bmi < 18.5) "Underweight"
      else if(bmi < 25) "Normal weight"
      else "Overweight"
      print(result);
    }
  }

}
