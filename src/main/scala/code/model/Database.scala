package code.model

import com.zaxxer.hikari.{HikariDataSource, HikariConfig}

import scala.slick.driver.MySQLDriver.simple._

object DataBase {

  Class.forName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource")
  Class.forName("com.mysql.jdbc.Driver")


  private val config = new HikariConfig()
  config.setMaximumPoolSize(10)
  config.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource")
  config.addDataSourceProperty("serverName", "localhost")
  config.addDataSourceProperty("port", "3306")
  config.addDataSourceProperty("databaseName", "viajes")
  config.addDataSourceProperty("user", "root")
  config.addDataSourceProperty("password", "neto")

  val ds = new HikariDataSource(config)



  //  val db = Database.forURL("jdbc:mysql://localhost:3306/viajes", "root", "mysql", driver = "com.mysql.jdbc.Driver")
//  val db = Database.forURL("jdbc:mysql://localhost:3306/viajes", "root", "neto", driver = "com.mysql.jdbc.Driver")
  val db = Database.forDataSource(ds)
  val funcionarios = TableQuery[Funcionarios]
  val viajes = TableQuery[Viajes]

  def initDatabase(): Unit = {

    DataBase.db.withSession {
      implicit session =>
        try {
          (viajes.ddl  ++ funcionarios.ddl).create
          println("Tablas creadas correctamente")
        } catch {
          case ex: Exception =>
            println(ex.getMessage)
        }
    }
  }

}
