package servidor.persistencia.dominio;


import java.sql.Date;

public class Bdg  extends ClaseGeneral {
	
	protected Date fecha_bdg;
	protected Pieza pieza;
	protected Pedido pedido;
	
	public Bdg(Date fecha_bdg, Pieza pieza,Pedido pedido) {
		super();
		this.fecha_bdg = fecha_bdg;
		this.pieza = pieza;
		this.pedido = pedido;
	}
	public Date getFecha_bdg() {
		return fecha_bdg;
	}
	public void setFecha_bdg(Date fecha_bdg) {
		this.fecha_bdg = fecha_bdg;
	}
	public Pieza getPieza() {
		return pieza;
	}
	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	

}
