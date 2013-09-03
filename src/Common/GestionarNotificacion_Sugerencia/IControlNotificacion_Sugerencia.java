package common.GestionarNotificacion_Sugerencia;

import java.util.Vector;

import common.DTOs.Notificacion_SugerenciaDTO;

public interface IControlNotificacion_Sugerencia {
	
	public Long agregarNotificacion_Sugerencia(Notificacion_SugerenciaDTO Notificacion_Sugerencia)throws Exception;
	public void eliminarNotificacion_Sugerencia(Long id)throws Exception;
	public void modificarNotificacion_Sugerencia(Long id,Notificacion_SugerenciaDTO modificado)throws Exception;
	
	public Vector<Notificacion_SugerenciaDTO> obtenerNotificacion_Sugerencia()throws Exception;
	public Vector<Notificacion_SugerenciaDTO> obtenerNotificacion_Sugerencia(Long id)throws Exception;
	public Vector<Notificacion_SugerenciaDTO> obtenerNotificacion_Sugerencia(Boolean concretada_notificacion)throws Exception;

	public boolean existeNotificacion_Sugerencia(Long id) throws Exception;
	public boolean existeNotificacion_Sugerencia(Notificacion_SugerenciaDTO Notificacion_Sugerencia) throws Exception;
	
	public Notificacion_SugerenciaDTO buscarAdministrativo(Long id) throws Exception;
	public Notificacion_SugerenciaDTO buscarAdministrativo(Notificacion_SugerenciaDTO Notificacion_Sugerencia) throws Exception;


}
