package common.DTOs;

import java.sql.Date;

public class Notificacion_SugerenciaDTO extends Notificacion_Area_RepuestoDTO {

	protected static final long serialVersionUID = 1L;
	
	public Notificacion_SugerenciaDTO(){
		super();
	}
	public Notificacion_SugerenciaDTO(Date fecha_notificacion, Boolean concretada_notificacion, String texto_notificacion) {
		super(fecha_notificacion,concretada_notificacion,texto_notificacion);
	}

}