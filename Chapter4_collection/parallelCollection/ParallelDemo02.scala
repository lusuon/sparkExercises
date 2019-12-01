package com.esoft.parallelCollection

/**
  * par + aggregate聚合
  * aggregate类似于mapreduce的maptask+combiner
  * 将每个分区里面的元素进行聚合，然后用combine函数将每个分区的结果和初始值进行combine操作
  */
object ParallelDemo02 {

  def main(args: Array[String]): Unit = {
    val rdd1 = List(1 to 100 :_*)
    val result: Int = rdd1.par.aggregate(0)(
      (acc, number) => {
        val res1 = acc + number
        println("par    " + acc + " + " + number+" = "+res1)
        res1
      },
      (par1, par2) => {
        val res2 = par1 + par2
        println("com    " + par1 + " + " + par2+" = "+res2)
        res2
      }
    )
    println(result)
  }
}
