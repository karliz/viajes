package code.model

import scala.slick.driver.MySQLDriver.simple._

/**
 * Created by neto on 05/10/14.
 */
case class Usuario(id: Option[Int], nombreUsuario: String, contraseña: String, nombre: String, apellidoPaterno: String, apellidoMaterno: String, imagenPerfil: Option[String], roleId: Int)

class Usuarios(tag: Tag) extends Table[Usuario](tag, "usuarios") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

  def contraseña = column[String]("contraseña")

  def nombreUsuario = column[String]("nombre_usuario")

  def nombre = column[String]("nombre")

  def apellidoPaterno = column[String]("apellido_paterno")

  def apellidoMaterno = column[String]("apellido_materno")

  def imagenPerfil = column[Option[String]]("imagen_perfil")

  def roleId = column[Int]("role_id")

  def * = (id.?, contraseña, nombreUsuario, nombre, apellidoPaterno, apellidoMaterno, imagenPerfil, roleId) <> (Usuario.tupled, Usuario.unapply)

  def roleFk = foreignKey("usuario_role", roleId, TableQuery[Roles])(r => r.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)

}