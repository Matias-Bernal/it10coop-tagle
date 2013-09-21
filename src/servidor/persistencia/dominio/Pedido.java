package servidor.persistencia.dominio;

import java.sql.Date;

public class Pedido {

	protected String numero_pedido;
	protected Date fecha_solicitud_pedido;
	protected Date fecha_solicitud_fabrica;
	protected Date fecha_recepcion_fabrica;
	protected String pnc;
	protected Reclamo reclamo;
	protected Long id;

	public Pedido() {
	}

	public Pedido(String numero_pedido, Date fecha_solicitud_pedido,
			Date fecha_solicitud_fabrica, Date fecha_recepcion_fabrica,
			String pnc, Reclamo reclamo) {
		super();
		this.numero_pedido = numero_pedido;
		this.fecha_solicitud_pedido = fecha_solicitud_pedido;
		this.fecha_solicitud_fabrica = fecha_solicitud_fabrica;
		this.fecha_recepcion_fabrica = fecha_recepcion_fabrica;
		this.pnc = pnc;
		this.reclamo = reclamo;
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

	public String getPnc() {
		return pnc;
	}

	public void setPnc(String pnc) {
		this.pnc = pnc;
	}

	public Reclamo getReclamo() {
		return reclamo;
	}

	public void setReclamo(Reclamo reclamo) {
		this.reclamo = reclamo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}