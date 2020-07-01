package scala.Chapter1_basic.ac
/**
  * Created by taos on 2017/4/18.
  */
class SuperClass {
   protected def f() {println("..")}
}

class SubClass extends SuperClass{
  super.f()
}
class Other{
 // (new SuperClass).f() // 相同包下，非子类不可以访问
}