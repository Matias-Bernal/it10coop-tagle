package common.GestionarNotificacion_Asignacion_Turnos;

import java.rmi.Remote;
import java.util.Vector;

import common.DTOs.Notificacion_Asignacion_TurnosDTO;

public interface IControlNotificacion_Asignacion_Turnos extends Remote{
	
	public Long agregarNotificacion_Asignacion_Turnos(Notificacion_Asignacion_TurnosDTO notificacion_asignacion_turnos)throws Exception;
	public void eliminarNotificacion_Asignacion_Turnos(Long id)throws Exception;
	public void modificarNotificacion_Asignacion_Turnos(Long id,Notificacion_Asignacion_TurnosDTO modificado)throws Exception;
	
	public Vector<Notificacion_Asignacion_TurnosDTO> obtenerNotificacion_Asignacion_Turnos()throws Exception;
	public Vector<Notificacion_Asignacion_TurnosDTO> obtenerNotificacion_Asignacion_Turnos(Long id)throws Exception;
	public Vector<Notificacion_Asignacion_TurnosDTO> obtenerNotificacion_Asignacion_Turnos(Boolean concretada_notificacion)throws Exception;

	public boolean existeNotificacion_Asignacion_Turnos(Long id) throws Exception;
	public boolean existeNotificacion_Asignacion_Turnos(Notificacion_Asignacion_TurnosDTO notificacion_asignacion_turnos) throws Exception;
	
	public Notificacion_Asignacion_TurnosDTO buscarAdministrativo(Long id) throws Exception;
	public Notificacion_Asignacion_TurnosDTO buscarAdministrativo(Notificacion_Asignacion_TurnosDTO notificacion_asignacion_turnos) throws Exception;

}
