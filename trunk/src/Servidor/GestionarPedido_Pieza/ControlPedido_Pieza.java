package servidor.GestionarPedido_Pieza;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.Vector;

import servidor.assembler.BdgAssembler;
import servidor.assembler.Devolucion_PiezaAssembler;
import servidor.assembler.Estado_PedidoAssembler;
import servidor.assembler.Mano_ObraAssembler;
import servidor.assembler.MuletoAssembler;
import servidor.assembler.PedidoAssembler;
import servidor.assembler.Pedido_PiezaAssembler;
import servidor.assembler.PiezaAssembler;
import servidor.assembler.RecursoAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Pedido_Pieza;

import common.DTOs.Estado_PedidoDTO;
import common.DTOs.PedidoDTO;
import common.DTOs.Pedido_PiezaDTO;
import common.DTOs.PiezaDTO;
import common.GestionarPedido_Pieza.IControlPedido_Pieza;

public class ControlPedido_Pieza  extends UnicastRemoteObject implements IControlPedido_Pieza{

	private static final long serialVersionUID = 1L;

	protected ControlPedido_Pieza() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarPedido_Pieza(Pedido_PiezaDTO pedido_PiezaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Pedido_Pieza pedido_Pieza = Pedido_PiezaAssembler.getPedido_Pieza(pedido_PiezaDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(pedido_Pieza);
			id=pedido_Pieza.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarPedido_Pieza(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Pedido_Pieza pedido_Pieza = Pedido_PiezaAssembler.getPedido_Pieza(buscarPedido_Pieza(id));
			accesoBD.eliminar(pedido_Pieza);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public void modificarPedido_Pieza(Long id, Pedido_PiezaDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Pedido_Pieza pedido_Pieza = Pedido_PiezaAssembler.getPedido_Pieza(buscarPedido_Pieza(id));
			
			pedido_Pieza.setPedido(PedidoAssembler.getPedido(modificado.getPedido()));
			pedido_Pieza.setPieza(PiezaAssembler.getPieza(modificado.getPieza()));
			pedido_Pieza.setStock(modificado.getStock());
			pedido_Pieza.setPropio(modificado.getPropio());
			pedido_Pieza.setMuleto(MuletoAssembler.getMuleto(modificado.getMuleto()));
			pedido_Pieza.setDevolucion_pieza(Devolucion_PiezaAssembler.getDevolucion_Pieza(modificado.getDevolucion_pieza()));
			pedido_Pieza.setEstado_pedido(Estado_PedidoAssembler.getEstado_Pedido(modificado.getEstado_pedido()));
			pedido_Pieza.setFecha_estado(modificado.getFecha_estado());
			pedido_Pieza.setBdg(BdgAssembler.getBdg(modificado.getBdg()));
			pedido_Pieza.setRecurso(RecursoAssembler.getRecurso(modificado.getRecurso()));
			pedido_Pieza.setMano_obra(Mano_ObraAssembler.getMano_Obra(modificado.getMano_obra()));
			
			accesoBD.hacerPersistente(pedido_Pieza);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<Pedido_PiezaDTO> obtenerPedido_Pieza() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Pedido_PiezaDTO> pedidos_PiezaDTO = new Vector<Pedido_PiezaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Pedido_Pieza> pedidos_Pieza = (Vector<Pedido_Pieza>) accesoBD.buscarPorFiltro(Pedido_Pieza.class,"id ascending");
			for(int i=0; i<pedidos_Pieza.size();i++){
				Pedido_PiezaDTO pedido_PiezaDTO = new Pedido_PiezaDTO();
				
				pedido_PiezaDTO.setId(((Pedido_Pieza)pedidos_Pieza.elementAt(i)).getId());
				pedido_PiezaDTO.setPedido(PedidoAssembler.getPedidoDTO(((Pedido_Pieza)pedidos_Pieza.elementAt(i)).getPedido()));
				pedido_PiezaDTO.setPieza(PiezaAssembler.getPiezaDTO(((Pedido_Pieza)pedidos_Pieza.elementAt(i)).getPieza()));
				pedido_PiezaDTO.setStock(((Pedido_Pieza)pedidos_Pieza.elementAt(i)).getStock());
				pedido_PiezaDTO.setPropio(((Pedido_Pieza)pedidos_Pieza.elementAt(i)).getPropio());
				pedido_PiezaDTO.setMuleto(MuletoAssembler.getMuletoDTO(((Pedido_Pieza)pedidos_Pieza.elementAt(i)).getMuleto()));
				pedido_PiezaDTO.setDevolucion_pieza(Devolucion_PiezaAssembler.getDevolucion_PiezaDTO(((Pedido_Pieza)pedidos_Pieza.elementAt(i)).getDevolucion_pieza()));
				pedido_PiezaDTO.setEstado_pedido(Estado_PedidoAssembler.getEstado_PedidoDTO(((Pedido_Pieza)pedidos_Pieza.elementAt(i)).getEstado_pedido()));
				pedido_PiezaDTO.setFecha_estado(((Pedido_Pieza)pedidos_Pieza.elementAt(i)).getFecha_estado());
				pedido_PiezaDTO.setBdg(BdgAssembler.getBdgDTO(((Pedido_Pieza)pedidos_Pieza.elementAt(i)).getBdg()));
				pedido_PiezaDTO.setRecurso(RecursoAssembler.getRecursoDTO(((Pedido_Pieza)pedidos_Pieza.elementAt(i)).getRecurso()));
				pedido_PiezaDTO.setMano_obra(Mano_ObraAssembler.getMano_ObraDTO(((Pedido_Pieza)pedidos_Pieza.elementAt(i)).getMano_obra()));
				
				pedidos_PiezaDTO.add(pedido_PiezaDTO);
				
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return pedidos_PiezaDTO;
	}

	@Override
	public Vector<Pedido_PiezaDTO> obtenerPedido_Pieza(Date fecha_estado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Pedido_PiezaDTO> pedidos_PiezaDTO = new Vector<Pedido_PiezaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Pedido_Pieza> pedidos_Pieza = (Vector<Pedido_Pieza>) accesoBD.buscarPorFiltro(Pedido_Pieza.class,"id ascending");
			for(int i=0; i<pedidos_Pieza.size();i++){
				if (pedidos_Pieza.elementAt(i).getFecha_estado().equals(fecha_estado)){
					Pedido_PiezaDTO pedido_PiezaDTO = new Pedido_PiezaDTO();
				
					pedido_PiezaDTO.setId(pedidos_Pieza.elementAt(i).getId());
					pedido_PiezaDTO.setPedido(PedidoAssembler.getPedidoDTO(pedidos_Pieza.elementAt(i).getPedido()));
					pedido_PiezaDTO.setPieza(PiezaAssembler.getPiezaDTO(pedidos_Pieza.elementAt(i).getPieza()));
					pedido_PiezaDTO.setStock(pedidos_Pieza.elementAt(i).getStock());
					pedido_PiezaDTO.setPropio(pedidos_Pieza.elementAt(i).getPropio());
					pedido_PiezaDTO.setMuleto(MuletoAssembler.getMuletoDTO(pedidos_Pieza.elementAt(i).getMuleto()));
					pedido_PiezaDTO.setDevolucion_pieza(Devolucion_PiezaAssembler.getDevolucion_PiezaDTO(pedidos_Pieza.elementAt(i).getDevolucion_pieza()));
					pedido_PiezaDTO.setEstado_pedido(Estado_PedidoAssembler.getEstado_PedidoDTO(pedidos_Pieza.elementAt(i).getEstado_pedido()));
					pedido_PiezaDTO.setFecha_estado(pedidos_Pieza.elementAt(i).getFecha_estado());
					pedido_PiezaDTO.setBdg(BdgAssembler.getBdgDTO(pedidos_Pieza.elementAt(i).getBdg()));
					pedido_PiezaDTO.setRecurso(RecursoAssembler.getRecursoDTO(pedidos_Pieza.elementAt(i).getRecurso()));
					pedido_PiezaDTO.setMano_obra(Mano_ObraAssembler.getMano_ObraDTO(pedidos_Pieza.elementAt(i).getMano_obra()));
					
					pedidos_PiezaDTO.add(pedido_PiezaDTO);
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return pedidos_PiezaDTO;
	}

	@Override
	public Vector<Pedido_PiezaDTO> obtenerPedido_Pieza(Estado_PedidoDTO estado_pedidoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Pedido_PiezaDTO> pedidos_PiezaDTO = new Vector<Pedido_PiezaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Pedido_Pieza> pedidos_Pieza = (Vector<Pedido_Pieza>) accesoBD.buscarPorFiltro(Pedido_Pieza.class,"id ascending");
			for(int i=0; i<pedidos_Pieza.size();i++){
				if (pedidos_Pieza.elementAt(i).getEstado_pedido().getEstado_pedido().equals(estado_pedidoDTO.getEstado_pedido())){
					Pedido_PiezaDTO pedido_PiezaDTO = new Pedido_PiezaDTO();
				
					pedido_PiezaDTO.setId(pedidos_Pieza.elementAt(i).getId());
					pedido_PiezaDTO.setPedido(PedidoAssembler.getPedidoDTO(pedidos_Pieza.elementAt(i).getPedido()));
					pedido_PiezaDTO.setPieza(PiezaAssembler.getPiezaDTO(pedidos_Pieza.elementAt(i).getPieza()));
					pedido_PiezaDTO.setStock(pedidos_Pieza.elementAt(i).getStock());
					pedido_PiezaDTO.setPropio(pedidos_Pieza.elementAt(i).getPropio());
					pedido_PiezaDTO.setMuleto(MuletoAssembler.getMuletoDTO(pedidos_Pieza.elementAt(i).getMuleto()));
					pedido_PiezaDTO.setDevolucion_pieza(Devolucion_PiezaAssembler.getDevolucion_PiezaDTO(pedidos_Pieza.elementAt(i).getDevolucion_pieza()));
					pedido_PiezaDTO.setEstado_pedido(Estado_PedidoAssembler.getEstado_PedidoDTO(pedidos_Pieza.elementAt(i).getEstado_pedido()));
					pedido_PiezaDTO.setFecha_estado(pedidos_Pieza.elementAt(i).getFecha_estado());
					pedido_PiezaDTO.setBdg(BdgAssembler.getBdgDTO(pedidos_Pieza.elementAt(i).getBdg()));
					pedido_PiezaDTO.setRecurso(RecursoAssembler.getRecursoDTO(pedidos_Pieza.elementAt(i).getRecurso()));
					pedido_PiezaDTO.setMano_obra(Mano_ObraAssembler.getMano_ObraDTO(pedidos_Pieza.elementAt(i).getMano_obra()));
					
					pedidos_PiezaDTO.add(pedido_PiezaDTO);
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return pedidos_PiezaDTO;
	}

	@Override
	public Vector<Pedido_PiezaDTO> obtenerPedido_Pieza(PedidoDTO pedidoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Pedido_PiezaDTO> pedidos_PiezaDTO = new Vector<Pedido_PiezaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Pedido_Pieza> pedidos_Pieza = (Vector<Pedido_Pieza>) accesoBD.buscarPorFiltro(Pedido_Pieza.class,"id ascending");
			for(int i=0; i<pedidos_Pieza.size();i++){
				if (pedidos_Pieza.elementAt(i).getPedido().getId().equals(pedidoDTO.getId())){
					Pedido_PiezaDTO pedido_PiezaDTO = new Pedido_PiezaDTO();
				
					pedido_PiezaDTO.setId(pedidos_Pieza.elementAt(i).getId());
					pedido_PiezaDTO.setPedido(PedidoAssembler.getPedidoDTO(pedidos_Pieza.elementAt(i).getPedido()));
					pedido_PiezaDTO.setPieza(PiezaAssembler.getPiezaDTO(pedidos_Pieza.elementAt(i).getPieza()));
					pedido_PiezaDTO.setStock(pedidos_Pieza.elementAt(i).getStock());
					pedido_PiezaDTO.setPropio(pedidos_Pieza.elementAt(i).getPropio());
					pedido_PiezaDTO.setMuleto(MuletoAssembler.getMuletoDTO(pedidos_Pieza.elementAt(i).getMuleto()));
					pedido_PiezaDTO.setDevolucion_pieza(Devolucion_PiezaAssembler.getDevolucion_PiezaDTO(pedidos_Pieza.elementAt(i).getDevolucion_pieza()));
					pedido_PiezaDTO.setEstado_pedido(Estado_PedidoAssembler.getEstado_PedidoDTO(pedidos_Pieza.elementAt(i).getEstado_pedido()));
					pedido_PiezaDTO.setFecha_estado(pedidos_Pieza.elementAt(i).getFecha_estado());
					pedido_PiezaDTO.setBdg(BdgAssembler.getBdgDTO(pedidos_Pieza.elementAt(i).getBdg()));
					pedido_PiezaDTO.setRecurso(RecursoAssembler.getRecursoDTO(pedidos_Pieza.elementAt(i).getRecurso()));
					pedido_PiezaDTO.setMano_obra(Mano_ObraAssembler.getMano_ObraDTO(pedidos_Pieza.elementAt(i).getMano_obra()));
					
					pedidos_PiezaDTO.add(pedido_PiezaDTO);
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return pedidos_PiezaDTO;
	}

	@Override
	public boolean existePedido_Pieza(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Pedido_Pieza) accesoBD.buscarPorId(Pedido_Pieza.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existePedido_Pieza(PedidoDTO pedidoDTO, PiezaDTO piezaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Pedido_PiezaDTO> pedidos_PiezaDTO = obtenerPedido_Pieza();
			for(int i=0; i<pedidos_PiezaDTO.size();i++){
				if (pedidos_PiezaDTO.elementAt(i).getPedido().getId().equals(pedidoDTO.getId()) && pedidos_PiezaDTO.elementAt(i).getPieza().getId().equals(piezaDTO.getId()) ){
					existe = true;
					break;
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public Pedido_PiezaDTO buscarPedido_Pieza(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Pedido_PiezaDTO pedido_PiezaDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			pedido_PiezaDTO = Pedido_PiezaAssembler.getPedido_PiezaDTO((Pedido_Pieza) accesoBD.buscarPorId(Pedido_Pieza.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return pedido_PiezaDTO;
	}

	@Override
	public Pedido_PiezaDTO buscarPedido_Pieza(PedidoDTO pedidoDTO, PiezaDTO piezaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Pedido_PiezaDTO pedido_PiezaDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Pedido_PiezaDTO> pedidos_PiezaDTO = obtenerPedido_Pieza();
			for(int i=0; i<pedidos_PiezaDTO.size();i++){
				if (pedidos_PiezaDTO.elementAt(i).getPedido().getId().equals(pedidoDTO.getId()) && pedidos_PiezaDTO.elementAt(i).getPieza().getId().equals(piezaDTO.getId()) ){
					pedido_PiezaDTO = pedidos_PiezaDTO.elementAt(i);
						break;
					}
				}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return pedido_PiezaDTO;
	}

}
