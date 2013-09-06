package servidor.GestionarReclamo_Fabrica;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.Vector;

import common.DTOs.PedidoDTO;
import common.DTOs.PiezaDTO;
import common.DTOs.Reclamo_FabricaDTO;
import common.GestionarReclamo_Fabrica.IControlReclamo_Fabrica;

public class ControlReclamo_Fabrica extends UnicastRemoteObject implements IControlReclamo_Fabrica{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlReclamo_Fabrica() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarReclamo_FabricaDTO(Reclamo_FabricaDTO reclamo_fabrica)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarReclamo_FabricaDTO(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarReclamo_Fabrica(Long id, Reclamo_FabricaDTO modificado)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Reclamo_FabricaDTO> obtenerReclamo_Fabrica() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Reclamo_FabricaDTO> obtenerReclamo_Fabrica(PedidoDTO pedido)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Reclamo_FabricaDTO> obtenerReclamo_Fabrica(Date fecha_reclamo)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Reclamo_FabricaDTO> obtenerReclamo_Fabrica(PiezaDTO pieza)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeReclamo_Fabrica(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeReclamo_Fabrica(PedidoDTO pedido, PiezaDTO pieza)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reclamo_FabricaDTO buscarReclamo_FabricaDTO(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reclamo_FabricaDTO buscarReclamo_FabricaDTO(PedidoDTO pedido,
			PiezaDTO pieza) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}