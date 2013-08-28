package servidor.persistencia.dominio;

public class Estado_Pedido {
	
	private String estado_pedido;

	public Estado_Pedido(String estado_pedido) {
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
