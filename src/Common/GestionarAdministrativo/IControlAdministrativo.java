package common.GestionarAdministrativo;

import java.util.Vector;

import common.DTOs.AdministrativoDTO;

public interface IControlAdministrativo {
	
	public Long agregarAdministrativo(AdministrativoDTO administrativo)throws Exception;
	public void eliminarAdministrativo(Long id)throws Exception;
	public void modificarAdministrativo(Long id,AdministrativoDTO modificado)throws Exception;
	
	public Vector<AdministrativoDTO> obtenerAdministrativo()throws Exception;
	public Vector<AdministrativoDTO> obtenerAdministrativo(Long id)throws Exception;
	public Vector<AdministrativoDTO> obtenerAdministrativo_Nombre(String nombre_administrativo)throws Exception;
	public Vector<AdministrativoDTO> obtenerAdministrativo_Email(String email)throws Exception;
	
	public boolean existeAdministrativo(Long id) throws Exception;
	public boolean existeAdministrativo(String nombre_administrativo) throws Exception;
	
	public AdministrativoDTO buscarAdministrativo(Long id) throws Exception;
	public AdministrativoDTO buscarAdministrativo(String nombre_administrativo) throws Exception;

}