package com.esoft.func.LocalFunc

import scala.io.Source

/**
  * 可以在方法内定义方法，这种方法叫本地函数，本地函数可以直接访问父函数的参数
  */
object LocalFun {

  def processFile(fileName: String, width: Int) {
     def processLine(line: String) {
        if(line.length > width) {
          print("fileName:" + line )
        }
     }
     val source = Source.fromFile(fileName)
     for(line <- source.getLines()){
       processLine(line)
     }

  }
  def main(args: Array[String]):Unit = {
    LocalFun.processFile("G:\\out\\RE.txt",2)
  }



}
