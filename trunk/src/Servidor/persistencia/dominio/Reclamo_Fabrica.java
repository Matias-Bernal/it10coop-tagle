package servidor.persistencia.dominio;


import java.sql.Date;

public class Reclamo_Fabrica {
	
	private int id_reclamo_fabrica;
	private Date fecha_reclamo_fabrica;
	private Pieza numero_pieza;
	private Pedido numero_pedido;
	private Usuario nombre_usuario;
	
	public Reclamo_Fabrica(int id_reclamo_fabrica, Date fecha_reclamo_fabrica,
			Pieza numero_pieza, Pedido numero_pedido, Usuario nombre_usuario) {
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
	public Pieza getNumero_pieza() {
		return numero_pieza;
	}
	public void setNumero_pieza(Pieza numero_pieza) {
		this.numero_pieza = numero_pieza;
	}
	public Pedido getNumero_pedido() {
		return numero_pedido;
	}
	public void setNumero_pedido(Pedido numero_pedido) {
		this.numero_pedido = numero_pedido;
	}
	public Usuario getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(Usuario nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

}
