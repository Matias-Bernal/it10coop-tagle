package servidor.GestionarAgente;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.assembler.AgenteAssembler;
import servidor.persistencia.AccesoBD;
import servidor.persistencia.dominio.Agente;

import common.DTOs.AgenteDTO;
import common.GestionarAgente.IControlAgente;

public class ControlAgente extends UnicastRemoteObject implements IControlAgente{

	private static final long serialVersionUID = 1L;

	protected ControlAgente() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long agregarAgente(AgenteDTO agenteDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Agente nuevoAagente = AgenteAssembler.getAgente(agenteDTO);
		Long id= new Long(0);
		try{
			accesoBD.iniciarTransaccion();
			accesoBD.hacerPersistente(nuevoAagente);
			id=nuevoAagente.getId();
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarAgente(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			Agente agente = AgenteAssembler.getAgente(buscarAgente(id));
			accesoBD.eliminar(agente);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public void modificarAgente(Long id, AgenteDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try{
			accesoBD.iniciarTransaccion();
			Agente agente = AgenteAssembler.getAgente(buscarAgente(id));
			agente.setNombre_registrante(modificado.getNombre_registrante());
			accesoBD.hacerPersistente(agente);
			accesoBD.concretarTransaccion();
		} finally {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public Vector<AgenteDTO> obtenerAgentes() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<AgenteDTO> agentesDTO = new Vector<AgenteDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Agente> agentes= (Vector<Agente>) accesoBD.buscarPorFiltro(Agente.class,"nombre_registrante ascending");
			for(int i=0; i<agentes.size();i++){
				AgenteDTO agentDTO = new AgenteDTO();
				agentDTO.setId(((Agente)agentes.elementAt(i)).getId());
				agentDTO.setNombre_registrante(((Agente)agentes.elementAt(i)).getNombre_registrante());
				agentesDTO.add(agentDTO);
			}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return agentesDTO;
	}

	@Override
	public boolean existeAgente(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Agente) accesoBD.buscarPorId(Agente.class,id) == null);
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	@Override
	public boolean existeAgente(String nombre_registrante) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			Vector<AgenteDTO> agentesDTO = obtenerAgentes();
			for(int i=0; i<agentesDTO.size();i++){
				if (((AgenteDTO)agentesDTO.elementAt(i)).getNombre_registrante().equals(nombre_registrante)){
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
	public AgenteDTO buscarAgente(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		AgenteDTO agenteDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			agenteDTO = AgenteAssembler.getAgenteDTO((Agente) accesoBD.buscarPorId(Agente.class,id));
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return agenteDTO;
	}

	@Override
	public AgenteDTO buscarAgente(String nombre_registrante) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		AgenteDTO agenteDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			Vector<AgenteDTO> agentesDTO = obtenerAgentes();
				for(int i=0; i<agentesDTO.size();i++){
					if (((AgenteDTO)agentesDTO.elementAt(i)).getNombre_registrante().equals(nombre_registrante)){
						agenteDTO = (AgenteDTO)agentesDTO.elementAt(i);
						break;
					}
				}
			accesoBD.concretarTransaccion();
		}  finally{
			accesoBD.rollbackTransaccion();
		}
		return agenteDTO;
	}
}