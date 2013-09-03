package common.GestionarReclamante_Reclamo;

import java.util.Vector;

import common.DTOs.ReclamanteDTO;
import common.DTOs.Reclamante_ReclamoDTO;
import common.DTOs.ReclamoDTO;

public interface IControlReclamante_Reclamo {
	
	public Long agregarReclamante_Reclamo(Reclamante_ReclamoDTO Reclamante_Reclamo)throws Exception;
	public void eliminarReclamante_Reclamo(Long id)throws Exception;
	public void modificarReclamante_Reclamo(Long id,Reclamante_ReclamoDTO modificado)throws Exception;
	
	public Vector<Reclamante_ReclamoDTO> obtenerReclamante_Reclamos()throws Exception;
	public Vector<Reclamante_ReclamoDTO> obtenerReclamante_Reclamos(ReclamanteDTO reclamante)throws Exception;
	
	public boolean existeReclamante_Reclamo(Long id) throws Exception;
	public boolean existeReclamante_Reclamo(ReclamanteDTO reclamante, ReclamoDTO reclamo) throws Exception;
	
	public Reclamante_ReclamoDTO buscarReclamante_Reclamo(Long id) throws Exception;
	public Reclamante_ReclamoDTO buscarReclamante_Reclamo(ReclamanteDTO reclamante, ReclamoDTO reclamo) throws Exception;

}