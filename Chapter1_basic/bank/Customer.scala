package Chapter1_basic.bank

import scala.io.StdIn._
/**
  * Created by taos on 2017/4/13.
  */
class Customer(val id: Int,val pwd: Int,val name: String,var money: Double) {
  def this(id: Int, pwd: Int, name: String) =
      this(id, pwd, name, 0.0)

  def getMoney(): Double = {
    println("输入金额：")
    val reqMoney = readDouble()
    if(reqMoney > this.money) {
      println("余额不足！")
    } else {
      this.money -= reqMoney
    }
    this.money
  }

  def saveMoney(): Double = {
    println("输入金额：")
    val reqMoney = readDouble()
    this.money += reqMoney
    this.money
  }

  def showMoney() = println(this.money)

  def run(): Unit = {
    while(true){
      println("=======菜单=======")
      println("1、存钱")
      println("2、取钱")
      println("3、余额")
      println("0、退出")
      println("请输入选项：")

      val cmd = readInt();
      cmd match{
        case 1 => this.money = saveMoney()
        case 2 => this.money = getMoney()
        case 3 => showMoney()
        case 0 => System.exit(0)
        case _ => println("输入错误！")
      }
    }
  }

}
