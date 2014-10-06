package code.model


import scala.slick.driver.MySQLDriver.simple._

/**
 * Created by neto on 04/10/14.
 */

case class MecanismoOrigen(id: Option[Int], descripción: String)

class MecanismosOrigen(tag: Tag) extends Table[MecanismoOrigen](tag, "mecanismos_origen") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def descripción = column[String]("descripción")


  def * = (id.?, descripción) <> (MecanismoOrigen.tupled, MecanismoOrigen.unapply)
}
