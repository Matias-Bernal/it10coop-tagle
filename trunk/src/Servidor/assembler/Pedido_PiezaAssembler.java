package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Pedido_Pieza;
import common.DTOs.Pedido_PiezaDTO;

public class Pedido_PiezaAssembler {

	public Pedido_PiezaAssembler(){}
	
	public static Pedido_PiezaDTO getPedido_PiezaDTO (Pedido_Pieza pedido_Pieza ){
		Pedido_PiezaDTO pedido_PiezaDTO = new Pedido_PiezaDTO();
		pedido_PiezaDTO.setId(pedido_Pieza.getId());
		pedido_PiezaDTO.setFecha_estado(pedido_Pieza.getFecha_estado());
		pedido_PiezaDTO.setPropio(pedido_Pieza.getPropio());
		pedido_PiezaDTO.setStock(pedido_Pieza.getStock());
		BdgAssembler bdgAssemb = new BdgAssembler();
		pedido_PiezaDTO.setBdg(bdgAssemb.getBdgDTO(pedido_Pieza.getBdg()));
		Devolucion_PiezaAssembler devolucion_piezaAssemb = new Devolucion_PiezaAssembler();
		pedido_PiezaDTO.setDevolucion_pieza(devolucion_piezaAssemb.getDevolucion_PiezaDTO(pedido_Pieza.getDevolucion_pieza()));
		Estado_PedidoAssembler estado_pedidoAssemb = new Estado_PedidoAssembler();
		pedido_PiezaDTO.setEstado_pedido(estado_pedidoAssemb.getEstado_PedidoDTO(pedido_Pieza.getEstado_pedido()));
		Mano_ObraAssembler mano_obraAssemb = new Mano_ObraAssembler();
		pedido_PiezaDTO.setMano_obra(mano_obraAssemb.getMano_ObraDTO(pedido_Pieza.getMano_obra()));
		MuletoAssembler muletoAssemb = new MuletoAssembler();
		pedido_PiezaDTO.setMuleto(muletoAssemb.getMuletoDTO(pedido_Pieza.getMuleto()));
		PedidoAssembler pedidoAssemb =new PedidoAssembler();
		pedido_PiezaDTO.setPedido(pedidoAssemb.getPedidoDTO(pedido_Pieza.getPedido()));
		PiezaAssembler piezaAssemb = new PiezaAssembler();
		pedido_PiezaDTO.setPieza(piezaAssemb.getPiezaDTO(pedido_Pieza.getPieza()));
		RecursoAssembler recursoAssemb = new RecursoAssembler();
		pedido_PiezaDTO.setRecurso(recursoAssemb.getRecursoDTO(pedido_Pieza.getRecurso()));
		return pedido_PiezaDTO;
	}
	public static Pedido_Pieza getPedido_Pieza (Pedido_PiezaDTO pedido_PiezaDTO ){
		Pedido_Pieza pedido_Pieza = new Pedido_Pieza();
		pedido_Pieza.setId(pedido_PiezaDTO.getId());
		pedido_Pieza.setFecha_estado(pedido_PiezaDTO.getFecha_estado());
		pedido_Pieza.setPropio(pedido_PiezaDTO.getPropio());
		pedido_Pieza.setStock(pedido_PiezaDTO.getStock());
		BdgAssembler bdgAssemb = new BdgAssembler();
		pedido_Pieza.setBdg(bdgAssemb.getBdg(pedido_PiezaDTO.getBdg()));
		Devolucion_PiezaAssembler devolucion_piezaAssemb = new Devolucion_PiezaAssembler();
		pedido_Pieza.setDevolucion_pieza(devolucion_piezaAssemb.getDevolucion_Pieza(pedido_PiezaDTO.getDevolucion_pieza()));
		Estado_PedidoAssembler estado_pedidoAssemb = new Estado_PedidoAssembler();
		pedido_Pieza.setEstado_pedido(estado_pedidoAssemb.getEstado_Pedido(pedido_PiezaDTO.getEstado_pedido()));
		Mano_ObraAssembler mano_obraAssemb = new Mano_ObraAssembler();
		pedido_Pieza.setMano_obra(mano_obraAssemb.getMano_Obra(pedido_PiezaDTO.getMano_obra()));
		MuletoAssembler muletoAssemb = new MuletoAssembler();
		pedido_Pieza.setMuleto(muletoAssemb.getMuleto(pedido_PiezaDTO.getMuleto()));
		PedidoAssembler pedidoAssemb =new PedidoAssembler();
		pedido_Pieza.setPedido(pedidoAssemb.getPedido(pedido_PiezaDTO.getPedido()));
		PiezaAssembler piezaAssemb = new PiezaAssembler();
		pedido_Pieza.setPieza(piezaAssemb.getPieza(pedido_PiezaDTO.getPieza()));
		RecursoAssembler recursoAssemb = new RecursoAssembler();
		pedido_Pieza.setRecurso(recursoAssemb.getRecurso(pedido_PiezaDTO.getRecurso()));
		return pedido_Pieza;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==Pedido_PiezaDTO.class) {
				aux.add(getPedido_Pieza((Pedido_PiezaDTO) obj));
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
			if (obj.getClass()==Pedido_Pieza.class) {
				auxDTO.add(getPedido_PiezaDTO((Pedido_Pieza) obj));
			}
		}
		return auxDTO;
	}

}