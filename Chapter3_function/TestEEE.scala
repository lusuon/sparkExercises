package Chapter1_basic.func

import java.io.File

import scala.io.Source

/**
  * Created by taos on 2017/11/15.
  */

object Context {
  implicit def file2Rich(file: File) = new RichFile(file)
}
object TestEEE {
  def main(args: Array[String]): Unit = {

    val file = new File("E:\\eee.txt")
    import Context._
    println(file.read)
  }
}
class RichFile(val file: File) {
  def read = Source.fromFile(file.getPath)("GBK").mkString
}
