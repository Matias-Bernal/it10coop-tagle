package servidor.assembler;

import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Reclamo;

import common.DTOs.ReclamoDTO;

public class ReclamoAssembler {
	
	private AccesoBD accesoBD;

	public ReclamoAssembler(AccesoBD accesoBD) {
		this.accesoBD = accesoBD;
	}

	public ReclamoDTO getReclamoDTO(Reclamo reclamo) {
		ReclamoDTO reclamoDTO = new ReclamoDTO();
		reclamoDTO.setId(reclamo.getId());
		reclamoDTO.setEstado_reclamo(reclamo.getEstado_reclamo());
		reclamoDTO.setFecha_reclamo(reclamo.getFecha_reclamo());
		reclamoDTO.setFecha_turno(reclamo.getFecha_turno());
		reclamoDTO.setInmovilizado(reclamo.getInmovilizado());
		reclamoDTO.setPeligroso(reclamo.getPeligroso());
		reclamoDTO.setdescripcion(reclamo.getDescripcion());
		ReclamanteAssembler reclamanteAssemb = new ReclamanteAssembler(accesoBD);
		reclamoDTO.setReclamante(reclamanteAssemb.getReclamanteDTO(reclamo.getReclamante()));
		UsuarioAssembler usuarioAssemb = new UsuarioAssembler(accesoBD);
		reclamoDTO.setUsuario(usuarioAssemb.getUsuarioDTO(reclamo.getUsuario()));
		VehiculoAssembler vehiculoAssemb = new VehiculoAssembler(accesoBD);
		reclamoDTO.setVehiculo(vehiculoAssemb.getVehiculoDTO(reclamo.getVehiculo()));
		OrdenAssembler ordenAssemb = new OrdenAssembler(accesoBD);
		reclamoDTO.setOrden(ordenAssemb.getOrdenDTO(reclamo.getOrden()));
		return reclamoDTO;
	}

	public Reclamo getReclamo(ReclamoDTO reclamoDTO) {
		Reclamo reclamo = (Reclamo) accesoBD.buscarPorId(Reclamo.class, reclamoDTO.getId());
		reclamo.setId(reclamoDTO.getId());
		reclamo.setEstado_reclamo(reclamoDTO.getEstado_reclamo());
		reclamo.setFecha_reclamo(reclamoDTO.getFecha_reclamo());
		reclamo.setFecha_turno(reclamoDTO.getFecha_turno());
		reclamo.setInmovilizado(reclamoDTO.getInmovilizado());
		reclamo.setPeligroso(reclamoDTO.getPeligroso());
		reclamo.setdescripcion(reclamoDTO.getDescripcion());
		ReclamanteAssembler reclamanteAssemb = new ReclamanteAssembler(accesoBD);
		reclamo.setReclamante(reclamanteAssemb.getReclamante(reclamoDTO.getReclamante()));
		UsuarioAssembler usuarioAssemb = new UsuarioAssembler(accesoBD);
		reclamo.setUsuario(usuarioAssemb.getUsuario(reclamoDTO.getUsuario()));
		VehiculoAssembler vehiculoAssemb = new VehiculoAssembler(accesoBD);
		reclamo.setVehiculo(vehiculoAssemb.getVehiculo(reclamoDTO.getVehiculo()));
		OrdenAssembler ordenAssemb = new OrdenAssembler(accesoBD);
		reclamo.setOrden(ordenAssemb.getOrden(reclamoDTO.getOrden()));
		return reclamo;
	}
	
	public Reclamo getReclamoNuevo(ReclamoDTO reclamoDTO) {
		Reclamo reclamo = new Reclamo();
		reclamo.setId(reclamoDTO.getId());
		reclamo.setEstado_reclamo(reclamoDTO.getEstado_reclamo());
		reclamo.setFecha_reclamo(reclamoDTO.getFecha_reclamo());
		reclamo.setFecha_turno(reclamoDTO.getFecha_turno());
		reclamo.setInmovilizado(reclamoDTO.getInmovilizado());
		reclamo.setPeligroso(reclamoDTO.getPeligroso());
		reclamo.setdescripcion(reclamoDTO.getDescripcion());
		ReclamanteAssembler reclamanteAssemb = new ReclamanteAssembler(accesoBD);
		reclamo.setReclamante(reclamanteAssemb.getReclamante(reclamoDTO.getReclamante()));
		UsuarioAssembler usuarioAssemb = new UsuarioAssembler(accesoBD);
		reclamo.setUsuario(usuarioAssemb.getUsuario(reclamoDTO.getUsuario()));
		VehiculoAssembler vehiculoAssemb = new VehiculoAssembler(accesoBD);
		reclamo.setVehiculo(vehiculoAssemb.getVehiculo(reclamoDTO.getVehiculo()));
		OrdenAssembler ordenAssemb = new OrdenAssembler(accesoBD);
		reclamo.setOrden(ordenAssemb.getOrden(reclamoDTO.getOrden()));
		return reclamo;
	}

}