package cliente.GestionarReclamante;

import java.util.Vector;

import cliente.MediadorPrincipal;
import cliente.GestionarRegistrante.GUIVerReclamante;

public class MediadorReclamante {

	protected GUIAltaReclamante guiAltaReclamante;
	protected GUIGestionReclamante guiGestionReclamante;
	protected MediadorPrincipal mediadorPrincipal;
	protected GUIVerReclamante verReclamante;

	public MediadorReclamante(MediadorPrincipal mediadorPrincipal) {
		this.mediadorPrincipal = mediadorPrincipal;
	}
	
	public void altaReclamante() {
		guiAltaReclamante = new GUIAltaReclamante(this);
		guiAltaReclamante.setVisible(true);
	}

	public void gestionReclamante() {
		guiGestionReclamante = 	new GUIGestionReclamante(this);
		guiGestionReclamante.setVisible(true);
	}

	public void altaReclamante(String nombre_reclamante, String email, String telefono) {
		guiAltaReclamante = new GUIAltaReclamante(this, nombre_reclamante, email, telefono);
		guiAltaReclamante.setVisible(true);

	}

	public void verRegistrante(Long id) {
		String nombre = "Matias";
		String email = "Matias@matias.com.ar";
		Vector<String>	telefonos = new Vector<String>();
		telefonos.add("4647678 (Fijo)");
		telefonos.add("156021284 (Celular)");
		System.out.println("ID NUMERO: "+id.toString());
		verReclamante = new GUIVerReclamante(this,nombre,email,telefonos);
		verReclamante.SetVisible(true);

	}

	public void reiniciar() {
		guiGestionReclamante.reiniciar();
	}

}
