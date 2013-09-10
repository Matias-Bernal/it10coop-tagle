package servidor.GestionarNotificacion_Area_Repuesto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.Notificacion_Area_RepuestoAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Notificacion;
import servidor.persistencia.dominio.Notificacion_Area_Repuesto;

import common.DTOs.Notificacion_Area_RepuestoDTO;
import common.GestionarNotificacion_Area_Repuesto.IControlNotificacion_Area_Repuesto;

public class ControlNotificacion_Area_Repuesto extends UnicastRemoteObject implements IControlNotificacion_Area_Repuesto{

	private static final long serialVersionUID = 1L;

	protected ControlNotificacion_Area_Repuesto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarNotificacion_Area_Repuesto(Notificacion_Area_RepuestoDTO notificacion_area_RepuestoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_Area_Repuesto notificacion_Area_Repuesto = Notificacion_Area_RepuestoAssembler.getNotificacion_Area_Repuesto(notificacion_area_RepuestoDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(notificacion_Area_Repuesto);
			id=notificacion_Area_Repuesto.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarNotificacion_Area_Repuesto(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Notificacion_Area_Repuesto notificacion_Area_Repuesto =  Notificacion_Area_RepuestoAssembler.getNotificacion_Area_Repuesto(buscarNotificacion_Area_Repuesto(id));
			accesoBD.eliminar(notificacion_Area_Repuesto);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}		
	}

	@Override
	public void modificarNotificacion_Area_Repuesto(Long id,Notificacion_Area_RepuestoDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Notificacion_Area_Repuesto notificacion_Area_Repuesto =  Notificacion_Area_RepuestoAssembler.getNotificacion_Area_Repuesto(buscarNotificacion_Area_Repuesto(id));
			
			notificacion_Area_Repuesto.setConcretada_notificacion(modificado.getConcretada_notificacion());
			notificacion_Area_Repuesto.setTexto_notificacion(modificado.getTexto_notificacion());
			notificacion_Area_Repuesto.setFecha_notificacion(modificado.getFecha_notificacion());

			accesoBD.hacerPersistente(notificacion_Area_Repuesto);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<Notificacion_Area_RepuestoDTO> obtenerNotificacion_Area_Repuesto() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Notificacion_Area_RepuestoDTO> notificacionesDTO = new Vector<Notificacion_Area_RepuestoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Notificacion_Area_Repuesto> notificaciones= (Vector<Notificacion_Area_Repuesto>) accesoBD.buscarPorFiltro(Notificacion_Area_Repuesto.class,"id ascending");
			for(int i=0; i<notificaciones.size();i++){
				Notificacion_Area_RepuestoDTO notificacionDTO = new Notificacion_Area_RepuestoDTO();
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
	public Vector<Notificacion_Area_RepuestoDTO> obtenerNotificacion_Area_Repuesto(Boolean concretada_notificacion) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Notificacion_Area_RepuestoDTO> notificacionesDTO = new Vector<Notificacion_Area_RepuestoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_Area_RepuestoDTO> notificaciones = obtenerNotificacion_Area_Repuesto();
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
	public boolean existeNotificacion_Area_Repuesto(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Notificacion_Area_Repuesto) accesoBD.buscarPorId(Notificacion_Area_Repuesto.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existeNotificacion_Area_Repuesto(Notificacion_Area_RepuestoDTO notificacion_area_RepuestoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_Area_RepuestoDTO> notificacions = obtenerNotificacion_Area_Repuesto();
			for(int i=0; i<notificacions.size();i++){		
				if (notificacions.elementAt(i).getId().equals(notificacion_area_RepuestoDTO.getId())){
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
	public Notificacion_Area_RepuestoDTO buscarNotificacion_Area_Repuesto(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_Area_RepuestoDTO notificacionDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			notificacionDTO = Notificacion_Area_RepuestoAssembler.getNotificacion_Area_RepuestoDTO((Notificacion_Area_Repuesto) accesoBD.buscarPorId(Notificacion_Area_Repuesto.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return notificacionDTO;
	}

	@Override
	public Notificacion_Area_RepuestoDTO buscarNotificacion_Area_Repuesto(Notificacion_Area_RepuestoDTO notificacion_area_RepuestoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_Area_RepuestoDTO notificacionesDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_Area_RepuestoDTO> notificaciones = obtenerNotificacion_Area_Repuesto();
			for(int i=0; i<notificaciones.size();i++){		
				if (notificaciones.elementAt(i).getId().equals(notificacion_area_RepuestoDTO.getId())){
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
