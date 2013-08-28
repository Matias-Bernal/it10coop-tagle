package servidor.persistencia.dominio;

import java.sql.Date;

public class Recurso {

	private int id_recurso;
	private Date fecha_recurso;
	private String numero_recurso;
	
	public Recurso(int id_recurso, Date fecha_recurso, String numero_recurso) {
		super();
		this.id_recurso = id_recurso;
		this.fecha_recurso = fecha_recurso;
		this.numero_recurso = numero_recurso;
	}

	public int getId_recurso() {
		return id_recurso;
	}

	public void setId_recurso(int id_recurso) {
		this.id_recurso = id_recurso;
	}

	public Date getFecha_recurso() {
		return fecha_recurso;
	}

	public void setFecha_recurso(Date fecha_recurso) {
		this.fecha_recurso = fecha_recurso;
	}

	public String getNumero_recurso() {
		return numero_recurso;
	}

	public void setNumero_recurso(String numero_recurso) {
		this.numero_recurso = numero_recurso;
	}
}
