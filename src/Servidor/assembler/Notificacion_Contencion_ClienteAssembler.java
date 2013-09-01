package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Notificacion_Contencion_Cliente;
import common.DTOs.Notificacion_Contencion_ClienteDTO;

public class Notificacion_Contencion_ClienteAssembler {

	public Notificacion_Contencion_ClienteAssembler(){}
	
	public static Notificacion_Contencion_ClienteDTO getNotificacion_Contencion_ClienteDTO (Notificacion_Contencion_Cliente notificacion_Contencion_Cliente ){
		Notificacion_Contencion_ClienteDTO notificacion_Contencion_ClienteDTO = new Notificacion_Contencion_ClienteDTO();
		notificacion_Contencion_ClienteDTO.setId(notificacion_Contencion_Cliente.getId());
		notificacion_Contencion_ClienteDTO.setTexto_notificacion(notificacion_Contencion_Cliente.getTexto_notificacion());
		notificacion_Contencion_ClienteDTO.setFecha_notificacion(notificacion_Contencion_Cliente.getFecha_notificacion());
		notificacion_Contencion_ClienteDTO.setConcretada_notificacion(notificacion_Contencion_Cliente.getConcretada_notificacion());
		return notificacion_Contencion_ClienteDTO;
	}
	public static Notificacion_Contencion_Cliente getNotificacion_Contencion_Cliente (Notificacion_Contencion_ClienteDTO notificacion_Contencion_ClienteDTO ){
		Notificacion_Contencion_Cliente notificacion_Contencion_Cliente = new Notificacion_Contencion_Cliente();
		notificacion_Contencion_Cliente.setId(notificacion_Contencion_ClienteDTO.getId());
		notificacion_Contencion_Cliente.setTexto_notificacion(notificacion_Contencion_ClienteDTO.getTexto_notificacion());
		notificacion_Contencion_Cliente.setFecha_notificacion(notificacion_Contencion_ClienteDTO.getFecha_notificacion());
		notificacion_Contencion_Cliente.setConcretada_notificacion(notificacion_Contencion_ClienteDTO.getConcretada_notificacion());
		return notificacion_Contencion_Cliente;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==Notificacion_Contencion_ClienteDTO.class) {
	
				aux.add(getNotificacion_Contencion_Cliente((Notificacion_Contencion_ClienteDTO) obj));
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
			if (obj.getClass()==Notificacion_Contencion_Cliente.class) {
				auxDTO.add(getNotificacion_Contencion_ClienteDTO((Notificacion_Contencion_Cliente) obj));
			}
		}
		return auxDTO;
	}

}