package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.ClaseGeneral;
import common.DTOs.ClaseGeneralDTO;

public class ClaseGeneralAssembler {

	public ClaseGeneralAssembler() {}
	
	public static ClaseGeneralDTO getClaseGeneralDTO(ClaseGeneral claseGeneral) {
		ClaseGeneralDTO claseGeneralDTO = new ClaseGeneralDTO();
		claseGeneralDTO.setId(claseGeneral.getId());
		return claseGeneralDTO;
	}
	public static ClaseGeneral getClaseGeneral(ClaseGeneralDTO claseGeneralDTO) {
		ClaseGeneral claseGeneral = new ClaseGeneral();
		claseGeneral.setId(claseGeneralDTO.getId());
		return claseGeneral;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==ClaseGeneralDTO.class) {
				aux.add(getClaseGeneral((ClaseGeneralDTO) obj));
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
			if (obj.getClass()==ClaseGeneral.class) {
				auxDTO.add(getClaseGeneralDTO((ClaseGeneral) obj));
			}
		}
		return auxDTO;
	}

}