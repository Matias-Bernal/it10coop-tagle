package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Pieza;
import common.DTOs.PiezaDTO;

public class PiezaAssembler {

	public PiezaAssembler(){}
	
	public static PiezaDTO getPiezaDTO(Pieza pieza) {
		PiezaDTO piezaDTO = new PiezaDTO();
		piezaDTO.setId(pieza.getId());
		piezaDTO.setNumero_pieza(pieza.getNumero_pieza());
		piezaDTO.setDescripcion(pieza.getDescripcion());
		return piezaDTO;
	}
	public static Pieza getPieza(PiezaDTO piezaDTO) {
		Pieza pieza = new Pieza();
		pieza.setId(piezaDTO.getId());
		pieza.setNumero_pieza(piezaDTO.getNumero_pieza());
		pieza.setDescripcion(piezaDTO.getDescripcion());
		return pieza;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==PiezaDTO.class) {
				aux.add(getPieza((PiezaDTO) obj));
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
			if (obj.getClass()==Pieza.class) {
				auxDTO.add(getPiezaDTO((Pieza) obj));
			}
		}
		return auxDTO;
	}

}