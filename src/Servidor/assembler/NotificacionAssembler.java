package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Notificacion;
import common.DTOs.NotificacionDTO;

public class NotificacionAssembler {

	public NotificacionAssembler(){}

	
	public static NotificacionDTO getNotificacionDTO(Notificacion notificacion) {
		NotificacionDTO notificacionDTO = new NotificacionDTO();
		notificacionDTO.setId(notificacion.getId());
		notificacionDTO.setTexto_notificacion(notificacion.getTexto_notificacion());
		notificacionDTO.setFecha_notificacion(notificacion.getFecha_notificacion());
		notificacionDTO.setConcretada_notificacion(notificacion.getConcretada_notificacion());
		return notificacionDTO;
	}
	public static Notificacion getNotificacion(NotificacionDTO notificacionDTO) {
		Notificacion notificacion = new Notificacion();
		notificacion.setId(notificacionDTO.getId());
		notificacion.setTexto_notificacion(notificacionDTO.getTexto_notificacion());
		notificacion.setFecha_notificacion(notificacionDTO.getFecha_notificacion());
		notificacion.setConcretada_notificacion(notificacionDTO.getConcretada_notificacion());
		return notificacion;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==NotificacionDTO.class) {
				aux.add(getNotificacion((NotificacionDTO) obj));
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
			if (obj.getClass()==Notificacion.class) {
				auxDTO.add(getNotificacionDTO((Notificacion) obj));
			}
		}
		return auxDTO;
	}

}