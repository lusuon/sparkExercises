/**
  * 定义抽象类Animal，在抽象类中定义抽象方法animal 和 sound，并定义templateMethod
  * * 方法，在这个方法中直接调用animal 和sound方法是否合理？定义两种实现类，实现Animal，修
  * * 改Animal 和它的子类，使其还能表示动物都吃什么。所编写的代码需要满足如下测试
  */

abstract class Animal{
  def animal:String
  def sound:String
  def food:String
  def templateMethod(): String = s"$animal: $sound"
}

class Duck extends Animal {
  override def animal: String = "Duck"
  override def sound: String = "Gaga!"
  override def food: String = "Duck food is plants."
}

class Cow extends Animal{
  override def animal: String = "Cow"
  override def sound: String = "Mow~"
  override def food: String = "Cow food is grass."
}

object Animal{
  def main(args: Array[String]): Unit = {
    val duck = new Duck
    val cow = new Cow
    println(s"${duck.templateMethod()},${duck.food}")// Duck food is “plants”
    println(s"${cow.templateMethod()},${cow.food}")// Cow.food is “grass”
  }
}
