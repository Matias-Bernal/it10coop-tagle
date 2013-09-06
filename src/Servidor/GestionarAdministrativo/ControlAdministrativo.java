package servidor.GestionarAdministrativo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.AdministrativoDTO;
import common.GestionarAdministrativo.IControlAdministrativo;

public class ControlAdministrativo extends UnicastRemoteObject implements IControlAdministrativo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlAdministrativo() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarAdministrativo(AdministrativoDTO administrativo)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarAdministrativo(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarAdministrativo(Long id, AdministrativoDTO modificado)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<AdministrativoDTO> obtenerAdministrativo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<AdministrativoDTO> obtenerAdministrativo(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<AdministrativoDTO> obtenerAdministrativo_Nombre(
			String nombre_administrativo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<AdministrativoDTO> obtenerAdministrativo_Email(String email)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeAdministrativo(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeAdministrativo(String nombre_administrativo)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AdministrativoDTO buscarAdministrativo(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdministrativoDTO buscarAdministrativo(String nombre_administrativo)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	


}