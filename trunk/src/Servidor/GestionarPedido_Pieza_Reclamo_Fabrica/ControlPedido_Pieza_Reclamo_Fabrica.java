package servidor.GestionarPedido_Pieza_Reclamo_Fabrica;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.PedidoAssembler;
import servidor.assembler.Pedido_Pieza_Reclamo_FabricaAssembler;
import servidor.assembler.PiezaAssembler;
import servidor.assembler.Reclamo_FabricaAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Pedido_Pieza_Reclamo_Fabrica;

import common.DTOs.PedidoDTO;
import common.DTOs.Pedido_Pieza_Reclamo_FabricaDTO;
import common.DTOs.PiezaDTO;
import common.DTOs.Reclamo_FabricaDTO;
import common.GestionarPedido_Pieza_Reclamo_Fabrica.IControlPedido_Pieza_Reclamo_Fabrica;

public class ControlPedido_Pieza_Reclamo_Fabrica extends UnicastRemoteObject implements IControlPedido_Pieza_Reclamo_Fabrica{

	private static final long serialVersionUID = 1L;

	protected ControlPedido_Pieza_Reclamo_Fabrica() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarPedido_Pieza_Reclamo_Fabrica(Pedido_Pieza_Reclamo_FabricaDTO pedido_Pieza_Reclamo_FabricaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Pedido_Pieza_Reclamo_Fabrica pedido_Pieza_Reclamo_Fabrica = Pedido_Pieza_Reclamo_FabricaAssembler.getPedido_Pieza_Reclamo_Fabrica(pedido_Pieza_Reclamo_FabricaDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(pedido_Pieza_Reclamo_Fabrica);
			id=pedido_Pieza_Reclamo_Fabrica.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarPedido_Pieza_Reclamo_Fabrica(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Pedido_Pieza_Reclamo_Fabrica pedido_Pieza_Reclamo_Fabrica = Pedido_Pieza_Reclamo_FabricaAssembler.getPedido_Pieza_Reclamo_Fabrica(buscarPedido_Pieza_Reclamo_Fabrica(id));
			accesoBD.eliminar(pedido_Pieza_Reclamo_Fabrica);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}		
	}

	@Override
	public void modificarPedido_Pieza_Reclamo_Fabrica(Long id, Pedido_Pieza_Reclamo_FabricaDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Pedido_Pieza_Reclamo_Fabrica pedido_Pieza_Reclamo_Fabrica = Pedido_Pieza_Reclamo_FabricaAssembler.getPedido_Pieza_Reclamo_Fabrica(buscarPedido_Pieza_Reclamo_Fabrica(id));
			
			pedido_Pieza_Reclamo_Fabrica.setPedido(PedidoAssembler.getPedido(modificado.getPedido()));
			pedido_Pieza_Reclamo_Fabrica.setPieza(PiezaAssembler.getPieza(modificado.getPieza()));
			pedido_Pieza_Reclamo_Fabrica.setReclamo_fabrica(Reclamo_FabricaAssembler.getReclamo_Fabrica(modificado.getReclamo_fabrica()));
			
			accesoBD.hacerPersistente(pedido_Pieza_Reclamo_Fabrica);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<Pedido_Pieza_Reclamo_FabricaDTO> obtenerPedido_Pieza_Reclamo_Fabrica() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Pedido_Pieza_Reclamo_FabricaDTO> pedidos_Pieza_Reclamo_FabricaDTO = new Vector<Pedido_Pieza_Reclamo_FabricaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Pedido_Pieza_Reclamo_Fabrica> pedidos_Pieza_Reclamo_Fabrica = (Vector<Pedido_Pieza_Reclamo_Fabrica>) accesoBD.buscarPorFiltro(Pedido_Pieza_Reclamo_Fabrica.class,"id ascending");
			for(int i=0; i<pedidos_Pieza_Reclamo_Fabrica.size();i++){
				
				Pedido_Pieza_Reclamo_FabricaDTO pedido_Pieza_Reclamo_FabricaDTO = new Pedido_Pieza_Reclamo_FabricaDTO();
				
				pedido_Pieza_Reclamo_FabricaDTO.setId(pedidos_Pieza_Reclamo_Fabrica.elementAt(i).getId());
				pedido_Pieza_Reclamo_FabricaDTO.setPedido(PedidoAssembler.getPedidoDTO(pedidos_Pieza_Reclamo_Fabrica.elementAt(i).getPedido()));
				pedido_Pieza_Reclamo_FabricaDTO.setPieza(PiezaAssembler.getPiezaDTO(pedidos_Pieza_Reclamo_Fabrica.elementAt(i).getPieza()));
				pedido_Pieza_Reclamo_FabricaDTO.setReclamo_fabrica(Reclamo_FabricaAssembler.getReclamo_FabricaDTO(pedidos_Pieza_Reclamo_Fabrica.elementAt(i).getReclamo_fabrica()));

				pedidos_Pieza_Reclamo_FabricaDTO.add(pedido_Pieza_Reclamo_FabricaDTO);
				
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return pedidos_Pieza_Reclamo_FabricaDTO;
	}

	@Override
	public Vector<Pedido_Pieza_Reclamo_FabricaDTO> obtenerPedido_Pieza_Reclamo_Fabrica(PiezaDTO piezaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Pedido_Pieza_Reclamo_FabricaDTO> pedidos_Pieza_Reclamo_FabricaDTO = new Vector<Pedido_Pieza_Reclamo_FabricaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Pedido_Pieza_Reclamo_Fabrica> pedidos_Pieza_Reclamo_Fabrica = (Vector<Pedido_Pieza_Reclamo_Fabrica>) accesoBD.buscarPorFiltro(Pedido_Pieza_Reclamo_Fabrica.class,"id ascending");
			for(int i=0; i<pedidos_Pieza_Reclamo_Fabrica.size();i++){
				if (pedidos_Pieza_Reclamo_Fabrica.elementAt(i).getPieza().getId().equals(piezaDTO.getId())){
					Pedido_Pieza_Reclamo_FabricaDTO pedido_Pieza_Reclamo_FabricaDTO = new Pedido_Pieza_Reclamo_FabricaDTO();
					
					pedido_Pieza_Reclamo_FabricaDTO.setId(pedidos_Pieza_Reclamo_Fabrica.elementAt(i).getId());
					pedido_Pieza_Reclamo_FabricaDTO.setPedido(PedidoAssembler.getPedidoDTO(pedidos_Pieza_Reclamo_Fabrica.elementAt(i).getPedido()));
					pedido_Pieza_Reclamo_FabricaDTO.setPieza(PiezaAssembler.getPiezaDTO(pedidos_Pieza_Reclamo_Fabrica.elementAt(i).getPieza()));
					pedido_Pieza_Reclamo_FabricaDTO.setReclamo_fabrica(Reclamo_FabricaAssembler.getReclamo_FabricaDTO(pedidos_Pieza_Reclamo_Fabrica.elementAt(i).getReclamo_fabrica()));
	
					pedidos_Pieza_Reclamo_FabricaDTO.add(pedido_Pieza_Reclamo_FabricaDTO);
				
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return pedidos_Pieza_Reclamo_FabricaDTO;
	}

	@Override
	public Vector<Pedido_Pieza_Reclamo_FabricaDTO> obtenerPedido_Pieza_Reclamo_Fabrica(PedidoDTO pedidoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Pedido_Pieza_Reclamo_FabricaDTO> pedidos_Pieza_Reclamo_FabricaDTO = new Vector<Pedido_Pieza_Reclamo_FabricaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Pedido_Pieza_Reclamo_Fabrica> pedidos_Pieza_Reclamo_Fabrica = (Vector<Pedido_Pieza_Reclamo_Fabrica>) accesoBD.buscarPorFiltro(Pedido_Pieza_Reclamo_Fabrica.class,"id ascending");
			for(int i=0; i<pedidos_Pieza_Reclamo_Fabrica.size();i++){
				if (pedidos_Pieza_Reclamo_Fabrica.elementAt(i).getPedido().getId().equals(pedidoDTO.getId())){
					Pedido_Pieza_Reclamo_FabricaDTO pedido_Pieza_Reclamo_FabricaDTO = new Pedido_Pieza_Reclamo_FabricaDTO();
					
					pedido_Pieza_Reclamo_FabricaDTO.setId(pedidos_Pieza_Reclamo_Fabrica.elementAt(i).getId());
					pedido_Pieza_Reclamo_FabricaDTO.setPedido(PedidoAssembler.getPedidoDTO(pedidos_Pieza_Reclamo_Fabrica.elementAt(i).getPedido()));
					pedido_Pieza_Reclamo_FabricaDTO.setPieza(PiezaAssembler.getPiezaDTO(pedidos_Pieza_Reclamo_Fabrica.elementAt(i).getPieza()));
					pedido_Pieza_Reclamo_FabricaDTO.setReclamo_fabrica(Reclamo_FabricaAssembler.getReclamo_FabricaDTO(pedidos_Pieza_Reclamo_Fabrica.elementAt(i).getReclamo_fabrica()));
	
					pedidos_Pieza_Reclamo_FabricaDTO.add(pedido_Pieza_Reclamo_FabricaDTO);
				
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return pedidos_Pieza_Reclamo_FabricaDTO;
	}

	@Override
	public boolean existePedido_Pieza_Reclamo_Fabrica(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Pedido_Pieza_Reclamo_Fabrica) accesoBD.buscarPorId(Pedido_Pieza_Reclamo_Fabrica.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existePedido_Pieza_Reclamo_Fabrica(PedidoDTO pedidoDTO, PiezaDTO piezaDTO, Reclamo_FabricaDTO reclamo_fabricaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Pedido_Pieza_Reclamo_FabricaDTO> pedidos_Pieza_Reclamo_FabricaDTO = obtenerPedido_Pieza_Reclamo_Fabrica();
			for(int i=0; i<pedidos_Pieza_Reclamo_FabricaDTO.size();i++){
				if (pedidos_Pieza_Reclamo_FabricaDTO.elementAt(i).getPedido().getId().equals(pedidoDTO.getId()) && pedidos_Pieza_Reclamo_FabricaDTO.elementAt(i).getPieza().getId().equals(piezaDTO.getId()) && pedidos_Pieza_Reclamo_FabricaDTO.elementAt(i).getReclamo_fabrica().getId().equals(reclamo_fabricaDTO.getId()) ){
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
	public Pedido_Pieza_Reclamo_FabricaDTO buscarPedido_Pieza_Reclamo_Fabrica(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Pedido_Pieza_Reclamo_FabricaDTO pedido_Pieza_Reclamo_FabricaDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			pedido_Pieza_Reclamo_FabricaDTO = Pedido_Pieza_Reclamo_FabricaAssembler.getPedido_Pieza_Reclamo_FabricaDTO((Pedido_Pieza_Reclamo_Fabrica) accesoBD.buscarPorId (Pedido_Pieza_Reclamo_Fabrica.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return pedido_Pieza_Reclamo_FabricaDTO;
	}

	@Override
	public Pedido_Pieza_Reclamo_FabricaDTO buscarPedido_Pieza_Reclamo_Fabrica(PedidoDTO pedidoDTO, PiezaDTO piezaDTO,Reclamo_FabricaDTO reclamo_fabricaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Pedido_Pieza_Reclamo_FabricaDTO pedido_Pieza_Reclamo_FabricaDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Pedido_Pieza_Reclamo_FabricaDTO> pedidos_Pieza_Reclamo_FabricaDTO = obtenerPedido_Pieza_Reclamo_Fabrica();
			for(int i=0; i<pedidos_Pieza_Reclamo_FabricaDTO.size();i++){
				if (pedidos_Pieza_Reclamo_FabricaDTO.elementAt(i).getPedido().getId().equals(pedidoDTO.getId()) && pedidos_Pieza_Reclamo_FabricaDTO.elementAt(i).getPieza().getId().equals(piezaDTO.getId()) && pedidos_Pieza_Reclamo_FabricaDTO.elementAt(i).getReclamo_fabrica().getId().equals(reclamo_fabricaDTO.getId()) ){
					pedido_Pieza_Reclamo_FabricaDTO = pedidos_Pieza_Reclamo_FabricaDTO.elementAt(i);
						break;
					}
				}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return pedido_Pieza_Reclamo_FabricaDTO;
	}

}