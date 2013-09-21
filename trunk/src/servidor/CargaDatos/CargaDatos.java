package servidor.CargaDatos;

import common.DTOs.EntidadDTO;
import common.DTOs.UsuarioDTO;
import servidor.SingletonConexion;
import servidor.GestionarEntidad.ControlEntidad;
import servidor.GestionarUsuario.ControlUsuario;
import servidor.persistencia.dominio.Usuario;

public class CargaDatos {

	
	
	public static void main(String[] args) {

		try {
			ControlUsuario controlUsuario =new ControlUsuario();

			// Creando, seteando e inicializando el Servidor
			SingletonConexion c = new SingletonConexion();
			
//			ControlMarca cmarca = new ControlMarca();
//			ControlModelo cmodelo = new ControlModelo();
//			
//			MarcaDTO marca = new MarcaDTO("Renault");
//			cmarca.agregarMarca(marca);
//			
//			marca = cmarca.buscarMarca("Renault");
//			ModeloDTO modelo = new ModeloDTO("Clio Mio", marca);
//			cmodelo.agregarModelo(modelo);
			
			//UsuarioDTO usuario = cusuario.buscarUsuario("admin");
			//ControlEntidad centidad = new ControlEntidad();
			
			ControlUsuario cusuario = new ControlUsuario();
			UsuarioDTO usuario = new UsuarioDTO("Admin", "it10", "matiasbernal.it10@gmail.com", "Administrador");
			Long id = cusuario.agregarUsuario(usuario);

			
			//usuario.setId(id);
			
			
			//EntidadDTO entidad = centidad.buscarEntidad("Nissan");
			//boolean res = centidad.existeEntidad(entidad.getId());
			//System.out.println(res);
			//marca = (cmarca.buscarMarca(marca.getNombre_marca()));
			//marca.setNombre_marca("Nissan");
			//cmarca.modificarMarca(marca.getId(), marca);
			
			//cmarca.eliminarMarca(marca.getId());
			System.exit(0);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
