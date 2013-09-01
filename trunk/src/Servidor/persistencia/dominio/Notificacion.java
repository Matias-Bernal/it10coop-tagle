package servidor.persistencia.dominio;


import java.sql.Date;

public class Notificacion extends ClaseGeneral {
	
	protected Date fecha_notificacion;
	protected Boolean concretada_notificacion;
	protected String texto_notificacion;
	
	public Notificacion(){}	
	public Notificacion( Date fecha_notificacion,
			Boolean concretada_notificacion, String texto_notificacion) {
		super();
		this.fecha_notificacion = fecha_notificacion;
		this.concretada_notificacion = concretada_notificacion;
		this.texto_notificacion = texto_notificacion;
	}
	public Date getFecha_notificacion() {
		return fecha_notificacion;
	}
	public void setFecha_notificacion(Date fecha_notificacion) {
		this.fecha_notificacion = fecha_notificacion;
	}
	public Boolean getConcretada_notificacion() {
		return concretada_notificacion;
	}
	public void setConcretada_notificacion(Boolean concretada_notificacion) {
		this.concretada_notificacion = concretada_notificacion;
	}
	public String getTexto_notificacion() {
		return texto_notificacion;
	}
	public void setTexto_notificacion(String texto_notificacion) {
		this.texto_notificacion = texto_notificacion;
	}

	
}
