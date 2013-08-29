package cliente.principal;

import cliente.menu_principal.GUIMenu_Principal;


public class MediadorPrincipal{
	private GUILogin guiLogin;
	public GUIMenu_Principal guiMenu_Principal;
	
	public MediadorPrincipal() throws Exception{
		guiLogin = new GUILogin();
		guiMenu_Principal = new GUIMenu_Principal();
		guiMenu_Principal.setVisible(false);
	}

	public void show() {
		guiLogin.setVisible(true);
	}
	
}
