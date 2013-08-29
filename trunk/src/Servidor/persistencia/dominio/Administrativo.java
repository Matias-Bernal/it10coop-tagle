package servidor.persistencia.dominio;


public class Administrativo {
	
	private int id_administrativo;
	private Usuario nombre_usuario;
	
	public Administrativo(int id_administrativo, Usuario nombre_usuario) {
		super();
		this.id_administrativo = id_administrativo;
		this.nombre_usuario = nombre_usuario;
	}
	public int getId_administrativo() {
		return id_administrativo;
	}
	public void setId_administrativo(int id_administrativo) {
		this.id_administrativo = id_administrativo;
	}
	public Usuario getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(Usuario nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	
	
	
}
