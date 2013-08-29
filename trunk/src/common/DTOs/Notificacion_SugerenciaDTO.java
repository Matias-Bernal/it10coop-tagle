package common.DTOs;

import java.io.Serializable;

public class Notificacion_SugerenciaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_sugerencia;
	private Notificacion_Area_RepuestoDTO id_area_repuesto;
	private NotificacionDTO id_notificacion;
	
	public Notificacion_SugerenciaDTO(int id_sugerencia,
			Notificacion_Area_RepuestoDTO id_area_repuesto,
			NotificacionDTO id_notificacion) {
		super();
		this.id_sugerencia = id_sugerencia;
		this.id_area_repuesto = id_area_repuesto;
		this.id_notificacion = id_notificacion;
	}
	public int getId_sugerencia() {
		return id_sugerencia;
	}
	public void setId_sugerencia(int id_sugerencia) {
		this.id_sugerencia = id_sugerencia;
	}
	public Notificacion_Area_RepuestoDTO getId_area_repuesto() {
		return id_area_repuesto;
	}
	public void setId_area_repuesto(Notificacion_Area_RepuestoDTO id_area_repuesto) {
		this.id_area_repuesto = id_area_repuesto;
	}
	public NotificacionDTO getId_notificacion() {
		return id_notificacion;
	}
	public void setId_notificacion(NotificacionDTO id_notificacion) {
		this.id_notificacion = id_notificacion;
	}
	
	
}
