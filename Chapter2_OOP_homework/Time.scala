/**
  * .编写一个Time类，加入只读属性hours和minutes，和一个检查某一时刻是否早于另一时刻
  * 的方法before(other:Time):Boolean。Time对象应该以new Time(hrs,min)方式构建。其中hrs以
  * 军用时间格式呈现(介于0和23之间)
  *
  */

class Time(val hours:Int, val minutes:Int){
  def before(other:Time):Boolean = this.hours < other.hours || this.minutes < other.minutes
  override def toString: String = s"$hours:$minutes"
}

object Time{
  def main(args: Array[String]): Unit = {
    val t1 = new Time(23,34)
    val t2 = new Time(23,44)
    val t3 = new Time(10,20)
    println(s"compare $t1 and $t2, $t1  before $t2 ${t1.before(t2)}")
    println(s"compare $t3 and $t1, $t3  before $t1 ${t3.before(t1)}")
    println(s"compare $t1 and $t3, $t1  before $t3 ${t1.before(t3)}")
  }
}
