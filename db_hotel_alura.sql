CREATE DATABASE db_hotel_alura;

use db_hotel_alura;


CREATE TABLE IF NOT EXISTS `reservas` (
  `id` int NOT NULL auto_increment,
  `fecha_entrada` date NOT NULL,
  `fecha_salida` date NOT NULL,
  `valor` double (10,2),
  `forma_pago` varchar(50) NOT NULL,
  primary key (id)
  );

CREATE TABLE IF NOT exists`huespedes` (
  `id` int NOT NULL auto_increment,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `identificacion` varchar(20) NOT NULL,
  `nacionalidad` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `id_reserva` int NOT NULL,
  primary key (id),
  foreign key (id_reserva) references reservas (id)
);

CREATE TABLE `usuarios` (
  `nombre` varchar (100),
  `contrasena` varchar (50)
  );

INSERT INTO `usuarios` (`nombre`, `contrasena`) VALUES ('Admin', '123');
INSERT INTO `usuarios` (`nombre`, `contrasena`) VALUES ('Usuario', '123');


