package servidor.GestionarMTelefono;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.MTelefonoAssembler;
import servidor.assembler.ReclamanteAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.MTelefono;

import common.DTOs.MTelefonoDTO;
import common.DTOs.ReclamanteDTO;
import common.GestionarMTelefono.IControlMTelefono;

public class ControlMTelefono extends UnicastRemoteObject implements IControlMTelefono{

	private static final long serialVersionUID = 1L;

	protected ControlMTelefono() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarMTelefono(MTelefonoDTO mTelefonoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		MTelefono mTelefono = MTelefonoAssembler.getMTelefono(mTelefonoDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(mTelefono);
			id=mTelefono.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarMTelefono(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			MTelefono mTelefono = MTelefonoAssembler.getMTelefono(buscarMTelefono(id));
			accesoBD.eliminar(mTelefono);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}	
	}

	@Override
	public void modificarMTelefono(Long id, MTelefonoDTO modificado) throws Exception {
			AccesoBD accesoBD = new AccesoBD();
			try{
				accesoBD.iniciarTransaccion();
				MTelefono mTelefono = MTelefonoAssembler.getMTelefono(buscarMTelefono(id));
				
				mTelefono.setTelefono(modificado.getTelefono());
				mTelefono.setReclamante(ReclamanteAssembler.getReclamante(modificado.getReclamante()));

				accesoBD.hacerPersistente(mTelefono);
				accesoBD.concretarTransaccion();
			} finally {
				accesoBD.rollbackTransaccion();
			}
	}

	@Override
	public Vector<MTelefonoDTO> obtenerMTelefono() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<MTelefonoDTO> mTelefonosDTO = new Vector<MTelefonoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<MTelefono> mTelefonos= (Vector<MTelefono>) accesoBD.buscarPorFiltro(MTelefono.class,"id ascending");
			for(int i=0; i<mTelefonos.size();i++){
				MTelefonoDTO mTelefonoDTO = new MTelefonoDTO();
				mTelefonoDTO.setId(((MTelefono)mTelefonos.elementAt(i)).getId());
				mTelefonoDTO.setTelefono(((MTelefono)mTelefonos.elementAt(i)).getTelefono());
				mTelefonoDTO.setReclamante(ReclamanteAssembler.getReclamanteDTO(((MTelefono)mTelefonos.elementAt(i)).getReclamante()));
				mTelefonosDTO.add(mTelefonoDTO);
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return mTelefonosDTO;
	}

	@Override
	public Vector<MTelefonoDTO> obtenerMTelefono(ReclamanteDTO reclamanteDTO) throws Exception{
	AccesoBD accesoBD = new AccesoBD();
	Vector<MTelefonoDTO> mTelefonosDTO = new Vector<MTelefonoDTO>();
	try {
		accesoBD.iniciarTransaccion();
		Vector<MTelefonoDTO> mTelefonos = obtenerMTelefono();
		for(int i=0; i<mTelefonos.size();i++){		
			if (mTelefonos.elementAt(i).getReclamante().getId().equals(reclamanteDTO.getId())){
				mTelefonosDTO.add(mTelefonos.elementAt(i));
			}
		}
		accesoBD.concretarTransaccion();
	}  finally{
		accesoBD.rollbackTransaccion();
	}
	return mTelefonosDTO;
	}

	@Override
	public boolean existeMTelefono(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((MTelefono) accesoBD.buscarPorId(MTelefono.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existeMTelefono(ReclamanteDTO reclamanteDTO, String telefono) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<MTelefonoDTO> mTelefonos = obtenerMTelefono();
			for(int i=0; i<mTelefonos.size();i++){		
				if (mTelefonos.elementAt(i).getReclamante().getId().equals(reclamanteDTO.getId()) && (mTelefonos.elementAt(i).getTelefono().equals(telefono))){
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
	public MTelefonoDTO buscarMTelefono(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		MTelefonoDTO mTelefonoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			mTelefonoDTO = MTelefonoAssembler.getMTelefonoDTO((MTelefono) accesoBD.buscarPorId(MTelefono.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return mTelefonoDTO;
	}


	@Override
	public MTelefonoDTO buscarMTelefono(ReclamanteDTO reclamanteDTO, String telefono) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		MTelefonoDTO mTelefonoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<MTelefonoDTO> mTelefonos = obtenerMTelefono();
			for(int i=0; i<mTelefonos.size();i++){		
				if (mTelefonos.elementAt(i).getReclamante().getId().equals(reclamanteDTO.getId()) && (mTelefonos.elementAt(i).getTelefono().equals(telefono))){
					mTelefonoDTO = mTelefonos.elementAt(i);
					break;
				}
			}
			accesoBD.concretarTransaccion();
		} finally{
			accesoBD.rollbackTransaccion();
		}
		return mTelefonoDTO;
	}
	
}