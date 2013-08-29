package servidor.persistencia.dominio;


import java.sql.Date;

public class Reclamo {
	
	private int id_reclamo;
	private Date fecha_reclamo;
	private Date fecha_turno;
	private String estado_reclamo;
	private Registrante nombre_registrante;
	private Reclamante id_reclamante;
	private Vehiculo dominio;
	private Boolean inmovilizado;
	private Boolean peligroso;
	private Usuario nombre_usuario;
	
	public Reclamo(int id_reclamo, Date fecha_reclamo, Date fecha_turno,
			String estado_reclamoString, Registrante nombre_registrante,
			Reclamante id_reclamante, Vehiculo dominio, Boolean inmovilizado,
			Boolean peligroso, Usuario nombre_usuario) {
		super();
		this.id_reclamo = id_reclamo;
		this.fecha_reclamo = fecha_reclamo;
		this.fecha_turno = fecha_turno;
		this.estado_reclamo = estado_reclamoString;
		this.nombre_registrante = nombre_registrante;
		this.id_reclamante = id_reclamante;
		this.dominio = dominio;
		this.inmovilizado = inmovilizado;
		this.peligroso = peligroso;
		this.nombre_usuario = nombre_usuario;
	}

	public int getId_reclamo() {
		return id_reclamo;
	}

	public void setId_reclamo(int id_reclamo) {
		this.id_reclamo = id_reclamo;
	}

	public Date getFecha_reclamo() {
		return fecha_reclamo;
	}

	public void setFecha_reclamo(Date fecha_reclamo) {
		this.fecha_reclamo = fecha_reclamo;
	}

	public Date getFecha_turno() {
		return fecha_turno;
	}

	public void setFecha_turno(Date fecha_turno) {
		this.fecha_turno = fecha_turno;
	}

	public String getEstado_reclamoString() {
		return estado_reclamo;
	}

	public void setEstado_reclamoString(String estado_reclamoString) {
		this.estado_reclamo = estado_reclamoString;
	}

	public Registrante getNombre_registrante() {
		return nombre_registrante;
	}

	public void setNombre_registrante(Registrante nombre_registrante) {
		this.nombre_registrante = nombre_registrante;
	}

	public Reclamante getId_reclamante() {
		return id_reclamante;
	}

	public void setId_reclamante(Reclamante id_reclamante) {
		this.id_reclamante = id_reclamante;
	}

	public Vehiculo getDominio() {
		return dominio;
	}

	public void setDominio(Vehiculo dominio) {
		this.dominio = dominio;
	}

	public Boolean getInmovilizado() {
		return inmovilizado;
	}

	public void setInmovilizado(Boolean inmovilizado) {
		this.inmovilizado = inmovilizado;
	}

	public Boolean getPeligroso() {
		return peligroso;
	}

	public void setPeligroso(Boolean peligroso) {
		this.peligroso = peligroso;
	}

	public Usuario getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(Usuario nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	
}
