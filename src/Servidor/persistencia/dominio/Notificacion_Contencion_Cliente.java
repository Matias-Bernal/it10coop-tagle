package servidor.persistencia.dominio;

import java.sql.Date;


public class Notificacion_Contencion_Cliente extends Notificacion_Area_Administracion{
	
	
	public Notificacion_Contencion_Cliente(Date fecha_notificacion,
			Boolean concretada_notificacion, String texto_notificacion) {
		super (fecha_notificacion,concretada_notificacion,texto_notificacion);
	}
}
