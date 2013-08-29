package servidor.persistencia.dominio;



public class Vehiculo {

	private String dominio;
	private String vin;
	private String nombre_titular;
	private Marca nombre_marca;
	private Modelo nombre_modelo;
	
	public Vehiculo(String dominio, String vin, String nombre_titular,
			Marca nombre_marca, Modelo nombre_modelo) {
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

	public Marca getNombre_marca() {
		return nombre_marca;
	}

	public void setNombre_marca(Marca nombre_marca) {
		this.nombre_marca = nombre_marca;
	}

	public Modelo getNombre_modelo() {
		return nombre_modelo;
	}

	public void setNombre_modelo(Modelo nombre_modelo) {
		this.nombre_modelo = nombre_modelo;
	}
	
	
}
