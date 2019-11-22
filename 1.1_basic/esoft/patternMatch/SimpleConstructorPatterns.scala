package com.esoft.patternMatch

/**
  * Created by taos on 2017/11/7.
  */
object SimpleConstructorPatterns {
  def main(args: Array[String]): Unit = {

  }
//  def findPerson(name: String): Person = name match  {
//    case Person(name) => Person(name)
//    case _ => Person("default")
//  }
}

case class Person(name: String)
