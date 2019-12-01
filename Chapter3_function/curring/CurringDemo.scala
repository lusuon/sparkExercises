package Chapter1_basic.func.curring

/**
  * Created by Administrator on 2017/4/24.
  */
object CurringDemo {
  def main(args: Array[String]) {
    val a = Array()
    val lista = Array("a", "b")
    val listb = Array("a", "b")
    //比较两个序列是否在某个对比条件下相同
    val aa = lista.corresponds(listb)(_.equalsIgnoreCase(_))

    println(aa)

  }
}
