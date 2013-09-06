package common.GestionarEncargado_Repuesto;

import java.rmi.Remote;
import java.util.Vector;

import common.DTOs.Encargado_RepuestoDTO;

public interface IControlEncargado_Repuesto extends Remote{
	
	public Long agregarEncargado_Repuesto(Encargado_RepuestoDTO devolucion_pieza)throws Exception;
	public void eliminarEncargado_Repuesto(Long id)throws Exception;
	public void modificarEncargado_Repuesto(Long id,Encargado_RepuestoDTO modificado)throws Exception;
	
	public Vector<Encargado_RepuestoDTO> obtenerEncargado_Repuesto()throws Exception;
	public Vector<Encargado_RepuestoDTO> obtenerEncargado_Repuesto(Long id)throws Exception;
	public Vector<Encargado_RepuestoDTO> obtenerEncargado_Repuesto_Nombre(String nombre_administrativo)throws Exception;
	public Vector<Encargado_RepuestoDTO> obtenerEncargado_Repuesto_Email(String email)throws Exception;
	
	public boolean existeEncargado_Repuesto(Long id) throws Exception;
	public boolean existeEncargado_Repuesto(String nombre_administrativo) throws Exception;
	
	public Encargado_RepuestoDTO buscarEncargado_Repuesto(Long id) throws Exception;
	public Encargado_RepuestoDTO buscarEncargado_Repuesto(String nombre_administrativo) throws Exception;

}