package Chapter1_basic.func

import scala.reflect.ClassTag

/**
  * Created by Administrator on 2017/6/3.
  */
object TypeFunc {

  def arrayMake[T: ClassTag](first: T, second: T) = {
    val r = new Array[T](2)
    r(0) = first
    r(1) = second
    r
  }

  def main(args: Array[String]) {
    arrayMake(1,2)
  }

}
