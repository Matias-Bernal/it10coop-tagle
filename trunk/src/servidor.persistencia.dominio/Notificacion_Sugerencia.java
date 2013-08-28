package servidor.persistencia.dominio;

public class Notificacion_Sugerencia {

	private int id_sugerencia;
	private Notificacion_Area_Repuesto id_area_repuesto;
	private Notificacion id_notificacion;
	
	public Notificacion_Sugerencia(int id_sugerencia,
			Notificacion_Area_Repuesto id_area_repuesto,
			Notificacion id_notificacion) {
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
