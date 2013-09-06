package common.GestionarMTelefono;

import java.rmi.Remote;
import java.util.Vector;

import common.DTOs.MTelefonoDTO;
import common.DTOs.ReclamanteDTO;

public interface IControlMTelefono extends Remote{
	
	public Long agregarMTelefono(MTelefonoDTO mTelefono)throws Exception;
	public void eliminarMTelefono(Long id)throws Exception;
	public void modificarMTelefono(Long id,MTelefonoDTO modificado)throws Exception;
	
	public Vector<MTelefonoDTO> obtenerMTelefono()throws Exception;
	public Vector<MTelefonoDTO> obtenerMTelefono(Long id)throws Exception;
	public Vector<MTelefonoDTO> obtenerAdministrativo_Nombre(ReclamanteDTO reclamante)throws Exception;
	
	public boolean existeAdministrativo(Long id) throws Exception;
	public boolean existeAdministrativo(ReclamanteDTO reclamante, String telefono) throws Exception;
	
	public MTelefonoDTO buscarAdministrativo(Long id) throws Exception;
	public MTelefonoDTO buscarAdministrativo(ReclamanteDTO reclamante) throws Exception;
	public MTelefonoDTO buscarAdministrativo(ReclamanteDTO reclamante, String telefono) throws Exception;

}