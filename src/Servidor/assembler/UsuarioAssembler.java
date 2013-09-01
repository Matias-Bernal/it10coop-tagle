package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Usuario;
import common.DTOs.UsuarioDTO;

public class UsuarioAssembler {

	public UsuarioAssembler(){}
	
	public static UsuarioDTO getUsuarioDTO (Usuario usuario ){
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(usuario.getId());
		usuarioDTO.setNombre_usuario(usuario.getNombre_usuario());
		usuarioDTO.setClave(usuario.getClave());
		usuarioDTO.setEmail(usuario.getEmail());
		return usuarioDTO;
	}
	public static Usuario getUsuario (UsuarioDTO usuarioDTO ){
		Usuario usuario = new Usuario();
		usuario.setId(usuarioDTO.getId());
		usuario.setNombre_usuario(usuarioDTO.getNombre_usuario());
		usuario.setClave(usuarioDTO.getClave());
		usuario.setEmail(usuarioDTO.getEmail());
		return usuario;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==UsuarioDTO.class) {
				aux.add(getUsuario((UsuarioDTO) obj));
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
			if (obj.getClass()==Usuario.class) {
				auxDTO.add(getUsuarioDTO((Usuario) obj));
			}
		}
		return auxDTO;
	}

}