package servidor.GestionarNotificacion_Sugerencia;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.Notificacion_SugerenciaDTO;
import common.GestionarNotificacion_Sugerencia.IControlNotificacion_Sugerencia;

public class ControlNotificacion_Sugerencia extends UnicastRemoteObject implements IControlNotificacion_Sugerencia{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlNotificacion_Sugerencia() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarNotificacion_Sugerencia(
			Notificacion_SugerenciaDTO Notificacion_Sugerencia)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarNotificacion_Sugerencia(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarNotificacion_Sugerencia(Long id,
			Notificacion_SugerenciaDTO modificado) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Notificacion_SugerenciaDTO> obtenerNotificacion_Sugerencia()
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Notificacion_SugerenciaDTO> obtenerNotificacion_Sugerencia(
			Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Notificacion_SugerenciaDTO> obtenerNotificacion_Sugerencia(
			Boolean concretada_notificacion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeNotificacion_Sugerencia(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeNotificacion_Sugerencia(
			Notificacion_SugerenciaDTO Notificacion_Sugerencia)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Notificacion_SugerenciaDTO buscarAdministrativo(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notificacion_SugerenciaDTO buscarAdministrativo(
			Notificacion_SugerenciaDTO Notificacion_Sugerencia)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	



}
