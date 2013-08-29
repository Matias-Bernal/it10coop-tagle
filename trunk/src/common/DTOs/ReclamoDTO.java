package common.DTOs;

import java.io.Serializable;
import java.sql.Date;

public class ReclamoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_reclamo;
	private Date fecha_reclamo;
	private Date fecha_turno;
	private String estado_reclamo;
	private RegistranteDTO nombre_registrante;
	private ReclamanteDTO id_reclamante;
	private VehiculoDTO dominio;
	private Boolean inmovilizado;
	private Boolean peligroso;
	private UsuarioDTO nombre_usuario;
	
	public ReclamoDTO(int id_reclamo, Date fecha_reclamo, Date fecha_turno,
			String estado_reclamo, RegistranteDTO nombre_registrante,
			ReclamanteDTO id_reclamante, VehiculoDTO dominio, Boolean inmovilizado,
			Boolean peligroso, UsuarioDTO nombre_usuario) {
		super();
		this.id_reclamo = id_reclamo;
		this.fecha_reclamo = fecha_reclamo;
		this.fecha_turno = fecha_turno;
		this.estado_reclamo = estado_reclamo;
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

	public RegistranteDTO getNombre_registrante() {
		return nombre_registrante;
	}

	public void setNombre_registrante(RegistranteDTO nombre_registrante) {
		this.nombre_registrante = nombre_registrante;
	}

	public ReclamanteDTO getId_reclamante() {
		return id_reclamante;
	}

	public void setId_reclamante(ReclamanteDTO id_reclamante) {
		this.id_reclamante = id_reclamante;
	}

	public VehiculoDTO getDominio() {
		return dominio;
	}

	public void setDominio(VehiculoDTO dominio) {
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

	public UsuarioDTO getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(UsuarioDTO nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	
}
