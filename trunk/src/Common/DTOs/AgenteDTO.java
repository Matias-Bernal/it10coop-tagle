package common.DTOs;

import java.io.Serializable;

public class AgenteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_agente;
	private RegistranteDTO nombre_registrante;

	public AgenteDTO(int id_agente, RegistranteDTO nombre_registrante) {
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

	public RegistranteDTO getNombre_registrante() {
		return nombre_registrante;
	}

	public void setNombre_registrante(RegistranteDTO nombre_registrante) {
		this.nombre_registrante = nombre_registrante;
	}
}
