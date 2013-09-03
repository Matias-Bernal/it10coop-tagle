package common.GestionarAgente;

import java.util.Vector;

import common.DTOs.AgenteDTO;

public interface IControlAgente {

	public Long agregarAgente(AgenteDTO agente)throws Exception;
	public void eliminarAgente(Long id)throws Exception;
	public void modificarAgente(Long id,AgenteDTO modificado)throws Exception;
	
	public Vector<AgenteDTO> obtenerAgente()throws Exception;
	public Vector<AgenteDTO> obtenerAgente(Long id)throws Exception;
	public Vector<AgenteDTO> obtenerAgente(String nombre_agente)throws Exception;
	
	public boolean existeAgente(Long id) throws Exception;
	public boolean existeAgente(String nombre_agente) throws Exception;
	
	public AgenteDTO buscarAgente(Long id) throws Exception;
	public AgenteDTO buscarAgente(String nombre_agente) throws Exception;

}