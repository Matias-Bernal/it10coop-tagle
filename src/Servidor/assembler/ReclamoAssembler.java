package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import servidor.persistencia.dominio.Reclamo;
import common.DTOs.ReclamoDTO;

public class ReclamoAssembler {

	public ReclamoAssembler(){}
	
	public static ReclamoDTO getReclamoDTO(Reclamo reclamo) {
		ReclamoDTO reclamoDTO = new ReclamoDTO();
		reclamoDTO.setId(reclamo.getId());
		reclamoDTO.setEstado_reclamo(reclamo.getEstado_reclamo());
		reclamoDTO.setFecha_reclamo(reclamo.getFecha_reclamo());
		reclamoDTO.setFecha_turno(reclamo.getFecha_turno());
		reclamoDTO.setInmovilizado(reclamo.getInmovilizado());
		reclamoDTO.setPeligroso(reclamo.getPeligroso());
		ReclamanteAssembler reclamanteAssemb = new ReclamanteAssembler();
		reclamoDTO.setReclamante(reclamanteAssemb.getReclamanteDTO(reclamo.getReclamante()) );
		UsuarioAssembler usuarioAssemb = new UsuarioAssembler();
		reclamoDTO.setUsuario(usuarioAssemb.getUsuarioDTO(reclamo.getUsuario()));
		VehiculoAssembler vehiculoAssemb = new VehiculoAssembler();
		reclamoDTO.setVehiculo(vehiculoAssemb.getVehiculoDTO(reclamo.getVehiculo()));
		return reclamoDTO;
	}
	public static Reclamo getReclamo(ReclamoDTO reclamoDTO) {
		Reclamo reclamo = new Reclamo();
		reclamo.setId(reclamoDTO.getId());
		reclamo.setEstado_reclamo(reclamoDTO.getEstado_reclamo());
		reclamo.setFecha_reclamo(reclamoDTO.getFecha_reclamo());
		reclamo.setFecha_turno(reclamoDTO.getFecha_turno());
		reclamo.setInmovilizado(reclamoDTO.getInmovilizado());
		reclamo.setPeligroso(reclamoDTO.getPeligroso());
		ReclamanteAssembler reclamanteAssemb = new ReclamanteAssembler();
		reclamo.setReclamante(reclamanteAssemb.getReclamante(reclamoDTO.getReclamante()) );
		UsuarioAssembler usuarioAssemb = new UsuarioAssembler();
		reclamo.setUsuario(usuarioAssemb.getUsuario(reclamoDTO.getUsuario()));
		VehiculoAssembler vehiculoAssemb = new VehiculoAssembler();
		reclamo.setVehiculo(vehiculoAssemb.getVehiculo(reclamoDTO.getVehiculo()));
		return reclamo;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==ReclamoDTO.class) {
				aux.add(getReclamo((ReclamoDTO) obj));
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
			if (obj.getClass()==Reclamo.class) {
				auxDTO.add(getReclamoDTO((Reclamo) obj));
			}
		}
		return auxDTO;
	}

}