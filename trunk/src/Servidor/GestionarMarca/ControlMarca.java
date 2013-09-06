package servidor.GestionarMarca;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.MarcaDTO;
import common.GestionarMarca.IControlMarca;

public class ControlMarca extends UnicastRemoteObject implements IControlMarca {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlMarca() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarMarca(MarcaDTO marca) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarMarca(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarMarca(Long id, MarcaDTO modificado) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<MarcaDTO> obtenerAdministrativo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<MarcaDTO> obtenerAdministrativo(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<MarcaDTO> obtenerAdministrativo_Nombre(String nombre_marca)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeMarca(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeMarca(String nombre_marca) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MarcaDTO buscarMarca(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MarcaDTO buscarMarca(String nombre_marca) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
