package servidor.GestionarEntidad;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.EntidadAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Entidad;

import common.DTOs.EntidadDTO;
import common.GestionarEntidad.IControlEntidad;

public class ControlEntidad extends UnicastRemoteObject implements IControlEntidad{

	private static final long serialVersionUID = 1L;

	protected ControlEntidad() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarEntidad(EntidadDTO entidad) throws Exception {
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
	}

	@Override
	public void eliminarEntidad(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Entidad entidad = EntidadAssembler.getEntidad(buscarEntidad(id));
			accesoBD.eliminar(entidad);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
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
	}

	@Override
	public Vector<EntidadDTO> obtenerEntidad() throws Exception {
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
	}

	@Override
	public boolean existeEntidad(Long id) throws Exception {
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
	}

	@Override
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
	}

	@Override
	public EntidadDTO buscarEntidad(Long id) throws Exception {
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
	}

	@Override
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
	}

}