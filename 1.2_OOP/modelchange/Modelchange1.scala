package com.esoft.modelchange
// 不变
class List1[T](val head:T, val tail:List1[T])
// 协变
class List2[+T](val head:T, val tail:List2[T])
// 逆变
class List3[-T](val head:Any, val tail:List3[T])

object Modelchange1 extends App{
  val a:List2[String] = new List2("hello",null)
  // List2[AnyRef]顺应List2[String]
  val b:List2[AnyRef] = a
  // 此处报错,因为List2的泛型是协变
  //val c:List2[String] = b

  val d:List3[AnyRef] = new List3("hello", null)
  // List3[String]顺应List3[AnyRef]
  val e:List3[String] = d
  // 此处报错，因为List3的泛型是逆变的。
  //val f:List3[AnyRef] = e
}
