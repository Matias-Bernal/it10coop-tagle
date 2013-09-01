package common.DTOs;

import java.sql.Date;

public class Notificacion_Contencion_ClienteDTO extends Notificacion_Area_AdministracionDTO {

	protected static final long serialVersionUID = 1L;
	
	public Notificacion_Contencion_ClienteDTO(){
		super();
	}
	public Notificacion_Contencion_ClienteDTO(Date fecha_notificacion, Boolean concretada_notificacion, String texto_notificacion) {
		super(fecha_notificacion,concretada_notificacion,texto_notificacion);
	}

}