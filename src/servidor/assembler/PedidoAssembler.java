package servidor.assembler;

import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Pedido;

import common.DTOs.PedidoDTO;

public class PedidoAssembler {

	private AccesoBD accesoBD;

	public PedidoAssembler(AccesoBD accesoBD) {
		this.accesoBD = accesoBD;
	}

	public PedidoDTO getPedidoDTO(Pedido pedido) {
		PedidoDTO pedidoDTO = new PedidoDTO();
		pedidoDTO.setId(pedido.getId());
		pedidoDTO.setNumero_pedido(pedido.getNumero_pedido());
		pedidoDTO.setFecha_recepcion_fabrica(pedido.getFecha_recepcion_fabrica());
		pedidoDTO.setFecha_solicitud_fabrica(pedido.getFecha_solicitud_fabrica());
		pedidoDTO.setFecha_solicitud_pedido(pedido.getFecha_solicitud_pedido());
		pedidoDTO.setPnc(pedido.getPnc());
		ReclamoAssembler reclamoAssemb = new ReclamoAssembler(accesoBD);
		pedidoDTO.setReclamo(reclamoAssemb.getReclamoDTO(pedido.getReclamo()));
		return pedidoDTO;
	}

	public Pedido getPedido(PedidoDTO pedidoDTO) {
		Pedido pedido = (Pedido) accesoBD.buscarPorId(Pedido.class, pedidoDTO.getId());
		pedido.setId(pedidoDTO.getId());
		pedido.setNumero_pedido(pedidoDTO.getNumero_pedido());
		pedido.setFecha_recepcion_fabrica(pedidoDTO.getFecha_recepcion_fabrica());
		pedido.setFecha_solicitud_fabrica(pedidoDTO.getFecha_solicitud_fabrica());
		pedido.setFecha_solicitud_pedido(pedidoDTO.getFecha_solicitud_pedido());
		pedido.setPnc(pedidoDTO.getPnc());
		ReclamoAssembler reclamoAssemb = new ReclamoAssembler(accesoBD);
		pedido.setReclamo(reclamoAssemb.getReclamo(pedidoDTO.getReclamo()));
		return pedido;
	}

	public Pedido getPedidoNuevo(PedidoDTO pedidoDTO) {
		Pedido pedido = new Pedido();
		pedido.setId(pedidoDTO.getId());
		pedido.setNumero_pedido(pedidoDTO.getNumero_pedido());
		pedido.setFecha_recepcion_fabrica(pedidoDTO.getFecha_recepcion_fabrica());
		pedido.setFecha_solicitud_fabrica(pedidoDTO.getFecha_solicitud_fabrica());
		pedido.setFecha_solicitud_pedido(pedidoDTO.getFecha_solicitud_pedido());
		pedido.setPnc(pedidoDTO.getPnc());
		ReclamoAssembler reclamoAssemb = new ReclamoAssembler(accesoBD);
		pedido.setReclamo(reclamoAssemb.getReclamo(pedidoDTO.getReclamo()));
		return pedido;
	}

}