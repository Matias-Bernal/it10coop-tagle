package common.GestionarUsuario;

import java.rmi.Remote;
import java.util.Vector;

import common.DTOs.UsuarioDTO;

public interface IControlUsuario extends Remote{

	public Long agregarUsuario(UsuarioDTO usr)throws Exception;
	public void eliminarUsuario(Long id)throws Exception;
	public void modificarUsuario(Long id,UsuarioDTO modificado)throws Exception;
	
	public Vector<UsuarioDTO> obtenerUsuarios()throws Exception;
	public boolean login(String nombre_usuario, String password)throws Exception;
	
	public boolean existeUsuario(Long id) throws Exception;
	public boolean existeUsuario(String nombre_usuario) throws Exception;
	
	public UsuarioDTO buscarUsuarioDTO(Long id) throws Exception;
	public UsuarioDTO buscarUsuarioDTO(String nombre_usuario) throws Exception;
	
}