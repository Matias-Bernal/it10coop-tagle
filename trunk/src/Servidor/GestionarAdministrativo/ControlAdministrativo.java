package servidor.GestionarAdministrativo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.AdministrativoAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Administrativo;
import common.DTOs.AdministrativoDTO;
import common.GestionarAdministrativo.IControlAdministrativo;

public class ControlAdministrativo extends UnicastRemoteObject implements IControlAdministrativo {


	private static final long serialVersionUID = 1L;

	protected ControlAdministrativo() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarAdministrativo(AdministrativoDTO administrativoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Administrativo nuevoAdministrativo = AdministrativoAssembler.getAdministrativo(administrativoDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(nuevoAdministrativo);
			id=nuevoAdministrativo.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarAdministrativo(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Administrativo administrativo = AdministrativoAssembler.getAdministrativo(buscarAdministrativo(id));
			accesoBD.eliminar(administrativo);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public void modificarAdministrativo(Long id, AdministrativoDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Administrativo administrativo = AdministrativoAssembler.getAdministrativo(buscarAdministrativo(id));

			administrativo.setNombre_usuario(modificado.getNombre_usuario());
			administrativo.setClave(modificado.getClave());
			administrativo.setEmail(modificado.getEmail());
			
			accesoBD.hacerPersistente(administrativo);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<AdministrativoDTO> obtenerAdministrativos() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<AdministrativoDTO> administrativosDTO = new Vector<AdministrativoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Administrativo> administrativos = (Vector<Administrativo>) accesoBD.buscarPorFiltro(Administrativo.class,"nombre_usuario ascending");
			for(int i=0; i<administrativos.size();i++){
				AdministrativoDTO adminDTO = new AdministrativoDTO();
				adminDTO.setId(((Administrativo)administrativos.elementAt(i)).getId());
				adminDTO.setNombre_usuario(((Administrativo)administrativos.elementAt(i)).getNombre_usuario());
				adminDTO.setClave(((Administrativo)administrativos.elementAt(i)).getClave());
				adminDTO.setEmail(((Administrativo)administrativos.elementAt(i)).getEmail());
				administrativosDTO.add(adminDTO);
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return administrativosDTO;
	}


	@Override
	public boolean existeAdministrativo(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Administrativo) accesoBD.buscarPorId(Administrativo.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existeAdministrativo(String nombre_usuario) throws Exception {		
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<AdministrativoDTO> administrativosDTO = obtenerAdministrativos();
			for(int i=0; i<administrativosDTO.size();i++){
				if (((AdministrativoDTO)administrativosDTO.elementAt(i)).getNombre_usuario().equals(nombre_usuario)){
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
	public AdministrativoDTO buscarAdministrativo(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		AdministrativoDTO administrativoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			administrativoDTO = AdministrativoAssembler.getAdministrativoDTO((Administrativo) accesoBD.buscarPorId(Administrativo.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return administrativoDTO;
	}

	@Override
	public AdministrativoDTO buscarAdministrativo(String nombre_usuario) throws Exception{
		AccesoBD accesoBD = new AccesoBD();
		AdministrativoDTO administrativoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<AdministrativoDTO> administrativosDTO = obtenerAdministrativos();
			for(int i=0; i<administrativosDTO.size();i++){
				if (((AdministrativoDTO)administrativosDTO.elementAt(i)).getNombre_usuario().equals(nombre_usuario)){
					administrativoDTO = (AdministrativoDTO)administrativosDTO.elementAt(i);
					break;
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return administrativoDTO;
	}
}