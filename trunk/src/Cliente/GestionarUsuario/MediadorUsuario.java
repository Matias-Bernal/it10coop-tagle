package cliente.GestionarUsuario;

import common.DTOs.UsuarioDTO;

import cliente.MediadorPrincipal;

public class MediadorUsuario {
	
	protected GUIAltaUsuario guiAltaUsuario;
	protected GUIGestionUsuario guiGestionUsuario;
	protected MediadorPrincipal mediadorPrincipal;

	public MediadorUsuario(MediadorPrincipal mediadorPrincipal){
		this.mediadorPrincipal = mediadorPrincipal;
	}
	
	public void altaUsuario(){
		guiAltaUsuario = new GUIAltaUsuario(this);
		guiAltaUsuario.setVisible(true);
	}
	public void altaUsuario(String nombre_usuario, String email, String Tipo){
		guiAltaUsuario = new GUIAltaUsuario(this,nombre_usuario,email, Tipo);
		guiAltaUsuario.setVisible(true);
	}
	
	public void gestioUsuario(){
		guiGestionUsuario = new GUIGestionUsuario(this);
		guiGestionUsuario.setVisible(true);
	}

	public boolean nuevoUsuario(String nombre_usuario, String clave , String email ,String tipo){
		UsuarioDTO nuevo_usuario = new UsuarioDTO(nombre_usuario, clave, email, tipo);
		//Chequeo de existencia y hacer persistente en BD
		//si hubo error retornar falso en caso contrario true
		return true;
		
	}

}
