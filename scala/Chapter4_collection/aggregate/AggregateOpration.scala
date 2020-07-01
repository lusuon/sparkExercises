package com.esoft.aggregate

/**
  * Created by taos on 2017/4/6.
  */
object AggregateOpration {

  def main(args: Array[String]): Unit = {
    val array = Array(1,2,3,4,5)
    val list = List(6,7,8)
    val list2 = List(1,2,3)
    val end = array ++: list
    end.foreach(println)
    val listString = List("a","b","c","d")
    // :\代表foldRight,类似于reduceRight
    val x1 = (listString :\ "e")(_ +"|"+ _)
    println(x1)

  }
  /**
  1.  0+1,  0+1
  2.  1+2,  1+1
  3.  3+3,  2+1
  4.  6+4,  3+1
  5.  10+5,  4+1
  6.  15+6,  5+1
  7.  21+7,  6+1
  8.  28+8,  7+1
  9.  36+9,  8+1
  10. 45+10  9+1
    */

}


