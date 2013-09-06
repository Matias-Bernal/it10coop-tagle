package common.GestionarModelo;

import java.rmi.Remote;
import java.util.Vector;

import common.DTOs.MarcaDTO;
import common.DTOs.ModeloDTO;

public interface IControlModelo extends Remote{

	public Long agregarModelo(ModeloDTO modelo)throws Exception;
	public void eliminarModelo(Long id)throws Exception;
	public void modificarModelo(Long id,ModeloDTO modificado)throws Exception;
	
	public Vector<ModeloDTO> obtenerModelo()throws Exception;
	public Vector<ModeloDTO> obtenerModelo(Long id)throws Exception;
	public Vector<ModeloDTO> obtenerModelo(String nombre_modelo)throws Exception;
	public Vector<ModeloDTO> obtenerModelo(MarcaDTO marca)throws Exception;
	
	public boolean existeModelo(Long id) throws Exception;
	public boolean existeModelo(String nombre_modelo) throws Exception;
	public boolean existeModelo(MarcaDTO marca,String nombre_modelo) throws Exception;
	
	public ModeloDTO buscarModelo(Long id) throws Exception;
	public ModeloDTO buscarModelo(String nombre_modelo) throws Exception;
	public ModeloDTO buscarModelo(MarcaDTO marca,String nombre_modelo) throws Exception;
}
