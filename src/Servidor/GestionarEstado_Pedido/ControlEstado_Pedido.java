package servidor.GestionarEstado_Pedido;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.Vector;

import servidor.assembler.Estado_PedidoAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Estado_Pedido;

import common.DTOs.Estado_PedidoDTO;
import common.GestionarEstado_Pedido.IControlEstado_Pedido;

public class ControlEstado_Pedido extends UnicastRemoteObject implements IControlEstado_Pedido {

	private static final long serialVersionUID = 1L;

	protected ControlEstado_Pedido() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
<<<<<<< .mine
	public Long agregarEstado_Pedido(Estado_PedidoDTO estado_pedidoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Long id = new Long(0);
		try {
			accesoBD.iniciarTransaccion();
			Estado_PedidoAssembler estado_pedidoAssemb = new Estado_PedidoAssembler(accesoBD);
			Estado_Pedido estado_Pedido = estado_pedidoAssemb.getEstado_PedidoNuevo(estado_pedidoDTO);
			accesoBD.hacerPersistente(estado_Pedido);
			id = estado_Pedido.getId();
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return id;
=======
	public Long agregarEstado_Pedido(Estado_PedidoDTO estado_pedidoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Estado_Pedido estado_Pedido = Estado_PedidoAssembler.getEstado_Pedido(estado_pedidoDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(estado_Pedido);
			id=estado_Pedido.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
>>>>>>> .r18
	}

	@Override
	public void eliminarEstado_Pedido(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Estado_PedidoAssembler estado_pedidoAssemb = new Estado_PedidoAssembler(accesoBD);
			Estado_Pedido estado_Pedido = estado_pedidoAssemb.getEstado_Pedido(buscarEstado_Pedido(id));
			accesoBD.eliminar(estado_Pedido);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
=======
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Estado_Pedido estado_Pedido = Estado_PedidoAssembler.getEstado_Pedido(buscarEstado_Pedido(id));
			accesoBD.eliminar(estado_Pedido);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public void modificarEstado_Pedido(Long id, Estado_PedidoDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Estado_PedidoAssembler estado_pedidoAssemb = new Estado_PedidoAssembler(accesoBD);
			Estado_Pedido estado_Pedido = estado_pedidoAssemb.getEstado_Pedido(buscarEstado_Pedido(id));
			estado_Pedido.setEstado_pedido(modificado.getEstado_pedido());
=======
	public void modificarEstado_Pedido(Long id, Estado_PedidoDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Estado_Pedido estado_Pedido = Estado_PedidoAssembler.getEstado_Pedido(buscarEstado_Pedido(id));
			estado_Pedido.setEstado_pedido(modificado.getEstado_pedido());
			accesoBD.hacerPersistente(estado_Pedido);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}
>>>>>>> .r18

<<<<<<< .mine
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
=======
	@Override
	public Vector<Estado_PedidoDTO> obtenerEstado_Pedido() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Estado_PedidoDTO> estado_PedidosDTO = new Vector<Estado_PedidoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Estado_Pedido> estado_Pedidos= (Vector<Estado_Pedido>) accesoBD.buscarPorFiltro(Estado_Pedido.class,"nombre_registrante ascending");
			for(int i=0; i<estado_Pedidos.size();i++){
				Estado_PedidoDTO estado_PedidoDTO = new Estado_PedidoDTO();
				estado_PedidoDTO.setId(((Estado_Pedido)estado_Pedidos.elementAt(i)).getId());
				estado_PedidoDTO.setEstado_pedido(((Estado_Pedido)estado_Pedidos.elementAt(i)).getEstado_pedido());
				estado_PedidosDTO.add(estado_PedidoDTO);
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return estado_PedidosDTO;
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Vector<Estado_PedidoDTO> obtenerEstado_Pedido() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Estado_PedidoDTO> estado_PedidosDTO = new Vector<Estado_PedidoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Estado_Pedido> estado_Pedidos = (Vector<Estado_Pedido>) accesoBD.buscarPorFiltro(Estado_Pedido.class,"");
			for (int i = 0; i < estado_Pedidos.size(); i++) {
				Estado_PedidoDTO estado_PedidoDTO = new Estado_PedidoDTO();
				estado_PedidoDTO.setId(estado_Pedidos.elementAt(i).getId());
				estado_PedidoDTO.setEstado_pedido(estado_Pedidos.elementAt(i).getEstado_pedido());
				estado_PedidosDTO.add(estado_PedidoDTO);
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return estado_PedidosDTO;
	}

	@Override
	public Vector<Estado_PedidoDTO> obtenerEstado_Pedido(String estado_pedido) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Estado_PedidoDTO> estado_PedidosDTO = new Vector<Estado_PedidoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "estado_pedido.equals(\""+estado_pedido+"\")";
			Collection movCol = accesoBD.buscarPorFiltro(Estado_Pedido.class, filtro);
			Estado_PedidoAssembler estado_pedidoAssemb = new Estado_PedidoAssembler(accesoBD);
			for (int i = 0; i < movCol.size(); i++) {
				estado_PedidosDTO.add(estado_pedidoAssemb.getEstado_PedidoDTO((Estado_Pedido)(movCol.toArray())[i]));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return estado_PedidosDTO;
=======
	public Vector<Estado_PedidoDTO> obtenerEstado_Pedido(String estado_pedido) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Estado_PedidoDTO> estado_PedidosDTO = new Vector<Estado_PedidoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Estado_Pedido> estado_Pedidos= (Vector<Estado_Pedido>) accesoBD.buscarPorFiltro(Estado_Pedido.class,"nombre_registrante ascending");
			for(int i=0; i<estado_Pedidos.size();i++){
				if (((Estado_Pedido)estado_Pedidos.elementAt(i)).getEstado_pedido().equals(estado_pedido)){
					Estado_PedidoDTO estado_PedidoDTO = new Estado_PedidoDTO();
					estado_PedidoDTO.setId(((Estado_Pedido)estado_Pedidos.elementAt(i)).getId());
					estado_PedidoDTO.setEstado_pedido(((Estado_Pedido)estado_Pedidos.elementAt(i)).getEstado_pedido());
					estado_PedidosDTO.add(estado_PedidoDTO);
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return estado_PedidosDTO;
>>>>>>> .r18
	}

	@Override
	public boolean existeEstado_Pedido(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Estado_Pedido) accesoBD.buscarPorId(Estado_Pedido.class,id) == null);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return existe;
=======
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Estado_Pedido) accesoBD.buscarPorId(Estado_Pedido.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
>>>>>>> .r18
	}

	@Override
	public Estado_PedidoDTO buscarEstado_Pedido(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		Estado_PedidoDTO estado_PedidoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Estado_PedidoAssembler estado_pedidoAssemb = new Estado_PedidoAssembler(accesoBD);
			estado_PedidoDTO = estado_pedidoAssemb.getEstado_PedidoDTO((Estado_Pedido) accesoBD.buscarPorId(Estado_Pedido.class, id));
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return estado_PedidoDTO;
=======
		AccesoBD accesoBD = new AccesoBD();
		Estado_PedidoDTO estado_PedidoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			estado_PedidoDTO = Estado_PedidoAssembler.getEstado_PedidoDTO((Estado_Pedido) accesoBD.buscarPorId(Estado_Pedido.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return estado_PedidoDTO;
>>>>>>> .r18
	}

}