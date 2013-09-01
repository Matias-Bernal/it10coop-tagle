package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Modelo;
import common.DTOs.ModeloDTO;

public class ModeloAssembler {

	public ModeloAssembler(){}
	
	public static ModeloDTO getModeloDTO (Modelo modelo){
		ModeloDTO modeloDTO = new ModeloDTO();
		modeloDTO.setId(modelo.getId());
		modeloDTO.setNombre_modelo(modelo.getNombre_modelo());
		MarcaAssembler marcaAssemb = new MarcaAssembler();
		modeloDTO.setMarca(marcaAssemb.getMarcaDTO(modelo.getMarca()));
		return modeloDTO;
	}
	public static Modelo getModelo (ModeloDTO modeloDTO){
		Modelo modelo = new Modelo();
		modelo.setId(modeloDTO.getId());
		modelo.setNombre_modelo(modeloDTO.getNombre_modelo());
		MarcaAssembler marcaAssemb = new MarcaAssembler();
		modelo.setMarca(marcaAssemb.getMarca(modeloDTO.getMarca()));
		return modelo;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==ModeloDTO.class) {
				aux.add(getModelo((ModeloDTO) obj));
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
			if (obj.getClass()==Modelo.class) {
				auxDTO.add(getModeloDTO((Modelo) obj));
			}
		}
		return auxDTO;
	}

}