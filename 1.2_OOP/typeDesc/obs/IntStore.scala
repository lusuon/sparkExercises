package com.esoft.typeDesc.obs

/**
  * Created by taos on 2017/10/31.
  */
class IntStore(private var value: Int) extends Subject with DefaultHandles{
  def get : Int = value
  def set(newValue: Int): Unit = {
    value = newValue
    notifyListenners()
  }

  override def toString: String = "IntStore("+ value +")"
}

object Testor {

  def hello(x:Any):Unit = {
    println("hello everyone")
  }

  def main(args: Array[String]): Unit = {
    val x = new IntStore(5)
    val handle = x.attach(println)
    val handle1 = x.attach(hello)
    x.set(2)
  }
}
