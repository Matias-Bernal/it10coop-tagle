package servidor.GestionarReclamante_Reclamo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.ReclamanteDTO;
import common.DTOs.Reclamante_ReclamoDTO;
import common.DTOs.ReclamoDTO;
import common.GestionarReclamante_Reclamo.IControlReclamante_Reclamo;

public class ControlReclamante_Reclamo extends UnicastRemoteObject implements IControlReclamante_Reclamo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlReclamante_Reclamo() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarReclamante_Reclamo(
			Reclamante_ReclamoDTO Reclamante_Reclamo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarReclamante_Reclamo(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarReclamante_Reclamo(Long id,
			Reclamante_ReclamoDTO modificado) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Reclamante_ReclamoDTO> obtenerReclamante_Reclamos()
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Reclamante_ReclamoDTO> obtenerReclamante_Reclamos(
			ReclamanteDTO reclamante) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeReclamante_Reclamo(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeReclamante_Reclamo(ReclamanteDTO reclamante,
			ReclamoDTO reclamo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reclamante_ReclamoDTO buscarReclamante_Reclamo(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reclamante_ReclamoDTO buscarReclamante_Reclamo(
			ReclamanteDTO reclamante, ReclamoDTO reclamo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	


}