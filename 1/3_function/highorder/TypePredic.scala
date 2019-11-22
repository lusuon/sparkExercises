package com.esoft.func.highorder

/**
  * Created by Administrator on 2017/4/22.
  */
object TypePredic {

  def greeting(func: (String) => Unit, name: String) { func(name) }

  def triple(func: (Int) => Int) = { func(3) }

  def main(args: Array[String]) {
    greeting((name: String) => println("Hello, " + name), "leo")
    greeting((name) => println("Hello, " + name), "leo")
    greeting(name => println("Hello, " + name), "leo")
    triple(3 * _)
  }
}
