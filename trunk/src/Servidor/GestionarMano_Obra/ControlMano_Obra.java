package servidor.GestionarMano_Obra;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.Mano_ObraAssembler;
import servidor.assembler.ReclamoAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Mano_Obra;

import common.DTOs.Mano_ObraDTO;
import common.DTOs.ReclamoDTO;
import common.GestionarMano_Obra.IControlMano_Obra;

public class ControlMano_Obra extends UnicastRemoteObject implements IControlMano_Obra{

	private static final long serialVersionUID = 1L;

	protected ControlMano_Obra() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarMano_Obra(Mano_ObraDTO mano_obraDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Mano_Obra mano_Obra = Mano_ObraAssembler.getMano_Obra(mano_obraDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(mano_Obra);
			id=mano_Obra.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarMano_Obra(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Mano_Obra mano_Obra = Mano_ObraAssembler.getMano_Obra(buscarMano_Obra(id));
			accesoBD.eliminar(mano_Obra);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}	
	}

	@Override
	public void modificarMano_Obra(Long id, Mano_ObraDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Mano_Obra mano_Obra = Mano_ObraAssembler.getMano_Obra(buscarMano_Obra(id));
			mano_Obra.setCantidad_horas(modificado.getCantidad_horas());
			mano_Obra.setCodigo_mano_obra(modificado.getCodigo_mano_obra());
			mano_Obra.setValor_mano_obra(modificado.getValor_mano_obra());
			mano_Obra.setReclamo(ReclamoAssembler.getReclamo(modificado.getReclamo()));
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}		
	}

	@Override
	public Vector<Mano_ObraDTO> obtenerMano_Obra() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Mano_ObraDTO> mano_ObrasDTO = new Vector<Mano_ObraDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Mano_Obra> mano_Obras= (Vector<Mano_Obra>) accesoBD.buscarPorFiltro(Mano_Obra.class,"id ascending");
			for(int i=0; i<mano_Obras.size();i++){
				Mano_ObraDTO mano_ObraDTO = new Mano_ObraDTO();
				mano_ObraDTO.setId(((Mano_Obra)mano_Obras.elementAt(i)).getId());
				mano_ObraDTO.setCantidad_horas(((Mano_Obra)mano_Obras.elementAt(i)).getCantidad_horas());
				mano_ObraDTO.setCodigo_mano_obra(((Mano_Obra)mano_Obras.elementAt(i)).getCodigo_mano_obra());
				mano_ObraDTO.setValor_mano_obra(((Mano_Obra)mano_Obras.elementAt(i)).getValor_mano_obra());
				mano_ObraDTO.setReclamo(ReclamoAssembler.getReclamoDTO(((Mano_Obra)mano_Obras.elementAt(i)).getReclamo()));
				mano_ObrasDTO.add(mano_ObraDTO);
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return mano_ObrasDTO;
	}


