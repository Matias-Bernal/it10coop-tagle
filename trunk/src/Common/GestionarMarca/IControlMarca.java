package common.GestionarMarca;

import java.util.Vector;

import common.DTOs.MarcaDTO;

public interface IControlMarca {
	
	public Long agregarMarca(MarcaDTO marca)throws Exception;
	public void eliminarMarca(Long id)throws Exception;
	public void modificarMarca(Long id,MarcaDTO modificado)throws Exception;
	
	public Vector<MarcaDTO> obtenerAdministrativo()throws Exception;
	public Vector<MarcaDTO> obtenerAdministrativo(Long id)throws Exception;
	public Vector<MarcaDTO> obtenerAdministrativo_Nombre(String nombre_marca)throws Exception;
	
	public boolean existeMarca(Long id) throws Exception;
	public boolean existeMarca(String nombre_marca) throws Exception;
	
	public MarcaDTO buscarMarca(Long id) throws Exception;
	public MarcaDTO buscarMarca(String nombre_marca) throws Exception;

}
