package common.GestionarMano_Obra;

import java.util.Vector;

import common.DTOs.Mano_ObraDTO;
import common.DTOs.ReclamoDTO;

public interface IControlMano_Obra {
	
	public Long agregarMano_Obra(Mano_ObraDTO mano_obra)throws Exception;
	public void eliminarMano_Obra(Long id)throws Exception;
	public void modificarMano_Obra(Long id,Mano_ObraDTO modificado)throws Exception;
	
	public Vector<Mano_ObraDTO> obtenerMano_Obra()throws Exception;
	public Vector<Mano_ObraDTO> obtenerMano_Obra(Long id)throws Exception;
	public Vector<Mano_ObraDTO> obtenerMano_Obra_Nombre(String codigo_mano_obra)throws Exception;
	public Vector<Mano_ObraDTO> obtenerMano_Obra_Email(ReclamoDTO reclamo)throws Exception;
	
	public boolean existeAdministrativo(Long id) throws Exception;
	public boolean existeAdministrativo(String nombre_administrativo) throws Exception;
	
	public Mano_ObraDTO buscarAdministrativo(Long id) throws Exception;
	public Mano_ObraDTO buscarAdministrativo(String codigo_mano_obra) throws Exception;
	public Mano_ObraDTO buscarAdministrativo(ReclamoDTO reclamo,String codigo_mano_obra) throws Exception;

}
