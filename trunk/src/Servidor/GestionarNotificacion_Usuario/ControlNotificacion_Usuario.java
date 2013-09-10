package servidor.GestionarNotificacion_Usuario;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.NotificacionAssembler;
import servidor.assembler.Notificacion_UsuarioAssembler;
import servidor.assembler.UsuarioAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Notificacion;
import servidor.persistencia.dominio.Notificacion_Usuario;
import servidor.persistencia.dominio.Usuario;

import common.DTOs.NotificacionDTO;
import common.DTOs.Notificacion_UsuarioDTO;
import common.DTOs.UsuarioDTO;
import common.GestionarNotificacion_Usuario.IControlNotificacion_Usuario;

public class ControlNotificacion_Usuario extends UnicastRemoteObject implements IControlNotificacion_Usuario{

	private static final long serialVersionUID = 1L;

	protected ControlNotificacion_Usuario() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarNotificacion_Usuario(Notificacion_UsuarioDTO notificacion_usuarioDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_Usuario notificacion_Usuario = Notificacion_UsuarioAssembler.getNotificacion_Usuario(notificacion_usuarioDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(notificacion_Usuario);
			id=notificacion_Usuario.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarNotificacion_Usuario(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Notificacion_Usuario notificacion_Usuario = Notificacion_UsuarioAssembler.getNotificacion_Usuario(buscarNotificacion_Usuario(id));
			accesoBD.eliminar(notificacion_Usuario);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public void modificarNotificacion_Usuario(Long id, Notificacion_UsuarioDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Notificacion_Usuario notificacion_Usuario = Notificacion_UsuarioAssembler.getNotificacion_Usuario(buscarNotificacion_Usuario(id));
			notificacion_Usuario.setNotificacion(NotificacionAssembler.getNotificacion(modificado.getNotificacion()));
			notificacion_Usuario.setUsuario(UsuarioAssembler.getUsuario(modificado.getUsuario()));
			accesoBD.hacerPersistente(notificacion_Usuario);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<Notificacion_UsuarioDTO> obtenerNotificacion_Usuario() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Notificacion_UsuarioDTO> notificacion_UsuariosDTO = new Vector<Notificacion_UsuarioDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Notificacion_Usuario> notificacion_Usuarios = (Vector<Notificacion_Usuario>) accesoBD.buscarPorFiltro(Notificacion_Usuario.class,"id ascending");
			for(int i=0; i<notificacion_Usuarios.size();i++){
				Notificacion_UsuarioDTO notificacion_UsuarioDTO = new Notificacion_UsuarioDTO();
				notificacion_UsuarioDTO.setId(((Notificacion_Usuario)notificacion_Usuarios.elementAt(i)).getId());
				notificacion_UsuarioDTO.setNotificacion(NotificacionAssembler.getNotificacionDTO((Notificacion) notificacion_Usuarios.elementAt(i).getNotificacion()));
				notificacion_UsuarioDTO.setUsuario(UsuarioAssembler.getUsuarioDTO((Usuario) notificacion_Usuarios.elementAt(i).getUsuario()));
				notificacion_UsuariosDTO.add(notificacion_UsuarioDTO);
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return notificacion_UsuariosDTO;
	}

	@Override
	public Vector<Notificacion_UsuarioDTO> obtenerNotificacion_Usuario(UsuarioDTO usuarioDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Notificacion_UsuarioDTO> notificacion_UsuariosDTO = new Vector<Notificacion_UsuarioDTO>();
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_UsuarioDTO> notificaciones_UsuariosDTO = obtenerNotificacion_Usuario();
			for(int i=0; i<notificaciones_UsuariosDTO.size();i++){
				if (notificaciones_UsuariosDTO.elementAt(i).getUsuario().getId().equals(usuarioDTO.getId())){
					Notificacion_UsuarioDTO notificacion_UsuarioDTO = new Notificacion_UsuarioDTO();
					notificacion_UsuarioDTO.setId(notificaciones_UsuariosDTO.elementAt(i).getId());
					notificacion_UsuarioDTO.setNotificacion(notificaciones_UsuariosDTO.elementAt(i).getNotificacion());
					notificacion_UsuarioDTO.setUsuario(notificaciones_UsuariosDTO.elementAt(i).getUsuario());
					notificacion_UsuariosDTO.add(notificacion_UsuarioDTO);
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return notificacion_UsuariosDTO;
	}

	@Override
	public boolean existeNotificacion_Usuario(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Notificacion_Usuario) accesoBD.buscarPorId(Notificacion_Usuario.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existeNotificacion_Usuario(NotificacionDTO notificacionDTO, UsuarioDTO usuarioDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_UsuarioDTO> notificaciones_UsuariosDTO = obtenerNotificacion_Usuario();
				for(int i=0; i<notificaciones_UsuariosDTO.size();i++){
					if ((notificaciones_UsuariosDTO.elementAt(i)).getNotificacion().getId().equals(notificacionDTO.getId())&& (notificaciones_UsuariosDTO.elementAt(i)).getUsuario().getId().equals(usuarioDTO.getId())){
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
	public Notificacion_UsuarioDTO buscarNotificacion_Usuario(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_UsuarioDTO notificacion_UsuarioDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			notificacion_UsuarioDTO = Notificacion_UsuarioAssembler.getNotificacion_UsuarioDTO((Notificacion_Usuario) accesoBD.buscarPorId(Notificacion_Usuario.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return notificacion_UsuarioDTO;
	}

	@Override
	public Notificacion_UsuarioDTO buscarNotificacion_Usuario(NotificacionDTO notificacionDTO, UsuarioDTO usuarioDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Notificacion_UsuarioDTO notificacion_UsuarioDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Notificacion_UsuarioDTO> notificaciones_UsuariosDTO = obtenerNotificacion_Usuario();
				for(int i=0; i<notificaciones_UsuariosDTO.size();i++){
					if ((notificaciones_UsuariosDTO.elementAt(i)).getNotificacion().getId().equals(notificacionDTO.getId())&& (notificaciones_UsuariosDTO.elementAt(i)).getUsuario().getId().equals(usuarioDTO.getId())){
						notificacion_UsuarioDTO = notificaciones_UsuariosDTO.elementAt(i);
						break;
					}
				}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return notificacion_UsuarioDTO;
	}

}
