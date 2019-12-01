package Chapter1_basic.ac.overridetest
// traint的extend不需要override
trait T{
  def foo : String
  def bar : String
}

class TB extends T{
  def foo: String = {
    "TB.foo"
  }
  def bar: String = "TB.bar"
}

trait TT extends T{
  override def bar() : String = "TT.bar"
}

class TTB extends TT{
   def foo: String = "TTB.foo"

   override def bar: String = "TTB.bar"
}


/**
  * TT和TTB的例子也是说明了下trait继承trait是不需要使用override的。
  *
  */
class Override2 {}
object Override2 extends App {

}
