package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import servidor.persistencia.dominio.Marca;
import common.DTOs.MarcaDTO;

public class MarcaAssembler {

	public MarcaAssembler(){}
	
	public static MarcaDTO getMarcaDTO (Marca marca){
		MarcaDTO marcaDTO = new MarcaDTO();
		marcaDTO.setId(marca.getId());
		marcaDTO.setNombre_marca(marca.getNombre_marca());
		return marcaDTO;
	}
	public static Marca getMarca (MarcaDTO marcaDTO){
		Marca marca = new Marca();
		marca.setId(marcaDTO.getId());
		marca.setNombre_marca(marcaDTO.getNombre_marca());
		return marca;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==MarcaDTO.class) {
				aux.add(getMarca((MarcaDTO) obj));
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
			if (obj.getClass()==Marca.class) {
				auxDTO.add(getMarcaDTO((Marca) obj));
			}
		}
		return auxDTO;
	}

}