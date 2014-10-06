package code.snippet

import code.model.Usuario
import net.liftweb.common.{Full, Box, Empty}
import net.liftweb.http.{SHtml, SessionVar}
import net.liftweb.util.Helpers._

import scala.xml.Text

/**
 * Created by neto on 05/10/14.
 */

object UsuarioSV extends SessionVar[Box[Usuario]](Empty)

class MiMenu {

  def render = {
    "#menu-login" #> (UsuarioSV.is match {
      case Full(u) => SHtml.link("/", () => UsuarioSV.set(Empty), Text("Salir"))
      case _ => <a href="/login">Iniciar Sesión</a>
    })

  }

}
