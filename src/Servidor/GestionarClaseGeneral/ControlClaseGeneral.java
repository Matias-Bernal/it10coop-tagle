package servidor.GestionarClaseGeneral;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.GestionarClaseGeneral.IControlClaseGeneral;


public class ControlClaseGeneral extends UnicastRemoteObject implements IControlClaseGeneral{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlClaseGeneral() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
