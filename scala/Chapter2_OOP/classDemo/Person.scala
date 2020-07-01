package scala.Chapter1_basic.classDemo

/**
  * Created by taos.
  */
class Person(val name: String,var age: Int, val gender: String) {

  var agg: Int = 10


  def this(name: String, age: Int) {
    this(name, age, "male")
  }

  override def toString(): String = {
    name +" "+ age +" "+ gender
  }
}

class Student(name: String ,age: Int, gender: String) extends Person(name: String ,age: Int, gender: String){
  override def toString(): String = {
    name +" " + age +" "+gender
  }
}

object DTestor{
  def main(args: Array[String]) {
    //val map = HashMap[Int, Int]()
    val person = new Person("zhang", 12,"female")
    println(person.age)
    person.age=(11)
    println(person.age)
    println(person.toString())
    val stu = new Student("li", 12,"female")
    println(stu.toString())
  }
}
