package servidor.GestionarModelo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.Vector;

<<<<<<< .mine
import servidor.assembler.Mano_ObraAssembler;
import servidor.assembler.MarcaAssembler;
import servidor.assembler.ModeloAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Mano_Obra;
import servidor.persistencia.dominio.Marca;
import servidor.persistencia.dominio.Modelo;
=======
import servidor.assembler.MarcaAssembler;
import servidor.assembler.ModeloAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Modelo;

>>>>>>> .r18
import common.DTOs.MarcaDTO;
import common.DTOs.ModeloDTO;
import common.GestionarModelo.IControlModelo;

public class ControlModelo extends UnicastRemoteObject implements IControlModelo {

	private static final long serialVersionUID = 1L;

	public ControlModelo() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
<<<<<<< .mine
	public Long agregarModelo(ModeloDTO modeloDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Long id = new Long(0);
		try {
			accesoBD.iniciarTransaccion();
			ModeloAssembler modeloAssemb = new ModeloAssembler(accesoBD);
			Modelo modelo = modeloAssemb.getModeloNuevo(modeloDTO);
			accesoBD.hacerPersistente(modelo);
			id = modelo.getId();
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return id;
=======
	public Long agregarModelo(ModeloDTO modeloDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Modelo modelo = ModeloAssembler.getModelo(modeloDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(modelo);
			id=modelo.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
>>>>>>> .r18
	}

	@Override
	public void eliminarModelo(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			ModeloAssembler modeloAssemb = new ModeloAssembler(accesoBD);
			Modelo modelo = modeloAssemb.getModelo(buscarModelo(id));
			accesoBD.eliminar(modelo);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
=======
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Modelo modelo = ModeloAssembler.getModelo(buscarModelo(id));
			accesoBD.eliminar(modelo);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
>>>>>>> .r18
	}

	@Override
	public void modificarModelo(Long id, ModeloDTO modificado) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			ModeloAssembler modeloAssemb = new ModeloAssembler(accesoBD);
			Modelo modelo = modeloAssemb.getModelo(buscarModelo(id));
			modelo.setNombre_modelo(modificado.getNombre_modelo());
			MarcaAssembler marcaAssemb = new MarcaAssembler(accesoBD);
			modelo.setMarca(marcaAssemb.getMarca(modificado.getMarca()));
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<ModeloDTO> obtenerModelos() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<ModeloDTO> modelosDTO = new Vector<ModeloDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Modelo> modelos = (Vector<Modelo>) accesoBD.buscarPorFiltro(Modelo.class, "");
			for (int i = 0; i < modelos.size(); i++) {
				ModeloDTO modeloDTO = new ModeloDTO();
				modeloDTO.setId(modelos.elementAt(i).getId());
				modeloDTO.setNombre_modelo(modelos.elementAt(i).getNombre_modelo());
				MarcaAssembler marcaAssemb = new MarcaAssembler(accesoBD);
				modeloDTO.setMarca(marcaAssemb.getMarcaDTO(modelos.elementAt(i).getMarca()));
				modelosDTO.add(modeloDTO);
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return modelosDTO;
=======
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Modelo modelo = ModeloAssembler.getModelo(buscarModelo(id));
			modelo.setNombre_modelo(modificado.getNombre_modelo());
			modelo.setMarca(MarcaAssembler.getMarca(modificado.getMarca()));
			accesoBD.hacerPersistente(modelo);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}		
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public Vector<ModeloDTO> obtenerModelos(MarcaDTO marca) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<ModeloDTO> modelosDTO = new Vector<ModeloDTO>();
		try {
			accesoBD.iniciarTransaccion();
=======
	public Vector<ModeloDTO> obtenerModelos() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<ModeloDTO> modelosDTO = new Vector<ModeloDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Modelo> modelos = (Vector<Modelo>) accesoBD.buscarPorFiltro(Modelo.class,"id ascending");
			for(int i=0; i<modelos.size();i++){
				ModeloDTO modeloDTO = new ModeloDTO();
				modeloDTO.setId(((Modelo)modelos.elementAt(i)).getId());
				modeloDTO.setNombre_modelo(((Modelo)modelos.elementAt(i)).getNombre_modelo());
				modeloDTO.setMarca(MarcaAssembler.getMarcaDTO(((Modelo)modelos.elementAt(i)).getMarca()));
				modelosDTO.add(modeloDTO);
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return modelosDTO;
	}
>>>>>>> .r18

<<<<<<< .mine
			String filtro = "marca.id == "+marca.getId();
			Collection modelos = accesoBD.buscarPorFiltro(Modelo.class, filtro);
			ModeloAssembler modeloAssemb = new ModeloAssembler(accesoBD);
			for (int i = 0; i < modelos.size(); i++) {
				modelosDTO.add(modeloAssemb.getModeloDTO((Modelo)(modelos.toArray()[i])));
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return modelosDTO;
=======
	@Override
	public Vector<ModeloDTO> obtenerModelos(MarcaDTO marca) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<ModeloDTO> modelosDTO = new Vector<ModeloDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Modelo> modelos = (Vector<Modelo>) accesoBD.buscarPorFiltro(Modelo.class,"id ascending");
			for(int i=0; i<modelos.size();i++){
				if (((Modelo)modelos.elementAt(i)).getMarca().getId().equals(marca.getId())){
					ModeloDTO modeloDTO = new ModeloDTO();
					modeloDTO.setId(((Modelo)modelos.elementAt(i)).getId());
					modeloDTO.setNombre_modelo(((Modelo)modelos.elementAt(i)).getNombre_modelo());
					modeloDTO.setMarca(MarcaAssembler.getMarcaDTO(((Modelo)modelos.elementAt(i)).getMarca()));
					modelosDTO.add(modeloDTO);
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return modelosDTO;
>>>>>>> .r18
	}

	@Override
	public boolean existeModelo(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Modelo) accesoBD.buscarPorId(Modelo.class, id) == null);
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
			existe = ((Modelo) accesoBD.buscarPorId(Modelo.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
>>>>>>> .r18
	}

	@Override
	public boolean existeModelo(String nombre_modelo) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		Collection movCol = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "nombre_modelo.equals(\""+nombre_modelo+"\")";
			movCol = accesoBD.buscarPorFiltro(Modelo.class, filtro);
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
			Vector<ModeloDTO> modelosDTO = obtenerModelos();
			for(int i=0; i<modelosDTO.size();i++){
				if (((ModeloDTO)modelosDTO.elementAt(i)).getNombre_modelo().equals(nombre_modelo)){
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
	public boolean existeModelo(MarcaDTO marca, String nombre_modelo) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Collection movCol = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "marca.id == "+marca.getId()+" && nombre_modelo.equals(\""+nombre_modelo+"\")";
			movCol = accesoBD.buscarPorFiltro(Modelo.class, filtro);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return (movCol != null && movCol.size()>=1);
=======
	public boolean existeModelo(MarcaDTO marca, String nombre_modelo) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<ModeloDTO> modelosDTO = obtenerModelos();
			for(int i=0; i<modelosDTO.size();i++){
				if (((ModeloDTO)modelosDTO.elementAt(i)).getNombre_modelo().equals(nombre_modelo) && ((ModeloDTO)modelosDTO.elementAt(i)).getMarca().getId().equals(marca.getId())){
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
	public ModeloDTO buscarModelo(Long id) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		ModeloDTO modeloDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			ModeloAssembler modeloAssemb = new ModeloAssembler(accesoBD);
			modeloDTO = modeloAssemb.getModeloDTO((Modelo) accesoBD.buscarPorId(Modelo.class, id));
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return modeloDTO;
=======
		AccesoBD accesoBD = new AccesoBD();
		ModeloDTO modeloDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			modeloDTO = ModeloAssembler.getModeloDTO((Modelo) accesoBD.buscarPorId(Modelo.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return modeloDTO;
>>>>>>> .r18
	}

	@Override
	public ModeloDTO buscarModelo(String nombre_modelo) throws Exception {
<<<<<<< .mine
		AccesoBD accesoBD = new AccesoBD();
		ModeloDTO modeloDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "nombre_modelo.equals(\""+nombre_modelo+"\")";
			Collection movCol = accesoBD.buscarPorFiltro(Modelo.class, filtro);
			ModeloAssembler modeloAssemb = new ModeloAssembler(accesoBD); 
			if (movCol.size()>=1){
				modeloDTO = modeloAssemb.getModeloDTO((Modelo)(movCol.toArray())[0]);
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			System.out.println("entre en el roolback");
			accesoBD.rollbackTransaccion();
		}
		return modeloDTO;
=======
		AccesoBD accesoBD = new AccesoBD();
		ModeloDTO modeloDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<ModeloDTO> modelosDTO = obtenerModelos();
				for(int i=0; i<modelosDTO.size();i++){
					if (((ModeloDTO)modelosDTO.elementAt(i)).getNombre_modelo().equals(nombre_modelo)){
						modeloDTO = (ModeloDTO)modelosDTO.elementAt(i);
						break;
					}
				}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return modeloDTO;
>>>>>>> .r18
	}

	@Override
<<<<<<< .mine
	public ModeloDTO buscarModelo(MarcaDTO marca, String nombre_modelo)	throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		ModeloDTO modeloDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			String filtro = "marca.id == "+marca.getId()+" && nombre_modelo.equals(\""+nombre_modelo+"\")";
			Collection movCol = accesoBD.buscarPorFiltro(Modelo.class, filtro);
			ModeloAssembler modeloAssemb = new ModeloAssembler(accesoBD); 
			if (movCol.size()>=1){
				modeloDTO = modeloAssemb.getModeloDTO((Modelo)(movCol.toArray())[0]);
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			System.out.println("entre en el roolback");
			accesoBD.rollbackTransaccion();
		}
		return modeloDTO;
=======
	public ModeloDTO buscarModelo(MarcaDTO marca, String nombre_modelo) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		ModeloDTO modeloDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<ModeloDTO> modelosDTO = obtenerModelos();
				for(int i=0; i<modelosDTO.size();i++){
					if (((ModeloDTO)modelosDTO.elementAt(i)).getNombre_modelo().equals(nombre_modelo)&& ((ModeloDTO)modelosDTO.elementAt(i)).getMarca().getId().equals(marca.getId())){
						modeloDTO = (ModeloDTO)modelosDTO.elementAt(i);
						break;
					}
				}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return modeloDTO;
>>>>>>> .r18
	}

}