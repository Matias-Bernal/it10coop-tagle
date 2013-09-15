package servidor.GestionarDevolucion_Pieza;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.Collection;
import java.util.Vector;

import servidor.assembler.Devolucion_PiezaAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Devolucion_Pieza;

import common.DTOs.Devolucion_PiezaDTO;
import common.GestionarDevolucion_Pieza.IControlDevolucion_Pieza;

public class ControlDevolucion_Pieza extends UnicastRemoteObject implements IControlDevolucion_Pieza {

	private static final long serialVersionUID = 1L;

	protected ControlDevolucion_Pieza() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
<<<<<<< .mine
	public Long agregarDevolucion_Pieza(Devolucion_PiezaDTO devolucion_piezaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Long id = new Long(0);
		try {
			accesoBD.iniciarTransaccion();
			Devolucion_PiezaAssembler devolucion_piezaAssemb = new Devolucion_PiezaAssembler(accesoBD);
			Devolucion_Pieza devolucion_Pieza = devolucion_piezaAssemb.getDevolucion_PiezaNueva(devolucion_piezaDTO);
			accesoBD.hacerPersistente(devolucion_Pieza);
			id = devolucion_Pieza.getId();
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return id;
=======
	public Long agregarDevolucion_Pieza(Devolucion_PiezaDTO devolucion_piezaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Devolucion_Pieza devolucion_Pieza = Devolucion_PiezaAssembler.getDevolucion_Pieza(devolucion_piezaDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(devolucion_Pieza);
			id=devolucion_Pieza.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
>>>>>>> .r18
	}

	@Override
	public void eliminarDevolucion_Pieza(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Devolucion_PiezaAssembler devolucion_piezaAssemb = new Devolucion_PiezaAssembler(accesoBD);
			Devolucion_Pieza devolucion_Pieza = devolucion_piezaAssemb.getDevolucion_Pieza(buscarDevolucion_Pieza(id));
			accesoBD.eliminar(devolucion_Pieza);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
=======
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Devolucion_Pieza devolucion_Pieza = Devolucion_PiezaAssembler.getDevolucion_Pieza(buscarDevolucion_Pieza(id));
			accesoBD.eliminar(devolucion_Pieza);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public void modificarDevolucion_Pieza(Long id, Devolucion_PiezaDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Devolucion_PiezaAssembler devolucion_piezaAssemb = new Devolucion_PiezaAssembler(accesoBD);
			Devolucion_Pieza devolucion_Pieza = devolucion_piezaAssemb.getDevolucion_Pieza(buscarDevolucion_Pieza(id));

			devolucion_Pieza.setFecha_devolucion(modificado.getFecha_devolucion());
			devolucion_Pieza.setNumero_remito(modificado.getNumero_remito());
			devolucion_Pieza.setTransporte(modificado.getTransporte());
			devolucion_Pieza.setNumero_retiro(modificado.getNumero_retiro());

			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
=======
	public void modificarDevolucion_Pieza(Long id, Devolucion_PiezaDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Devolucion_Pieza devolucion_Pieza = Devolucion_PiezaAssembler.getDevolucion_Pieza(buscarDevolucion_Pieza(id));
			
			devolucion_Pieza.setFecha_devolucion(modificado.getFecha_devolucion());
			devolucion_Pieza.setNumero_remito(modificado.getNumero_remito());
			devolucion_Pieza.setTransporte(modificado.getTransporte());
			devolucion_Pieza.setNumero_retiro(modificado.getNumero_retiro());
			
			accesoBD.hacerPersistente(devolucion_Pieza);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}	
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Vector<Devolucion_PiezaDTO> obtenerDevolucion_Pieza() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Devolucion_PiezaDTO> devolucion_PiezasDTO = new Vector<Devolucion_PiezaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Devolucion_Pieza> devolucion_Piezas = (Vector<Devolucion_Pieza>) accesoBD.buscarPorFiltro(Devolucion_Pieza.class, "");
			for (int i = 0; i < devolucion_Piezas.size(); i++) {
				Devolucion_PiezaDTO devolucion_PiezaDTO = new Devolucion_PiezaDTO();
				devolucion_PiezaDTO.setId(devolucion_Piezas.elementAt(i).getId());
				devolucion_PiezaDTO.setFecha_devolucion(devolucion_Piezas.elementAt(i).getFecha_devolucion());
				devolucion_PiezaDTO.setNumero_remito(devolucion_Piezas.elementAt(i).getNumero_remito());
				devolucion_PiezaDTO.setTransporte(devolucion_Piezas.elementAt(i).getTransporte());
				devolucion_PiezaDTO.setNumero_retiro(devolucion_Piezas.elementAt(i).getNumero_retiro());

				devolucion_PiezasDTO.add(devolucion_PiezaDTO);
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return devolucion_PiezasDTO;
=======
	public Vector<Devolucion_PiezaDTO> obtenerDevolucion_Pieza() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Devolucion_PiezaDTO> devolucion_PiezasDTO = new Vector<Devolucion_PiezaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Devolucion_Pieza> devolucion_Piezas= (Vector<Devolucion_Pieza>) accesoBD.buscarPorFiltro(Devolucion_Pieza.class,"id ascending");
			for(int i=0; i<devolucion_Piezas.size();i++){
				Devolucion_PiezaDTO devolucion_PiezaDTO = new Devolucion_PiezaDTO();
				devolucion_PiezaDTO.setId(((Devolucion_Pieza)devolucion_Piezas.elementAt(i)).getId());
				devolucion_PiezaDTO.setFecha_devolucion(((Devolucion_Pieza)devolucion_Piezas.elementAt(i)).getFecha_devolucion());
				devolucion_PiezaDTO.setNumero_remito(((Devolucion_Pieza)devolucion_Piezas.elementAt(i)).getNumero_remito());
				devolucion_PiezaDTO.setTransporte(((Devolucion_Pieza)devolucion_Piezas.elementAt(i)).getTransporte());
				devolucion_PiezaDTO.setNumero_retiro(((Devolucion_Pieza)devolucion_Piezas.elementAt(i)).getNumero_retiro());

				devolucion_PiezasDTO.add(devolucion_PiezaDTO);
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return devolucion_PiezasDTO;
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Vector<Devolucion_PiezaDTO> obtenerDevolucion_Pieza(Date fecha_devolucion) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Devolucion_PiezaDTO> devolucion_PiezasDTO = new Vector<Devolucion_PiezaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			Collection devoluciones_piezas =  accesoBD.obtenerObjetosFecha(Devolucion_Pieza.class, fecha_devolucion.getYear(),fecha_devolucion.getMonth(), fecha_devolucion.getDay());
			Devolucion_PiezaAssembler devolucion_piezaAssemb = new Devolucion_PiezaAssembler(accesoBD);
			for (int i = 0; i < devoluciones_piezas.size(); i++) {
				devolucion_PiezasDTO.add(devolucion_piezaAssemb.getDevolucion_PiezaDTO((Devolucion_Pieza)(devoluciones_piezas.toArray()[i])));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return devolucion_PiezasDTO;
=======
	public Vector<Devolucion_PiezaDTO> obtenerDevolucion_Pieza(Date fecha_devolucion) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Devolucion_PiezaDTO> devolucion_PiezasDTO = new Vector<Devolucion_PiezaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			Vector<Devolucion_PiezaDTO> devolucion_Piezas = obtenerDevolucion_Pieza();
			for(int i=0; i<devolucion_Piezas.size();i++){		
				if (devolucion_Piezas.elementAt(i).getFecha_devolucion().equals(fecha_devolucion)){
					devolucion_PiezasDTO.add(devolucion_Piezas.elementAt(i));
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return devolucion_PiezasDTO;
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Vector<Devolucion_PiezaDTO> obtenerDevolucion_Pieza_Trasnporte(String transporte) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Devolucion_PiezaDTO> devolucion_PiezasDTO = new Vector<Devolucion_PiezaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "transporte.equals(\""+transporte+"\")";
			Collection movCol = accesoBD.buscarPorFiltro(Devolucion_Pieza.class, filtro);
			Devolucion_PiezaAssembler devolucion_piezaAssemb = new Devolucion_PiezaAssembler(accesoBD); 
			for (int i = 0; i < movCol.size(); i++) {
				devolucion_PiezasDTO.add(devolucion_piezaAssemb.getDevolucion_PiezaDTO((Devolucion_Pieza)(movCol.toArray())[i]));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return devolucion_PiezasDTO;
=======
	public Vector<Devolucion_PiezaDTO> obtenerDevolucion_Pieza_Trasnporte(String transporte) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<Devolucion_PiezaDTO> devolucion_PiezasDTO = new Vector<Devolucion_PiezaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			Vector<Devolucion_PiezaDTO> devolucion_Piezas = obtenerDevolucion_Pieza();
			for(int i=0; i<devolucion_Piezas.size();i++){		
				if (devolucion_Piezas.elementAt(i).getTransporte().equals(transporte)){
					devolucion_PiezasDTO.add(devolucion_Piezas.elementAt(i));
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return devolucion_PiezasDTO;
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public boolean existeDevolucion_Pieza(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Devolucion_Pieza) accesoBD.buscarPorId(Devolucion_Pieza.class, id) == null);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return existe;
=======
	public boolean existeDevolucion_Pieza(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Devolucion_Pieza) accesoBD.buscarPorId(Devolucion_Pieza.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public boolean existeDevolucion_Pieza(String numero_remito)	throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Collection devoluciones_piezas = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "numero_remito.equals(\""+numero_remito+"\")";
			devoluciones_piezas = accesoBD.buscarPorFiltro(Devolucion_Pieza.class, filtro);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return (devoluciones_piezas!=null && devoluciones_piezas.size()>=1);
=======
	public boolean existeDevolucion_Pieza(String numero_remito)	throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Devolucion_PiezaDTO> devolucion_Piezas = obtenerDevolucion_Pieza();
			for(int i=0; i<devolucion_Piezas.size();i++){		
				if (devolucion_Piezas.elementAt(i).getNumero_remito().equals(numero_remito)){
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
	public boolean existeDevolucion_Pieza_Numero_Retiro(String numero_retiro)
			throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Collection devoluciones_piezas = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "numero_retiro.equals(\""+numero_retiro+"\")";
			devoluciones_piezas = accesoBD.buscarPorFiltro(Devolucion_Pieza.class, filtro);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return (devoluciones_piezas!=null && devoluciones_piezas.size()>=1);
=======
	public Devolucion_PiezaDTO buscarDevolucion_Pieza(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Devolucion_PiezaDTO devolucion_PiezaDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			devolucion_PiezaDTO = Devolucion_PiezaAssembler.getDevolucion_PiezaDTO((Devolucion_Pieza) accesoBD.buscarPorId(Devolucion_Pieza.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return devolucion_PiezaDTO;
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Devolucion_PiezaDTO buscarDevolucion_Pieza(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Devolucion_PiezaDTO devolucion_PiezaDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Devolucion_PiezaAssembler devolucion_piezaAssemb = new Devolucion_PiezaAssembler(accesoBD); 
			devolucion_PiezaDTO = devolucion_piezaAssemb.getDevolucion_PiezaDTO((Devolucion_Pieza) accesoBD.buscarPorId(Devolucion_Pieza.class, id));
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return devolucion_PiezaDTO;
	}
	
	@Override
	public Devolucion_PiezaDTO buscarDevolucion_Pieza(String numero_remito)	throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Devolucion_PiezaDTO devolucion_PiezaDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "numero_remito.equals(\""+numero_remito+"\")";
			Collection devoluciones_piezas = accesoBD.buscarPorFiltro(Devolucion_Pieza.class, filtro);
			Devolucion_PiezaAssembler devolucion_piezaAssemb = new Devolucion_PiezaAssembler(accesoBD);
			if (devoluciones_piezas.size()>=1 ) {
				devolucion_PiezaDTO = devolucion_piezaAssemb.getDevolucion_PiezaDTO((Devolucion_Pieza)(devoluciones_piezas.toArray()[0]));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return devolucion_PiezaDTO;
=======
	public Devolucion_PiezaDTO buscarDevolucion_Pieza(String numero_remito) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Devolucion_PiezaDTO devolucion_PiezaDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Devolucion_PiezaDTO> devolucion_PiezasDTO = obtenerDevolucion_Pieza();
			for(int i=0; i<devolucion_PiezasDTO.size();i++){		
				if (devolucion_PiezasDTO.elementAt(i).getNumero_remito().equals(numero_remito)){
					devolucion_PiezaDTO = devolucion_PiezasDTO.elementAt(i);
					break;
				}
			}
			accesoBD.concretarTransaccion();
		} finally{
			accesoBD.rollbackTransaccion();
		}
		return devolucion_PiezaDTO;
>>>>>>> .r18
	}

<<<<<<< .mine
	@Override
	public Devolucion_PiezaDTO buscarDevolucion_Pieza_Numero_Retiro(String numero_retiro) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Devolucion_PiezaDTO devolucion_PiezaDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "numero_retiro.equals(\""+numero_retiro+"\")";
			Collection devoluciones_piezas = accesoBD.buscarPorFiltro(Devolucion_Pieza.class, filtro);
			Devolucion_PiezaAssembler devolucion_piezaAssemb = new Devolucion_PiezaAssembler(accesoBD);
			if (devoluciones_piezas.size()>=1 ) {
				devolucion_PiezaDTO = devolucion_piezaAssemb.getDevolucion_PiezaDTO((Devolucion_Pieza)(devoluciones_piezas.toArray()[0]));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return devolucion_PiezaDTO;
	}
=======
	@Override
	public boolean existeDevolucion_Pieza_Numero_Retiro(String numero_retiro) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Devolucion_PiezaDTO> devolucion_Piezas = obtenerDevolucion_Pieza();
			for(int i=0; i<devolucion_Piezas.size();i++){		
				if (devolucion_Piezas.elementAt(i).getNumero_retiro().equals(numero_retiro)){
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
	public Devolucion_PiezaDTO buscarDevolucion_Pieza_Numero_Retiro(String numero_retiro) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Devolucion_PiezaDTO devolucion_PiezaDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<Devolucion_PiezaDTO> devolucion_PiezasDTO = obtenerDevolucion_Pieza();
			for(int i=0; i<devolucion_PiezasDTO.size();i++){		
				if (devolucion_PiezasDTO.elementAt(i).getNumero_retiro().equals(numero_retiro)){
					devolucion_PiezaDTO = devolucion_PiezasDTO.elementAt(i);
					break;
				}
			}
			accesoBD.concretarTransaccion();
		} finally{
			accesoBD.rollbackTransaccion();
		}
		return devolucion_PiezaDTO;
	}
>>>>>>> .r18

}