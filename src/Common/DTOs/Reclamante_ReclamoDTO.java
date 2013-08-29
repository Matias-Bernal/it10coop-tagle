package common.DTOs;

import java.io.Serializable;

public class Reclamante_ReclamoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private ReclamanteDTO id_reclamante;
	private ReclamoDTO id_reclamo;
	
	public Reclamante_ReclamoDTO(ReclamanteDTO id_reclamante, ReclamoDTO id_reclamo) {
		super();
		this.id_reclamante = id_reclamante;
		this.id_reclamo = id_reclamo;
	}
	public ReclamanteDTO getId_reclamante() {
		return id_reclamante;
	}
	public void setId_reclamante(ReclamanteDTO id_reclamante) {
		this.id_reclamante = id_reclamante;
	}
	public ReclamoDTO getId_reclamo() {
		return id_reclamo;
	}
	public void setId_reclamo(ReclamoDTO id_reclamo) {
		this.id_reclamo = id_reclamo;
	}

}
