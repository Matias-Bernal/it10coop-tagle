package common.DTOs;

import java.io.Serializable;

public class Encargado_RepuestoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_encargado_repuesto;
	private UsuarioDTO nombre_usuario;
	
	public Encargado_RepuestoDTO(int id_encargado_repuesto, UsuarioDTO nombre_usuario) {
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
	public UsuarioDTO getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(UsuarioDTO nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	

}
