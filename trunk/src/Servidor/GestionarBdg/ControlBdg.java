package servidor.GestionarBdg;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.Collection;
import java.util.Vector;

<<<<<<< .mine
import servidor.assembler.BdgAssembler;
import servidor.assembler.PedidoAssembler;
import servidor.assembler.PiezaAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Agente;
import servidor.persistencia.dominio.Bdg;

=======
import servidor.assembler.BdgAssembler;
import servidor.assembler.PedidoAssembler;
import servidor.assembler.PiezaAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Bdg;

>>>>>>> .r18
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
<<<<<<< .mine
	public Long agregarBdg(BdgDTO bdgDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Long id = new Long(0);
		try {
			accesoBD.iniciarTransaccion();
			BdgAssembler bdgAssemb = new BdgAssembler(accesoBD);
			Bdg nuevoBdg = bdgAssemb.getBdgNuevo(bdgDTO);
			accesoBD.hacerPersistente(nuevoBdg);
			id = nuevoBdg.getId();
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return id;
=======
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
>>>>>>> .r18
	}

	@Override
	public void eliminarBdg(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			BdgAssembler bdgAssemb = new BdgAssembler(accesoBD);
			Bdg bdg = bdgAssemb.getBdg(buscarBdg(id));
			accesoBD.eliminar(bdg);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
=======
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Bdg bdg = BdgAssembler.getBdg(buscarBdg(id));
			accesoBD.eliminar(bdg);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}		
>>>>>>> .r18
	}

	@Override
	public void modificarBdg(Long id, BdgDTO modificado) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			BdgAssembler bdgAssemb = new BdgAssembler(accesoBD);
			Bdg bdg = bdgAssemb.getBdg(buscarBdg(id));
=======
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Bdg bdg = BdgAssembler.getBdg(buscarBdg(id));
			
			bdg.setFecha_bdg(modificado.getFecha_bdg());
			bdg.setPedido(PedidoAssembler.getPedido(modificado.getPedido()));
			bdg.setPieza(PiezaAssembler.getPieza(modificado.getPieza()));
>>>>>>> .r18

<<<<<<< .mine
			bdg.setFecha_bdg(modificado.getFecha_bdg());
			PedidoAssembler pedidoAssemb = new PedidoAssembler(accesoBD);
			bdg.setPedido(pedidoAssemb.getPedido(modificado.getPedido()));
			PiezaAssembler piezaAssemb = new PiezaAssembler(accesoBD);
			bdg.setPieza(piezaAssemb.getPieza(modificado.getPieza()));

			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
