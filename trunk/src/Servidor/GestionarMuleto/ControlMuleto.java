package servidor.GestionarMuleto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.Vector;

<<<<<<< .mine
import servidor.assembler.BdgAssembler;
import servidor.assembler.Mano_ObraAssembler;
import servidor.assembler.MuletoAssembler;
import servidor.assembler.PedidoAssembler;
import servidor.assembler.PiezaAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Bdg;
import servidor.persistencia.dominio.Mano_Obra;
import servidor.persistencia.dominio.Muleto;
=======
import servidor.assembler.MuletoAssembler;
import servidor.assembler.PedidoAssembler;
import servidor.assembler.PiezaAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Muleto;

>>>>>>> .r18
import common.DTOs.MuletoDTO;
import common.DTOs.PedidoDTO;
import common.DTOs.PiezaDTO;
import common.GestionarMuleto.IControlMuleto;

public class ControlMuleto extends UnicastRemoteObject implements
		IControlMuleto {

	private static final long serialVersionUID = 1L;

	protected ControlMuleto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
<<<<<<< .mine
	public Long agregarMuleto(MuletoDTO muletoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Long id = new Long(0);
		try {
			accesoBD.iniciarTransaccion();
			MuletoAssembler muletoAssemb = new MuletoAssembler(accesoBD);
			Muleto muleto = muletoAssemb.getMuletoNuevo(muletoDTO);
			accesoBD.hacerPersistente(muleto);
			id = muleto.getId();
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return id;
=======
	public Long agregarMuleto(MuletoDTO muletoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Muleto muleto = MuletoAssembler.getMuleto(muletoDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(muleto);
			id=muleto.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
>>>>>>> .r18
	}

	@Override
	public void eliminarMuleto(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			MuletoAssembler muletoAssemb = new MuletoAssembler(accesoBD);
			Muleto muleto = muletoAssemb.getMuleto(buscarMuleto(id));
			accesoBD.eliminar(muleto);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
=======
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Muleto muleto = MuletoAssembler.getMuleto(buscarMuleto(id));
			accesoBD.eliminar(muleto);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}	
>>>>>>> .r18
	}

	@Override
	public void modificarMuleto(Long id, MuletoDTO modificado) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			MuletoAssembler muletoAssemb = new MuletoAssembler(accesoBD);
			Muleto muleto = muletoAssemb.getMuleto(buscarMuleto(id));
=======
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Muleto muleto = MuletoAssembler.getMuleto(buscarMuleto(id));
			
			muleto.setVin(modificado.getVin());
			muleto.setDescripcion(modificado.getDescripcion());
			muleto.setPedido(PedidoAssembler.getPedido(modificado.getPedido()));
			muleto.setPieza(PiezaAssembler.getPieza(modificado.getPieza()));
>>>>>>> .r18

<<<<<<< .mine
			muleto.setVin(modificado.getVin());
			muleto.setDescripcion(modificado.getDescripcion());
			PedidoAssembler pedidoAssemb = new PedidoAssembler(accesoBD);
			muleto.setPedido(pedidoAssemb.getPedido(modificado.getPedido()));
			PiezaAssembler piezaAssemb = new PiezaAssembler(accesoBD);
			muleto.setPieza(piezaAssemb.getPieza(modificado.getPieza()));

			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
=======
			accesoBD.hacerPersistente(muleto);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Vector<MuletoDTO> obtenerMuleto() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<MuletoDTO> muletosDTO = new Vector<MuletoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Muleto> muletos = (Vector<Muleto>) accesoBD.buscarPorFiltro(Muleto.class, "");
			for (int i = 0; i < muletos.size(); i++) {
				MuletoDTO muletoDTO = new MuletoDTO();
				muletoDTO.setId(muletos.elementAt(i).getId());
				muletoDTO.setVin(muletos.elementAt(i).getVin());
				muletoDTO.setDescripcion(muletos.elementAt(i).getDescripcion());
				PedidoAssembler pedidoAssemb = new PedidoAssembler(accesoBD);
				muletoDTO.setPedido(pedidoAssemb.getPedidoDTO(muletos.elementAt(i).getPedido()));
				PiezaAssembler piezaAssembler = new PiezaAssembler(accesoBD);
				muletoDTO.setPieza(piezaAssembler.getPiezaDTO(muletos.elementAt(i).getPieza()));
				muletosDTO.add(muletoDTO);
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return muletosDTO;
=======
	public Vector<MuletoDTO> obtenerMuleto() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<MuletoDTO> muletosDTO = new Vector<MuletoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Muleto> muletos= (Vector<Muleto>) accesoBD.buscarPorFiltro(Muleto.class,"id ascending");
			for(int i=0; i<muletos.size();i++){
				MuletoDTO muletoDTO = new MuletoDTO();
				muletoDTO.setId(((Muleto)muletos.elementAt(i)).getId());
				muletoDTO.setVin(((Muleto)muletos.elementAt(i)).getVin());
				muletoDTO.setDescripcion(((Muleto)muletos.elementAt(i)).getDescripcion());
				muletoDTO.setPedido(PedidoAssembler.getPedidoDTO(((Muleto)muletos.elementAt(i)).getPedido()));
				muletoDTO.setPieza(PiezaAssembler.getPiezaDTO(((Muleto)muletos.elementAt(i)).getPieza()));
				muletosDTO.add(muletoDTO);
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return muletosDTO;
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Vector<MuletoDTO> obtenerMuleto(PedidoDTO pedidoDTO)
			throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<MuletoDTO> muletosDTO = new Vector<MuletoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "pedido.id =="+pedidoDTO.getId();
			Collection movCol = accesoBD.buscarPorFiltro(Muleto.class, filtro);
			MuletoAssembler muletoAssemb = new MuletoAssembler(accesoBD);
			for (int i = 0; i < movCol.size(); i++) {
				muletosDTO.add(muletoAssemb.getMuletoDTO((Muleto)(movCol.toArray())[i]));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return muletosDTO;
=======
	public Vector<MuletoDTO> obtenerMuleto(PedidoDTO pedidoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<MuletoDTO> muletosDTO = new Vector<MuletoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			Vector<MuletoDTO> muletos = obtenerMuleto();
			for(int i=0; i<muletos.size();i++){		
				if (muletos.elementAt(i).getPedido().getId().equals(pedidoDTO.getId())){
					muletosDTO.add(muletos.elementAt(i));
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return muletosDTO;
>>>>>>> .r18
	}

	@Override
	public boolean existeMuleto(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Muleto) accesoBD.buscarPorId(Muleto.class, id) == null);
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
			existe = ((Muleto) accesoBD.buscarPorId(Muleto.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public boolean existeMuleto(PedidoDTO pedidoDTO, PiezaDTO piezaDTO)	throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Collection movCol = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "pedido.id =="+pedidoDTO.getId()+" && pieza.id == "+piezaDTO.getId();
			movCol = accesoBD.buscarPorFiltro(Muleto.class, filtro);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return (movCol != null && movCol.size()>=1);
=======
	public boolean existeMuleto(PedidoDTO pedidoDTO, PiezaDTO piezaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<MuletoDTO> muletos = obtenerMuleto();
			for(int i=0; i<muletos.size();i++){		
				if (muletos.elementAt(i).getPedido().getId().equals(pedidoDTO.getId()) && (muletos.elementAt(i).getPieza().getId().equals(piezaDTO.getId()))){
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
	public MuletoDTO buscarMuleto(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		MuletoDTO muletoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			MuletoAssembler muletoAssemb = new MuletoAssembler(accesoBD);
			muletoDTO = muletoAssemb.getMuletoDTO((Muleto) accesoBD.buscarPorId(Muleto.class, id));
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return muletoDTO;
=======
		AccesoBD accesoBD = new AccesoBD();
		MuletoDTO muletoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			muletoDTO = MuletoAssembler.getMuletoDTO((Muleto) accesoBD.buscarPorId(Muleto.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return muletoDTO;
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public MuletoDTO buscarMuleto(PedidoDTO pedidoDTO, PiezaDTO piezaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		MuletoDTO muletoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "pieza.id == "+piezaDTO.getId()+" && pedido.id =="+ pedidoDTO.getId();
			Collection muletos = accesoBD.buscarPorFiltro(Muleto.class, filtro);
			MuletoAssembler muletoAssemb = new MuletoAssembler(accesoBD);
			if (muletos.size()>=1 ) {
				muletoDTO = muletoAssemb.getMuletoDTO((Muleto)(muletos.toArray()[0]));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return muletoDTO;
=======
	public MuletoDTO buscarMuleto(PedidoDTO pedidoDTO, PiezaDTO piezaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		MuletoDTO muletoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<MuletoDTO> muletos = obtenerMuleto();
			for(int i=0; i<muletos.size();i++){		
				if (muletos.elementAt(i).getPedido().getId().equals(pedidoDTO.getId()) && (muletos.elementAt(i).getPieza().getId().equals(piezaDTO.getId()))){
					muletoDTO = muletos.elementAt(i);
					break;
				}
			}
			accesoBD.concretarTransaccion();
		} finally{
			accesoBD.rollbackTransaccion();
		}
		return muletoDTO;
>>>>>>> .r18
	}
}