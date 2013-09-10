package servidor.GestionarModelo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.MarcaAssembler;
import servidor.assembler.ModeloAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Modelo;

import common.DTOs.MarcaDTO;
import common.DTOs.ModeloDTO;
import common.GestionarModelo.IControlModelo;

public class ControlModelo extends UnicastRemoteObject implements IControlModelo{

	private static final long serialVersionUID = 1L;

	protected ControlModelo() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
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
	}

	@Override
	public void eliminarModelo(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Modelo modelo = ModeloAssembler.getModelo(buscarModelo(id));
			accesoBD.eliminar(modelo);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public void modificarModelo(Long id, ModeloDTO modificado) throws Exception {
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
	}

	@Override
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
	}

	@Override
	public boolean existeModelo(Long id) throws Exception {
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
	}

	@Override
	public boolean existeModelo(String nombre_modelo) throws Exception {
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
	}

	@Override
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
	}

	@Override
	public ModeloDTO buscarModelo(Long id) throws Exception {
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
	}

	@Override
	public ModeloDTO buscarModelo(String nombre_modelo) throws Exception {
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
	}

	@Override
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
	}

}