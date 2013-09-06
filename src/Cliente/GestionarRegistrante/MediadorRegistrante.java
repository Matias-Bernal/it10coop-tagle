package cliente.GestionarRegistrante;

import cliente.MediadorPrincipal;
import common.DTOs.AgenteDTO;
import common.DTOs.EntidadDTO;

public class MediadorRegistrante {

	protected GUIAltaRegistrante guiAltaRegistrante;
	protected GUIGestionRegistrante guiGestionRegistrante;
	protected MediadorPrincipal mediadorPrincipal;

	public MediadorRegistrante(MediadorPrincipal mediadorPrincipal){
		this.mediadorPrincipal = mediadorPrincipal;
	}
	
	public void altaRegistrante(){
		guiAltaRegistrante = new GUIAltaRegistrante(this);
		guiAltaRegistrante.setVisible(true);
	}
	public void altaRegistrante(String nombre_usuario, String tipo){
		guiAltaRegistrante = new GUIAltaRegistrante(this,nombre_usuario,tipo);
		guiAltaRegistrante.setVisible(true);
	}

	public boolean nuevoRegistrante(String nombre_registrante,String Tipo){
		
		EntidadDTO nueva_entidad = new EntidadDTO(nombre_registrante);
		AgenteDTO nuevo_agente = new AgenteDTO(nombre_registrante);
		//Chequeo de existencia y hacer persistente en BD
		//si hubo error retornar falso en caso contrario true
		return true;
		
	}

	public void gestioRegistrante() {
		guiGestionRegistrante = new GUIGestionRegistrante(this);
		guiGestionRegistrante.setVisible(true);
		
	}
}
