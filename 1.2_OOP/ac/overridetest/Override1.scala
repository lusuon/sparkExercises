package com.esoft.ac.overridetest

/**
  * 当一个类extends另外一个类的时候，override的规则基本如下：<br>
  * 子类中的方法要覆盖父类中的方法，必须写override（参见foo）<br>
  * 子类中的属性val要覆盖父类中的属性，必须写override（参见nameVal）<br>
  * 父类中的变量不可以覆盖（参见nameVar）
  */
class A {
  val nameVal = "A"
  var nameVar = "A"
  def foo(): String = {
    "A.foo"
  }
}

class B extends A{

  override val nameVal: String = "B"

  //override var nameVar: String = "B"

  override def foo: String = {
    "B.foo"
  }
}
class Test1{}
object Test1{
  def main(args: Array[String]): Unit = {
    val b1 = new B
    println(b1.foo)
    println(b1.nameVal)
    b1.nameVar = "BBB";
    println(b1.nameVal)
    println(b1.nameVar)
  }
}