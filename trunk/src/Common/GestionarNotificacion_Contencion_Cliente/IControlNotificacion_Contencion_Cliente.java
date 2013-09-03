package common.GestionarNotificacion_Contencion_Cliente;

import java.util.Vector;

import common.DTOs.Notificacion_Contencion_ClienteDTO;

public interface IControlNotificacion_Contencion_Cliente {
	
	public Long agregarNotificacion_Contencion_Cliente(Notificacion_Contencion_ClienteDTO Notificacion_Contencion_Cliente)throws Exception;
	public void eliminarNotificacion_Contencion_Cliente(Long id)throws Exception;
	public void modificarNotificacion_Contencion_Cliente(Long id,Notificacion_Contencion_ClienteDTO modificado)throws Exception;
	
	public Vector<Notificacion_Contencion_ClienteDTO> obtenerNotificacion_Contencion_Cliente()throws Exception;
	public Vector<Notificacion_Contencion_ClienteDTO> obtenerNotificacion_Contencion_Cliente(Long id)throws Exception;
	public Vector<Notificacion_Contencion_ClienteDTO> obtenerNotificacion_Contencion_Cliente(Boolean concretada_notificacion)throws Exception;

	public boolean existeNotificacion_Contencion_Cliente(Long id) throws Exception;
	public boolean existeNotificacion_Contencion_Cliente(Notificacion_Contencion_ClienteDTO Notificacion_Contencion_Cliente) throws Exception;
	
	public Notificacion_Contencion_ClienteDTO buscarAdministrativo(Long id) throws Exception;
	public Notificacion_Contencion_ClienteDTO buscarAdministrativo(Notificacion_Contencion_ClienteDTO Notificacion_Contencion_Cliente) throws Exception;


}
