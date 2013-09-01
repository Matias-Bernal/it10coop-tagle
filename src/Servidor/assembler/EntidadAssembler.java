package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import servidor.persistencia.dominio.Entidad;
import common.DTOs.EntidadDTO;

public class EntidadAssembler {
	
	public static EntidadDTO getEntidadDTO(Entidad entidad) {
		EntidadDTO entidadDTO = new EntidadDTO();
		entidadDTO.setId(entidad.getId());
		entidadDTO.setNombre_registrante(entidad.getNombre_registrante());
		return entidadDTO;
	}
	public static Entidad getEntidad(EntidadDTO entidadDTO) {
		Entidad entidad = new Entidad();
		entidad.setId(entidadDTO.getId());
		entidad.setNombre_registrante(entidadDTO.getNombre_registrante());
		return entidad;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==EntidadDTO.class) {
				aux.add(getEntidad((EntidadDTO) obj));
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
			if (obj.getClass()==Entidad.class) {
				auxDTO.add(getEntidadDTO((Entidad) obj));
			}
		}
		return auxDTO;
	}

}