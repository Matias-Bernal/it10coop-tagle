package servidor.GestionarModelo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.MarcaDTO;
import common.DTOs.ModeloDTO;
import common.GestionarModelo.IControlModelo;

public class ControlModelo extends UnicastRemoteObject implements IControlModelo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlModelo() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarModelo(ModeloDTO modelo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarModelo(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarModelo(Long id, ModeloDTO modificado) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<ModeloDTO> obtenerModelo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<ModeloDTO> obtenerModelo(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<ModeloDTO> obtenerModelo(String nombre_modelo)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<ModeloDTO> obtenerModelo(MarcaDTO marca) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeModelo(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeModelo(String nombre_modelo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeModelo(MarcaDTO marca, String nombre_modelo)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ModeloDTO buscarModelo(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModeloDTO buscarModelo(String nombre_modelo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModeloDTO buscarModelo(MarcaDTO marca, String nombre_modelo)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
