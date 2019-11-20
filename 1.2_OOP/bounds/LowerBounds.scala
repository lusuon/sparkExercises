package com.esoft.bounds

object LowerBounds {
  def main(args: Array[String]) {
    //定义一个能装两台车的容器
    val twoCars = new PairLow(new Car(), new Car())

    // suv: PairLow[Car] = PairLow@5a566922
    val suv = twoCars.replaceFirst(new suv)

    // tankAndCar: PairLow[Vehicle] = PairLow@66ec4409
    val tankAndCar = twoCars.replaceFirst(new Tank)
  }

}

class PairLow[T](val first: T, val second: T) {
  //如果 换为 T，则 函数的返回值会有变化
  def replaceFirst[R >: T](newFirst: R) = new PairLow(newFirst, second)
}

class Vehicle{}

class Car extends Vehicle{}

class Tank extends Vehicle{}

class suv extends  Car {}
