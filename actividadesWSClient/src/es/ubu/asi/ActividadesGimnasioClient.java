package es.ubu.asi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;

public class ActividadesGimnasioClient {
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	private static String formatActivity(Activity a) {
		return "Activity{" + "id=" + a.getId() + ", titulo=" + a.getTitle() + ", "
				+ "descripcion=" + a.getDescription() + ", docentes=" + a.getTeachers() + ", "
				+ "días=" + a.getDays() + ", horario=" + a.getSchedule() + ", "
				+ "inicio=" + a.getDateStart() + ", fin=" + a.getDateEnd() + '}';
	}
	
	private static XMLGregorianCalendar getXMLCalendar (Date date) {
		XMLGregorianCalendar xmlDate = null;
		GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
 
        try {
            xmlDate = DatatypeFactory.newInstance()
                          .newXMLGregorianCalendar(gc);
        }
        catch (Exception e) {}
        
        return xmlDate;
	}

	public static void main(String[] args) {
		float score = 0;
		Activity activity = null;
		List<Activity> activities = new ArrayList<Activity>();
		List<String> resultados = new ArrayList<String>();
		int freePlaces = 0, participants = 0, idActivity = 0;
		Date start = null, end = null;

		ActividadesGimnasioService servicio = new ActividadesGimnasioService();		
		ActividadesGimnasio c = servicio.getActividadesGimnasioPort();
		// mantenemos la sesión (probar a comentar)
		// ((BindingProvider)c).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY,true);


		// ejecutamos un serie de consultas del servicio
		System.out.println("\n\n\t consultarActividadesConPlazas");
		activities = c.consultarActividadesConPlazas();
		System.out.println(String.format("Resultado (consultarActividadesConPlazas):"));
		activities.forEach( (a) -> System.out.println(formatActivity(a)) );
		resultados = c.consultar();
		System.out.println(String.format("Resultado almacenado (%d): %s", resultados.size(), resultados));


		try {
			System.out.println("\n\n\t consultarActividadesConPlazasLibres");
			start = dateFormat.parse("2021-01-01");
			end = dateFormat.parse("2021-04-20");
			activities = c.consultarActividadesConPlazasFechas(getXMLCalendar(start), getXMLCalendar(end));
			System.out.println(String.format(String.format("Resultado (consultarActividadesConPlazasLibres %s %s):", start, end)));
			activities.forEach( (a) -> System.out.println(formatActivity(a)) );
			resultados = c.consultar();
			System.out.println(String.format("Resultado almacenado (%d): %s", resultados.size(), resultados));
			
			start = dateFormat.parse("2021-01-01");
			end = dateFormat.parse("2021-11-20");
			activities = c.consultarActividadesConPlazasFechas(getXMLCalendar(start), getXMLCalendar(end));
			System.out.println(String.format(String.format("\nResultado (consultarActividadesConPlazasLibres %s %s):", start, end)));
			activities.forEach( (a) -> System.out.println(formatActivity(a)) );
			resultados = c.consultar();
			System.out.println(String.format("Resultado almacenado (%d): %s", resultados.size(), resultados));
			
			start = dateFormat.parse("2021-07-01");
			end = dateFormat.parse("2021-12-31");
			activities = c.consultarActividadesConPlazasFechas(getXMLCalendar(start), getXMLCalendar(end));
			System.out.println(String.format(String.format("\nResultado (consultarActividadesConPlazasLibres %s %s):", start, end)));
			activities.forEach( (a) -> System.out.println(formatActivity(a)) );
			resultados = c.consultar();
			System.out.println(String.format("Resultado almacenado (%d): %s", resultados.size(), resultados));
		} catch (Exception e) {}


		System.out.println("\n\n\t consultarActividadMejorPuntuada");
		activity = c.consultarActividadMejorPuntuada();
		System.out.println(String.format("Resultado (consultarActividadMejorPuntuada): \n" + formatActivity(activity)));
		resultados = c.consultar();
		System.out.println(String.format("Resultado almacenado (%d): %s", resultados.size(), resultados));


		try {
			System.out.println("\n\n\t consultarActividadMejorPuntuadaFechas");
			start = dateFormat.parse("2021-04-21");
			end = dateFormat.parse("2021-10-30");
			activity = c.consultarActividadMejorPuntuadaFechas(getXMLCalendar(start), getXMLCalendar(end));
			System.out.println(String.format(String.format("Resultado (consultarActividadMejorPuntuadaFechas %s %s): \n %s", start, end, formatActivity(activity))));
			resultados = c.consultar();
			System.out.println(String.format("Resultado almacenado (%d): %s", resultados.size(), resultados));
			
			start = dateFormat.parse("2021-04-01");
			end = dateFormat.parse("2021-10-30");
			activity = c.consultarActividadMejorPuntuadaFechas(getXMLCalendar(start), getXMLCalendar(end));
			System.out.println(String.format(String.format("\nResultado (consultarActividadMejorPuntuadaFechas %s %s): \n %s", start, end, formatActivity(activity))));
			resultados = c.consultar();
			System.out.println(String.format("Resultado almacenado (%d): %s", resultados.size(), resultados));
		} catch (Exception e) {}


		System.out.println("\n\n\t consultarMediaPuntuacionActividades");
		score = c.consultarMediaPuntuacionActividades();
		System.out.println(String.format("Resultado (consultarMediaPuntuacionActividades): %f", score));
		resultados = c.consultar();
		System.out.println(String.format("Resultado almacenado (%d): %s", resultados.size(), resultados));
		score = c.consultarMediaPuntuacionActividades();
		System.out.println(String.format("\nResultado (consultarMediaPuntuacionActividades): %f", score));
		resultados = c.consultar();
		System.out.println(String.format("Resultado almacenado (%d): %s", resultados.size(), resultados));


		try {
			System.out.println("\n\n\t consultarMediaPuntuacionActividadesFechas");
			start = dateFormat.parse("2021-01-01");
			end = dateFormat.parse("2021-12-30");
			score = c.consultarMediaPuntuacionActividadesFechas(getXMLCalendar(start), getXMLCalendar(end));
			System.out.println(String.format(String.format("Resultado (consultarMediaPuntuacionActividadesFechas %s %s): \n %d", start, end, score)));
			resultados = c.consultar();
			System.out.println(String.format("Resultado almacenado (%d): %s", resultados.size(), resultados));
			
			start = dateFormat.parse("2021-04-01");
			end = dateFormat.parse("2021-10-30");
			score = c.consultarMediaPuntuacionActividadesFechas(getXMLCalendar(start), getXMLCalendar(end));
			System.out.println(String.format(String.format("\nResultado (consultarMediaPuntuacionActividadesFechas %s %s): \n %d", start, end, score)));
			resultados = c.consultar();
			System.out.println(String.format("Resultado almacenado (%d): %s", resultados.size(), resultados));
			
			start = dateFormat.parse("2021-04-21");
			end = dateFormat.parse("2021-10-30");
			score = c.consultarMediaPuntuacionActividadesFechas(getXMLCalendar(start), getXMLCalendar(end));
			System.out.println(String.format(String.format("\nResultado (consultarMediaPuntuacionActividadesFechas %s %s): \n %d", start, end, score)));
			resultados = c.consultar();
			System.out.println(String.format("Resultado almacenado (%d): %s", resultados.size(), resultados));
		} catch (Exception e) {}


		System.out.println("\n\n\t consultarPlazasLibresActividad");
		idActivity = 1;
		freePlaces = c.consultarPlazasLibresActividad(idActivity);
		System.out.println(String.format("Resultado (consultarPlazasLibresActividad %d): %d", idActivity, freePlaces));
		resultados = c.consultar();
		System.out.println(String.format("Resultado almacenado (%d): %s", resultados.size(), resultados));
		idActivity = 2;
		freePlaces = c.consultarPlazasLibresActividad(idActivity);
		System.out.println(String.format("Resultado (consultarPlazasLibresActividad %d): %d", idActivity, freePlaces));
		resultados = c.consultar();
		System.out.println(String.format("Resultado almacenado (%d): %s", resultados.size(), resultados));
		idActivity = 6;
		freePlaces = c.consultarPlazasLibresActividad(idActivity);
		System.out.println(String.format("Resultado (consultarPlazasLibresActividad %d): %d", idActivity, freePlaces));
		resultados = c.consultar();
		System.out.println(String.format("Resultado almacenado (%d): %s", resultados.size(), resultados));
		idActivity = 8;
		freePlaces = c.consultarPlazasLibresActividad(idActivity);
		System.out.println(String.format("Resultado (consultarPlazasLibresActividad %d): %d", idActivity, freePlaces));
		resultados = c.consultar();
		System.out.println(String.format("Resultado almacenado (%d): %s", resultados.size(), resultados));
		

		System.out.println("\n\n\t consultarNumeroInscritosActividad");
		idActivity = 1;
		participants = c.consultarNumeroInscritosActividad(idActivity);
		System.out.println(String.format("Resultado (consultarNumeroInscritosActividad %d): %d", idActivity, participants));
		resultados = c.consultar();
		System.out.println(String.format("Resultado almacenado (%d): %s", resultados.size(), resultados));
		idActivity = 2;
		participants = c.consultarNumeroInscritosActividad(idActivity);
		System.out.println(String.format("Resultado (consultarNumeroInscritosActividad %d): %d", idActivity, participants));
		resultados = c.consultar();
		System.out.println(String.format("Resultado almacenado (%d): %s", resultados.size(), resultados));
		idActivity = 6;
		participants = c.consultarNumeroInscritosActividad(idActivity);
		System.out.println(String.format("Resultado (consultarNumeroInscritosActividad %d): %d", idActivity, participants));
		resultados = c.consultar();
		System.out.println(String.format("Resultado almacenado (%d): %s", resultados.size(), resultados));
		idActivity = 8;
		participants = c.consultarNumeroInscritosActividad(idActivity);
		System.out.println(String.format("Resultado (consultarNumeroInscritosActividad %d): %d", idActivity, participants));
		resultados = c.consultar();
		System.out.println(String.format("Resultado almacenado (%d): %s", resultados.size(), resultados));
	}
}
