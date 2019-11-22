package com.esoft.func.implicitDemo

import java.io.File
import scala.io.Source

object ImplicitDemo02 {
  class RichFile(val file: File) {
    def read = Source.fromFile(file.getPath).mkString
  }

  implicit def file2Rich(f: File) = new RichFile(f)

  def main(args: Array[String]): Unit = {
    val f: File = new File("E: \\Result\\spark-job-server.log")
    f.read
  }
}




