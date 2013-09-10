package common.GestionarPedido;

import java.rmi.Remote;
import java.sql.Date;
import java.util.Vector;

import common.DTOs.PedidoDTO;
import common.DTOs.ReclamoDTO;

public interface IControlPedido extends Remote{

	public Long agregarPedido(PedidoDTO pedido)throws Exception;
	public void eliminarPedido(Long id)throws Exception;
	public void modificarPedido(Long id,PedidoDTO modificado)throws Exception;
	
	public Vector<PedidoDTO> obtenerPedidos()throws Exception;
	public Vector<PedidoDTO> obtenerPedidos_Fecha_Solicitud_Pedido(Date fecha_solicitud_pedido)throws Exception;
	public Vector<PedidoDTO> obtenerPedidos_Fecha_Solicitud_Fabrica(Date fecha_recepcion_fabrica)throws Exception;
	public Vector<PedidoDTO> obtenerPedidos_Fecha_Recepcion_Fabrica(Date fecha_recepcion_fabrica)throws Exception;
	public Vector<PedidoDTO> obtenerPedidos(ReclamoDTO reclamo)throws Exception;
	
	public boolean existePedido(Long id) throws Exception;
	public boolean existePedido(String numero_pedido) throws Exception;
	
	public PedidoDTO buscarPedido(Long id) throws Exception;
	public PedidoDTO buscarPedido(String numero_pedido) throws Exception;
	
}