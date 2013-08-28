package servidor.persistencia.dominio;

public class Notificacion_Area_Repuesto {

	private int id_area_repuesto;
	private Notificacion id_notificacion;
	
	public Notificacion_Area_Repuesto(int id_area_repuesto,
			Notificacion id_notificacion) {
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
	public Notificacion getId_notificacion() {
		return id_notificacion;
	}
	public void setId_notificacion(Notificacion id_notificacion) {
		this.id_notificacion = id_notificacion;
	}
	
}
