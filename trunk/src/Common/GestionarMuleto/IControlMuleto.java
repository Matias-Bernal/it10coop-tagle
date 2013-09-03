package common.GestionarMuleto;

import java.util.Vector;

import common.DTOs.MuletoDTO;
import common.DTOs.PedidoDTO;
import common.DTOs.PiezaDTO;

public interface IControlMuleto {

	public Long agregarMuleto(MuletoDTO muleto)throws Exception;
	public void eliminarMuleto(Long id)throws Exception;
	public void modificarMuleto(Long id,MuletoDTO modificado)throws Exception;
	
	public Vector<MuletoDTO> obtenerMuleto()throws Exception;
	public Vector<MuletoDTO> obtenerMuleto(Long id)throws Exception;
	public Vector<MuletoDTO> obtenerMuleto(PedidoDTO reginstrante)throws Exception;
	
	public boolean existeMuleto(Long id) throws Exception;
	public boolean existeMuleto(PedidoDTO pedido, PiezaDTO pieza) throws Exception;
	
	public MuletoDTO buscarMuleto(Long id) throws Exception;
	public MuletoDTO buscarMuleto(PedidoDTO pedido, PiezaDTO pieza) throws Exception;

}
