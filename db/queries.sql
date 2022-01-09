-- consultarActividadesConPlazas (NO DATES)
SELECT a.*, COALESCE(participantes, 0) as participantes FROM actividades a
LEFT JOIN (
  SELECT idActividad, COUNT(*) as participantes FROM participaciones GROUP BY idActividad
) as p ON a.id = p.idActividad
ORDER BY participantes ASC;

SELECT a.*, COALESCE(participantes, 0) FROM actividades a
LEFT JOIN (
  SELECT idActividad, COUNT(*) as participantes FROM participaciones GROUP BY idActividad
) as p ON a.id = p.idActividad
WHERE ((participantes >= 0 AND participantes < 20) OR participantes IS NULL) AND fechaFin > NOW()
ORDER BY participantes ASC;

-- consultarActividadesConPlazasFechas (DATES)
SELECT a.*, COALESCE(participantes, 0) as participantes FROM actividades a
LEFT JOIN (
  SELECT idActividad, COUNT(*) as participantes FROM participaciones GROUP BY idActividad
) as p ON a.id = p.idActividad
WHERE ((participantes >= 0 AND participantes < 20) OR participantes IS NULL)
  AND (fechaInicio >= '2021-01-01' AND fechaFin <= '2021-04-20')
ORDER BY participantes ASC;

-- fechaInicio >= '2021-01-01' AND fechaFin <= '2021-04-20'
-- fechaInicio >= '2021-01-01' AND fechaFin <= '2021-11-20'
-- fechaInicio >= '2021-01-01' AND fechaFin <= '2021-10-20'
-- fechaInicio >= '2021-03-01' AND fechaFin <= '2021-10-20'
-- fechaInicio >= '2021-07-01' AND fechaFin <= '2021-12-31'

-- consultarActividadMejorPuntuada (NO DATES)
SELECT a.*, media, participantes FROM actividades a
INNER JOIN (
  SELECT idActividad, COUNT(*) participantes, SUM(votacion)/COUNT(*) media FROM participaciones GROUP BY idActividad
) p ON a.id = p.idActividad
ORDER BY media DESC LIMIT 1;


-- consultarActividadMejorPuntuadaFechas (DATES)
SELECT a.*, media, participantes FROM actividades a
INNER JOIN (
  SELECT idActividad, COUNT(*) participantes, SUM(votacion)/COUNT(*) media FROM participaciones GROUP BY idActividad
) p ON a.id = p.idActividad
WHERE fechaInicio >= '2021-04-01' AND fechaFin <= '2021-10-30'
ORDER BY media DESC LIMIT 1;

-- fechaInicio >= '2021-01-01' AND fechaFin <= '2021-12-30'
-- fechaInicio >= '2021-04-01' AND fechaFin <= '2021-10-30'
-- fechaInicio >= '2021-04-21' AND fechaFin <= '2021-10-30'

-- consultarMediaPuntuacionActividades (NO DATES)
SELECT COUNT(*) participantes, SUM(votacion)/COUNT(*) media
FROM participaciones
WHERE idActividad IN (SELECT id FROM actividades WHERE fechaFin < NOW());

-- consultarMediaPuntuacionActividadesFechas (DATES)
SELECT COUNT(*) participantes, SUM(votacion)/COUNT(*) media
FROM participaciones
WHERE idActividad IN (
  SELECT id FROM actividades WHERE fechaFin < NOW() AND (fechaInicio >= '2021-01-01' AND fechaFin <= '2021-12-30'));

-- fechaInicio >= '2021-01-01' AND fechaFin <= '2021-12-30'
-- fechaInicio >= '2021-04-01' AND fechaFin <= '2021-10-30'
-- fechaInicio >= '2021-04-21' AND fechaFin <= '2021-10-30'


-- consultarPlazasLibresActividad (restar a Globals.MAX_PARTICIPANTES)
SELECT a.*, COALESCE(participantes, 0) as participantes FROM actividades a
LEFT JOIN (
  SELECT idActividad, COUNT(*) as participantes FROM participaciones GROUP BY idActividad
) as p ON a.id = p.idActividad
WHERE a.id = 1 AND a.fechaFin >= NOW();

-- consultarNumeroInscritosActividad
SELECT idActividad, COUNT(*) as participantes
FROM participaciones WHERE idActividad = 1 LIMIT 1;
