DELETE FROM usuarios;
DELETE FROM actividades;
DELETE FROM ficheros;
DELETE FROM participaciones;
ALTER TABLE usuarios AUTO_INCREMENT = 1;
ALTER TABLE actividades AUTO_INCREMENT = 1;
ALTER TABLE ficheros AUTO_INCREMENT = 1;
ALTER TABLE participaciones AUTO_INCREMENT = 1;

-- usuarios
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('admin', 'admin', 'admin');
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('david', 'david', 'socio');
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('usuario1', 'usuario1', 'socio');
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('usuario2', 'usuario2', 'socio');
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('usuario3', 'usuario3', 'socio');
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('usuario4', 'usuario4', 'socio');
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('usuario5', 'usuario5', 'socio');
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('usuario6', 'usuario6', 'socio');
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('usuario8', 'usuario8', 'socio');
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('usuario9', 'usuario9', 'socio');
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('usuario10', 'usuario10', 'socio');
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('usuario11', 'usuario11', 'socio');
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('usuario12', 'usuario12', 'socio');
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('usuario13', 'usuario13', 'socio');
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('usuario14', 'usuario14', 'socio');
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('usuario15', 'usuario15', 'socio');
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('usuario16', 'usuario16', 'socio');
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('usuario17', 'usuario17', 'socio');
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('usuario18', 'usuario18', 'socio');
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('usuario19', 'usuario19', 'socio');
INSERT INTO `usuarios` (login, password, perfilAcceso) VALUES
('usuario20', 'usuario20', 'socio');


-- actividades
INSERT INTO `actividades` (titulo, descripcion, recomendaciones, docentes, dias, horario, fechaInicio, fechaFin) VALUES
('natacion I', 'natacion iniciacion', 'llevar bañador', 'david, carlos', 'lunes, martes', '08:00-11:00', '2021-01-21 00:00:01', '2021-12-31 23:59:59');

INSERT INTO `actividades` (titulo, descripcion, recomendaciones, docentes, dias, horario, fechaInicio, fechaFin) VALUES
('natacion II', 'natacion media', 'llevar bañador', 'david, carlos', 'lunes, martes', '08:00-11:00', '2021-04-21 00:00:01', '2021-10-21 23:59:59');

INSERT INTO `actividades` (titulo, descripcion, recomendaciones, docentes, dias, horario, fechaInicio, fechaFin) VALUES
('natacion III', 'natacion avanzada', 'llevar bañador', 'david, carlos', 'lunes, martes', '08:00-11:00', '2021-09-21 00:00:01', '2021-12-31 23:59:59');

INSERT INTO `actividades` (titulo, descripcion, recomendaciones, docentes, dias, horario, fechaInicio, fechaFin) VALUES
('fultbol I', 'futbol iniciacion', 'llevar botas', 'david, carlos', 'lunes, martes, jueves, viernes', '18:00-21:00', '2021-01-21 00:00:01', '2021-12-31 23:59:59');

INSERT INTO `actividades` (titulo, descripcion, recomendaciones, docentes, dias, horario, fechaInicio, fechaFin) VALUES
('baloncesto I', 'baloncesto iniciacion', 'llevar botas', 'jaime, ramon', 'lunes, martes, jueves, viernes', '18:00-21:00', '2021-01-21 00:00:01', '2021-12-31 23:59:59');

INSERT INTO `actividades` (titulo, descripcion, recomendaciones, docentes, dias, horario, fechaInicio, fechaFin) VALUES
('baloncesto I', 'baloncesto iniciacion', 'llevar botas', 'jaime, ramon', 'lunes, martes, jueves, viernes', '18:00-21:00', '2021-01-21 00:00:01', '2021-12-31 23:59:59');

INSERT INTO `actividades` (titulo, descripcion, recomendaciones, docentes, dias, horario, fechaInicio, fechaFin) VALUES
('bolos I', 'bolos iniciacion', 'llevar botas', 'ramon', 'viernes', '18:00-21:00', '2021-01-21 00:00:01', '2021-03-25 23:59:59');

