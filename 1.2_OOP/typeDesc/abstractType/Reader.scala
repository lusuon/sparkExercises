package com.esoft.typeDesc.abstractType

import java.io.File
import javax.imageio.ImageIO
import scala.io.Source
import java.awt.image.BufferedImage
/**
  * Created by taos on 2017/5/28.
  */
trait Reader {
  type Contents
  def read(fileName: String): Contents
}

class StringReader extends Reader {
  type Contents = String
  def read(fileName: String):Contents = Source.fromFile(fileName, "UTF-8").mkString
}

class ImageReader extends Reader {
  type Contents = BufferedImage
  def read(fileName: String):Contents = ImageIO.read(new File(fileName))
}
