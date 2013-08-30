package servidor.persistencia.dominio;

import java.sql.Date;


public class Notificacion_Sugerencia extends Notificacion_Area_Repuesto {

	
	public Notificacion_Sugerencia(Date fecha_notificacion,
			Boolean concretada_notificacion, String texto_notificacion) {
		super (fecha_notificacion,concretada_notificacion,texto_notificacion);
	}
}
