package servidor.GestionarNotificacion_Area_Administracion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.Notificacion_Area_AdministracionDTO;
import common.GestionarNotificacion_Area_Administracion.IControlNotificacion_Area_Administracion;

public class ControlNotificacion_Area_Administracion extends UnicastRemoteObject implements IControlNotificacion_Area_Administracion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlNotificacion_Area_Administracion() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarNotificacion_Area_Administracion(
			Notificacion_Area_AdministracionDTO notificacion_area_administracion)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarNotificacion_Area_Administracion(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarNotificacion_Area_Administracion(Long id,
			Notificacion_Area_AdministracionDTO modificado) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Notificacion_Area_AdministracionDTO> obtenerNotificacion_Area_Administracion()
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Notificacion_Area_AdministracionDTO> obtenerNotificacion_Area_Administracion(
			Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Notificacion_Area_AdministracionDTO> obtenerNotificacion_Area_Administracion(
			Boolean concretada_notificacion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeNotificacion_Area_Administracion(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeNotificacion_Area_Administracion(
			Notificacion_Area_AdministracionDTO notificacion_area_administracion)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Notificacion_Area_AdministracionDTO buscarAdministrativo(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notificacion_Area_AdministracionDTO buscarAdministrativo(
			Notificacion_Area_AdministracionDTO notificacion_area_administracion)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
