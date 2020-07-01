package scala.Chapter4_collection_homework

/**
  * 对给定的整型列表lst,(lst :\ List[Int]())(_:: _)得到的是什么?
  * （List[Int]() /: lst）(_:+_)又得到什么?
  * 如何修改这两个操作，对原来列表反向操作？
  */
object ListOperations {
  def main(args: Array[String]): Unit = {
    val lst:List[Int] = List(1,2,3,4)
    // 运算符 :\ 表达foldRight
    val foldRight_lst = (lst :\ List[Int](5,6,7,8))(_::_) // (5,6,7,8)为累计值，自右向左将(1,2,3,4)的元素通过构造::插到(5,6,7,8)前面
    val foldLeft_lst = (List[Int](5,6,7,8) /: lst)(_:+_)  // (5,6,7,8)为累计值，向左遍历(1,2,3,4)，遍历值追加到(5,6,7,8)之后
    println(foldRight_lst)
    println(foldLeft_lst)
    //val alter_foldRight_lst = (lst :\ List[Int](5,6,7,8))(_+:_) // (5,6,7,8)为累计值，使用构造将(1,2,3,4)插到其前面
    //val alter_foldLeft_lst = (List[Int](5,6,7,8) /: lst)(_++_)  // (5,6,7,8)为累计值，在尾部追加(1,2,3,4)
    //println(alter_foldRight_lst)
    //println(alter_foldLeft_lst)

  }
}
