package Chapter1_basic.typeDesc

/**
  * Created by taos on 2017/5/28.
  */
object Resource {
  type Resource = {
     def close(): Unit
  }
  def closeResource(r: Resource) = r.close()
}
