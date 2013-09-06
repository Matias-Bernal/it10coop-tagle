package servidor.GestionarNotificacion_Area_Repuesto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.Notificacion_Area_RepuestoDTO;
import common.GestionarNotificacion_Area_Repuesto.IControlNotificacion_Area_Repuesto;

public class ControlNotificacion_Area_Repuesto extends UnicastRemoteObject implements IControlNotificacion_Area_Repuesto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlNotificacion_Area_Repuesto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarNotificacion_Area_Repuesto(
			Notificacion_Area_RepuestoDTO notificacion_area_repuesto)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarNotificacion_Area_Repuesto(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarNotificacion_Area_Repuesto(Long id,
			Notificacion_Area_RepuestoDTO modificado) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Notificacion_Area_RepuestoDTO> obtenerNotificacion_Area_Repuesto()
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Notificacion_Area_RepuestoDTO> obtenerNotificacion_Area_Repuesto(
			Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Notificacion_Area_RepuestoDTO> obtenerNotificacion_Area_Repuesto(
			Boolean concretada_notificacion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeNotificacion_Area_Repuesto(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeNotificacion_Area_Repuesto(
			Notificacion_Area_RepuestoDTO notificacion_area_repuesto)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Notificacion_Area_RepuestoDTO buscarAdministrativo(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notificacion_Area_RepuestoDTO buscarAdministrativo(
			Notificacion_Area_RepuestoDTO notificacion_area_repuesto)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
