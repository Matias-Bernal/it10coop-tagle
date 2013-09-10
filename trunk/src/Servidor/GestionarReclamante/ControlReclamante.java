package servidor.GestionarReclamante;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.ReclamanteAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Reclamante;

import common.DTOs.ReclamanteDTO;
import common.GestionarReclamante.IControlReclamante;

public class ControlReclamante extends UnicastRemoteObject implements IControlReclamante{

	private static final long serialVersionUID = 1L;

	protected ControlReclamante() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarReclamante(ReclamanteDTO reclamanteDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Reclamante reclamante = ReclamanteAssembler.getReclamante(reclamanteDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(reclamante);
			id=reclamante.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarReclamante(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Reclamante reclamante = ReclamanteAssembler.getReclamante(buscarReclamante(id));
			accesoBD.eliminar(reclamante);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public void modificarReclamante(Long id, ReclamanteDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Reclamante reclamante = ReclamanteAssembler.getReclamante(buscarReclamante(id));
			
			reclamante.setEmail(modificado.getEmail());
			reclamante.setNombre_apellido(modificado.getNombre_apellido());
			
			accesoBD.hacerPersistente(reclamante);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<ReclamanteDTO> obtenerReclamantes() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<ReclamanteDTO> reclamantesDTO = new Vector<ReclamanteDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Reclamante> reclamantes = (Vector<Reclamante>) accesoBD.buscarPorFiltro(Reclamante.class,"id ascending");
			for(int i=0; i<reclamantes.size();i++){
				ReclamanteDTO reclamanteDTO = new ReclamanteDTO();
				
				reclamanteDTO.setId(reclamantes.elementAt(i).getId());
				reclamanteDTO.setNombre_apellido(reclamantes.elementAt(i).getNombre_apellido());
				reclamanteDTO.setEmail(reclamantes.elementAt(i).getEmail());
				
				reclamantesDTO.add(reclamanteDTO);
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return reclamantesDTO;
	}

	@Override
	public boolean existeReclamante(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Reclamante) accesoBD.buscarPorId(Reclamante.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existeReclamante(String nombre_apellido) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<ReclamanteDTO> reclamantesDTO = obtenerReclamantes();
			for(int i=0; i<reclamantesDTO.size();i++){
				if (reclamantesDTO.elementAt(i).getNombre_apellido().equals(nombre_apellido)){
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
	public ReclamanteDTO buscarReclamante(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		ReclamanteDTO reclamanteDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			reclamanteDTO = ReclamanteAssembler.getReclamanteDTO((Reclamante) accesoBD.buscarPorId(Reclamante.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return reclamanteDTO;
	}

	@Override
	public ReclamanteDTO buscarReclamante(String nombre_apellido) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		ReclamanteDTO reclamanteDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<ReclamanteDTO> reclamantesDTO = obtenerReclamantes();
			for(int i=0; i<reclamantesDTO.size();i++){
				if (reclamantesDTO.elementAt(i).getNombre_apellido().equals(nombre_apellido)){
					reclamanteDTO = reclamantesDTO.elementAt(i);
					break;
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return reclamanteDTO;
	}
}