package common.DTOs;

import java.io.Serializable;

public class Notificacion_Area_AdministracionDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_area_administracion;
	private NotificacionDTO id_notificacion;
	
	public Notificacion_Area_AdministracionDTO(int id_area_administracion,
			NotificacionDTO id_notificacion) {
		super();
		this.id_area_administracion = id_area_administracion;
		this.id_notificacion = id_notificacion;
	}
	public int getId_area_administracion() {
		return id_area_administracion;
	}
	public void setId_area_administracion(int id_area_administracion) {
		this.id_area_administracion = id_area_administracion;
	}
	public NotificacionDTO getId_notificacion() {
		return id_notificacion;
	}
	public void setId_notificacion(NotificacionDTO id_notificacion) {
		this.id_notificacion = id_notificacion;
	}
	
	

}
