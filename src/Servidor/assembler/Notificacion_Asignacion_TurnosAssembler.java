package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Notificacion_Asignacion_Turnos;
import common.DTOs.Notificacion_Asignacion_TurnosDTO;

public class Notificacion_Asignacion_TurnosAssembler {

	public Notificacion_Asignacion_TurnosAssembler(){}
	
	public static Notificacion_Asignacion_TurnosDTO getNotificacion_Asignacion_TurnosDTO (Notificacion_Asignacion_Turnos notificacion_Asignacion_Turnos ){
		Notificacion_Asignacion_TurnosDTO notificacion_Asignacion_TurnosDTO = new Notificacion_Asignacion_TurnosDTO();
		notificacion_Asignacion_TurnosDTO.setId(notificacion_Asignacion_Turnos.getId());
		notificacion_Asignacion_TurnosDTO.setTexto_notificacion(notificacion_Asignacion_Turnos.getTexto_notificacion());
		notificacion_Asignacion_TurnosDTO.setFecha_notificacion(notificacion_Asignacion_Turnos.getFecha_notificacion());
		notificacion_Asignacion_TurnosDTO.setConcretada_notificacion(notificacion_Asignacion_Turnos.getConcretada_notificacion());
		return notificacion_Asignacion_TurnosDTO;
	}
	public static Notificacion_Asignacion_Turnos getNotificacion_Asignacion_Turnos (Notificacion_Asignacion_TurnosDTO notificacion_Asignacion_TurnosDTO ){
		Notificacion_Asignacion_Turnos notificacion_Asignacion_Turnos = new Notificacion_Asignacion_Turnos();
		notificacion_Asignacion_Turnos.setId(notificacion_Asignacion_TurnosDTO.getId());
		notificacion_Asignacion_Turnos.setTexto_notificacion(notificacion_Asignacion_TurnosDTO.getTexto_notificacion());
		notificacion_Asignacion_Turnos.setFecha_notificacion(notificacion_Asignacion_TurnosDTO.getFecha_notificacion());
		notificacion_Asignacion_Turnos.setConcretada_notificacion(notificacion_Asignacion_TurnosDTO.getConcretada_notificacion());
		return notificacion_Asignacion_Turnos;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==Notificacion_Asignacion_TurnosDTO.class) {
	
				aux.add(getNotificacion_Asignacion_Turnos((Notificacion_Asignacion_TurnosDTO) obj));
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
			if (obj.getClass()==Notificacion_Asignacion_Turnos.class) {
				auxDTO.add(getNotificacion_Asignacion_TurnosDTO((Notificacion_Asignacion_Turnos) obj));
			}
		}
		return auxDTO;
	}

}