INSERT INTO `actividades` (titulo, descripcion, recomendaciones, docentes, dias, horario, fechaInicio, fechaFin) VALUES
('bolos II', 'bolos intermedio', 'llevar botas', 'jaime', 'viernes', '18:00-21:00', '2021-04-01 00:00:01', '2021-09-25 23:59:59');



-- participaciones (permitir votar)
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(1, 1, 'domiciliacion', 'permitir pagar con bitcoin');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(1, 2, 'domiciliacion', 'permitir pagar con bitcoin');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(1, 3, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(1, 4, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(1, 5, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(1, 6, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(1, 7, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(1, 8, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(1, 9, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(1, 10, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(1, 11, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(1, 12, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(1, 13, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(1, 14, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(1, 15, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(1, 16, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(1, 17, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(1, 18, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(1, 19, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(1, 20, 'domiciliacion', '');

INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(4, 1, 'domiciliacion', 'permitir pagar con bitcoin');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(4, 2, 'domiciliacion', 'permitir pagar con bitcoin');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(4, 3, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(4, 4, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(4, 5, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(4, 6, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(4, 7, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(4, 8, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(4, 9, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(4, 10, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(4, 11, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(4, 12, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(4, 13, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(4, 14, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(4, 15, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(4, 16, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(4, 17, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(4, 18, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(4, 19, 'domiciliacion', '');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, sugerencia) VALUES
(4, 20, 'domiciliacion', '');

INSERT INTO `participaciones` (idActividad, idUsuario, modoPago) VALUES
(5, 2, 'domiciliacion');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago) VALUES
(5, 3, 'domiciliacion';
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago) VALUES
(5, 4, 'domiciliacion');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago) VALUES
(5, 5, 'domiciliacion');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago) VALUES
(5, 6, 'domiciliacion');

INSERT INTO `participaciones` (idActividad, idUsuario, modoPago) VALUES
(6, 10, 'domiciliacion');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago) VALUES
(6, 11, 'domiciliacion';
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago) VALUES
(6, 12, 'domiciliacion');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago) VALUES
(6, 5, 'domiciliacion');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago) VALUES
(6, 6, 'domiciliacion');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago) VALUES
(6, 8, 'domiciliacion');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago) VALUES
(6, 9, 'domiciliacion';
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago) VALUES
(6, 15, 'domiciliacion');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago) VALUES
(6, 13, 'domiciliacion');
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago) VALUES
(6, 3, 'domiciliacion');

-- participaciones y votaciones
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, votacion) VALUES
(2, 2, 'domiciliacion', 3);
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, votacion) VALUES
(2, 3, 'domiciliacion', 4);
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, votacion) VALUES
(2, 4, 'domiciliacion', 4);
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, votacion) VALUES
(2, 5, 'domiciliacion', 1);
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, votacion) VALUES
(2, 6, 'domiciliacion', 5);

INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, votacion) VALUES
(7, 12, 'domiciliacion', 4);
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, votacion) VALUES
(7, 8, 'domiciliacion', 4);
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, votacion) VALUES
(7, 3, 'domiciliacion', 5);
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, votacion) VALUES
(7, 16, 'domiciliacion', 5);

INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, votacion) VALUES
(8, 10, 'domiciliacion', 4);
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, votacion) VALUES
(8, 18, 'domiciliacion', 5);
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, votacion) VALUES
(8, 9, 'domiciliacion', 5);
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, votacion) VALUES
(8, 6, 'domiciliacion', 5);
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, votacion) VALUES
(8, 2, 'domiciliacion', 4);
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, votacion) VALUES
(8, 3, 'domiciliacion', 4);
INSERT INTO `participaciones` (idActividad, idUsuario, modoPago, votacion) VALUES
(8, 12, 'domiciliacion', 2);


