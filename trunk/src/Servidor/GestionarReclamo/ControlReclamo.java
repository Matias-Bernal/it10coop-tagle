package servidor.GestionarReclamo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.Vector;

import servidor.assembler.ReclamanteAssembler;
import servidor.assembler.ReclamoAssembler;
import servidor.assembler.RegistranteAssembler;
import servidor.assembler.UsuarioAssembler;
import servidor.assembler.VehiculoAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Reclamo;

import common.DTOs.ReclamanteDTO;
import common.DTOs.ReclamoDTO;
import common.DTOs.VehiculoDTO;
import common.GestionarReclamo.IControlReclamo;

public class ControlReclamo extends UnicastRemoteObject implements
		IControlReclamo {

	private static final long serialVersionUID = 1L;

	protected ControlReclamo() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
<<<<<<< .mine
	public Long agregarReclamo(ReclamoDTO reclamoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Reclamo reclamo = ReclamoAssembler.getReclamo(reclamoDTO);
		Long id = new Long(0);
		try {
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(reclamo);
			id = reclamo.getId();
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return id;
=======
	public Long agregarReclamo(ReclamoDTO reclamoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Reclamo reclamo = ReclamoAssembler.getReclamo(reclamoDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(reclamo);
			id=reclamo.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
>>>>>>> .r18
	}

	@Override
	public void eliminarReclamo(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Reclamo reclamo = ReclamoAssembler.getReclamo(buscarReclamo(id));
			accesoBD.eliminar(reclamo);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
=======
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Reclamo reclamo = ReclamoAssembler.getReclamo(buscarReclamo(id));
			accesoBD.eliminar(reclamo);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public void modificarReclamo(Long id, ReclamoDTO modificado)
			throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Reclamo reclamo = ReclamoAssembler.getReclamo(buscarReclamo(id));

			reclamo.setdescripcion(modificado.getDescripcion());
			reclamo.setEstado_reclamo(modificado.getEstado_reclamo());
			reclamo.setFecha_reclamo(modificado.getFecha_reclamo());
			reclamo.setFecha_turno(modificado.getFecha_turno());
			reclamo.setInmovilizado(modificado.getInmovilizado());
			reclamo.setPeligroso(modificado.getPeligroso());
			reclamo.setReclamante(ReclamanteAssembler.getReclamante(modificado
					.getReclamante()));
			reclamo.setRegistrante(RegistranteAssembler
					.getRegistrante(modificado.getRegistrante()));
			reclamo.setUsuario(UsuarioAssembler.getUsuario(modificado
					.getUsuario()));
			reclamo.setVehiculo(VehiculoAssembler.getVehiculo(modificado
					.getVehiculo()));

			accesoBD.hacerPersistente(reclamo);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}

=======
	public void modificarReclamo(Long id, ReclamoDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Reclamo reclamo = ReclamoAssembler.getReclamo(buscarReclamo(id));
			
			reclamo.setdescripcion(modificado.getDescripcion());
			reclamo.setEstado_reclamo(modificado.getEstado_reclamo());
			reclamo.setFecha_reclamo(modificado.getFecha_reclamo());
			reclamo.setFecha_turno(modificado.getFecha_turno());
			reclamo.setInmovilizado(modificado.getInmovilizado());
			reclamo.setPeligroso(modificado.getPeligroso());
			reclamo.setReclamante(ReclamanteAssembler.getReclamante(modificado.getReclamante()));
			reclamo.setRegistrante(RegistranteAssembler.getRegistrante(modificado.getRegistrante()));
			reclamo.setUsuario(UsuarioAssembler.getUsuario(modificado.getUsuario()));
			reclamo.setVehiculo(VehiculoAssembler.getVehiculo(modificado.getVehiculo()));
			
			accesoBD.hacerPersistente(reclamo);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		
>>>>>>> .r18
	}

	@Override
	public Vector<ReclamoDTO> obtenerReclamos() throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		Vector<ReclamoDTO> reclamosDTO = new Vector<ReclamoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Reclamo> reclamos = (Vector<Reclamo>) accesoBD
					.buscarPorFiltro(Reclamo.class, "id ascending");
			for (int i = 0; i < reclamos.size(); i++) {
				ReclamoDTO reclamoDTO = new ReclamoDTO();

				reclamoDTO.setId(reclamos.elementAt(i).getId());
				reclamoDTO.setdescripcion(reclamos.elementAt(i)
						.getDescripcion());
				reclamoDTO.setEstado_reclamo(reclamos.elementAt(i)
						.getEstado_reclamo());
				reclamoDTO.setFecha_reclamo(reclamos.elementAt(i)
						.getFecha_reclamo());
				reclamoDTO.setFecha_turno(reclamos.elementAt(i)
						.getFecha_turno());
				reclamoDTO.setInmovilizado(reclamos.elementAt(i)
						.getInmovilizado());
				reclamoDTO.setPeligroso(reclamos.elementAt(i).getPeligroso());
				reclamoDTO
						.setReclamante(ReclamanteAssembler
								.getReclamanteDTO(reclamos.elementAt(i)
										.getReclamante()));
				reclamoDTO.setRegistrante(RegistranteAssembler
						.getRegistranteDTO(reclamos.elementAt(i)
								.getRegistrante()));
				reclamoDTO.setUsuario(UsuarioAssembler.getUsuarioDTO(reclamos
						.elementAt(i).getUsuario()));
				reclamoDTO.setVehiculo(VehiculoAssembler
						.getVehiculoDTO(reclamos.elementAt(i).getVehiculo()));

				reclamosDTO.add(reclamoDTO);
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return reclamosDTO;
=======
		AccesoBD accesoBD = new AccesoBD();
		Vector<ReclamoDTO> reclamosDTO = new Vector<ReclamoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Reclamo> reclamos = (Vector<Reclamo>) accesoBD.buscarPorFiltro(Reclamo.class,"id ascending");
			for(int i=0; i<reclamos.size();i++){
				ReclamoDTO reclamoDTO = new ReclamoDTO();
				
				reclamoDTO.setId(reclamos.elementAt(i).getId());
				reclamoDTO.setdescripcion(reclamos.elementAt(i).getDescripcion());
				reclamoDTO.setEstado_reclamo(reclamos.elementAt(i).getEstado_reclamo());
				reclamoDTO.setFecha_reclamo(reclamos.elementAt(i).getFecha_reclamo());
				reclamoDTO.setFecha_turno(reclamos.elementAt(i).getFecha_turno());
				reclamoDTO.setInmovilizado(reclamos.elementAt(i).getInmovilizado());
				reclamoDTO.setPeligroso(reclamos.elementAt(i).getPeligroso());
				reclamoDTO.setReclamante(ReclamanteAssembler.getReclamanteDTO(reclamos.elementAt(i).getReclamante()));
				reclamoDTO.setRegistrante(RegistranteAssembler.getRegistranteDTO(reclamos.elementAt(i).getRegistrante()));
				reclamoDTO.setUsuario(UsuarioAssembler.getUsuarioDTO(reclamos.elementAt(i).getUsuario()));
				reclamoDTO.setVehiculo(VehiculoAssembler.getVehiculoDTO(reclamos.elementAt(i).getVehiculo()));
				
				reclamosDTO.add(reclamoDTO);
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return reclamosDTO;
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Vector<ReclamoDTO> obtenerReclamos(Date fecha_reclamo)
			throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<ReclamoDTO> reclamosDTO = new Vector<ReclamoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Reclamo> reclamos = (Vector<Reclamo>) accesoBD
					.buscarPorFiltro(Reclamo.class, "id ascending");
			for (int i = 0; i < reclamos.size(); i++) {

				if (reclamos.elementAt(i).getFecha_reclamo()
						.equals(fecha_reclamo)) {
					ReclamoDTO reclamoDTO = new ReclamoDTO();

					reclamoDTO.setId(reclamos.elementAt(i).getId());
					reclamoDTO.setdescripcion(reclamos.elementAt(i)
							.getDescripcion());
					reclamoDTO.setEstado_reclamo(reclamos.elementAt(i)
							.getEstado_reclamo());
					reclamoDTO.setFecha_reclamo(reclamos.elementAt(i)
							.getFecha_reclamo());
					reclamoDTO.setFecha_turno(reclamos.elementAt(i)
							.getFecha_turno());
					reclamoDTO.setInmovilizado(reclamos.elementAt(i)
							.getInmovilizado());
					reclamoDTO.setPeligroso(reclamos.elementAt(i)
							.getPeligroso());
					reclamoDTO.setReclamante(ReclamanteAssembler
							.getReclamanteDTO(reclamos.elementAt(i)
									.getReclamante()));
					reclamoDTO.setRegistrante(RegistranteAssembler
							.getRegistranteDTO(reclamos.elementAt(i)
									.getRegistrante()));
					reclamoDTO.setUsuario(UsuarioAssembler
							.getUsuarioDTO(reclamos.elementAt(i).getUsuario()));
					reclamoDTO
							.setVehiculo(VehiculoAssembler
									.getVehiculoDTO(reclamos.elementAt(i)
											.getVehiculo()));

					reclamosDTO.add(reclamoDTO);
				}
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return reclamosDTO;
=======
	public Vector<ReclamoDTO> obtenerReclamos(Date fecha_reclamo) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<ReclamoDTO> reclamosDTO = new Vector<ReclamoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Reclamo> reclamos = (Vector<Reclamo>) accesoBD.buscarPorFiltro(Reclamo.class,"id ascending");
			for(int i=0; i<reclamos.size();i++){
				
				if(reclamos.elementAt(i).getFecha_reclamo().equals(fecha_reclamo)){
					ReclamoDTO reclamoDTO = new ReclamoDTO();
					
					reclamoDTO.setId(reclamos.elementAt(i).getId());
					reclamoDTO.setdescripcion(reclamos.elementAt(i).getDescripcion());
					reclamoDTO.setEstado_reclamo(reclamos.elementAt(i).getEstado_reclamo());
					reclamoDTO.setFecha_reclamo(reclamos.elementAt(i).getFecha_reclamo());
					reclamoDTO.setFecha_turno(reclamos.elementAt(i).getFecha_turno());
					reclamoDTO.setInmovilizado(reclamos.elementAt(i).getInmovilizado());
					reclamoDTO.setPeligroso(reclamos.elementAt(i).getPeligroso());
					reclamoDTO.setReclamante(ReclamanteAssembler.getReclamanteDTO(reclamos.elementAt(i).getReclamante()));
					reclamoDTO.setRegistrante(RegistranteAssembler.getRegistranteDTO(reclamos.elementAt(i).getRegistrante()));
					reclamoDTO.setUsuario(UsuarioAssembler.getUsuarioDTO(reclamos.elementAt(i).getUsuario()));
					reclamoDTO.setVehiculo(VehiculoAssembler.getVehiculoDTO(reclamos.elementAt(i).getVehiculo()));
					
					reclamosDTO.add(reclamoDTO);
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return reclamosDTO;
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Vector<ReclamoDTO> obtenerReclamos(String estado_reclamo)
			throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<ReclamoDTO> reclamosDTO = new Vector<ReclamoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Reclamo> reclamos = (Vector<Reclamo>) accesoBD
					.buscarPorFiltro(Reclamo.class, "id ascending");
			for (int i = 0; i < reclamos.size(); i++) {

				if (reclamos.elementAt(i).getEstado_reclamo()
						.equals(estado_reclamo)) {
					ReclamoDTO reclamoDTO = new ReclamoDTO();

					reclamoDTO.setId(reclamos.elementAt(i).getId());
					reclamoDTO.setdescripcion(reclamos.elementAt(i)
							.getDescripcion());
					reclamoDTO.setEstado_reclamo(reclamos.elementAt(i)
							.getEstado_reclamo());
					reclamoDTO.setFecha_reclamo(reclamos.elementAt(i)
							.getFecha_reclamo());
					reclamoDTO.setFecha_turno(reclamos.elementAt(i)
							.getFecha_turno());
					reclamoDTO.setInmovilizado(reclamos.elementAt(i)
							.getInmovilizado());
					reclamoDTO.setPeligroso(reclamos.elementAt(i)
							.getPeligroso());
					reclamoDTO.setReclamante(ReclamanteAssembler
							.getReclamanteDTO(reclamos.elementAt(i)
									.getReclamante()));
					reclamoDTO.setRegistrante(RegistranteAssembler
							.getRegistranteDTO(reclamos.elementAt(i)
									.getRegistrante()));
					reclamoDTO.setUsuario(UsuarioAssembler
							.getUsuarioDTO(reclamos.elementAt(i).getUsuario()));
					reclamoDTO
							.setVehiculo(VehiculoAssembler
									.getVehiculoDTO(reclamos.elementAt(i)
											.getVehiculo()));

					reclamosDTO.add(reclamoDTO);
				}
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return reclamosDTO;
=======
	public Vector<ReclamoDTO> obtenerReclamos(String estado_reclamo) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<ReclamoDTO> reclamosDTO = new Vector<ReclamoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Reclamo> reclamos = (Vector<Reclamo>) accesoBD.buscarPorFiltro(Reclamo.class,"id ascending");
			for(int i=0; i<reclamos.size();i++){
				
				if(reclamos.elementAt(i).getEstado_reclamo().equals(estado_reclamo)){
					ReclamoDTO reclamoDTO = new ReclamoDTO();
					
					reclamoDTO.setId(reclamos.elementAt(i).getId());
					reclamoDTO.setdescripcion(reclamos.elementAt(i).getDescripcion());
					reclamoDTO.setEstado_reclamo(reclamos.elementAt(i).getEstado_reclamo());
					reclamoDTO.setFecha_reclamo(reclamos.elementAt(i).getFecha_reclamo());
					reclamoDTO.setFecha_turno(reclamos.elementAt(i).getFecha_turno());
					reclamoDTO.setInmovilizado(reclamos.elementAt(i).getInmovilizado());
					reclamoDTO.setPeligroso(reclamos.elementAt(i).getPeligroso());
					reclamoDTO.setReclamante(ReclamanteAssembler.getReclamanteDTO(reclamos.elementAt(i).getReclamante()));
					reclamoDTO.setRegistrante(RegistranteAssembler.getRegistranteDTO(reclamos.elementAt(i).getRegistrante()));
					reclamoDTO.setUsuario(UsuarioAssembler.getUsuarioDTO(reclamos.elementAt(i).getUsuario()));
					reclamoDTO.setVehiculo(VehiculoAssembler.getVehiculoDTO(reclamos.elementAt(i).getVehiculo()));
					
					reclamosDTO.add(reclamoDTO);
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return reclamosDTO;
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Vector<ReclamoDTO> obtenerReclamos(ReclamanteDTO reclamanteDTO)
			throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<ReclamoDTO> reclamosDTO = new Vector<ReclamoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Reclamo> reclamos = (Vector<Reclamo>) accesoBD
					.buscarPorFiltro(Reclamo.class, "id ascending");
			for (int i = 0; i < reclamos.size(); i++) {

				if (reclamos.elementAt(i).getReclamante().getId()
						.equals(reclamanteDTO.getId())) {
					ReclamoDTO reclamoDTO = new ReclamoDTO();

					reclamoDTO.setId(reclamos.elementAt(i).getId());
					reclamoDTO.setdescripcion(reclamos.elementAt(i)
							.getDescripcion());
					reclamoDTO.setEstado_reclamo(reclamos.elementAt(i)
							.getEstado_reclamo());
					reclamoDTO.setFecha_reclamo(reclamos.elementAt(i)
							.getFecha_reclamo());
					reclamoDTO.setFecha_turno(reclamos.elementAt(i)
							.getFecha_turno());
					reclamoDTO.setInmovilizado(reclamos.elementAt(i)
							.getInmovilizado());
					reclamoDTO.setPeligroso(reclamos.elementAt(i)
							.getPeligroso());
					reclamoDTO.setReclamante(ReclamanteAssembler
							.getReclamanteDTO(reclamos.elementAt(i)
									.getReclamante()));
					reclamoDTO.setRegistrante(RegistranteAssembler
							.getRegistranteDTO(reclamos.elementAt(i)
									.getRegistrante()));
					reclamoDTO.setUsuario(UsuarioAssembler
							.getUsuarioDTO(reclamos.elementAt(i).getUsuario()));
					reclamoDTO
							.setVehiculo(VehiculoAssembler
									.getVehiculoDTO(reclamos.elementAt(i)
											.getVehiculo()));

					reclamosDTO.add(reclamoDTO);
				}
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return reclamosDTO;
=======
	public Vector<ReclamoDTO> obtenerReclamos(ReclamanteDTO reclamanteDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<ReclamoDTO> reclamosDTO = new Vector<ReclamoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Reclamo> reclamos = (Vector<Reclamo>) accesoBD.buscarPorFiltro(Reclamo.class,"id ascending");
			for(int i=0; i<reclamos.size();i++){
				
				if(reclamos.elementAt(i).getReclamante().getId().equals(reclamanteDTO.getId())){
					ReclamoDTO reclamoDTO = new ReclamoDTO();
					
					reclamoDTO.setId(reclamos.elementAt(i).getId());
					reclamoDTO.setdescripcion(reclamos.elementAt(i).getDescripcion());
					reclamoDTO.setEstado_reclamo(reclamos.elementAt(i).getEstado_reclamo());
					reclamoDTO.setFecha_reclamo(reclamos.elementAt(i).getFecha_reclamo());
					reclamoDTO.setFecha_turno(reclamos.elementAt(i).getFecha_turno());
					reclamoDTO.setInmovilizado(reclamos.elementAt(i).getInmovilizado());
					reclamoDTO.setPeligroso(reclamos.elementAt(i).getPeligroso());
					reclamoDTO.setReclamante(ReclamanteAssembler.getReclamanteDTO(reclamos.elementAt(i).getReclamante()));
					reclamoDTO.setRegistrante(RegistranteAssembler.getRegistranteDTO(reclamos.elementAt(i).getRegistrante()));
					reclamoDTO.setUsuario(UsuarioAssembler.getUsuarioDTO(reclamos.elementAt(i).getUsuario()));
					reclamoDTO.setVehiculo(VehiculoAssembler.getVehiculoDTO(reclamos.elementAt(i).getVehiculo()));
					
					reclamosDTO.add(reclamoDTO);
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return reclamosDTO;
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Vector<ReclamoDTO> obtenerReclamos(VehiculoDTO vehiculoDTO)
			throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<ReclamoDTO> reclamosDTO = new Vector<ReclamoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Reclamo> reclamos = (Vector<Reclamo>) accesoBD
					.buscarPorFiltro(Reclamo.class, "id ascending");
			for (int i = 0; i < reclamos.size(); i++) {

				if (reclamos.elementAt(i).getVehiculo().getId()
						.equals(vehiculoDTO.getId())) {
					ReclamoDTO reclamoDTO = new ReclamoDTO();

					reclamoDTO.setId(reclamos.elementAt(i).getId());
					reclamoDTO.setdescripcion(reclamos.elementAt(i)
							.getDescripcion());
					reclamoDTO.setEstado_reclamo(reclamos.elementAt(i)
							.getEstado_reclamo());
					reclamoDTO.setFecha_reclamo(reclamos.elementAt(i)
							.getFecha_reclamo());
					reclamoDTO.setFecha_turno(reclamos.elementAt(i)
							.getFecha_turno());
					reclamoDTO.setInmovilizado(reclamos.elementAt(i)
							.getInmovilizado());
					reclamoDTO.setPeligroso(reclamos.elementAt(i)
							.getPeligroso());
					reclamoDTO.setReclamante(ReclamanteAssembler
							.getReclamanteDTO(reclamos.elementAt(i)
									.getReclamante()));
					reclamoDTO.setRegistrante(RegistranteAssembler
							.getRegistranteDTO(reclamos.elementAt(i)
									.getRegistrante()));
					reclamoDTO.setUsuario(UsuarioAssembler
							.getUsuarioDTO(reclamos.elementAt(i).getUsuario()));
					reclamoDTO
							.setVehiculo(VehiculoAssembler
									.getVehiculoDTO(reclamos.elementAt(i)
											.getVehiculo()));

					reclamosDTO.add(reclamoDTO);
				}
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return reclamosDTO;
=======
	public Vector<ReclamoDTO> obtenerReclamos(VehiculoDTO vehiculoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<ReclamoDTO> reclamosDTO = new Vector<ReclamoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Reclamo> reclamos = (Vector<Reclamo>) accesoBD.buscarPorFiltro(Reclamo.class,"id ascending");
			for(int i=0; i<reclamos.size();i++){
				
				if(reclamos.elementAt(i).getVehiculo().getId().equals(vehiculoDTO.getId())){
					ReclamoDTO reclamoDTO = new ReclamoDTO();
					
					reclamoDTO.setId(reclamos.elementAt(i).getId());
					reclamoDTO.setdescripcion(reclamos.elementAt(i).getDescripcion());
					reclamoDTO.setEstado_reclamo(reclamos.elementAt(i).getEstado_reclamo());
					reclamoDTO.setFecha_reclamo(reclamos.elementAt(i).getFecha_reclamo());
					reclamoDTO.setFecha_turno(reclamos.elementAt(i).getFecha_turno());
					reclamoDTO.setInmovilizado(reclamos.elementAt(i).getInmovilizado());
					reclamoDTO.setPeligroso(reclamos.elementAt(i).getPeligroso());
					reclamoDTO.setReclamante(ReclamanteAssembler.getReclamanteDTO(reclamos.elementAt(i).getReclamante()));
					reclamoDTO.setRegistrante(RegistranteAssembler.getRegistranteDTO(reclamos.elementAt(i).getRegistrante()));
					reclamoDTO.setUsuario(UsuarioAssembler.getUsuarioDTO(reclamos.elementAt(i).getUsuario()));
					reclamoDTO.setVehiculo(VehiculoAssembler.getVehiculoDTO(reclamos.elementAt(i).getVehiculo()));
					
					reclamosDTO.add(reclamoDTO);
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return reclamosDTO;
>>>>>>> .r18
	}

	@Override
	public boolean existeReclamo(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Reclamo) accesoBD.buscarPorId(Reclamo.class, id) == null);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return existe;
=======
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Reclamo) accesoBD.buscarPorId(Reclamo.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public boolean existeReclamo(Date fecha_reclamo,
			ReclamanteDTO reclamanteDTO, VehiculoDTO vehiculoDTO)
			throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<ReclamoDTO> reclamosDTO = obtenerReclamos();
			for (int i = 0; i < reclamosDTO.size(); i++) {
				if (reclamosDTO.elementAt(i).getFecha_reclamo()
						.equals(fecha_reclamo)
						&& reclamosDTO.elementAt(i).getReclamante().getId()
								.equals(reclamanteDTO.getId())
						&& reclamosDTO.elementAt(i).getVehiculo().getId()
								.equals(vehiculoDTO.getId())) {
					existe = true;
					break;
				}
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return existe;
=======
	public boolean existeReclamo(Date fecha_reclamo, ReclamanteDTO reclamanteDTO, VehiculoDTO vehiculoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<ReclamoDTO> reclamosDTO = obtenerReclamos();
			for(int i=0; i<reclamosDTO.size();i++){
				if (reclamosDTO.elementAt(i).getFecha_reclamo().equals(fecha_reclamo) && reclamosDTO.elementAt(i).getReclamante().getId().equals(reclamanteDTO.getId()) && reclamosDTO.elementAt(i).getVehiculo().getId().equals(vehiculoDTO.getId()) ){
					existe = true;
					break;
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
>>>>>>> .r18
	}

	@Override
	public ReclamoDTO buscarReclamo(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		ReclamoDTO reclamoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			reclamoDTO = ReclamoAssembler.getReclamoDTO((Reclamo) accesoBD
					.buscarPorId(Reclamo.class, id));
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return reclamoDTO;
=======
		AccesoBD accesoBD = new AccesoBD();
		ReclamoDTO reclamoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			reclamoDTO = ReclamoAssembler.getReclamoDTO((Reclamo) accesoBD.buscarPorId(Reclamo.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return reclamoDTO;
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public ReclamoDTO buscarReclamo(Date fecha_reclamo,
			ReclamanteDTO reclamanteDTO, VehiculoDTO vehiculoDTO)
			throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		ReclamoDTO reclamoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<ReclamoDTO> reclamosDTO = obtenerReclamos();
			for (int i = 0; i < reclamosDTO.size(); i++) {
				if (reclamosDTO.elementAt(i).getFecha_reclamo()
						.equals(fecha_reclamo)
						&& reclamosDTO.elementAt(i).getReclamante().getId()
								.equals(reclamanteDTO.getId())
						&& reclamosDTO.elementAt(i).getVehiculo().getId()
								.equals(vehiculoDTO.getId())) {
					reclamoDTO = reclamosDTO.elementAt(i);
					break;
				}
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return reclamoDTO;
=======
	public ReclamoDTO buscarReclamo(Date fecha_reclamo,ReclamanteDTO reclamanteDTO, VehiculoDTO vehiculoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		ReclamoDTO reclamoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<ReclamoDTO> reclamosDTO = obtenerReclamos();
			for(int i=0; i<reclamosDTO.size();i++){
				if (reclamosDTO.elementAt(i).getFecha_reclamo().equals(fecha_reclamo) && reclamosDTO.elementAt(i).getReclamante().getId().equals(reclamanteDTO.getId()) && reclamosDTO.elementAt(i).getVehiculo().getId().equals(vehiculoDTO.getId()) ){
					reclamoDTO = reclamosDTO.elementAt(i);
					break;
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return reclamoDTO;
>>>>>>> .r18
	}

}