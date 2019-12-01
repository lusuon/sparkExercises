package Chapter1_basic.traitDemo

trait Iterator[A] {
  def hasNext:Boolean
  def next:A
}

trait ogger {
  def log(msg : String) = println(msg)
}

class IntIterator(to:Int) extends Iterator[Int] {

  private var current:Int = 0;

  override def hasNext = current < to

  override def next = {
    //log("next start...")
    if(hasNext) {
      val t = current
      current += 1
      t
    }else 0
  }
}

object TraintTest {

  def main(args: Array[String]): Unit = {
//    val it = new IntIterator(10)
//    while(it.hasNext) println(it.next)

    val it2 = new IntIterator(10) with ogger
    it2.log("finish!")
  }
}
