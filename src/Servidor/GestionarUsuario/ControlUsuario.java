package servidor.GestionarUsuario;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.UsuarioAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Usuario;

import common.DTOs.UsuarioDTO;
import common.GestionarUsuario.IControlUsuario;

public class ControlUsuario extends UnicastRemoteObject implements IControlUsuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlUsuario() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarUsuario(UsuarioDTO usuarioDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Usuario nuevoUsuario = UsuarioAssembler.getUsuario(usuarioDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(nuevoUsuario);
			id=nuevoUsuario.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarUsuario(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Usuario usuario = UsuarioAssembler.getUsuario(buscarUsuario(id));
			accesoBD.eliminar(usuario);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public void modificarUsuario(Long id, UsuarioDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Usuario usuario = UsuarioAssembler.getUsuario(buscarUsuario(id));

			usuario.setNombre_usuario(modificado.getNombre_usuario());
			usuario.setClave(modificado.getClave());
			usuario.setEmail(modificado.getEmail());
			
			accesoBD.hacerPersistente(usuario);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<UsuarioDTO> obtenerUsuarios() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<UsuarioDTO> usuariosDTO = new Vector<UsuarioDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Usuario> Usuarios = (Vector<Usuario>) accesoBD.buscarPorFiltro(Usuario.class,"nombre_usuario ascending");
			for(int i=0; i<Usuarios.size();i++){
				UsuarioDTO usuarioDTO = new UsuarioDTO();
				usuarioDTO.setId(((Usuario)Usuarios.elementAt(i)).getId());
				usuarioDTO.setNombre_usuario(((Usuario)Usuarios.elementAt(i)).getNombre_usuario());
				usuarioDTO.setClave(((Usuario)Usuarios.elementAt(i)).getClave());
				usuarioDTO.setEmail(((Usuario)Usuarios.elementAt(i)).getEmail());
				usuariosDTO.add(usuarioDTO);
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return usuariosDTO;
	}

	@Override
	public boolean login(String nombre_usuario, String password) throws Exception {
		UsuarioDTO usuarioDTO = buscarUsuario(nombre_usuario);
		return (usuarioDTO.getClave().equals(password) && usuarioDTO != null);
	}

	@Override
	public boolean existeUsuario(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Usuario) accesoBD.buscarPorId(Usuario.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existeUsuario(String nombre_usuario) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<UsuarioDTO> usuariosDTO = obtenerUsuarios();
			for(int i=0; i<usuariosDTO.size();i++){
				if (((UsuarioDTO)usuariosDTO.elementAt(i)).getNombre_usuario().equals(nombre_usuario)){
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
	public UsuarioDTO buscarUsuario(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		UsuarioDTO usuarioDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			usuarioDTO = UsuarioAssembler.getUsuarioDTO((Usuario) accesoBD.buscarPorId(Usuario.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return usuarioDTO;
	}

	@Override
	public UsuarioDTO buscarUsuario(String nombre_usuario) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		UsuarioDTO usuarioDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<UsuarioDTO> usuariosDTO = obtenerUsuarios();
			for(int i=0; i<usuariosDTO.size();i++){
				if (((UsuarioDTO)usuariosDTO.elementAt(i)).getNombre_usuario().equals(nombre_usuario)){
					usuarioDTO = (UsuarioDTO)usuariosDTO.elementAt(i);
					break;
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return usuarioDTO;
	}

	
}