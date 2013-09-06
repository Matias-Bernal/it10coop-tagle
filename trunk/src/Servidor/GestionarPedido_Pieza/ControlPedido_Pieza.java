package servidor.GestionarPedido_Pieza;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.Vector;

import common.DTOs.Estado_PedidoDTO;
import common.DTOs.PedidoDTO;
import common.DTOs.Pedido_PiezaDTO;
import common.DTOs.PiezaDTO;
import common.GestionarPedido_Pieza.IControlPedido_Pieza;

public class ControlPedido_Pieza  extends UnicastRemoteObject implements IControlPedido_Pieza{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlPedido_Pieza() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarPedido_Pieza(Pedido_PiezaDTO Pedido_Pieza)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarPedido_Pieza(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarPedido_Pieza(Long id, Pedido_PiezaDTO modificado)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Pedido_PiezaDTO> obtenerPedido_Pieza() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Pedido_PiezaDTO> obtenerPedido_Pieza(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Pedido_PiezaDTO> obtenerPedido_Pieza(Date fecha_estado)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Pedido_PiezaDTO> obtenerPedido_Pieza(
			Estado_PedidoDTO estado_pedido) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existePedido_Pieza(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existePedido_Pieza(PedidoDTO pedido, PiezaDTO pieza)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pedido_PiezaDTO buscarPedido_Pieza(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido_PiezaDTO buscarPedido_Pieza(PedidoDTO pedido, PiezaDTO pieza)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
