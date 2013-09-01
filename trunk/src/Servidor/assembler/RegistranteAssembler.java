package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Registrante;
import common.DTOs.RegistranteDTO;

public class RegistranteAssembler {
	
	public RegistranteAssembler(){}
	
	public static RegistranteDTO getRegistranteDTO (Registrante registrante ){
		RegistranteDTO registranteDTO = new RegistranteDTO();
		registranteDTO.setId(registrante.getId());
		registranteDTO.setNombre_registrante(registrante.getNombre_registrante());
		return registranteDTO;
	}
	public static Registrante getRegistrante (RegistranteDTO registranteDTO ){
		Registrante registrante = new Registrante();
		registrante.setId(registranteDTO.getId());
		registrante.setNombre_registrante(registranteDTO.getNombre_registrante());
		return registrante;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==RegistranteDTO.class) {
				aux.add(getRegistrante((RegistranteDTO) obj));
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
			if (obj.getClass()==Registrante.class) {
				auxDTO.add(getRegistranteDTO((Registrante) obj));
			}
		}
		return auxDTO;
	}

}