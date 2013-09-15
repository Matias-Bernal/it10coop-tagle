package servidor.assembler;

import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Bdg;

import common.DTOs.BdgDTO;

public class BdgAssembler {

	private AccesoBD accesoBD;

	public BdgAssembler (AccesoBD accesoBD) {
		this.accesoBD = accesoBD;
	}

	public BdgDTO getBdgDTO(Bdg bdg) {
		BdgDTO bdgDTO = new BdgDTO();
		bdgDTO.setId(bdg.getId());
		bdgDTO.setFecha_bdg(bdg.getFecha_bdg());
		PedidoAssembler pedidoAssemb = new PedidoAssembler(accesoBD);
		bdgDTO.setPedido(pedidoAssemb.getPedidoDTO(bdg.getPedido()));
		PiezaAssembler piezaAssem = new PiezaAssembler(accesoBD);
		bdgDTO.setPieza(piezaAssem.getPiezaDTO(bdg.getPieza()));
		return bdgDTO;
	}

	public Bdg getBdg(BdgDTO bdgDTO) {
		Bdg bdg = (Bdg) accesoBD.buscarPorId(Bdg.class, bdgDTO.getId());
		bdg.setId(bdgDTO.getId());
		bdg.setFecha_bdg(bdgDTO.getFecha_bdg());
		PedidoAssembler pedidoAssemb = new PedidoAssembler(accesoBD);
		bdg.setPedido(pedidoAssemb.getPedido(bdgDTO.getPedido()));
		PiezaAssembler piezaAssem = new PiezaAssembler(accesoBD);
		bdg.setPieza(piezaAssem.getPieza(bdgDTO.getPieza()));
		return bdg;
	}

	public Bdg getBdgNuevo(BdgDTO bdgDTO) {
		Bdg bdg = new Bdg();
		bdg.setId(bdgDTO.getId());
		bdg.setFecha_bdg(bdgDTO.getFecha_bdg());
		PedidoAssembler pedidoAssemb = new PedidoAssembler(accesoBD);
		bdg.setPedido(pedidoAssemb.getPedido(bdgDTO.getPedido()));
		PiezaAssembler piezaAssem = new PiezaAssembler(accesoBD);
		bdg.setPieza(piezaAssem.getPieza(bdgDTO.getPieza()));
		return bdg;
	}

}