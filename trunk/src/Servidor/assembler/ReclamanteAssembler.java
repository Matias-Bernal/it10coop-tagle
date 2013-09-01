package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Reclamante;
import common.DTOs.ReclamanteDTO;

public class ReclamanteAssembler {
	
	public ReclamanteAssembler(){}

	public static ReclamanteDTO getReclamanteDTO(Reclamante reclamante) {
		ReclamanteDTO reclamanteDTO = new ReclamanteDTO();
		reclamanteDTO.setId(reclamante.getId());
		reclamanteDTO.setNombre_apellido(reclamante.getNombre_apellido());
		reclamanteDTO.setEmail(reclamante.getEmail());
		return reclamanteDTO;
	}
	public static Reclamante getReclamante(ReclamanteDTO reclamanteDTO) {
		Reclamante reclamante = new Reclamante();
		reclamante.setId(reclamanteDTO.getId());
		reclamante.setNombre_apellido(reclamanteDTO.getNombre_apellido());
		reclamante.setEmail(reclamanteDTO.getEmail());
		return reclamante;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==ReclamanteDTO.class) {
				aux.add(getReclamante((ReclamanteDTO) obj));
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
			if (obj.getClass()==Reclamante.class) {
				auxDTO.add(getReclamanteDTO((Reclamante) obj));
			}
		}
		return auxDTO;
	}

}