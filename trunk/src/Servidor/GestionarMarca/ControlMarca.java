package servidor.GestionarMarca;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.MarcaAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Marca;

import common.DTOs.MarcaDTO;
import common.GestionarMarca.IControlMarca;

public class ControlMarca extends UnicastRemoteObject implements IControlMarca {

	private static final long serialVersionUID = 1L;

	protected ControlMarca() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
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
	}

	@Override
	public void eliminarMarca(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Marca marca = MarcaAssembler.getMarca(buscarMarca(id));
			accesoBD.eliminar(marca);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public void modificarMarca(Long id, MarcaDTO modificado) throws Exception {
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
	}
	
	@Override
	public boolean existeMarca(Long id) throws Exception {
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
	}

	@Override
	public boolean existeMarca(String nombre_marca) throws Exception {
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
	}

	@Override
	public MarcaDTO buscarMarca(Long id) throws Exception {
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
	}

	@Override
	public MarcaDTO buscarMarca(String nombre_marca) throws Exception {
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
	}

}
