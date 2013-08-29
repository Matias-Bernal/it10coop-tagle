package common.DTOs;

import java.io.Serializable;

public class ReclamanteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_reclamante;
	private String nombre_apellido;
	private String email;
	
	
	public ReclamanteDTO(int id_reclamante, String nombre_apellido, String email) {
		super();
		this.id_reclamante = id_reclamante;
		this.nombre_apellido = nombre_apellido;
		this.email = email;
	}
	
	public int getId_reclamante() {
		return id_reclamante;
	}
	public void setId_reclamante(int id_reclamante) {
		this.id_reclamante = id_reclamante;
	}
	public String getNombre_apellido() {
		return nombre_apellido;
	}
	public void setNombre_apellido(String nombre_apellido) {
		this.nombre_apellido = nombre_apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
