package common.DTOs;

public class Encargado_RepuestoDTO extends UsuarioDTO {

	protected static final long serialVersionUID = 1L;
	
	public Encargado_RepuestoDTO(){
		super();
	}
	public Encargado_RepuestoDTO(String nombre_encargado_repuesto, String clave, String email) {
		super(nombre_encargado_repuesto,clave,email);
	}

}
