package servidor.GestionarPedido_Pieza_Reclamo_Fabrica;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.Pedido_Pieza_Reclamo_FabricaDTO;
import common.DTOs.PedidoDTO;
import common.DTOs.PiezaDTO;
import common.DTOs.Reclamo_FabricaDTO;
import common.GestionarPedido_Pieza_Reclamo_Fabrica.IControlPedido_Pieza_Reclamo_Fabrica;

public class ControlPedido_Pieza_Reclamo_Fabrica extends UnicastRemoteObject implements IControlPedido_Pieza_Reclamo_Fabrica{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlPedido_Pieza_Reclamo_Fabrica() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarPedido_Pieza_Reclamo_Fabrica(
			Pedido_Pieza_Reclamo_FabricaDTO Pedido_Pieza_Reclamo_Fabrica)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarPedido_Pieza_Reclamo_Fabrica(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarPedido_Pieza_Reclamo_Fabrica(Long id,
			Pedido_Pieza_Reclamo_FabricaDTO modificado) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Pedido_Pieza_Reclamo_FabricaDTO> obtenerPedido_Pieza_Reclamo_Fabrica()
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Pedido_Pieza_Reclamo_FabricaDTO> obtenerPedido_Pieza_Reclamo_Fabrica(
			Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existePedido_Pieza_Reclamo_Fabrica(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existePedido_Pieza_Reclamo_Fabrica(PedidoDTO pedido,
			PiezaDTO pieza, Reclamo_FabricaDTO reclamo_fabrica)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pedido_Pieza_Reclamo_FabricaDTO buscarPedido_Pieza_Reclamo_Fabrica(
			Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido_Pieza_Reclamo_FabricaDTO buscarPedido_Pieza_Reclamo_Fabrica(
			PedidoDTO pedido, PiezaDTO pieza, Reclamo_FabricaDTO reclamo_fabrica)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
 
}
