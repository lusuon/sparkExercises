package scala.Chapter1_basic.lazyVal

import java.io.File
import java.net.URI

/**
  * Created by taos on 2017/6/2.
  */
object ReadFileDemo {
  def main(args: Array[String]) {
    //获取根路径
    val root = ReadFileDemo.getClass.getResource("/")
    val uri = new URI(root + "readMe1.txt");
//    val f = new File()，所以需要构造URL
    //注意 fromFile 接收的参数是URI
    lazy val words = scala.io.Source.fromFile(uri).mkString

    //定义lazy 变量的作用是延迟加载，用到变量的时候才去加载
    //println(words)
  }
}
