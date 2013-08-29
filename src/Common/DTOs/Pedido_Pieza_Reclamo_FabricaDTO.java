package common.DTOs;

import java.io.Serializable;

public class Pedido_Pieza_Reclamo_FabricaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private PedidoDTO numero_pedido;
	private PiezaDTO numero_pieza;
	private Reclamo_FabricaDTO id_reclamo_fabrica;
	
	public Pedido_Pieza_Reclamo_FabricaDTO(PedidoDTO numero_pedido,
			PiezaDTO numero_pieza, Reclamo_FabricaDTO id_reclamo_fabrica) {
		super();
		this.numero_pedido = numero_pedido;
		this.numero_pieza = numero_pieza;
		this.id_reclamo_fabrica = id_reclamo_fabrica;
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
	public Reclamo_FabricaDTO getId_reclamo_fabrica() {
		return id_reclamo_fabrica;
	}
	public void setId_reclamo_fabrica(Reclamo_FabricaDTO id_reclamo_fabrica) {
		this.id_reclamo_fabrica = id_reclamo_fabrica;
	}
}
