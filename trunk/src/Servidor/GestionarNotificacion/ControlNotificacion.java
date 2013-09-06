package servidor.GestionarNotificacion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.NotificacionDTO;
import common.GestionarNotificacion.IControlNotificacion;

public class  ControlNotificacion extends UnicastRemoteObject implements IControlNotificacion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlNotificacion() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarNotificacion(NotificacionDTO Notificacion)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarNotificacion(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarNotificacion(Long id, NotificacionDTO modificado)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<NotificacionDTO> obtenerNotificacion() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<NotificacionDTO> obtenerNotificacion(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<NotificacionDTO> obtenerNotificacion(
			Boolean concretada_notificacion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeNotificacion(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeNotificacion(NotificacionDTO Notificacion)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NotificacionDTO buscarAdministrativo(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotificacionDTO buscarAdministrativo(NotificacionDTO Notificacion)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
