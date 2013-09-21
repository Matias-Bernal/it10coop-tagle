package cliente.GestionarVehiculo;

import cliente.MediadorPrincipal;

public class MediadorVehiculo {
	
	protected GUIAltaVehiculo guiAltaVehiculo;
	protected GUIGestionVehiculo guiGestionVehiculo;
	protected MediadorPrincipal mediadorPrincipal;

	public MediadorVehiculo(MediadorPrincipal mediadorPrincipal) {
		this.mediadorPrincipal = mediadorPrincipal;
	}

	public void altaVehiculo() {
		guiAltaVehiculo = new GUIAltaVehiculo(this);
		guiAltaVehiculo.setVisible(true);
	}

	public void gestionVehiculo() {
		guiGestionVehiculo = new GUIGestionVehiculo(this);
		guiGestionVehiculo.setVisible(true);
	}

	public void altaVehiculo(String nombre_titular, String dominio, String vin, String marca, String modelo) {
		guiAltaVehiculo = new GUIAltaVehiculo(this, nombre_titular, dominio, vin, marca, modelo);
		guiAltaVehiculo.setVisible(true);
	}
	
	public void reiniciar(){
		// TODO hacer esto para cuandos se carga uno nuevo se limpie los campos en el gestionar
	}

}
