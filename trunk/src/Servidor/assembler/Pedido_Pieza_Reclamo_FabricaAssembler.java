package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Pedido_Pieza_Reclamo_Fabrica;
import common.DTOs.Pedido_Pieza_Reclamo_FabricaDTO;

public class Pedido_Pieza_Reclamo_FabricaAssembler {

	public Pedido_Pieza_Reclamo_FabricaAssembler(){}
	
	public static Pedido_Pieza_Reclamo_FabricaDTO getPedido_Pieza_Reclamo_FabricaDTO (Pedido_Pieza_Reclamo_Fabrica pedido_Pieza_Reclamo_Fabrica ){
		Pedido_Pieza_Reclamo_FabricaDTO pedido_Pieza_Reclamo_FabricaDTO = new Pedido_Pieza_Reclamo_FabricaDTO();
		pedido_Pieza_Reclamo_FabricaDTO.setId(pedido_Pieza_Reclamo_Fabrica.getId());
		PedidoAssembler pedidoAssemb = new PedidoAssembler();
		pedido_Pieza_Reclamo_FabricaDTO.setPedido(pedidoAssemb.getPedidoDTO(pedido_Pieza_Reclamo_Fabrica.getPedido()));
		PiezaAssembler piezaAssemb = new PiezaAssembler();
		pedido_Pieza_Reclamo_FabricaDTO.setPieza(piezaAssemb.getPiezaDTO(pedido_Pieza_Reclamo_Fabrica.getPieza()));
		Reclamo_FabricaAssembler reclamo_FabricaAssemb = new Reclamo_FabricaAssembler();
		pedido_Pieza_Reclamo_FabricaDTO.setReclamo_fabrica(reclamo_FabricaAssemb.getReclamo_FabricaDTO(pedido_Pieza_Reclamo_Fabrica.getReclamo_fabrica()));
		return pedido_Pieza_Reclamo_FabricaDTO;
	}
	public static Pedido_Pieza_Reclamo_Fabrica getPedido_Pieza_Reclamo_Fabrica (Pedido_Pieza_Reclamo_FabricaDTO pedido_Pieza_Reclamo_FabricaDTO ){
		Pedido_Pieza_Reclamo_Fabrica pedido_Pieza_Reclamo_Fabrica = new Pedido_Pieza_Reclamo_Fabrica();
		pedido_Pieza_Reclamo_Fabrica.setId(pedido_Pieza_Reclamo_FabricaDTO.getId());
		PedidoAssembler pedidoAssemb = new PedidoAssembler();
		pedido_Pieza_Reclamo_Fabrica.setPedido(pedidoAssemb.getPedido(pedido_Pieza_Reclamo_FabricaDTO.getPedido()));
		PiezaAssembler piezaAssemb = new PiezaAssembler();
		pedido_Pieza_Reclamo_Fabrica.setPieza(piezaAssemb.getPieza(pedido_Pieza_Reclamo_FabricaDTO.getPieza()));
		Reclamo_FabricaAssembler reclamo_FabricaAssemb = new Reclamo_FabricaAssembler();
		pedido_Pieza_Reclamo_Fabrica.setReclamo_fabrica(reclamo_FabricaAssemb.getReclamo_Fabrica(pedido_Pieza_Reclamo_FabricaDTO.getReclamo_fabrica()));
		return pedido_Pieza_Reclamo_Fabrica;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==Pedido_Pieza_Reclamo_FabricaDTO.class) {
				aux.add(getPedido_Pieza_Reclamo_Fabrica((Pedido_Pieza_Reclamo_FabricaDTO) obj));
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
			if (obj.getClass()==Pedido_Pieza_Reclamo_Fabrica.class) {
				auxDTO.add(getPedido_Pieza_Reclamo_FabricaDTO((Pedido_Pieza_Reclamo_Fabrica) obj));
			}
		}
		return auxDTO;
	}

}