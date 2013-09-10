package servidor.GestionarReclamante_Reclamo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.ReclamanteAssembler;
import servidor.assembler.Reclamante_ReclamoAssembler;
import servidor.assembler.ReclamoAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Reclamante_Reclamo;

import common.DTOs.ReclamanteDTO;
import common.DTOs.Reclamante_ReclamoDTO;
import common.DTOs.ReclamoDTO;
import common.GestionarReclamante_Reclamo.IControlReclamante_Reclamo;

public class ControlReclamante_Reclamo extends UnicastRemoteObject implements IControlReclamante_Reclamo{

	private static final long serialVersionUID = 1L;

	protected ControlReclamante_Reclamo() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarReclamante_Reclamo(Reclamante_ReclamoDTO reclamante_ReclamoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Reclamante_Reclamo reclamante_Reclamo = Reclamante_ReclamoAssembler.getReclamante_Reclamo(reclamante_ReclamoDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(reclamante_Reclamo);
			id=reclamante_Reclamo.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarReclamante_Reclamo(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Reclamante_Reclamo reclamante_Reclamo = Reclamante_ReclamoAssembler.getReclamante_Reclamo(buscarReclamante_Reclamo(id));
			accesoBD.eliminar(reclamante_Reclamo);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public void modificarReclamante_Reclamo(Long id,Reclamante_ReclamoDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Reclamante_Reclamo reclamante_Reclamo = Reclamante_ReclamoAssembler.getReclamante_Reclamo(buscarReclamante_Reclamo(id));
			
			reclamante_Reclamo.setReclamante(ReclamanteAssembler.getReclamante(modificado.getReclamante()));
			reclamante_Reclamo.setReclamo(ReclamoAssembler.getReclamo(modificado.getReclamo()));
			
			accesoBD.hacerPersistente(reclamante_Reclamo);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<Reclamante_ReclamoDTO> obtenerReclamante_Reclamos() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Reclamante_ReclamoDTO> reclamantes_ReclamosDTO = new Vector<Reclamante_ReclamoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Reclamante_Reclamo> reclamantes_Reclamos = (Vector<Reclamante_Reclamo>) accesoBD.buscarPorFiltro(Reclamante_Reclamo.class,"id ascending");
			for(int i=0; i<reclamantes_Reclamos.size();i++){
				Reclamante_ReclamoDTO reclamante_ReclamoDTO = new Reclamante_ReclamoDTO();
				
				reclamante_ReclamoDTO.setId(reclamantes_Reclamos.elementAt(i).getId());
				reclamante_ReclamoDTO.setReclamante(ReclamanteAssembler.getReclamanteDTO(reclamantes_Reclamos.elementAt(i).getReclamante()));
				reclamante_ReclamoDTO.setReclamo(ReclamoAssembler.getReclamoDTO(reclamantes_Reclamos.elementAt(i).getReclamo()));
				
				reclamantes_ReclamosDTO.add(reclamante_ReclamoDTO);
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return reclamantes_ReclamosDTO;
	}

	@Override
	public Vector<Reclamante_ReclamoDTO> obtenerReclamante_Reclamos(ReclamoDTO reclamoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Reclamante_ReclamoDTO> reclamantes_ReclamosDTO = new Vector<Reclamante_ReclamoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Reclamante_Reclamo> reclamantes_Reclamos = (Vector<Reclamante_Reclamo>) accesoBD.buscarPorFiltro(Reclamante_Reclamo.class,"id ascending");
			for(int i=0; i<reclamantes_Reclamos.size();i++){
				if (reclamantes_Reclamos.elementAt(i).getReclamo().getId().equals(reclamoDTO.getId())){
					Reclamante_ReclamoDTO reclamante_ReclamoDTO = new Reclamante_ReclamoDTO();
					
					reclamante_ReclamoDTO.setId(reclamantes_Reclamos.elementAt(i).getId());
					reclamante_ReclamoDTO.setReclamante(ReclamanteAssembler.getReclamanteDTO(reclamantes_Reclamos.elementAt(i).getReclamante()));
					reclamante_ReclamoDTO.setReclamo(ReclamoAssembler.getReclamoDTO(reclamantes_Reclamos.elementAt(i).getReclamo()));
					
					reclamantes_ReclamosDTO.add(reclamante_ReclamoDTO);
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return reclamantes_ReclamosDTO;
	}

	@Override
	public boolean existeReclamante_Reclamo(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Reclamante_Reclamo) accesoBD.buscarPorId(Reclamante_Reclamo.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existeReclamante_Reclamo(ReclamanteDTO reclamanteDTO, ReclamoDTO reclamoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Reclamante_ReclamoDTO> reclamantes_ReclamoDTO = obtenerReclamante_Reclamos();
			for(int i=0; i<reclamantes_ReclamoDTO.size();i++){
				if (reclamantes_ReclamoDTO.elementAt(i).getReclamante().getId().equals(reclamanteDTO.getId()) && reclamantes_ReclamoDTO.elementAt(i).getReclamo().getId().equals(reclamoDTO.getId())){
					existe = true;
					break;
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public Reclamante_ReclamoDTO buscarReclamante_Reclamo(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Reclamante_ReclamoDTO reclamante_ReclamoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			reclamante_ReclamoDTO = Reclamante_ReclamoAssembler.getReclamante_ReclamoDTO((Reclamante_Reclamo) accesoBD.buscarPorId(Reclamante_Reclamo.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return reclamante_ReclamoDTO;
	}

	@Override
	public Reclamante_ReclamoDTO buscarReclamante_Reclamo(ReclamanteDTO reclamanteDTO, ReclamoDTO reclamoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Reclamante_ReclamoDTO reclamante_ReclamoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Reclamante_ReclamoDTO> reclamantes_ReclamoDTO = obtenerReclamante_Reclamos();
			for(int i=0; i<reclamantes_ReclamoDTO.size();i++){
				if (reclamantes_ReclamoDTO.elementAt(i).getReclamante().getId().equals(reclamanteDTO.getId()) && reclamantes_ReclamoDTO.elementAt(i).getReclamo().getId().equals(reclamoDTO.getId())){
					reclamante_ReclamoDTO = reclamantes_ReclamoDTO.elementAt(i);
					break;
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return reclamante_ReclamoDTO;
	}

}