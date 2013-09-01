package servidor.persistencia.dominio;

import java.sql.Date;

public class Notificacion_Asignacion_Turnos extends Notificacion_Area_Administracion {

	public Notificacion_Asignacion_Turnos(){
		super();
	}
	public Notificacion_Asignacion_Turnos(Date fecha_notificacion,
			Boolean concretada_notificacion, String texto_notificacion) {
		super (fecha_notificacion,concretada_notificacion,texto_notificacion);
	}
	
	
}
