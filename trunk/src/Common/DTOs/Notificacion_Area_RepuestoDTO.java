package common.DTOs;

import java.sql.Date;

public class Notificacion_Area_RepuestoDTO extends NotificacionDTO {

	protected static final long serialVersionUID = 1L;
	
	public Notificacion_Area_RepuestoDTO(Date fecha_notificacion, Boolean concretada_notificacion, String texto_notificacion) {
		super(fecha_notificacion,concretada_notificacion,texto_notificacion);
	}

}