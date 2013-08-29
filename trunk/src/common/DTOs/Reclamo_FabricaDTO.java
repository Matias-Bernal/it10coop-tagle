package common.DTOs;

import java.io.Serializable;
import java.sql.Date;

public class Reclamo_FabricaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_reclamo_fabrica;
	private Date fecha_reclamo_fabrica;
	private PiezaDTO numero_pieza;
	private PedidoDTO numero_pedido;
	private UsuarioDTO nombre_usuario;
	
	public Reclamo_FabricaDTO(int id_reclamo_fabrica, Date fecha_reclamo_fabrica,
			PiezaDTO numero_pieza, PedidoDTO numero_pedido, UsuarioDTO nombre_usuario) {
		super();
		this.id_reclamo_fabrica = id_reclamo_fabrica;
		this.fecha_reclamo_fabrica = fecha_reclamo_fabrica;
		this.numero_pieza = numero_pieza;
		this.numero_pedido = numero_pedido;
		this.nombre_usuario = nombre_usuario;
	}
	public int getId_reclamo_fabrica() {
		return id_reclamo_fabrica;
	}
	public void setId_reclamo_fabrica(int id_reclamo_fabrica) {
		this.id_reclamo_fabrica = id_reclamo_fabrica;
	}
	public Date getFecha_reclamo_fabrica() {
		return fecha_reclamo_fabrica;
	}
	public void setFecha_reclamo_fabrica(Date fecha_reclamo_fabrica) {
		this.fecha_reclamo_fabrica = fecha_reclamo_fabrica;
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
	public UsuarioDTO getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(UsuarioDTO nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

}
