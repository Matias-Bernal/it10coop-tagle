package servidor.persistencia.dominio;


public class Modelo {

	private String nombre_modelo;
	private Marca nombre_marca;
	
	public Modelo(String nombre_modelo, Marca nombre_marca) {
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
	public Marca getNombre_marca() {
		return nombre_marca;
	}
	public void setNombre_marca(Marca nombre_marca) {
		this.nombre_marca = nombre_marca;
	}
	
}
