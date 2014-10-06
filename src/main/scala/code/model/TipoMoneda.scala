package code.model

import scala.slick.driver.MySQLDriver.simple._

/**
 * Created by neto on 04/10/14.
 */
case class TipoMoneda(id: Option[Int], descripción: String)

class TiposMoneda(tag: Tag) extends Table[TipoMoneda](tag, "ctipos_moneda"){
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def descripción = column[String]("descripción")


  def * = (id.?, descripción) <> (TipoMoneda.tupled, TipoMoneda.unapply)

}
