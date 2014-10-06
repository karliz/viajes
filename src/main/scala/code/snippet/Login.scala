package code.snippet

import code.model.{Usuario, DataBase}
import net.liftweb.http.SHtml
import net.liftweb.http.js.{JsCmds, JsCmd}

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._

import scala.slick.driver.MySQLDriver.simple._

/**
 * Created by neto on 05/10/14.
 */
class Login {
  def login = {

    var user = ""
    var pass = ""

    def iniciar(): JsCmd = {
      DataBase.db.withSession {
        implicit session =>
          DataBase.usuarios.filter(u => u.nombreUsuario === user && u.contraseña === pass).firstOption match {
            case Some(u: Usuario) =>
              UsuarioSV.set(Full(u))
              JsCmds.RedirectTo("/")
            case _ =>
              JsCmds.Alert("Credenciales incorrectas")
          }
      }
    }

    "#inputUser" #> SHtml.text("", user = _) &
      "#inputPass" #> SHtml.password("", pass = _) &
      "type=submit" #> SHtml.ajaxOnSubmit(iniciar)

  }
}
