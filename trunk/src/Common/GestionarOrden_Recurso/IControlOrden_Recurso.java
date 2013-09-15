package common.GestionarOrden_Recurso;

import java.rmi.Remote;
import java.util.Vector;

import common.DTOs.OrdenDTO;
import common.DTOs.Orden_RecursoDTO;
import common.DTOs.RecursoDTO;

public interface IControlOrden_Recurso extends Remote{
	
	public Long agregarOrden_Recurso(Orden_RecursoDTO orden_RecursoDTO)throws Exception;
	public void eliminarOrden_Recurso(Long id)throws Exception;
	public void modificarOrden_Recurso(Long id,Orden_RecursoDTO modificado)throws Exception;
	
	public Vector<Orden_RecursoDTO> obtenerOrdenes_Recursos()throws Exception;
	public Vector<Orden_RecursoDTO> obtenerOrdenes_Recursos(OrdenDTO ordenDTO)throws Exception;
	public Vector<Orden_RecursoDTO> obtenerOrdenes_Recursos(RecursoDTO recursoDTO)throws Exception;

	public boolean existeOrden_Recurso(Long id) throws Exception;
	public boolean existeOrden_Recurso(OrdenDTO ordenDTO,RecursoDTO recursoDTO) throws Exception;
	
	public Orden_RecursoDTO buscarOrden_Recurso(Long id) throws Exception;
	public Orden_RecursoDTO buscarOrden_Recurso(OrdenDTO ordenDTO,RecursoDTO recursoDTO) throws Exception;

}
