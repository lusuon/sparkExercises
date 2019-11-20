package com.esoft.typeDesc.obs

/**
  * Created by taos on 2017/5/17.
  */
trait DefaultHandles extends Subject {

  type Handler = (this.type => Unit)

  override protected def createHandle(callback: Handler): Handler = callback

}
