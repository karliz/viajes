package code.snippet

import net.liftweb.common.{Box, Full, Empty}
import net.liftweb.http.{RequestVar, SHtml}
import net.liftweb.util.Helpers._

import code.model.{Comisión, DataBase}

import scala.slick.driver.MySQLDriver.simple._

import scala.xml.Text

/**
 * Created by neto on 05/10/14.
 */

object ComisiónRV extends RequestVar[Box[Comisión]](Empty)

class ComisionesSnippet {

  def table = {
    val comisiones: Seq[(String, String, String, String, String, String, Comisión)] = DataBase.db.withSession {
      implicit session =>
        (for {
          (c, f) <- DataBase.comisiones leftJoin DataBase.funcionarios on (_.funcionarioId === _.id)
          (_, tr) <- DataBase.comisiones leftJoin DataBase.tiposRepresentación on (_.tipoRepresentaciónId === _.id)
          (_, tema) <- DataBase.comisiones leftJoin DataBase.temas on (_.temaId === _.id)
          (_, tc) <- DataBase.comisiones leftJoin DataBase.tiposComisiones on (_.tipoComisiónId === _.id)
        } yield (c.númeroComisión, f.nombre, tr.descripción, tema.descripción, tc.descripción, c.linkCominicado, c)).run
    }
    ".datos-comision *" #>
      comisiones.map(c => "td *" #> List(Text(c._1),
        Text(c._2),
        Text(c._3),
        Text(c._4),
        Text(c._5),
        <a href={c._6}>{c._6}</a>,
        SHtml.link("/admin/comisiones/detalles", () => ComisiónRV.set(Full(c._7)), Text("editar"))
      ))
  }

  def detalles =  {

  }
}
