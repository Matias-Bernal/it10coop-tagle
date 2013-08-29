package servidor.persistencia.dominio;


public class Pedido_Pieza_Reclamo_Fabrica {
	
	private Pedido numero_pedido;
	private Pieza numero_pieza;
	private Reclamo_Fabrica id_reclamo_fabrica;
	
	public Pedido_Pieza_Reclamo_Fabrica(Pedido numero_pedido,
			Pieza numero_pieza, Reclamo_Fabrica id_reclamo_fabrica) {
		super();
		this.numero_pedido = numero_pedido;
		this.numero_pieza = numero_pieza;
		this.id_reclamo_fabrica = id_reclamo_fabrica;
	}
	public Pedido getNumero_pedido() {
		return numero_pedido;
	}
	public void setNumero_pedido(Pedido numero_pedido) {
		this.numero_pedido = numero_pedido;
	}
	public Pieza getNumero_pieza() {
		return numero_pieza;
	}
	public void setNumero_pieza(Pieza numero_pieza) {
		this.numero_pieza = numero_pieza;
	}
	public Reclamo_Fabrica getId_reclamo_fabrica() {
		return id_reclamo_fabrica;
	}
	public void setId_reclamo_fabrica(Reclamo_Fabrica id_reclamo_fabrica) {
		this.id_reclamo_fabrica = id_reclamo_fabrica;
	}
}
