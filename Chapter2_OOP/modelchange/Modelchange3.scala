package Chapter1_basic.modelchange

// 这里A是逆变
abstract class Printer[-A] {
  def print(value: A): Unit
}

class AnimalPrinter extends Printer[Animal] {
  def print(animal: Animal): Unit =
    println("The animal's name is: " + animal.name)
}

class CatPrinter extends Printer[Cat] {
  def print(cat: Cat): Unit =
    println("The cat's name is: " + cat.name)
}

object Modelchange3 extends App{
  val myCat: Cat = Cat("Boots")

  def printMyCat(printer: Printer[Cat]): Unit = {
    printer.print(myCat)
  }

  // 如果 Printer[Cat] 知道如何在控制台打印出任意 Cat，
  // 并且 Printer[Animal] 知道如何在控制台打印出任意 Animal，
  // 那么 Printer[Animal] 也应该知道如何打印出 Cat 就是合理的。
  // 反向关系不适用，因为 Printer[Cat] 并不知道如何在控制台打印出任意 Animal。
  // 因此，如果我们愿意，我们应该能够用 Printer[Animal] 替换 Printer[Cat]，
  // 而使 Printer[A] 逆变允许我们做到这一点。
  val catPrinter: Printer[Cat] = new CatPrinter
  val animalPrinter: Printer[Animal] = new AnimalPrinter
  //val animalPrinter2: Printer[Animal] = new CatPrinter
  val catPrinter2:Printer[Cat] = new AnimalPrinter

  printMyCat(catPrinter)
  printMyCat(animalPrinter)

  val catPrinter1: Printer[Cat] = animalPrinter
  printMyCat(catPrinter1)
  //
  // val animalPrinter1:Printer[Animal] = catPrinter
}