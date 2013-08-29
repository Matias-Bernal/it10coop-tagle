package common.DTOs;

import java.io.Serializable;
import java.sql.Date;

public class BdgDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_bdg;
	private Date fecha_bdg;
	private PiezaDTO numero_pieza;
	private PedidoDTO numero_pedido;
	
	public BdgDTO(int id_bdg, Date fecha_bdg, PiezaDTO numero_pieza,
			PedidoDTO numero_pedido) {
		super();
		this.id_bdg = id_bdg;
		this.fecha_bdg = fecha_bdg;
		this.numero_pieza = numero_pieza;
		this.numero_pedido = numero_pedido;
	}
	public int getId_bdg() {
		return id_bdg;
	}
	public void setId_bdg(int id_bdg) {
		this.id_bdg = id_bdg;
	}
	public Date getFecha_bdg() {
		return fecha_bdg;
	}
	public void setFecha_bdg(Date fecha_bdg) {
		this.fecha_bdg = fecha_bdg;
	}
	public PiezaDTO getNumero_pieza() {
		return numero_pieza;
	}
	public void setNumero_pieza(PiezaDTO numero_pieza) {
		this.numero_pieza = numero_pieza;
	}
	public PedidoDTO getNumero_pedido() {
		return numero_pedido;
	}
	public void setNumero_pedido(PedidoDTO numero_pedido) {
		this.numero_pedido = numero_pedido;
	}
	

}
