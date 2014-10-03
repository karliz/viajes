package code.snippet

import code.model.{Funcionarios, Viajes, DataBase, Funcionario}
import dispatch._, Defaults._
import net.liftweb.common.{Full, Box, Empty}
import net.liftweb.http.{S, RequestVar, SHtml}

import net.liftweb.util.Helpers._

import scala.slick.lifted.TableQuery
import scala.xml.Text

/**
 * Created by neto on 29/09/14.
 */

object FuncionarioRequestVar extends RequestVar[Box[Funcionario]](Empty)

class FuncionariosSnippet {

  def table = {

    val funcionarios = DataBase.db.withSession{
      implicit sesion =>
        DataBase.funcionarios.filter(_.id === 1)
          .map(p => ())
    }

    ".datos-funcionario *" #>
      funcionarios.map( f => "td *" #> List(Text(f.nombreCompleto),
        Text(f.nombreDelCargo),
        Text(f.institución),
        SHtml.link("/funcionarios/detalles", () => FuncionarioRequestVar.set(Full(f)), Text("perfil"))
        ))
  }

  def details = {
    FuncionarioRequestVar.is match {
      case Full(f) =>

        val viajesQuery = TableQuery[Viajes]
        val funcionariosQuery = TableQuery[Funcionarios]


        "h3 *" #> f.nombreCompleto &
        "#funcionario-puesto" #> <h4><small>Puesto: </small>{f.nombreDelPuesto}</h4> &
        "#funcionario-cargo" #> <h4><small>Cargo: </small>{f.nombreDelCargo}</h4> &
        "#funcionario-email" #> <h4><small>Correo Electrónico: </small>{f.correoElectrónico}</h4> &
        "li *" #> <li>{}</li>
      case _ => S.redirectTo("/funcionarios/")
    }
  }
}
