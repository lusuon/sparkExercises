package com.esoft.classDemo

/**
  * Created by taos
  *       主构造器中参数如果不带 val 或者 var 相当于private[this]外面访问不到
  */
class Course(val courseName: String,var courseNum: Int) {
        var desc: String = "Scala 编程"
}
object Testor {
    def main(args: Array[String]): Unit = {
        val course = new Course("Scala", 10)
        println(course.courseName)

        course.courseNum = 5
        println(course.courseNum)
    }

}

