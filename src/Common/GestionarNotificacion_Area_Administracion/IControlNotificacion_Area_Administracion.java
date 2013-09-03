package common.GestionarNotificacion_Area_Administracion;

import java.util.Vector;

import common.DTOs.Notificacion_Area_AdministracionDTO;

public interface IControlNotificacion_Area_Administracion {
	
	public Long agregarNotificacion_Area_Administracion(Notificacion_Area_AdministracionDTO notificacion_area_administracion)throws Exception;
	public void eliminarNotificacion_Area_Administracion(Long id)throws Exception;
	public void modificarNotificacion_Area_Administracion(Long id,Notificacion_Area_AdministracionDTO modificado)throws Exception;
	
	public Vector<Notificacion_Area_AdministracionDTO> obtenerNotificacion_Area_Administracion()throws Exception;
	public Vector<Notificacion_Area_AdministracionDTO> obtenerNotificacion_Area_Administracion(Long id)throws Exception;
	public Vector<Notificacion_Area_AdministracionDTO> obtenerNotificacion_Area_Administracion(Boolean concretada_notificacion)throws Exception;

	public boolean existeNotificacion_Area_Administracion(Long id) throws Exception;
	public boolean existeNotificacion_Area_Administracion(Notificacion_Area_AdministracionDTO notificacion_area_administracion) throws Exception;
	
	public Notificacion_Area_AdministracionDTO buscarAdministrativo(Long id) throws Exception;
	public Notificacion_Area_AdministracionDTO buscarAdministrativo(Notificacion_Area_AdministracionDTO notificacion_area_administracion) throws Exception;

}
