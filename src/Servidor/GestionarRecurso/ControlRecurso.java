package servidor.GestionarRecurso;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.Vector;

import common.DTOs.RecursoDTO;
import common.GestionarRecurso.IControlRecurso;

public class ControlRecurso extends UnicastRemoteObject implements
		IControlRecurso {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlRecurso() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarRecurso(RecursoDTO Recurso) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarRecurso(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarRecurso(Long id, RecursoDTO modificado)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector<RecursoDTO> obtenerRecursos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<RecursoDTO> obtenerRecursos(Date fecha_recurso)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeRecurso(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeRecurso(String numero_recurso) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RecursoDTO buscarRecurso(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecursoDTO buscarRecurso(String numero_recurso) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}