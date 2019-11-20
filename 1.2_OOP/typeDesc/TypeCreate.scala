package com.esoft.typeDesc

/**
  * Created by taos on 2017/5/7.
  */
object TypeCreate {

  //type  AbstaractType
  type  ConcreateType = Int
  def main(args: Array[String]): Unit = {
    val param:ConcreateType = 1
    println(param)
  }
}

class T {
  type AbstractType = String
  def sayHello():AbstractType ={
    "hello everyone"
  }
}