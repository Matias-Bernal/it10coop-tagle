package servidor.GestionarNotificacion_Reclamo_Fabrica;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.Notificacion_Reclamo_FabricaDTO;
import common.GestionarNotificacion_Reclamo_Fabrica.IControlNotificacion_Reclamo_Fabrica;

public class ControlNotificacion_Reclamo_Fabrica extends UnicastRemoteObject implements IControlNotificacion_Reclamo_Fabrica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlNotificacion_Reclamo_Fabrica() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarNotificacion_Reclamo_Fabrica(
			Notificacion_Reclamo_FabricaDTO Notificacion_Reclamo_Fabrica)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarNotificacion_Reclamo_Fabrica(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarNotificacion_Reclamo_Fabrica(Long id,
			Notificacion_Reclamo_FabricaDTO modificado) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Notificacion_Reclamo_FabricaDTO> obtenerNotificacion_Reclamo_Fabrica()
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Notificacion_Reclamo_FabricaDTO> obtenerNotificacion_Reclamo_Fabrica(
			Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Notificacion_Reclamo_FabricaDTO> obtenerNotificacion_Reclamo_Fabrica(
			Boolean concretada_notificacion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeNotificacion_Reclamo_Fabrica(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeNotificacion_Reclamo_Fabrica(
			Notificacion_Reclamo_FabricaDTO Notificacion_Reclamo_Fabrica)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Notificacion_Reclamo_FabricaDTO buscarAdministrativo(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notificacion_Reclamo_FabricaDTO buscarAdministrativo(
			Notificacion_Reclamo_FabricaDTO Notificacion_Reclamo_Fabrica)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}