package servidor.persistencia.dominio;

public class Reclamante {

	protected String nombre_apellido;
	protected String email;
	protected Long id;

	public Reclamante() {
	}

	public Reclamante(String nombre_apellido, String email) {
		super();
		this.nombre_apellido = nombre_apellido;
		this.email = email;
	}

	public String getNombre_apellido() {
		return nombre_apellido;
	}

	public void setNombre_apellido(String nombre_apellido) {
		this.nombre_apellido = nombre_apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
