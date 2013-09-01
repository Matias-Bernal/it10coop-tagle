package servidor.assembler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import servidor.persistencia.dominio.Agente;
import common.DTOs.AgenteDTO;

public class AgenteAssembler {
	
	public AgenteAssembler() {}

	public static AgenteDTO getAgenteDTO(Agente agente) {
		AgenteDTO agentDTO = new AgenteDTO();
		agentDTO.setId(agente.getId());
		agentDTO.setNombre_registrante(agente.getNombre_registrante());
		return agentDTO;
	}
	public static Agente getAgente(AgenteDTO agenteDTO) {
		Agente agent = new Agente();
		agent.setId(agenteDTO.getId());
		agent.setNombre_registrante(agenteDTO.getNombre_registrante());
		return agent;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set getConjunto(Vector v){
		Set aux = new HashSet();
		Iterator it = v.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==AgenteDTO.class) {
				aux.add(getAgente((AgenteDTO) obj));
			}
		}
		return aux;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector getVector (Set s) {
		Vector auxDTO = new Vector();
		auxDTO.clear();
		Iterator it = s.iterator();
		Object obj;
		while(it.hasNext()){
			obj = it.next();
			if (obj.getClass()==Agente.class) {
				auxDTO.add(getAgenteDTO((Agente) obj));
			}
		}
		return auxDTO;
	}

}