package servidor.persistencia.dominio;


import java.sql.Date;

public class Pedido_Pieza extends ClaseGeneral {
	
	protected Pedido pedido;
	protected Pieza pieza;
	protected Boolean stock;
	protected Boolean propio;
	protected Muleto muleto;
	protected Devolucion_Pieza devolucion_pieza;
	protected Estado_Pedido estado_pedido;
	protected Date fecha_estado;
	protected Bdg bdg;
	protected Recurso recurso;
	protected Mano_Obra mano_obra;
	
	public Pedido_Pieza(Pedido pedido, Pieza pieza,
			Boolean stock, Boolean propio, Muleto muleto,
			Devolucion_Pieza devolucion_pieza, Estado_Pedido estado_pedido,
			Date fecha_estado, Bdg bdg, Recurso recurso,
			Mano_Obra mano_obra) {
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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
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

	public Muleto getMuleto() {
		return muleto;
	}

	public void setMuleto(Muleto muleto) {
		this.muleto = muleto;
	}

	public Devolucion_Pieza getDevolucion_pieza() {
		return devolucion_pieza;
	}

	public void setDevolucion_pieza(Devolucion_Pieza devolucion_pieza) {
		this.devolucion_pieza = devolucion_pieza;
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

	public Bdg getBdg() {
		return bdg;
	}

	public void setBdg(Bdg bdg) {
		this.bdg = bdg;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public Mano_Obra getMano_obra() {
		return mano_obra;
	}

	public void setMano_obra(Mano_Obra mano_obra) {
		this.mano_obra = mano_obra;
	}

}
