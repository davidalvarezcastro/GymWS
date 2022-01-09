# SQL

**Autor:** David Álvarez Castro

**Fecha:** 19/12/2021

**Asignatura:** ARQUITECTURA Y SERVICIOS DE INTERNET

---

Proyecto con un servicio web que permite consultar información sobre las actividades de un gimnasio desarrollado utilizando SOAP (JAX-WS).

El proyecto está formado por los siguientes elementos:

- ***actividadesWS:*** proyecto maven que implementa el servicio web SOAP.
- ***actividadesWSClient:*** proyecto maven que implementa el cliente de prueba para conectar con el servicio web.
- ***db:*** directorio con los scripts SQL empleados para crear y poblar la base de datos (se preparan una serie de escenarios con datos generados manualmente).
- ***video.txt:*** link del video (One Drive UBU).

## actividadesWS

El proyecto se encuentra en el paquete `es.ubu.asi` donde se pueden encontrar los siguientes subpaquetes:

- *dao:* directorio con los Data Access Object que definen las funciones que ejecutan las consultas SQL para acceder a la base de datos.
- *database:* directorio con el fichero `Database` archivo que permite definir la conexión a la base de datos (usada por los `dao`).
- *model* directorio con los ficheros que definen los modelos utilizados por el servicio web (en este caso simplemente las `Activities`).

Se explican brevemente algunos de los ficheros más destacados que forman el servicio web:

- ***Activity:*** clase java formada por los atributos, getters y setter asociados a la tabla de actividades de la base de datos.
- ***ActivityDAO:*** dao con las funciones SQL necesarias para poder obtener los datos requeridos por la interfaz del servicio.
- ***ActividadesGimnasioInterface:*** interfaz java que define las funciones que implementa el servicio web.
- ***ActividadesGimnasio:*** servicio web (clase java) que implementa la interfaz `ActividadesGimnasioInterface` mediante `WebMethods`.

## actividadesWSClient

Es muy importante generar el `.jar` (`wsclient.jar`) con los artefactos del servidor web para poder llamar a las funciones desde el cliente (véase documento pdf `Guía de desarrollo servicios web-v01.pdf`). Para ello, a partir del fichero `wsdl` del servicio (es necesario tenerlo desplegado/funcionando) se ejecuta el siguiente comando (puede ejecutarse desde cualquier ruta y copiarlo en el cliente, o simplemente ejecutarlo dentro del proyecto a utilizar):

```sh
$ wsimport -clientjar wsclient.jar http://localhost:8080/actividadesWS/ActividadesGimnasioService?wsdl
```

El cliente simplemente está formado por la clase java `ActividadesGimnasioClient`, encargada de conectarse al servicio web manteniendo la sesión (`((BindingProvider)c).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY,true);`) y ejecutar el listado de funciones definidas. En algunos casos, los relativos a los servicios que involucran fechas, se han ejecutado un par de veces con valores diferentes para apreciar los resultados diferentes.

## **Consideraciones**

Para llevar a cabo esta práctica se han tenido en cuenta una serie de consideraciones/decisiones. Se muestran algunas de ellas a continuación:

- Solo se puede votar a actividades en las que has participado y hayan finalizado
  - esto provoca que las consultas que involucren el campo `votacion` de la tabla `participaciones`, tienen en cuenta que la actividad haya finalizado (`fechaFin < NOW()`).
- Se parte de una base de datos con filas insertadas a mano para crear un escenario acorde a las consultas.
- En las consultas relativas a la actividad mejor puntuada (`consultarActividadMejorPuntuada`), se tiene en cuenta la media de los participantes; en lugar de la mejor nota individual dada por un participante, esto puede provocar que una actividad con la mejor puntuación individual tenga una media muy baja si se tienen en cuenta las votaciones del resto de participantes.
- No se explica cómo se llevaría a cabo el despliegue del servicio en Glassfish debido a que en el guion no se especifica; simplemente se ejecutan, tanto el servicio como el cliente, desde el IDE Eclipse.

## **Demo**

Se describe brevemente el guion seguido:

- Explicación de los valores iniciales de la base de datos `init-content.sql`
- Explicación de las consultas 8 SQL implementadas (conjunto a las consideraciones)
- Explicación del WS
  - Creación del proyecto
  - Explicación de la estructura modelos-dao-servicio
  - Explicación del uso de la sesión
  - Ejecución
- Explicación del cliente
  - Creación del proyecto
  - Generación del `jar` a partir del servicio
  - Ejecución

En la demostración me he olvidado comentar que para llevar a cabo la conexión a la base de datos, se hace uso del pool de conexiones de la práctica 1 y práctica 2. Debido a ciertos problemas, tuve que grabar la demo en dos partes (por eso el cambio de intensidad de sonido al explicar la codificación).

Quedo a total disposición de la profesora para acordar una tutoría y explicar más en detalle ciertos aspectos de la aplicación si así fuese necesario.
