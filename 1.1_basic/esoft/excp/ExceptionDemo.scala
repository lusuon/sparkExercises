package com.esoft.excp

/**
  * Created by taos on 2017/4/22.
  */
object ExceptionDemo {
  def main(args: Array[String]) {
    try {
      throw new IndexOutOfBoundsException("....")
    } catch {
      case e: IndexOutOfBoundsException => e.printStackTrace()
    }
  }
}
