package common.DTOs;

import java.io.Serializable;

public class PiezaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String numero_pieza;
	private String descripcion;
	
	public PiezaDTO(String numero_pieza, String descripcion) {
		super();
		this.numero_pieza = numero_pieza;
		this.descripcion = descripcion;
	}

	public String getNumero_pieza() {
		return numero_pieza;
	}

	public void setNumero_pieza(String numero_pieza) {
		this.numero_pieza = numero_pieza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
