package servidor.GestionarAgente;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.AgenteDTO;
import common.GestionarAgente.IControlAgente;

public class ControlAgente extends UnicastRemoteObject implements IControlAgente{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlAgente() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarAgente(AgenteDTO agente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarAgente(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarAgente(Long id, AgenteDTO modificado) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<AgenteDTO> obtenerAgente() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<AgenteDTO> obtenerAgente(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<AgenteDTO> obtenerAgente(String nombre_agente)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeAgente(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeAgente(String nombre_agente) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AgenteDTO buscarAgente(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgenteDTO buscarAgente(String nombre_agente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}