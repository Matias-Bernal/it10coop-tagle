package servidor.persistencia.dominio;


public class Encargado_Repuesto {
	
	private int id_encargado_repuesto;
	private Usuario nombre_usuario;
	
	public Encargado_Repuesto(int id_encargado_repuesto, Usuario nombre_usuario) {
		super();
		this.id_encargado_repuesto = id_encargado_repuesto;
		this.nombre_usuario = nombre_usuario;
	}
	public int getId_encargado_repuesto() {
		return id_encargado_repuesto;
	}
	public void setId_encargado_repuesto(int id_encargado_repuesto) {
		this.id_encargado_repuesto = id_encargado_repuesto;
	}
	public Usuario getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(Usuario nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	

}
