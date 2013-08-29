package common.DTOs;

import java.io.Serializable;

public class EntidadDTO implements Serializable{

	private static final long serialVersionUID = 1L;	
	private int id_entidad;
	private RegistranteDTO nombre_registrante;

	public EntidadDTO(int id_entidad, RegistranteDTO nombre_registrante) {
		super();
		this.id_entidad = id_entidad;
		this.nombre_registrante = nombre_registrante;
	}

	public int getId_entidad() {
		return id_entidad;
	}

	public void setId_entidad(int id_entidad) {
		this.id_entidad = id_entidad;
	}

	public RegistranteDTO getNombre_registrante() {
		return nombre_registrante;
	}

	public void setNombre_registrante(RegistranteDTO nombre_registrante) {
		this.nombre_registrante = nombre_registrante;
	}
}
