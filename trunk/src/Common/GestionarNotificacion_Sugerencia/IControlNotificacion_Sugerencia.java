package common.GestionarNotificacion_Sugerencia;

import java.rmi.Remote;
import java.util.Vector;

import common.DTOs.Notificacion_SugerenciaDTO;

public interface IControlNotificacion_Sugerencia extends Remote{
	
	public Long agregarNotificacion_Sugerencia(Notificacion_SugerenciaDTO notificacion_SugerenciaDTO)throws Exception;
	public void eliminarNotificacion_Sugerencia(Long id)throws Exception;
	public void modificarNotificacion_Sugerencia(Long id,Notificacion_SugerenciaDTO modificado)throws Exception;
	
	public Vector<Notificacion_SugerenciaDTO> obtenerNotificacion_Sugerencia()throws Exception;
	public Vector<Notificacion_SugerenciaDTO> obtenerNotificacion_Sugerencia(Boolean concretada_notificacion)throws Exception;

	public boolean existeNotificacion_Sugerencia(Long id) throws Exception;
	public boolean existeNotificacion_Sugerencia(Notificacion_SugerenciaDTO notificacion_SugerenciaDTO) throws Exception;
	
	public Notificacion_SugerenciaDTO buscarNotificacion_Sugerencia(Long id) throws Exception;
	public Notificacion_SugerenciaDTO buscarNotificacion_Sugerencia(Notificacion_SugerenciaDTO notificacion_SugerenciaDTO) throws Exception;


}
