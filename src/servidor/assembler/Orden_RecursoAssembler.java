package servidor.assembler;

import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Orden_Recurso;

import common.DTOs.Orden_RecursoDTO;

public class Orden_RecursoAssembler {
	private AccesoBD accesoBD;

	public Orden_RecursoAssembler(AccesoBD accesoBD) {
		this.accesoBD = accesoBD;
	}

	public Orden_RecursoDTO getOrden_RecursoDTO(Orden_Recurso orden_Recurso) {
		Orden_RecursoDTO orden_recursoDTO = new Orden_RecursoDTO();
		orden_recursoDTO.setId(orden_Recurso.getId());
		OrdenAssembler ordenAssemb = new OrdenAssembler(accesoBD);
		orden_recursoDTO.setOrden(ordenAssemb.getOrdenDTO(orden_Recurso.getOrden()));
		RecursoAssembler recursoAssemb = new RecursoAssembler(accesoBD);
		orden_recursoDTO.setRecurso(recursoAssemb.getRecursoDTO(orden_Recurso.getRecurso()));
		return orden_recursoDTO;
	}

	public Orden_Recurso getOrden_Recurso(Orden_RecursoDTO orden_RecursoDTO) {
		Orden_Recurso orden_Recurso = (Orden_Recurso) accesoBD.buscarPorId(Orden_Recurso.class, orden_RecursoDTO.getId());
		orden_Recurso.setId(orden_RecursoDTO.getId());
		OrdenAssembler ordenAssemb = new OrdenAssembler(accesoBD);
		orden_Recurso.setOrden(ordenAssemb.getOrden(orden_RecursoDTO.getOrden()));
		RecursoAssembler recursoAssemb = new RecursoAssembler(accesoBD);
		orden_Recurso.setRecurso(recursoAssemb.getRecurso(orden_RecursoDTO.getRecurso()));
		return orden_Recurso;
	}
	
	public Orden_Recurso getOrden_RecursoNuevo(Orden_RecursoDTO orden_RecursoDTO) {
		Orden_Recurso orden_Recurso = new Orden_Recurso();
		orden_Recurso.setId(orden_RecursoDTO.getId());
		OrdenAssembler ordenAssemb = new OrdenAssembler(accesoBD);
		orden_Recurso.setOrden(ordenAssemb.getOrden(orden_RecursoDTO.getOrden()));
		RecursoAssembler recursoAssemb = new RecursoAssembler(accesoBD);
		orden_Recurso.setRecurso(recursoAssemb.getRecurso(orden_RecursoDTO.getRecurso()));
		return orden_Recurso;
	}

}
