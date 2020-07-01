package scala.Chapter4_collection_homework

/**
  * 编写一个函数，接收一个字符串集合，以及一个从字符串到整数的映射，返回整数集合，其值为能和集合中某个字符串相应的映射值。
  * 举例来说，给定Array("Tom","Fred","Harry") 和 Map("Tom"->3,"Dick"->4,"Harry"->5),返回Array(3,5)
  */
object StringMap {
  // map的get方法返回option对象，需要get解封装
  def str2int(strArr:Array[String],mapper:Map[String,Int])= strArr.map(mapper.get(_)).filter(_ != None)

  def main(args: Array[String]): Unit = {
    val strCol = Array("Tom","Fred","Harry")
    val strMap = Map("Tom"->3,"Dick"->4,"Harry"->5)
    str2int(strCol,strMap).map(_.get).map(println)
  }
}
