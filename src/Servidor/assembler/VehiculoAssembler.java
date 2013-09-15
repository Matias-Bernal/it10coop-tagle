package servidor.assembler;

import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Vehiculo;

import common.DTOs.VehiculoDTO;

public class VehiculoAssembler {
	
	private AccesoBD accesoBD;

	public VehiculoAssembler(AccesoBD accesoBD) {
		this.accesoBD = accesoBD;
	}

	public VehiculoDTO getVehiculoDTO(Vehiculo vehiculo) {
		VehiculoDTO vehiculoDTO = new VehiculoDTO();
		vehiculoDTO.setId(vehiculo.getId());
		vehiculoDTO.setDominio(vehiculo.getDominio());
		vehiculoDTO.setNombre_titular(vehiculo.getNombre_titular());
		vehiculoDTO.setVin(vehiculo.getVin());
		MarcaAssembler marcaAssemb = new MarcaAssembler(accesoBD);
		vehiculoDTO.setMarca(marcaAssemb.getMarcaDTO(vehiculo.getMarca()));
		ModeloAssembler modeloAssemb = new ModeloAssembler(accesoBD);
		vehiculoDTO.setModelo(modeloAssemb.getModeloDTO(vehiculo.getModelo()));
		return vehiculoDTO;
	}

	public Vehiculo getVehiculo(VehiculoDTO vehiculoDTO) {
		Vehiculo vehiculo = (Vehiculo) accesoBD.buscarPorId(Vehiculo.class, vehiculoDTO.getId());
		vehiculo.setId(vehiculoDTO.getId());
		vehiculo.setDominio(vehiculoDTO.getDominio());
		vehiculo.setNombre_titular(vehiculoDTO.getNombre_titular());
		vehiculo.setVin(vehiculoDTO.getVin());
		MarcaAssembler marcaAssemb = new MarcaAssembler(accesoBD);
		vehiculo.setMarca(marcaAssemb.getMarca(vehiculoDTO.getMarca()));
		ModeloAssembler modeloAssemb = new ModeloAssembler(accesoBD);
		vehiculo.setModelo(modeloAssemb.getModelo(vehiculoDTO.getModelo()));
		return vehiculo;
	}

}