package servidor.persistencia.dominio;

public class Administrativo extends Usuario {
	
	
	public Administrativo(){
		super();
	}
	public Administrativo(String nombre_administrativo, String clave, String email){
		super(nombre_administrativo,clave,email);
	}
	
}
