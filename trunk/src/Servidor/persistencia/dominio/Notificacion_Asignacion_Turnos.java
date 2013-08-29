package servidor.persistencia.dominio;


public class Notificacion_Asignacion_Turnos {

	private int id_asignacion_turnos;
	private Notificacion_Area_Administracion id_area_administracion;
	private Notificacion id_notificacion;
	
	public Notificacion_Asignacion_Turnos(int id_asignacion_turnos,
			Notificacion_Area_Administracion id_area_administracion,
			Notificacion id_notificacion) {
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
	public Notificacion_Area_Administracion getId_area_administracion() {
		return id_area_administracion;
	}
	public void setId_area_administracion(
			Notificacion_Area_Administracion id_area_administracion) {
		this.id_area_administracion = id_area_administracion;
	}
	public Notificacion getId_notificacion() {
		return id_notificacion;
	}
	public void setId_notificacion(Notificacion id_notificacion) {
		this.id_notificacion = id_notificacion;
	}
	
	
}
