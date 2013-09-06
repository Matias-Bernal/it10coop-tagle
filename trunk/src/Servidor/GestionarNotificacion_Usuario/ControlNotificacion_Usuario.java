package servidor.GestionarNotificacion_Usuario;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.Notificacion_UsuarioDTO;
import common.GestionarNotificacion_Usuario.IControlNotificacion_Usuario;

public class ControlNotificacion_Usuario extends UnicastRemoteObject implements IControlNotificacion_Usuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlNotificacion_Usuario() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarNotificacion_Usuario(
			Notificacion_UsuarioDTO notificacion_usuario) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarNotificacion_Usuario(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarNotificacion_Usuario(Long id,
			Notificacion_UsuarioDTO modificado) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Notificacion_UsuarioDTO> obtenerNotificacion_Usuario()
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Notificacion_UsuarioDTO> obtenerNotificacion_Usuario(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Notificacion_UsuarioDTO> obtenerNotificacion_Usuario(
			Boolean concretada_notificacion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeNotificacion_Usuario(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeNotificacion_Usuario(
			Notificacion_UsuarioDTO Notificacion_Usuario) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Notificacion_UsuarioDTO buscarAdministrativo(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notificacion_UsuarioDTO buscarAdministrativo(
			Notificacion_UsuarioDTO notificacion_asignacion_tTurnos)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
