package Chapter1_basic.bank
import scala.util.control.Breaks._
import scala.io.StdIn._
/**
  * Created by taos on 2017/4/13.
  */
class Administrator (var custs: List[Customer]){

  def createCust(custs: List[Customer] ):List[Customer] = {
    println("输入账号:")
    val userId = readInt()

//      for (cust <- custs) {
//        if (cust.id == userId) {
//          println("用户已存在")
//          custs
//        }
//      }
      val list =  custs.filter(_.id != userId)
      if(list.size == custs.size) {
        println("账号创建成功！请输入账户信息：")
        println("密码：")
        val pwd = readInt()
        println("名字：")
        val name = readLine()
        System.out.println("账号余额：");
        val money = readDouble()
        val customer = new Customer(userId, pwd, name, money);
        println(s"账户：$userId，姓名：$name，余额：$money")
        customer :: custs
      } else {
        println("账号已存在!")
        list
      }
  }

  def showUser(custs: List[Customer]): Unit ={
    println("输入要查询用户账号:")
    val userId = readInt()
    val targetUser = custs.find(_.id == userId)
    targetUser.map{
      line =>
        println(s"姓名：${line.name},金额:${line.money}")
    }
  }

  def delete(custs: List[Customer]): List[Customer] = {
    print("请输入删除用户账号:")
    val userId = readInt()
    custs.filter(_.id != userId )
  }

  def showAll(custs: List[Customer]): Unit = {
    custs.map{
      user =>
        println(s"账号:${user.id},用户名:${user.name},金额:${user.money}")
    }
  }

  def run(): Unit = {
    while(true){
      println("=======菜单=======")
      println("1、创建账户")
      println("2、查找信息")
      println("3、删除某顾客")
      println("4、显示全部")
      println("0、退出")
      println("请输入选项：")

      val cmd = readInt();
      cmd match{
        case 1 => this.custs = createCust(custs)
        case 2 => showUser(custs)
        case 3 => this.custs = delete(custs)
        case 4 => showAll(custs)
        case 0 => System.exit(0)
        case _ => println("输入错误！")
      }
      }
  }



}
