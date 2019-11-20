/**
  * .编写一个Time类，加入只读属性hours和minutes，和一个检查某一时刻是否早于另一时刻
  * 的方法before(other:Time):Boolean。Time对象应该以new Time(hrs,min)方式构建。其中hrs以
  * 军用时间格式呈现(介于0和23之间)
  *
  */

class Time(val hours, val minutes){

}

object Time{
  def main(args: Array[String]): Unit = {
    val t = new Time()
  }
}
