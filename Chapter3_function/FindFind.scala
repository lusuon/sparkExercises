package Chapter1_basic.func

/**
  * Created by taos on 2017/11/15.
  */
object FindFind {
  def main(args: Array[String]): Unit = {
    println(findFirst(Array("1","2","3","4","5"), "4"))
    def f = (x:String) => x == "3"
    findFirstExt(Array("1","2","3","4","5"), f)
  }
  def findFirst(ss: Array[String],key: String): Int = {
    def loop(n: Int): Int =
        if(n >= ss.size) -1
        else if (ss(n) == key) n
        else loop(n + 1)
    loop(0)
  }
  def findFirstExt[R](ss: Array[R],f:(R)=> Boolean): Int= {
      def loop(n: Int): Int = {
        if(n >= ss.length) -1
        else if(f(ss(n))) n
        else loop(n + 1)
      }
    loop(0)
  }
}
