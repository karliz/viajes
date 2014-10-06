package code.model

import scala.slick.driver.MySQLDriver.simple._
/**
 * Created by neto on 04/10/14.
 */

case class TipoRepresentacion(id: Option[Int], descripción: String)

class TiposRepresentacion(tag: Tag) extends Table[TipoRepresentacion](tag, "tipos_representación") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def descripción = column[String]("descripción")


  def * = (id.?, descripción) <> (TipoRepresentacion.tupled, TipoRepresentacion.unapply)
}

