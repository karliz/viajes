package code.model

import java.sql.Date

import scala.slick.driver.MySQLDriver.simple._

/**
 * Created by neto on 30/09/14.
 */
case class Viaje(id: Option[Int],
                 comisiónId: String,
                 tipoViajeId: Int,
                 tipoPasajeId: Int,
                 paisOrigen: String,
                 estadoOrigen: String,
                 ciudadOrigen: String,
                 paisDestino: String,
                 estadoDestino: String,
                 ciudadDestino: String,
                 instituciónCubrePasaje: String,
                 aerolineaIda: String,
                 númeroVuelosIda: String,
                 aerolineaVuelta: String,
                 númeroVuelosVuelta: String,
                 fechaInicioComisión: Option[String],
                 fechaFinComisión: Option[String],
                 gastoPasajes: String,
                 observaciones: String)

class Viajes(tag: Tag) extends Table[Viaje](tag, "viajes") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

  def comisiónId = column[String]("comisión_id")

  def tipoViajeId = column[Int]("tipo_viaje_id")

  def tipoPasajeId = column[Int]("tipo_pasaje_id")

  def paisOrigen = column[String]("pais_origen")

  def estadoOrigen = column[String]("estado_origen")

  def ciudadOrigen = column[String]("cuidad_origen")

  def paisDestino = column[String]("pais_destino")

  def estadoDestino = column[String]("estado_destino")

  def ciudadDestino = column[String]("cuidad_destino")

  def instituciónCubrePasaje = column[String]("instituciónCubrePasaje")

  def aerolineaIda = column[String]("aerolinea_ida")

  def númeroVuelosIda = column[String]("número_vuelos_ida")

  def aerolineaVuelta = column[String]("aerolinea_vuelta")

  def númeroVuelosVuelta = column[String]("número_vuelos_vuelta")

  def fechaInicioComisión = column[Option[String]]("fecha_inicio_vomisión")

  def fechaFinComisión = column[Option[String]]("fecha_fin_comisión")

  def gastoPasajes = column[String]("gasto_pasajes")

  def observaciones = column[String]("observaciones")

  def * =
    (id.?,
      comisiónId,
      tipoViajeId,
      tipoPasajeId,
      paisOrigen,
      estadoOrigen,
      ciudadOrigen,
      paisDestino,
      estadoDestino,
      ciudadDestino,
      instituciónCubrePasaje,
      aerolineaIda,
      númeroVuelosIda,
      aerolineaVuelta,
      númeroVuelosVuelta,
      fechaInicioComisión,
      fechaFinComisión,
      gastoPasajes,
      observaciones) <>
      (Viaje.tupled, Viaje.unapply)

  def comisiónFk = foreignKey("viaje_comisión", comisiónId, TableQuery[Comisiones])(c => c.númeroComisión, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)

  def tipoViajeFk = foreignKey("viaje_tipo_viaje", tipoViajeId, TableQuery[TiposViaje])(t => t.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)

  def tipoPasajeFk = foreignKey("viaje_tipo_pasaje", tipoPasajeId, TableQuery[TiposPasaje])(t => t.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)

}