package servidor.GestionarNotificacion_Asignacion_Turnos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.Notificacion_Asignacion_TurnosDTO;
import common.GestionarNotificacion_Asignacion_Turnos.IControlNotificacion_Asignacion_Turnos;

public class ControlNotificacion_Asignacion_Turnos extends UnicastRemoteObject implements IControlNotificacion_Asignacion_Turnos{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlNotificacion_Asignacion_Turnos() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarNotificacion_Asignacion_Turnos(
			Notificacion_Asignacion_TurnosDTO notificacion_asignacion_turnos)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarNotificacion_Asignacion_Turnos(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarNotificacion_Asignacion_Turnos(Long id,
			Notificacion_Asignacion_TurnosDTO modificado) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Notificacion_Asignacion_TurnosDTO> obtenerNotificacion_Asignacion_Turnos()
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Notificacion_Asignacion_TurnosDTO> obtenerNotificacion_Asignacion_Turnos(
			Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Notificacion_Asignacion_TurnosDTO> obtenerNotificacion_Asignacion_Turnos(
			Boolean concretada_notificacion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeNotificacion_Asignacion_Turnos(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeNotificacion_Asignacion_Turnos(
			Notificacion_Asignacion_TurnosDTO notificacion_asignacion_turnos)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Notificacion_Asignacion_TurnosDTO buscarAdministrativo(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notificacion_Asignacion_TurnosDTO buscarAdministrativo(
			Notificacion_Asignacion_TurnosDTO notificacion_asignacion_turnos)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
