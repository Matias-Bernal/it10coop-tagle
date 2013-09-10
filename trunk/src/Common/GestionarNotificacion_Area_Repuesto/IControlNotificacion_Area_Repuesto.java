package common.GestionarNotificacion_Area_Repuesto;

import java.rmi.Remote;
import java.util.Vector;

import common.DTOs.Notificacion_Area_RepuestoDTO;

public interface IControlNotificacion_Area_Repuesto extends Remote{
	
	public Long agregarNotificacion_Area_Repuesto(Notificacion_Area_RepuestoDTO notificacion_area_repuestoDTO)throws Exception;
	public void eliminarNotificacion_Area_Repuesto(Long id)throws Exception;
	public void modificarNotificacion_Area_Repuesto(Long id,Notificacion_Area_RepuestoDTO modificado)throws Exception;
	
	public Vector<Notificacion_Area_RepuestoDTO> obtenerNotificacion_Area_Repuesto()throws Exception;
	public Vector<Notificacion_Area_RepuestoDTO> obtenerNotificacion_Area_Repuesto(Boolean concretada_notificacion)throws Exception;

	public boolean existeNotificacion_Area_Repuesto(Long id) throws Exception;
	public boolean existeNotificacion_Area_Repuesto(Notificacion_Area_RepuestoDTO notificacion_area_repuestoDTO) throws Exception;
	
	public Notificacion_Area_RepuestoDTO buscarNotificacion_Area_Repuesto(Long id) throws Exception;
	public Notificacion_Area_RepuestoDTO buscarNotificacion_Area_Repuesto(Notificacion_Area_RepuestoDTO notificacion_area_repuestoDTO) throws Exception;

}