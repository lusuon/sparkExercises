package scala.Chapter1_basic.caseClassDemo

/**
  * Created by taos on 2017/11/7.
  */
class CourseUtils {
  def findCourseByNo(no: Int): Course = {
    Course(1, "scala")
  }
}

case class Course(no: Int, name: String)


object Testor {
  def main(args: Array[String]): Unit = {
     val c = new CourseUtils
      c.findCourseByNo(1)
  }
}