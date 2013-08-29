package servidor.persistencia.dominio;


public class Notificacion_Ususario {

	private Notificacion id_notificacion;
	private Usuario nombre_usuario;
	
	public Notificacion_Ususario(Notificacion id_notificacion,
			Usuario nombre_usuario) {
		super();
		this.id_notificacion = id_notificacion;
		this.nombre_usuario = nombre_usuario;
	}
	public Notificacion getId_notificacion() {
		return id_notificacion;
	}
	public void setId_notificacion(Notificacion id_notificacion) {
		this.id_notificacion = id_notificacion;
	}
	public Usuario getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(Usuario nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
}
