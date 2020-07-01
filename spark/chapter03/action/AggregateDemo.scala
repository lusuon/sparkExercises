

import org.apache.spark.sql.SparkSession

/**
  * The aggregate function allows the user to apply two different reduce functions to the RDD
  */
object AggregateDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("AggregateDemo").master("local").getOrCreate()
    val sc = spark.sparkContext
    val z = sc.parallelize(List(1,2,3,4,5,6), 2)

    // lets first print out the contents of the RDD with partition labels
    def myfunc(index: Int, iter: Iterator[(Int)]) : Iterator[String] = {
      iter.map(x => "[partID:" +  index + ", val: " + x + "]")
    }

    z.mapPartitionsWithIndex(myfunc).collect

    // This example returns 16 since the initial value is 5
    // reduce of partition 0 will be max(5, 1, 2, 3) = 5
    // reduce of partition 1 will be max(5, 4, 5, 6) = 6
    // final reduce across partitions will be 5 + 5 + 6 = 16
    // note the final reduce include the initial value
    z.aggregate(5)(math.max(_, _), _ + _)

    val z1 = sc.parallelize(List("a","b","c","d","e","f"),2)
    def myfunc1(index: Int, iter: Iterator[(String)]) : Iterator[String] = {
      iter.map(x => "[partID:" +  index + ", val: " + x + "]")
    }

    z1.mapPartitionsWithIndex(myfunc1).collect
    // [partID:0, val: a], [partID:0, val: b], [partID:0, val: c],
    // [partID:1, val: d], [partID:1, val: e], [partID:1, val: f]
    // 输出什么？
    z1.aggregate("")(_ + _, _+_)
    // 输出什么？
    z1.aggregate("x")(_ + _, _+_)

    val z2 = sc.parallelize(List("12","23","345","4567"),2)
    z2.mapPartitionsWithIndex(myfunc1).collect
    // [partID:0, val: 12], [partID:0, val: 23], [partID:1, val: 345], [partID:1, val: 4567]
    // 输出什么？
    z2.aggregate("")((x,y) => math.max(x.length, y.length).toString, (x,y) => x + y)
    z2.aggregate("")((x,y) => math.min(x.length, y.length).toString, (x,y) => x + y)

    val z3 = sc.parallelize(List("12","23","345",""),2)
    z3.mapPartitionsWithIndex(myfunc1).collect
    //[partID:0, val: 12], [partID:0, val: 23], [partID:1, val: 345], [partID:1, val: ]
    z3.aggregate("")((x,y) => math.min(x.length, y.length).toString, (x,y) => x + y)
  }

}
