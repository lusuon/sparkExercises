package com.esoft.parallelCollection

import scala.collection.mutable

/**
  * Created by taos
  *
  */
object ParallelDemo01 {
  def main(args: Array[String]) {
    (1 to 5).foreach(println(_))
    (1 to 5).par.foreach(println(_))


    val a = (1 to 100).map{case _ => Thread.currentThread().getName}.distinct
    println(a)

    val b = (1 to 100).par.map{
      case _ => Thread.currentThread().getName
    }.distinct
    println(b)

    val c = mutable.HashSet(1,2,3,4)
    println(c.par)
  }
}
