package com.esoft.func

/**
  * Created by taos on 2017/11/14.
  */
object Testor1 {
  def main(args: Array[String]): Unit = {
    val p = new Pair(new Person(),new Person())
    val p2 = p.replaceFirst(new Student())
  }}
class Pair[T](val first: T, val second: T) {
  def replaceFirst(newFirst: T) = new Pair[T](newFirst, second)
}
class Person{}
class Student extends Person{}