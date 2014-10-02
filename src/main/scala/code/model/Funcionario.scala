package code.model


import scala.slick.driver.MySQLDriver.simple._

/**
 * Created by neto on 29/09/14.
 */
case class Funcionario(id: Option[Int], institución: String, nombre: String, primerApellido: String, segundoApellido: String,
                       nombreCompleto: String, tipoPersonal: String, nombreDelCargo: String,
                       nombreDelCargoSuperior: String, unidadAdministrativa: String, claveDelPuesto: String,
                       nombreDelPuesto: String, correoElectrónico: String)

class Funcionarios(tag: Tag) extends Table[Funcionario](tag, "FUNCIONARIOS") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def institición = column[String]("institición")
  def nombre = column[String]("nombre")
  def primerApellido = column[String]("primerApellido")
  def segundoApellido = column[String]("segundoApellido")
  def nombreCompleto = column[String]("nombreCompleto")
  def tipoPersonal = column[String]("tipoPersonal")
  def nombreDelCargo = column[String]("nombreDelCargo")
  def nombreDelCargoSuperior = column[String]("nombreDelCargoSuperior")
  def unidadAdministrativa = column[String]("unidadAdministrativa")
  def claveDelPuesto = column[String]("claveDelPuesto")
  def nombreDelPuesto = column[String]("nombreDelPuesto")
  def correoElectrónico = column[String]("correoElectrónico")


  def * = (id.?, institición, nombre, primerApellido, segundoApellido, nombreCompleto, tipoPersonal, nombreDelCargo, nombreDelCargoSuperior, unidadAdministrativa, claveDelPuesto, nombreDelPuesto, correoElectrónico) <> (Funcionario.tupled, Funcionario.unapply)
}

object Funcionario extends ((Option[Int], String, String, String, String, String, String, String, String, String, String, String, String) => Funcionario){

  val funcionarios = TableQuery[Funcionarios]
  val db = DataBase.db

  def all: List[Funcionario] = {
    db.withSession{
      implicit session =>
        funcionarios.list
    }
  }
}