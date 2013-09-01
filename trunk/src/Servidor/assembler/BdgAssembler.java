package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import servidor.persistencia.dominio.Bdg;
import common.DTOs.BdgDTO;

public class BdgAssembler {
	
	public BdgAssembler(){}
	
	public static BdgDTO getBdgDTO(Bdg bdg) {
		BdgDTO bdgDTO = new BdgDTO();
		bdgDTO.setId(bdg.getId());
		bdgDTO.setFecha_bdg(bdg.getFecha_bdg());
		PedidoAssembler pedidoAssemb = new PedidoAssembler();
		bdgDTO.setPedido(pedidoAssemb.getPedidoDTO(bdg.getPedido()));
		PiezaAssembler piezaAssem = new PiezaAssembler();
		bdgDTO.setPieza(piezaAssem.getPiezaDTO(bdg.getPieza()));
		return bdgDTO;
	}
	public static Bdg getBdg(BdgDTO bdgDTO) {
		Bdg bdg = new Bdg();
		bdg.setId(bdgDTO.getId());
		bdg.setFecha_bdg(bdgDTO.getFecha_bdg());
		PedidoAssembler pedidoAssemb = new PedidoAssembler();
		bdg.setPedido(pedidoAssemb.getPedido(bdgDTO.getPedido()));
		PiezaAssembler piezaAssem = new PiezaAssembler();
		bdg.setPieza(piezaAssem.getPieza(bdgDTO.getPieza()));
		return bdg;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==BdgDTO.class) {
				aux.add(getBdg((BdgDTO) obj));
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
			if (obj.getClass()==Bdg.class) {
				auxDTO.add(getBdgDTO((Bdg) obj));
			}
		}
		return auxDTO;
	}

}