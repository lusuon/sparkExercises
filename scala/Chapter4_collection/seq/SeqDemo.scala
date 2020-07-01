package com.esoft.seq

/**
  * Created by Administrator on 2017/4/24.
  */
object SeqDemo {

  def main(args: Array[String]) {
     val x = Seq(2,1,30,-20,1,2,0)
     /*List(List(2, 1), List(1, 30), List(30, -20), List(-20, 1),
     List(1, 2), List(2, 0), List(0), List())
     println(x.tails.map(_.take(2)).toList)*/

    // Seq(2,1,30,-20,1,2,0),Seq(1,30,-20,1,2,0),Seq(30,-20,1,2,0),Seq(-20,1,2,0),Seq(1,2,0),Seq(2,0),Seq(0)
    // 3,31,10,-19,3,2
    println(x.tails.map(_.take(2)).filter(_.length > 1) map (_.sum) toList)
  }
}
