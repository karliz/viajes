package code.model

/**
 * Created by neto on 04/10/14.
 */

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.model.ForeignKeyAction

case class Viatico(id: Option[Int],
                   viajeId: Int,
                   tipoMonedaId: Int,
                   tarifaDiaria: Int,
                   gastoViáticos: String,
                   instituciónHospedaje: String,
                   nombreHotel: String,
                   fechaEntrada: String,
                   fechaSalida: String,
                   costoHotel: String,
                   montoComprobado: String,
                   montoNoComprobado: String,
                   montoDevuelto: String)

class Viaticos(tag: Tag) extends Table[Viatico](tag, "viáticos") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

  def viajeId = column[Int]("viaje_id")

  def tipoMonedaId = column[Int]("tipo_moneda_id")

  def tarifaDiaria = column[Int]("tarifa_diaria")

  def gastoViáticos = column[String]("gasto_viáticos")

  def instituciónHospedaje = column[String]("institución_hospedaje")

  def nombreHotel = column[String]("nombre_hotel")

  def fechaHotelEntrada = column[String]("fecha_hotel_entrada")

  def fechaHotelSalida = column[String]("fecha_hotel_salida")

  def costoHotel = column[String]("costo_hotel")

  def montoComprobado = column[String]("monto_comprobado")

  def montoNoComprobado = column[String]("monto_no_comprobado")

  def montoDevuelto = column[String]("monto_devuelto")

  def * = (id.?,
    viajeId,
    tipoMonedaId,
    tarifaDiaria,
    gastoViáticos,
    instituciónHospedaje,
    nombreHotel,
    fechaHotelEntrada,
    fechaHotelSalida,
    costoHotel,
    montoComprobado,
    montoNoComprobado,
    montoDevuelto) <>(Viatico.tupled, Viatico.unapply)

  def tipoMonedaFk = foreignKey("viáticos_tipo_moneda", tipoMonedaId, TableQuery[TiposMoneda])(tm => tm.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)

  def viajeFk = foreignKey("viáticos_viaje", viajeId, TableQuery[Viajes])(v => v.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)
}
