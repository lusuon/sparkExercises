package scala.Chapter1_basic.func.placeHolder

/**
  * Created by taos
  */
object PlaceHolder {
  def main(args: Array[String]) {
    val list = List(1,2,3,4)
    list.filter((x) => x > 2)
    //使用占位符使得程序更简洁
    list.filter(_>2)
  }
}
