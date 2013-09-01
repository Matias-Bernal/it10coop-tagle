package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import servidor.persistencia.dominio.Mano_Obra;
import common.DTOs.Mano_ObraDTO;

public class Mano_ObraAssembler {

	public Mano_ObraAssembler(){}
	
	public static Mano_ObraDTO getMano_ObraDTO(Mano_Obra mano_obra){
		Mano_ObraDTO mano_obraDTO = new Mano_ObraDTO();
		mano_obraDTO.setId(mano_obra.getId());
		mano_obraDTO.setCodigo_mano_obra(mano_obra.getCodigo_mano_obra());
		mano_obraDTO.setCantidad_horas(mano_obra.getCantidad_horas());
		mano_obraDTO.setValor_mano_obra(mano_obra.getValor_mano_obra());
		ReclamoAssembler reclamoAssemb = new ReclamoAssembler();
		mano_obraDTO.setReclamo(reclamoAssemb.getReclamoDTO(mano_obra.getReclamo()));
		return mano_obraDTO;
	}
	public static Mano_Obra getMano_Obra(Mano_ObraDTO mano_obraDTO){
		Mano_Obra mano_obra = new Mano_Obra();
		mano_obra.setId(mano_obraDTO.getId());
		mano_obra.setCodigo_mano_obra(mano_obraDTO.getCodigo_mano_obra());
		mano_obra.setCantidad_horas(mano_obraDTO.getCantidad_horas());
		mano_obra.setValor_mano_obra(mano_obraDTO.getValor_mano_obra());
		ReclamoAssembler reclamoAssemb = new ReclamoAssembler();
		mano_obra.setReclamo(reclamoAssemb.getReclamo(mano_obraDTO.getReclamo()));
		return mano_obra;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==Mano_ObraDTO.class) {
				aux.add(getMano_Obra((Mano_ObraDTO) obj));
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
			if (obj.getClass()==Mano_Obra.class) {
				auxDTO.add(getMano_ObraDTO((Mano_Obra) obj));
			}
		}
		return auxDTO;
	}

}