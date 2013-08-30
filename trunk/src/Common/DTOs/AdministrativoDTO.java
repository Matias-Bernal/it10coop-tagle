package common.DTOs;

public class AdministrativoDTO extends UsuarioDTO {

	protected static final long serialVersionUID = 1L;
	
	public AdministrativoDTO(String nombre_administrativo, String clave, String email) {
		super(nombre_administrativo,clave,email);
	}	
	
}
