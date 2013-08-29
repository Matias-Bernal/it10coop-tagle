package servidor.persistencia.dominio;


public class Notificacion_Contencion_Cliente {
	
	private int id_contencion_cliente;
	private Notificacion_Area_Administracion id_area_administracion;
	private Notificacion id_notificacion;
	
	public Notificacion_Contencion_Cliente(int id_contencion_cliente,
			Notificacion_Area_Administracion id_area_administracion,
			Notificacion id_notificacion) {
		super();
		this.id_contencion_cliente = id_contencion_cliente;
		this.id_area_administracion = id_area_administracion;
		this.id_notificacion = id_notificacion;
	}
	public int getId_contencion_cliente() {
		return id_contencion_cliente;
	}
	public void setId_contencion_cliente(int id_contencion_cliente) {
		this.id_contencion_cliente = id_contencion_cliente;
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