package code.model

import java.sql.Date

import scala.slick.collection.heterogenous._
import syntax._
import scala.slick.driver.MySQLDriver.simple._
import shapeless.Generic

/**
 * Created by neto on 30/09/14.
 */
case class Viaje(id: Option[Int],
                                origenComisión: String,
                                urSolicitante: String,
                                unidadResponsable: String,
                                tipoRepresentación: String,
                                númeroComisión: String,
                                servidorPúblico: String,
                                cargo: String,
                                grupoJerárquico: String,
                                tipoViaje: String,
                                noAcuerdo: String,
                                noOficio: String,
                                paisOrigen: String,
                                estadoOrigen: String,
                                ciudadOrigen: String,
                                paisDestino: String,
                                estadoDestino: String,
                                ciudadDestino: String,
                                tarifaDiaria: Int,
                                monedad: String,
                                tema: String,
                                tipoComisión: String,
                                nombreEvento: String,
                                urlEvento: String,
                                fechaInicio: String,
                                fechaFin: String,
                                motivoComisión: String,
                                antecedentes: String,
                                actividadesRealizadas: String,
                                resultadosObtenidos: String,
                                contribucionesIFAI: String,
                                linkComunicado: String,
                                instituciónCubrePasaje: String,
                                tipoPasaje: String,
                                aerolineaIda: String,
                                númeroVuelosIda: String,
                                aerolineaVuelta: String,
                                númeroVuelosVuelta: String,
                                fechaInicioComisión: String,
                                fechaTérminoComisión: String,
                                gastoPasajes: String,
                                gastoViáticos: String,
                                institucionCubreHospedaje: String,
                                nombreHotel: String,
                                fechaEntrada: String,
                                fechaSalida: String,
                                gastoTotalHospedaje: String,
                                montoComprobadoViáticos: String,
                                montoSinComprobación: String,
                                montoViáticosDevuelto: String,
                                observaciones: String
                                 )

