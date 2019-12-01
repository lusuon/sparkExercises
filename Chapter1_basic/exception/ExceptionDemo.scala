package Chapter1_basic.exception

import java.io.InputStream
import java.net.URL

/**
  * Created by taos on 2017/9/15.
  * Scala 抛出对象必须是java.lang.Throwable 的子类
  */
object ExceptionDemo {
  def main(args: Array[String]): Unit = {
    var in = new URL("http://horstmann.com/fred.gif").openStream()
    try{
      process(in)
    } finally {
      in.close()
    }
  }

  def process(in: InputStream):Unit = {}
}
