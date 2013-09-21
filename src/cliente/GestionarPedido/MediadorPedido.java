package cliente.GestionarPedido;

import cliente.MediadorPrincipal;

public class MediadorPedido {

	private GUIAltaPedido guiAltaPedido;
	private GUIGestionPedido guiGestionPedido;
	private MediadorPrincipal mediadorPrincipal;
	
	public MediadorPedido(MediadorPrincipal mediadorPrincipal) {
		this.mediadorPrincipal = mediadorPrincipal;
	}

	public void altaPedido() {
		guiAltaPedido = new GUIAltaPedido(this);
		guiAltaPedido.setVisible(true);
		
	}

	public void gestionPedido() {
		guiGestionPedido = new GUIGestionPedido(this);
		guiGestionPedido.setVisible(true);
		
	}

	public void altaPedido(String nombre_registrante, String tipo) {
		// TODO Auto-generated method stub
		
	}

}
