package servidor.persistencia.dominio;


public class Registrante {
	
	private String nombre_registrante;

	public String getNombre_registrante() {
		return nombre_registrante;
	}

	public void setNombre_registrante(String nombre_registrante) {
		this.nombre_registrante = nombre_registrante;
	}

	public Registrante(String nombre_registrante) {
		super();
		this.nombre_registrante = nombre_registrante;
	}
}