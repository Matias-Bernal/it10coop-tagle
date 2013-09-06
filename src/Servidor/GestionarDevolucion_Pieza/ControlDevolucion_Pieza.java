package servidor.GestionarDevolucion_Pieza;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.Vector;

import common.DTOs.Devolucion_PiezaDTO;
import common.GestionarDevolucion_Pieza.IControlDevolucion_Pieza;

public class ControlDevolucion_Pieza extends UnicastRemoteObject implements IControlDevolucion_Pieza{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlDevolucion_Pieza() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarDevolucion_Pieza(Devolucion_PiezaDTO devolucion_pieza)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarDevolucion_Pieza(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarDevolucion_Pieza(Long id,
			Devolucion_PiezaDTO modificado) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Devolucion_PiezaDTO> obtenerDevolucion_Pieza()
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Devolucion_PiezaDTO> obtenerDevolucion_Pieza(
			String numero_remito) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Devolucion_PiezaDTO> obtenerDevolucion_Pieza(
			Date fecha_devolucion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Devolucion_PiezaDTO> obtenerDevolucion_Pieza_Trasnporte(
			String transporte) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeDevolucion_Pieza(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeDevolucion_Pieza(String numero_remito)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeDevolucion_Pieza(String numero_remito,
			Date fecha_devolucion) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}


}