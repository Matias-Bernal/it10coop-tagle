package servidor.persistencia.dominio;


public class Reclamante_Reclamo extends ClaseGeneral  {
	
	protected Reclamante reclamante;
	protected Reclamo reclamo;
	
	public Reclamante_Reclamo(Reclamante reclamante, Reclamo reclamo) {
		super();
		this.reclamante = reclamante;
		this.reclamo = reclamo;
	}
	public Reclamante getReclamante() {
		return reclamante;
	}
	public void setReclamante(Reclamante reclamante) {
		this.reclamante = reclamante;
	}
	public Reclamo getReclamo() {
		return reclamo;
	}
	public void setReclamo(Reclamo reclamo) {
		this.reclamo = reclamo;
	}

}
