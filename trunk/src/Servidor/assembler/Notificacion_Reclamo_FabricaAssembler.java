package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Notificacion_Reclamo_Fabrica;
import common.DTOs.Notificacion_Reclamo_FabricaDTO;

public class Notificacion_Reclamo_FabricaAssembler {

	public Notificacion_Reclamo_FabricaAssembler(){}
	
	public static Notificacion_Reclamo_FabricaDTO getNotificacion_Reclamo_FabricaDTO (Notificacion_Reclamo_Fabrica notificacion_Reclamo_Fabrica ){
		Notificacion_Reclamo_FabricaDTO notificacion_Reclamo_FabricaDTO = new Notificacion_Reclamo_FabricaDTO();
		notificacion_Reclamo_FabricaDTO.setId(notificacion_Reclamo_Fabrica.getId());
		notificacion_Reclamo_FabricaDTO.setTexto_notificacion(notificacion_Reclamo_Fabrica.getTexto_notificacion());
		notificacion_Reclamo_FabricaDTO.setFecha_notificacion(notificacion_Reclamo_Fabrica.getFecha_notificacion());
		notificacion_Reclamo_FabricaDTO.setConcretada_notificacion(notificacion_Reclamo_Fabrica.getConcretada_notificacion());
		return notificacion_Reclamo_FabricaDTO;
	}
	public static Notificacion_Reclamo_Fabrica getNotificacion_Reclamo_Fabrica (Notificacion_Reclamo_FabricaDTO notificacion_Reclamo_FabricaDTO ){
		Notificacion_Reclamo_Fabrica notificacion_Reclamo_Fabrica = new Notificacion_Reclamo_Fabrica();
		notificacion_Reclamo_Fabrica.setId(notificacion_Reclamo_FabricaDTO.getId());
		notificacion_Reclamo_Fabrica.setTexto_notificacion(notificacion_Reclamo_FabricaDTO.getTexto_notificacion());
		notificacion_Reclamo_Fabrica.setFecha_notificacion(notificacion_Reclamo_FabricaDTO.getFecha_notificacion());
		notificacion_Reclamo_Fabrica.setConcretada_notificacion(notificacion_Reclamo_FabricaDTO.getConcretada_notificacion());
		return notificacion_Reclamo_Fabrica;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==Notificacion_Reclamo_FabricaDTO.class) {
	
				aux.add(getNotificacion_Reclamo_Fabrica((Notificacion_Reclamo_FabricaDTO) obj));
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
			if (obj.getClass()==Notificacion_Reclamo_Fabrica.class) {
				auxDTO.add(getNotificacion_Reclamo_FabricaDTO((Notificacion_Reclamo_Fabrica) obj));
			}
		}
		return auxDTO;
	}

}