package servidor.GestionarMarca;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.Vector;

<<<<<<< .mine
import servidor.assembler.MarcaAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Marca;
=======
import servidor.assembler.MarcaAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Marca;

>>>>>>> .r18
import common.DTOs.MarcaDTO;
import common.GestionarMarca.IControlMarca;

public class ControlMarca extends UnicastRemoteObject implements IControlMarca {

	private static final long serialVersionUID = 1L;

	public ControlMarca() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
<<<<<<< .mine
	public Long agregarMarca(MarcaDTO marcaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Long id = new Long(0);
		try {
			accesoBD.iniciarTransaccion();
			MarcaAssembler marcaAssemb = new MarcaAssembler(accesoBD); 
			Marca Marca = marcaAssemb.getMarcaNueva(marcaDTO);
			accesoBD.hacerPersistente(Marca);
			id = Marca.getId();
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
			e.printStackTrace();
		}
		return id;
=======
	public Long agregarMarca(MarcaDTO marcaDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Marca Marca = MarcaAssembler.getMarca(marcaDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(Marca);
			id=Marca.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
>>>>>>> .r18
	}

	@Override
	public void eliminarMarca(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			MarcaAssembler marcaAssemb = new MarcaAssembler(accesoBD); 
			Marca marca = marcaAssemb.getMarca(buscarMarca(id));
			accesoBD.eliminar(marca);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
=======
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Marca marca = MarcaAssembler.getMarca(buscarMarca(id));
			accesoBD.eliminar(marca);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
>>>>>>> .r18
	}

	@Override
	public void modificarMarca(Long id, MarcaDTO modificado) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			MarcaAssembler marcaAssemb = new MarcaAssembler(accesoBD); 
			Marca marca = marcaAssemb.getMarca(buscarMarca(id));
			marca.setNombre_marca(modificado.getNombre_marca()); //no hace nada en la base de datos
			//accesoBD.hacerPersistente(marca);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<MarcaDTO> obtenerMarcas() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<MarcaDTO> marcasDTO = new Vector<MarcaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Marca> marcas = new Vector<Marca>(accesoBD.buscarPorFiltro(Marca.class, ""));
			for (int i = 0; i < marcas.size(); i++) {
				
				MarcaDTO marcaDTO = new MarcaDTO();
				marcaDTO.setId(marcas.elementAt(i).getId());
				marcaDTO.setNombre_marca(marcas.elementAt(i).getNombre_marca());
				marcasDTO.add(marcaDTO);
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			System.out.println("Error en obtener todas las marcas desde la BD");
			accesoBD.rollbackTransaccion();
		}
		return marcasDTO;
=======
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Marca marca = MarcaAssembler.getMarca(buscarMarca(id));
			marca.setNombre_marca(modificado.getNombre_marca());
			accesoBD.hacerPersistente(marca);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}
	
	@Override
	public Vector<MarcaDTO> obtenerMarcas() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<MarcaDTO> marcasDTO = new Vector<MarcaDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Marca> marcas = (Vector<Marca>) accesoBD.buscarPorFiltro(Marca.class,"id ascending");
			for(int i=0; i<marcas.size();i++){
				MarcaDTO marcaDTO = new MarcaDTO();
				marcaDTO.setId(((Marca)marcas.elementAt(i)).getId());
				marcaDTO.setNombre_marca(((Marca)marcas.elementAt(i)).getNombre_marca());
				marcasDTO.add(marcaDTO);
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return marcasDTO;
>>>>>>> .r18
	}
	
	@Override
	public boolean existeMarca(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Marca) accesoBD.buscarPorId(Marca.class, id) == null);
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
			existe = ((Marca) accesoBD.buscarPorId(Marca.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
>>>>>>> .r18
	}

	@Override
	public boolean existeMarca(String nombre_marca) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		Collection movCol = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "nombre_marca.equals(\""+nombre_marca+"\")";
			movCol = accesoBD.buscarPorFiltro(Marca.class, filtro);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return (movCol != null && movCol.size()>=1);
=======
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<MarcaDTO> marcasDTO = obtenerMarcas();
			for(int i=0; i<marcasDTO.size();i++){
				if (((MarcaDTO)marcasDTO.elementAt(i)).getNombre_marca().equals(nombre_marca)){
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
	public MarcaDTO buscarMarca(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		MarcaDTO marcaDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			MarcaAssembler marcaAssemb = new MarcaAssembler(accesoBD); 
			marcaDTO = marcaAssemb.getMarcaDTO((Marca) accesoBD.buscarPorId(Marca.class, id));
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return marcaDTO;
=======
		AccesoBD accesoBD = new AccesoBD();
		MarcaDTO marcaDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			marcaDTO = MarcaAssembler.getMarcaDTO((Marca) accesoBD.buscarPorId(Marca.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return marcaDTO;
>>>>>>> .r18
	}
	
	@Override
	public MarcaDTO buscarMarca(String nombre_marca) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		MarcaDTO marcaDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "nombre_marca.equals(\""+nombre_marca+"\")";
			Collection movCol = accesoBD.buscarPorFiltro(Marca.class, filtro);
			MarcaAssembler marcaAssemb = new MarcaAssembler(accesoBD); 
			if (movCol.size()>=1){
				marcaDTO = marcaAssemb.getMarcaDTO((Marca)(movCol.toArray())[0]);
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			System.out.println("entre en el roolback");
			accesoBD.rollbackTransaccion();
		}
		return marcaDTO;
=======
		AccesoBD accesoBD = new AccesoBD();
		MarcaDTO marcaDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<MarcaDTO> marcasDTO = obtenerMarcas();
				for(int i=0; i<marcasDTO.size();i++){
					if (((MarcaDTO)marcasDTO.elementAt(i)).getNombre_marca().equals(nombre_marca)){
						marcaDTO = (MarcaDTO)marcasDTO.elementAt(i);
						break;
					}
				}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return marcaDTO;
>>>>>>> .r18
	}

}