	@Override
	public Vector<Mano_ObraDTO> obtenerMano_Obra(String codigo_mano_obra) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Mano_ObraDTO> mano_ObrasDTO = new Vector<Mano_ObraDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Mano_Obra> mano_Obras= (Vector<Mano_Obra>) accesoBD.buscarPorFiltro(Mano_Obra.class,"id ascending");
			for(int i=0; i<mano_Obras.size();i++){
				if (((Mano_Obra)mano_Obras.elementAt(i)).getCodigo_mano_obra().equals(codigo_mano_obra)){
					Mano_ObraDTO mano_ObraDTO = new Mano_ObraDTO();
					mano_ObraDTO.setId(((Mano_Obra)mano_Obras.elementAt(i)).getId());
					mano_ObraDTO.setCantidad_horas(((Mano_Obra)mano_Obras.elementAt(i)).getCantidad_horas());
					mano_ObraDTO.setCodigo_mano_obra(((Mano_Obra)mano_Obras.elementAt(i)).getCodigo_mano_obra());
					mano_ObraDTO.setValor_mano_obra(((Mano_Obra)mano_Obras.elementAt(i)).getValor_mano_obra());
					mano_ObraDTO.setReclamo(ReclamoAssembler.getReclamoDTO(((Mano_Obra)mano_Obras.elementAt(i)).getReclamo()));
					mano_ObrasDTO.add(mano_ObraDTO);
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return mano_ObrasDTO;
	}

	@Override
	public Vector<Mano_ObraDTO> obtenerMano_Obra(ReclamoDTO reclamo) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Mano_ObraDTO> mano_ObrasDTO = new Vector<Mano_ObraDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Mano_Obra> mano_Obras= (Vector<Mano_Obra>) accesoBD.buscarPorFiltro(Mano_Obra.class,"id ascending");
			for(int i=0; i<mano_Obras.size();i++){
				if (((Mano_Obra)mano_Obras.elementAt(i)).getReclamo().getId().equals(reclamo.getId())){
					Mano_ObraDTO mano_ObraDTO = new Mano_ObraDTO();
					mano_ObraDTO.setId(((Mano_Obra)mano_Obras.elementAt(i)).getId());
					mano_ObraDTO.setCantidad_horas(((Mano_Obra)mano_Obras.elementAt(i)).getCantidad_horas());
					mano_ObraDTO.setCodigo_mano_obra(((Mano_Obra)mano_Obras.elementAt(i)).getCodigo_mano_obra());
					mano_ObraDTO.setValor_mano_obra(((Mano_Obra)mano_Obras.elementAt(i)).getValor_mano_obra());
					mano_ObraDTO.setReclamo(ReclamoAssembler.getReclamoDTO(((Mano_Obra)mano_Obras.elementAt(i)).getReclamo()));
					mano_ObrasDTO.add(mano_ObraDTO);
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return mano_ObrasDTO;
	}

	@Override
	public boolean existeMano_Obra(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Mano_Obra) accesoBD.buscarPorId(Mano_Obra.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existeMano_Obra(String codigo_mano_obra) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Mano_ObraDTO> manos_obrasDTO = obtenerMano_Obra();
			for(int i=0; i<manos_obrasDTO.size();i++){
				if (((Mano_ObraDTO)manos_obrasDTO.elementAt(i)).getCodigo_mano_obra().equals(codigo_mano_obra)){
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
	public Mano_ObraDTO buscarMano_Obra(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Mano_ObraDTO mano_ObraDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			mano_ObraDTO = Mano_ObraAssembler.getMano_ObraDTO((Mano_Obra) accesoBD.buscarPorId(Mano_Obra.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return mano_ObraDTO;
	}

	@Override
	public Mano_ObraDTO buscarMano_Obra(String codigo_mano_obra) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Mano_ObraDTO mano_ObraDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Mano_ObraDTO> manos_ObrasDTO = obtenerMano_Obra();
				for(int i=0; i<manos_ObrasDTO.size();i++){
					if (((Mano_ObraDTO)manos_ObrasDTO.elementAt(i)).getCodigo_mano_obra().equals(codigo_mano_obra)){
						mano_ObraDTO = (Mano_ObraDTO)manos_ObrasDTO.elementAt(i);
						break;
					}
				}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return mano_ObraDTO;
	}

	@Override
	public Mano_ObraDTO buscarMano_Obra(ReclamoDTO reclamo,String codigo_mano_obra) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Mano_ObraDTO mano_ObraDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Mano_ObraDTO> manos_ObrasDTO = obtenerMano_Obra();
				for(int i=0; i<manos_ObrasDTO.size();i++){
					if (((Mano_ObraDTO)manos_ObrasDTO.elementAt(i)).getCodigo_mano_obra().equals(codigo_mano_obra) && ((Mano_ObraDTO)manos_ObrasDTO.elementAt(i)).getReclamo().getId().equals(reclamo.getId())){
						mano_ObraDTO = (Mano_ObraDTO)manos_ObrasDTO.elementAt(i);
						break;
					}
				}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return mano_ObraDTO;
	}

}