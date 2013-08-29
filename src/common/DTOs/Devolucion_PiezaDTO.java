package common.DTOs;

import java.io.Serializable;
import java.sql.Date;

public class Devolucion_PiezaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_devolucion_pieza;
	private String numero_remito;
	private Date fecha_devolucion;
	private String transporte;
	
	public Devolucion_PiezaDTO(int id_devolucion_pieza, String numero_remito,
			Date fecha_devolucion, String transporte) {
		super();
		this.id_devolucion_pieza = id_devolucion_pieza;
		this.numero_remito = numero_remito;
		this.fecha_devolucion = fecha_devolucion;
		this.transporte = transporte;
	}
	public int getId_devolucion_pieza() {
		return id_devolucion_pieza;
	}
	public void setId_devolucion_pieza(int id_devolucion_pieza) {
		this.id_devolucion_pieza = id_devolucion_pieza;
	}
	public String getNumero_remito() {
		return numero_remito;
	}
	public void setNumero_remito(String numero_remito) {
		this.numero_remito = numero_remito;
	}
	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}
	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}
	public String getTransporte() {
		return transporte;
	}
	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}

}
