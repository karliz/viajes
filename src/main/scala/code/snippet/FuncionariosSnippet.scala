package code.snippet

import code.model._
import net.liftweb.common.{Full, Box, Empty}
import net.liftweb.http.{S, RequestVar, SHtml}

import net.liftweb.util.Helpers._
import scala.slick.driver.MySQLDriver.simple._

import scala.slick.lifted.TableQuery
import scala.xml.Text

/**
 * Created by neto on 29/09/14.
 */

object FuncionarioRequestVar extends RequestVar[Box[Funcionario]](Empty)

class FuncionariosSnippet {

  def table = {

    val funcionarios = DataBase.db.withSession {
      implicit session =>
        DataBase.funcionarios.run
    }

    ".datos-funcionario *" #>
      funcionarios.map(f => "td *" #> List(Text(f.nombreCompleto),
        Text(f.nombreDelCargo),
        Text(f.institución),
        SHtml.link("/funcionarios/detalles", () => FuncionarioRequestVar.set(Full(f)), Text("perfil"))
      ))
  }

  def details = {
    FuncionarioRequestVar.is match {
      case Full(f) =>

        val viajes: Seq[(Viaje, Viatico)] = DataBase.db.withSession {
          implicit session =>
            (for {
              c <- DataBase.comisiones if c.funcionarioId === f.id
              v <- DataBase.viajes if v.comisiónId === c.númeroComisión
              vi <- DataBase.viáticos if vi.viajeId === v.id
            } yield (v, vi)).run
        }


        "h3 *" #> f.nombreCompleto &
          "#funcionario-puesto" #> <h4>
            <small>Puesto:</small>{f.nombreDelPuesto}
          </h4> &
          "#funcionario-cargo" #> <h4>
            <small>Cargo:</small>{f.nombreDelCargo}
          </h4> &
          "#funcionario-email" #> <h4>
            <small>Correo Electrónico:</small>{f.correoElectrónico}
          </h4> &
          "li *" #> viajes.map(v => <li>{ "%s, %s - %s, Gasto de Viáticos: %s".format(v._1.ciudadDestino, v._1.fechaInicioComisión.getOrElse("No disponible"), v._1.fechaFinComisión.getOrElse("No disponible"),v._2.gastoViáticos)}</li>)
      case _ => S.redirectTo("/funcionarios/")
    }
  }
}
