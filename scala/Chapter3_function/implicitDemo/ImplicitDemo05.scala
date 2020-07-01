package scala.Chapter1_basic.func.implicitDemo

import java.io.File

import scala.io.Source

object ImplicitDemo05 {

  implicit class RichFile(val file: File) {
    def read = Source.fromFile(file.getPath).mkString
  }

  def main(args: Array[String]): Unit = {
    val f: File = new File("E: \\Result\\spark-job-server.log")
    f.read
  }
}
