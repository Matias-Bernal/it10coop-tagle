package common.DTOs;

import java.io.Serializable;

public class VehiculoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String dominio;
	private String vin;
	private String nombre_titular;
	private MarcaDTO nombre_marca;
	private ModeloDTO nombre_modelo;
	
	public VehiculoDTO(String dominio, String vin, String nombre_titular,
			MarcaDTO nombre_marca, ModeloDTO nombre_modelo) {
		super();
		this.dominio = dominio;
		this.vin = vin;
		this.nombre_titular = nombre_titular;
		this.nombre_marca = nombre_marca;
		this.nombre_modelo = nombre_modelo;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getNombre_titular() {
		return nombre_titular;
	}

	public void setNombre_titular(String nombre_titular) {
		this.nombre_titular = nombre_titular;
	}

	public MarcaDTO getNombre_marca() {
		return nombre_marca;
	}

	public void setNombre_marca(MarcaDTO nombre_marca) {
		this.nombre_marca = nombre_marca;
	}

	public ModeloDTO getNombre_modelo() {
		return nombre_modelo;
	}

	public void setNombre_modelo(ModeloDTO nombre_modelo) {
		this.nombre_modelo = nombre_modelo;
	}
	
	
}
