package servidor.GestionarReclamante;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.ReclamanteDTO;
import common.GestionarReclamante.IControlReclamante;

public class ControlReclamante extends UnicastRemoteObject implements IControlReclamante{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlReclamante() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarReclamante(ReclamanteDTO Reclamante) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarReclamante(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarReclamante(Long id, ReclamanteDTO modificado)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<ReclamanteDTO> obtenerReclamantes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeReclamante(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeReclamante(String nombre_apellido) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ReclamanteDTO buscarReclamante(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReclamanteDTO buscarReclamante(String nombre_apellido)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
