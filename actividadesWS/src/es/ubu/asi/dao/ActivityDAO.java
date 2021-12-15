/**
 * 
 */
package es.ubu.asi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.ubu.asi.Globals;
import es.ubu.asi.database.Database;
import es.ubu.asi.model.Activity;

/**
 * @author david {dac1005@alu.ubu.es}
 */
public class ActivityDAO {
	private static Database db;
	private static Logger logger = Logger.getLogger(ActivityDAO.class.getName());
	
	static {
		db = Database.getInstance();
	}

	// methods
	/**
	 * Permite conectarse a la db y obtener el listado con plazas libres
	 * 	- nº de participaciones < 20
	 *  - actividad no finalizada
	 *
	 * @return listado de las actividades con plazas libres
	 * @throws Exception
	 */
	public static List<Activity> consultarActividadesConPlazas() {
		String query = "SELECT a.*, COALESCE(participantes, 0) as participantes FROM actividades a\n" + 
				"	LEFT JOIN (\n" + 
				"  		SELECT idActividad, COUNT(*) as participantes FROM participaciones GROUP BY idActividad\n" + 
				"	) as p ON a.id = p.idActividad\n" + 
				"	WHERE ((participantes >= 0 AND participantes < ?) OR participantes IS NULL) AND fechaFin < NOW()\n" + 
				"	ORDER BY participantes ASC;";
		List<Activity> list = new ArrayList<Activity>();

		try (Connection conn = db.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			preparedStatement.setLong(1, Globals.MAX_PARTICIPANTES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long participations = resultSet.getLong("participantes");
                String title = resultSet.getString("titulo");
                String description = resultSet.getString("descripcion");
                String suggestions = resultSet.getString("recomendaciones");
                String teachers = resultSet.getString("docentes");
                String days = resultSet.getString("dias");
                String schedule = resultSet.getString("horario");
                java.util.Date dateS = resultSet.getDate("fechaInicio");
                java.util.Date dateE = resultSet.getDate("fechaFin");
                Activity a = new Activity(id, title, description, suggestions, teachers, days, schedule, dateS, dateE);
                a.setParticipations(participations);
                list.add(a);
            }
        } catch (SQLException e) {
        	logger.log(Level.SEVERE,e.getMessage());
        	list = null;
        } catch (Exception e) {
        	logger.log(Level.SEVERE,e.getMessage());
        	list = null;
        }

		return list;
	}
	

