package servidor.persistencia.dominio;


import java.sql.Date;

public class Recurso extends ClaseGeneral  {

	protected Date fecha_recurso;
	protected String numero_recurso;

	public Recurso(){}
	public Recurso(Date fecha_recurso, String numero_recurso) {
		super();
		this.fecha_recurso = fecha_recurso;
		this.numero_recurso = numero_recurso;
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