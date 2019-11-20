package com.esoft.typeDesc.obs

/**
  * Created by taos on 2017/5/17.
  */
trait Subject {
  type Handler
  protected var callbacks = Map[Handler, this.type => Unit]()

  /**
    * 订阅
    */
  def attach(callback: this.type => Unit): Handler = {
    val handle = createHandle(callback)
    // 将key=handle,value=callback的键值对加入到map中。
    callbacks += (handle -> callback)
    handle
  }

  /**
    * 退订
    */
  def detach(handle: Handler): Unit = {
    callbacks -= handle
  }

  /**
    * 创建Handler
    */
  protected def createHandle(callback: this.type => Unit): Handler

  /**
    * 通知所有监听者
    */
  protected def notifyListenners(): Unit =
    for (callback <- callbacks.values) callback(this)
  // println(this)

}
