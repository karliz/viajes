package code.model
import scala.slick.driver.MySQLDriver.simple._


/**
 * Created by neto on 04/10/14.
 */
case class TipoPasaje(id: Option[Int], descripción: String)

class TiposPasaje(tag: Tag) extends Table[TipoPasaje](tag, "tipos_pasaje"){
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def descripción = column[String]("descripción")


  def * = (id.?, descripción) <> (TipoPasaje.tupled, TipoPasaje.unapply)
}

