package common.GestionarPedido_Pieza;

import java.sql.Date;
import java.util.Vector;

import common.DTOs.Estado_PedidoDTO;
import common.DTOs.PedidoDTO;
import common.DTOs.Pedido_PiezaDTO;
import common.DTOs.PiezaDTO;

public interface IControlPedido_Pieza {

	public Long agregarPedido_Pieza(Pedido_PiezaDTO Pedido_Pieza)throws Exception;
	public void eliminarPedido_Pieza(Long id)throws Exception;
	public void modificarPedido_Pieza(Long id,Pedido_PiezaDTO modificado)throws Exception;
	
	public Vector<Pedido_PiezaDTO> obtenerPedido_Pieza()throws Exception;
	public Vector<Pedido_PiezaDTO> obtenerPedido_Pieza(Long id)throws Exception;
	public Vector<Pedido_PiezaDTO> obtenerPedido_Pieza(Date fecha_estado)throws Exception;
	public Vector<Pedido_PiezaDTO> obtenerPedido_Pieza(Estado_PedidoDTO estado_pedido)throws Exception;
	
	public boolean existePedido_Pieza(Long id) throws Exception;
	public boolean existePedido_Pieza(PedidoDTO pedido, PiezaDTO pieza) throws Exception;
	
	public Pedido_PiezaDTO buscarPedido_Pieza(Long id) throws Exception;
	public Pedido_PiezaDTO buscarPedido_Pieza(PedidoDTO pedido, PiezaDTO pieza) throws Exception;

}
