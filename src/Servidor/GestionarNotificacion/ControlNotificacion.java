package servidor.GestionarNotificacion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.Vector;

import servidor.assembler.NotificacionAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Notificacion;

import common.DTOs.NotificacionDTO;
import common.GestionarNotificacion.IControlNotificacion;

public class ControlNotificacion extends UnicastRemoteObject implements
		IControlNotificacion {

	private static final long serialVersionUID = 1L;

	protected ControlNotificacion() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
<<<<<<< .mine
	public Long agregarNotificacion(NotificacionDTO notificacionDTO)
			throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Long id = new Long(0);
		try {
			accesoBD.iniciarTransaccion();
			NotificacionAssembler notificacionAssemb = new NotificacionAssembler(accesoBD);
			Notificacion notificacion = notificacionAssemb.getNotificacionNueva(notificacionDTO);
			accesoBD.hacerPersistente(notificacion);
			id = notificacion.getId();
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return id;
=======
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
>>>>>>> .r18
	}

	@Override
	public void eliminarNotificacion(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			NotificacionAssembler notificacionAssemb = new NotificacionAssembler(accesoBD);
			Notificacion notificacion = notificacionAssemb.getNotificacion(buscarNotificacion(id));
			accesoBD.eliminar(notificacion);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
=======
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Notificacion notificacion = NotificacionAssembler.getNotificacion(buscarNotificacion(id));
			accesoBD.eliminar(notificacion);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}		
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public void modificarNotificacion(Long id, NotificacionDTO modificado)
			throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();

			NotificacionAssembler notificacionAssemb = new NotificacionAssembler(accesoBD);
			Notificacion notificacion = notificacionAssemb.getNotificacion(buscarNotificacion(id));
			notificacion.setConcretada_notificacion(modificado.getConcretada_notificacion());
			notificacion.setTexto_notificacion(modificado.getTexto_notificacion());
			notificacion.setFecha_notificacion(modificado.getFecha_notificacion());
			notificacion.setTipo_notificacion(modificado.getTipo_notificacion());

			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
	}
=======
	public void modificarNotificacion(Long id, NotificacionDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Notificacion notificacion = NotificacionAssembler.getNotificacion(buscarNotificacion(id));
			
			notificacion.setConcretada_notificacion(modificado.getConcretada_notificacion());
			notificacion.setTexto_notificacion(modificado.getTexto_notificacion());
			notificacion.setFecha_notificacion(modificado.getFecha_notificacion());
>>>>>>> .r18

<<<<<<< .mine
	@Override
	public Vector<NotificacionDTO> obtenerNotificacion() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<NotificacionDTO> notificacionesDTO = new Vector<NotificacionDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Notificacion> notificaciones = (Vector<Notificacion>) accesoBD.buscarPorFiltro(Notificacion.class, "");
			for (int i = 0; i < notificaciones.size(); i++) {
				NotificacionDTO notificacionDTO = new NotificacionDTO();
				
				notificacionDTO.setId(notificaciones.elementAt(i).getId());
				notificacionDTO.setFecha_notificacion(notificaciones.elementAt(i).getFecha_notificacion());
				notificacionDTO.setConcretada_notificacion(notificaciones.elementAt(i).getConcretada_notificacion());
				notificacionDTO.setTexto_notificacion(notificaciones.elementAt(i).getTexto_notificacion());
				notificacionDTO.setTipo_notificacion(notificaciones.elementAt(i).getTipo_notificacion());
			
				notificacionesDTO.add(notificacionDTO);
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return notificacionesDTO;
=======
			accesoBD.hacerPersistente(notificacion);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Vector<NotificacionDTO> obtenerNotificacion(Boolean concretada_notificacion) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<NotificacionDTO> notificacionesDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "concretada_notificacion.equals(\""+concretada_notificacion+"\")";
			Collection notificaciones = accesoBD.buscarPorFiltro(Notificacion.class, filtro);
			NotificacionAssembler notificacionAssemb = new NotificacionAssembler(accesoBD);
			for (int i = 0; i < notificaciones.size(); i++) {
				notificacionesDTO.add(notificacionAssemb.getNotificacionDTO((Notificacion)(notificaciones.toArray()[i])));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return notificacionesDTO;
=======
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
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Vector<NotificacionDTO> obtenerNotificacion(String tipo_notificacion)throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<NotificacionDTO> notificacionesDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "concretada_notificacion.equals(\""+tipo_notificacion+"\")";
			Collection notificaciones = accesoBD.buscarPorFiltro(Notificacion.class, filtro);
			NotificacionAssembler notificacionAssemb = new NotificacionAssembler(accesoBD);
			for (int i = 0; i < notificaciones.size(); i++) {
				notificacionesDTO.add(notificacionAssemb.getNotificacionDTO((Notificacion)(notificaciones.toArray()[i])));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return notificacionesDTO;
=======
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
>>>>>>> .r18
	}

	@Override
	public boolean existeNotificacion(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Notificacion) accesoBD.buscarPorId(Notificacion.class,id) == null);
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
			existe = ((Notificacion) accesoBD.buscarPorId(Notificacion.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public boolean existeNotificacion(NotificacionDTO notificacionDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Collection movCol = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "notificacion.id == "+notificacionDTO.getId();
			movCol = accesoBD.buscarPorFiltro(Notificacion.class, filtro);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return (movCol != null && movCol.size()>=1);
=======
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
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public NotificacionDTO buscarNotificacion(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		NotificacionDTO notificacionDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			NotificacionAssembler notificacionAssemb = new NotificacionAssembler(accesoBD);
			notificacionDTO = notificacionAssemb.getNotificacionDTO((Notificacion) accesoBD.buscarPorId(Notificacion.class, id));
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return notificacionDTO;
=======
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
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public NotificacionDTO buscarNotificacion(NotificacionDTO notificacionDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		NotificacionDTO notifDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "notificacion.id == "+notificacionDTO.getId();
			Collection movCol = accesoBD.buscarPorFiltro(Notificacion.class, filtro);
			NotificacionAssembler notificacionAssemb = new NotificacionAssembler(accesoBD);
			if (movCol.size()>=1){
				notifDTO = notificacionAssemb.getNotificacionDTO((Notificacion)(movCol.toArray())[0]);
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return notifDTO;
=======
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
>>>>>>> .r18
	}

<<<<<<< .mine

}=======
}>>>>>>> .r18
