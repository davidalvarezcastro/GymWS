/**
 * 
 */
package es.ubu.asi.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author david {dac1005@alu.ubu.es}
 */
public class Activity {
	// attributes
	private long id;
	private String title;
	private String description;
	private String suggestions;
	private String teachers;
	private String days;
	private String schedule;
	private long participations; // nº de participantes [variable utilizada para las consultas del servicio]
	private long score; // valoración media [variable utilizada para las consultas del servicio]
	private Date dateStart;
	private Date dateEnd;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	// constructors
	public Activity() {
		super();
	}

	public Activity(String title, String description, String suggestions, String teachers, String days, String schedule,
			Date dateStart, Date dateEnd) {
		super();
		this.title = title;
		this.description = description;
		this.suggestions = suggestions;
		this.teachers = teachers;
		this.days = days;
		this.schedule = schedule;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}

	public Activity(long id, String title, String description, String suggestions, String teachers, String days,
			String schedule, Date dateStart, Date dateEnd) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.suggestions = suggestions;
		this.teachers = teachers;
		this.days = days;
		this.schedule = schedule;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}
	
	// getters & setters
	public long getId() {
		return id;
	}
	public String getIdStr() {
		return String.valueOf(id);
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSuggestions() {
		return suggestions;
	}
	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}
	public String getTeachers() {
		return teachers;
	}
	public void setTeachers(String teachers) {
		this.teachers = teachers;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public String getDateStartString() {
		return dateFormat.format(dateStart);
	}
	public String getDateEndString() {
		return dateFormat.format(dateEnd);
	}
	
	public long getParticipations() {
		return participations;
	}

	public void setParticipations(long participations) {
		this.participations = participations;
	}

	public long getScore() {
		return participations;
	}

	public void setScore(long score) {
		this.score = score;
	}
	
	// methods
	@Override
    public String toString() {
		return "Activity{" + "id=" + id + ", titulo=" + title + ", descripcion=" + description + ", docentes=" + teachers + ", días=" + days + ", horario=" + schedule + ", inicio=" + dateFormat.format(dateStart) + ", fin=" + dateFormat.format(dateEnd) + '}';
    }
}

