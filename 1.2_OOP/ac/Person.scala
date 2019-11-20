package com.esoft.ac

/**
  * Created by Administrator on 2017/4/21.
  */
class Person(private[Person] val name: String){
  def callCompanionObj(): Int ={
    Person.age
  }
}

object Person{
  private val age = 100
  def apply(pname: String) = {
    new Person(pname)
  }
   def callCompanionClass(p:Person) = {
      p.name
  }
}

object Testor{
  def main(args: Array[String]): Unit ={
    val p = Person("hhh")
    println(Person.callCompanionClass(p))
    println(p.callCompanionObj())
  }

}
