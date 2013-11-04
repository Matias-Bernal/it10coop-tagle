package cliente.Repuesto;

import java.sql.Date;
import java.util.Vector;

import cliente.MediadorAccionesIniciarPrograma;
import cliente.MediadorPrincipal;

import common.DTOs.Pedido_PiezaDTO;
import common.DTOs.Reclamo_AgenteDTO;
import common.DTOs.Reclamo_FabricaDTO;
import common.DTOs.RegistranteDTO;
import common.GestionarAgente.IControlAgente;
import common.GestionarEntidad.IControlEntidad;
import common.GestionarPedido_Pieza.IControlPedido_Pieza;
import common.GestionarReclamo_Agente.IControlReclamo_Agente;
import common.GestionarReclamo_Fabrica.IControlReclamo_Fabrica;

public class MediadorReclamos {
	
	private MediadorPrincipal mediadorPrincipal;
	
	private GUIReclamo guiReclamo;
	

	public MediadorReclamos(MediadorPrincipal mediadorPrincipal) {
		this.setMediadorPrincipal(mediadorPrincipal);
	}
	
	public void mostrarRepuesto(){
		guiReclamo = new GUIReclamo(this);
		guiReclamo.setVisible(true);
	}

	public MediadorPrincipal getMediadorPrincipal() {
		return mediadorPrincipal;
	}

	public void setMediadorPrincipal(MediadorPrincipal mediadorPrincipal) {
		this.mediadorPrincipal = mediadorPrincipal;
	}

