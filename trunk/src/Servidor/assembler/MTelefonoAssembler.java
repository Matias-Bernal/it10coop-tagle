package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.MTelefono;
import common.DTOs.MTelefonoDTO;

public class MTelefonoAssembler {
	
	public MTelefonoAssembler(){}
	
	public static MTelefonoDTO getMTelefonoDTO (MTelefono mTelefono){
		MTelefonoDTO mTelefonoDTO = new MTelefonoDTO();
		mTelefonoDTO.setId(mTelefono.getId());
		mTelefonoDTO.setTelefono(mTelefono.getTelefono());
		ReclamanteAssembler reclamanteAssemb = new ReclamanteAssembler();
		mTelefonoDTO.setReclamante(reclamanteAssemb.getReclamanteDTO(mTelefono.getReclamante()));
		return mTelefonoDTO;
	}
	public static MTelefono getMTelefono (MTelefonoDTO mTelefonoDTO){
		MTelefono mTelefono = new MTelefono();
		mTelefono.setId(mTelefonoDTO.getId());
		mTelefono.setTelefono(mTelefonoDTO.getTelefono());
		ReclamanteAssembler reclamanteAssemb = new ReclamanteAssembler();
		mTelefono.setReclamante(reclamanteAssemb.getReclamante(mTelefonoDTO.getReclamante()));
		return mTelefono;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==MTelefonoDTO.class) {
				aux.add(getMTelefono((MTelefonoDTO) obj));
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
			if (obj.getClass()==MTelefono.class) {
				auxDTO.add(getMTelefonoDTO((MTelefono) obj));
			}
		}
		return auxDTO;
	}

}