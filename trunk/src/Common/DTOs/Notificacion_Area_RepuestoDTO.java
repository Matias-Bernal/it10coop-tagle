package common.DTOs;

import java.io.Serializable;

public class Notificacion_Area_RepuestoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_area_repuesto;
	private NotificacionDTO id_notificacion;
	
	public Notificacion_Area_RepuestoDTO(int id_area_repuesto,
			NotificacionDTO id_notificacion) {
		super();
		this.id_area_repuesto = id_area_repuesto;
		this.id_notificacion = id_notificacion;
	}
	public int getId_area_repuesto() {
		return id_area_repuesto;
	}
	public void setId_area_repuesto(int id_area_repuesto) {
		this.id_area_repuesto = id_area_repuesto;
	}
	public NotificacionDTO getId_notificacion() {
		return id_notificacion;
	}
	public void setId_notificacion(NotificacionDTO id_notificacion) {
		this.id_notificacion = id_notificacion;
	}
	
}
