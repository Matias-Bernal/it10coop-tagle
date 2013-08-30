package common.DTOs;

import java.sql.Date;

public class Devolucion_PiezaDTO extends ClaseGeneralDTO {

	protected static final long serialVersionUID = 1L;
	protected String numero_remito;
	protected Date fecha_devolucion;
	protected String transporte;
	
	public Devolucion_PiezaDTO(String numero_remito, Date fecha_devolucion, String transporte) {
		super();
		this.numero_remito = numero_remito;
		this.fecha_devolucion = fecha_devolucion;
		this.transporte = transporte;
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