class Viajes(tag:Tag) extends Table[Viaje](tag,"VIAJES") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

  def origenComisión = column[String]("origen_comisión")

  def urSolicitante = column[String]("ur_solicitante")

  def unidadResponsable = column[String]("unidad_responsable")

  def tipoRepresentación = column[String]("tipo_representación")

  def númeroComisión = column[String]("número_comisión")

  def servidorPúblico = column[String]("servidor_público")

  def cargo = column[String]("cargo")

  def grupoJerárquico = column[String]("grupo_jerárquico")

  def tipoViaje = column[String]("tipo_viaje")

  def noAcuerdo = column[String]("no_acuerdo")

  def noOficio = column[String]("no_oficio")

  def paisOrigen = column[String]("pais_origen")

  def estadoOrigen = column[String]("estado_origen")

  def ciudadOrigen = column[String]("cuidad_origen")

  def paisDestino = column[String]("pais_destino")

  def estadoDestino = column[String]("estado_destino")

  def ciudadDestino = column[String]("cuidad_destino")

  def tarifaDiaria = column[Int]("tarifa_diaria")

  def monedad = column[String]("monedad")

  def tema = column[String]("tema")

  def tipoComisión = column[String]("tipo_comisión")

  def nombreEvento = column[String]("nombre_evento")

  def urlEvento = column[String]("url_evento")

  def fechaInicio = column[String]("fecha_inicio")

  def fechaFin = column[String]("fecha_fin")

  def motivoComisión = column[String]("motivo_comisión")

  def antecedentes = column[String]("antecedentes")

  def actividadesRealizadas = column[String]("actividades_realizadas")

  def resultadosObtenidos = column[String]("resultados_obtenidos")

  def contribucionesIFAI = column[String]("contribuciones_ifai")

  def linkComunicado = column[String]("link_comunicado")

  def instituciónCubrePasaje = column[String]("instituciónCubrePasaje")

  def tipoPasaje = column[String]("tipo_pasaje")

  def aerolineaIda = column[String]("aerolinea_ida")

  def númeroVuelosIda = column[String]("númeroVuelosIda")

  def aerolineaVuelta = column[String]("aerolineaVuelta")

  def númeroVuelosVuelta = column[String]("númeroVuelosVuelta")

  def fechaInicioComisión = column[String]("fechaInicioComisión")

  def fechaTérminoComisión = column[String]("fechaTérminoComisión")

  def gastoPasajes = column[String]("gastoPasajes")

  def gastoViáticos = column[String]("gastoViáticos")

  def institucionCubreHospedaje = column[String]("institucionCubreHospedaje")

  def nombreHotel = column[String]("nombreHotel")

  def fechaEntrada = column[String]("fechaEntrada")

  def fechaSalida = column[String]("fechaSalida")

  def gastoTotalHospedaje = column[String]("gastoTotalHospedaje")

  def montoComprobadoViáticos = column[String]("montoComprobadoViáticos")

  def montoSinComprobación = column[String]("montoSinComprobación")

  def montoViáticosDevuelto = column[String]("montoViáticosDevuelto")

  def observaciones = column[String]("observaciones")

  private def iso[L <: HList, M <: HList](l: L)
                                         (implicit iso: Generic.Aux[Viaje, M], eq: L =:= M): Viaje = iso.from(l)

  def * =
    (id.? ::
      origenComisión ::
      urSolicitante ::
      unidadResponsable ::
      tipoRepresentación ::
      númeroComisión ::
      servidorPúblico ::
      cargo ::
      grupoJerárquico ::
      tipoViaje ::
      noAcuerdo ::
      noOficio ::
      paisOrigen ::
      estadoOrigen ::
      ciudadOrigen ::
      paisDestino ::
      estadoDestino ::
      ciudadDestino ::
      tarifaDiaria ::
      monedad ::
      tema ::
      tipoComisión ::
      nombreEvento ::
      urlEvento ::
      fechaInicio ::
      fechaFin ::
      motivoComisión ::
      antecedentes ::
      actividadesRealizadas ::
      resultadosObtenidos ::
      contribucionesIFAI ::
      linkComunicado ::
      instituciónCubrePasaje ::
      tipoPasaje ::
      aerolineaIda ::
      númeroVuelosIda ::
      aerolineaVuelta ::
      númeroVuelosVuelta ::
      fechaInicioComisión ::
      fechaTérminoComisión ::
      gastoPasajes ::
      gastoViáticos ::
      institucionCubreHospedaje ::
      nombreHotel ::
      fechaEntrada ::
      fechaSalida ::
      gastoTotalHospedaje ::
      montoComprobadoViáticos ::
      montoSinComprobación ::
      montoViáticosDevuelto ::
      observaciones ::
      HNil).shaped <>
      ( {
        case x => Viaje(
          x(0),
          x(1),
          x(2),
          x(3),
          x(4),
          x(5),
          x(6),
          x(7),
          x(8),
          x(9),
          x(10),
          x(11),
          x(12),
          x(13),
          x(14),
          x(15),
          x(16),
          x(17),
          x(18),
          x(19),
          x(20),
          x(21),
          x(22),
          x(23),
          x(24),
          x(25),
          x(26),
          x(27),
          x(28),
          x(29),
          x(30),
          x(31),
          x(32),
          x(33),
          x(34),
          x(35),
          x(36),
          x(37),
          x(38),
          x(39),
          x(40),
          x(41),
          x(42),
          x(43),
          x(44),
          x(45),
          x(46),
          x(47),
          x(48),
          x(49),
          x(50)
        )
      }, ({ v: Viaje =>
        Option((
          v.id ::
            v.origenComisión ::
            v.urSolicitante ::
            v.unidadResponsable ::
            v.tipoRepresentación ::
            v.númeroComisión ::
            v.servidorPúblico ::
            v.cargo ::
            v.grupoJerárquico ::
            v.tipoViaje ::
            v.noAcuerdo ::
            v.noOficio ::
            v.paisOrigen ::
            v.estadoOrigen ::
            v.ciudadOrigen ::
            v.paisDestino ::
            v.estadoDestino ::
            v.ciudadDestino ::
            v.tarifaDiaria ::
            v.monedad ::
            v.tema ::
            v.tipoComisión ::
            v.nombreEvento ::
            v.urlEvento ::
            v.fechaInicio ::
            v.fechaFin ::
            v.motivoComisión ::
            v.antecedentes ::
            v.actividadesRealizadas ::
            v.resultadosObtenidos ::
            v.contribucionesIFAI ::
            v.linkComunicado ::
            v.instituciónCubrePasaje ::
            v.tipoPasaje ::
            v.aerolineaIda ::
            v.númeroVuelosIda ::
            v.aerolineaVuelta ::
            v.númeroVuelosVuelta ::
            v.fechaInicioComisión ::
            v.fechaTérminoComisión ::
            v.gastoPasajes ::
            v.gastoViáticos ::
            v.institucionCubreHospedaje ::
            v.nombreHotel ::
            v.fechaEntrada ::
            v.fechaSalida ::
            v.gastoTotalHospedaje ::
            v.montoComprobadoViáticos ::
            v.montoSinComprobación ::
            v.montoViáticosDevuelto ::
            v.observaciones ::
            HNil
          ))
      }))

}