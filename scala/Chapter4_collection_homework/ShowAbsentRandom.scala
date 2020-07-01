package scala.Chapter4_collection_homework

import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import scala.collection.mutable.BitSet

/**
  *1.一千万个随机数，随机数范围在1到1亿之间，现在要求写出一种算法，将1到1亿之间没有出现的随机数求出来
 */

object ShowAbsentRandom {
  def main(args: Array[String]): Unit = {
    var full = BitSet()
    var randomSet = BitSet() // 使用BitSet的标记位记录取样，以降低内存占用
    val seed = new Random()
    (1 to 100000000).map(full.add(_)) // 初始化完全的数组
    (1 to 10000000).par.foreach(_ => randomSet.add( seed.nextInt(9999999) + 1 )) // 并行添加随机数
    print((full -- randomSet).size) // 差集过大，不方便打印，仅打印其大小
  }
}
