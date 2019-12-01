package Chapter1_basic.modelchange

abstract class Animal{
  def name:String
}
case class Cat(name:String) extends Animal
case class Dog(name:String) extends Animal

object Modelchange2 extends App {

  // List是协变，Cat和Doc都是Animal的子类，所以List[Cat]和List[Dog]都是List[Animal]的子类。
  // 猫的列表和狗的列表都是动物的列表是合理的，你应该能够用它们中的任何一个替换 List[Animal]
  def printAnimalNames(animals: List[Animal]): Unit = {
    animals.foreach { animal =>
      println(animal.name)
    }
  }

  val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))

  val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

  printAnimalNames(cats)

  printAnimalNames(dogs)

}
