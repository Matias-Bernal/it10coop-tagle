package common.DTOs;

import java.io.Serializable;

public class MarcaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String 	nombre_marca;

	public MarcaDTO(String nombre_marca) {
		super();
		this.nombre_marca = nombre_marca;
	}

	public String getNombre_marca() {
		return nombre_marca;
	}

	public void setNombre_marca(String nombre_marca) {
		this.nombre_marca = nombre_marca;
	}
	
	
}
