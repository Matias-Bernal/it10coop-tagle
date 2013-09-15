package servidor.GestionarRegistrante;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.RegistranteDTO;
import common.GestionarRegistrante.IControlRegistrante;

public class ControlRegistrante extends UnicastRemoteObject implements IControlRegistrante {

	private static final long serialVersionUID = 1L;

	protected ControlRegistrante() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarRegistranteDTO(RegistranteDTO regitrante)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarRegistranteDTO(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarRegistrante(Long id, RegistranteDTO modificado)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector<RegistranteDTO> obtenerRegistrantes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeRegistrante(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeRegistrante(String nombre_registrante)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RegistranteDTO buscarRegistranteDTO(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegistranteDTO buscarRegistranteDTO(String nombre_registrante)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}