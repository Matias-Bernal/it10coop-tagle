package servidor.GestionarVehiculo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.MarcaAssembler;
import servidor.assembler.ModeloAssembler;
import servidor.assembler.VehiculoAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Vehiculo;

import common.DTOs.MarcaDTO;
import common.DTOs.ModeloDTO;
import common.DTOs.VehiculoDTO;
import common.GestionarVehiculo.IControlVehiculo;

public class ControlVehiculo extends UnicastRemoteObject implements IControlVehiculo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ControlVehiculo() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarVehiculo(VehiculoDTO vehiculoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vehiculo nuevovehiculo = VehiculoAssembler.getVehiculo(vehiculoDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(nuevovehiculo);
			id=nuevovehiculo.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarVehiculo(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Vehiculo vehiculo = VehiculoAssembler.getVehiculo(buscarVehiculo(id));
			accesoBD.eliminar(vehiculo);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}	
		
	}

	@Override
	public void modificarVehiculo(Long id, VehiculoDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Vehiculo vehiculo = VehiculoAssembler.getVehiculo(buscarVehiculo(id));
			
			vehiculo.setDominio(modificado.getDominio());
			vehiculo.setNombre_titular(modificado.getNombre_titular());
			vehiculo.setVin(modificado.getVin());
			vehiculo.setMarca(MarcaAssembler.getMarca(modificado.getMarca()));
			vehiculo.setModelo(ModeloAssembler.getModelo(modificado.getModelo()));

			accesoBD.hacerPersistente(vehiculo);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<VehiculoDTO> obtenerVehiculos() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<VehiculoDTO> vehiculosDTO = new Vector<VehiculoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Vehiculo> vehiculos= (Vector<Vehiculo>) accesoBD.buscarPorFiltro(Vehiculo.class,"id ascending");
			for(int i=0; i<vehiculos.size();i++){
				VehiculoDTO vehiculoDTO = new VehiculoDTO();
				vehiculoDTO.setId(((Vehiculo)vehiculos.elementAt(i)).getId());
				vehiculoDTO.setDominio(((Vehiculo)vehiculos.elementAt(i)).getDominio());
				vehiculoDTO.setNombre_titular(((Vehiculo)vehiculos.elementAt(i)).getNombre_titular());
				vehiculoDTO.setVin(((Vehiculo)vehiculos.elementAt(i)).getNombre_titular());
				vehiculoDTO.setMarca(MarcaAssembler.getMarcaDTO(((Vehiculo)vehiculos.elementAt(i)).getMarca()));
				vehiculoDTO.setModelo(ModeloAssembler.getModeloDTO(((Vehiculo)vehiculos.elementAt(i)).getModelo()));
				vehiculosDTO.add(vehiculoDTO);
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return vehiculosDTO;
	}

	@Override
	public Vector<VehiculoDTO> obtenerVehiculos(MarcaDTO marca) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<VehiculoDTO> vehiculosDTO = new Vector<VehiculoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Vehiculo> vehiculos= (Vector<Vehiculo>) accesoBD.buscarPorFiltro(Vehiculo.class,"id ascending");
			for(int i=0; i<vehiculos.size();i++){
				if ((vehiculos.elementAt(i)).getMarca().getId().equals(marca.getId())){
					VehiculoDTO vehiculoDTO = new VehiculoDTO();
					vehiculoDTO.setId(((Vehiculo)vehiculos.elementAt(i)).getId());
					vehiculoDTO.setDominio(((Vehiculo)vehiculos.elementAt(i)).getDominio());
					vehiculoDTO.setNombre_titular(((Vehiculo)vehiculos.elementAt(i)).getNombre_titular());
					vehiculoDTO.setVin(((Vehiculo)vehiculos.elementAt(i)).getNombre_titular());
					vehiculoDTO.setMarca(MarcaAssembler.getMarcaDTO(((Vehiculo)vehiculos.elementAt(i)).getMarca()));
					vehiculoDTO.setModelo(ModeloAssembler.getModeloDTO(((Vehiculo)vehiculos.elementAt(i)).getModelo()));
					vehiculosDTO.add(vehiculoDTO);
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return vehiculosDTO;
	}

	@Override
	public Vector<VehiculoDTO> obtenerVehiculos(ModeloDTO modelo) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<VehiculoDTO> vehiculosDTO = new Vector<VehiculoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Vehiculo> vehiculos= (Vector<Vehiculo>) accesoBD.buscarPorFiltro(Vehiculo.class,"id ascending");
			for(int i=0; i<vehiculos.size();i++){
				if ((vehiculos.elementAt(i)).getModelo().getId().equals(modelo.getId())){
					VehiculoDTO vehiculoDTO = new VehiculoDTO();
					vehiculoDTO.setId(((Vehiculo)vehiculos.elementAt(i)).getId());
					vehiculoDTO.setDominio(((Vehiculo)vehiculos.elementAt(i)).getDominio());
					vehiculoDTO.setNombre_titular(((Vehiculo)vehiculos.elementAt(i)).getNombre_titular());
					vehiculoDTO.setVin(((Vehiculo)vehiculos.elementAt(i)).getNombre_titular());
					vehiculoDTO.setMarca(MarcaAssembler.getMarcaDTO(((Vehiculo)vehiculos.elementAt(i)).getMarca()));
					vehiculoDTO.setModelo(ModeloAssembler.getModeloDTO(((Vehiculo)vehiculos.elementAt(i)).getModelo()));
					vehiculosDTO.add(vehiculoDTO);
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return vehiculosDTO;
	}

	@Override
	public boolean existeVehiculo(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Vehiculo) accesoBD.buscarPorId(Vehiculo.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existeVehiculo(String dominio) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<VehiculoDTO> vehiculosDTO = obtenerVehiculos();
			for(int i=0; i<vehiculosDTO.size();i++){
				if (((VehiculoDTO)vehiculosDTO.elementAt(i)).getDominio().equals(dominio)){
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
	public VehiculoDTO buscarVehiculo(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		VehiculoDTO vehiculoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			vehiculoDTO = VehiculoAssembler.getVehiculoDTO((Vehiculo) accesoBD.buscarPorId(Vehiculo.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return vehiculoDTO;
	}

	@Override
	public VehiculoDTO buscarVehiculo(String dominio) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		VehiculoDTO vehiculoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<VehiculoDTO> vehiculosDTO = obtenerVehiculos();
			for(int i=0; i<vehiculosDTO.size();i++){
				if (((VehiculoDTO)vehiculosDTO.elementAt(i)).getDominio().equals(dominio)){
					vehiculoDTO = (VehiculoDTO)vehiculosDTO.elementAt(i);
					break;
				}
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return vehiculoDTO;
	}


}