=======
			accesoBD.hacerPersistente(bdg);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Vector<BdgDTO> obtenerBdgs() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<BdgDTO> bdgsDTO = new Vector<BdgDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Bdg> bdgs = (Vector<Bdg>) accesoBD.buscarPorFiltro(Bdg.class, "");
			PedidoAssembler pedidoAssemb = new PedidoAssembler(accesoBD);
			PiezaAssembler piezaAssemb = new PiezaAssembler(accesoBD);
			for (int i = 0; i < bdgs.size(); i++) {
				BdgDTO bdgDTO = new BdgDTO();
				
				bdgDTO.setId(bdgs.elementAt(i).getId());
				bdgDTO.setFecha_bdg(bdgs.elementAt(i).getFecha_bdg());
				bdgDTO.setPedido(pedidoAssemb.getPedidoDTO(bdgs.elementAt(i).getPedido()));
				bdgDTO.setPieza(piezaAssemb.getPiezaDTO(bdgs.elementAt(i).getPieza()));
				
				bdgsDTO.add(bdgDTO);
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return bdgsDTO;
=======
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
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Vector<BdgDTO> obtenerBdgs(Date fecha_bdg) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<BdgDTO> bdgsDTO = new Vector<BdgDTO>();
		try {
			accesoBD.iniciarTransaccion();
			Collection bdgs =  accesoBD.obtenerObjetosFecha(Agente.class, fecha_bdg.getYear(),fecha_bdg.getMonth(), fecha_bdg.getDay());
			BdgAssembler bdgAssemb = new BdgAssembler(accesoBD);
			for (int i = 0; i < bdgs.size(); i++) {
				bdgsDTO.add(bdgAssemb.getBdgDTO((Bdg)(bdgs.toArray()[i])));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return bdgsDTO;
=======
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
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Vector<BdgDTO> obtenerBdgs(PiezaDTO pieza) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<BdgDTO> bdgsDTO = new Vector<BdgDTO>();
		try {
			accesoBD.iniciarTransaccion();

			String filtro = "pieza.id == "+pieza.getId();
			Collection bdgs = accesoBD.buscarPorFiltro(Bdg.class, filtro);
			BdgAssembler bdgAssemb = new BdgAssembler(accesoBD);
			for (int i = 0; i < bdgs.size(); i++) {
				bdgsDTO.add(bdgAssemb.getBdgDTO((Bdg)(bdgs.toArray()[i])));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return bdgsDTO;
=======
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
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Vector<BdgDTO> obtenerBdgs(PedidoDTO pedido) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<BdgDTO> bdgsDTO = new Vector<BdgDTO>();
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "pedido.id == "+pedido.getId();
			Collection bdgs = accesoBD.buscarPorFiltro(Bdg.class, filtro);
			BdgAssembler bdgAssemb = new BdgAssembler(accesoBD);
			for (int i = 0; i < bdgs.size(); i++) {
				bdgsDTO.add(bdgAssemb.getBdgDTO((Bdg)(bdgs.toArray()[i])));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return bdgsDTO;
=======
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
>>>>>>> .r18
	}

	@Override
	public boolean existeBdg(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Bdg) accesoBD.buscarPorId(Bdg.class, id) == null);
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
			existe = ((Bdg) accesoBD.buscarPorId(Bdg.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
>>>>>>> .r18
	}

	@Override
	public boolean existeBdg(PiezaDTO pieza, PedidoDTO pedido) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		Collection bdgs = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "pieza.id == "+pieza.getId()+" && pedido.id =="+ pedido.getId();
			bdgs = accesoBD.buscarPorFiltro(Bdg.class, filtro);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return (bdgs != null && bdgs.size()>=1);
=======
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
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public boolean existeBdg(Date fecha_bdg, PiezaDTO pieza, PedidoDTO pedido) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Collection bdgs = null;
		try {
			accesoBD.iniciarTransaccion();	
			String filtro = "pieza.id == "+pieza.getId()+" && pedido.id == "+pedido.getId()+" && fecha_bdg.getYear() == "+fecha_bdg.getYear()+" && fecha_bdg.getMonth() == "+fecha_bdg.getMonth()+" && fecha_bdg.getDay() == "+fecha_bdg.getDay();
			bdgs = accesoBD.buscarPorFiltro(Bdg.class, filtro);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return (bdgs != null && bdgs.size()>=1);
=======
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
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public BdgDTO buscarBdg(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		BdgDTO bdgDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			BdgAssembler bdgAssemb = new BdgAssembler(accesoBD);
			bdgDTO = bdgAssemb.getBdgDTO((Bdg) accesoBD.buscarPorId(Bdg.class, id));
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return bdgDTO;
=======
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
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public BdgDTO buscarBdg(PiezaDTO pieza, PedidoDTO pedido) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		BdgDTO bdgDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "pieza.id == "+pieza.getId()+" && pedido.id =="+ pedido.getId();
			Collection bdgs = accesoBD.buscarPorFiltro(Bdg.class, filtro);
			BdgAssembler bdgAssemb = new BdgAssembler(accesoBD);
			if (bdgs.size()>=1 ) {
				bdgDTO = bdgAssemb.getBdgDTO((Bdg)(bdgs.toArray()[0]));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return bdgDTO;
=======
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
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public BdgDTO buscarBdg(Date fecha_bdg, PiezaDTO pieza, PedidoDTO pedido) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		BdgDTO bdgDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "pieza.id == "+pieza.getId()+" && pedido.id == "+pedido.getId()+" && fecha_bdg.getYear() == "+fecha_bdg.getYear()+" && fecha_bdg.getMonth() == "+fecha_bdg.getMonth()+" && fecha_bdg.getDay() == "+fecha_bdg.getDay();
			Collection bdgs = accesoBD.buscarPorFiltro(Bdg.class, filtro);
			BdgAssembler bdgAssemb = new BdgAssembler(accesoBD);
			if (bdgs.size()>=1 ) {
				bdgDTO = bdgAssemb.getBdgDTO((Bdg)(bdgs.toArray()[0]));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return bdgDTO;
=======
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
>>>>>>> .r18
	}

}
