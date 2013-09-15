package servidor.GestionarReclamante;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.Vector;

import servidor.assembler.ReclamanteAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Reclamante;

import common.DTOs.ReclamanteDTO;
import common.GestionarReclamante.IControlReclamante;

public class ControlReclamante extends UnicastRemoteObject implements IControlReclamante {

	private static final long serialVersionUID = 1L;

	protected ControlReclamante() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
<<<<<<< .mine
	public Long agregarReclamante(ReclamanteDTO reclamanteDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Long id = new Long(0);
		try {
			accesoBD.iniciarTransaccion();
			ReclamanteAssembler reclamanteAssemb = new ReclamanteAssembler(accesoBD);
			Reclamante reclamante = reclamanteAssemb.getReclamanteNuevo(reclamanteDTO);
			accesoBD.hacerPersistente(reclamante);
			id = reclamante.getId();
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return id;
=======
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
>>>>>>> .r18
	}

	@Override
	public void eliminarReclamante(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			ReclamanteAssembler reclamanteAssemb = new ReclamanteAssembler(accesoBD);
			Reclamante reclamante = reclamanteAssemb.getReclamante(buscarReclamante(id));
			accesoBD.eliminar(reclamante);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
=======
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Reclamante reclamante = ReclamanteAssembler.getReclamante(buscarReclamante(id));
			accesoBD.eliminar(reclamante);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public void modificarReclamante(Long id, ReclamanteDTO modificado)
			throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			ReclamanteAssembler reclamanteAssemb = new ReclamanteAssembler(accesoBD);
			Reclamante reclamante = reclamanteAssemb.getReclamante(buscarReclamante(id));

			reclamante.setEmail(modificado.getEmail());
			reclamante.setNombre_apellido(modificado.getNombre_apellido());

			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
=======
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
>>>>>>> .r18
	}

	@Override
	public Vector<ReclamanteDTO> obtenerReclamantes() throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		Vector<ReclamanteDTO> reclamantesDTO = new Vector<ReclamanteDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Reclamante> reclamantes = new Vector<Reclamante>(accesoBD.buscarPorFiltro(Reclamante.class, ""));
			for (int i = 0; i < reclamantes.size(); i++) {
				ReclamanteDTO reclamanteDTO = new ReclamanteDTO();

				reclamanteDTO.setId(reclamantes.elementAt(i).getId());
				reclamanteDTO.setNombre_apellido(reclamantes.elementAt(i).getNombre_apellido());
				reclamanteDTO.setEmail(reclamantes.elementAt(i).getEmail());

				reclamantesDTO.add(reclamanteDTO);
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return reclamantesDTO;
=======
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
>>>>>>> .r18
	}

	@Override
	public boolean existeReclamante(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Reclamante) accesoBD.buscarPorId(Reclamante.class, id) == null);
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
			existe = ((Reclamante) accesoBD.buscarPorId(Reclamante.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
>>>>>>> .r18
	}

	@Override
	public boolean existeReclamante(String nombre_apellido) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		Collection movCol = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "nombre_apellido.equals(\""+nombre_apellido+"\")";
			movCol = accesoBD.buscarPorFiltro(Reclamante.class, filtro);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return (movCol != null && movCol.size()>=1);
=======
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
>>>>>>> .r18
	}

	@Override
	public ReclamanteDTO buscarReclamante(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		ReclamanteDTO reclamanteDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			ReclamanteAssembler reclamanteAssemb = new ReclamanteAssembler(accesoBD);
			reclamanteDTO = reclamanteAssemb.getReclamanteDTO((Reclamante) accesoBD.buscarPorId(Reclamante.class, id));
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return reclamanteDTO;
=======
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
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public ReclamanteDTO buscarReclamante(String nombre_apellido)
			throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		ReclamanteDTO reclamanteDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "nombre_apellido.equals(\""+nombre_apellido+"\")";
			Collection movCol = accesoBD.buscarPorFiltro(Reclamante.class, filtro);
			ReclamanteAssembler reclamanteAssemb = new ReclamanteAssembler(accesoBD);
			if (movCol.size()>=1){
				reclamanteDTO = reclamanteAssemb.getReclamanteDTO((Reclamante)(movCol.toArray())[0]);
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return reclamanteDTO;
=======
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
>>>>>>> .r18
	}
}