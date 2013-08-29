package common.DTOs;

import java.io.Serializable;

public class MTelefonoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private ReclamanteDTO id_reclamante;
	private String telefono;

	public MTelefonoDTO(ReclamanteDTO id_reclamante, String telefono) {
		super();
		this.id_reclamante = id_reclamante;
		this.telefono = telefono;
	}
	
	public ReclamanteDTO getId_reclamante() {
		return id_reclamante;
	}
	public void setId_reclamante(ReclamanteDTO id_reclamante) {
		this.id_reclamante = id_reclamante;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
