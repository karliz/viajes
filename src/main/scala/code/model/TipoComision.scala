package code.model

import scala.slick.driver.MySQLDriver.simple._

/**
 * Created by neto on 04/10/14.
 */

case class TipoComision(id: Option[Int], descripción: String)

class TiposComision(tag: Tag) extends Table[TipoComision](tag, "ctipos_comisión") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def descripción = column[String]("descripción")


  def * = (id.?, descripción) <> (TipoComision.tupled, TipoComision.unapply)
}