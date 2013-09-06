package servidor.GestionarNotificacion_Contencion_Cliente;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.Notificacion_Contencion_ClienteDTO;
import common.GestionarNotificacion_Contencion_Cliente.IControlNotificacion_Contencion_Cliente;

public class ControlNotificacion_Contencion_Cliente extends UnicastRemoteObject implements IControlNotificacion_Contencion_Cliente{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlNotificacion_Contencion_Cliente() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarNotificacion_Contencion_Cliente(
			Notificacion_Contencion_ClienteDTO Notificacion_Contencion_Cliente)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarNotificacion_Contencion_Cliente(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarNotificacion_Contencion_Cliente(Long id,
			Notificacion_Contencion_ClienteDTO modificado) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Notificacion_Contencion_ClienteDTO> obtenerNotificacion_Contencion_Cliente()
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Notificacion_Contencion_ClienteDTO> obtenerNotificacion_Contencion_Cliente(
			Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Notificacion_Contencion_ClienteDTO> obtenerNotificacion_Contencion_Cliente(
			Boolean concretada_notificacion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeNotificacion_Contencion_Cliente(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeNotificacion_Contencion_Cliente(
			Notificacion_Contencion_ClienteDTO Notificacion_Contencion_Cliente)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Notificacion_Contencion_ClienteDTO buscarAdministrativo(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notificacion_Contencion_ClienteDTO buscarAdministrativo(
			Notificacion_Contencion_ClienteDTO Notificacion_Contencion_Cliente)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	


}
