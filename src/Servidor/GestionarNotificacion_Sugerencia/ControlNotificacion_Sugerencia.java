package servidor.GestionarNotificacion_Sugerencia;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.Notificacion_SugerenciaAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Notificacion;
import servidor.persistencia.dominio.Notificacion_Sugerencia;

import common.DTOs.Notificacion_SugerenciaDTO;
import common.GestionarNotificacion_Sugerencia.IControlNotificacion_Sugerencia;

public class ControlNotificacion_Sugerencia extends UnicastRemoteObject implements IControlNotificacion_Sugerencia{

	private static final long serialVersionUID = 1L;

	protected ControlNotificacion_Sugerencia() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarNotificacion_Sugerencia(Notificacion_SugerenciaDTO notificacion_SugerenciaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_Sugerencia notificacion_Sugerencia = Notificacion_SugerenciaAssembler.getNotificacion_Sugerencia(notificacion_SugerenciaDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(notificacion_Sugerencia);
			id=notificacion_Sugerencia.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarNotificacion_Sugerencia(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Notificacion_Sugerencia notificacion_Sugerencia =  Notificacion_SugerenciaAssembler.getNotificacion_Sugerencia(buscarNotificacion_Sugerencia(id));
			accesoBD.eliminar(notificacion_Sugerencia);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}		
	}

	@Override
	public void modificarNotificacion_Sugerencia(Long id,Notificacion_SugerenciaDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Notificacion_Sugerencia notificacion_Sugerencia =  Notificacion_SugerenciaAssembler.getNotificacion_Sugerencia(buscarNotificacion_Sugerencia(id));
			
			notificacion_Sugerencia.setConcretada_notificacion(modificado.getConcretada_notificacion());
			notificacion_Sugerencia.setTexto_notificacion(modificado.getTexto_notificacion());
			notificacion_Sugerencia.setFecha_notificacion(modificado.getFecha_notificacion());

			accesoBD.hacerPersistente(notificacion_Sugerencia);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<Notificacion_SugerenciaDTO> obtenerNotificacion_Sugerencia() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Notificacion_SugerenciaDTO> notificacionesDTO = new Vector<Notificacion_SugerenciaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Notificacion_Sugerencia> notificaciones= (Vector<Notificacion_Sugerencia>) accesoBD.buscarPorFiltro(Notificacion_Sugerencia.class,"id ascending");
			for(int i=0; i<notificaciones.size();i++){
				Notificacion_SugerenciaDTO notificacionDTO = new Notificacion_SugerenciaDTO();
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
	public Vector<Notificacion_SugerenciaDTO> obtenerNotificacion_Sugerencia(Boolean concretada_notificacion) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Notificacion_SugerenciaDTO> notificacionesDTO = new Vector<Notificacion_SugerenciaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_SugerenciaDTO> notificaciones = obtenerNotificacion_Sugerencia();
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
	public boolean existeNotificacion_Sugerencia(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Notificacion_Sugerencia) accesoBD.buscarPorId(Notificacion_Sugerencia.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existeNotificacion_Sugerencia(Notificacion_SugerenciaDTO notificacion_SugerenciaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_SugerenciaDTO> notificacions = obtenerNotificacion_Sugerencia();
			for(int i=0; i<notificacions.size();i++){		
				if (notificacions.elementAt(i).getId().equals(notificacion_SugerenciaDTO.getId())){
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
	public Notificacion_SugerenciaDTO buscarNotificacion_Sugerencia(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_SugerenciaDTO notificacionDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			notificacionDTO = Notificacion_SugerenciaAssembler.getNotificacion_SugerenciaDTO((Notificacion_Sugerencia) accesoBD.buscarPorId(Notificacion_Sugerencia.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return notificacionDTO;
	}

	@Override
	public Notificacion_SugerenciaDTO buscarNotificacion_Sugerencia(Notificacion_SugerenciaDTO notificacion_SugerenciaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_SugerenciaDTO notificacionesDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_SugerenciaDTO> notificaciones = obtenerNotificacion_Sugerencia();
			for(int i=0; i<notificaciones.size();i++){		
				if (notificaciones.elementAt(i).getId().equals(notificacion_SugerenciaDTO.getId())){
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
