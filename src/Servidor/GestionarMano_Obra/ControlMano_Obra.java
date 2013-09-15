package servidor.GestionarMano_Obra;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.Vector;

import servidor.assembler.Mano_ObraAssembler;
import servidor.assembler.ReclamoAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Mano_Obra;

import common.DTOs.Mano_ObraDTO;
import common.DTOs.ReclamoDTO;
import common.GestionarMano_Obra.IControlMano_Obra;

public class ControlMano_Obra extends UnicastRemoteObject implements
		IControlMano_Obra {

	private static final long serialVersionUID = 1L;

	protected ControlMano_Obra() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
<<<<<<< .mine
	public Long agregarMano_Obra(Mano_ObraDTO mano_obraDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Long id = new Long(0);
		try {
			accesoBD.iniciarTransaccion();
			Mano_ObraAssembler mano_ObraAssemb = new Mano_ObraAssembler(accesoBD);
			Mano_Obra mano_Obra = mano_ObraAssemb.getMano_ObraNueva(mano_obraDTO);
			accesoBD.hacerPersistente(mano_Obra);
			id = mano_Obra.getId();
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return id;
=======
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
>>>>>>> .r18
	}

	@Override
	public void eliminarMano_Obra(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Mano_ObraAssembler mano_ObraAssemb = new Mano_ObraAssembler(accesoBD);
			Mano_Obra mano_Obra = mano_ObraAssemb.getMano_Obra(buscarMano_Obra(id));
			accesoBD.eliminar(mano_Obra);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
=======
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Mano_Obra mano_Obra = Mano_ObraAssembler.getMano_Obra(buscarMano_Obra(id));
			accesoBD.eliminar(mano_Obra);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}	
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public void modificarMano_Obra(Long id, Mano_ObraDTO modificado)
			throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Mano_ObraAssembler mano_ObraAssemb = new Mano_ObraAssembler(accesoBD);
			Mano_Obra mano_Obra = mano_ObraAssemb.getMano_Obra(buscarMano_Obra(id));
			mano_Obra.setCantidad_horas(modificado.getCantidad_horas());
			mano_Obra.setCodigo_mano_obra(modificado.getCodigo_mano_obra());
			mano_Obra.setValor_mano_obra(modificado.getValor_mano_obra());
			ReclamoAssembler reclamoAssemb = new ReclamoAssembler(accesoBD);
			mano_Obra.setReclamo(reclamoAssemb.getReclamo(modificado.getReclamo()));
			
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
=======
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
>>>>>>> .r18
	}

	@Override
	public Vector<Mano_ObraDTO> obtenerMano_Obra() throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		Vector<Mano_ObraDTO> mano_ObrasDTO = new Vector<Mano_ObraDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Mano_Obra> mano_Obras = (Vector<Mano_Obra>) accesoBD.buscarPorFiltro(Mano_Obra.class, "");
			for (int i = 0; i < mano_Obras.size(); i++) {
				Mano_ObraDTO mano_ObraDTO = new Mano_ObraDTO();
				
				mano_ObraDTO.setId(mano_Obras.elementAt(i).getId());
				mano_ObraDTO.setCantidad_horas(mano_Obras.elementAt(i).getCantidad_horas());
				mano_ObraDTO.setCodigo_mano_obra(mano_Obras.elementAt(i).getCodigo_mano_obra());
				mano_ObraDTO.setValor_mano_obra(mano_Obras.elementAt(i).getValor_mano_obra());
				ReclamoAssembler reclamoAssemb = new ReclamoAssembler(accesoBD);
				mano_ObraDTO.setReclamo(reclamoAssemb.getReclamoDTO(mano_Obras.elementAt(i).getReclamo()));
				
				mano_ObrasDTO.add(mano_ObraDTO);
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return mano_ObrasDTO;
=======
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
>>>>>>> .r18
	}

<<<<<<< .mine
	@Override
	public Vector<Mano_ObraDTO> obtenerMano_Obra(String codigo_mano_obra)
			throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Mano_ObraDTO> mano_ObrasDTO = new Vector<Mano_ObraDTO>();
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "codigo_mano_obra.equals(\""+codigo_mano_obra+"\")";
			Collection movCol = accesoBD.buscarPorFiltro(Mano_Obra.class, filtro);
			Mano_ObraAssembler mano_ObraAssemb = new Mano_ObraAssembler(accesoBD);
			for (int i = 0; i < movCol.size(); i++) {
				mano_ObrasDTO.add(mano_ObraAssemb.getMano_ObraDTO((Mano_Obra)(movCol.toArray())[i]));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return mano_ObrasDTO;
=======

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
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Vector<Mano_ObraDTO> obtenerMano_Obra(ReclamoDTO reclamo)throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Mano_ObraDTO> manos_obrasDTO = new Vector<Mano_ObraDTO>();
		try {
			accesoBD.iniciarTransaccion();

			String filtro = "reclamo.id == "+reclamo.getId();
			Collection manos_obras = accesoBD.buscarPorFiltro(Mano_Obra.class, filtro);
			Mano_ObraAssembler mano_ObraAssemb = new Mano_ObraAssembler(accesoBD);
			for (int i = 0; i < manos_obras.size(); i++) {
				manos_obrasDTO.add(mano_ObraAssemb.getMano_ObraDTO((Mano_Obra)(manos_obras.toArray()[i])));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return manos_obrasDTO;
=======
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
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public boolean existeMano_Obra(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Mano_Obra) accesoBD.buscarPorId(Mano_Obra.class, id) == null);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return existe;
=======
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
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public boolean existeMano_Obra(String codigo_mano_obra) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Collection movCol = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "codigo_mano_obra.equals(\""+codigo_mano_obra+"\")";
			movCol = accesoBD.buscarPorFiltro(Mano_Obra.class, filtro);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return (movCol != null && movCol.size()>=1);
=======
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
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Mano_ObraDTO buscarMano_Obra(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Mano_ObraDTO mano_ObraDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Mano_ObraAssembler mano_ObraAssemb = new Mano_ObraAssembler(accesoBD);
			mano_ObraDTO = mano_ObraAssemb.getMano_ObraDTO((Mano_Obra) accesoBD.buscarPorId(Mano_Obra.class, id));
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return mano_ObraDTO;
=======
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
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Mano_ObraDTO buscarMano_Obra(String codigo_mano_obra) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Mano_ObraDTO mano_ObraDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "codigo_mano_obra.equals(\""+codigo_mano_obra+"\")";
			Collection manos_obras = accesoBD.buscarPorFiltro(Mano_Obra.class, filtro);
			Mano_ObraAssembler mano_obraAssemb = new Mano_ObraAssembler(accesoBD);
			if (manos_obras.size()>=1 ) {
				mano_ObraDTO = mano_obraAssemb.getMano_ObraDTO((Mano_Obra)(manos_obras.toArray()[0]));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return mano_ObraDTO;
=======
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
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Mano_ObraDTO buscarMano_Obra(ReclamoDTO reclamo,	String codigo_mano_obra) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Mano_ObraDTO mano_ObraDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "reclamo.id == "+reclamo.getId()+" && codigo_mano_obra.equals(\""+codigo_mano_obra+"\")";
			Collection manos_obras = accesoBD.buscarPorFiltro(Mano_Obra.class, filtro);
			Mano_ObraAssembler mano_obraAssemb = new Mano_ObraAssembler(accesoBD);
			if (manos_obras.size()>=1 ) {
				mano_ObraDTO = mano_obraAssemb.getMano_ObraDTO((Mano_Obra)(manos_obras.toArray()[0]));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return mano_ObraDTO;
=======
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
>>>>>>> .r18
	}

}