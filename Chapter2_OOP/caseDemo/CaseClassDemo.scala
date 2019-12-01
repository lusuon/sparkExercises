package Chapter1_basic.caseDemo

/**
  * Created by taos
  * case class 2个 基本应用
  * 消息传递和模式匹配
  */

abstract class People

case class Student(age: Int) extends People
case class Worker(age:Int,salary:Double) extends People
//能用于模式匹配，能序列化，actor 会用到
case object Shared extends People
object CaseClassDemo {
  def main(args: Array[String]) {

    // 1.样例类的比较：基于值比较
//    val stu1:Student = Student(10)
//    val stu2:Student = Student(11)
//    println(stu1 == stu2)

    // 2.样例类的拷贝
//    val worker = Worker(20,15000.0)
//    val worker1 = worker.copy()
//    println(worker == worker1)
//    val worker2 = worker.copy(salary=16000.0)//case class的消息传递功能
//    println(worker == worker2)
//    val worker3 = worker2.copy(age = 30)
//
//    // 3.利用样例类做模式匹配
    caseOps(Student(19))
    caseOps(Shared)
  }
  //方法可以嵌套到main 函数里面
  def caseOps(people:People) = people match {//定义caseOps方法，对输入参数people进行模式匹配
    case Student(age) => println("age:" + age)
    case Worker(age,salary) => println("age:" +age + "salary" + salary)
    case Shared => println("nothing")
  }
}
