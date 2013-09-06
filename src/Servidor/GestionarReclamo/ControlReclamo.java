package servidor.GestionarReclamo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.Vector;

import common.DTOs.ReclamanteDTO;
import common.DTOs.ReclamoDTO;
import common.DTOs.VehiculoDTO;
import common.GestionarReclamo.IControlReclamo;

public class ControlReclamo extends UnicastRemoteObject implements IControlReclamo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlReclamo() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarReclamo(ReclamoDTO Reclamo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarReclamo(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarReclamo(Long id, ReclamoDTO modificado)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<ReclamoDTO> obtenerReclamos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<ReclamoDTO> obtenerReclamos(Date fecha_reclamo)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<ReclamoDTO> obtenerReclamos(String estado_reclamo)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<ReclamoDTO> obtenerReclamos(ReclamanteDTO reclamante)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<ReclamoDTO> obtenerReclamos(VehiculoDTO vehiculo)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeReclamo(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeReclamo(Date fecha_reclamo, ReclamanteDTO reclamante,
			VehiculoDTO vehiculo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ReclamoDTO buscarReclamo(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReclamoDTO buscarReclamo(Date fecha_reclamo,
			ReclamanteDTO reclamante, VehiculoDTO vehiculo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	


}
