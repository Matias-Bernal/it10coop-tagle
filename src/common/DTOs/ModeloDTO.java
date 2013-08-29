package common.DTOs;

import java.io.Serializable;

public class ModeloDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre_modelo;
	private MarcaDTO nombre_marca;
	
	public ModeloDTO(String nombre_modelo, MarcaDTO nombre_marca) {
		super();
		this.nombre_modelo = nombre_modelo;
		this.nombre_marca = nombre_marca;
	}
	public String getNombre_modelo() {
		return nombre_modelo;
	}
	public void setNombre_modelo(String nombre_modelo) {
		this.nombre_modelo = nombre_modelo;
	}
	public MarcaDTO getNombre_marca() {
		return nombre_marca;
	}
	public void setNombre_marca(MarcaDTO nombre_marca) {
		this.nombre_marca = nombre_marca;
	}
	
}
