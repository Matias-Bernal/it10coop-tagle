package servidor.persistencia.dominio;


public class Reclamante_Reclamo {
	
	private Reclamante id_reclamante;
	private Reclamo id_reclamo;
	
	public Reclamante_Reclamo(Reclamante id_reclamante, Reclamo id_reclamo) {
		super();
		this.id_reclamante = id_reclamante;
		this.id_reclamo = id_reclamo;
	}
	public Reclamante getId_reclamante() {
		return id_reclamante;
	}
	public void setId_reclamante(Reclamante id_reclamante) {
		this.id_reclamante = id_reclamante;
	}
	public Reclamo getId_reclamo() {
		return id_reclamo;
	}
	public void setId_reclamo(Reclamo id_reclamo) {
		this.id_reclamo = id_reclamo;
	}

}
