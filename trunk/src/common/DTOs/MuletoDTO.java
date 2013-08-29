package common.DTOs;

import java.io.Serializable;

public class MuletoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_muleto;
	private String descripcion;
	private String vin;
	private PedidoDTO numero_pedido;
	private PiezaDTO numero_pieza;
	
	public MuletoDTO(int id_muleto, String descripcion, String vin,
			PedidoDTO numero_pedido, PiezaDTO numero_pieza) {
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
	
	
}
