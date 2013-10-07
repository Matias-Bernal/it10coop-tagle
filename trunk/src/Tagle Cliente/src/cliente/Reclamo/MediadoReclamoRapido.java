package cliente.Reclamo;

import java.util.Vector;

import cliente.MediadorAccionesIniciarPrograma;
import cliente.MediadorPrincipal;

import common.DTOs.AgenteDTO;
import common.DTOs.EntidadDTO;
import common.DTOs.MTelefonoDTO;
import common.DTOs.MarcaDTO;
import common.DTOs.ModeloDTO;
import common.DTOs.OrdenDTO;
import common.DTOs.Orden_ReclamoDTO;
import common.DTOs.ReclamanteDTO;
import common.DTOs.ReclamoDTO;
import common.DTOs.RegistranteDTO;
import common.DTOs.VehiculoDTO;
import common.GestionarAgente.IControlAgente;
import common.GestionarEntidad.IControlEntidad;
import common.GestionarMTelefono.IControlMTelefono;
import common.GestionarMarca.IControlMarca;
import common.GestionarModelo.IControlModelo;
import common.GestionarOrden.IControlOrden;
import common.GestionarOrden_Reclamo.IControlOrden_Reclamo;
import common.GestionarReclamante.IControlReclamante;
import common.GestionarReclamo.IControlReclamo;
import common.GestionarRegistrante.IControlRegistrante;
import common.GestionarVehiculo.IControlVehiculo;

public class MediadoReclamoRapido {

	private MediadorPrincipal mediadorPrincipal;
	
	private GUIAltaReclamo guiAltaReclamo;
	
	private GUIBuscarOrden guiBuscarOrden;
	private GUIBuscarReclamante guiBuscarReclamante;
	private GUIBuscarVehiculo guiBuscarVehiculo;
	
	public MediadoReclamoRapido(MediadorPrincipal mediadorPrincipal){
		this.setMediadorPrincipal(mediadorPrincipal);
	}

	public void altaReclamo() {
		guiAltaReclamo = new GUIAltaReclamo(this);
		guiAltaReclamo.setVisible(true);
		
	}

