package servidor.persistencia.dominio;

import java.sql.Date;

public class Pedido_Pieza {
	
	private Pedido numero_pedido;
	private Pieza numero_pieza;
	private Boolean stock;
	private Boolean propio;
	private Muleto id_muleto;
	private Devolucion_Pieza id_devolucion_pieza;
	private Estado_Pedido estado_pedido;
	private Date fecha_estado;
	private Bdg id_bdg;
	private Recurso id_recurso;
	private Mano_Obra id_mano_obra;
	
	public Pedido_Pieza(Pedido numero_pedido, Pieza numero_pieza,
			Boolean stock, Boolean propio, Muleto id_muleto,
			Devolucion_Pieza id_devolucion_pieza, Estado_Pedido estado_pedido,
			Date fecha_estado, Bdg id_bdg, Recurso id_recurso,
			Mano_Obra id_mano_obra) {
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
	public Muleto getId_muleto() {
		return id_muleto;
	}
	public void setId_muleto(Muleto id_muleto) {
		this.id_muleto = id_muleto;
	}
	public Devolucion_Pieza getId_devolucion_pieza() {
		return id_devolucion_pieza;
	}
	public void setId_devolucion_pieza(Devolucion_Pieza id_devolucion_pieza) {
		this.id_devolucion_pieza = id_devolucion_pieza;
	}
	public Estado_Pedido getEstado_pedido() {
		return estado_pedido;
	}
	public void setEstado_pedido(Estado_Pedido estado_pedido) {
		this.estado_pedido = estado_pedido;
	}
	public Date getFecha_estado() {
		return fecha_estado;
	}
	public void setFecha_estado(Date fecha_estado) {
		this.fecha_estado = fecha_estado;
	}
	public Bdg getId_bdg() {
		return id_bdg;
	}
	public void setId_bdg(Bdg id_bdg) {
		this.id_bdg = id_bdg;
	}
	public Recurso getId_recurso() {
		return id_recurso;
	}
	public void setId_recurso(Recurso id_recurso) {
		this.id_recurso = id_recurso;
	}
	public Mano_Obra getId_mano_obra() {
		return id_mano_obra;
	}
	public void setId_mano_obra(Mano_Obra id_mano_obra) {
		this.id_mano_obra = id_mano_obra;
	}

}
