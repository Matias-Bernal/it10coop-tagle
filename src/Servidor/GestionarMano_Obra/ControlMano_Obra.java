package servidor.GestionarMano_Obra;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.Mano_ObraDTO;
import common.DTOs.ReclamoDTO;
import common.GestionarMano_Obra.IControlMano_Obra;

public class ControlMano_Obra extends UnicastRemoteObject implements IControlMano_Obra{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlMano_Obra() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarMano_Obra(Mano_ObraDTO mano_obra) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarMano_Obra(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarMano_Obra(Long id, Mano_ObraDTO modificado)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Mano_ObraDTO> obtenerMano_Obra() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Mano_ObraDTO> obtenerMano_Obra(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Mano_ObraDTO> obtenerMano_Obra_Nombre(String codigo_mano_obra)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Mano_ObraDTO> obtenerMano_Obra_Email(ReclamoDTO reclamo)
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
	public Mano_ObraDTO buscarAdministrativo(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mano_ObraDTO buscarAdministrativo(String codigo_mano_obra)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mano_ObraDTO buscarAdministrativo(ReclamoDTO reclamo,
			String codigo_mano_obra) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	


}
