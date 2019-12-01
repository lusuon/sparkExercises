package Chapter1_basic.ac.outside

import Chapter1_basic.ac.Father

/**
  * Created by Administrator on 2017/4/21.
  */
class Son extends Father{
    def skill() = {
      super.programing()
    }

  override def programing(): Unit = {
    println("use java or scala programing1111")
  }
}

object SonT{
  def main(args: Array[String]) {
    val son = new Son()
    son.skill()
    son.programing()

    val father:Father = new Father
    //father.programing()
  }
}
