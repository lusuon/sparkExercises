package com.esoft.stream

/**
  * Created by taos on 2017/4/25.
  */
object StreamDemo {

  def main(args: Array[String]) {
    //拉链函数 zip
    val result = List("a","b","c","d") zip (Stream from 1)
    println(result)

    val result1 = (Stream from 1)
    for (i <- 0 until 10) println(result1(i))
    println(result1)

    val ListasStreamList = List("a","b","c","d","e").toStream
    println(ListasStreamList)

    val ss = Stream.cons(3, Stream.cons(2, Stream.cons(1, Stream.empty)))
    println(ss)

    lazy val fib: Stream[BigInt] = Stream.cons(1, Stream.cons(1, (fib zip fib.tail).map(p => p._1 + p._2)))
    println(fib)
    println(fib(9))

    //构造 stream
    val s = 1 #::{
      println("HI")
      2
    } #:: {
      println("BAI")
      3
    } #:: Stream.empty
    println(s(2))
  }

}
