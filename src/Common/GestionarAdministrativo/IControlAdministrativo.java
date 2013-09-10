package common.GestionarAdministrativo;

import java.rmi.Remote;
import java.util.Vector;

import common.DTOs.AdministrativoDTO;

public interface IControlAdministrativo extends Remote{
	
	public Long agregarAdministrativo(AdministrativoDTO administrativoDTO)throws Exception;
	public void eliminarAdministrativo(Long id)throws Exception;
	public void modificarAdministrativo(Long id,AdministrativoDTO modificado)throws Exception;
	
	public Vector<AdministrativoDTO> obtenerAdministrativos()throws Exception;
	
	public boolean existeAdministrativo(Long id) throws Exception;
	public boolean existeAdministrativo(String nombre_usuario) throws Exception;
	
	public AdministrativoDTO buscarAdministrativo(Long id) throws Exception;
	public AdministrativoDTO buscarAdministrativo(String nombre_usuario) throws Exception;

}