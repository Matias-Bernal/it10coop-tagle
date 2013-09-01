package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Estado_Pedido;
import common.DTOs.Estado_PedidoDTO;

public class Estado_PedidoAssembler {
	
	public Estado_PedidoAssembler(){}

	public static Estado_PedidoDTO getEstado_PedidoDTO(Estado_Pedido estado_pedido) {
		Estado_PedidoDTO estado_pedidoDTO = new Estado_PedidoDTO();
		estado_pedidoDTO.setId(estado_pedido.getId());
		estado_pedidoDTO.setEstado_pedido(estado_pedido.getEstado_pedido());
		return estado_pedidoDTO;
	}

	public static Estado_Pedido getEstado_Pedido(Estado_PedidoDTO estado_pedidoDTO) {
		Estado_Pedido estado_pedido = new Estado_Pedido();
		estado_pedido.setId(estado_pedidoDTO.getId());
		estado_pedido.setEstado_pedido(estado_pedidoDTO.getEstado_pedido());
		return estado_pedido;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==Estado_PedidoDTO.class) {
				aux.add(getEstado_Pedido((Estado_PedidoDTO) obj));
			}
		}
		return aux;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector getVector (Set s) {
		Vector auxDTO = new Vector();
		auxDTO.clear();
		Iterator it = s.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==Estado_Pedido.class) {
				auxDTO.add(getEstado_PedidoDTO((Estado_Pedido) obj));
			}
		}
		return auxDTO;
	}

}