package cliente;

import common.DTOs.UsuarioDTO;
import cliente.GestionarRegistrante.MediadorRegistrante;
import cliente.GestionarUsuario.MediadorUsuario;
import cliente.login.GUILogin;


public class MediadorPrincipal{

	protected GUIMenu_Principal gui_menu_Principal;
	protected GUILogin gui_login; 
	protected MediadorUsuario mediadorUsuario;
	protected MediadorRegistrante mediadorRegistrante; 
	protected UsuarioDTO usuario;
	
	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public MediadorPrincipal() throws Exception{
		usuario = new UsuarioDTO("Matias", "pass", "matias@matias.com.ar");
		usuario.setId(new Long(1));
		gui_login = new GUILogin(this);
		gui_login.setVisible(true);
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public boolean acceso(String usuario, String contrasenia) {
		gui_menu_Principal = new GUIMenu_Principal(this);
		gui_menu_Principal.setVisible(true);
		return true;
		//
/*		if ((this.usuario.getNombre_usuario().equals(usuario)) && (this.usuario.getClave().equals(contrasenia))){
			gui_menu_Principal = new GUIMenu_Principal(this);
			gui_menu_Principal.setVisible(true);
			return true;
		}else{
			return false;
		}*/
	}
	
	public void reiniciar(){
		gui_menu_Principal.dispose();
		gui_login = new GUILogin(this);
		gui_login.setVisible(true);
	}

	public void salir() {
		gui_menu_Principal.dispose();
		gui_login.dispose();
		System.exit(1);
		// TODO Auto-generated method stub
	}
	// Usuarios //
	public void altaUsuario(){
		mediadorUsuario = new MediadorUsuario(this);
		mediadorUsuario.altaUsuario();
	}

	public void gestionarUsuario(){
		mediadorUsuario = new MediadorUsuario(this);
		mediadorUsuario.gestioUsuario();
		
	}
	public void altaUsuario(String nombre_usuario, String email){
		mediadorUsuario = new MediadorUsuario(this);
		mediadorUsuario.altaUsuario(nombre_usuario, email);
		
	}
	
	// Registrantes //
	public void altaRegistrante(){
		mediadorRegistrante = new MediadorRegistrante(this);
		mediadorRegistrante.altaRegistrante();
	}

	public void gestionarRegistrante(){
		mediadorRegistrante = new MediadorRegistrante(this);
		mediadorRegistrante.gestioRegistrante();
		
	}
	public void altaRegistrante(String nombre_registrante, String tipo){
		mediadorRegistrante = new MediadorRegistrante(this);
		mediadorRegistrante.altaRegistrante(nombre_registrante, tipo);
		
	}
	
}
