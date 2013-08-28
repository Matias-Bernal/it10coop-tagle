package servidor.persistencia.dominio;

public class Notificacion_Reclamo_Fabrica {

	private int id_reclamo_fabrica;
	private Notificacion_Area_Repuesto id_area_repuesto;
	private Notificacion id_notificacion;
	
	public Notificacion_Reclamo_Fabrica(int id_reclamo_fabrica,
			Notificacion_Area_Repuesto id_area_repuesto,
			Notificacion id_notificacion) {
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
	public Notificacion_Area_Repuesto getId_area_repuesto() {
		return id_area_repuesto;
	}
	public void setId_area_repuesto(Notificacion_Area_Repuesto id_area_repuesto) {
		this.id_area_repuesto = id_area_repuesto;
	}
	public Notificacion getId_notificacion() {
		return id_notificacion;
	}
	public void setId_notificacion(Notificacion id_notificacion) {
		this.id_notificacion = id_notificacion;
	}
	
	
}
