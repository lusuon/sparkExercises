package scala.Chapter1_basic.optionDemo
import java.io.File
/**
  * Created by taos on 2017/11/6.
  */
object Company {
  val opt: Option[Employee] = Some(Employee("zhangsan","dev"))
  def main(args: Array[String]): Unit = {
    val joeDepartment = lookupByName("zhangsan").map(_.department)
    println(joeDepartment.getOrElse("guagua"))
  }
  def lookupByName(name: String): Option[Employee] = {
    //opt.filter(_.name == ("zhangsan") )
    opt.filter{
      line=>
        println(line)
      false
    }
  }

  def getTemp(tem: Option[String]): File = {
    val t: Option[File] = tem.map(name => new File(name))
      t.filter(_.isDirectory).getOrElse(new File(System.getProperty("java.io.tmpdir")))
  }
}
//定义数据类型Employee
case class Employee(name: String, department: String)