CREATE DATABASE `viajes_ifai` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `viajes_ifai`;

CREATE TABLE comisiones
(
    número_comisión VARCHAR(254) PRIMARY KEY NOT NULL,
    funcionario_id INT NOT NULL,
    mecanismoOrigen_id INT NOT NULL,
    institución_generadora VARCHAR(254) NOT NULL,
    unidad_responsable VARCHAR(254) NOT NULL,
    tipo_representaciónId INT NOT NULL,
    no_acuerdo_autorización VARCHAR(254) NOT NULL,
    no_oficio VARCHAR(254) NOT NULL,
    temaId INT NOT NULL,
    tipoComisiónId INT NOT NULL,
    motivo_comisión LONGTEXT NOT NULL,
    antecedentes_comisión LONGTEXT NOT NULL,
    actividades_realizadas LONGTEXT NOT NULL,
    resultados_obtenidos LONGTEXT NOT NULL,
    contribuciones LONGTEXT NOT NULL,
    link_cominicado VARCHAR(254) NOT NULL
);
CREATE TABLE ctema
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripción VARCHAR(254) NOT NULL
);
CREATE TABLE ctipos_comisión
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripción VARCHAR(254) NOT NULL
);
CREATE TABLE ctipos_moneda
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripción VARCHAR(254) NOT NULL
);
CREATE TABLE eventos
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    comisión_id VARCHAR(254) NOT NULL,
    nombre_evento VARCHAR(600) NOT NULL,
    url_evento VARCHAR(254) NOT NULL,
    fechaParticipaciónInicio VARCHAR(254) NOT NULL,
    fechaParticipaciónFin VARCHAR(254) NOT NULL
);
CREATE TABLE funcionarios
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    institución VARCHAR(254) NOT NULL,
    nombre VARCHAR(254) NOT NULL,
    primerApellido VARCHAR(254) NOT NULL,
    segundoApellido VARCHAR(254) NOT NULL,
    nombreCompleto VARCHAR(254) NOT NULL,
    tipoPersonal VARCHAR(254) NOT NULL,
    nombreDelCargo VARCHAR(254) NOT NULL,
    nombreDelCargoSuperior VARCHAR(254) NOT NULL,
    unidadAdministrativa VARCHAR(254) NOT NULL,
    claveDelPuesto VARCHAR(254) NOT NULL,
    nombreDelPuesto VARCHAR(254) NOT NULL,
    correoElectrónico VARCHAR(254) NOT NULL
);
CREATE TABLE mecanismos_origen
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripción VARCHAR(254) NOT NULL
);
CREATE TABLE roles
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripción VARCHAR(254) NOT NULL
);
CREATE TABLE tipos_pasaje
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripción VARCHAR(254) NOT NULL
);
CREATE TABLE tipos_representación
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripción VARCHAR(254) NOT NULL
);
CREATE TABLE tipos_viaje
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripción VARCHAR(254) NOT NULL
);
CREATE TABLE usuarios
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    contraseña VARCHAR(254) NOT NULL,
    nombre_usuario VARCHAR(254) NOT NULL,
    nombre VARCHAR(254) NOT NULL,
    apellido_paterno VARCHAR(254) NOT NULL,
    apellido_materno VARCHAR(254) NOT NULL,
    imagen_perfil VARCHAR(254),
    role_id INT NOT NULL
);
CREATE TABLE viajes
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    comisión_id VARCHAR(254) NOT NULL,
    tipo_viaje_id INT NOT NULL,
    tipo_pasaje_id INT NOT NULL,
    pais_origen VARCHAR(254) NOT NULL,
    estado_origen VARCHAR(254) NOT NULL,
    cuidad_origen VARCHAR(254) NOT NULL,
    pais_destino VARCHAR(254) NOT NULL,
    estado_destino VARCHAR(254) NOT NULL,
    cuidad_destino VARCHAR(254) NOT NULL,
    instituciónCubrePasaje VARCHAR(254) NOT NULL,
    aerolinea_ida VARCHAR(254) NOT NULL,
    número_vuelos_ida VARCHAR(254) NOT NULL,
    aerolinea_vuelta VARCHAR(254) NOT NULL,
    número_vuelos_vuelta VARCHAR(254) NOT NULL,
    fecha_inicio_vomisión VARCHAR(254),
    fecha_fin_comisión VARCHAR(254),
    gasto_pasajes VARCHAR(254) NOT NULL,
    observaciones VARCHAR(254) NOT NULL
);
CREATE TABLE viáticos
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    viaje_id INT NOT NULL,
    tipo_moneda_id INT NOT NULL,
    tarifa_diaria INT NOT NULL,
    gasto_viáticos VARCHAR(254) NOT NULL,
    institución_hospedaje VARCHAR(254) NOT NULL,
    nombre_hotel VARCHAR(254) NOT NULL,
    fecha_hotel_entrada VARCHAR(254) NOT NULL,
    fecha_hotel_salida VARCHAR(254) NOT NULL,
    costo_hotel VARCHAR(254) NOT NULL,
    monto_comprobado VARCHAR(254) NOT NULL,
    monto_no_comprobado VARCHAR(254) NOT NULL,
    monto_devuelto VARCHAR(254) NOT NULL
);
ALTER TABLE comisiones ADD FOREIGN KEY (tipo_representaciónId) REFERENCES tipos_representación (id);
ALTER TABLE comisiones ADD FOREIGN KEY (funcionario_id) REFERENCES funcionarios (id);
ALTER TABLE comisiones ADD FOREIGN KEY (mecanismoOrigen_id) REFERENCES mecanismos_origen (id);
ALTER TABLE comisiones ADD FOREIGN KEY (tipo_representaciónId) REFERENCES ctema (id);
ALTER TABLE comisiones ADD FOREIGN KEY (tipo_representaciónId) REFERENCES ctipos_comisión (id);
CREATE INDEX comisión_funcionario ON comisiones (funcionario_id);
CREATE INDEX comisión_mecanismo_origen ON comisiones (mecanismoOrigen_id);
CREATE INDEX comisión_tipo_representación ON comisiones (tipo_representaciónId);
ALTER TABLE eventos ADD FOREIGN KEY (comisión_id) REFERENCES comisiones (número_comisión);
CREATE INDEX evento_comisión ON eventos (comisión_id);
ALTER TABLE usuarios ADD FOREIGN KEY (role_id) REFERENCES roles (id);
CREATE INDEX usuario_role ON usuarios (role_id);
ALTER TABLE viajes ADD FOREIGN KEY (tipo_viaje_id) REFERENCES tipos_viaje (id);
ALTER TABLE viajes ADD FOREIGN KEY (comisión_id) REFERENCES comisiones (número_comisión);
ALTER TABLE viajes ADD FOREIGN KEY (tipo_pasaje_id) REFERENCES tipos_pasaje (id);
CREATE INDEX viaje_comisión ON viajes (comisión_id);
CREATE INDEX viaje_tipo_pasaje ON viajes (tipo_pasaje_id);
CREATE INDEX viaje_tipo_viaje ON viajes (tipo_viaje_id);
ALTER TABLE viáticos ADD FOREIGN KEY (viaje_id) REFERENCES viajes (id);
ALTER TABLE viáticos ADD FOREIGN KEY (tipo_moneda_id) REFERENCES ctipos_moneda (id);
CREATE INDEX viáticos_tipo_moneda ON viáticos (tipo_moneda_id);
CREATE INDEX viáticos_viaje ON viáticos (viaje_id);
