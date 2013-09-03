package common.GestionarReclamante;

import java.util.Vector;

import common.DTOs.ReclamanteDTO;

public interface IControlReclamante {

	public Long agregarReclamante(ReclamanteDTO Reclamante)throws Exception;
	public void eliminarReclamante(Long id)throws Exception;
	public void modificarReclamante(Long id,ReclamanteDTO modificado)throws Exception;
	
	public Vector<ReclamanteDTO> obtenerReclamantes()throws Exception;
	
	public boolean existeReclamante(Long id) throws Exception;
	public boolean existeReclamante(String nombre_apellido) throws Exception;
	
	public ReclamanteDTO buscarReclamante(Long id) throws Exception;
	public ReclamanteDTO buscarReclamante(String nombre_apellido) throws Exception;
}