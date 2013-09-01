package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Notificacion_Area_Administracion;
import common.DTOs.Notificacion_Area_AdministracionDTO;

public class Notificacion_Area_AdministracionAssembler {

	public Notificacion_Area_AdministracionAssembler(){}
	
	public static Notificacion_Area_AdministracionDTO getNotificacion_Area_AdministracionDTO (Notificacion_Area_Administracion notificacion_Area_Administracion ){
		Notificacion_Area_AdministracionDTO notificacion_Area_AdministracionDTO = new Notificacion_Area_AdministracionDTO();
		notificacion_Area_AdministracionDTO.setId(notificacion_Area_Administracion.getId());
		notificacion_Area_AdministracionDTO.setTexto_notificacion(notificacion_Area_Administracion.getTexto_notificacion());
		notificacion_Area_AdministracionDTO.setFecha_notificacion(notificacion_Area_Administracion.getFecha_notificacion());
		notificacion_Area_AdministracionDTO.setConcretada_notificacion(notificacion_Area_Administracion.getConcretada_notificacion());
		return notificacion_Area_AdministracionDTO;
	}
	public static Notificacion_Area_Administracion getNotificacion_Area_Administracion (Notificacion_Area_AdministracionDTO notificacion_Area_AdministracionDTO ){
		Notificacion_Area_Administracion notificacion_Area_Administracion = new Notificacion_Area_Administracion();
		notificacion_Area_Administracion.setId(notificacion_Area_AdministracionDTO.getId());
		notificacion_Area_Administracion.setTexto_notificacion(notificacion_Area_AdministracionDTO.getTexto_notificacion());
		notificacion_Area_Administracion.setFecha_notificacion(notificacion_Area_AdministracionDTO.getFecha_notificacion());
		notificacion_Area_Administracion.setConcretada_notificacion(notificacion_Area_AdministracionDTO.getConcretada_notificacion());
		return notificacion_Area_Administracion;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==Notificacion_Area_AdministracionDTO.class) {
				aux.add(getNotificacion_Area_Administracion((Notificacion_Area_AdministracionDTO) obj));
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
			if (obj.getClass()==Notificacion_Area_Administracion.class) {
				auxDTO.add(getNotificacion_Area_AdministracionDTO((Notificacion_Area_Administracion) obj));
			}
		}
		return auxDTO;
	}

}