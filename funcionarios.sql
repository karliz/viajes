# LOAD DATA INFILE '/Users/neto/Developer/IdeaProjects/scala/viajes/viajes.csv'
LOAD DATA INFILE '/home/neto/funcionarios.csv'
INTO TABLE viajes.funcionarios
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(institición, nombre, primerApellido, segundoApellido, nombreCompleto, tipoPersonal, nombreDelCargo, nombreDelCargoSuperior, unidadAdministrativa, claveDelPuesto, nombreDelPuesto, correoElectrónico);