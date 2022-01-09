-- CREATE BATABASE
DROP DATABASE IF EXISTS `actividades`;
CREATE DATABASE actividades;
USE actividades;

-- CREATE TABLES
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
	id int AUTO_INCREMENT PRIMARY KEY,
	login VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  perfilAcceso VARCHAR(45) NOT NULL
);

DROP TABLE IF EXISTS `actividades`;
CREATE TABLE `actividades` (
	id int AUTO_INCREMENT PRIMARY KEY,
	titulo VARCHAR(100) NOT NULL,
  descripcion TEXT NOT NULL,
	recomendaciones TEXT NOT NULL,
	docentes VARCHAR(250) NOT NULL,
	dias VARCHAR(60) NOT NULL,
	horario VARCHAR(20) NOT NULL,
	fechaInicio DATE NOT NULL,
	fechaFin DATE NOT NULL
);

CREATE TABLES
DROP TABLE IF EXISTS `ficheros`;
CREATE TABLE `ficheros` (
	id int AUTO_INCREMENT PRIMARY KEY,
	titulo VARCHAR(100) NOT NULL,
  ruta VARCHAR(250) NOT NULL,
	idActividad INT NOT NULL,
	idUsuario INT NULL,
	CONSTRAINT idActividad_ficheros_FK FOREIGN KEY (idActividad) REFERENCES `actividades`.`actividades` (`id`) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT idUsuario_ficheros_FK FOREIGN KEY (idUsuario) REFERENCES `actividades`.`usuarios` (`id`) ON UPDATE CASCADE ON DELETE SET NULL
);

DROP TABLE IF EXISTS `participaciones`;
CREATE TABLE `participaciones` (
	id int AUTO_INCREMENT PRIMARY KEY,
	idActividad INT NOT NULL,
	idUsuario INT NULL, -- en caso de que el usuario sea eliminado
	modoPago VARCHAR(50) NOT NULL,
	sugerencia TEXT NULL,
	votacion INT DEFAULT 0,
	comentarios TEXT NULL,
	CONSTRAINT idActividad_participaciones_FK FOREIGN KEY (idActividad) REFERENCES `actividades`.`actividades` (`id`) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT idUsuario_participaciones_FK FOREIGN KEY (idUsuario) REFERENCES `actividades`.`usuarios` (`id`) ON UPDATE CASCADE ON DELETE SET NULL
);
