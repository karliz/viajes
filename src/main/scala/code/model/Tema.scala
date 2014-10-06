package code.model

import scala.slick.driver.MySQLDriver.simple._

/**
 * Created by neto on 04/10/14.
 */

case class Tema(id: Option[Int], descripción: String)

class Temas(tag: Tag) extends Table[Tema](tag, "ctema") {

  /*scala.slick.codegen.SourceCodeGenerator.main(
    Array("scala.slick.driver.MySQLDriver", "com.mysql.jdbc.Driver", "jdbc:mysql://localhost/viajes", "/Users/neto/Developer/IdeaProjects/scala/viajes", "netoooss", "root", "mysql")
  )*/

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def descripción = column[String]("descripción")


  def * = (id.?, descripción) <> (Tema.tupled, Tema.unapply)
}