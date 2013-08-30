package common.DTOs;

import java.sql.Date;

public class Pedido_PiezaDTO extends ClaseGeneralDTO {

	protected static final long serialVersionUID = 1L;
	protected PedidoDTO pedido;
	protected PiezaDTO pieza;
	protected Boolean stock;
	protected Boolean propio;
	protected MuletoDTO muleto;
	protected Devolucion_PiezaDTO devolucion_pieza;
	protected Estado_PedidoDTO estado_pedido;
	protected Date fecha_estado;
	protected BdgDTO bdg;
	protected RecursoDTO recurso;
	protected Mano_ObraDTO mano_obra;

	public Pedido_PiezaDTO(PedidoDTO pedido, PiezaDTO pieza, Boolean stock,
			Boolean propio, MuletoDTO muleto,
			Devolucion_PiezaDTO devolucion_pieza,
			Estado_PedidoDTO estado_pedido, Date fecha_estado, BdgDTO bdg,
			RecursoDTO recurso, Mano_ObraDTO mano_obra) {
		super();
		this.pedido = pedido;
		this.pieza = pieza;
		this.stock = stock;
		this.propio = propio;
		this.muleto = muleto;
		this.devolucion_pieza = devolucion_pieza;
		this.estado_pedido = estado_pedido;
		this.fecha_estado = fecha_estado;
		this.bdg = bdg;
		this.recurso = recurso;
		this.mano_obra = mano_obra;
	}
	public PedidoDTO getPedido() {
		return pedido;
	}
	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}
	public PiezaDTO getPieza() {
		return pieza;
	}
	public void setPieza(PiezaDTO pieza) {
		this.pieza = pieza;
	}
	public Boolean getStock() {
		return stock;
	}
	public void setStock(Boolean stock) {
		this.stock = stock;
	}
	public Boolean getPropio() {
		return propio;
	}
	public void setPropio(Boolean propio) {
		this.propio = propio;
	}
	public MuletoDTO getMuleto() {
		return muleto;
	}
	public void setMuleto(MuletoDTO muleto) {
		this.muleto = muleto;
	}
	public Devolucion_PiezaDTO getDevolucion_pieza() {
		return devolucion_pieza;
	}
	public void setDevolucion_pieza(Devolucion_PiezaDTO devolucion_pieza) {
		this.devolucion_pieza = devolucion_pieza;
	}
	public Estado_PedidoDTO getEstado_pedido() {
		return estado_pedido;
	}
	public void setEstado_pedido(Estado_PedidoDTO estado_pedido) {
		this.estado_pedido = estado_pedido;
	}
	public Date getFecha_estado() {
		return fecha_estado;
	}
	public void setFecha_estado(Date fecha_estado) {
		this.fecha_estado = fecha_estado;
	}
	public BdgDTO getBdg() {
		return bdg;
	}
	public void setBdg(BdgDTO bdg) {
		this.bdg = bdg;
	}
	public RecursoDTO getRecurso() {
		return recurso;
	}
	public void setRecurso(RecursoDTO recurso) {
		this.recurso = recurso;
	}
	public Mano_ObraDTO getMano_obra() {
		return mano_obra;
	}
	public void setMano_obra(Mano_ObraDTO mano_obra) {
		this.mano_obra = mano_obra;
	}

}
