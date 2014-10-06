package code.model

import scala.slick.driver.MySQLDriver.simple._

/**
 * Created by neto on 05/10/14.
 */

case class Comisión(númeroComisión: Option[String],
                    funcionarioId: Int,
                    mecanismoOrigenId: Int,
                    instituciónGeneradora: String,
                    unidadResponsable: String,
                    tipoRepresentaciónId: Int,
                    noAcuerdoAutorización: String,
                    noOficio: String,
                    temaId: Int,
                    tipoComisiónId: Int,
                    motivoComisión: String,
                    antecedentesComisión: String,
                    actividadesRealizadas: String,
                    resultadosObtenidos: String,
                    contribuciones: String,
                    linkCominicado: String)

class Comisiones(tag: Tag) extends Table[Comisión](tag, "comisiones") {

  def númeroComisión = column[String]("número_comisión", O.PrimaryKey)

  def funcionarioId = column[Int]("funcionario_id")

  def mecanismoOrigenId = column[Int]("mecanismoOrigen_id")

  def instituciónGeneradora = column[String]("institución_generadora")

  def unidadResponsable = column[String]("unidad_responsable")

  def tipoRepresentaciónId = column[Int]("tipo_representaciónId")

  def noAcuerdoAutorización = column[String]("no_acuerdo_autorización")

  def noOficio = column[String]("no_oficio")

  def temaId = column[Int]("temaId")

  def tipoComisiónId = column[Int]("tipoComisiónId")

  def motivoComisión = column[String]("motivo_comisión", O.DBType("TEXT"))

  def antecedentesComisión = column[String]("antecedentes_comisión", O.DBType("TEXT"))

  def actividadesRealizadas = column[String]("actividades_realizadas", O.DBType("TEXT"))

  def resultadosObtenidos = column[String]("resultados_obtenidos", O.DBType("TEXT"))

  def contribuciones = column[String]("contribuciones", O.DBType("TEXT"))

  def linkCominicado = column[String]("link_cominicado")

  def * = (númeroComisión.?,
    funcionarioId,
    mecanismoOrigenId,
    instituciónGeneradora,
    unidadResponsable,
    tipoRepresentaciónId,
    noAcuerdoAutorización,
    noOficio,
    temaId,
    tipoComisiónId,
    motivoComisión,
    antecedentesComisión,
    actividadesRealizadas,
    resultadosObtenidos,
    contribuciones,
    linkCominicado) <>(Comisión.tupled, Comisión.unapply)

  def funcionarioFk = foreignKey("comisión_funcionario", funcionarioId, TableQuery[Funcionarios])(f => f.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)

  def mecanismoOrigenFk = foreignKey("comisión_mecanismo_origen", mecanismoOrigenId, TableQuery[MecanismosOrigen])(m => m.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)

  def tipoRepresentaciónFk = foreignKey("comisión_tipo_representación", tipoRepresentaciónId, TableQuery[TiposRepresentación])(t => t.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)

  def temaComisiónFk = foreignKey("comisión_tema", tipoRepresentaciónId, TableQuery[Temas])(t => t.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)

  def tipoComisiónFk = foreignKey("comisión_tipo", tipoRepresentaciónId, TableQuery[TiposComisión])(t => t.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)

}
