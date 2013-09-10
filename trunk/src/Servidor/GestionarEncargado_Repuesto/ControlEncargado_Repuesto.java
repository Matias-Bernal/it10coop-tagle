package servidor.GestionarEncargado_Repuesto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.Encargado_RepuestoAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Encargado_Repuesto;

import common.DTOs.Encargado_RepuestoDTO;
import common.GestionarEncargado_Repuesto.IControlEncargado_Repuesto;

public class ControlEncargado_Repuesto extends UnicastRemoteObject implements IControlEncargado_Repuesto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlEncargado_Repuesto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarEncargado_Repuesto(Encargado_RepuestoDTO encargado_RepuestoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Encargado_Repuesto encargado_Repuesto = Encargado_RepuestoAssembler.getEncargado_Repuesto(encargado_RepuestoDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(encargado_Repuesto);
			id=encargado_Repuesto.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarEncargado_Repuesto(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Encargado_Repuesto encargado_Repuesto = Encargado_RepuestoAssembler.getEncargado_Repuesto(buscarEncargado_Repuesto(id));
			accesoBD.eliminar(encargado_Repuesto);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public void modificarEncargado_Repuesto(Long id, Encargado_RepuestoDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Encargado_Repuesto encargado_Repuesto = Encargado_RepuestoAssembler.getEncargado_Repuesto(buscarEncargado_Repuesto(id));

			encargado_Repuesto.setNombre_usuario(modificado.getNombre_usuario());
			encargado_Repuesto.setClave(modificado.getClave());
			encargado_Repuesto.setEmail(modificado.getEmail());
			
			accesoBD.hacerPersistente(encargado_Repuesto);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<Encargado_RepuestoDTO> obtenerEncargado_Repuesto() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Encargado_RepuestoDTO> ecargados_RepuestoDTO = new Vector<Encargado_RepuestoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Encargado_Repuesto> encargados = (Vector<Encargado_Repuesto>) accesoBD.buscarPorFiltro(Encargado_Repuesto.class,"nombre_usuario ascending");
			for(int i=0; i<encargados.size();i++){
				Encargado_RepuestoDTO encargDTO = new Encargado_RepuestoDTO();
				encargDTO.setId(((Encargado_Repuesto)encargados.elementAt(i)).getId());
				encargDTO.setNombre_usuario(((Encargado_Repuesto)encargados.elementAt(i)).getNombre_usuario());
				encargDTO.setClave(((Encargado_Repuesto)encargados.elementAt(i)).getClave());
				encargDTO.setEmail(((Encargado_Repuesto)encargados.elementAt(i)).getEmail());
				ecargados_RepuestoDTO.add(encargDTO);
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return ecargados_RepuestoDTO;
	}

	@Override
	public boolean existeEncargado_Repuesto(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Encargado_Repuesto) accesoBD.buscarPorId(Encargado_Repuesto.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existeEncargado_Repuesto(String nombre_usuario) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Encargado_RepuestoDTO> encargadosDTO = obtenerEncargado_Repuesto();
			for(int i=0; i<encargadosDTO.size();i++){
				if ((encargadosDTO.elementAt(i)).getNombre_usuario().equals(nombre_usuario)){
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
	public Encargado_RepuestoDTO buscarEncargado_Repuesto(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Encargado_RepuestoDTO encargado_RepuestoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			encargado_RepuestoDTO = Encargado_RepuestoAssembler.getEncargado_RepuestoDTO((Encargado_Repuesto) accesoBD.buscarPorId(Encargado_Repuesto.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return encargado_RepuestoDTO;
	}

	@Override
	public Encargado_RepuestoDTO buscarEncargado_Repuesto(String nombre_usuario) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Encargado_RepuestoDTO encargado_RepuestoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Encargado_RepuestoDTO> encargados = obtenerEncargado_Repuesto();
			for(int i=0; i<encargados.size();i++){
				if (((Encargado_RepuestoDTO)encargados.elementAt(i)).getNombre_usuario().equals(nombre_usuario)){
					encargado_RepuestoDTO = (Encargado_RepuestoDTO)encargados.elementAt(i);
					break;
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return encargado_RepuestoDTO;
	}
	


}