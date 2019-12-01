package Chapter1_basic.func.recursion

/**
  * Created by taos on 2017/11/10.
  */
object FindFirst {
def findFirst(as: Array[String], key: String): Int = {
  def loop(n: Int): Int =
     if(n >= as.length) -1 //退出条件
     else if(as(n) == key) n//结束条件找到值
     else loop(n + 1)
  loop(0)
}
  def findFirstExt[A](as: Array[A],f:A=> Boolean): Int = {
    def loop(n: Int): Int =
      if(n >= as.length) -1 //退出条件
      else if(f(as(n))) n//结束条件找到值
      else loop(n + 1)
    loop(0)
  }

  def main(args: Array[String]): Unit = {
    val array = Array("1","2","3","4","5")
    println(findFirst(array, "5"))

    println(findFirstExt(array, (x: String) => x == "3"))
  }
}
