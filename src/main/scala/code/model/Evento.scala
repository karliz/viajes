package code.model

import scala.slick.driver.MySQLDriver.simple._

/**
 * Created by neto on 05/10/14.
 */

case class Evento(id: Option[Int],
                  comisiónId: String,
                  nombreEvento: String,
                  urlEvento: String,
                  fechaParticipaciónInicio: String,
                  fechaParticipaciónFin: String)

class Eventos(tag: Tag) extends Table[Evento](tag, "eventos") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

  def comisiónId = column[String]("comisión_id")

  def nombreEvento = column[String]("nombre_evento", O.DBType("VARCHAR(600)"))

  def urlEvento = column[String]("url_evento")

  def fechaParticipaciónInicio = column[String]("fechaParticipaciónInicio")

  def fechaParticipaciónFin = column[String]("fechaParticipaciónFin")

  def * = (id.?,
    comisiónId,
    nombreEvento,
    urlEvento,
    fechaParticipaciónInicio,
    fechaParticipaciónFin) <> (Evento.tupled, Evento.unapply)

  def comisiónFk = foreignKey("evento_comisión", comisiónId, TableQuery[Comisiones])(c => c.númeroComisión, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)

}
