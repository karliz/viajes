package code.model

import scala.slick.driver.MySQLDriver.simple._

/**
 * Created by neto on 04/10/14.
 */
case class TipoViaje(id: Option[Int], descripción: String)

class TiposViaje(tag: Tag) extends Table[TipoViaje](tag, "tipos_viaje"){
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def descripción = column[String]("descripción")


  def * = (id.?, descripción) <> (TipoViaje.tupled, TipoViaje.unapply)
}
