package servidor.GestionarNotificacion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.NotificacionAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Notificacion;

import common.DTOs.NotificacionDTO;
import common.GestionarNotificacion.IControlNotificacion;

public class  ControlNotificacion extends UnicastRemoteObject implements IControlNotificacion{

	private static final long serialVersionUID = 1L;

	protected ControlNotificacion() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarNotificacion(NotificacionDTO notificacionDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion notificacion = NotificacionAssembler.getNotificacion(notificacionDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(notificacion);
			id=notificacion.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarNotificacion(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Notificacion notificacion = NotificacionAssembler.getNotificacion(buscarNotificacion(id));
			accesoBD.eliminar(notificacion);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}		
	}

	@Override
	public void modificarNotificacion(Long id, NotificacionDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Notificacion notificacion = NotificacionAssembler.getNotificacion(buscarNotificacion(id));
			
			notificacion.setConcretada_notificacion(modificado.getConcretada_notificacion());
			notificacion.setTexto_notificacion(modificado.getTexto_notificacion());
			notificacion.setFecha_notificacion(modificado.getFecha_notificacion());

			accesoBD.hacerPersistente(notificacion);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<NotificacionDTO> obtenerNotificacion() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<NotificacionDTO> notificacionesDTO = new Vector<NotificacionDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Notificacion> notificaciones= (Vector<Notificacion>) accesoBD.buscarPorFiltro(Notificacion.class,"id ascending");
			for(int i=0; i<notificaciones.size();i++){
				NotificacionDTO notificacionDTO = new NotificacionDTO();
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
	public Vector<NotificacionDTO> obtenerNotificacion(Boolean concretada_notificacion) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<NotificacionDTO> notificacionesDTO = new Vector<NotificacionDTO>();
		try {
			accesoBD.iniciarTransaccion();
			Vector<NotificacionDTO> notificaciones = obtenerNotificacion();
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
	public boolean existeNotificacion(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Notificacion) accesoBD.buscarPorId(Notificacion.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existeNotificacion(NotificacionDTO notificacionDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<NotificacionDTO> notificacions = obtenerNotificacion();
			for(int i=0; i<notificacions.size();i++){		
				if (notificacions.elementAt(i).getId().equals(notificacionDTO.getId())){
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
	public NotificacionDTO buscarNotificacion(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		NotificacionDTO notificacionDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			notificacionDTO = NotificacionAssembler.getNotificacionDTO((Notificacion) accesoBD.buscarPorId(Notificacion.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return notificacionDTO;
	}

	@Override
	public NotificacionDTO buscarNotificacion(NotificacionDTO notificacionDTO)throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		NotificacionDTO notificacionesDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<NotificacionDTO> notificaciones = obtenerNotificacion();
			for(int i=0; i<notificaciones.size();i++){		
				if (notificaciones.elementAt(i).getId().equals(notificacionDTO.getId())){
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