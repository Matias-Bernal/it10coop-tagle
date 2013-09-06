package common.GestionarNotificacion;

import java.rmi.Remote;
import java.util.Vector;

import common.DTOs.NotificacionDTO;

public interface IControlNotificacion extends Remote{
	
	public Long agregarNotificacion(NotificacionDTO Notificacion)throws Exception;
	public void eliminarNotificacion(Long id)throws Exception;
	public void modificarNotificacion(Long id,NotificacionDTO modificado)throws Exception;
	
	public Vector<NotificacionDTO> obtenerNotificacion()throws Exception;
	public Vector<NotificacionDTO> obtenerNotificacion(Long id)throws Exception;
	public Vector<NotificacionDTO> obtenerNotificacion(Boolean concretada_notificacion)throws Exception;
	
	public boolean existeNotificacion(Long id) throws Exception;
	public boolean existeNotificacion(NotificacionDTO Notificacion) throws Exception;
	
	public NotificacionDTO buscarAdministrativo(Long id) throws Exception;
	public NotificacionDTO buscarAdministrativo(NotificacionDTO Notificacion) throws Exception;


}
