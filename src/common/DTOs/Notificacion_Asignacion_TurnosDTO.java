package common.DTOs;

import java.io.Serializable;

public class Notificacion_Asignacion_TurnosDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_asignacion_turnos;
	private Notificacion_Area_AdministracionDTO id_area_administracion;
	private NotificacionDTO id_notificacion;
	
	public Notificacion_Asignacion_TurnosDTO(int id_asignacion_turnos,
			Notificacion_Area_AdministracionDTO id_area_administracion,
			NotificacionDTO id_notificacion) {
		super();
		this.id_asignacion_turnos = id_asignacion_turnos;
		this.id_area_administracion = id_area_administracion;
		this.id_notificacion = id_notificacion;
	}
	public int getId_asignacion_turnos() {
		return id_asignacion_turnos;
	}
	public void setId_asignacion_turnos(int id_asignacion_turnos) {
		this.id_asignacion_turnos = id_asignacion_turnos;
	}
	public Notificacion_Area_AdministracionDTO getId_area_administracion() {
		return id_area_administracion;
	}
	public void setId_area_administracion(
			Notificacion_Area_AdministracionDTO id_area_administracion) {
		this.id_area_administracion = id_area_administracion;
	}
	public NotificacionDTO getId_notificacion() {
		return id_notificacion;
	}
	public void setId_notificacion(NotificacionDTO id_notificacion) {
		this.id_notificacion = id_notificacion;
	}
	
	
}
