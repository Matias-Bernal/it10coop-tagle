package common.DTOs;

import java.io.Serializable;

public class Notificacion_UsusarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private NotificacionDTO id_notificacion;
	private UsuarioDTO nombre_usuario;
	
	public Notificacion_UsusarioDTO(NotificacionDTO id_notificacion,
			UsuarioDTO nombre_usuario) {
		super();
		this.id_notificacion = id_notificacion;
		this.nombre_usuario = nombre_usuario;
	}
	public NotificacionDTO getId_notificacion() {
		return id_notificacion;
	}
	public void setId_notificacion(NotificacionDTO id_notificacion) {
		this.id_notificacion = id_notificacion;
	}
	public UsuarioDTO getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(UsuarioDTO nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
}
