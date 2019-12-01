package com.esoft.traversable

import java.io.{File, FileReader, BufferedReader}

/**
  * Created by taos on 2017/4/24.
  */
class FileLineTraversable(file: File) extends Traversable[String]{
  override def foreach[U](f: (String) => U): Unit = {
    val input = new BufferedReader(new FileReader(file))
    try{
      var line = input.readLine
      while(line != null){
        f(line)
        line = input.readLine
      }
    } finally{
      input.close()
    }
  }
  override def toString = "{line of " + file.getAbsolutePath + "}"
}


object FileLineTestor{
  def main(args: Array[String]) {
      val fl = new FileLineTraversable(new File("E:\\Result\\req.txt"))
      fl.foreach(println(_))
      println(fl.toString)
  }
}