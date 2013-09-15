package common.DTOs;

public class Orden_RecursoDTO  extends ClaseGeneralDTO{

	private static final long serialVersionUID = 1L;
	protected OrdenDTO orden;
	protected RecursoDTO recurso;
	
	public Orden_RecursoDTO() {}

	public Orden_RecursoDTO(OrdenDTO orden, RecursoDTO recurso) {
		super();
		this.orden = orden;
		this.recurso = recurso;
	}
	
	public OrdenDTO getOrden() {
		return orden;
	}

	public void setOrden(OrdenDTO orden) {
		this.orden = orden;
	}

	public RecursoDTO getRecurso() {
		return recurso;
	}

	public void setRecurso(RecursoDTO recurso) {
		this.recurso = recurso;
	}

}
