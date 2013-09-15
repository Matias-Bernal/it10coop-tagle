package servidor.assembler;

import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Pieza;

import common.DTOs.PiezaDTO;

public class PiezaAssembler {
	
	private AccesoBD accesoBD;

	public PiezaAssembler(AccesoBD accesoBD) {
		this.accesoBD = accesoBD;
	}

	public PiezaDTO getPiezaDTO(Pieza pieza) {
		PiezaDTO piezaDTO = new PiezaDTO();
		piezaDTO.setId(pieza.getId());
		piezaDTO.setNumero_pieza(pieza.getNumero_pieza());
		piezaDTO.setDescripcion(pieza.getDescripcion());
		return piezaDTO;
	}

	public Pieza getPieza(PiezaDTO piezaDTO) {
		Pieza pieza = (Pieza) accesoBD.buscarPorId(Pieza.class, piezaDTO.getId());
		pieza.setId(piezaDTO.getId());
		pieza.setNumero_pieza(piezaDTO.getNumero_pieza());
		pieza.setDescripcion(piezaDTO.getDescripcion());
		return pieza;
	}

	public Pieza getPiezaNuevo(PiezaDTO piezaDTO) {
		Pieza pieza = new Pieza();
		pieza.setId(piezaDTO.getId());
		pieza.setNumero_pieza(piezaDTO.getNumero_pieza());
		pieza.setDescripcion(piezaDTO.getDescripcion());
		return pieza;
	}

}