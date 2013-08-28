package cliente.principal;


public class MediadorPrincipal{
	private GUILogin guiLogin;
	public GUIMenu_Principal guiMenu_Principal;
	
	public MediadorPrincipal() throws Exception{
		guiLogin = new GUILogin();
		guiLogin.setVisible(true);
		guiMenu_Principal = new GUIMenu_Principal();
		guiMenu_Principal.setVisible(false);
	}
	
}
