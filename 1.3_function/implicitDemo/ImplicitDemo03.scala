package com.esoft.func.implicitDemo

object ImplicitDemo03 {

  implicit val str1:String = "everyone"

  // implicit name即为隐式参数
  def hello(implicit name:String) = {
    println(s"hello $name")
  }

  def main(args: Array[String]): Unit = {
    hello
  }

}
