package common.GestionarNotificacion_Reclamo_Fabrica;

import java.rmi.Remote;
import java.util.Vector;

import common.DTOs.Notificacion_Reclamo_FabricaDTO;

public interface IControlNotificacion_Reclamo_Fabrica extends Remote{
	
	public Long agregarNotificacion_Reclamo_Fabrica(Notificacion_Reclamo_FabricaDTO Notificacion_Reclamo_Fabrica)throws Exception;
	public void eliminarNotificacion_Reclamo_Fabrica(Long id)throws Exception;
	public void modificarNotificacion_Reclamo_Fabrica(Long id,Notificacion_Reclamo_FabricaDTO modificado)throws Exception;
	
	public Vector<Notificacion_Reclamo_FabricaDTO> obtenerNotificacion_Reclamo_Fabrica()throws Exception;
	public Vector<Notificacion_Reclamo_FabricaDTO> obtenerNotificacion_Reclamo_Fabrica(Long id)throws Exception;
	public Vector<Notificacion_Reclamo_FabricaDTO> obtenerNotificacion_Reclamo_Fabrica(Boolean concretada_notificacion)throws Exception;

	public boolean existeNotificacion_Reclamo_Fabrica(Long id) throws Exception;
	public boolean existeNotificacion_Reclamo_Fabrica(Notificacion_Reclamo_FabricaDTO Notificacion_Reclamo_Fabrica) throws Exception;
	
	public Notificacion_Reclamo_FabricaDTO buscarAdministrativo(Long id) throws Exception;
	public Notificacion_Reclamo_FabricaDTO buscarAdministrativo(Notificacion_Reclamo_FabricaDTO Notificacion_Reclamo_Fabrica) throws Exception;

}