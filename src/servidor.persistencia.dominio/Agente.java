package servidor.persistencia.dominio;

public class Agente {
	
	private int id_agente;
	private Registrante nombre_registrante;

	public Agente(int id_agente, Registrante nombre_registrante) {
		super();
		this.id_agente = id_agente;
		this.nombre_registrante = nombre_registrante;
	}
	
	public int getId_agente() {
		return id_agente;
	}

	public void setId_agente(int id_agente) {
		this.id_agente = id_agente;
	}

	public Registrante getNombre_registrante() {
		return nombre_registrante;
	}

	public void setNombre_registrante(Registrante nombre_registrante) {
		this.nombre_registrante = nombre_registrante;
	}
}
