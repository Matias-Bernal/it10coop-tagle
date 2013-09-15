package servidor.GestionarUsuario;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

<<<<<<< .mine
import servidor.assembler.UsuarioAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Usuario;
=======
import servidor.assembler.UsuarioAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Usuario;

>>>>>>> .r18
import common.DTOs.UsuarioDTO;
import common.GestionarUsuario.IControlUsuario;

public class ControlUsuario extends UnicastRemoteObject implements IControlUsuario {
	
	private static final long serialVersionUID = 1L;

	public ControlUsuario() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
<<<<<<< .mine
	public Long agregarUsuario(UsuarioDTO usuarioDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Usuario nuevoUsuario = UsuarioAssembler.getUsuario(usuarioDTO);
		Long id = new Long(0);
		try {
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(nuevoUsuario);
			id = nuevoUsuario.getId();
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			System.out.println("ERRROOORRR se rompio todo guaso");
			accesoBD.rollbackTransaccion();
		}
		return id;
=======
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
>>>>>>> .r18
	}

	@Override
	public void eliminarUsuario(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Usuario usuario = UsuarioAssembler.getUsuario(buscarUsuario(id));
			accesoBD.eliminar(usuario);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
=======
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Usuario usuario = UsuarioAssembler.getUsuario(buscarUsuario(id));
			accesoBD.eliminar(usuario);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public void modificarUsuario(Long id, UsuarioDTO modificado)
			throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Usuario usuario = UsuarioAssembler.getUsuario(buscarUsuario(id));

			usuario.setNombre_usuario(modificado.getNombre_usuario());
			usuario.setClave(modificado.getClave());
			usuario.setEmail(modificado.getEmail());
			usuario.setTipo(modificado.getTipo());

			accesoBD.hacerPersistente(usuario);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
=======
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
>>>>>>> .r18
	}

	@Override
	public Vector<UsuarioDTO> obtenerUsuarios() throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		Vector<UsuarioDTO> usuariosDTO = new Vector<UsuarioDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Usuario> Usuarios = (Vector<Usuario>) accesoBD.buscarPorFiltro(Usuario.class, "id ascending");
			for (int i = 0; i < Usuarios.size(); i++) {
				UsuarioDTO usuarioDTO = new UsuarioDTO();
				usuarioDTO.setId(Usuarios.elementAt(i).getId());
				usuarioDTO.setNombre_usuario(Usuarios.elementAt(i).getNombre_usuario());
				usuarioDTO.setClave(Usuarios.elementAt(i).getClave());
				usuarioDTO.setEmail(Usuarios.elementAt(i).getEmail());
				usuarioDTO.setTipo(Usuarios.elementAt(i).getTipo());
				usuariosDTO.add(usuarioDTO);
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return usuariosDTO;
=======
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
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public boolean login(String nombre_usuario, String password)
			throws Exception {
		UsuarioDTO usuarioDTO = buscarUsuario(nombre_usuario);
		return (usuarioDTO.getClave().equals(password) && usuarioDTO != null);
=======
	public boolean login(String nombre_usuario, String password) throws Exception {
		UsuarioDTO usuarioDTO = buscarUsuario(nombre_usuario);
		return (usuarioDTO.getClave().equals(password) && usuarioDTO != null);
>>>>>>> .r18
	}

	@Override
	public boolean existeUsuario(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		Boolean existe = null;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Usuario) accesoBD.buscarPorId(Usuario.class, id) == null);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return existe;
=======
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
>>>>>>> .r18
	}

	@Override
	public boolean existeUsuario(String nombre_usuario) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<UsuarioDTO> usuariosDTO = obtenerUsuarios();
			for (int i = 0; i < usuariosDTO.size(); i++) {
				if (((UsuarioDTO) usuariosDTO.elementAt(i)).getNombre_usuario().equals(nombre_usuario)) {
					existe = true;
					break;
				}
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return existe;
=======
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
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public UsuarioDTO buscarUsuario(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		UsuarioDTO usuarioDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			usuarioDTO = UsuarioAssembler.getUsuarioDTO((Usuario) accesoBD.buscarPorId(Usuario.class, id));
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return usuarioDTO;
=======
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
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public UsuarioDTO buscarUsuario(String nombre_usuario) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		UsuarioDTO usuarioDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<UsuarioDTO> usuariosDTO = obtenerUsuarios();
			for (int i = 0; i < usuariosDTO.size(); i++) {
				if (((UsuarioDTO) usuariosDTO.elementAt(i)).getNombre_usuario().equals(nombre_usuario)) {
					usuarioDTO = (UsuarioDTO) usuariosDTO.elementAt(i);
					break;
				}
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return usuarioDTO;
=======
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
>>>>>>> .r18
	}

<<<<<<< .mine
	@Override
	public Vector<UsuarioDTO> obtenerUsuarios(String tipo) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<UsuarioDTO> usuariosDTO = new Vector<UsuarioDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Usuario> Usuarios = (Vector<Usuario>) accesoBD.buscarPorFiltro(Usuario.class, "id ascending");
			for (int i = 0; i < Usuarios.size(); i++) {
				if (Usuarios.elementAt(i).getTipo().equals(tipo)) {
					UsuarioDTO usuarioDTO = new UsuarioDTO();
					usuarioDTO.setId(((Usuario) Usuarios.elementAt(i)).getId());
					usuarioDTO.setNombre_usuario(((Usuario) Usuarios.elementAt(i)).getNombre_usuario());
					usuarioDTO.setClave(((Usuario) Usuarios.elementAt(i)).getClave());
					usuarioDTO.setEmail(((Usuario) Usuarios.elementAt(i)).getEmail());
					usuarioDTO.setTipo(tipo);
					usuariosDTO.add(usuarioDTO);
				}
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return usuariosDTO;
	}

=======
>>>>>>> .r18
}