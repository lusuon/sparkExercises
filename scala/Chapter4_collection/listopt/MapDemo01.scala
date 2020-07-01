package com.esoft.listopt

object MapDemo01 {

  def main(args: Array[String]): Unit = {
    val list01 = List(1,2,3)
    val list02 = list01.map(_*2)
    val list03 = list01.map(x => x*2)
    println(list02)

    val books = List("Hadoop","Hive","HDFS")
    val rs1 = books flatMap (s => s.toList)
    println(rs1)
    val rs2 = books map (s => s.toList)
    println(rs2)
  }

}
