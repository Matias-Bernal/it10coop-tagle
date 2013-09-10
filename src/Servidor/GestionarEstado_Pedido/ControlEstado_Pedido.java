package servidor.GestionarEstado_Pedido;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.Estado_PedidoAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Estado_Pedido;

import common.DTOs.Estado_PedidoDTO;
import common.GestionarEstado_Pedido.IControlEstado_Pedido;

public class ControlEstado_Pedido extends UnicastRemoteObject implements IControlEstado_Pedido{

	private static final long serialVersionUID = 1L;

	protected ControlEstado_Pedido() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
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
	}

	@Override
	public void eliminarEstado_Pedido(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Estado_Pedido estado_Pedido = Estado_PedidoAssembler.getEstado_Pedido(buscarEstado_Pedido(id));
			accesoBD.eliminar(estado_Pedido);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
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
	}

	@Override
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
	}

	@Override
	public boolean existeEstado_Pedido(Long id) throws Exception {
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
	}

	@Override
	public Estado_PedidoDTO buscarEstado_Pedido(Long id) throws Exception {
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
	}

}