	public Vector<String> obtenerNombresEntidades() {
		Vector<EntidadDTO> entidadesDTO = new Vector<EntidadDTO>();
		Vector<String> entidades = new Vector<String>();
		try {
			IControlEntidad iControlEntidad = MediadorAccionesIniciarPrograma.getControlEntidad();
			entidadesDTO = iControlEntidad.obtenerEntidad();
			for (int i=0;i<entidadesDTO.size();i++){
				entidades.add(entidadesDTO.elementAt(i).getNombre_registrante());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entidades;
	}
	public Vector<String> obtenerNombresAgentes() {
		Vector<AgenteDTO> agentesDTO = new Vector<AgenteDTO>();
		Vector<String> agentes = new Vector<String>();
		try {
			IControlAgente iControlAgente = MediadorAccionesIniciarPrograma.getControlAgente();
			agentesDTO = iControlAgente.obtenerAgentes();
			for (int i=0;i<agentesDTO.size();i++){
				agentes.add(agentesDTO.elementAt(i).getNombre_registrante());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return agentes;
	}
	public Vector<OrdenDTO> obtenerOrdenes() {
		Vector<OrdenDTO> ordenes = new Vector<OrdenDTO>();
		try {
			IControlOrden iControlOrden = MediadorAccionesIniciarPrograma.getControlOrden();
			ordenes = iControlOrden.obtenerOrdenes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ordenes;
	}
	public Vector<ReclamanteDTO> obtenerReclamantes() {
		Vector<ReclamanteDTO> reclamantes = new Vector<ReclamanteDTO>();
		try {
			IControlReclamante iControlReclamnte = MediadorAccionesIniciarPrograma.getControlReclamante();
			reclamantes = iControlReclamnte.obtenerReclamantes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reclamantes;
	}
	public Vector<VehiculoDTO> obtenerVehiculos() {
		Vector<VehiculoDTO> vehiculos = new Vector<VehiculoDTO>();
		try {
			IControlVehiculo iControlVehiculo = MediadorAccionesIniciarPrograma.getControlVehiculo();
			vehiculos = iControlVehiculo.obtenerVehiculos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehiculos;
	}
	public Vector<String> obtenerTelefonos(ReclamanteDTO reclamante){
		Vector<String> telefonos = new Vector<String>();
		Vector<MTelefonoDTO> telefonosDTO = new Vector<MTelefonoDTO>();
		try {
			IControlMTelefono iControlMTelefonos = MediadorAccionesIniciarPrograma.getControlMTelefono();
			telefonosDTO = iControlMTelefonos.obtenerMTelefono(reclamante);
			for (int i=0; i< telefonosDTO.size();i++){
				telefonos.add(telefonosDTO.elementAt(i).getTelefono());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return telefonos;
	}
	public Vector<String> obtenerNombresMarcas() {
		Vector<String> marcas = new Vector<String>();
		Vector<MarcaDTO> marcasDTO = new Vector<MarcaDTO>();
		try {
			IControlMarca iControlMarca = MediadorAccionesIniciarPrograma.getControlMarca();
			marcasDTO = iControlMarca.obtenerMarcas();
			for (int i=0; i< marcasDTO.size();i++){
				marcas.add(marcasDTO.elementAt(i).getNombre_marca());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return marcas;
	}
	public Vector<String> obtenerNombresModelos() {
		Vector<String> modelos = new Vector<String>();
		Vector<ModeloDTO> modelosDTO = new Vector<ModeloDTO>();
		try {
			IControlModelo iControlModelo = MediadorAccionesIniciarPrograma.getControlModelo();
			modelosDTO = iControlModelo.obtenerModelos();
			for (int i=0; i< modelosDTO.size();i++){
				modelos.add(modelosDTO.elementAt(i).getNombre_modelo());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelos;
	}
	
	public void setOrden(String id_orden) {
		try {
			IControlOrden iControlOrden = MediadorAccionesIniciarPrograma.getControlOrden();
			OrdenDTO orden;
			orden = iControlOrden.buscarOrden(new Long(id_orden));
			if(guiAltaReclamo.isOrden_desdeEntidad()){
				guiAltaReclamo.setOrdenEntidad(orden);
			}else{
				guiAltaReclamo.setOrdenAgente(orden);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	public void setReclamante(String id_reclamante) {
		try {
			IControlReclamante iControlReclamante = MediadorAccionesIniciarPrograma.getControlReclamante();
			ReclamanteDTO reclamante;
			reclamante = iControlReclamante.buscarReclamante(new Long(id_reclamante));
			if(guiAltaReclamo.isReclamante_desdeEntidad()){
				guiAltaReclamo.setReclamanteEntidad(reclamante);
			}else{
				guiAltaReclamo.setReclamanteAgente(reclamante);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setVehiculo(String id_vehiculo) {
		try {
			IControlVehiculo iControlVehiculo = MediadorAccionesIniciarPrograma.getControlVehiculo();
			VehiculoDTO vehiculo;
			vehiculo = iControlVehiculo.buscarVehiculo(new Long(id_vehiculo));
			if(guiAltaReclamo.isVehiculo_desdeEntidad()){
				guiAltaReclamo.setVehiculoEntidad(vehiculo);
			}else{
				guiAltaReclamo.setVehiculoAgente(vehiculo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buscarOrden() {
		guiBuscarOrden = new GUIBuscarOrden(this);
		guiBuscarOrden.setVisible(true);
	}
	public void buscarReclamante() {
		guiBuscarReclamante = new GUIBuscarReclamante(this);
		guiBuscarReclamante.setVisible(true);
	}
	public void buscarVehiculo() {
		guiBuscarVehiculo = new GUIBuscarVehiculo(this);
		guiBuscarVehiculo.setVisible(true);
	}


	public MediadorPrincipal getMediadorPrincipal() {
		return mediadorPrincipal;
	}

	public void setMediadorPrincipal(MediadorPrincipal mediadorPrincipal) {
		this.mediadorPrincipal = mediadorPrincipal;
	}

	public boolean nuevoReclamoEntidad(String nombre_registrante, String nombre_reclamante,
			String dni_reclamante,String email_registrante,  Vector<String> telefonos_reclamante, String nombre_titular,
			String dominio, String vin, String nombre_marca, String nombre_modelo,
			String numero_orden, java.sql.Date fechaApertura,
			java.sql.Date fechaReclamo, String descipcion, Boolean peligroso,
			Boolean inmovilizado) {
		
		boolean res = false;
		RegistranteDTO registrante = new RegistranteDTO();
		ReclamanteDTO reclamante = new ReclamanteDTO();
		MTelefonoDTO mTelefono = new MTelefonoDTO();
		VehiculoDTO vehiculo = new VehiculoDTO();
		MarcaDTO marca = new MarcaDTO();
		ModeloDTO modelo = new ModeloDTO();
		OrdenDTO orden = new OrdenDTO();
		ReclamoDTO reclamo = new ReclamoDTO();
		Orden_ReclamoDTO orden_reclamo = new Orden_ReclamoDTO();
		
		try {
			IControlRegistrante iControlRegistrante = MediadorAccionesIniciarPrograma.getControlRegistrante();
			IControlReclamante iControlReclamante = MediadorAccionesIniciarPrograma.getControlReclamante();
			IControlMTelefono iControlMTelefono = MediadorAccionesIniciarPrograma.getControlMTelefono();
			IControlVehiculo iControlVehiculo = MediadorAccionesIniciarPrograma.getControlVehiculo();
			IControlMarca iControlMarca = MediadorAccionesIniciarPrograma.getControlMarca();
			IControlModelo iControlModelo = MediadorAccionesIniciarPrograma.getControlModelo();
			IControlOrden iControlOrden = MediadorAccionesIniciarPrograma.getControlOrden();
			IControlReclamo iControlReclamo = MediadorAccionesIniciarPrograma.getControlReclamo();
			IControlOrden_Reclamo iControlOrden_Reclamo = MediadorAccionesIniciarPrograma.getControlOrden_Reclamo();

			//REGISTRATE
			if (iControlRegistrante.existeRegistrante(nombre_registrante)){
				registrante = iControlRegistrante.buscarRegistranteDTO(nombre_registrante);
			}else{
				registrante.setNombre_registrante(nombre_registrante);
				registrante.setId(iControlRegistrante.agregarRegistranteDTO(registrante));
			}
			//RECLAMANTE
			if(iControlReclamante.existeReclamanteDni(dni_reclamante)){
				reclamante = iControlReclamante.buscarReclamanteDni(dni_reclamante);
			}else{
				reclamante.setDni(dni_reclamante);
				reclamante.setEmail(email_registrante);
				reclamante.setNombre_apellido(nombre_reclamante);
				reclamante.setId(iControlReclamante.agregarReclamante(reclamante));
			}
			//MTELEFONO
			Vector<MTelefonoDTO> telefonosDTO = new Vector<MTelefonoDTO>();
			telefonosDTO = iControlMTelefono.obtenerMTelefono(reclamante);
			for (int i = 0; i< telefonosDTO.size(); i++){
				if (!telefonos_reclamante.contains(telefonosDTO.elementAt(i).getTelefono())){
					iControlMTelefono.eliminarMTelefono(telefonosDTO.elementAt(i).getId());
				}else{
					telefonos_reclamante.remove(telefonosDTO.elementAt(i).getTelefono());
				}
			}
			for (int i = 0; i< telefonos_reclamante.size(); i++){
				//TODO ARREGLAR INSERTA UN TELEFONO EN BLANCO DE MAS
				if(!telefonos_reclamante.elementAt(i).equals("")){
					MTelefonoDTO mtelefono = new MTelefonoDTO(reclamante, telefonos_reclamante.elementAt(i));
					iControlMTelefono.agregarMTelefono(mtelefono);
				}
			}
			//VEHICULO
			if(iControlVehiculo.existeVehiculo(dominio)){
				vehiculo = iControlVehiculo.buscarVehiculo(dominio);
			}else{
				vehiculo.setDominio(dominio);
				vehiculo.setNombre_titular(nombre_titular);
				vehiculo.setVin(vin);
				if(iControlMarca.existeMarca(nombre_marca)){
					marca = iControlMarca.buscarMarca(nombre_marca);
				}else{
					marca.setNombre_marca(nombre_marca);
					marca.setId(iControlMarca.agregarMarca(marca));
				}
				vehiculo.setMarca(marca);
				if(iControlModelo.existeModelo(nombre_modelo)){
					modelo = iControlModelo.buscarModelo(nombre_modelo);
				}else{
					modelo.setNombre_modelo(nombre_modelo);
					modelo.setMarca(marca);
					modelo.setId(iControlModelo.agregarModelo(modelo));
				}
				vehiculo.setModelo(modelo);
				vehiculo.setId(iControlVehiculo.agregarVehiculo(vehiculo));
			}
			//ORDEN
			if(iControlOrden.existeOrden(numero_orden)){
				orden = iControlOrden.buscarOrden(numero_orden);
			}else{
				orden.setFecha_apertura(fechaApertura);
				orden.setNumero_orden(numero_orden);
				orden.setEstado("SIN RECLAMO");
				orden.setId(iControlOrden.agregarOrden(orden));
			}
			//RECLAMO
			if(iControlReclamo.existeReclamo(fechaReclamo, reclamante, vehiculo)){
				reclamo = iControlReclamo.buscarReclamo(fechaReclamo, reclamante, vehiculo);
			}else{
				reclamo.setFecha_reclamo(fechaReclamo);
				reclamo.setEstado_reclamo("ABIERTO/SIN PEDIDO/SIN TURNO");
				reclamo.setDescripcion(descipcion);
				reclamo.setInmovilizado(inmovilizado);
				reclamo.setPeligroso(peligroso);
				reclamo.setOrden(orden);
				reclamo.setReclamante(reclamante);
				reclamo.setRegistrante(registrante);
				reclamo.setVehiculo(vehiculo);
				reclamo.setUsuario(mediadorPrincipal.getUsuario());
				reclamo.setId(iControlReclamo.agregarReclamo(reclamo));
			}
			//RECLAMO-ORDEN
			if(iControlOrden_Reclamo.existeOrden_Reclamo(orden, reclamo)){
				orden_reclamo = iControlOrden_Reclamo.buscarOrden_Reclamo(orden, reclamo);
			}else{
				orden.setEstado("ABIERTA/SIN RECURSO");
				iControlOrden.modificarOrden(orden.getId(), orden);
				orden_reclamo.setOrden(orden);
				orden_reclamo.setReclamo(reclamo);
				orden_reclamo.setId(iControlOrden_Reclamo.agregarOrden_Reclamo(orden_reclamo));
			}
			res= true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}