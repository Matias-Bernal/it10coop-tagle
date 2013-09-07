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

	/**
	 * 
	 */
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
			
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<AdministrativoDTO> obtenerAdministrativo() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector administrativosDTO = new Vector();
		try {
			accesoBD.iniciarTransaccion();
			Vector administrativos= (Vector) accesoBD.buscarPorFiltro(Administrativo.class,"nombre_usuario ascending");
			for(int i=0; i<administrativos.size();i++){
				AdministrativoDTO adminDTO = new AdministrativoDTO();
				Administrativo admin = (Administrativo)administrativos.elementAt(i);
				adminDTO.setId(admin.getId());
				adminDTO.setNombre_usuario(admin.getNombre_usuario());
				adminDTO.setClave(admin.getClave());
				adminDTO.setEmail(admin.getEmail());
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeAdministrativo(String nombre_administrativo)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AdministrativoDTO buscarAdministrativo(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdministrativoDTO buscarAdministrativo(String nombre_administrativo)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	


}