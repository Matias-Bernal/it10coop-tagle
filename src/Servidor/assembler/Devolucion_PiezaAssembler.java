package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import servidor.persistencia.dominio.Devolucion_Pieza;
import common.DTOs.Devolucion_PiezaDTO;

public class Devolucion_PiezaAssembler {

	public Devolucion_PiezaAssembler(){}
	
	public static Devolucion_PiezaDTO getDevolucion_PiezaDTO(Devolucion_Pieza devolucion_pieza) {
		Devolucion_PiezaDTO devolucion_piezaDTO = new Devolucion_PiezaDTO();
		devolucion_piezaDTO.setId(devolucion_pieza.getId());
		devolucion_piezaDTO.setFecha_devolucion(devolucion_pieza.getFecha_devolucion());
		devolucion_piezaDTO.setNumero_remito(devolucion_pieza.getNumero_remito());
		devolucion_piezaDTO.setTransporte(devolucion_pieza.getTransporte());
		return devolucion_piezaDTO;
	}
	public static Devolucion_Pieza getDevolucion_Pieza(Devolucion_PiezaDTO devolucion_piezaDTO) {
		Devolucion_Pieza devolucion_pieza = new Devolucion_Pieza();
		devolucion_pieza.setId(devolucion_piezaDTO.getId());
		devolucion_pieza.setFecha_devolucion(devolucion_piezaDTO.getFecha_devolucion());
		devolucion_pieza.setNumero_remito(devolucion_piezaDTO.getNumero_remito());
		devolucion_pieza.setTransporte(devolucion_piezaDTO.getTransporte());
		return devolucion_pieza;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==Devolucion_PiezaDTO.class) {
				aux.add(getDevolucion_Pieza((Devolucion_PiezaDTO) obj));
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
			if (obj.getClass()==Devolucion_Pieza.class) {
				auxDTO.add(getDevolucion_PiezaDTO((Devolucion_Pieza) obj));
			}
		}
		return auxDTO;
	}

}