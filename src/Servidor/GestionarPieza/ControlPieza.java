package servidor.GestionarPieza;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.PiezaDTO;
import common.GestionarPieza.IControlPieza;

public class ControlPieza extends UnicastRemoteObject implements IControlPieza{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlPieza() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarPieza(PiezaDTO Pieza) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarPieza(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarPieza(Long id, PiezaDTO modificado) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<PiezaDTO> obtenerPiezas() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<PiezaDTO> obtenerPiezas(String numero_pieza) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existePieza(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existePieza(String numero_pieza) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PiezaDTO buscarPieza(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PiezaDTO buscarPieza(String numero_pieza) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}