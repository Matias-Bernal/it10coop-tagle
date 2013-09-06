package servidor.GestionarEncargado_Repuesto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.Encargado_RepuestoDTO;
import common.GestionarEncargado_Repuesto.IControlEncargado_Repuesto;

public class ControlEncargado_Repuesto extends UnicastRemoteObject implements IControlEncargado_Repuesto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlEncargado_Repuesto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarEncargado_Repuesto(Encargado_RepuestoDTO devolucion_pieza)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarEncargado_Repuesto(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarEncargado_Repuesto(Long id,
			Encargado_RepuestoDTO modificado) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Encargado_RepuestoDTO> obtenerEncargado_Repuesto()
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Encargado_RepuestoDTO> obtenerEncargado_Repuesto(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Encargado_RepuestoDTO> obtenerEncargado_Repuesto_Nombre(
			String nombre_administrativo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Encargado_RepuestoDTO> obtenerEncargado_Repuesto_Email(
			String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeEncargado_Repuesto(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeEncargado_Repuesto(String nombre_administrativo)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Encargado_RepuestoDTO buscarEncargado_Repuesto(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Encargado_RepuestoDTO buscarEncargado_Repuesto(
			String nombre_administrativo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	


}