	/**
	 * Permite conectarse a la db y obtener el listado con plazas libres dentro de un rango temporal
	 * 	- nº de participaciones < 20
	 *
	 * @param fecha de inicio
	 * * @param fecha de fin
	 * @return listado de las actividades con plazas libres en el instante temporal marcado
	 * @throws Exception
	 */
	public static List<Activity> consultarActividadesConPlazasLibres(java.util.Date start, java.util.Date end) {
		String query = "SELECT a.*, COALESCE(participantes, 0) as participantes FROM actividades a\n" + 
				"	LEFT JOIN (\n" + 
				"  		SELECT idActividad, COUNT(*) as participantes FROM participaciones GROUP BY idActividad\n" + 
				"	) as p ON a.id = p.idActividad\n" + 
				"	WHERE ((participantes >= 0 AND participantes < ?) OR participantes IS NULL)\n" + 
				"  		AND (fechaInicio >= ? AND fechaFin <= ?)\n" + 
				"	ORDER BY participantes ASC;";
		List<Activity> list = new ArrayList<Activity>();

		try (Connection conn = db.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			preparedStatement.setLong(1, Globals.MAX_PARTICIPANTES);
			preparedStatement.setDate(2, new Date(start.getTime()));
			preparedStatement.setDate(3, new Date(end.getTime()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long participations = resultSet.getLong("participantes");
                String title = resultSet.getString("titulo");
                String description = resultSet.getString("descripcion");
                String suggestions = resultSet.getString("recomendaciones");
                String teachers = resultSet.getString("docentes");
                String days = resultSet.getString("dias");
                String schedule = resultSet.getString("horario");
                java.util.Date dateS = resultSet.getDate("fechaInicio");
                java.util.Date dateE = resultSet.getDate("fechaFin");
                Activity a = new Activity(id, title, description, suggestions, teachers, days, schedule, dateS, dateE);
                a.setParticipations(participations);
                list.add(a);
            }
        } catch (SQLException e) {
        	logger.log(Level.SEVERE,e.getMessage());
        	list = null;
        } catch (Exception e) {
        	logger.log(Level.SEVERE,e.getMessage());
        	list = null;
        }

		return list;
	}


	/**
	 * Permite conectarse a la db y obtener información de la actividad
	 * con la mejor puntuación
	 *
	 * NOTA: se podrían considerar solo las actividades finalizadas
	 * 	WHERE fechaFin <= NOW() ORDER BY media DESC LIMIT 1
	 *
	 * @return información de la actividad
	 * @throws Exception
	 */
	public static Activity consultarActividadMejorPuntuada () {
		String query = "SELECT a.*, media, participantes FROM actividades a\n" + 
				"	INNER JOIN (\n" + 
				"  		SELECT idActividad, COUNT(*) participantes, SUM(votacion)/COUNT(*) media FROM participaciones GROUP BY idActividad\n" + 
				"	) p ON a.id = p.idActividad\n" + 
				"	ORDER BY media DESC LIMIT 1;";
		Activity a = null;

		try (Connection conn = db.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long participations = resultSet.getLong("participantes");
                long score = resultSet.getLong("media");
                String title = resultSet.getString("titulo");
                String description = resultSet.getString("descripcion");
                String suggestions = resultSet.getString("recomendaciones");
                String teachers = resultSet.getString("docentes");
                String days = resultSet.getString("dias");
                String schedule = resultSet.getString("horario");
                java.util.Date dateS = resultSet.getDate("fechaInicio");
                java.util.Date dateE = resultSet.getDate("fechaFin");
                a = new Activity(id, title, description, suggestions, teachers, days, schedule, dateS, dateE);
                a.setParticipations(participations);
                a.setScore(score);
            }

            return a;
		} catch (SQLException e) {
        	logger.log(Level.SEVERE,e.getMessage());
        } catch (Exception e) {
        	logger.log(Level.SEVERE,e.getMessage());
        }

		return a;
	}

	
	/**
	 * Permite conectarse a la db y obtener información de la actividad
	 * con la mejor puntuación en un instante temporal determinado
	 *
	 * @param fecha de inicio
	 * @param fecha de fin
	 * @return información de la actividad
	 * @throws Exception
	 */
	public static Activity consultarActividadMejorPuntuada (java.util.Date start, java.util.Date end) {
		String query = "SELECT a.*, media, participantes FROM actividades a\n" + 
				"	INNER JOIN (\n" + 
				"  		SELECT idActividad, COUNT(*) participantes, SUM(votacion)/COUNT(*) media FROM participaciones GROUP BY idActividad\n" + 
				"	) p ON a.id = p.idActividad\n" + 
				"	WHERE fechaInicio >= ? AND fechaFin <= ?\n" + 
				"	ORDER BY media DESC LIMIT 1;";
		Activity a = null;

		try (Connection conn = db.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			preparedStatement.setDate(1, new Date(start.getTime()));
			preparedStatement.setDate(2, new Date(end.getTime()));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long participations = resultSet.getLong("participantes");
                long score = resultSet.getLong("media");
                String title = resultSet.getString("titulo");
                String description = resultSet.getString("descripcion");
                String suggestions = resultSet.getString("recomendaciones");
                String teachers = resultSet.getString("docentes");
                String days = resultSet.getString("dias");
                String schedule = resultSet.getString("horario");
                java.util.Date dateS = resultSet.getDate("fechaInicio");
                java.util.Date dateE = resultSet.getDate("fechaFin");
                a = new Activity(id, title, description, suggestions, teachers, days, schedule, dateS, dateE);
                a.setParticipations(participations);
                a.setScore(score);
            }

            return a;
		} catch (SQLException e) {
        	logger.log(Level.SEVERE,e.getMessage());
        } catch (Exception e) {
        	logger.log(Level.SEVERE,e.getMessage());
        }

