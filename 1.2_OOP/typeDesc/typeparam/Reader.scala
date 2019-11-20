package com.esoft.typeDesc.typeparam

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

import scala.io.Source

/**
  * Created by taoshi on 2017/5/28.
  */
trait Reader[T] {
  def read(fileName: String): T
}

class StringReader extends Reader[String]{
  def read(fileName: String) = Source.fromFile(fileName, "UTF-8").mkString
}

//写出ImageReader 的实现类
class ImageReader extends Reader[BufferedImage] {
  override def read(fileName: String) = {
    ImageIO.read(new File(fileName))
  }
}