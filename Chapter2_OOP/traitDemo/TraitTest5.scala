package Chapter1_basic.traitDemo

class A{
  println("查看调用顺序A")
  def m(s:String) = println(s"A($s)")
}
trait B extends A{
  println("查看调用顺序B")
  override def m(s:String) = super.m(s"B($s)")
}
trait C extends A{
  println("查看调用顺序C")
  override def m(s:String) = super.m(s"C($s)")
}
trait D extends A{
  println("查看调用顺序D")
  override def m(s:String) = super.m(s"D($s)")
}
trait E extends C{
  println("查看调用顺序E")
  override def m(s:String) = super.m(s"E($s)")
}
trait F extends C{
  println("查看调用顺序F")
  override def m(s:String) = super.m(s"F($s)")
}
class G extends D with E with F with B{
  println("查看调用顺序G")
  override def m(s:String) = super.m(s"G($s)")
}

object TraitTest5 extends App {
  val x = new G
  x.m("")
}
