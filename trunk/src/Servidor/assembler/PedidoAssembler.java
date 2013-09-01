package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Pedido;
import common.DTOs.PedidoDTO;

public class PedidoAssembler {

	public PedidoAssembler(){}

	public static PedidoDTO getPedidoDTO(Pedido pedido) {
		PedidoDTO pedidoDTO = new PedidoDTO();
		pedidoDTO.setId(pedido.getId());
		pedidoDTO.setNumero_pedido(pedido.getNumero_pedido());
		pedidoDTO.setFecha_recepcion_fabrica(pedido.getFecha_recepcion_fabrica());
		pedidoDTO.setFecha_solicitud_fabrica(pedido.getFecha_solicitud_fabrica());
		pedidoDTO.setFecha_solicitud_pedido(pedido.getFecha_solicitud_pedido());
		pedidoDTO.setNumero_orden_trabajo(pedido.getNumero_orden_trabajo());
		pedidoDTO.setPnc(pedido.getPnc());
		Estado_PedidoAssembler estadoAssemb = new Estado_PedidoAssembler();
		pedidoDTO.setEstado_pedido(estadoAssemb.getEstado_PedidoDTO(pedido.getEstado_pedido()));
		ReclamoAssembler reclamoAssemb = new ReclamoAssembler();
		pedidoDTO.setReclamo(reclamoAssemb.getReclamoDTO(pedido.getReclamo()));
		return pedidoDTO;
	}
	public static Pedido getPedido(PedidoDTO pedidoDTO) {
		Pedido pedido = new Pedido();
		pedido.setId(pedidoDTO.getId());
		pedido.setNumero_pedido(pedidoDTO.getNumero_pedido());
		pedido.setFecha_recepcion_fabrica(pedidoDTO.getFecha_recepcion_fabrica());
		pedido.setFecha_solicitud_fabrica(pedidoDTO.getFecha_solicitud_fabrica());
		pedido.setFecha_solicitud_pedido(pedidoDTO.getFecha_solicitud_pedido());
		pedido.setNumero_orden_trabajo(pedidoDTO.getNumero_orden_trabajo());
		pedido.setPnc(pedidoDTO.getPnc());
		Estado_PedidoAssembler estadoAssemb = new Estado_PedidoAssembler();
		pedido.setEstado_pedido(estadoAssemb.getEstado_Pedido(pedidoDTO.getEstado_pedido()));
		ReclamoAssembler reclamoAssemb = new ReclamoAssembler();
		pedido.setReclamo(reclamoAssemb.getReclamo(pedidoDTO.getReclamo()));
		return pedido;
	}
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==PedidoDTO.class) {
				aux.add(getPedido((PedidoDTO) obj));
			}
		}
		return aux;
	}
	public static Vector getVector (Set s) {
		Vector auxDTO = new Vector();
		auxDTO.clear();
		Iterator it = s.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==Pedido.class) {
				auxDTO.add(getPedidoDTO((Pedido) obj));
			}
		}
		return auxDTO;
	}

}