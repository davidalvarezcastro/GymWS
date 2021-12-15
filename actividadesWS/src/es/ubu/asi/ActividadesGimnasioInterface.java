package es.ubu.asi;

import java.util.Date;
import java.util.List;

import es.ubu.asi.model.Activity;


/**
 * ActividadesGimnasioInterface.
 * 
 * @author davalv
 *
 */
public interface ActividadesGimnasioInterface {

	public List<Activity> consultarActividadesConPlazas();
	public List<Activity> consultarActividadesConPlazasFechas(Date fechaInicio, Date fechaFin);
	public Activity consultarActividadMejorPuntuada();
	public Activity consultarActividadMejorPuntuadaFechas(Date fechaInicio, Date fechaFin);
	public float consultarMediaPuntuacionActividades();
	public float consultarMediaPuntuacionActividadesFechas(Date fechaInicio, Date fechaFin);
	public int consultarPlazasLibresActividad(int idActividad);
	public int consultarNumeroInscritosActividad(int idActividad);
	public List<String> consultar();

}
