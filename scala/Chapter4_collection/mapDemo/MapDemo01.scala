package com.esoft.mapDemo

import scala.collection.mutable

/**
 * @author taoshi
 */
object MapDemo01 {
  
  def main(args: Array[String]): Unit = {
    // 1.构造不可变Map
    val map1 = Map("name"->"zhangsan","age"->16)
    //map1.put("gendar","male")// 报错
    // 输出结果有序
    println(map1)

    // 2.构造不可变map
    val map2 = mutable.Map("name"->"zhangsan", "age"->16)
    map2.put("class", "大数据实验班")
    println(map2)

    // 3.创建空map
    val map3 = new scala.collection.mutable.HashMap[String, Int]
    println(map3)

    // 4.以对偶元组的形式创建Map
    val map4 = mutable.Map(("name", "zhangsan"), ("age", 20))
    println(map4)

    // 5.map 的取值可以使用 getOrElse
    println(map1.getOrElse("name1", "does not exists!"))

    //遍历kv 的值
    for((k, v)<- map1){
      println(s"$k===>$v")
    }

    //只想取其中一个值时
    for((k, _) <- map1){
      println(s"$k")
    }
    
    //map 可以转换为key set
    val keyset = map1.keySet
    keyset foreach(print _)
    
    val iter = map1.values.iterator
    while(iter.hasNext){
      println(iter.next)
    }

    // 添加元素 更新元素
    map2 += ("address"->"东北大学")
    map2 += ("address"->"东北大学南湖校区")// 或者map.updated
    println(map2)
    //删除元素
    map2 -= ("address")

    // 合并map ++

    // 改变map值
    map2 transform((x, y) => x + "_")
    println(map2)

    // 清空map
    map2.empty
  }
  
}