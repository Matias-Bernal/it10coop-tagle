package cliente.GestionarNotificacion;

import javax.swing.JOptionPane;

import cliente.MediadorAccionesIniciarPrograma;
import cliente.MediadorPrincipal;
import common.DTOs.Notificacion_ReclamoDTO;
import common.DTOs.Notificacion_UsuarioDTO;
import common.DTOs.UsuarioDTO;
import common.GestionarNotificacion.IControlNotificacion;
import common.GestionarNotificacion_Reclamo.IControlNotificacion_Reclamo;
import common.GestionarNotificacion_Usuario.IControlNotificacion_Usuario;

public class MediadorEjecutarNotificacion extends Thread {

	protected MediadorPrincipal mediador_principal;
	private GUINotificacion guiNotificacion;
	private Notificacion_ReclamoDTO notificacion_reclamo;
	private long tiempoInicial;
	private UsuarioDTO usuario;
	
	private boolean posponer;
	private boolean completada;
	
	public MediadorEjecutarNotificacion(MediadorPrincipal mediador_principal, Notificacion_ReclamoDTO notificacion_reclamo,long tiempoInicial,UsuarioDTO usuario){
		this.setMediador_principal(mediador_principal);
		this.tiempoInicial= tiempoInicial;
		this.notificacion_reclamo = notificacion_reclamo;
		this.usuario = usuario;
		setPosponer(false);
		setCompletada(false);
		guiNotificacion = new GUINotificacion(this,notificacion_reclamo.getNotificacion().getTipo_notificacion(),notificacion_reclamo.getNotificacion().getTexto_notificacion());
	}
	
	@Override
	public void run (){
		try {
			sleep(tiempoInicial);
			guiNotificacion.setVisible(true);
			while(!completada){
				if(posponer){
					synchronized (GUINotificacion.class){
						sleep(600000);
						posponer = false;
						guiNotificacion.setVisible(true);
						guiNotificacion.toFront();
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean isCompletada() {
		return completada;
	}

	public void setCompletada(boolean completada) {
		this.completada = completada;
	}

	public boolean isPosponer() {
		return posponer;
	}

	public void setPosponer(boolean posponer) {
		this.posponer = posponer;
	}

	public MediadorPrincipal getMediador_principal() {
		return mediador_principal;
	}

	public void setMediador_principal(MediadorPrincipal mediador_principal) {
		this.mediador_principal = mediador_principal;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
	@SuppressWarnings("deprecation")
	public void destruir(){
		guiNotificacion.dispose();
		this.stop();
	}

	public Notificacion_ReclamoDTO getNotificacion_reclamo() {
		return notificacion_reclamo;
	}

	public void setNotificacion_reclamo(Notificacion_ReclamoDTO notificacion_reclamo) {
		this.notificacion_reclamo = notificacion_reclamo;
	}

	public void verGuiNotificacion() {
		guiNotificacion.setVisible(true);
		guiNotificacion.toFront();	
	}

	@SuppressWarnings("deprecation")
	public void guardarNotificacion() {
		IControlNotificacion iControlNotificacion = MediadorAccionesIniciarPrograma.getControlNotificacion();
		IControlNotificacion_Reclamo iControlNotificacion_Reclamo = MediadorAccionesIniciarPrograma.getControlNotificacion_Reclamo();
		IControlNotificacion_Usuario iControlNotificacion_Usuario = MediadorAccionesIniciarPrograma.getControlNotificacion_Usuario();
		try {
			notificacion_reclamo.getNotificacion().setId(iControlNotificacion.agregarNotificacion(notificacion_reclamo.getNotificacion()));
			notificacion_reclamo.setId(iControlNotificacion_Reclamo.agregarNotificacionReclamo(notificacion_reclamo));
			Notificacion_UsuarioDTO notificacion_usuarioDTO = new Notificacion_UsuarioDTO();
			notificacion_usuarioDTO.setUsuario(usuario);
			notificacion_usuarioDTO.setNotificacion(notificacion_reclamo.getNotificacion());
			iControlNotificacion_Usuario.agregarNotificacion_Usuario(notificacion_usuarioDTO);
			JOptionPane.showMessageDialog(null,"Notificacion Guardada","Advertencia",JOptionPane.INFORMATION_MESSAGE);
			guiNotificacion.dispose();
			this.stop();
			mediador_principal.actualizarTablaNotificaciones();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
