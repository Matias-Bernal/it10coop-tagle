package servidor.GestionarReclamo_Fabrica;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.Vector;

import servidor.assembler.ReclamoAssembler;
import servidor.assembler.Reclamo_FabricaAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Reclamo;
import servidor.persistencia.dominio.Reclamo_Fabrica;
import common.DTOs.PedidoDTO;
import common.DTOs.PiezaDTO;
import common.DTOs.Reclamo_FabricaDTO;
import common.GestionarReclamo_Fabrica.IControlReclamo_Fabrica;

public class ControlReclamo_Fabrica extends UnicastRemoteObject implements IControlReclamo_Fabrica {

	private static final long serialVersionUID = 1L;

	protected ControlReclamo_Fabrica() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarReclamo_FabricaDTO(Reclamo_FabricaDTO reclamo_fabricaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Reclamo_Fabrica reclamo_Fabrica = Reclamo_FabricaAssembler.getReclamo_Fabrica(reclamo_fabricaDTO);
		Long id = new Long(0);
		try {
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(reclamo_Fabrica);
			id = reclamo_Fabrica.getId();
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarReclamo_FabricaDTO(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Reclamo_Fabrica reclamo_Fabrica = Reclamo_FabricaAssembler.getReclamo_Fabrica(buscarReclamo_FabricaDTO(id));
			accesoBD.eliminar(reclamo_Fabrica);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public void modificarReclamo_Fabrica(Long id, Reclamo_FabricaDTO modificado)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Reclamo_FabricaDTO> obtenerReclamo_Fabrica() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Reclamo_FabricaDTO> obtenerReclamo_Fabrica(PedidoDTO pedidoDTO)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Reclamo_FabricaDTO> obtenerReclamo_Fabrica(Date fecha_reclamo)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Reclamo_FabricaDTO> obtenerReclamo_Fabrica(PiezaDTO piezaDTO)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeReclamo_Fabrica(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeReclamo_Fabrica(PedidoDTO pedidoDTO, PiezaDTO piezaDTO)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reclamo_FabricaDTO buscarReclamo_FabricaDTO(Long id)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reclamo_FabricaDTO buscarReclamo_FabricaDTO(PedidoDTO pedidoDTO,
			PiezaDTO pieza) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}