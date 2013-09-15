package servidor;

import common.DTOs.MarcaDTO;
import common.DTOs.ModeloDTO;
import common.DTOs.UsuarioDTO;

import java.util.ResourceBundle;
import java.util.Vector;

import servidor.GestionarMarca.ControlMarca;
import servidor.GestionarModelo.ControlModelo;
import servidor.GestionarNotificacion_Usuario.ControlNotificacion_Usuario;
import servidor.GestionarUsuario.ControlUsuario;
import servidor.persistencia.dominio.Usuario;

public class Main {

	public Main() {
		super();
	}

	public static void main(String[] args) {
		String conf = "";
		if ((args != null) && (args.length > 0)) {
			conf = args[0];
		}
		// common.RootAndIp.setConf(conf);
		try {
			// Directorio donde estan las clases
			String classPath = "";// RootAndIp.getBase();

			// Controles que se publicaran
			// ControlFacturaCliente controlFacturaCliente =new
			// ControlFacturaCliente();

			// Creando, seteando e inicializando el Servidor
			Servidor servidor = new Servidor();
			servidor.setClassPath(classPath);
			SingletonConexion c = new SingletonConexion();
			
			//ControlModelo cmodelo = new ControlModelo();
			ControlMarca cmarca = new ControlMarca();
			
			Vector<MarcaDTO> marcasDTO = cmarca.obtenerMarcas();
			
			for (int i=0; i < marcasDTO.size(); i++){
				System.out.println("MARCA: "+marcasDTO.elementAt(i).getNombre_marca());
			}
			System.in.read();
//			MarcaDTO marca = new MarcaDTO("Renaut");
//			Long id_marca = cmarca.agregarMarca(marca);
//			marca.setId(id_marca);
			
			//ModeloDTO modelo = new ModeloDTO("Falcon",marca);
			//cmodelo.agregarModelo(modelo);
			//cm.agregarMarca(marca);
			
			
			//marca = (cm.buscarMarca(marca.getNombre_marca()));
			//marca.setNombre_marca("Nissan");
			
			
			//cmarca.modificarMarca(marca.getId(), marca);
			//cmarca.eliminarMarca(marca.getId());

			// Seteo de Controles en Servidor
			// servidor.setControlFacturaCliente(controlFacturaCliente);
			//servidor.iniciar();
			System.exit(0);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}