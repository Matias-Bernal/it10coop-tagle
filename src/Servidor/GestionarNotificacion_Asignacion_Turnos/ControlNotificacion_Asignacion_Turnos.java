package servidor.GestionarNotificacion_Asignacion_Turnos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.Notificacion_Asignacion_TurnosAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Notificacion;
import servidor.persistencia.dominio.Notificacion_Asignacion_Turnos;

import common.DTOs.Notificacion_Asignacion_TurnosDTO;
import common.GestionarNotificacion_Asignacion_Turnos.IControlNotificacion_Asignacion_Turnos;

public class ControlNotificacion_Asignacion_Turnos extends UnicastRemoteObject implements IControlNotificacion_Asignacion_Turnos{

	private static final long serialVersionUID = 1L;

	protected ControlNotificacion_Asignacion_Turnos() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarNotificacion_Asignacion_Turnos(Notificacion_Asignacion_TurnosDTO notificacion_Asignacion_TurnosDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_Asignacion_Turnos notificacion_Asignacion_Turnos = Notificacion_Asignacion_TurnosAssembler.getNotificacion_Asignacion_Turnos(notificacion_Asignacion_TurnosDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(notificacion_Asignacion_Turnos);
			id=notificacion_Asignacion_Turnos.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarNotificacion_Asignacion_Turnos(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Notificacion_Asignacion_Turnos notificacion_Asignacion_Turnos =  Notificacion_Asignacion_TurnosAssembler.getNotificacion_Asignacion_Turnos(buscarNotificacion_Asignacion_Turnos(id));
			accesoBD.eliminar(notificacion_Asignacion_Turnos);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}		
	}

	@Override
	public void modificarNotificacion_Asignacion_Turnos(Long id,Notificacion_Asignacion_TurnosDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Notificacion_Asignacion_Turnos notificacion_Asignacion_Turnos =  Notificacion_Asignacion_TurnosAssembler.getNotificacion_Asignacion_Turnos(buscarNotificacion_Asignacion_Turnos(id));
			
			notificacion_Asignacion_Turnos.setConcretada_notificacion(modificado.getConcretada_notificacion());
			notificacion_Asignacion_Turnos.setTexto_notificacion(modificado.getTexto_notificacion());
			notificacion_Asignacion_Turnos.setFecha_notificacion(modificado.getFecha_notificacion());

			accesoBD.hacerPersistente(notificacion_Asignacion_Turnos);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<Notificacion_Asignacion_TurnosDTO> obtenerNotificacion_Asignacion_Turnos() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Notificacion_Asignacion_TurnosDTO> notificacionesDTO = new Vector<Notificacion_Asignacion_TurnosDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Notificacion_Asignacion_Turnos> notificaciones= (Vector<Notificacion_Asignacion_Turnos>) accesoBD.buscarPorFiltro(Notificacion_Asignacion_Turnos.class,"id ascending");
			for(int i=0; i<notificaciones.size();i++){
				Notificacion_Asignacion_TurnosDTO notificacionDTO = new Notificacion_Asignacion_TurnosDTO();
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
	public Vector<Notificacion_Asignacion_TurnosDTO> obtenerNotificacion_Asignacion_Turnos(Boolean concretada_notificacion) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Notificacion_Asignacion_TurnosDTO> notificacionesDTO = new Vector<Notificacion_Asignacion_TurnosDTO>();
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_Asignacion_TurnosDTO> notificaciones = obtenerNotificacion_Asignacion_Turnos();
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
	public boolean existeNotificacion_Asignacion_Turnos(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Notificacion_Asignacion_Turnos) accesoBD.buscarPorId(Notificacion_Asignacion_Turnos.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existeNotificacion_Asignacion_Turnos(Notificacion_Asignacion_TurnosDTO notificacion_Asignacion_TurnosDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_Asignacion_TurnosDTO> notificacions = obtenerNotificacion_Asignacion_Turnos();
			for(int i=0; i<notificacions.size();i++){		
				if (notificacions.elementAt(i).getId().equals(notificacion_Asignacion_TurnosDTO.getId())){
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
	public Notificacion_Asignacion_TurnosDTO buscarNotificacion_Asignacion_Turnos(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_Asignacion_TurnosDTO notificacionDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			notificacionDTO = Notificacion_Asignacion_TurnosAssembler.getNotificacion_Asignacion_TurnosDTO((Notificacion_Asignacion_Turnos) accesoBD.buscarPorId(Notificacion_Asignacion_Turnos.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return notificacionDTO;
	}

	@Override
	public Notificacion_Asignacion_TurnosDTO buscarNotificacion_Asignacion_Turnos(Notificacion_Asignacion_TurnosDTO notificacion_Asignacion_TurnosDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_Asignacion_TurnosDTO notificacionesDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_Asignacion_TurnosDTO> notificaciones = obtenerNotificacion_Asignacion_Turnos();
			for(int i=0; i<notificaciones.size();i++){		
				if (notificaciones.elementAt(i).getId().equals(notificacion_Asignacion_TurnosDTO.getId())){
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
