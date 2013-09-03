package common.GestionarEntidad;

import java.util.Vector;

import common.DTOs.EntidadDTO;

public interface IControlEntidad {

	public Long agregarEntidad(EntidadDTO entidad)throws Exception;
	public void eliminarEntidad(Long id)throws Exception;
	public void modificarEntidad(Long id,EntidadDTO modificado)throws Exception;
	
	public Vector<EntidadDTO> obtenerEntidad()throws Exception;
	public Vector<EntidadDTO> obtenerEntidad(Long id)throws Exception;
	public Vector<EntidadDTO> obtenerAdministrativo_Nombre(String nombre_entidad)throws Exception;
	
	public boolean existeEntidad(Long id) throws Exception;
	public boolean existeEntidad(String nombre_entidad) throws Exception;
	
	public EntidadDTO buscarEntidad(Long id) throws Exception;
	public EntidadDTO buscarEntidad(String nombre_entidad) throws Exception;

}
