package com.esoft.mapDemo

/**
  * Created by taos on 2017/4/25.
  */
object MapDemo {

  def main(args: Array[String]) {
    val m = Map(1 -> "guanyu", 2 -> "zhaoyun")
    List(1,2) map m
    println(List(1,2).map(m))

    val mm = Map("zhangfei"->"zhangbashemao", "guanyu"->"qinglongyanyue")
      .withDefaultValue("bishou")

    println(mm("zzz"))
  }

}
