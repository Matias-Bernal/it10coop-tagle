package servidor.persistencia.dominio;

import java.sql.Date;


public class Notificacion_Area_Administracion extends Notificacion{
	

	public Notificacion_Area_Administracion(){
		super();
	}
	public Notificacion_Area_Administracion(Date fecha_notificacion,
			Boolean concretada_notificacion, String texto_notificacion) {
		super (fecha_notificacion,concretada_notificacion,texto_notificacion);
	}

}
