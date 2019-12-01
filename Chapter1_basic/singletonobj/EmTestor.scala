package Chapter1_basic.singletonobj

/**
  * Created by Administrator on 2017/6/2.
  */
object EmTestor {
  def main(args: Array[String]) {
    val employee = Employee("zhangsan", "bj")
    //val em = new Employee("zhangsan", "bj")
    println(employee.phoneNum)
    println(employee.infoComObj)
  }
}
