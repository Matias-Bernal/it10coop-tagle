package servidor.GestionarUsuario;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import common.DTOs.UsuarioDTO;
import common.GestionarUsuario.IControlUsuario;

public class ControlUsuario extends UnicastRemoteObject implements IControlUsuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlUsuario() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarUsuario(UsuarioDTO usr) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarUsuario(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarUsuario(Long id, UsuarioDTO modificado)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<UsuarioDTO> obtenerUsuarios() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(String nombre_usuario, String password)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeUsuario(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeUsuario(String nombre_usuario) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UsuarioDTO buscarUsuarioDTO(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO buscarUsuarioDTO(String nombre_usuario) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	
}