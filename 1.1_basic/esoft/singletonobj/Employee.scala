package com.esoft.singletonobj

/**
  * Created by taos on 2017/4/20.
  */
class Employee (var name:String, var address: String) {
  var phoneNum = "123499299"
  //可以直接访问伴生对象的属性
  def infoComObj = println(s"companion class call companion obj:"+Employee.gender )
  //println(infoComObj);
}
object Employee{
  var gender = "male"
  def apply(eName: String, eAddress: String) = new Employee(eName, eAddress)
}

object Test{
  def main(args: Array[String]): Unit = {
    val e = Employee("1","2")
    val e2 = new Employee("","")
    val array = Array(1,2,3,5)
  }
}
