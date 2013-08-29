package servidor.persistencia.dominio;


public class Pieza {

	private String numero_pieza;
	private String descripcion;
	
	public Pieza(String numero_pieza, String descripcion) {
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
