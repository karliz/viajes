USE viajes;
LOAD DATA INFILE '/Users/neto/Developer/IdeaProjects/scala/viajes/docs/ifai.csv'
INTO TABLE viajes.funcionarios
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(id, institución, nombre, primerApellido, segundoApellido, nombreCompleto, tipoPersonal, nombreDelCargo, nombreDelCargoSuperior, unidadAdministrativa, claveDelPuesto, nombreDelPuesto, correoElectrónico);

LOAD DATA INFILE '/Users/neto/Developer/IdeaProjects/scala/viajes/docs/comisiones.csv'
INTO TABLE viajes.comisiones
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(número_comisión, funcionario_id, mecanismoOrigen_id, institución_generadora, unidad_responsable, tipo_representaciónId, no_acuerdo_autorización, no_oficio, temaId, tipoComisiónId, motivo_comisión, antecedentes_comisión, actividades_realizadas, resultados_obtenidos, contribuciones, link_cominicado);


LOAD DATA INFILE '/Users/neto/Developer/IdeaProjects/scala/viajes/docs/viajes.csv'
INTO TABLE viajes.viajes
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(id, comisión_id, tipo_viaje_id, tipo_pasaje_id, pais_origen, estado_origen, cuidad_origen, pais_destino, estado_destino, cuidad_destino, instituciónCubrePasaje, aerolinea_ida, número_vuelos_ida, aerolinea_vuelta, número_vuelos_vuelta, fecha_inicio_vomisión, fecha_fin_comisión, gasto_pasajes, observaciones);

LOAD DATA INFILE '/Users/neto/Developer/IdeaProjects/scala/viajes/docs/viaticos.csv'
INTO TABLE viajes.viáticos
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(viaje_id, tipo_moneda_id, tarifa_diaria, gasto_viáticos, institución_hospedaje, nombre_hotel, fecha_hotel_entrada, fecha_hotel_salida, costo_hotel, monto_comprobado, monto_no_comprobado, monto_devuelto);

LOAD DATA INFILE '/Users/neto/Developer/IdeaProjects/scala/viajes/docs/eventos.csv'
INTO TABLE viajes.eventos
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(comisión_id, nombre_evento, url_evento, fechaParticipaciónInicio, fechaParticipaciónFin);