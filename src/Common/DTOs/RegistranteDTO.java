package common.DTOs;

import java.io.Serializable;

public class RegistranteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre_registrante;

	public String getNombre_registrante() {
		return nombre_registrante;
	}

	public void setNombre_registrante(String nombre_registrante) {
		this.nombre_registrante = nombre_registrante;
	}

	public RegistranteDTO(String nombre_registrante) {
		super();
		this.nombre_registrante = nombre_registrante;
	}
}
