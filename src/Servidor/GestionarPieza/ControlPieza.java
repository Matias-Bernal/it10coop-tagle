package servidor.GestionarPieza;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.PiezaAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Pieza;

import common.DTOs.PiezaDTO;
import common.GestionarPieza.IControlPieza;

public class ControlPieza extends UnicastRemoteObject implements IControlPieza{

	private static final long serialVersionUID = 1L;

	protected ControlPieza() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarPieza(PiezaDTO piezaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Pieza pieza = PiezaAssembler.getPieza(piezaDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(pieza);
			id=pieza.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarPieza(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Pieza pieza = PiezaAssembler.getPieza(buscarPieza(id));
			accesoBD.eliminar(pieza);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public void modificarPieza(Long id, PiezaDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Pieza pieza = PiezaAssembler.getPieza(buscarPieza(id));
			pieza.setNumero_pieza(modificado.getNumero_pieza());
			pieza.setDescripcion(modificado.getDescripcion());
			accesoBD.hacerPersistente(pieza);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<PiezaDTO> obtenerPiezas() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<PiezaDTO> piezasDTO = new Vector<PiezaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Pieza> agentes= (Vector<Pieza>) accesoBD.buscarPorFiltro(Pieza.class,"nombre_registrante ascending");
			for(int i=0; i<agentes.size();i++){
				PiezaDTO piezaDTO = new PiezaDTO();
				piezaDTO.setId(((Pieza)agentes.elementAt(i)).getId());
				piezaDTO.setNumero_pieza(((Pieza)agentes.elementAt(i)).getNumero_pieza());
				piezaDTO.setDescripcion(((Pieza)agentes.elementAt(i)).getDescripcion());
				piezasDTO.add(piezaDTO);
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return piezasDTO;
	}

	@Override
	public Vector<PiezaDTO> obtenerPiezas(String numero_pieza) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<PiezaDTO> piezasDTO = new Vector<PiezaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			Vector<PiezaDTO> piezas = obtenerPiezas();
			for(int i=0; i<piezas.size();i++){		
				if ((piezas.elementAt(i).getNumero_pieza()).equals(numero_pieza)){
					piezasDTO.add(piezas.elementAt(i));
					break;
				}
			}
			accesoBD.concretarTransaccion();
		} finally{
			accesoBD.rollbackTransaccion();
		}
		return piezasDTO;
	}

	@Override
	public boolean existePieza(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Pieza) accesoBD.buscarPorId(Pieza.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existePieza(String numero_pieza) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<PiezaDTO> piezas = obtenerPiezas();
			for(int i=0; i<piezas.size();i++){		
				if ((piezas.elementAt(i).getNumero_pieza()).equals(numero_pieza)){
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
	public PiezaDTO buscarPieza(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		PiezaDTO piezaDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			piezaDTO = PiezaAssembler.getPiezaDTO((Pieza) accesoBD.buscarPorId(Pieza.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return piezaDTO;
	}

	@Override
	public PiezaDTO buscarPieza(String numero_pieza) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		PiezaDTO piezaDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<PiezaDTO> piezasDTO = obtenerPiezas();
				for(int i=0; i<piezasDTO.size();i++){
					if (((PiezaDTO)piezasDTO.elementAt(i)).getNumero_pieza().equals(numero_pieza)){
						piezaDTO = (PiezaDTO)piezasDTO.elementAt(i);
						break;
					}
				}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return piezaDTO;
	}

}