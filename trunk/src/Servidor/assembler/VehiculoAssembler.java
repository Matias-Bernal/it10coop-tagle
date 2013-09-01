package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Vehiculo;
import common.DTOs.VehiculoDTO;

public class VehiculoAssembler {

	public VehiculoAssembler(){}
	
	public static VehiculoDTO getVehiculoDTO (Vehiculo vehiculo ){
		VehiculoDTO vehiculoDTO = new VehiculoDTO();
		vehiculoDTO.setId(vehiculo.getId());
		vehiculoDTO.setDominio(vehiculo.getDominio());
		vehiculoDTO.setNombre_titular(vehiculo.getNombre_titular());
		vehiculoDTO.setVin(vehiculo.getVin());
		MarcaAssembler marcaAssemb = new MarcaAssembler();
		vehiculoDTO.setMarca(marcaAssemb.getMarcaDTO(vehiculo.getMarca()));
		ModeloAssembler modeloAssemb = new ModeloAssembler();
		vehiculoDTO.setModelo(modeloAssemb.getModeloDTO(vehiculo.getModelo()));
		return vehiculoDTO;
	}
	public static Vehiculo getVehiculo (VehiculoDTO vehiculoDTO ){
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setId(vehiculoDTO.getId());
		vehiculo.setDominio(vehiculoDTO.getDominio());
		vehiculo.setNombre_titular(vehiculoDTO.getNombre_titular());
		vehiculo.setVin(vehiculoDTO.getVin());
		MarcaAssembler marcaAssemb = new MarcaAssembler();
		vehiculo.setMarca(marcaAssemb.getMarca(vehiculoDTO.getMarca()));
		ModeloAssembler modeloAssemb = new ModeloAssembler();
		vehiculo.setModelo(modeloAssemb.getModelo(vehiculoDTO.getModelo()));
		return vehiculo;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==VehiculoDTO.class) {
				aux.add(getVehiculo((VehiculoDTO) obj));
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
			if (obj.getClass()==Vehiculo.class) {
				auxDTO.add(getVehiculoDTO((Vehiculo) obj));
			}
		}
		return auxDTO;
	}

}