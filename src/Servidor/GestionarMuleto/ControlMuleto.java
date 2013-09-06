package servidor.GestionarMuleto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.MuletoDTO;
import common.DTOs.PedidoDTO;
import common.DTOs.PiezaDTO;
import common.GestionarMuleto.IControlMuleto;

public class ControlMuleto extends UnicastRemoteObject implements IControlMuleto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlMuleto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarMuleto(MuletoDTO muleto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarMuleto(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarMuleto(Long id, MuletoDTO modificado) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<MuletoDTO> obtenerMuleto() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<MuletoDTO> obtenerMuleto(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<MuletoDTO> obtenerMuleto(PedidoDTO reginstrante)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeMuleto(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeMuleto(PedidoDTO pedido, PiezaDTO pieza)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MuletoDTO buscarMuleto(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MuletoDTO buscarMuleto(PedidoDTO pedido, PiezaDTO pieza)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
