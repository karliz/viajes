package code.model

import code.lib.Valores

import scala.slick.driver.MySQLDriver.simple._
import scala.io.Source

object DataBase {

  val db = Database.forURL("jdbc:mysql://localhost:3306/viajes", "root", "mysql", driver = "com.mysql.jdbc.Driver")
  val funcionarios = TableQuery[Funcionarios]
  val viajes = TableQuery[Viajes]

  def initDatabase(): Unit = {

    DataBase.db.withSession {
      implicit session =>
        try {
          (viajes.ddl  ++ funcionarios.ddl).create
          println("")
        } catch {
          case ex: Exception =>
            println("")
        }
    }
  }

}
