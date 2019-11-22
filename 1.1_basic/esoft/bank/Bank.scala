package com.esoft.bank

/**
  * Created by taos on 2017/4/13.
  */
object Bank {

  def main(args: Array[String]): Unit = {
    println("")
    val czhang = new Customer(1,123,"zhangsan")
    val li = new Customer(2,123,"li")
    val wang = new Customer(3,123,"wang")
    val customerList = List(czhang,li,wang)
    val admin = new Administrator(customerList)
    admin.run()
  }

}
