package servidor.persistencia.dominio;


public class Marca extends ClaseGeneral {
	
	protected String 	nombre_marca;

	public Marca(String nombre_marca) {
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
