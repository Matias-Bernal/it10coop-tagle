package common.DTOs;

import java.io.Serializable;

public class Estado_PedidoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String estado_pedido;

	public Estado_PedidoDTO(String estado_pedido) {
		super();
		this.estado_pedido = estado_pedido;
	}

	public String getEstado_pedido() {
		return estado_pedido;
	}

	public void setEstado_pedido(String estado_pedido) {
		this.estado_pedido = estado_pedido;
	}

}
