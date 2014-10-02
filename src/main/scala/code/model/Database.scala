package code.model

import code.lib.Valores

import scala.slick.driver.MySQLDriver.simple._
import scala.io.Source

object DataBase {

  val db = Database.forURL("jdbc:mysql://localhost:3306/viajes", "root", "mysql", driver = "com.mysql.jdbc.Driver")

  def initDatabase(): Unit = {

    DataBase.db.withSession {
      implicit session =>
        val funcionarios = TableQuery[Funcionarios]
        val viajes = TableQuery[Viajes]
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
