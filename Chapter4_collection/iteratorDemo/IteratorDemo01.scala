package com.esoft.iteratorDemo

object IteratorDemo01 {

  def main(args: Array[String]): Unit = {
    // 得到迭代器
    val iterator = Array(1,2,3,4,5).iterator
    while (iterator.hasNext) {
      println(iterator.next())
    }

    val name = Iterable("关羽","赵云","吕布","张飞")
    val weapons = Iterable("青龙","梨花枪","方天画戟","丈八蛇矛")
    // 拉链操作
    val result = name.zip(weapons)
    println(result)
    val iter = result.iterator
    while(iter.hasNext){
      println(iter.next())
    }

  }
}
