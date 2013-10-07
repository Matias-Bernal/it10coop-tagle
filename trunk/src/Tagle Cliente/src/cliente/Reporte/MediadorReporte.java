package cliente.Reporte;

import cliente.MediadorPrincipal;

public class MediadorReporte {
	
	private GUIReporte guiReporte;
	
	private MediadorPrincipal mediadorPrincipal;
	
	
	public MediadorReporte(MediadorPrincipal mediadorPrincipal) {
		this.setMediadorPrincipal(mediadorPrincipal);
	}
	
	public void mostrarReportes(){
		guiReporte = new GUIReporte(this);
		guiReporte.setVisible(true);
	}

	public MediadorPrincipal getMediadorPrincipal() {
		return mediadorPrincipal;
	}

	public void setMediadorPrincipal(MediadorPrincipal mediadorPrincipal) {
		this.mediadorPrincipal = mediadorPrincipal;
	}
}
