package servidor.persistencia.dominio;

public class Orden_Recurso {

	protected Orden orden;
	protected Recurso recurso;
	protected Long id;
	
	public Orden_Recurso(){}

	public Orden_Recurso(Orden orden, Recurso recurso, Long id) {
		super();
		this.orden = orden;
		this.recurso = recurso;
		this.id = id;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
