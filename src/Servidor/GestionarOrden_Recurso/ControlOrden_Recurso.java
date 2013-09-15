package servidor.GestionarOrden_Recurso;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.Vector;

import servidor.assembler.OrdenAssembler;
import servidor.assembler.Orden_RecursoAssembler;
import servidor.assembler.RecursoAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Orden_Recurso;

import common.DTOs.OrdenDTO;
import common.DTOs.Orden_RecursoDTO;
import common.DTOs.RecursoDTO;
import common.GestionarOrden_Recurso.IControlOrden_Recurso;

public class ControlOrden_Recurso extends UnicastRemoteObject implements IControlOrden_Recurso {

	private static final long serialVersionUID = 1L;

	protected ControlOrden_Recurso() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarOrden_Recurso(Orden_RecursoDTO orden_RecursoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Long id = new Long(0);
		try {
			accesoBD.iniciarTransaccion();
			Orden_RecursoAssembler orden_RecursoAssem = new Orden_RecursoAssembler(accesoBD);
			Orden_Recurso orden_Recurso = orden_RecursoAssem.getOrden_RecursoNuevo(orden_RecursoDTO);
			accesoBD.hacerPersistente(orden_Recurso);
			id = orden_Recurso.getId();
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarOrden_Recurso(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Orden_RecursoAssembler orden_RecursoAssem = new Orden_RecursoAssembler(accesoBD);
			Orden_Recurso orden_Recurso = orden_RecursoAssem.getOrden_RecursoNuevo(buscarOrden_Recurso(id));			
			accesoBD.eliminar(orden_Recurso);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public void modificarOrden_Recurso(Long id, Orden_RecursoDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();

			Orden_RecursoAssembler orden_RecursoAssem = new Orden_RecursoAssembler(accesoBD);
			Orden_Recurso orden_Recurso = orden_RecursoAssem.getOrden_RecursoNuevo(buscarOrden_Recurso(id));
			
			OrdenAssembler ordenAssemb = new OrdenAssembler(accesoBD);
			orden_Recurso.setOrden(ordenAssemb.getOrden(modificado.getOrden()));
			RecursoAssembler recursoAssemb = new RecursoAssembler(accesoBD);
			orden_Recurso.setRecurso(recursoAssemb.getRecurso(modificado.getRecurso()));
			
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<Orden_RecursoDTO> obtenerOrdenes_Recursos() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Orden_RecursoDTO> ordenes_RecursosDTO = new Vector<Orden_RecursoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Orden_Recurso> ordenes_Recursos = (Vector<Orden_Recurso>) accesoBD.buscarPorFiltro(Orden_Recurso.class, "");
			for (int i = 0; i < ordenes_Recursos.size(); i++) {
				Orden_RecursoDTO orden_RecursoDTO = new Orden_RecursoDTO();
				
				orden_RecursoDTO.setId(ordenes_Recursos.elementAt(i).getId());
				OrdenAssembler ordenAssemb = new OrdenAssembler(accesoBD);
				orden_RecursoDTO.setOrden(ordenAssemb.getOrdenDTO(ordenes_Recursos.elementAt(i).getOrden()));
				RecursoAssembler recursoAssemb = new RecursoAssembler(accesoBD);
				orden_RecursoDTO.setRecurso(recursoAssemb.getRecursoDTO(ordenes_Recursos.elementAt(i).getRecurso()));
	
				ordenes_RecursosDTO.add(orden_RecursoDTO);
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return ordenes_RecursosDTO;
	}

	@Override
	public Vector<Orden_RecursoDTO> obtenerOrdenes_Recursos(OrdenDTO ordenDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Orden_RecursoDTO> ordenes_RecursosDTO = new Vector<Orden_RecursoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "orden.id == "+ordenDTO.getId();
			Collection movCol = accesoBD.buscarPorFiltro(Orden_Recurso.class, filtro);
			Orden_RecursoAssembler orden_RecursoAssem = new Orden_RecursoAssembler(accesoBD);
			for (int i = 0; i < movCol.size(); i++) {
				ordenes_RecursosDTO.add(orden_RecursoAssem.getOrden_RecursoDTO((Orden_Recurso)(movCol.toArray()[i])));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return ordenes_RecursosDTO;
	}

	@Override
	public Vector<Orden_RecursoDTO> obtenerOrdenes_Recursos(RecursoDTO recursoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Orden_RecursoDTO> ordenes_RecursosDTO = new Vector<Orden_RecursoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "recurso.id == "+recursoDTO.getId();
			Collection movCol = accesoBD.buscarPorFiltro(Orden_Recurso.class, filtro);
			Orden_RecursoAssembler orden_RecursoAssem = new Orden_RecursoAssembler(accesoBD);
			for (int i = 0; i < movCol.size(); i++) {
				ordenes_RecursosDTO.add(orden_RecursoAssem.getOrden_RecursoDTO((Orden_Recurso)(movCol.toArray()[i])));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return ordenes_RecursosDTO;
	}

	@Override
	public boolean existeOrden_Recurso(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Orden_Recurso) accesoBD.buscarPorId(Orden_Recurso.class, id) == null);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existeOrden_Recurso(OrdenDTO ordenDTO, RecursoDTO recursoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Collection movCol = null;
		try {
			accesoBD.iniciarTransaccion();
			
			String filtro = "orden.id == "+ordenDTO.getId()+ " && recurso.id == "+recursoDTO.getId();
			movCol = accesoBD.buscarPorFiltro(Orden_Recurso.class, filtro);
			
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return (movCol != null && movCol.size()>=1);
	}

	@Override
	public Orden_RecursoDTO buscarOrden_Recurso(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Orden_RecursoDTO orden_RecursoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Orden_RecursoAssembler orden_RecursoAssemb = new Orden_RecursoAssembler(accesoBD);
			orden_RecursoDTO = orden_RecursoAssemb.getOrden_RecursoDTO((Orden_Recurso) accesoBD.buscarPorId(Orden_Recurso.class, id));
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return orden_RecursoDTO;
	}

	@Override
	public Orden_RecursoDTO buscarOrden_Recurso(OrdenDTO ordenDTO, RecursoDTO recursoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Orden_RecursoDTO orden_RecursoDTO = null;
		try {
			accesoBD.iniciarTransaccion();

			String filtro = "orden.id == "+ordenDTO.getId()+ " && recurso.id == "+recursoDTO.getId();
			Collection movCol = accesoBD.buscarPorFiltro(Orden_Recurso.class, filtro);
			Orden_RecursoAssembler orden_RecursoAssemb = new Orden_RecursoAssembler(accesoBD);
			if (movCol.size()>=1 ) {
				orden_RecursoDTO = orden_RecursoAssemb.getOrden_RecursoDTO((Orden_Recurso)(movCol.toArray()[0]));
			}
			
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return orden_RecursoDTO;
	}

}
