package com.esoft.func
import scala.reflect.runtime.universe
/**
  * Created by taos on 2017/11/14.
  */
object FuncReflecUtils {

  def functor[R](className: String, methodName: String) = {
    val m = universe.runtimeMirror(getClass.getClassLoader)
    val clazz = Class.forName(className)
    val symbol = m.classSymbol(clazz)
    val tt = symbol.typeSignature.members

  val method = tt.filter(x => x.isMethod && x.name.toString == methodName).head.asMethod
    val call = m.reflect(clazz.newInstance()).reflectMethod(method)
    (call.apply _) andThen(_.asInstanceOf[R])
  }
  def _functor[R](className: String, methodName: String) = {
    val m = universe.runtimeMirror(getClass.getClassLoader)
    val clazz = Class.forName(className)
    val symbol = m.moduleSymbol(clazz)
    val method = symbol.typeSignature.members
                 .filter(x => x.isMethod && x.name.toString == methodName).head.asMethod
    val call = m.reflect(m.reflectModule(symbol).instance).reflectMethod(method)
    (call.apply _) andThen (_.asInstanceOf[R])
  }
}
object Testor{
  def main(args: Array[String]): Unit = {
    val f = FuncReflecUtils.functor[Int]("com.esoft.func.Fun","add")
    val l = f(Seq(10,11))
    print(l)
  }
}

class Fun {
  def add(x : Int, y: Int) = x + y
}