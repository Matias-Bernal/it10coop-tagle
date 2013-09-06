package servidor;

public class Main {
	
	public Main() {
		super();
	}
	
	public static void main(String[] args) {
		String conf = "";
		if ((args != null) && (args.length  > 0)) { 
			conf = args[0];
		}
		//common.RootAndIp.setConf(conf); 
		try {
			// Directorio donde estan las clases
			String classPath = "";//RootAndIp.getBase();

			// Controles que se publicaran
			//ControlFacturaCliente controlFacturaCliente =new ControlFacturaCliente();

		
			// Creando, seteando e inicializando el Servidor
			Servidor servidor = new Servidor();
			servidor.setClassPath(classPath);
			// Seteo de Controles en Servidor
			// servidor.setControlFacturaCliente(controlFacturaCliente);
			servidor.iniciar();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
