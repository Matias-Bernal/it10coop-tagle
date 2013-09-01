package servidor.persistencia.dominio;


public class Modelo extends ClaseGeneral {

	protected String nombre_modelo;
	protected Marca marca;
	
	public Modelo(){}
	public Modelo(String nombre_modelo, Marca marca) {
		super();
		this.nombre_modelo = nombre_modelo;
		this.marca = marca;
	}
	public String getNombre_modelo() {
		return nombre_modelo;
	}
	public void setNombre_modelo(String nombre_modelo) {
		this.nombre_modelo = nombre_modelo;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
}
