package code.model

import scala.slick.driver.MySQLDriver.simple._

/**
 * Created by neto on 05/10/14.
 */
case class Role(id: Option[Int], descripción: String)

class Roles(tag: Tag) extends Table[Role](tag, "roles") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

  def descripción = column[String]("descripción")

  def * = (id.?, descripción) <> (Role.tupled, Role.unapply)
}
