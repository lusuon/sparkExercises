package Chapter1_basic.func.base

/**
  * 变长参数测试
  */
object VariableLengthParam {

  def sum(args: Int*): Int = {
    // arg是一个Seq类型
    var result = 0
    for(arg <- args) {
      result += arg
    }
    result
  }

  def main(args: Array[String]): Unit = {
    println(sum(1,2,3,4,5))
    // 1 to 5生成一个Range类型对象，所以使用_*将1 to 5当做参数序列
    println(sum(1 to 5:_*))
  }

}
