package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import common.DTOs.AdministrativoDTO;
import servidor.persistencia.dominio.Administrativo;

public class AdministrativoAssembler {
	
	public AdministrativoAssembler() {}
	
	public static AdministrativoDTO getAdministrativoDTO(Administrativo administrativo) {
		AdministrativoDTO adminDTO = new AdministrativoDTO();
		adminDTO.setId(administrativo.getId());
		adminDTO.setNombre_usuario(administrativo.getNombre_usuario());
		adminDTO.setClave(administrativo.getClave());
		adminDTO.setEmail(administrativo.getEmail());
		return adminDTO;
	}
	public static Administrativo getAdministrativo(AdministrativoDTO administrativoDTO) {
		Administrativo admin = new Administrativo();
		admin.setId(administrativoDTO.getId());
		admin.setNombre_usuario(administrativoDTO.getNombre_usuario());
		admin.setClave(administrativoDTO.getClave());
		admin.setEmail(administrativoDTO.getEmail());
		return admin;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==AdministrativoDTO.class) {
				aux.add(getAdministrativo((AdministrativoDTO) obj));
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
			if (obj.getClass()==Administrativo.class) {
				auxDTO.add(getAdministrativoDTO((Administrativo) obj));
			}
		}
		return auxDTO;
	}

}