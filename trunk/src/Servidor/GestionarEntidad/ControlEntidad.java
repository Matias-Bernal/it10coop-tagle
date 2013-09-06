package servidor.GestionarEntidad;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.EntidadDTO;
import common.GestionarEntidad.IControlEntidad;

public class ControlEntidad extends UnicastRemoteObject implements IControlEntidad{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlEntidad() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarEntidad(EntidadDTO entidad) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarEntidad(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarEntidad(Long id, EntidadDTO modificado)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<EntidadDTO> obtenerEntidad() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<EntidadDTO> obtenerEntidad(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<EntidadDTO> obtenerAdministrativo_Nombre(String nombre_entidad)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeEntidad(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeEntidad(String nombre_entidad) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EntidadDTO buscarEntidad(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntidadDTO buscarEntidad(String nombre_entidad) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
