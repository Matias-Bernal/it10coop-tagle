package common.DTOs;

import java.io.Serializable;
import java.sql.Date;

public class Pedido_PiezaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private PedidoDTO numero_pedido;
	private PiezaDTO numero_pieza;
	private Boolean stock;
	private Boolean propio;
	private MuletoDTO id_muleto;
	private Devolucion_PiezaDTO id_devolucion_pieza;
	private Estado_PedidoDTO estado_pedido;
	private Date fecha_estado;
	private BdgDTO id_bdg;
	private RecursoDTO id_recurso;
	private Mano_ObraDTO id_mano_obra;
	
	public Pedido_PiezaDTO(PedidoDTO numero_pedido, PiezaDTO numero_pieza,
			Boolean stock, Boolean propio, MuletoDTO id_muleto,
			Devolucion_PiezaDTO id_devolucion_pieza, Estado_PedidoDTO estado_pedido,
			Date fecha_estado, BdgDTO id_bdg, RecursoDTO id_recurso,
			Mano_ObraDTO id_mano_obra) {
		super();
		this.numero_pedido = numero_pedido;
		this.numero_pieza = numero_pieza;
		this.stock = stock;
		this.propio = propio;
		this.id_muleto = id_muleto;
		this.id_devolucion_pieza = id_devolucion_pieza;
		this.estado_pedido = estado_pedido;
		this.fecha_estado = fecha_estado;
		this.id_bdg = id_bdg;
		this.id_recurso = id_recurso;
		this.id_mano_obra = id_mano_obra;
	}
	public PedidoDTO getNumero_pedido() {
		return numero_pedido;
	}
	public void setNumero_pedido(PedidoDTO numero_pedido) {
		this.numero_pedido = numero_pedido;
	}
	public PiezaDTO getNumero_pieza() {
		return numero_pieza;
	}
	public void setNumero_pieza(PiezaDTO numero_pieza) {
		this.numero_pieza = numero_pieza;
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
	public MuletoDTO getId_muleto() {
		return id_muleto;
	}
	public void setId_muleto(MuletoDTO id_muleto) {
		this.id_muleto = id_muleto;
	}
	public Devolucion_PiezaDTO getId_devolucion_pieza() {
		return id_devolucion_pieza;
	}
	public void setId_devolucion_pieza(Devolucion_PiezaDTO id_devolucion_pieza) {
		this.id_devolucion_pieza = id_devolucion_pieza;
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
	public BdgDTO getId_bdg() {
		return id_bdg;
	}
	public void setId_bdg(BdgDTO id_bdg) {
		this.id_bdg = id_bdg;
	}
	public RecursoDTO getId_recurso() {
		return id_recurso;
	}
	public void setId_recurso(RecursoDTO id_recurso) {
		this.id_recurso = id_recurso;
	}
	public Mano_ObraDTO getId_mano_obra() {
		return id_mano_obra;
	}
	public void setId_mano_obra(Mano_ObraDTO id_mano_obra) {
		this.id_mano_obra = id_mano_obra;
	}

}
