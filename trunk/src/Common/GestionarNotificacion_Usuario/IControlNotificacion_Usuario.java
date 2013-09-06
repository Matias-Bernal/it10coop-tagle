package common.GestionarNotificacion_Usuario;

import java.rmi.Remote;
import java.util.Vector;

import common.DTOs.Notificacion_UsuarioDTO;

public interface IControlNotificacion_Usuario extends Remote{

	public Long agregarNotificacion_Usuario(Notificacion_UsuarioDTO notificacion_usuario)throws Exception;
	public void eliminarNotificacion_Usuario(Long id)throws Exception;
	public void modificarNotificacion_Usuario(Long id,Notificacion_UsuarioDTO modificado)throws Exception;
	
	public Vector<Notificacion_UsuarioDTO> obtenerNotificacion_Usuario()throws Exception;
	public Vector<Notificacion_UsuarioDTO> obtenerNotificacion_Usuario(Long id)throws Exception;
	public Vector<Notificacion_UsuarioDTO> obtenerNotificacion_Usuario(Boolean concretada_notificacion)throws Exception;

	public boolean existeNotificacion_Usuario(Long id) throws Exception;
	public boolean existeNotificacion_Usuario(Notificacion_UsuarioDTO Notificacion_Usuario) throws Exception;
	
	public Notificacion_UsuarioDTO buscarAdministrativo(Long id) throws Exception;
	public Notificacion_UsuarioDTO buscarAdministrativo(Notificacion_UsuarioDTO notificacion_asignacion_tTurnos) throws Exception;

}
