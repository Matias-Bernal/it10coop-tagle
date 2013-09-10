package servidor.GestionarBdg;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.Vector;

import servidor.assembler.BdgAssembler;
import servidor.assembler.PedidoAssembler;
import servidor.assembler.PiezaAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Bdg;

import common.DTOs.BdgDTO;
import common.DTOs.PedidoDTO;
import common.DTOs.PiezaDTO;
import common.GestionarBdg.IControlBdg;

public class ControlBdg extends UnicastRemoteObject implements IControlBdg {

	private static final long serialVersionUID = 1L;

	protected ControlBdg() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarBdg(BdgDTO bdgDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Bdg nuevoBdg = BdgAssembler.getBdg(bdgDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(nuevoBdg);
			id=nuevoBdg.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarBdg(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Bdg bdg = BdgAssembler.getBdg(buscarBdg(id));
			accesoBD.eliminar(bdg);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}		
	}

	@Override
	public void modificarBdg(Long id, BdgDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Bdg bdg = BdgAssembler.getBdg(buscarBdg(id));
			
			bdg.setFecha_bdg(modificado.getFecha_bdg());
			bdg.setPedido(PedidoAssembler.getPedido(modificado.getPedido()));
			bdg.setPieza(PiezaAssembler.getPieza(modificado.getPieza()));

			accesoBD.hacerPersistente(bdg);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<BdgDTO> obtenerBdgs() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<BdgDTO> bdgsDTO = new Vector<BdgDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Bdg> bdgs= (Vector<Bdg>) accesoBD.buscarPorFiltro(Bdg.class,"id ascending");
			for(int i=0; i<bdgs.size();i++){
				BdgDTO bdgDTO = new BdgDTO();
				bdgDTO.setId(((Bdg)bdgs.elementAt(i)).getId());
				bdgDTO.setFecha_bdg(((Bdg)bdgs.elementAt(i)).getFecha_bdg());
				bdgDTO.setPedido(PedidoAssembler.getPedidoDTO(((Bdg)bdgs.elementAt(i)).getPedido()));
				bdgDTO.setPieza(PiezaAssembler.getPiezaDTO(((Bdg)bdgs.elementAt(i)).getPieza()));
				bdgsDTO.add(bdgDTO);
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return bdgsDTO;
	}

	@Override
	public Vector<BdgDTO> obtenerBdgs(Date fecha_bdg) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<BdgDTO> bdgsDTO = new Vector<BdgDTO>();
		try {
			accesoBD.iniciarTransaccion();
			Vector<BdgDTO> bdgs = obtenerBdgs();
			for(int i=0; i<bdgs.size();i++){		
				if (bdgs.elementAt(i).getFecha_bdg().equals(fecha_bdg)){
					bdgsDTO.add(bdgs.elementAt(i));
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return bdgsDTO;
	}

	@Override
	public Vector<BdgDTO> obtenerBdgs(PiezaDTO pieza) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<BdgDTO> bdgsDTO = new Vector<BdgDTO>();
		try {
			accesoBD.iniciarTransaccion();
			Vector<BdgDTO> bdgs = obtenerBdgs();
			for(int i=0; i<bdgs.size();i++){		
				if (bdgs.elementAt(i).getPieza().getId().equals(pieza.getId())){
					bdgsDTO.add(bdgs.elementAt(i));
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return bdgsDTO;
	}

	@Override
	public Vector<BdgDTO> obtenerBdgs(PedidoDTO pedido) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<BdgDTO> bdgsDTO = new Vector<BdgDTO>();
		try {
			accesoBD.iniciarTransaccion();
			Vector<BdgDTO> bdgs = obtenerBdgs();
			for(int i=0; i<bdgs.size();i++){		
				if (bdgs.elementAt(i).getPedido().getId().equals(pedido.getId())){
					bdgsDTO.add(bdgs.elementAt(i));
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return bdgsDTO;
	}

	@Override
	public boolean existeBdg(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Bdg) accesoBD.buscarPorId(Bdg.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existeBdg(PiezaDTO pieza, PedidoDTO pedido) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<BdgDTO> bdgs = obtenerBdgs();
			for(int i=0; i<bdgs.size();i++){		
				if (bdgs.elementAt(i).getPedido().getId().equals(pedido.getId()) && (bdgs.elementAt(i).getPieza().getId().equals(pieza.getId()))){
					existe = true;
					break;
				}
			}
			accesoBD.concretarTransaccion();
		} finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existeBdg(Date fecha_bdg, PiezaDTO pieza, PedidoDTO pedido) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<BdgDTO> bdgs = obtenerBdgs();
			for(int i=0; i<bdgs.size();i++){		
				if (bdgs.elementAt(i).getFecha_bdg().equals(fecha_bdg) && bdgs.elementAt(i).getPedido().getId().equals(pedido.getId()) && (bdgs.elementAt(i).getPieza().getId().equals(pieza.getId()))){
					existe = true;
					break;
				}
			}
			accesoBD.concretarTransaccion();
		} finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public BdgDTO buscarBdg(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		BdgDTO bdgDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			bdgDTO = BdgAssembler.getBdgDTO((Bdg) accesoBD.buscarPorId(Bdg.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return bdgDTO;
	}

	@Override
	public BdgDTO buscarBdg(PiezaDTO pieza, PedidoDTO pedido) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		BdgDTO bdgDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<BdgDTO> bdgs = obtenerBdgs();
			for(int i=0; i<bdgs.size();i++){		
				if (bdgs.elementAt(i).getPedido().getId().equals(pedido.getId()) && (bdgs.elementAt(i).getPieza().getId().equals(pieza.getId()))){
					bdgDTO = bdgs.elementAt(i);
					break;
				}
			}
			accesoBD.concretarTransaccion();
		} finally{
			accesoBD.rollbackTransaccion();
		}
		return bdgDTO;
	}

	@Override
	public BdgDTO buscarBdg(Date fecha_bdg, PiezaDTO pieza, PedidoDTO pedido) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		BdgDTO bdgDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<BdgDTO> bdgs = obtenerBdgs();
			for(int i=0; i<bdgs.size();i++){		
				if (bdgs.elementAt(i).getFecha_bdg().equals(fecha_bdg) && bdgs.elementAt(i).getPedido().getId().equals(pedido.getId()) && (bdgs.elementAt(i).getPieza().getId().equals(pieza.getId()))){
					bdgDTO = bdgs.elementAt(i);
					break;
				}
			}
			accesoBD.concretarTransaccion();
		} finally{
			accesoBD.rollbackTransaccion();
		}
		return bdgDTO;
	}

}
