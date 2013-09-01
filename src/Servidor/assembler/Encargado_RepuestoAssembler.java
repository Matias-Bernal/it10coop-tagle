package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import servidor.persistencia.dominio.Encargado_Repuesto;
import common.DTOs.Encargado_RepuestoDTO;

public class Encargado_RepuestoAssembler {
	
	public static Encargado_RepuestoDTO getEncargado_RepuestoDTO(Encargado_Repuesto encargado_repuesto) {
		Encargado_RepuestoDTO encargado_repuestoDTO = new Encargado_RepuestoDTO();
		encargado_repuestoDTO.setId(encargado_repuesto.getId());
		encargado_repuestoDTO.setNombre_usuario(encargado_repuesto.getNombre_usuario());
		encargado_repuestoDTO.setClave(encargado_repuesto.getClave());
		encargado_repuestoDTO.setEmail(encargado_repuesto.getEmail());
		return encargado_repuestoDTO;
	}
	public static Encargado_Repuesto getEncargado_Repuesto(Encargado_RepuestoDTO encargado_repuestoDTO) {
		Encargado_Repuesto encargado_repuesto = new Encargado_Repuesto();
		encargado_repuesto.setId(encargado_repuestoDTO.getId());
		encargado_repuesto.setNombre_usuario(encargado_repuestoDTO.getNombre_usuario());
		encargado_repuesto.setClave(encargado_repuestoDTO.getClave());
		encargado_repuesto.setEmail(encargado_repuestoDTO.getEmail());
		return encargado_repuesto;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==Encargado_RepuestoDTO.class) {
				aux.add(getEncargado_Repuesto((Encargado_RepuestoDTO) obj));
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
			if (obj.getClass()==Encargado_Repuesto.class) {
				auxDTO.add(getEncargado_RepuestoDTO((Encargado_Repuesto) obj));
			}
		}
		return auxDTO;
	}

}