package bootstrap.liftweb

import code.model.DataBase
import net.liftweb._
import util._
import Helpers._

import common._
import http._
import js.jquery.JQueryArtifacts
import sitemap._
import Loc._
import mapper._

import net.liftmodules.JQueryModule

import scala.xml.Text;


/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot {
  def boot {

    // Database init
    DataBase.initDatabase()

    // where to search snippet
    LiftRules.addToPackages("code")

    // Build SiteMap

    // Mapa del Sitio
    def sitemap = SiteMap(

      // Menu para ver mensajes
      Menu.i("Index") / "index" / ** >> Title(i => Text("Home Page")),

      // Menu para ver mensajes
      Menu.i("Funcionarios") / "funcionarios" / ** >> Title(i => Text("Funcionarios")),

      // Menu para ver cargos
      Menu.i("Cargos") / "cargos" / ** >> Title(i => Text("Cargos Pages"))/* >> BootHelpers.loggedIn*/,

      // Menu para ver mensajes
      Menu.i("Mensajes") / "mensajes" / ** >> Title(i => Text("Mensajes Stuff")),

      // Menu para ver las areas, los "**" quieren decir que también podemos ver los subdirectorios
      Menu.i("Areas") / "areas" / ** >> LocGroup("areas") >> Title(i => Text("Areas Stuff")),

      // Menu para ver los trabajadores de alguna area en particular
      Menu.i("Trabajadores") / "trabajadores" / ** >> LocGroup("trabajadores") >> Title(i => Text("Trabajadores Stuff")),

      // Menu para modificar el subsistema
      Menu.i("Subsistema") / "subsistemas" / ** >> Title(i => Text("Subsistemas Stuff")),

      // Menu para cerrar la sesión
      Menu.i("CerrarSesión") / "salir" >> Title(i => Text("Cerrar Sesión")),

      Menu(Loc("Static", Link(List("static"), true, "/static/index"),
        "Static Content"))

    )


    LiftRules.setSiteMap(sitemap)

    //Show the spinny image when an Ajax call starts
    LiftRules.ajaxStart =
      Full(() => LiftRules.jsArtifacts.show("ajax-loader").cmd)
    
    // Make the spinny image go away when it ends
    LiftRules.ajaxEnd =
      Full(() => LiftRules.jsArtifacts.hide("ajax-loader").cmd)

    // Force the request to be UTF-8
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))

    LiftRules.loggedInTest = Full(() => true)

    // Use HTML5 for rendering
    LiftRules.htmlProperties.default.set((r: Req) =>
      new Html5Properties(r.userAgent))    

  }
}
