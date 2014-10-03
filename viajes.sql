# LOAD DATA INFILE '/Users/neto/Developer/IdeaProjects/scala/viajes/viajes.csv'
LOAD DATA INFILE '/home/neto/viajes.csv'
INTO TABLE viajes.viajes
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(origen_comisión, ur_solicitante, unidad_responsable, tipo_representación, número_comisión, servidor_público, cargo, grupo_jerárquico, tipo_viaje, no_acuerdo, no_oficio, pais_origen, estado_origen, cuidad_origen, pais_destino, estado_destino, cuidad_destino, tarifa_diaria, monedad, tema, tipo_comisión, nombre_evento, url_evento, @fecha_inicio, @fecha_fin, motivo_comisión, antecedentes, actividades_realizadas, resultados_obtenidos, contribuciones_ifai, link_comunicado, instituciónCubrePasaje, tipo_pasaje, aerolinea_ida, númeroVuelosIda, aerolineaVuelta, númeroVuelosVuelta, @fechaInicioComisión, @fechaTérminoComisión, gastoPasajes, gastoViáticos, institucionCubreHospedaje, nombreHotel, @fechaEntrada, @fechaSalida, gastoTotalHospedaje, montoComprobadoViáticos, montoSinComprobación, montoViáticosDevuelto, observaciones);