		return a;
	}


	/**
	 * Permite conectarse a la db y obtener la media de las puntuaciones
	 * de todas las acividades
	 *
	 * NOTA: se consideran solo las actividades finalizadas
	 * 	(porque si no se tendrían en cuenta votaciones a 0
	 *   de participantes que no han votado todavía)
	 *
	 * @return media de puntuaciones recibidas a las actividades finalizadas
	 * @throws Exception
	 */
	public static float consultarMediaPuntuacionActividades () {
		String query = "SELECT COUNT(*) participantes, SUM(votacion)/COUNT(*) media\n" + 
				"	FROM participaciones\n" + 
				"	WHERE idActividad IN (SELECT id FROM actividades WHERE fechaFin < NOW()) LIMIT 1";
		float score = -1;

		try (Connection conn = db.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                score = resultSet.getFloat("media");
            }

		} catch (SQLException e) {
        	logger.log(Level.SEVERE,e.getMessage());
        } catch (Exception e) {
        	logger.log(Level.SEVERE,e.getMessage());
        }

		return score;
	}


	/**
	 * Permite conectarse a la db y obtener la media de las puntuaciones
	 * de las actividades que tuvieron lugar en un instante temporal determinado.
	 * 
	 * NOTA: se siguen teniendo en cuenta actividades finalizadas. No tiene sentido mirar la media
	 * de actividades que vayan a finalizar, por ejemplo, al consultar la media de las actividades
	 * que finalicen el día 31 de diciembre del 2021. Esas actividades tienen participantes pero la
	 * votación es 0 porque todavía no han votado.
	 *
	 * @param fecha de inicio
	 * @param fecha de fin
	 * @return media de puntuaciones recibidas a las actividades finalizadas
	 * @throws Exception
	 */
	public static float consultarMediaPuntuacionActividades (java.util.Date start, java.util.Date end) {
		String query = "SELECT COUNT(*) participantes, SUM(votacion)/COUNT(*) media\n" + 
				"FROM participaciones\n" + 
				"WHERE idActividad IN (\n" + 
				"  SELECT id FROM actividades WHERE fechaFin < NOW() AND (fechaInicio >= ? AND fechaFin <= ?));";
		float score = -1;

		try (Connection conn = db.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			preparedStatement.setDate(1, new Date(start.getTime()));
			preparedStatement.setDate(2, new Date(end.getTime()));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                score = resultSet.getFloat("media");
            }

		} catch (SQLException e) {
        	logger.log(Level.SEVERE,e.getMessage());
        } catch (Exception e) {
        	logger.log(Level.SEVERE,e.getMessage());
        }

		return score;
	}


	/**
	 * Permite conectarse a la db y obtener el número de participantes a una actividad
	 *
	 * @param identificador de actividad
	 * @return media de puntuaciones recibidas a las actividades finalizadas
	 * @throws Exception
	 */
	public static int consultarPlazasLibresActividad (long activity) {
		String query = "SELECT a.*, COALESCE(participantes, 0) as participantes FROM actividades a\n" + 
				"	LEFT JOIN (\n" + 
				"  		SELECT idActividad, COUNT(*) as participantes FROM participaciones GROUP BY idActividad\n" + 
				"	) as p ON a.id = p.idActividad\n" + 
				"	WHERE a.id = ? AND a.fechaFin >= NOW();";
		System.out.println(query);
		int free = 0;

		try (Connection conn = db.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			preparedStatement.setLong(1, activity);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	int participations = resultSet.getInt("participantes");
            	
            	if (participations >= 0) {
            		free = Globals.MAX_PARTICIPANTES - participations;
            	} else {
            		free = -1; // indicamos el error
            	}
            }

		} catch (SQLException e) {
        	logger.log(Level.SEVERE,e.getMessage());
        } catch (Exception e) {
        	logger.log(Level.SEVERE,e.getMessage());
        }

		return free;
	}


	/**
	 * Permite conectarse a la db y obtener el número de participantes a una actividad
	 *
	 * @param identificador de actividad
	 * @return media de puntuaciones recibidas a las actividades finalizadas
	 * @throws Exception
	 */
	public static int consultarNumeroInscritosActividad (long activity) {
		String query = "SELECT idActividad, COUNT(*) as participantes\n" + 
				"FROM participaciones WHERE idActividad = ? LIMIT 1;";
		int participations = 0;

		try (Connection conn = db.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			preparedStatement.setLong(1, activity);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	participations = resultSet.getInt("participantes");
            }

		} catch (SQLException e) {
        	logger.log(Level.SEVERE,e.getMessage());
        } catch (Exception e) {
        	logger.log(Level.SEVERE,e.getMessage());
        }

		return participations;
	}


	// handle connections
	private static void close(Statement st) throws Exception {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException ex) {
				throw new Exception("", ex);
			}
		}
	}

	private static void close(Connection con) throws Exception {
		if (con != null) {
			try {
				db.close(con);
			} catch (SQLException ex) {
				throw new Exception("", ex);
			}
		}
	}
}
