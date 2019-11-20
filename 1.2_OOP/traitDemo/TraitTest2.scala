package com.esoft.traitDemo

/**
  * Created by Administrator on 2017/10/23.
  */
trait Logged {
  println("Logged")
  def log(msg: String): Unit = {
    println(msg)
  }
}
trait TimestampLogger extends Logged {
  println("TimestampLogger")
  override def log(msg: String): Unit = {
    println("TimestampLogger..")
    //调用其左侧方法
    super.log(new java.util.Date() + "-" + msg)
  }
}

trait ShortLogger extends Logged {
  println("ShortLogger")
  val maxLength = 15
  override def log(msg: String): Unit ={
    println("ShortLogger..")
    super.log(if(msg.length <= maxLength) msg else msg.substring(0, maxLength - 3) + "...")
  }
}

trait ConsoleLoger extends Logged{
  println("ConsoleLoger")
  override def log(msg: String): Unit = {
    println("ConsoleLoger..")
    println(msg)
  }
}

class Account {
  println("Account")
  var balance = 0.0
}

class SavingAccount extends Account with Logged{
  println("SavingAccount")
  def withdraw(amount: Double): Unit = {
    if(amount > balance) log("Insufficient funds")
    else balance -= amount
  }
}

object Testor1 {
  def main(args: Array[String]): Unit = {
//    val acc = new SavingAccount with ShortLogger
    //acc.withdraw(1)

//    val acc1 = new SavingAccount with ConsoleLoger with TimestampLogger with ShortLogger
//    acc1.withdraw(2)

//    val acct2 = new SavingAccount with ConsoleLoger with ShortLogger with TimestampLogger
//    acct2.withdraw(3)
  }
}
