package servidor.persistencia.dominio;

public class MTelefono {

	private Reclamante id_reclamante;
	private String telefono;

	public MTelefono(Reclamante id_reclamante, String telefono) {
		super();
		this.id_reclamante = id_reclamante;
		this.telefono = telefono;
	}
	
	public Reclamante getId_reclamante() {
		return id_reclamante;
	}
	public void setId_reclamante(Reclamante id_reclamante) {
		this.id_reclamante = id_reclamante;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
