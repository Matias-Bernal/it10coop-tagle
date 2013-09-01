package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import servidor.persistencia.dominio.Notificacion_Area_Repuesto;

import common.DTOs.Notificacion_Area_RepuestoDTO;

public class Notificacion_Area_RepuestoAssembler {
	
	public Notificacion_Area_RepuestoAssembler(){}
	
	public static Notificacion_Area_RepuestoDTO getNotificacion_Area_RepuestoDTO (Notificacion_Area_Repuesto Notificacion_Area_Repuesto ){
		Notificacion_Area_RepuestoDTO Notificacion_Area_RepuestoDTO = new Notificacion_Area_RepuestoDTO();
		Notificacion_Area_RepuestoDTO.setId(Notificacion_Area_Repuesto.getId());
		Notificacion_Area_RepuestoDTO.setTexto_notificacion(Notificacion_Area_Repuesto.getTexto_notificacion());
		Notificacion_Area_RepuestoDTO.setFecha_notificacion(Notificacion_Area_Repuesto.getFecha_notificacion());
		Notificacion_Area_RepuestoDTO.setConcretada_notificacion(Notificacion_Area_Repuesto.getConcretada_notificacion());
		return Notificacion_Area_RepuestoDTO;
	}
	public static Notificacion_Area_Repuesto getNotificacion_Area_Repuesto (Notificacion_Area_RepuestoDTO Notificacion_Area_RepuestoDTO ){
		Notificacion_Area_Repuesto Notificacion_Area_Repuesto = new Notificacion_Area_Repuesto();
		Notificacion_Area_Repuesto.setId(Notificacion_Area_RepuestoDTO.getId());
		Notificacion_Area_Repuesto.setTexto_notificacion(Notificacion_Area_RepuestoDTO.getTexto_notificacion());
		Notificacion_Area_Repuesto.setFecha_notificacion(Notificacion_Area_RepuestoDTO.getFecha_notificacion());
		Notificacion_Area_Repuesto.setConcretada_notificacion(Notificacion_Area_RepuestoDTO.getConcretada_notificacion());
		return Notificacion_Area_Repuesto;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==Notificacion_Area_RepuestoDTO.class) {
				aux.add(getNotificacion_Area_Repuesto((Notificacion_Area_RepuestoDTO) obj));
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
			if (obj.getClass()==Notificacion_Area_Repuesto.class) {
				auxDTO.add(getNotificacion_Area_RepuestoDTO((Notificacion_Area_Repuesto) obj));
			}
		}
		return auxDTO;
	}

}