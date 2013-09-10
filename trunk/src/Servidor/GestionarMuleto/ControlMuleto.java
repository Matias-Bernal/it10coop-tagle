package servidor.GestionarMuleto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.MuletoAssembler;
import servidor.assembler.PedidoAssembler;
import servidor.assembler.PiezaAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Muleto;

import common.DTOs.MuletoDTO;
import common.DTOs.PedidoDTO;
import common.DTOs.PiezaDTO;
import common.GestionarMuleto.IControlMuleto;

public class ControlMuleto extends UnicastRemoteObject implements IControlMuleto{

	private static final long serialVersionUID = 1L;

	protected ControlMuleto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
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
	}

	@Override
	public void eliminarMuleto(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Muleto muleto = MuletoAssembler.getMuleto(buscarMuleto(id));
			accesoBD.eliminar(muleto);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}	
	}

	@Override
	public void modificarMuleto(Long id, MuletoDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Muleto muleto = MuletoAssembler.getMuleto(buscarMuleto(id));
			
			muleto.setVin(modificado.getVin());
			muleto.setDescripcion(modificado.getDescripcion());
			muleto.setPedido(PedidoAssembler.getPedido(modificado.getPedido()));
			muleto.setPieza(PiezaAssembler.getPieza(modificado.getPieza()));

			accesoBD.hacerPersistente(muleto);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
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
	}

	@Override
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
	}

	@Override
	public boolean existeMuleto(Long id) throws Exception {
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
	}

	@Override
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
	}

	@Override
	public MuletoDTO buscarMuleto(Long id) throws Exception {
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
	}

	@Override
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
	}
}