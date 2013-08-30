package servidor.persistencia.dominio;

public class Notificacion_Ususario extends ClaseGeneral {
	
	protected Notificacion notificacion;
	protected Usuario usuario;

	public Notificacion_Ususario(Notificacion notificacion, Usuario usuario) {
		super();
		this.notificacion = notificacion;
		this.usuario = usuario;
	}

	public Notificacion getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(Notificacion notificacion) {
		this.notificacion = notificacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
