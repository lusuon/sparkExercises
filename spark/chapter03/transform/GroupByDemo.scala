

import org.apache.spark.sql.SparkSession

object GroupByDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("GroupByDemo").master("local").getOrCreate()
    val sc = spark.sparkContext

    val a = sc.parallelize(1 to 9, 3)
    a.groupBy(x => { if (x % 2 == 0) "even" else "odd" }).collect

    val b = sc.parallelize(1 to 9, 3)
    def myfunc(b: Int) : Int =
    {
      b % 2
    }
    b.groupBy(myfunc).collect

    val c = sc.parallelize(1 to 9, 3)
    def myfunc1(x: Int) : Int =
    {
      x % 2
    }
    c.groupBy(myfunc1(_), 1).collect
    c.groupBy((x:Int) => x%2, 2).collect()
    c.groupBy((x:Int) => myfunc1(x), 2).collect()

    // 自定义分区
    val d = sc.parallelize(1 to 9, 3)
    val p = new MyPartitioner()
    val e = d.groupBy((x:Int) => { x % 2 }, p)
    e.collect
  }

  import org.apache.spark.Partitioner
  class MyPartitioner extends Partitioner {
    def numPartitions: Int = 2
    def getPartition(key: Any): Int =
    {
      key match
      {
        case null     => 0
        case key: Int => key          % numPartitions
        case _        => key.hashCode % numPartitions
      }
    }
    override def equals(other: Any): Boolean =
    {
      other match
      {
        case h: MyPartitioner => true
        case _                => false
      }
    }
  }
}
