package com.esoft.listopt

object FilterDemo01 {

  def main(args: Array[String]): Unit = {
    val score = Map[String, Double]("语文" -> 100, "数学" -> 98,"英语"->90,"历史"->80)
    val a = score.filter(kv => (kv._2 > 90))
    println(a)
    val b = score.filter(kv => (kv._1 == "语文"))
    println(b)
  }
}
