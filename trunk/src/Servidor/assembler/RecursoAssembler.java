package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Recurso;
import common.DTOs.RecursoDTO;

public class RecursoAssembler {
	
	public RecursoAssembler(){}

	public static RecursoDTO getRecursoDTO(Recurso recurso) {
		RecursoDTO recursoDTO = new RecursoDTO();
		recursoDTO.setId(recurso.getId());
		recursoDTO.setFecha_recurso(recurso.getFecha_recurso());
		recursoDTO.setNumero_recurso(recurso.getNumero_recurso());
		return recursoDTO;
	}

	public static Recurso getRecurso(RecursoDTO recursoDTO) {
		Recurso recurso = new Recurso();
		recurso.setId(recursoDTO.getId());
		recurso.setFecha_recurso(recursoDTO.getFecha_recurso());
		recurso.setNumero_recurso(recursoDTO.getNumero_recurso());
		return recurso;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==RecursoDTO.class) {
				aux.add(getRecurso((RecursoDTO) obj));
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
			if (obj.getClass()==Recurso.class) {
				auxDTO.add(getRecursoDTO((Recurso) obj));
			}
		}
		return auxDTO;
	}

}