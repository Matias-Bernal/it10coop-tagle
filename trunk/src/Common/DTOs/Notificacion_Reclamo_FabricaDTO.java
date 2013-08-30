package common.DTOs;

import java.sql.Date;

public class Notificacion_Reclamo_FabricaDTO extends Notificacion_Area_RepuestoDTO {

	protected static final long serialVersionUID = 1L;
	
	public Notificacion_Reclamo_FabricaDTO(Date fecha_notificacion, Boolean concretada_notificacion, String texto_notificacion) {
		super(fecha_notificacion,concretada_notificacion,texto_notificacion);
	}

}