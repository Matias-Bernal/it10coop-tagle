package servidor.GestionarNotificacion_Contencion_Cliente;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.Notificacion_Contencion_ClienteAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Notificacion;
import servidor.persistencia.dominio.Notificacion_Contencion_Cliente;

import common.DTOs.Notificacion_Contencion_ClienteDTO;
import common.GestionarNotificacion_Contencion_Cliente.IControlNotificacion_Contencion_Cliente;

public class ControlNotificacion_Contencion_Cliente extends UnicastRemoteObject implements IControlNotificacion_Contencion_Cliente{

	private static final long serialVersionUID = 1L;

	protected ControlNotificacion_Contencion_Cliente() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarNotificacion_Contencion_Cliente(Notificacion_Contencion_ClienteDTO notificacion_Contencion_ClienteDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_Contencion_Cliente notificacion_Contencion_Cliente = Notificacion_Contencion_ClienteAssembler.getNotificacion_Contencion_Cliente(notificacion_Contencion_ClienteDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(notificacion_Contencion_Cliente);
			id=notificacion_Contencion_Cliente.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarNotificacion_Contencion_Cliente(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Notificacion_Contencion_Cliente notificacion_Contencion_Cliente =  Notificacion_Contencion_ClienteAssembler.getNotificacion_Contencion_Cliente(buscarNotificacion_Contencion_Cliente(id));
			accesoBD.eliminar(notificacion_Contencion_Cliente);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}		
	}

	@Override
	public void modificarNotificacion_Contencion_Cliente(Long id,Notificacion_Contencion_ClienteDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Notificacion_Contencion_Cliente notificacion_Contencion_Cliente =  Notificacion_Contencion_ClienteAssembler.getNotificacion_Contencion_Cliente(buscarNotificacion_Contencion_Cliente(id));
			
			notificacion_Contencion_Cliente.setConcretada_notificacion(modificado.getConcretada_notificacion());
			notificacion_Contencion_Cliente.setTexto_notificacion(modificado.getTexto_notificacion());
			notificacion_Contencion_Cliente.setFecha_notificacion(modificado.getFecha_notificacion());

			accesoBD.hacerPersistente(notificacion_Contencion_Cliente);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<Notificacion_Contencion_ClienteDTO> obtenerNotificacion_Contencion_Cliente() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Notificacion_Contencion_ClienteDTO> notificacionesDTO = new Vector<Notificacion_Contencion_ClienteDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Notificacion_Contencion_Cliente> notificaciones= (Vector<Notificacion_Contencion_Cliente>) accesoBD.buscarPorFiltro(Notificacion_Contencion_Cliente.class,"id ascending");
			for(int i=0; i<notificaciones.size();i++){
				Notificacion_Contencion_ClienteDTO notificacionDTO = new Notificacion_Contencion_ClienteDTO();
				notificacionDTO.setId(((Notificacion)notificaciones.elementAt(i)).getId());
				notificacionDTO.setFecha_notificacion(((Notificacion)notificaciones.elementAt(i)).getFecha_notificacion());
				notificacionDTO.setConcretada_notificacion(((Notificacion)notificaciones.elementAt(i)).getConcretada_notificacion());
				notificacionDTO.setTexto_notificacion(((Notificacion)notificaciones.elementAt(i)).getTexto_notificacion());
				notificacionesDTO.add(notificacionDTO);
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return notificacionesDTO;
	}

	@Override
	public Vector<Notificacion_Contencion_ClienteDTO> obtenerNotificacion_Contencion_Cliente(Boolean concretada_notificacion) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Notificacion_Contencion_ClienteDTO> notificacionesDTO = new Vector<Notificacion_Contencion_ClienteDTO>();
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_Contencion_ClienteDTO> notificaciones = obtenerNotificacion_Contencion_Cliente();
			for(int i=0; i<notificaciones.size();i++){		
				if (notificaciones.elementAt(i).getConcretada_notificacion().equals(concretada_notificacion)){
					notificacionesDTO.add(notificaciones.elementAt(i));
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return notificacionesDTO;
	}

	@Override
	public boolean existeNotificacion_Contencion_Cliente(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Notificacion_Contencion_Cliente) accesoBD.buscarPorId(Notificacion_Contencion_Cliente.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existeNotificacion_Contencion_Cliente(Notificacion_Contencion_ClienteDTO notificacion_Contencion_ClienteDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_Contencion_ClienteDTO> notificacions = obtenerNotificacion_Contencion_Cliente();
			for(int i=0; i<notificacions.size();i++){		
				if (notificacions.elementAt(i).getId().equals(notificacion_Contencion_ClienteDTO.getId())){
					existe = true;
					break;
				}
			}
			accesoBD.concretarTransaccion();
		} finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public Notificacion_Contencion_ClienteDTO buscarNotificacion_Contencion_Cliente(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_Contencion_ClienteDTO notificacionDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			notificacionDTO = Notificacion_Contencion_ClienteAssembler.getNotificacion_Contencion_ClienteDTO((Notificacion_Contencion_Cliente) accesoBD.buscarPorId(Notificacion_Contencion_Cliente.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return notificacionDTO;
	}

	@Override
	public Notificacion_Contencion_ClienteDTO buscarNotificacion_Contencion_Cliente(Notificacion_Contencion_ClienteDTO notificacion_Contencion_ClienteDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_Contencion_ClienteDTO notificacionesDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_Contencion_ClienteDTO> notificaciones = obtenerNotificacion_Contencion_Cliente();
			for(int i=0; i<notificaciones.size();i++){		
				if (notificaciones.elementAt(i).getId().equals(notificacion_Contencion_ClienteDTO.getId())){
					notificacionesDTO = notificaciones.elementAt(i);
					break;
				}
			}
			accesoBD.concretarTransaccion();
		} finally{
			accesoBD.rollbackTransaccion();
		}
		return notificacionesDTO;
	}

}
