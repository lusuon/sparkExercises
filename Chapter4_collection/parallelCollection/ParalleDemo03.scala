package com.esoft.parallelCollection

object ParalleDemo03 {
  def main(args: Array[String]): Unit = {
    val x = (1 to 10).toList
    println(x.par)

    time {
      val y = x.par.aggregate((0, 0))(
        (acc, number) => {
          println(Thread.currentThread().getName)
          (acc._1 + number,acc._2 + 1)},
        (par1,par2) => (par1._1 + par2._1, par1._2 + par2._2))
      println(y)
    }
  }

  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
  }
}
