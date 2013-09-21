package servidor.assembler;

import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Pedido_Pieza;

import common.DTOs.Pedido_PiezaDTO;

public class Pedido_PiezaAssembler {
	
	private AccesoBD accesoBD;

	public Pedido_PiezaAssembler(AccesoBD accesoBD) {
		this.accesoBD = accesoBD;
	}

	public Pedido_PiezaDTO getPedido_PiezaDTO(Pedido_Pieza pedido_Pieza) {
		Pedido_PiezaDTO pedido_PiezaDTO = new Pedido_PiezaDTO();
		pedido_PiezaDTO.setId(pedido_Pieza.getId());
		pedido_PiezaDTO.setFecha_estado(pedido_Pieza.getFecha_estado());
		pedido_PiezaDTO.setPropio(pedido_Pieza.getPropio());
		pedido_PiezaDTO.setStock(pedido_Pieza.getStock());
		BdgAssembler bdgAssemb = new BdgAssembler(accesoBD);
		pedido_PiezaDTO.setBdg(bdgAssemb.getBdgDTO(pedido_Pieza.getBdg()));
		Devolucion_PiezaAssembler devolucion_piezaAssemb = new Devolucion_PiezaAssembler(accesoBD);
		pedido_PiezaDTO.setDevolucion_pieza(devolucion_piezaAssemb.getDevolucion_PiezaDTO(pedido_Pieza.getDevolucion_pieza()));
		Estado_PedidoAssembler estado_pedidoAssemb = new Estado_PedidoAssembler(accesoBD);
		pedido_PiezaDTO.setEstado_pedido(estado_pedidoAssemb.getEstado_PedidoDTO(pedido_Pieza.getEstado_pedido()));
		Mano_ObraAssembler mano_obraAssemb = new Mano_ObraAssembler(accesoBD);
		pedido_PiezaDTO.setMano_obra(mano_obraAssemb.getMano_ObraDTO(pedido_Pieza.getMano_obra()));
		MuletoAssembler muletoAssemb = new MuletoAssembler(accesoBD);
		pedido_PiezaDTO.setMuleto(muletoAssemb.getMuletoDTO(pedido_Pieza.getMuleto()));
		PedidoAssembler pedidoAssemb = new PedidoAssembler(accesoBD);
		pedido_PiezaDTO.setPedido(pedidoAssemb.getPedidoDTO(pedido_Pieza.getPedido()));
		PiezaAssembler piezaAssemb = new PiezaAssembler(accesoBD);
		pedido_PiezaDTO.setPieza(piezaAssemb.getPiezaDTO(pedido_Pieza.getPieza()));

		return pedido_PiezaDTO;
	}

	public Pedido_Pieza getPedido_Pieza(Pedido_PiezaDTO pedido_PiezaDTO) {
		Pedido_Pieza pedido_Pieza = (Pedido_Pieza) accesoBD.buscarPorId(Pedido_Pieza.class, pedido_PiezaDTO.getId());
		pedido_Pieza.setId(pedido_PiezaDTO.getId());
		pedido_Pieza.setFecha_estado(pedido_PiezaDTO.getFecha_estado());
		pedido_Pieza.setPropio(pedido_PiezaDTO.getPropio());
		pedido_Pieza.setStock(pedido_PiezaDTO.getStock());
		BdgAssembler bdgAssemb = new BdgAssembler(accesoBD);
		pedido_Pieza.setBdg(bdgAssemb.getBdg(pedido_PiezaDTO.getBdg()));
		Devolucion_PiezaAssembler devolucion_piezaAssemb = new Devolucion_PiezaAssembler(accesoBD);
		pedido_Pieza.setDevolucion_pieza(devolucion_piezaAssemb.getDevolucion_Pieza(pedido_PiezaDTO.getDevolucion_pieza()));
		Estado_PedidoAssembler estado_pedidoAssemb = new Estado_PedidoAssembler(accesoBD);
		pedido_Pieza.setEstado_pedido(estado_pedidoAssemb.getEstado_Pedido(pedido_PiezaDTO.getEstado_pedido()));
		Mano_ObraAssembler mano_obraAssemb = new Mano_ObraAssembler(accesoBD);
		pedido_Pieza.setMano_obra(mano_obraAssemb.getMano_Obra(pedido_PiezaDTO.getMano_obra()));
		MuletoAssembler muletoAssemb = new MuletoAssembler(accesoBD);
		pedido_Pieza.setMuleto(muletoAssemb.getMuleto(pedido_PiezaDTO.getMuleto()));
		PedidoAssembler pedidoAssemb = new PedidoAssembler(accesoBD);
		pedido_Pieza.setPedido(pedidoAssemb.getPedido(pedido_PiezaDTO.getPedido()));
		PiezaAssembler piezaAssemb = new PiezaAssembler(accesoBD);
		pedido_Pieza.setPieza(piezaAssemb.getPieza(pedido_PiezaDTO.getPieza()));

		return pedido_Pieza;
	}

	public Pedido_Pieza getPedido_PiezaNuevo(Pedido_PiezaDTO pedido_PiezaDTO) {
		Pedido_Pieza pedido_Pieza = new Pedido_Pieza();
		pedido_Pieza.setId(pedido_PiezaDTO.getId());
		pedido_Pieza.setFecha_estado(pedido_PiezaDTO.getFecha_estado());
		pedido_Pieza.setPropio(pedido_PiezaDTO.getPropio());
		pedido_Pieza.setStock(pedido_PiezaDTO.getStock());
		BdgAssembler bdgAssemb = new BdgAssembler(accesoBD);
		pedido_Pieza.setBdg(bdgAssemb.getBdg(pedido_PiezaDTO.getBdg()));
		Devolucion_PiezaAssembler devolucion_piezaAssemb = new Devolucion_PiezaAssembler(accesoBD);
		pedido_Pieza.setDevolucion_pieza(devolucion_piezaAssemb.getDevolucion_Pieza(pedido_PiezaDTO.getDevolucion_pieza()));
		Estado_PedidoAssembler estado_pedidoAssemb = new Estado_PedidoAssembler(accesoBD);
		pedido_Pieza.setEstado_pedido(estado_pedidoAssemb.getEstado_Pedido(pedido_PiezaDTO.getEstado_pedido()));
		Mano_ObraAssembler mano_obraAssemb = new Mano_ObraAssembler(accesoBD);
		pedido_Pieza.setMano_obra(mano_obraAssemb.getMano_Obra(pedido_PiezaDTO.getMano_obra()));
		MuletoAssembler muletoAssemb = new MuletoAssembler(accesoBD);
		pedido_Pieza.setMuleto(muletoAssemb.getMuleto(pedido_PiezaDTO.getMuleto()));
		PedidoAssembler pedidoAssemb = new PedidoAssembler(accesoBD);
		pedido_Pieza.setPedido(pedidoAssemb.getPedido(pedido_PiezaDTO.getPedido()));
		PiezaAssembler piezaAssemb = new PiezaAssembler(accesoBD);
		pedido_Pieza.setPieza(piezaAssemb.getPieza(pedido_PiezaDTO.getPieza()));

		return pedido_Pieza;
	}

}