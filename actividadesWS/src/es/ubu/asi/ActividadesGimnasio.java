package es.ubu.asi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import es.ubu.asi.dao.ActivityDAO;
import es.ubu.asi.model.Activity;

/**
 * ActividadesGimnasioService
 * 
 * 	implementación de la interface
 * 
 * @author davalv
 */
@WebService
public class ActividadesGimnasio implements ActividadesGimnasioInterface {

	private String SEPARADOR_OPERACIONES = " ";
	private static Logger logger = Logger.getLogger(ActividadesGimnasio.class.getName());
	private static String SESSION_CONSULTA_KEY = "operaciones";

	@Resource
	private WebServiceContext wsContext;

    /**
     * Default constructor. 
     */
    public ActividadesGimnasio() {
    }
    
	// methods
    /**
     * Función que permite registrar la operación llevada a cabo en la sesión de usuario
     *
     * @param operacion
     */
    private void registrarOperacion(String operacion) {
    	logger.log(Level.INFO, "Registrando operacion " + operacion);
    	try {
    		MessageContext mc = wsContext.getMessageContext();
        	HttpSession sesion = ((javax.servlet.http.HttpServletRequest) mc.get(MessageContext.SERVLET_REQUEST)).getSession();

        	if (sesion == null)
                throw new Exception("No se ha encontrado HTTP Session");

        	String operaciones = (String)sesion.getAttribute(SESSION_CONSULTA_KEY);
        	if (operaciones == null) {
        		operaciones = operacion;
        	} else {
        		operaciones = operaciones + SEPARADOR_OPERACIONES + operacion;
        	}

        	sesion.setAttribute(SESSION_CONSULTA_KEY, operaciones);
		} catch (Exception e) {
			logger.log(Level.INFO, "Error registrarOperacion =>" + e.getMessage());
		}
    }

	@Override
	@WebMethod
	public List<Activity> consultarActividadesConPlazas() {
		this.registrarOperacion("consultarActividadesConPlazas");
		return ActivityDAO.consultarActividadesConPlazas();
	}

	@Override
	@WebMethod
	public List<Activity> consultarActividadesConPlazasFechas(Date fechaInicio, Date fechaFin) {
		this.registrarOperacion("consultarActividadesConPlazasFechas");
		return ActivityDAO.consultarActividadesConPlazasLibres(fechaInicio, fechaFin);
	}

	@Override
	@WebMethod
	public Activity consultarActividadMejorPuntuada() {
		this.registrarOperacion("consultarActividadMejorPuntuada");
		return ActivityDAO.consultarActividadMejorPuntuada();
	}

	@Override
	@WebMethod
	public Activity consultarActividadMejorPuntuadaFechas(Date fechaInicio, Date fechaFin) {
		this.registrarOperacion("consultarActividadMejorPuntuadaFechas");
		return ActivityDAO.consultarActividadMejorPuntuada(fechaInicio, fechaFin);
	}

	@Override
	@WebMethod
	public float consultarMediaPuntuacionActividades() {
		this.registrarOperacion("consultarMediaPuntuacionActividades");
		return ActivityDAO.consultarMediaPuntuacionActividades();
	}

	@Override
	@WebMethod
	public float consultarMediaPuntuacionActividadesFechas(Date fechaInicio, Date fechaFin) {
		this.registrarOperacion("consultarMediaPuntuacionActividadesFechas");
		return ActivityDAO.consultarMediaPuntuacionActividades(fechaInicio, fechaFin);
	}

	@Override
	@WebMethod
	public int consultarPlazasLibresActividad(int idActividad) {
		this.registrarOperacion("consultarPlazasLibresActividad");
		return ActivityDAO.consultarPlazasLibresActividad(idActividad);
	}

	@Override
	@WebMethod
	public int consultarNumeroInscritosActividad(int idActividad) {
		this.registrarOperacion("consultarNumeroInscritosActividad");
		return ActivityDAO.consultarNumeroInscritosActividad(idActividad);
	}

	@Override
	@WebMethod
	public List<String> consultar() {
		logger.log(Level.INFO, "Consultando listado de operaciones...");
		List<String> consultas = new ArrayList<>();
		try {
    		MessageContext mc = wsContext.getMessageContext();
        	HttpSession sesion = ((javax.servlet.http.HttpServletRequest) mc.get(MessageContext.SERVLET_REQUEST)).getSession();

        	if (sesion == null)
                throw new Exception("No se ha encontrado HTTP Session");
        	
        	String operaciones = (String)sesion.getAttribute(SESSION_CONSULTA_KEY);
        	logger.log(Level.INFO, operaciones);
        	if (operaciones != null) {
        		consultas = new ArrayList<String>(Arrays.asList(operaciones.split(SEPARADOR_OPERACIONES)));
        	}
		} catch (Exception e) {
			logger.log(Level.INFO, e.getMessage());
		}
    	
		return consultas;
	}
}
