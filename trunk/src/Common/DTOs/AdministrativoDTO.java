package common.DTOs;

import java.io.Serializable;

public class AdministrativoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id_administrativo;
	private UsuarioDTO nombre_usuario;
	
	public AdministrativoDTO(int id_administrativo, UsuarioDTO nombre_usuario) {
		super();
		this.id_administrativo = id_administrativo;
		this.nombre_usuario = nombre_usuario;
	}
	public int getId_administrativo() {
		return id_administrativo;
	}
	public void setId_administrativo(int id_administrativo) {
		this.id_administrativo = id_administrativo;
	}
	public UsuarioDTO getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(UsuarioDTO nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	
	
	
}
