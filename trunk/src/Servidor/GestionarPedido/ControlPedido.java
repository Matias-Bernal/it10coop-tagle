package servidor.GestionarPedido;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.Vector;

import common.DTOs.PedidoDTO;
import common.DTOs.ReclamoDTO;
import common.GestionarPedido.IControlPedido;

public class ControlPedido extends UnicastRemoteObject implements IControlPedido{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlPedido() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarPedido(PedidoDTO pedido) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarPedido(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarPedido(Long id, PedidoDTO modificado) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<PedidoDTO> obtenerPedidos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<PedidoDTO> obtenerPedidos(String numero_pedido)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<PedidoDTO> obtenerPedidos_Fecha_Solicitud_Pedido(
			Date fecha_solicitud_pedido) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<PedidoDTO> obtenerPedidos_Fecha_Solicitud_Fabrica(
			Date fecha_recepcion_fabrica) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<PedidoDTO> obtenerPedidos_Fecha_Recepcion_Fabrica(
			Date fecha_recepcion_fabrica) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<PedidoDTO> obtenerPedidos(ReclamoDTO reclamo)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existePedido(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existePedido(String numero_pedido) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PedidoDTO buscarPedido(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoDTO buscarPedido(String numero_pedido) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	
}