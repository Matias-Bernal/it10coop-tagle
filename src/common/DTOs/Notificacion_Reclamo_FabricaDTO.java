package common.DTOs;

import java.io.Serializable;

public class Notificacion_Reclamo_FabricaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_reclamo_fabrica;
	private Notificacion_Area_RepuestoDTO id_area_repuesto;
	private NotificacionDTO id_notificacion;
	
	public Notificacion_Reclamo_FabricaDTO(int id_reclamo_fabrica,
			Notificacion_Area_RepuestoDTO id_area_repuesto,
			NotificacionDTO id_notificacion) {
		super();
		this.id_reclamo_fabrica = id_reclamo_fabrica;
		this.id_area_repuesto = id_area_repuesto;
		this.id_notificacion = id_notificacion;
	}
	public int getId_reclamo_fabrica() {
		return id_reclamo_fabrica;
	}
	public void setId_reclamo_fabrica(int id_reclamo_fabrica) {
		this.id_reclamo_fabrica = id_reclamo_fabrica;
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
