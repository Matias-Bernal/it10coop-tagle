package servidor.persistencia.dominio;


import java.sql.Date;

public class Pedido {
	
	private String numero_pedido;
	private Date fecha_solicitud_pedido;
	private Date fecha_solicitud_fabrica;
	private Date fecha_recepcion_fabrica;
	private String numero_orden_trabajo;
	private String pnc;
	private Estado_Pedido estado_pedido;
	private Reclamo id_reclamo;
	
	public Pedido(String numero_pedido, Date fecha_solicitud_pedido,
			Date fecha_solicitud_fabrica, Date fecha_recepcion_fabrica,
			String numero_orden_trabajo, String pnc,
			Estado_Pedido estado_pedido, Reclamo id_reclamo) {
		super();
		this.numero_pedido = numero_pedido;
		this.fecha_solicitud_pedido = fecha_solicitud_pedido;
		this.fecha_solicitud_fabrica = fecha_solicitud_fabrica;
		this.fecha_recepcion_fabrica = fecha_recepcion_fabrica;
		this.numero_orden_trabajo = numero_orden_trabajo;
		this.pnc = pnc;
		this.estado_pedido = estado_pedido;
		this.id_reclamo = id_reclamo;
	}
	public String getNumero_pedido() {
		return numero_pedido;
	}
	public void setNumero_pedido(String numero_pedido) {
		this.numero_pedido = numero_pedido;
	}
	public Date getFecha_solicitud_pedido() {
		return fecha_solicitud_pedido;
	}
	public void setFecha_solicitud_pedido(Date fecha_solicitud_pedido) {
		this.fecha_solicitud_pedido = fecha_solicitud_pedido;
	}
	public Date getFecha_solicitud_fabrica() {
		return fecha_solicitud_fabrica;
	}
	public void setFecha_solicitud_fabrica(Date fecha_solicitud_fabrica) {
		this.fecha_solicitud_fabrica = fecha_solicitud_fabrica;
	}
	public Date getFecha_recepcion_fabrica() {
		return fecha_recepcion_fabrica;
	}
	public void setFecha_recepcion_fabrica(Date fecha_recepcion_fabrica) {
		this.fecha_recepcion_fabrica = fecha_recepcion_fabrica;
	}
	public String getNumero_orden_trabajo() {
		return numero_orden_trabajo;
	}
	public void setNumero_orden_trabajo(String numero_orden_trabajo) {
		this.numero_orden_trabajo = numero_orden_trabajo;
	}
	public String getPnc() {
		return pnc;
	}
	public void setPnc(String pnc) {
		this.pnc = pnc;
	}
	public Estado_Pedido getEstado_pedido() {
		return estado_pedido;
	}
	public void setEstado_pedido(Estado_Pedido estado_pedido) {
		this.estado_pedido = estado_pedido;
	}
	public Reclamo getId_reclamo() {
		return id_reclamo;
	}
	public void setId_reclamo(Reclamo id_reclamo) {
		this.id_reclamo = id_reclamo;
	}
	
}