	public Vector<Pedido_PiezaDTO> obtenerPedido_Pieza_Agente() {
		Vector<Pedido_PiezaDTO> pedios_piezas = new Vector<Pedido_PiezaDTO>();
		IControlPedido_Pieza iControlPedido_Pieza = MediadorAccionesIniciarPrograma.getControlPedido_Pieza();
		try {
			Vector<Pedido_PiezaDTO> pedios_piezasDTO = iControlPedido_Pieza.obtenerPedido_Pieza();
			for (int i = 0; i<pedios_piezasDTO.size();i++){
				if (esAgente(pedios_piezasDTO.elementAt(i).getPedido().getReclamo().getRegistrante())){
					pedios_piezas.add(pedios_piezasDTO.elementAt(i));
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error al cargar los pedidos_piezas de agentes");
			e.printStackTrace();
		}
		return pedios_piezas;
	}

	public Vector<Pedido_PiezaDTO> obtenerPedido_Pieza_Entidad() {
		Vector<Pedido_PiezaDTO> pedios_piezas = new Vector<Pedido_PiezaDTO>();
		IControlPedido_Pieza iControlPedido_Pieza = MediadorAccionesIniciarPrograma.getControlPedido_Pieza();
		try {
			Vector<Pedido_PiezaDTO> pedios_piezasDTO = iControlPedido_Pieza.obtenerPedido_Pieza();
			for (int i = 0; i<pedios_piezasDTO.size();i++){
				if (esEntidad(pedios_piezasDTO.elementAt(i).getPedido().getReclamo().getRegistrante())){
					pedios_piezas.add(pedios_piezasDTO.elementAt(i));
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error al cargar los pedidos_piezas de agentes");
			e.printStackTrace();
		}
		return pedios_piezas;
	}
	
	public boolean esEntidad(RegistranteDTO registrante) {
		boolean res = false;
		try {
			IControlEntidad iControlEntidad = MediadorAccionesIniciarPrograma.getControlEntidad();
			res = iControlEntidad.existeEntidad(registrante.getNombre_registrante());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public boolean esAgente(RegistranteDTO registrante) {
		boolean res = false;
		try {
			IControlAgente iControlAgente = MediadorAccionesIniciarPrograma.getControlAgente();
			res = iControlAgente.existeAgente(registrante.getNombre_registrante());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public Integer cantidadReclamosFabrica(Pedido_PiezaDTO pedido_pieza) {
		Integer res = 0;
		IControlReclamo_Fabrica iControlReclamo_Fabrica = MediadorAccionesIniciarPrograma.getControlReclamo_Fabrica();
		try {
			Vector<Reclamo_FabricaDTO> reclamosDTO = iControlReclamo_Fabrica.obtenerReclamo_Fabrica();
			Vector<Reclamo_FabricaDTO> reclamos = new Vector<Reclamo_FabricaDTO>();
			for (int i = 0;i<reclamosDTO.size();i++){
				if(reclamosDTO.elementAt(i).getPedido().getId()==pedido_pieza.getPedido().getId() && reclamosDTO.elementAt(i).getPieza().getId()==pedido_pieza.getPieza().getId())
					reclamos.add(reclamosDTO.elementAt(i));
			}
			res = reclamos.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public Integer cantidadReclamosAgente(Pedido_PiezaDTO pedido_pieza) {
		Integer res = 0;
		IControlReclamo_Agente iControlReclamo_Agente = MediadorAccionesIniciarPrograma.getControlReclamo_Agente();
		try {
			Vector<Reclamo_AgenteDTO> reclamosDTO = iControlReclamo_Agente.obtenerReclamo_Agente();
			Vector<Reclamo_AgenteDTO> reclamos = new Vector<Reclamo_AgenteDTO>();
			for (int i = 0;i<reclamosDTO.size();i++){
				if(reclamosDTO.elementAt(i).getPedido().getId()==pedido_pieza.getPedido().getId() && reclamosDTO.elementAt(i).getPieza().getId()==pedido_pieza.getPieza().getId())
					reclamos.add(reclamosDTO.elementAt(i));
			}
			res = reclamos.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public Date obtenerUltimoReclamoFabrica(Pedido_PiezaDTO pedido_pieza) {
		Date fecha_ultimo_reclamoFabrica = null;
		IControlReclamo_Fabrica iControlReclamo_Fabrica = MediadorAccionesIniciarPrograma.getControlReclamo_Fabrica();
		try {
			Vector<Reclamo_FabricaDTO> reclamosDTO = iControlReclamo_Fabrica.obtenerReclamo_Fabrica();
			Vector<Reclamo_FabricaDTO> reclamos = new Vector<Reclamo_FabricaDTO>();
			for (int i = 0;i<reclamosDTO.size();i++){
				if(reclamosDTO.elementAt(i).getPedido().getId()==pedido_pieza.getPedido().getId() && reclamosDTO.elementAt(i).getPieza().getId()==pedido_pieza.getPieza().getId())
					reclamos.add(reclamosDTO.elementAt(i));
			}
			java.util.Date hoy = new java.util.Date();
			
			for (int i = 0; i<reclamos.size();i++){
				if (fecha_ultimo_reclamoFabrica==null)
					fecha_ultimo_reclamoFabrica = reclamos.elementAt(i).getFecha_reclamo_fabrica();

				if(reclamos.elementAt(i).getFecha_reclamo_fabrica().compareTo(fecha_ultimo_reclamoFabrica)>=0);
					fecha_ultimo_reclamoFabrica = reclamos.elementAt(i).getFecha_reclamo_fabrica();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fecha_ultimo_reclamoFabrica;
	}
	
	public Date obtenerUltimoReclamoAgente(Pedido_PiezaDTO pedido_pieza) {
		Date fecha_ultimo_reclamoAgente = null;
		IControlReclamo_Agente iControlReclamo_Agente = MediadorAccionesIniciarPrograma.getControlReclamo_Agente();
		try {
			Vector<Reclamo_AgenteDTO> reclamosDTO = iControlReclamo_Agente.obtenerReclamo_Agente();
			Vector<Reclamo_AgenteDTO> reclamos = new Vector<Reclamo_AgenteDTO>();
			for (int i = 0;i<reclamosDTO.size();i++){
				if(reclamosDTO.elementAt(i).getPedido().getId()==pedido_pieza.getPedido().getId() && reclamosDTO.elementAt(i).getPieza().getId()==pedido_pieza.getPieza().getId())
					reclamos.add(reclamosDTO.elementAt(i));
			}
			java.util.Date hoy = new java.util.Date();
			
			for (int i = 0; i<reclamos.size();i++){
				if (fecha_ultimo_reclamoAgente==null)
					fecha_ultimo_reclamoAgente = reclamos.elementAt(i).getFecha_reclamo_agente();

				if(reclamos.elementAt(i).getFecha_reclamo_agente().compareTo(fecha_ultimo_reclamoAgente)>=0);
					fecha_ultimo_reclamoAgente = reclamos.elementAt(i).getFecha_reclamo_agente();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fecha_ultimo_reclamoAgente;
	}
}