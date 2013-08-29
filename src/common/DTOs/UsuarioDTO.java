package common.DTOs;

import java.io.Serializable;

public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre_usuario;
	private String clave;
	private String email;
	
	public UsuarioDTO(String nombre_usuario, String clave, String email) {
		super();
		this.nombre_usuario = nombre_usuario;
		this.clave = clave;
		this.email = email;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
