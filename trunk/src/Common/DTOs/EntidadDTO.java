package common.DTOs;

public class EntidadDTO extends ClaseGeneralDTO {

	protected static final long serialVersionUID = 1L;	
	protected RegistranteDTO registrante;

	public EntidadDTO(RegistranteDTO registrante) {
		super();
		this.registrante = registrante;
	}
	public RegistranteDTO getRegistrante() {
		return registrante;
	}
	public void setRegistrante(RegistranteDTO registrante) {
		this.registrante = registrante;
	}

}
