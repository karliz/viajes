package code.model

import scala.slick.driver.MySQLDriver.simple._
/**
 * Created by neto on 04/10/14.
 */

case class TipoRepresentación(id: Option[Int], descripción: String)

class TiposRepresentación(tag: Tag) extends Table[TipoRepresentación](tag, "tipos_representación") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def descripción = column[String]("descripción")


  def * = (id.?, descripción) <> (TipoRepresentación.tupled, TipoRepresentación.unapply)
}

