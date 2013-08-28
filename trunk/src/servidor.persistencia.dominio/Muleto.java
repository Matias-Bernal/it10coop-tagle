package servidor.persistencia.dominio;

public class Muleto {

	private int id_muleto;
	private String descripcion;
	private String vin;
	private Pedido numero_pedido;
	private Pieza numero_pieza;
	
	public Muleto(int id_muleto, String descripcion, String vin,
			Pedido numero_pedido, Pieza numero_pieza) {
		super();
		this.id_muleto = id_muleto;
		this.descripcion = descripcion;
		this.vin = vin;
		this.numero_pedido = numero_pedido;
		this.numero_pieza = numero_pieza;
	}
	public int getId_muleto() {
		return id_muleto;
	}
	public void setId_muleto(int id_muleto) {
		this.id_muleto = id_muleto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
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
	
	
}
