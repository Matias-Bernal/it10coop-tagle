package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Notificacion_Usuario;
import common.DTOs.Notificacion_UsuarioDTO;

public class Notificacion_UsuarioAssembler {
	
	public Notificacion_UsuarioAssembler(){}
	
	public static Notificacion_UsuarioDTO getNotificacion_UsuarioDTO(Notificacion_Usuario notificacion_Usuario){
		Notificacion_UsuarioDTO notificacion_UsuarioDTO = new Notificacion_UsuarioDTO();
		notificacion_UsuarioDTO.setId(notificacion_Usuario.getId());
		NotificacionAssembler notificacionAssemb = new NotificacionAssembler();
		notificacion_UsuarioDTO.setNotificacion(notificacionAssemb.getNotificacionDTO(notificacion_Usuario.getNotificacion()));
		UsuarioAssembler usuarioAssemb = new UsuarioAssembler();
		notificacion_UsuarioDTO.setUsuario(usuarioAssemb.getUsuarioDTO(notificacion_Usuario.getUsuario()));
		return notificacion_UsuarioDTO;
	}
	public static Notificacion_Usuario getNotificacion_Usuario(Notificacion_UsuarioDTO notificacion_UsusarioDTO){
		Notificacion_Usuario notificacion_Ususario = new Notificacion_Usuario();
		notificacion_Ususario.setId(notificacion_UsusarioDTO.getId());
		NotificacionAssembler notificacionAssemb = new NotificacionAssembler();
		notificacion_Ususario.setNotificacion(notificacionAssemb.getNotificacion(notificacion_UsusarioDTO.getNotificacion()));
		UsuarioAssembler usuarioAssemb = new UsuarioAssembler();
		notificacion_Ususario.setUsuario(usuarioAssemb.getUsuario(notificacion_UsusarioDTO.getUsuario()));
		return notificacion_Ususario;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==Notificacion_UsuarioDTO.class) {
				aux.add(getNotificacion_Usuario((Notificacion_UsuarioDTO) obj));
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
			if (obj.getClass()==Notificacion_Usuario.class) {
				auxDTO.add(getNotificacion_UsuarioDTO((Notificacion_Usuario) obj));
			}
		}
		return auxDTO;
	}

}