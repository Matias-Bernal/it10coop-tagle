package servidor.GestionarEntidad;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.Vector;

<<<<<<< .mine
import servidor.assembler.BdgAssembler;
import servidor.assembler.Devolucion_PiezaAssembler;
import servidor.assembler.EntidadAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Bdg;
import servidor.persistencia.dominio.Entidad;
import servidor.persistencia.dominio.Mano_Obra;
=======
import servidor.assembler.EntidadAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Entidad;

>>>>>>> .r18
import common.DTOs.EntidadDTO;
import common.GestionarEntidad.IControlEntidad;

public class ControlEntidad extends UnicastRemoteObject implements
		IControlEntidad {

	private static final long serialVersionUID = 1L;

	protected ControlEntidad() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarEntidad(EntidadDTO entidad) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		Long id = new Long(0);
		try {
			accesoBD.iniciarTransaccion();
			EntidadAssembler entidadAssemb = new EntidadAssembler(accesoBD);
			Entidad nuevoEntidad = entidadAssemb.getEntidadNueva(entidad);
			accesoBD.hacerPersistente(nuevoEntidad);
			id = nuevoEntidad.getId();
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return id;
=======
		AccesoBD accesoBD = new AccesoBD();
		Entidad nuevoEntidad = EntidadAssembler.getEntidad(entidad);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(nuevoEntidad);
			id=nuevoEntidad.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
>>>>>>> .r18
	}

	@Override
	public void eliminarEntidad(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			EntidadAssembler entidadAssemb = new EntidadAssembler(accesoBD);
			Entidad entidad = entidadAssemb.getEntidad(buscarEntidad(id));
			accesoBD.eliminar(entidad);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
=======
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Entidad entidad = EntidadAssembler.getEntidad(buscarEntidad(id));
			accesoBD.eliminar(entidad);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public void modificarEntidad(Long id, EntidadDTO modificado)
			throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			EntidadAssembler entidadAssemb = new EntidadAssembler(accesoBD);
			Entidad entidad = entidadAssemb.getEntidad(buscarEntidad(id));
			entidad.setNombre_registrante(modificado.getNombre_registrante());
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
=======
	public void modificarEntidad(Long id, EntidadDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Entidad entidad = EntidadAssembler.getEntidad(buscarEntidad(id));
			entidad.setNombre_registrante(modificado.getNombre_registrante());
			accesoBD.hacerPersistente(entidad);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
>>>>>>> .r18
	}

	@Override
	public Vector<EntidadDTO> obtenerEntidad() throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		Vector<EntidadDTO> entidadesDTO = new Vector<EntidadDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Entidad> entidades = (Vector<Entidad>) accesoBD.buscarPorFiltro(Entidad.class,"");
			for (int i = 0; i < entidades.size(); i++) {
				EntidadDTO entidadDTO = new EntidadDTO();
				entidadDTO.setId(entidades.elementAt(i).getId());
				entidadDTO.setNombre_registrante(entidades.elementAt(i).getNombre_registrante());
				entidadesDTO.add(entidadDTO);
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return entidadesDTO;
=======
		AccesoBD accesoBD = new AccesoBD();
		Vector<EntidadDTO> entidadesDTO = new Vector<EntidadDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Entidad> entidades= (Vector<Entidad>) accesoBD.buscarPorFiltro(Entidad.class,"nombre_registrante ascending");
			for(int i=0; i<entidades.size();i++){
				EntidadDTO entidadDTO = new EntidadDTO();
				entidadDTO.setId(((Entidad)entidades.elementAt(i)).getId());
				entidadDTO.setNombre_registrante(((Entidad)entidades.elementAt(i)).getNombre_registrante());
				entidadesDTO.add(entidadDTO);
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return entidadesDTO;
>>>>>>> .r18
	}

	@Override
	public boolean existeEntidad(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Entidad) accesoBD.buscarPorId(Entidad.class, id) == null);
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
			existe = ((Entidad) accesoBD.buscarPorId(Entidad.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public boolean existeEntidad(String nombre_registrante) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Collection movCol = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "nombre_registrante.equals(\""+nombre_registrante+"\")";
			movCol = accesoBD.buscarPorFiltro(Entidad.class, filtro);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return (movCol != null && movCol.size()>=1);
=======
	public boolean existeEntidad(String nombre_registrante) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<EntidadDTO> entidadesDTO = obtenerEntidad();
			for(int i=0; i<entidadesDTO.size();i++){
				if (((EntidadDTO)entidadesDTO.elementAt(i)).getNombre_registrante().equals(nombre_registrante)){
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
	public EntidadDTO buscarEntidad(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		EntidadDTO entidadDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			EntidadAssembler entidadAssemb = new EntidadAssembler(accesoBD);
			entidadDTO = entidadAssemb.getEntidadDTO((Entidad) accesoBD.buscarPorId(Entidad.class, id));
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return entidadDTO;
=======
		AccesoBD accesoBD = new AccesoBD();
		EntidadDTO entidadDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			entidadDTO = EntidadAssembler.getEntidadDTO((Entidad) accesoBD.buscarPorId(Entidad.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return entidadDTO;
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public EntidadDTO buscarEntidad(String nombre_registrante) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		EntidadDTO entidadDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "nombre_registrante.equals(\""+nombre_registrante+"\")";
			Collection entidades = accesoBD.buscarPorFiltro(Entidad.class, filtro);
			EntidadAssembler entidadAssemb = new EntidadAssembler(accesoBD);
			if (entidades.size()>=1 ) {
				entidadDTO = entidadAssemb.getEntidadDTO((Entidad)(entidades.toArray()[0]));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return entidadDTO;
=======
	public EntidadDTO buscarEntidad(String nombre_registrante) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		EntidadDTO entidadDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<EntidadDTO> entidadesDTO = obtenerEntidad();
				for(int i=0; i<entidadesDTO.size();i++){
					if (((EntidadDTO)entidadesDTO.elementAt(i)).getNombre_registrante().equals(nombre_registrante)){
						entidadDTO = (EntidadDTO)entidadesDTO.elementAt(i);
						break;
					}
				}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return entidadDTO;
>>>>>>> .r18
	}

}