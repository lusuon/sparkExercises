package Chapter1_basic.traitDemo

// trait重新定义方法log,方法内部将从Exception中获得来的异常信息打印出来
// 那么其他类继承这个特质时也同时继承了Exception
trait LoggedException extends Exception with Logged {
  def log(){log(getMessage)}
}

class UnhappyException extends LoggedException{
  override def log(): Unit = "on my gad"
}

class happyException extends LoggedException{
  override def log(): Unit = "im happy exception"
}

// 特质并没有扩展Exception，而是有一个自身类型，在特质的方法中我们便可以调用该自身方法的任何方法；
trait ExceptionLogged extends Logged{
  //this:Exception => Unit
  self:Exception =>

  override def log(msg: String): Unit = {
    log(getMessage())
  }
}
class TraitTest3 {

  // SavingAccount不是Exception的子类，而Exception是ExceptionLogged的自身类型。
  // 所以这里会报错。
  /*val f = new SavingAccount with ExceptionLogged {
    override def log(msg: String): Unit = super.log(msg)
  }*/

}
