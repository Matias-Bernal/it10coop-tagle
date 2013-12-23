/********************************************************
  This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *********************************************************/
package cliente.Reportes;

import java.util.Vector;

import cliente.MediadorAccionesIniciarPrograma;
import cliente.MediadorPrincipal;

import common.DTOs.Orden_ReclamoDTO;
import common.DTOs.Pedido_PiezaDTO;
import common.DTOs.ReclamoDTO;
import common.DTOs.RegistranteDTO;
import common.GestionarAgente.IControlAgente;
import common.GestionarEntidad.IControlEntidad;
import common.GestionarOrden_Reclamo.IControlOrden_Reclamo;
import common.GestionarPedido_Pieza.IControlPedido_Pieza;
import common.GestionarReclamo.IControlReclamo;

public class MediadorReportes {
	
	private GUIReportes guiReporte;
	
	private MediadorPrincipal mediadorPrincipal;
	
	
	public MediadorReportes(MediadorPrincipal mediadorPrincipal) {
		this.setMediadorPrincipal(mediadorPrincipal);
	}
	
	public void mostrarReportes(){
		guiReporte = new GUIReportes(this);
		guiReporte.setVisible(true);
	}

	public MediadorPrincipal getMediadorPrincipal() {
		return mediadorPrincipal;
	}

	public void setMediadorPrincipal(MediadorPrincipal mediadorPrincipal) {
		this.mediadorPrincipal = mediadorPrincipal;
	}

	public Vector<Pedido_PiezaDTO> obtenerPedido_Piezas() {
		Vector<Pedido_PiezaDTO> result = new Vector<Pedido_PiezaDTO>();
		IControlPedido_Pieza iControlPedido_Pieza = MediadorAccionesIniciarPrograma.getControlPedido_Pieza();
		try {
			result = iControlPedido_Pieza.obtenerPedido_Pieza();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
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

	public Vector<ReclamoDTO> obtenerReclamos() {
		Vector<ReclamoDTO> result = new Vector<ReclamoDTO>();
		IControlReclamo iControlReclamo = MediadorAccionesIniciarPrograma.getControlReclamo();
		try {
			result = iControlReclamo.obtenerReclamos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Vector<Orden_ReclamoDTO> obtenerOrdenes() {
		Vector<Orden_ReclamoDTO> result = new Vector<Orden_ReclamoDTO>();
		IControlOrden_Reclamo iControlOrden_Reclamo = MediadorAccionesIniciarPrograma.getControlOrden_Reclamo();
		try {
			result = iControlOrden_Reclamo.obtenerOrdenes_Reclamos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
