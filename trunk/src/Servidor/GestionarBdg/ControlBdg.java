package servidor.GestionarBdg;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.Vector;

import common.DTOs.BdgDTO;
import common.DTOs.PedidoDTO;
import common.DTOs.PiezaDTO;
import common.GestionarBdg.IControlBdg;

public class ControlBdg extends UnicastRemoteObject implements IControlBdg {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlBdg() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarBdg(BdgDTO bdg) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarBdg(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarBdg(Long id, BdgDTO modificado) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<BdgDTO> obtenerBdg() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<BdgDTO> obtenerBdg(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<BdgDTO> obtenerBdg(Date fecha_bdg) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<BdgDTO> obtenerBdg(PiezaDTO pieza) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<BdgDTO> obtenerBdg(PedidoDTO pedido) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeBdg(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeBdg(PiezaDTO pieza, PedidoDTO pedido) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeBdg(Date fecha_bdg, PiezaDTO pieza, PedidoDTO pedido)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BdgDTO buscarAgente(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BdgDTO buscarAgente(PiezaDTO pieza, PedidoDTO pedido)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BdgDTO buscarAgente(Date fecha_bdg, PiezaDTO pieza, PedidoDTO pedido)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
