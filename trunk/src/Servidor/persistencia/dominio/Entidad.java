package servidor.persistencia.dominio;


public class Entidad {
	
	private int id_entidad;
	private Registrante nombre_registrante;

	public Entidad(int id_entidad, Registrante nombre_registrante) {
		super();
		this.id_entidad = id_entidad;
		this.nombre_registrante = nombre_registrante;
	}

	public int getId_entidad() {
		return id_entidad;
	}

	public void setId_entidad(int id_entidad) {
		this.id_entidad = id_entidad;
	}

	public Registrante getNombre_registrante() {
		return nombre_registrante;
	}

	public void setNombre_registrante(Registrante nombre_registrante) {
		this.nombre_registrante = nombre_registrante;
	}
}
