package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Reclamante_Reclamo;
import common.DTOs.Reclamante_ReclamoDTO;

public class Reclamante_ReclamoAssembler {

	public Reclamante_ReclamoAssembler(){}
	
	public static Reclamante_ReclamoDTO getReclamante_ReclamoDTO (Reclamante_Reclamo reclamante_Reclamo ){
		Reclamante_ReclamoDTO reclamante_ReclamoDTO = new Reclamante_ReclamoDTO();
		reclamante_ReclamoDTO.setId(reclamante_Reclamo.getId());
		ReclamanteAssembler reclamanteAssemb = new ReclamanteAssembler();
		reclamante_ReclamoDTO.setReclamante(reclamanteAssemb.getReclamanteDTO(reclamante_Reclamo.getReclamante()));
		ReclamoAssembler reclamoAssemb = new ReclamoAssembler();
		reclamante_ReclamoDTO.setReclamo(reclamoAssemb.getReclamoDTO(reclamante_Reclamo.getReclamo()));
		return reclamante_ReclamoDTO;
	}
	public static Reclamante_Reclamo getReclamante_Reclamo (Reclamante_ReclamoDTO reclamante_ReclamoDTO ){
		Reclamante_Reclamo reclamante_Reclamo = new Reclamante_Reclamo();
		reclamante_Reclamo.setId(reclamante_ReclamoDTO.getId());
		ReclamanteAssembler reclamanteAssemb = new ReclamanteAssembler();
		reclamante_Reclamo.setReclamante(reclamanteAssemb.getReclamante(reclamante_ReclamoDTO.getReclamante()));
		ReclamoAssembler reclamoAssemb = new ReclamoAssembler();
		reclamante_Reclamo.setReclamo(reclamoAssemb.getReclamo(reclamante_ReclamoDTO.getReclamo()));
		return reclamante_Reclamo;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==Reclamante_ReclamoDTO.class) {
				aux.add(getReclamante_Reclamo((Reclamante_ReclamoDTO) obj));
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
			if (obj.getClass()==Reclamante_Reclamo.class) {
				auxDTO.add(getReclamante_ReclamoDTO((Reclamante_Reclamo) obj));
			}
		}
		return auxDTO;
	}

}