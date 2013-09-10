package servidor.GestionarNotificacion_Reclamo_Fabrica;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.Notificacion_Reclamo_FabricaAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Notificacion;
import servidor.persistencia.dominio.Notificacion_Reclamo_Fabrica;

import common.DTOs.Notificacion_Reclamo_FabricaDTO;
import common.GestionarNotificacion_Reclamo_Fabrica.IControlNotificacion_Reclamo_Fabrica;

public class ControlNotificacion_Reclamo_Fabrica extends UnicastRemoteObject implements IControlNotificacion_Reclamo_Fabrica {

	private static final long serialVersionUID = 1L;

	protected ControlNotificacion_Reclamo_Fabrica() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarNotificacion_Reclamo_Fabrica(Notificacion_Reclamo_FabricaDTO notificacion_Reclamo_FabricaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_Reclamo_Fabrica notificacion_Reclamo_Fabrica = Notificacion_Reclamo_FabricaAssembler.getNotificacion_Reclamo_Fabrica(notificacion_Reclamo_FabricaDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(notificacion_Reclamo_Fabrica);
			id=notificacion_Reclamo_Fabrica.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarNotificacion_Reclamo_Fabrica(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Notificacion_Reclamo_Fabrica notificacion_Reclamo_Fabrica =  Notificacion_Reclamo_FabricaAssembler.getNotificacion_Reclamo_Fabrica(buscarNotificacion_Reclamo_Fabrica(id));
			accesoBD.eliminar(notificacion_Reclamo_Fabrica);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}		
	}

	@Override
	public void modificarNotificacion_Reclamo_Fabrica(Long id,Notificacion_Reclamo_FabricaDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Notificacion_Reclamo_Fabrica notificacion_Reclamo_Fabrica =  Notificacion_Reclamo_FabricaAssembler.getNotificacion_Reclamo_Fabrica(buscarNotificacion_Reclamo_Fabrica(id));
			
			notificacion_Reclamo_Fabrica.setConcretada_notificacion(modificado.getConcretada_notificacion());
			notificacion_Reclamo_Fabrica.setTexto_notificacion(modificado.getTexto_notificacion());
			notificacion_Reclamo_Fabrica.setFecha_notificacion(modificado.getFecha_notificacion());

			accesoBD.hacerPersistente(notificacion_Reclamo_Fabrica);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<Notificacion_Reclamo_FabricaDTO> obtenerNotificacion_Reclamo_Fabrica() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Notificacion_Reclamo_FabricaDTO> notificacionesDTO = new Vector<Notificacion_Reclamo_FabricaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Notificacion_Reclamo_Fabrica> notificaciones= (Vector<Notificacion_Reclamo_Fabrica>) accesoBD.buscarPorFiltro(Notificacion_Reclamo_Fabrica.class,"id ascending");
			for(int i=0; i<notificaciones.size();i++){
				Notificacion_Reclamo_FabricaDTO notificacionDTO = new Notificacion_Reclamo_FabricaDTO();
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
	public Vector<Notificacion_Reclamo_FabricaDTO> obtenerNotificacion_Reclamo_Fabrica(Boolean concretada_notificacion) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Notificacion_Reclamo_FabricaDTO> notificacionesDTO = new Vector<Notificacion_Reclamo_FabricaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_Reclamo_FabricaDTO> notificaciones = obtenerNotificacion_Reclamo_Fabrica();
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
	public boolean existeNotificacion_Reclamo_Fabrica(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Notificacion_Reclamo_Fabrica) accesoBD.buscarPorId(Notificacion_Reclamo_Fabrica.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existeNotificacion_Reclamo_Fabrica(Notificacion_Reclamo_FabricaDTO notificacion_Reclamo_FabricaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_Reclamo_FabricaDTO> notificacions = obtenerNotificacion_Reclamo_Fabrica();
			for(int i=0; i<notificacions.size();i++){		
				if (notificacions.elementAt(i).getId().equals(notificacion_Reclamo_FabricaDTO.getId())){
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
	public Notificacion_Reclamo_FabricaDTO buscarNotificacion_Reclamo_Fabrica(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_Reclamo_FabricaDTO notificacionDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			notificacionDTO = Notificacion_Reclamo_FabricaAssembler.getNotificacion_Reclamo_FabricaDTO((Notificacion_Reclamo_Fabrica) accesoBD.buscarPorId(Notificacion_Reclamo_Fabrica.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return notificacionDTO;
	}

	@Override
	public Notificacion_Reclamo_FabricaDTO buscarNotificacion_Reclamo_Fabrica(Notificacion_Reclamo_FabricaDTO notificacion_Reclamo_FabricaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_Reclamo_FabricaDTO notificacionesDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_Reclamo_FabricaDTO> notificaciones = obtenerNotificacion_Reclamo_Fabrica();
			for(int i=0; i<notificaciones.size();i++){		
				if (notificaciones.elementAt(i).getId().equals(notificacion_Reclamo_FabricaDTO.getId())){
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