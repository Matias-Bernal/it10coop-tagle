package servidor.persistencia.dominio;

public class Notificacion_Area_Administracion {
	
	private int id_area_administracion;
	private Notificacion id_notificacion;
	
	public Notificacion_Area_Administracion(int id_area_administracion,
			Notificacion id_notificacion) {
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
	public Notificacion getId_notificacion() {
		return id_notificacion;
	}
	public void setId_notificacion(Notificacion id_notificacion) {
		this.id_notificacion = id_notificacion;
	}
	
	

}
