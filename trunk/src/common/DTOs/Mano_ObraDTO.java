package common.DTOs;

import java.io.Serializable;

public class Mano_ObraDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_mano_obra;
	private float cantidad_horas;
	private float valor_mano_obra;
	private String codigo_mano_obra;
	private ReclamoDTO id_reclamo;
	
	public Mano_ObraDTO(int id_mano_obra, float cantidad_horas,
			float valor_mano_obra, String codigo_mano_obra, ReclamoDTO id_reclamo) {
		super();
		this.id_mano_obra = id_mano_obra;
		this.cantidad_horas = cantidad_horas;
		this.valor_mano_obra = valor_mano_obra;
		this.codigo_mano_obra = codigo_mano_obra;
		this.id_reclamo = id_reclamo;
	}
	public int getId_mano_obra() {
		return id_mano_obra;
	}
	public void setId_mano_obra(int id_mano_obra) {
		this.id_mano_obra = id_mano_obra;
	}
	public float getCantidad_horas() {
		return cantidad_horas;
	}
	public void setCantidad_horas(float cantidad_horas) {
		this.cantidad_horas = cantidad_horas;
	}
	public float getValor_mano_obra() {
		return valor_mano_obra;
	}
	public void setValor_mano_obra(float valor_mano_obra) {
		this.valor_mano_obra = valor_mano_obra;
	}
	public String getCodigo_mano_obra() {
		return codigo_mano_obra;
	}
	public void setCodigo_mano_obra(String codigo_mano_obra) {
		this.codigo_mano_obra = codigo_mano_obra;
	}
	public ReclamoDTO getId_reclamo() {
		return id_reclamo;
	}
	public void setId_reclamo(ReclamoDTO id_reclamo) {
		this.id_reclamo = id_reclamo;
	}
	
	

}
