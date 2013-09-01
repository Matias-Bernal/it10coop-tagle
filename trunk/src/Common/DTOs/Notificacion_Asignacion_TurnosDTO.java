package common.DTOs;

import java.sql.Date;

public class Notificacion_Asignacion_TurnosDTO extends Notificacion_Area_AdministracionDTO {

	protected static final long serialVersionUID = 1L;
	
	public Notificacion_Asignacion_TurnosDTO(){
		super();
	}
	public Notificacion_Asignacion_TurnosDTO(Date fecha_notificacion, Boolean concretada_notificacion, String texto_notificacion) {
		super(fecha_notificacion,concretada_notificacion,texto_notificacion);
	}

}