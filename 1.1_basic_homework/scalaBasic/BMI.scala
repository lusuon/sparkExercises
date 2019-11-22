object BMI{
  def bmiStatus(weight:Double , height:Double): Any = {
    val bmi = weight / (height/100) / (height/100)
        if (bmi < 18.5) "Underweight" else if (bmi > 24) "Overweight" else "Normal weight"
  }

  def main(args: Array[String]): Unit = {
    var normal = bmiStatus(75, 183)
    assert("Normal weight" == normal,"Expected Normal Weight, Got "+ normal) // 通过
    normal = bmiStatus(160, 68)
    assert("Normal weight" == normal,"Expected Normal Weight, Got "+ normal) // 抛出异常，提示Overweight
  }
}

