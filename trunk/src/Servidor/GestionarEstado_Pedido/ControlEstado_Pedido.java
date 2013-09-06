package servidor.GestionarEstado_Pedido;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.Estado_PedidoDTO;
import common.GestionarEstado_Pedido.IControlEstado_Pedido;

public class ControlEstado_Pedido extends UnicastRemoteObject implements IControlEstado_Pedido{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlEstado_Pedido() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarEstado_Pedido(Estado_PedidoDTO estado_pedido)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarEstado_Pedido(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarEstado_Pedido(Long id, Estado_PedidoDTO modificado)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Estado_PedidoDTO> obtenerEstado_Pedido() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Estado_PedidoDTO> obtenerEstado_Pedido(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Estado_PedidoDTO> obtenerEstado_Pedido(String estado_pedido)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeEstado_Pedido(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeEstado_Pedido(String estado_pedido) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Estado_PedidoDTO buscarEstado_Pedido(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estado_PedidoDTO buscarEstado_Pedido(String estado_pedido)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}