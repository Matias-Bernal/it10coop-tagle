package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Muleto;
import common.DTOs.MuletoDTO;

public class MuletoAssembler {
	
	public MuletoAssembler(){}
	
	public static MuletoDTO getMuletoDTO (Muleto muleto){
		MuletoDTO muletoDTO = new MuletoDTO();
		muletoDTO.setId(muleto.getId());
		muletoDTO.setDescripcion(muleto.getDescripcion());
		muletoDTO.setVin(muleto.getVin());
		PedidoAssembler pedidoAssemb = new PedidoAssembler();
		muletoDTO.setPedido(pedidoAssemb.getPedidoDTO(muleto.getPedido()));
		PiezaAssembler piezaAssemb = new PiezaAssembler();
		muletoDTO.setPieza(piezaAssemb.getPiezaDTO(muleto.getPieza()));
		return muletoDTO;
	}
	public static Muleto getMuleto (MuletoDTO muletoDTO){
		Muleto muleto = new Muleto();
		muleto.setId(muletoDTO.getId());
		muleto.setDescripcion(muletoDTO.getDescripcion());
		muleto.setVin(muletoDTO.getVin());
		PedidoAssembler pedidoAssemb = new PedidoAssembler();
		muleto.setPedido(pedidoAssemb.getPedido(muletoDTO.getPedido()));
		PiezaAssembler piezaAssemb = new PiezaAssembler();
		muleto.setPieza(piezaAssemb.getPieza(muletoDTO.getPieza()));
		return muleto;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==MuletoDTO.class) {
				aux.add(getMuleto((MuletoDTO) obj));
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
			if (obj.getClass()==Muleto.class) {
				auxDTO.add(getMuletoDTO((Muleto) obj));
			}
		}
		return auxDTO;
	}

}