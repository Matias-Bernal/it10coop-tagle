package common.DTOs;

import java.sql.Date;

public class PedidoDTO extends ClaseGeneralDTO {

	protected static final long serialVersionUID = 1L;
	protected String numero_pedido;
	protected Date fecha_solicitud_pedido;
	protected Date fecha_solicitud_fabrica;
	protected Date fecha_recepcion_fabrica;
	protected String numero_orden_trabajo;
	protected String pnc;
	protected Estado_PedidoDTO estado_pedido;
	protected ReclamoDTO reclamo;
	
	public PedidoDTO(String numero_pedido, Date fecha_solicitud_pedido,
			Date fecha_solicitud_fabrica, Date fecha_recepcion_fabrica,
			String numero_orden_trabajo, String pnc,
			Estado_PedidoDTO estado_pedido, ReclamoDTO reclamo) {
		super();
		this.numero_pedido = numero_pedido;
		this.fecha_solicitud_pedido = fecha_solicitud_pedido;
		this.fecha_solicitud_fabrica = fecha_solicitud_fabrica;
		this.fecha_recepcion_fabrica = fecha_recepcion_fabrica;
		this.numero_orden_trabajo = numero_orden_trabajo;
		this.pnc = pnc;
		this.estado_pedido = estado_pedido;
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
	public Estado_PedidoDTO getEstado_pedido() {
		return estado_pedido;
	}
	public void setEstado_pedido(Estado_PedidoDTO estado_pedido) {
		this.estado_pedido = estado_pedido;
	}
	public ReclamoDTO getReclamo() {
		return reclamo;
	}
	public void setReclamo(ReclamoDTO reclamo) {
		this.reclamo = reclamo;
	}

}
