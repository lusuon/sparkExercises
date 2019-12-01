package Chapter1_basic.abstractClass

/**
  * Created by dulm
  * 抽象类：abstract修饰的类，不可被实例化，抽象类中可以包含抽象字段、方法；非抽象字段、方法。
  * 抽象字段：没有初始化的字段，被子类覆盖时overried可选
  * 抽象方法:没有方法体的方法，被子类重写时overried可选
  */
abstract class Animal {
  var tt: Int
  def templateMethod = {s"The ${1+1} goes $sound"}
  def animal: String
  def sound: String
}
class Duck extends Animal {
  var tt = 100
  def animal = "Duck"
  //override 是可选的
  override def sound = "Quack"

}

abstract class Cow extends Animal {

  def animal = "Cow"
  //override 是可选的
  override def sound = "Moo"
}

object AnimalTest {
  def main(args: Array[String]) {
    println((new Duck).templateMethod)
  }
}
