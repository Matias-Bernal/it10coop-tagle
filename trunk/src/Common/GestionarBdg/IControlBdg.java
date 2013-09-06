package common.GestionarBdg;

import java.rmi.Remote;
import java.sql.Date;
import java.util.Vector;

import common.DTOs.BdgDTO;
import common.DTOs.PedidoDTO;
import common.DTOs.PiezaDTO;

public interface IControlBdg extends Remote{
	
	public Long agregarBdg(BdgDTO bdg)throws Exception;
	public void eliminarBdg(Long id)throws Exception;
	public void modificarBdg(Long id,BdgDTO modificado)throws Exception;
	
	public Vector<BdgDTO> obtenerBdg()throws Exception;
	public Vector<BdgDTO> obtenerBdg(Long id)throws Exception;
	public Vector<BdgDTO> obtenerBdg(Date fecha_bdg)throws Exception;
	public Vector<BdgDTO> obtenerBdg(PiezaDTO pieza)throws Exception;
	public Vector<BdgDTO> obtenerBdg(PedidoDTO pedido)throws Exception;
	
	public boolean existeBdg(Long id) throws Exception;
	public boolean existeBdg(PiezaDTO pieza, PedidoDTO pedido) throws Exception;
	public boolean existeBdg(Date fecha_bdg, PiezaDTO pieza, PedidoDTO pedido) throws Exception;

	public BdgDTO buscarAgente(Long id) throws Exception;
	public BdgDTO buscarAgente(PiezaDTO pieza, PedidoDTO pedido) throws Exception;
	public BdgDTO buscarAgente(Date fecha_bdg, PiezaDTO pieza, PedidoDTO pedido) throws Exception;

}
