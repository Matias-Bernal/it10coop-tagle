package servidor;

import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
	
/*	private ControlAdminitr controlFacturaCliente =null;
	private ControlFacturaProveedor controlFacturaProveedor = null;
	private ControlKiosco controlKiosco =null;
	private ControlLocalidad controlLocalidad = null;
	private ControlMovimientoCaja controlMovimientoCaja =null;
	private ControlProducto controlProducto =null;
	private ControlProveedor controlProveedor =null;
	private ControlProvincia controlProvincia = null;
	private ControlUsuario controlUsuario =null;
	private ControlBecaAsignada controlBecaAsignada=null;
	private ControlSesion controlSesion =null;
	private ControlRealizarPlanillaES controlRealizarPlanillaES =null;*/
	private String classPath = "";
	private String name = "";
	private String ip = "";

	public Servidor(){}
	
	public void iniciar() throws Exception{
		Registry Naming =LocateRegistry.createRegistry(1099);
		System.setProperty("java.rmi.server.codebase", "file:" + this.classPath);
		System.out.println("Iniciando servidor !!!");
		
		this.ip=(InetAddress.getLocalHost().getHostAddress()).toString();//RootAndIp.getIp();
		System.out.println("Ip: " + this.ip);
		
		GUIServidor serv = new GUIServidor();
		serv.show();
	}

	public String getClassPath() {
		return classPath;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}