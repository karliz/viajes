package code.model

import scala.slick.driver.MySQLDriver.simple._

/**
 * Created by neto on 04/10/14.
 */

case class TipoComisión(id: Option[Int], descripción: String)

class TiposComisión(tag: Tag) extends Table[TipoComisión](tag, "ctipos_comisión") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def descripción = column[String]("descripción")


  def * = (id.?, descripción) <> (TipoComisión.tupled, TipoComisión.unapply)
}