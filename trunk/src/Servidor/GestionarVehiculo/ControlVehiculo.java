package servidor.GestionarVehiculo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.MarcaDTO;
import common.DTOs.ModeloDTO;
import common.DTOs.VehiculoDTO;
import common.GestionarVehiculo.IControlVehiculo;

public class ControlVehiculo extends UnicastRemoteObject implements IControlVehiculo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlVehiculo() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarVehiculoDTO(VehiculoDTO vehiculo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarVehiculoDTO(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarVehiculo(Long id, VehiculoDTO modificado)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<VehiculoDTO> obtenerVehiculos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<VehiculoDTO> obtenerVehiculos(MarcaDTO marca)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<VehiculoDTO> obtenerVehiculos(ModeloDTO modelo)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeVehiculo(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeVehiculo(String dominio) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VehiculoDTO buscarVehiculoDTO(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehiculoDTO buscarVehiculoDTO(String dominio) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}