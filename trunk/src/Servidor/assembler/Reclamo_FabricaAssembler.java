package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Reclamo_Fabrica;
import common.DTOs.Reclamo_FabricaDTO;

public class Reclamo_FabricaAssembler {

	
	public static Reclamo_FabricaDTO getReclamo_FabricaDTO(Reclamo_Fabrica reclamo_fabrica) {
		Reclamo_FabricaDTO reclamo_fabricaDTO = new Reclamo_FabricaDTO();
		reclamo_fabricaDTO.setId(reclamo_fabrica.getId());
		reclamo_fabricaDTO.setFecha_reclamo_fabrica(reclamo_fabrica.getFecha_reclamo_fabrica());
		PedidoAssembler pedidoAssemb = new PedidoAssembler();
		reclamo_fabricaDTO.setPedido(pedidoAssemb.getPedidoDTO(reclamo_fabrica.getPedido()));
		PiezaAssembler piezaAssemb = new PiezaAssembler();
		reclamo_fabricaDTO.setPieza(piezaAssemb.getPiezaDTO(reclamo_fabrica.getPieza()));
		UsuarioAssembler usuarioAssemb = new UsuarioAssembler();
		reclamo_fabricaDTO.setUsuario(usuarioAssemb.getUsuarioDTO(reclamo_fabrica.getUsuario()));
		return reclamo_fabricaDTO;
	}

	public static Reclamo_Fabrica getReclamo_Fabrica(Reclamo_FabricaDTO reclamo_fabricaDTO) {
		Reclamo_Fabrica reclamo_fabrica = new Reclamo_Fabrica();
		reclamo_fabrica.setId(reclamo_fabricaDTO.getId());
		reclamo_fabrica.setFecha_reclamo_fabrica(reclamo_fabricaDTO.getFecha_reclamo_fabrica());
		PedidoAssembler pedidoAssemb = new PedidoAssembler();
		reclamo_fabrica.setPedido(pedidoAssemb.getPedido(reclamo_fabricaDTO.getPedido()));
		PiezaAssembler piezaAssemb = new PiezaAssembler();
		reclamo_fabrica.setPieza(piezaAssemb.getPieza(reclamo_fabricaDTO.getPieza()));
		UsuarioAssembler usuarioAssemb = new UsuarioAssembler();
		reclamo_fabrica.setUsuario(usuarioAssemb.getUsuario(reclamo_fabricaDTO.getUsuario()));
		return reclamo_fabrica;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==Reclamo_FabricaDTO.class) {
				aux.add(getReclamo_Fabrica((Reclamo_FabricaDTO) obj));
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
			if (obj.getClass()==Reclamo_Fabrica.class) {
				auxDTO.add(getReclamo_FabricaDTO((Reclamo_Fabrica) obj));
			}
		}
		return auxDTO;
	}

}