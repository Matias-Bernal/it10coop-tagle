package servidor.GestionarNotificacion_Area_Administracion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.Notificacion_Area_AdministracionAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Notificacion;
import servidor.persistencia.dominio.Notificacion_Area_Administracion;

import common.DTOs.Notificacion_Area_AdministracionDTO;
import common.GestionarNotificacion_Area_Administracion.IControlNotificacion_Area_Administracion;

public class ControlNotificacion_Area_Administracion extends UnicastRemoteObject implements IControlNotificacion_Area_Administracion{

	private static final long serialVersionUID = 1L;

	protected ControlNotificacion_Area_Administracion() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarNotificacion_Area_Administracion(Notificacion_Area_AdministracionDTO notificacion_area_administracionDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_Area_Administracion notificacion_Area_Administracion = Notificacion_Area_AdministracionAssembler.getNotificacion_Area_Administracion(notificacion_area_administracionDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(notificacion_Area_Administracion);
			id=notificacion_Area_Administracion.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarNotificacion_Area_Administracion(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Notificacion_Area_Administracion notificacion_Area_Administracion =  Notificacion_Area_AdministracionAssembler.getNotificacion_Area_Administracion(buscarNotificacion_Area_Administracion(id));
			accesoBD.eliminar(notificacion_Area_Administracion);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}		
	}

	@Override
	public void modificarNotificacion_Area_Administracion(Long id,Notificacion_Area_AdministracionDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Notificacion_Area_Administracion notificacion_Area_Administracion =  Notificacion_Area_AdministracionAssembler.getNotificacion_Area_Administracion(buscarNotificacion_Area_Administracion(id));
			
			notificacion_Area_Administracion.setConcretada_notificacion(modificado.getConcretada_notificacion());
			notificacion_Area_Administracion.setTexto_notificacion(modificado.getTexto_notificacion());
			notificacion_Area_Administracion.setFecha_notificacion(modificado.getFecha_notificacion());

			accesoBD.hacerPersistente(notificacion_Area_Administracion);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<Notificacion_Area_AdministracionDTO> obtenerNotificacion_Area_Administracion() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Notificacion_Area_AdministracionDTO> notificacionesDTO = new Vector<Notificacion_Area_AdministracionDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Notificacion_Area_Administracion> notificaciones= (Vector<Notificacion_Area_Administracion>) accesoBD.buscarPorFiltro(Notificacion_Area_Administracion.class,"id ascending");
			for(int i=0; i<notificaciones.size();i++){
				Notificacion_Area_AdministracionDTO notificacionDTO = new Notificacion_Area_AdministracionDTO();
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
	public Vector<Notificacion_Area_AdministracionDTO> obtenerNotificacion_Area_Administracion(Boolean concretada_notificacion) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Notificacion_Area_AdministracionDTO> notificacionesDTO = new Vector<Notificacion_Area_AdministracionDTO>();
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_Area_AdministracionDTO> notificaciones = obtenerNotificacion_Area_Administracion();
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
	public boolean existeNotificacion_Area_Administracion(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Notificacion_Area_Administracion) accesoBD.buscarPorId(Notificacion_Area_Administracion.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existeNotificacion_Area_Administracion(Notificacion_Area_AdministracionDTO notificacion_area_administracionDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_Area_AdministracionDTO> notificacions = obtenerNotificacion_Area_Administracion();
			for(int i=0; i<notificacions.size();i++){		
				if (notificacions.elementAt(i).getId().equals(notificacion_area_administracionDTO.getId())){
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
	public Notificacion_Area_AdministracionDTO buscarNotificacion_Area_Administracion(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_Area_AdministracionDTO notificacionDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			notificacionDTO = Notificacion_Area_AdministracionAssembler.getNotificacion_Area_AdministracionDTO((Notificacion_Area_Administracion) accesoBD.buscarPorId(Notificacion_Area_Administracion.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return notificacionDTO;
	}

	@Override
	public Notificacion_Area_AdministracionDTO buscarNotificacion_Area_Administracion(Notificacion_Area_AdministracionDTO notificacion_area_administracionDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_Area_AdministracionDTO notificacionesDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_Area_AdministracionDTO> notificaciones = obtenerNotificacion_Area_Administracion();
			for(int i=0; i<notificaciones.size();i++){		
				if (notificaciones.elementAt(i).getId().equals(notificacion_area_administracionDTO.getId())){
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