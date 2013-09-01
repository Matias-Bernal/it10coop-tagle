package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Notificacion_Sugerencia;
import common.DTOs.Notificacion_SugerenciaDTO;

public class Notificacion_SugerenciaAssembler {

	public Notificacion_SugerenciaAssembler(){}
	
	public static Notificacion_SugerenciaDTO getNotificacion_SugerenciaDTO (Notificacion_Sugerencia notificacion_Sugerencia ){
		Notificacion_SugerenciaDTO notificacion_SugerenciaDTO = new Notificacion_SugerenciaDTO();
		notificacion_SugerenciaDTO.setId(notificacion_Sugerencia.getId());
		notificacion_SugerenciaDTO.setTexto_notificacion(notificacion_Sugerencia.getTexto_notificacion());
		notificacion_SugerenciaDTO.setFecha_notificacion(notificacion_Sugerencia.getFecha_notificacion());
		notificacion_SugerenciaDTO.setConcretada_notificacion(notificacion_Sugerencia.getConcretada_notificacion());
		return notificacion_SugerenciaDTO;
	}
	public static Notificacion_Sugerencia getNotificacion_Sugerencia (Notificacion_SugerenciaDTO notificacion_SugerenciaDTO ){
		Notificacion_Sugerencia notificacion_Sugerencia = new Notificacion_Sugerencia();
		notificacion_Sugerencia.setId(notificacion_SugerenciaDTO.getId());
		notificacion_Sugerencia.setTexto_notificacion(notificacion_SugerenciaDTO.getTexto_notificacion());
		notificacion_Sugerencia.setFecha_notificacion(notificacion_SugerenciaDTO.getFecha_notificacion());
		notificacion_Sugerencia.setConcretada_notificacion(notificacion_SugerenciaDTO.getConcretada_notificacion());
		return notificacion_Sugerencia;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==Notificacion_SugerenciaDTO.class) {
	
				aux.add(getNotificacion_Sugerencia((Notificacion_SugerenciaDTO) obj));
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
			if (obj.getClass()==Notificacion_Sugerencia.class) {
				auxDTO.add(getNotificacion_SugerenciaDTO((Notificacion_Sugerencia) obj));
			}
		}
		return auxDTO;
	}

}