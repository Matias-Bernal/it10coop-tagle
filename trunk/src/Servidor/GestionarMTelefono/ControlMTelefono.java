package servidor.GestionarMTelefono;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.MTelefonoDTO;
import common.DTOs.ReclamanteDTO;
import common.GestionarMTelefono.IControlMTelefono;

public class ControlMTelefono extends UnicastRemoteObject implements IControlMTelefono{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlMTelefono() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarMTelefono(MTelefonoDTO mTelefono) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarMTelefono(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarMTelefono(Long id, MTelefonoDTO modificado)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<MTelefonoDTO> obtenerMTelefono() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<MTelefonoDTO> obtenerMTelefono(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<MTelefonoDTO> obtenerAdministrativo_Nombre(
			ReclamanteDTO reclamante) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeAdministrativo(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeAdministrativo(ReclamanteDTO reclamante,
			String telefono) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MTelefonoDTO buscarAdministrativo(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MTelefonoDTO buscarAdministrativo(ReclamanteDTO reclamante)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MTelefonoDTO buscarAdministrativo(ReclamanteDTO reclamante,
			String telefono) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}