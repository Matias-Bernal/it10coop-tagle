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

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import common.DTOs.Pedido_PiezaDTO;
import common.DTOs.ReclamoDTO;

import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIReportes extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private MediadorReportes mediador;
	//
	Vector<Pedido_PiezaDTO> pedidos_piezas;
	Vector<ReclamoDTO> reclamos;
	//
	private JPanel contentPane;
	private JPanel pnPiezaLLegadas;
	private JPanel pnPiezasLLegadasSinTurno;
	private JPanel pnOrdenSinSDP;
	private JPanel pnSDPsinNumPedido;
	private JPanel pnPiezasPedidasSinLLegar;
	private JPanel pnDiasDesdeFSolicitudFabirca;
	private JPanel pnDiasDesdeFRecepcionFabirca;
	private JPanel pnPiezasDevueltas;
	private JPanel pnDiasDesdeFRecepcionFabricaFTurno;
	private JPanel pnDiasDesdeFCierreFTurno;
	private JTable tablaDiasDesdeFRF;
	private JPanel pnDiasDesdeFRecursoFCierreOT;
	private JPanel pnReclamos_Turnos;
	private JPanel pnDiasDesdeFReclamoFDevolucion;
	private JPanel pnManoObra;
	private JPanel pnRecursoCierre;
	private JPanel panel;
	private JPanel pnPiezasLlegadas_PiezasDevueltas;
	private JPanel panel_filtros;
	//tabla piezas sin llegar
	private JDateChooser dC_SLL_fin;
	private JDateChooser dC_SLL_inicio;
	private JRadioButton rB_SLL_Intervalo;
	private JRadioButton rB_SLL_Hoy;
	private JRadioButton rB_SLL_Semana;
	private JRadioButton rB_SLL_Mes;
	private JRadioButton rB_SLL_Anio;
	private JRadioButton rB_SLL_MesPasado;
	private JScrollPane scrollPane_pedidas_sin_llegar;
	private JTable tabla_piezas_sin_llegar;
	private DefaultTableModel modelo_tabla_piezas_sin_llegar;
	private Vector<Vector<String>> datosTabla_piezas_sin_llegar;
	private Vector<String> nombreColumnas_piezas_sin_llegar;
	private Vector<Integer> anchos_tabla_piezas_sin_llegar;
	//tabla piezas devueltas
	private JDateChooser dcFechaInicioPDev;
	private JDateChooser dcFechaFinPDev;
	private JRadioButton rbIntervaloPDev;
	private JRadioButton rbUltimoAnioPDev;
	private JRadioButton rbHoyPDev;
	private JRadioButton rbUltimaSemanaPDev;
	private JRadioButton rbUltimoMesPDev;
	private JTable tablaPiezasDevueltas;
	private DefaultTableModel modelo_tabla_piezas_devueltas;
	private Vector<Vector<String>> datosTabla_piezas_devueltas;
	private Vector<String> nombreColumnas_piezas_devueltas;
	private Vector<Integer> anchos_tabla_piezas_devueltas;
	private JScrollPane scrollPane_piezas_devueltas;
	//tabla piezas llegadas
	private JRadioButton rBUltimoMesPLL;
	private JRadioButton rBItervaloPLL;
	private JRadioButton rBHoyPLL;
	private JRadioButton rBUltimaSemanaPLL;
	private JRadioButton rBUltimoAnioPLL;
	private DefaultTableModel modelo_tabla_piezas_llegadas;
	private JTable tablaPiezas_Llegadas;
	private Vector<Vector<String>> datosTabla_piezas_llegadas;
	private Vector<String> nombreColumnas_piezas_llegadas;
	private Vector<Integer> anchos_tabla_piezas_llegadas;
	//tabla llegadas sin turno
	private JDateChooser dCPiezasLLegadasST_Inicio;
	private JDateChooser dCPiezasLLegadasST_Fin;
	private JRadioButton rB_Intervalo_PLLST;
	private JRadioButton rB_Hoy_PLLST;
	private JRadioButton rB_UMes_PLLST;
	private JRadioButton rB_USemana_PLLST;
	private JRadioButton rB_UAnio_PLLST;
	private JScrollPane scrollPane_piezas_llegadas_sin_turno;
	private DefaultTableModel modelo_tabla_piezas_llegadas_sin_turno;
	private Vector<Vector<String>> datosTabla_piezas_llegadas_sin_turno;
	private Vector<String> nombreColumnas_piezas_llegadas_sin_turno;
	private JTable tabla_piezas_llegadas_sin_turno;
	private Vector<Integer> anchos_tabla_piezas_llegadas_sin_turno;
	//tabla orden sin sdp
	private JDateChooser dC_OSSDP_Inicio;
	private JDateChooser dC_OSSDP_Fin;
	private JRadioButton rB_Intervalo_OSSDP;
	private JRadioButton rB_Hoy_OSSDP;
	private JRadioButton rB_USemana_OSSDP;
	private JRadioButton rB_UMes_OSSDP;
	private JRadioButton rB_UAnio_OSSDP;
	private JScrollPane scrollPane_orden_sin_sdp;
	private DefaultTableModel modelo_tabla_orden_sin_solicitud_pedido;
	private Vector<Vector<String>> datosTabla_orden_sin_solicitud_pedido;
	private Vector<String> nombreColumnas_orden_sin_solicitud_pedido;
	private JTable tabla_orden_sin_solicitud_pedido;
	private Vector<Integer> anchos_tabla_orden_sin_solicitud_pedido;
	//Tabla sdp sin solicitud pedido
	private JDateChooser dC_SDPSN_Inicio;
	private JDateChooser dC_SDPSN_Fin;
	private JRadioButton rB_Inetervalo_SDPSN;
	private JRadioButton rB_Hoy_SDPSN;
	private JRadioButton rB_USemana_SDPSN;
	private JRadioButton rB_UMes_SDPSN;
	private JRadioButton rB_UAnio_SDPSN;
	private JScrollPane scrollPane_sdp_sin_numero;
	private DefaultTableModel modelo_tabla_sdp_sin_numero_pedido;
	private Vector<Vector<String>> datosTabla_sdp_sin_numero_pedido;
	private Vector<String> nombreColumnas_sdp_sin_numero_pedido;
	private JTable tablaSdp_sin_numero_pedido;
	private Vector<Integer> anchos_tabla_sdp_sin_numero_pedido;
	//Tabla dias desde fsf
	private JScrollPane scrollPane_dias_trascurridos_desde_pedido_fabrica;
	private DefaultTableModel modelo_tabla_dias_desde_fsf;
	private JTable tablaDiasDesdeFSF;
	private Vector<String> nombreColumnas_tabla_dias_desde_fsf;
	private Vector<Vector<String>> datosTabla_dias_desde_fsf;
	private Vector<Integer> anchos_tabla_dias_desde_fsf;
	//Tabla dias desde frf
	private JScrollPane scrollPane_dias_trascurridos_desde_frf;
	private DefaultTableModel modelo_tabla_dias_desde_frf;
	private Vector<Vector<String>> datosTabla_dias_desde_frf;
	private Vector<String> nombreColumnas_tabla_dias_desde_frf;
	private Vector<Integer> anchos_tabla_dias_desde_frf;
	//Tabla dias desde fcierre a fturno
	private JScrollPane scrollPane_dias_trasncurridos_desde_fcierre_fturno;
	private DefaultTableModel modelo_tabla_dias_desde_fcierre_fturno;
	private Vector<String> nombreColumnas_tabla_dias_desde_fcierre_fturno;
	private Vector<Vector<String>> datosTabla_dias_desde_fcierre_fturno;
	private Vector<Integer> anchos_tabla_dias_desde_fcierre_fturno;
	private JTable tablaDiasDesdeFCierreOTaFTurno;
	//tabla dias desde frecurso fcierre
	private JScrollPane scrollPane_dias_desde_frecurso_fcierre;
	private JTable tablaDiasDesdeFRecursoFCierreOT;
	private DefaultTableModel modelo_tabla_dias_desde_frecurso_fcierre;
	private Vector<Vector<String>> datosTabla_dias_desde_frecurso_fcierre;
	private Vector<String> nombreColumnas_tabla_dias_desde_frecurso_fcierre;
	private Vector<Integer> anchos_tabla_dias_desde_frecurso_fcierre;
	//tabla dias desde frf fturno
	private JScrollPane scrollPane_dias_transcurridos_desde_frf_fturno;
	private JTable tablaDiasDesdeFRFaFTurno;
	private DefaultTableModel modelo_tabla_dias_desde_frf_fturno;
	private Vector<Vector<String>> datosTabla_dias_desde_frf_fturno;
	private Vector<String> nombreColumnas_tabla_dias_desde_frf_fturno;
	private Vector<Integer> anchos_tabla_dias_desde_frf_fturno;
	//tabla dias desde freclamo fdevolucion
	private JScrollPane scrollPane_dias_desde_freclamo_fdevolucion;
	private DefaultTableModel modelo_tabla_dias_desde_freclamo_fdevolucion;
	private Vector<Vector<String>> datosTabla_dias_desde_freclamo_fdevolucion;
	private Vector<String> nombreColumnas_tabla_dias_desde_freclamo_fdevolucion;
	private JTable tablaDiasDesdeFReclamoFDevolucion;
	private Vector<Integer> anchos_tabla_dias_desde_freclamo_fdevolucion;
	//tabla reclamos/turnos
	private JScrollPane scrollPane_tabla_reclamos_turno_Reclamos;
	private JScrollPane scrollPane_tabla_reclamos_turnos_Turno;
	private JLabel lblReclamoTurnos;
	private JDateChooser dC_FReclamoTurno_INICIO;
	private JDateChooser dC_FReclamoTruno_FIN;
	private JRadioButton rB_UAnio_FReclamoTurno;
	private JRadioButton rB_MesAnterior_FReclamoTurno;
	private JRadioButton rB_UMes_FReclamoTurno;
	private JRadioButton rB_USemana_FReclamoTurno;
	private JRadioButton rB_Hoy_FReclamoTurno;
	private JRadioButton rB_Intervalo_FReclamoTurno;
	private JTable tabla_reclamos_turno_Reclamos;
	private JTable tabla_reclamos_turno_Turnos;
	private DefaultTableModel modelo_tabla_reclamos_turno_Reclamos;
	private Vector<Vector<String>> datos_tabla_reclamos_turno_Reclamos;
	private Vector<String> nombreColumnas_tabla_reclamos_turno_Reclamos;
	private Vector<Integer> anchos_tabla_reclamos_turno_Reclamos;
	private DefaultTableModel modelo_tabla_reclamos_turno_Turno;
	private Vector<Vector<String>> datos_tabla_reclamos_turno_Turno;	
	private Vector<String> nombreColumnas_tabla_reclamos_turno_Turno;
	private Vector<Integer> anchos_tabla_reclamos_turno_Turno;
	private float numero_reclamos;
	private float numero_turnos;
	private JLabel lblNum_ReclmaosConTurno;
	private JLabel lblNum_ReclamosSinTurno;
	//tabla piezas llegadas piezas devueltas
	private JRadioButton rB_Intervalo_PLlegadasPDevueltas;
	private JRadioButton rB_Hoy_PLlegadasPDevueltas;
	private JRadioButton rB_USemana_PLlegadasPDevueltas;
	private JRadioButton rB_UMes_PLlegadasPDevueltas;
	private JRadioButton rB_MPasado_PLlegadasPDevueltas;
	private JRadioButton rB_UAnio_PLlegadasPDevueltas;
	private JDateChooser dC_FLlegadaFDevueltas_Inicio;
	private JDateChooser dC_FLlegadaFDevueltas_Fin;
	private JScrollPane scrollPane_tabla_Pllegadas_PDevuletas_LLegadas;
	private JScrollPane scrollPane_tabla_Pllegadas_PDevuletas_Devueltas;
	private JLabel lblNum_PDevueltas;
	private JLabel lblNumPLlegadas;
	private JTable tabla_Pllegadas_PDevuletas_LLegadas;
	private JTable tabla_Pllegadas_PDevuletas_Devueltas;
	private JLabel lblLlegadaDevueltas;
	private DefaultTableModel modelo_tabla_Pllegadas_PDevuletas_Devueltas;
	private Vector<Vector<String>> datos_tabla_Pllegadas_PDevuletas_Devueltas;
	private Vector<String> nombreColumnas_tabla_Pllegadas_PDevuletas_Devueltas;
	private Vector<Integer> anchos_tabla_Pllegadas_PDevuletas_Devueltas;
	private DefaultTableModel modelo_tabla_Pllegadas_PDevuletas_LLegadas;
	private Vector<Vector<String>> datos_tabla_Pllegadas_PDevuletas_LLegadas;
	private Vector<String> nombreColumnas_tabla_Pllegadas_PDevuletas_LLegadas;
	private Vector<Integer> anchos_tabla_Pllegadas_PDevuletas_LLegadas;
	private float  numero_PiezasLlegadas;
	private float numero_PiezasDevueltas;
	private JLabel lblPiezasLLegadas_PiezasDevueltas;
	//tabla mano obra
	private float hs_mano_obra;
	private float preico_mano_obra;
	private JRadioButton rB_Intervalo_MObra;
	private JRadioButton rB_Hoy_ManoObra;
	private JRadioButton rB_Usemana_ManoObra;
	private JRadioButton rB_UMes_ManoObra;
	private JRadioButton rB_MAnterior_ManoObra;
	private JRadioButton rB_UAnio_ManoObra;
	private JDateChooser dC_ManoObra_Inicio;
	private JDateChooser dc_ManoObra_Fin;
	private JTable tabla_mano_obra;
	private JScrollPane scrollPane_mano_obra;
	private DefaultTableModel modelo_tabla_mano_obra;
	private Vector<Vector<String>> datos_tabla_mano_obra;
	private Vector<String> nombreColumnas_tabla_mano_obra;
	private Vector<Integer> anchos_tabla_mano_obra;
	private JRadioButton rBMAnteriorPLL;
	private JDateChooser dC_FInicioPLL;
	private JDateChooser dC_FFinPLL;
	private JRadioButton rbMAnteriorPDev;
	private JRadioButton rBMesPasado_PLLST;
	private JRadioButton rB_MesAnterior_OSSDP;
	private JRadioButton rB_MesPasado_SDPSN;
	//Tabla recurso cierre
	private JTable tabla_recurso_cierre;
	private DefaultTableModel modelo_tabla_recurso_cierre;
	private Vector<Vector<String>> datos_tabla_recurso_cierre;
	private Vector<String> nombreColumnas_tabla_recurso_cierre;
	private Vector<Integer> anchos_tabla_recurso_cierre;
	private JRadioButton rb_Intervalo_RecursoCierre;
	private JRadioButton rb_Hoy_RecursoCierre;
	private JRadioButton rb_USemana_RecursoCierre;
	private JRadioButton rb_UMes_RecursoCierre;
	private JRadioButton rb_MAnterior_RecursoCierre;
	private JRadioButton rb_UAnio_RecursoCierre;
	private JDateChooser dc_Inicio_RecursoCierre;
	private JDateChooser dc_Fin_RecursoCierre;
	private JScrollPane scrollPane_recurso_cierre;
	private float N_casos;
	private float sum_frecurso_fcierre;
	private JLabel lblValorTotalDe;
	private JLabel lblHorasTotalesDe;
	private JLabel lbl_HsTotalesMO;
	private JLabel lbl_ValorTotalMO;
	private JButton btnFiltrar_PLL;
	private JButton btnFiltrarPDev;
	private JButton btonFiltrar_SLL;
	private JButton btnFiltrarPLLST;
	private JButton btnFiltrarOSSDP;
	private JButton btnFiltrarSDPSN;
	private JButton btnFiltrarReclamo_Turno;



	
	//tabla 
	public GUIReportes(MediadorReportes mediadorReporte) {
		setMediador(mediadorReporte);
		cargarDatos();
		initialize();
	}

	private void cargarDatos() {

		pedidos_piezas = mediador.obtenerPedido_Piezas();
		reclamos = mediador.obtenerReclamos(); 
		int chico = 100;
		int mediano = 150;
		int grande = 230;	
		
		//Tabla piezas sin llegar
		modelo_tabla_piezas_sin_llegar = new DefaultTableModel();
		nombreColumnas_piezas_sin_llegar = new Vector<String> ();
		anchos_tabla_piezas_sin_llegar = new Vector<Integer>();

		nombreColumnas_piezas_sin_llegar.add("ID Pedido");//0
		anchos_tabla_piezas_sin_llegar.add(75);
		nombreColumnas_piezas_sin_llegar.add("Numero Pedido");//2
		anchos_tabla_piezas_sin_llegar.add(chico);
		nombreColumnas_piezas_sin_llegar.add("Numero Pieza");//3
		anchos_tabla_piezas_sin_llegar.add(chico);
		nombreColumnas_piezas_sin_llegar.add("Descripcion");//4
		anchos_tabla_piezas_sin_llegar.add(mediano);
		nombreColumnas_piezas_sin_llegar.add("Numero Orden");//5
		anchos_tabla_piezas_sin_llegar.add(chico);
		nombreColumnas_piezas_sin_llegar.add("VIN");//6
		anchos_tabla_piezas_sin_llegar.add(130);
		nombreColumnas_piezas_sin_llegar.add("Registrante");//7
		anchos_tabla_piezas_sin_llegar.add(grande);
		nombreColumnas_piezas_sin_llegar.add("Fecha Solicitud Pedido");//8
		anchos_tabla_piezas_sin_llegar.add(mediano);
		nombreColumnas_piezas_sin_llegar.add("Fecha Solicitud Fabrica");//9
		anchos_tabla_piezas_sin_llegar.add(mediano);
		//
		
		datosTabla_piezas_sin_llegar = new Vector<Vector<String>>();
		
		for (int i=0; i< pedidos_piezas.size();i++){
			
			if(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null ){
				Vector<String> row = new Vector<String> ();

				row.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
				row.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
				row.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
				row.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
				
				SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 

				if(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido()!=null){
					java.sql.Date fsp = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido().getTime());
					row.add(format2.format(fsp));//Fecha Solicitud Pedido
				}else{
					row.add("");
				}			    
				
				if (pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null){
					java.sql.Date fsf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica().getTime());
					row.add(format2.format(fsf));//Fecha Solicitud Fabrica
				}else{
					row.add("");
				}

				datosTabla_piezas_sin_llegar.add(row);
			}
		}
		modelo_tabla_piezas_sin_llegar.setDataVector(datosTabla_piezas_sin_llegar, nombreColumnas_piezas_sin_llegar);
		modelo_tabla_piezas_sin_llegar.fireTableStructureChanged();
		//
		
		
		//tablas Piezas Devueltas
		modelo_tabla_piezas_devueltas = new DefaultTableModel();
		nombreColumnas_piezas_devueltas = new Vector<String> ();
		anchos_tabla_piezas_devueltas = new Vector<Integer>();
		

		nombreColumnas_piezas_devueltas.add("ID Pedido");//0
		anchos_tabla_piezas_devueltas.add(75);
		nombreColumnas_piezas_devueltas.add("Numero Pedido");//2
		anchos_tabla_piezas_devueltas.add(chico);
		nombreColumnas_piezas_devueltas.add("Numero Pieza");//3
		anchos_tabla_piezas_devueltas.add(chico);
		nombreColumnas_piezas_devueltas.add("Descripcion");//4
		anchos_tabla_piezas_devueltas.add(mediano);
		nombreColumnas_piezas_devueltas.add("Numero Orden");//5
		anchos_tabla_piezas_devueltas.add(chico);
		nombreColumnas_piezas_devueltas.add("VIN");//6
		anchos_tabla_piezas_devueltas.add(130);
		nombreColumnas_piezas_devueltas.add("Registrante");//7
		anchos_tabla_piezas_devueltas.add(grande);
		nombreColumnas_piezas_devueltas.add("Fecha Solicitud Pedido");//8
		anchos_tabla_piezas_devueltas.add(mediano);
		nombreColumnas_piezas_devueltas.add("Fecha Solicitud Fabrica");//9
		anchos_tabla_piezas_devueltas.add(mediano);
		nombreColumnas_piezas_devueltas.add("Fecha Recepcion Fabrica");//10
		anchos_tabla_piezas_devueltas.add(mediano);
		nombreColumnas_piezas_devueltas.add("Fecha Envio Agente");//11
		anchos_tabla_piezas_devueltas.add(mediano);
		nombreColumnas_piezas_devueltas.add("Fecha Recepcion Agente");//12
		anchos_tabla_piezas_devueltas.add(mediano);
		nombreColumnas_piezas_devueltas.add("Fecha Envio Fabrica");//13
		anchos_tabla_piezas_devueltas.add(mediano);
		//
		
		datosTabla_piezas_devueltas = new Vector<Vector<String>>();
		
		for (int i=0; i< pedidos_piezas.size();i++){
				
			if(pedidos_piezas.elementAt(i).getDevolucion_pieza()!=null && pedidos_piezas.elementAt(i).getDevolucion_pieza().getFecha_devolucion()!=null){
				Vector<String> row = new Vector<String> ();

				row.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
				row.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
				row.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
				row.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
				
				SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 

				if(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido()!=null){
					java.sql.Date fsp = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido().getTime());
					row.add(format2.format(fsp));//Fecha Solicitud Pedido
				}else{
					row.add("");
				}			    
				
				if (pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null){
					java.sql.Date fsf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica().getTime());
					row.add(format2.format(fsf));//Fecha Solicitud Fabrica
				}else{
					row.add("");
				}
				if (pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null){
					java.sql.Date frf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().getTime());
					row.add(format2.format(frf));//Fecha Recepcion Fabrica
				}else{
					row.add("");
				}
				if (pedidos_piezas.elementAt(i).getFecha_envio_agente()!=null){
					java.sql.Date fea = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_envio_agente().getTime());
					row.add(format2.format(fea));//Fecha Envio Agente
				}else{
					row.add("");
				}
				if (pedidos_piezas.elementAt(i).getFecha_recepcion_agente()!=null){
					java.sql.Date fra = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_recepcion_agente().getTime());
					row.add(format2.format(fra));//Fecha Recepcion Agente
				}else{
					row.add("");
				}
				if (pedidos_piezas.elementAt(i).getDevolucion_pieza()!=null && pedidos_piezas.elementAt(i).getDevolucion_pieza().getFecha_devolucion()!=null){
					java.sql.Date fef = new java.sql.Date(pedidos_piezas.elementAt(i).getDevolucion_pieza().getFecha_devolucion().getTime());
					row.add(format2.format(fef));//Fecha Envio Fabrica
				}else{
					row.add("");
				}

				datosTabla_piezas_devueltas.add(row);
			}
		}
		modelo_tabla_piezas_devueltas.setDataVector(datosTabla_piezas_devueltas, nombreColumnas_piezas_devueltas);
		modelo_tabla_piezas_devueltas.fireTableStructureChanged();
		//
		//tablas Piezas Llegadas
		modelo_tabla_piezas_llegadas = new DefaultTableModel();
		nombreColumnas_piezas_llegadas = new Vector<String> ();
		anchos_tabla_piezas_llegadas = new Vector<Integer>();
		

		nombreColumnas_piezas_llegadas.add("ID Pedido");//0
		anchos_tabla_piezas_llegadas.add(75);
		nombreColumnas_piezas_llegadas.add("Numero Pedido");//2
		anchos_tabla_piezas_llegadas.add(chico);
		nombreColumnas_piezas_llegadas.add("Numero Pieza");//3
		anchos_tabla_piezas_llegadas.add(chico);
		nombreColumnas_piezas_llegadas.add("Descripcion");//4
		anchos_tabla_piezas_llegadas.add(mediano);
		nombreColumnas_piezas_llegadas.add("Numero Orden");//5
		anchos_tabla_piezas_llegadas.add(chico);
		nombreColumnas_piezas_llegadas.add("VIN");//6
		anchos_tabla_piezas_llegadas.add(130);
		nombreColumnas_piezas_llegadas.add("Registrante");//7
		anchos_tabla_piezas_llegadas.add(grande);
		nombreColumnas_piezas_llegadas.add("Fecha Solicitud Pedido");//8
		anchos_tabla_piezas_llegadas.add(mediano);
		nombreColumnas_piezas_llegadas.add("Fecha Solicitud Fabrica");//9
		anchos_tabla_piezas_llegadas.add(mediano);
		nombreColumnas_piezas_llegadas.add("Fecha Recepcion Fabrica");//10
		anchos_tabla_piezas_llegadas.add(mediano);
		//
		
		datosTabla_piezas_llegadas= new Vector<Vector<String>>();
		
		for (int i=0; i< pedidos_piezas.size();i++){
			boolean resp = false;
			if (mediador.esEntidad(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante())){
				resp = pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getDevolucion_pieza()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null;
			}else{
				resp = pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getFecha_envio_agente()==null  && pedidos_piezas.elementAt(i).getDevolucion_pieza()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null;
			}					
			if(resp){
				Vector<String> row = new Vector<String> ();

				row.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
				row.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
				row.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
				row.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
				
				SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 

				if(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido()!=null){
					java.sql.Date fsp = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido().getTime());
					row.add(format2.format(fsp));//Fecha Solicitud Pedido
				}else{
					row.add("");
				}			    
				
				if (pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null){
					java.sql.Date fsf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica().getTime());
					row.add(format2.format(fsf));//Fecha Solicitud Fabrica
				}else{
					row.add("");
				}
				if (pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null){
					java.sql.Date frf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().getTime());
					row.add(format2.format(frf));//Fecha Recepcion Fabrica
				}else{
					row.add("");
				}

				datosTabla_piezas_llegadas.add(row);
			}
		}
		modelo_tabla_piezas_llegadas.setDataVector(datosTabla_piezas_llegadas, nombreColumnas_piezas_llegadas);
		modelo_tabla_piezas_llegadas.fireTableStructureChanged();
		//
		
		//Tabla piezas LLegadas sin Turno
		modelo_tabla_piezas_llegadas_sin_turno = new DefaultTableModel();
		nombreColumnas_piezas_llegadas_sin_turno = new Vector<String> ();
		anchos_tabla_piezas_llegadas_sin_turno = new Vector<Integer>();
		

		nombreColumnas_piezas_llegadas_sin_turno.add("ID Pedido");//0
		anchos_tabla_piezas_llegadas_sin_turno.add(75);
		nombreColumnas_piezas_llegadas_sin_turno.add("Numero Pedido");//2
		anchos_tabla_piezas_llegadas_sin_turno.add(chico);
		nombreColumnas_piezas_llegadas_sin_turno.add("Numero Pieza");//3
		anchos_tabla_piezas_llegadas_sin_turno.add(chico);
		nombreColumnas_piezas_llegadas_sin_turno.add("Descripcion");//4
		anchos_tabla_piezas_llegadas_sin_turno.add(mediano);
		nombreColumnas_piezas_llegadas_sin_turno.add("Numero Orden");//5
		anchos_tabla_piezas_llegadas_sin_turno.add(chico);
		nombreColumnas_piezas_llegadas_sin_turno.add("VIN");//6
		anchos_tabla_piezas_llegadas_sin_turno.add(130);
		nombreColumnas_piezas_llegadas_sin_turno.add("Registrante");//7
		anchos_tabla_piezas_llegadas_sin_turno.add(grande);
		nombreColumnas_piezas_llegadas_sin_turno.add("Fecha Solicitud Pedido");//8
		anchos_tabla_piezas_llegadas_sin_turno.add(mediano);
		nombreColumnas_piezas_llegadas_sin_turno.add("Fecha Solicitud Fabrica");//9
		anchos_tabla_piezas_llegadas_sin_turno.add(mediano);
		nombreColumnas_piezas_llegadas_sin_turno.add("Fecha Recepcion Fabrica");//10
		anchos_tabla_piezas_llegadas_sin_turno.add(mediano);
		//
		
		datosTabla_piezas_llegadas_sin_turno= new Vector<Vector<String>>();
		
		for (int i=0; i< pedidos_piezas.size();i++){
			boolean resp = false;
				if (mediador.esEntidad(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante())){
					resp = pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getDevolucion_pieza()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null;
				}				
				if(resp && pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_turno()==null){
					Vector<String> row = new Vector<String> ();
	
					row.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
					row.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
					row.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
					row.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
					
					SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 
	
					if(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido()!=null){
						java.sql.Date fsp = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido().getTime());
						row.add(format2.format(fsp));//Fecha Solicitud Pedido
					}else{
						row.add("");
					}			    
					
					if (pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null){
						java.sql.Date fsf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica().getTime());
						row.add(format2.format(fsf));//Fecha Solicitud Fabrica
					}else{
						row.add("");
					}
					if (pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null){
						java.sql.Date frf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().getTime());
						row.add(format2.format(frf));//Fecha Recepcion Fabrica
					}else{
						row.add("");
					}
	
					datosTabla_piezas_llegadas_sin_turno.add(row);
				}
		}
		modelo_tabla_piezas_llegadas_sin_turno.setDataVector(datosTabla_piezas_llegadas_sin_turno, nombreColumnas_piezas_llegadas_sin_turno);
		modelo_tabla_piezas_llegadas_sin_turno.fireTableStructureChanged();
		//
		//Tabla orden sin sdp
		modelo_tabla_orden_sin_solicitud_pedido = new DefaultTableModel();
		nombreColumnas_orden_sin_solicitud_pedido = new Vector<String> ();
		anchos_tabla_orden_sin_solicitud_pedido = new Vector<Integer>();
		

		nombreColumnas_orden_sin_solicitud_pedido.add("ID Orden");//0
		anchos_tabla_orden_sin_solicitud_pedido.add(75);
		nombreColumnas_orden_sin_solicitud_pedido.add("Numero Orden");//1
		anchos_tabla_orden_sin_solicitud_pedido.add(chico);
		nombreColumnas_orden_sin_solicitud_pedido.add("Fecha Apertura Orden");//2
		anchos_tabla_orden_sin_solicitud_pedido.add(mediano);
		nombreColumnas_orden_sin_solicitud_pedido.add("ID Reclamo");//3
		anchos_tabla_orden_sin_solicitud_pedido.add(75);
		nombreColumnas_orden_sin_solicitud_pedido.add("Fecha Reclamo");//4
		anchos_tabla_orden_sin_solicitud_pedido.add(mediano);
		nombreColumnas_orden_sin_solicitud_pedido.add("Registrante");//5
		anchos_tabla_orden_sin_solicitud_pedido.add(grande);
		//
		
		datosTabla_orden_sin_solicitud_pedido = new Vector<Vector<String>>();
		
		for (int i=0; i< reclamos.size();i++){

			if(reclamos.elementAt(i).getOrden()!=null && !conPedido(reclamos.elementAt(i))){
				Vector<String> row = new Vector<String> ();

				row.add(reclamos.elementAt(i).getOrden().getId().toString());//ID Orden
				row.add(reclamos.elementAt(i).getOrden().getNumero_orden());//Numero Orden
				
				SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 
				if(reclamos.elementAt(i).getOrden().getFecha_apertura()!=null){
					java.sql.Date fao = new java.sql.Date(reclamos.elementAt(i).getOrden().getFecha_apertura().getTime());
					row.add(format2.format(fao));//Fecha Apertura Orden
				}else{
					row.add("");
				}
				row.add(reclamos.elementAt(i).getId().toString());//ID Reclamo
				if(reclamos.elementAt(i).getFecha_reclamo()!=null){
					java.sql.Date fr = new java.sql.Date(reclamos.elementAt(i).getFecha_reclamo().getTime());
					row.add(format2.format(fr));//Fecha Reclamo
				}else{
					row.add("");
				}
				row.add(reclamos.elementAt(i).getRegistrante().getNombre_registrante());//Registrante
				
				datosTabla_orden_sin_solicitud_pedido.add(row);
			}
		}
		modelo_tabla_orden_sin_solicitud_pedido.setDataVector(datosTabla_orden_sin_solicitud_pedido, nombreColumnas_orden_sin_solicitud_pedido);
		modelo_tabla_orden_sin_solicitud_pedido.fireTableStructureChanged();
		//
		//Tabla sdp sin numero pedido
		modelo_tabla_sdp_sin_numero_pedido = new DefaultTableModel();
		nombreColumnas_sdp_sin_numero_pedido = new Vector<String> ();
		anchos_tabla_sdp_sin_numero_pedido = new Vector<Integer>();
		

		nombreColumnas_sdp_sin_numero_pedido.add("ID Pedido");//0
		anchos_tabla_sdp_sin_numero_pedido.add(75);
		nombreColumnas_sdp_sin_numero_pedido.add("Numero Pieza");//3
		anchos_tabla_sdp_sin_numero_pedido.add(chico);
		nombreColumnas_sdp_sin_numero_pedido.add("Descripcion");//4
		anchos_tabla_sdp_sin_numero_pedido.add(mediano);
		nombreColumnas_sdp_sin_numero_pedido.add("Numero Orden");//5
		anchos_tabla_sdp_sin_numero_pedido.add(chico);
		nombreColumnas_sdp_sin_numero_pedido.add("VIN");//6
		anchos_tabla_sdp_sin_numero_pedido.add(130);
		nombreColumnas_sdp_sin_numero_pedido.add("Registrante");//7
		anchos_tabla_sdp_sin_numero_pedido.add(grande);
		nombreColumnas_sdp_sin_numero_pedido.add("Fecha Solicitud Pedido");//8
		anchos_tabla_sdp_sin_numero_pedido.add(mediano);
		nombreColumnas_sdp_sin_numero_pedido.add("Fecha Solicitud Fabrica");//9
		anchos_tabla_sdp_sin_numero_pedido.add(mediano);
		//
		
		datosTabla_sdp_sin_numero_pedido = new Vector<Vector<String>>();
		
		for (int i=0; i< pedidos_piezas.size();i++){
					
			if(pedidos_piezas.elementAt(i).getNumero_pedido()==null){
				Vector<String> row = new Vector<String> ();
	
				row.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
				row.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
				row.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
				
				SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 
	
				if(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido()!=null){
					java.sql.Date fsp = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido().getTime());
					row.add(format2.format(fsp));//Fecha Solicitud Pedido
				}else{
					row.add("");
				}			    
				
				if (pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null){
					java.sql.Date fsf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica().getTime());
					row.add(format2.format(fsf));//Fecha Solicitud Fabrica
				}else{
					row.add("");
				}
	
				datosTabla_sdp_sin_numero_pedido.add(row);
			}
		}
		modelo_tabla_sdp_sin_numero_pedido.setDataVector(datosTabla_sdp_sin_numero_pedido, nombreColumnas_sdp_sin_numero_pedido);
		modelo_tabla_sdp_sin_numero_pedido.fireTableStructureChanged();
		//
		//Tabla dias desde fsf
		modelo_tabla_dias_desde_fsf = new DefaultTableModel();
		nombreColumnas_tabla_dias_desde_fsf = new Vector<String> ();
		anchos_tabla_dias_desde_fsf = new Vector<Integer>();
		

		nombreColumnas_tabla_dias_desde_fsf.add("ID Pedido");//0
		anchos_tabla_dias_desde_fsf.add(75);
		nombreColumnas_tabla_dias_desde_fsf.add("Numero Pedido");//1
		anchos_tabla_dias_desde_fsf.add(chico);
		nombreColumnas_tabla_dias_desde_fsf.add("Numero Pieza");//2
		anchos_tabla_dias_desde_fsf.add(chico);
		nombreColumnas_tabla_dias_desde_fsf.add("Descripcion");//3
		anchos_tabla_dias_desde_fsf.add(mediano);
		nombreColumnas_tabla_dias_desde_fsf.add("Numero Orden");//4
		anchos_tabla_dias_desde_fsf.add(chico);
		nombreColumnas_tabla_dias_desde_fsf.add("VIN");//5
		anchos_tabla_dias_desde_fsf.add(130);
		nombreColumnas_tabla_dias_desde_fsf.add("Registrante");//6
		anchos_tabla_dias_desde_fsf.add(grande);
		nombreColumnas_tabla_dias_desde_fsf.add("Fecha Solicitud Pedido");//7
		anchos_tabla_dias_desde_fsf.add(mediano);
		nombreColumnas_tabla_dias_desde_fsf.add("Fecha Solicitud Fabrica");//8
		anchos_tabla_dias_desde_fsf.add(mediano);
		nombreColumnas_tabla_dias_desde_fsf.add("Dias Desde FSF");//9
		anchos_tabla_dias_desde_fsf.add(chico);
		//
		
		datosTabla_dias_desde_fsf = new Vector<Vector<String>>();
		
		for (int i=0; i< pedidos_piezas.size();i++){
			if(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null && pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()==null){
				Vector<String> row = new Vector<String> ();
		
				row.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
				row.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
				row.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
				row.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
				
				SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 
		
				if(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido()!=null){
					java.sql.Date fsp = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido().getTime());
					row.add(format2.format(fsp));//Fecha Solicitud Pedido
				}else{
					row.add("");
				}			    
				
				if (pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null){
					java.sql.Date fsf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica().getTime());
					row.add(format2.format(fsf));//Fecha Solicitud Fabrica
					final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 
					java.util.Date hoy = new Date(); //Fecha de hoy 
					@SuppressWarnings("deprecation")
					Calendar calendar = new GregorianCalendar(fsf.getYear(), fsf.getMonth()-1, fsf.getDay());
					long diferencia = ( hoy.getTime() - fsf.getTime() )/MILLSECS_PER_DAY;
					row.add(String.valueOf(diferencia));
					
				}else{
					row.add("");
					row.add("");
				}
		
				datosTabla_dias_desde_fsf.add(row);
			}
		}
		modelo_tabla_dias_desde_fsf.setDataVector(datosTabla_dias_desde_fsf, nombreColumnas_tabla_dias_desde_fsf);
		modelo_tabla_dias_desde_fsf.fireTableStructureChanged();
		//
		//Tabla dias desde frf
		modelo_tabla_dias_desde_frf = new DefaultTableModel();
		nombreColumnas_tabla_dias_desde_frf = new Vector<String> ();
		anchos_tabla_dias_desde_frf = new Vector<Integer>();
		

		nombreColumnas_tabla_dias_desde_frf.add("ID Pedido");//0
		anchos_tabla_dias_desde_frf.add(75);
		nombreColumnas_tabla_dias_desde_frf.add("Numero Pedido");//1
		anchos_tabla_dias_desde_frf.add(chico);
		nombreColumnas_tabla_dias_desde_frf.add("Numero Pieza");//2
		anchos_tabla_dias_desde_frf.add(chico);
		nombreColumnas_tabla_dias_desde_frf.add("Descripcion");//3
		anchos_tabla_dias_desde_frf.add(mediano);
		nombreColumnas_tabla_dias_desde_frf.add("Numero Orden");//4
		anchos_tabla_dias_desde_frf.add(chico);
		nombreColumnas_tabla_dias_desde_frf.add("VIN");//5
		anchos_tabla_dias_desde_frf.add(130);
		nombreColumnas_tabla_dias_desde_frf.add("Registrante");//6
		anchos_tabla_dias_desde_frf.add(grande);
		nombreColumnas_tabla_dias_desde_frf.add("Fecha Solicitud Pedido");//7
		anchos_tabla_dias_desde_frf.add(mediano);
		nombreColumnas_tabla_dias_desde_frf.add("Fecha Solicitud Fabrica");//8
		anchos_tabla_dias_desde_frf.add(mediano);
		nombreColumnas_tabla_dias_desde_frf.add("Fecha Recepcion Fabrica");//9
		anchos_tabla_dias_desde_frf.add(mediano);
		nombreColumnas_tabla_dias_desde_frf.add("Dias Desde FRF");//10
		anchos_tabla_dias_desde_frf.add(chico);
		//
		
		datosTabla_dias_desde_frf = new Vector<Vector<String>>();
		
		for (int i=0; i< pedidos_piezas.size();i++){
			boolean resp = false;
			if (mediador.esEntidad(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante())){
				resp = pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getDevolucion_pieza()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null;
			}else{
				resp = pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getFecha_envio_agente()==null  && pedidos_piezas.elementAt(i).getDevolucion_pieza()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null;
			}	
			if(resp){
					Vector<String> row = new Vector<String> ();
	
					row.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
					row.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
					row.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
					row.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
					
					SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 
	
					if(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido()!=null){
						java.sql.Date fsp = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido().getTime());
						row.add(format2.format(fsp));//Fecha Solicitud Pedido
					}else{
						row.add("");
					}			    
					
					if (pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null){
						java.sql.Date fsf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica().getTime());
						row.add(format2.format(fsf));//Fecha Solicitud Fabrica
					}else{
						row.add("");
					}
					if(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null){
						java.sql.Date frf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().getTime());
						row.add(format2.format(frf));//Fecha Recepcion Fabrica
						
						final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 
						java.util.Date hoy = new Date(); //Fecha de hoy 
						@SuppressWarnings("deprecation")
						Calendar calendar = new GregorianCalendar(frf.getYear(), frf.getMonth()-1, frf.getDay());
						long diferencia = ( hoy.getTime() - frf.getTime() )/MILLSECS_PER_DAY;
						row.add(String.valueOf(diferencia));
					}else{
						row.add("");
						row.add("");
					}	
					datosTabla_dias_desde_frf.add(row);
				}
		}
		modelo_tabla_dias_desde_frf.setDataVector(datosTabla_dias_desde_frf, nombreColumnas_tabla_dias_desde_frf);
		modelo_tabla_dias_desde_frf.fireTableStructureChanged();
		//
		//Tabla dias desde fcierrre fturno
		modelo_tabla_dias_desde_fcierre_fturno = new DefaultTableModel();
		nombreColumnas_tabla_dias_desde_fcierre_fturno = new Vector<String> ();
		anchos_tabla_dias_desde_fcierre_fturno = new Vector<Integer>();
		

		nombreColumnas_tabla_dias_desde_fcierre_fturno.add("ID Pedido");//0
		anchos_tabla_dias_desde_fcierre_fturno.add(75);
		nombreColumnas_tabla_dias_desde_fcierre_fturno.add("Numero Pedido");//1
		anchos_tabla_dias_desde_fcierre_fturno.add(chico);
		nombreColumnas_tabla_dias_desde_fcierre_fturno.add("Numero Pieza");//2
		anchos_tabla_dias_desde_fcierre_fturno.add(chico);
		nombreColumnas_tabla_dias_desde_fcierre_fturno.add("Descripcion");//3
		anchos_tabla_dias_desde_fcierre_fturno.add(mediano);
		nombreColumnas_tabla_dias_desde_fcierre_fturno.add("Numero Orden");//4
		anchos_tabla_dias_desde_fcierre_fturno.add(chico);
		nombreColumnas_tabla_dias_desde_fcierre_fturno.add("VIN");//5
		anchos_tabla_dias_desde_fcierre_fturno.add(130);
		nombreColumnas_tabla_dias_desde_fcierre_fturno.add("Registrante");//6
		anchos_tabla_dias_desde_fcierre_fturno.add(grande);
		nombreColumnas_tabla_dias_desde_fcierre_fturno.add("Fecha Solicitud Pedido");//7
		anchos_tabla_dias_desde_fcierre_fturno.add(mediano);
		nombreColumnas_tabla_dias_desde_fcierre_fturno.add("Fecha Turno");//8
		anchos_tabla_dias_desde_fcierre_fturno.add(mediano);
		nombreColumnas_tabla_dias_desde_fcierre_fturno.add("Fecha Cierre Orden");//9
		anchos_tabla_dias_desde_fcierre_fturno.add(mediano);
		nombreColumnas_tabla_dias_desde_fcierre_fturno.add("Dias Desde Turno a Cierre Orden");//10
		anchos_tabla_dias_desde_fcierre_fturno.add(grande);
		//
		
		datosTabla_dias_desde_fcierre_fturno = new Vector<Vector<String>>();
		
		for (int i=0; i< pedidos_piezas.size();i++){
			if(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getFecha_cierre()!=null && (pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_turno()!=null)){
							Vector<String> row = new Vector<String> ();
	
				row.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
				row.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
				row.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
				row.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
				
				SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 
	
				if(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido()!=null){
					java.sql.Date fsp = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido().getTime());
					row.add(format2.format(fsp));//Fecha Solicitud Pedido
				}else{
					row.add("");
				}			    
				java.sql.Date fturno = null;
				if (pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_turno()!=null){
					fturno = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_turno().getTime());
					row.add(format2.format(fturno));//Fecha Turno
				}else{
					row.add("");
				}
				java.sql.Date fcierre = null;
				if (pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getFecha_cierre()!=null){
					fcierre = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getFecha_cierre().getTime());
					row.add(format2.format(fcierre));//Fecha Cierre
				}else{
					row.add("");
				}
				if(fturno!=null && fcierre!=null){
					final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 
					@SuppressWarnings("deprecation")
					Calendar calendar = new GregorianCalendar(fturno.getYear(), fturno.getMonth()-1, fturno.getDay());
					long diferencia = ( fcierre.getTime() - fturno.getTime() )/MILLSECS_PER_DAY;
					row.add(String.valueOf(diferencia));
				}else{
					row.add("");
				}	
				datosTabla_dias_desde_fcierre_fturno.add(row);
			}
		}
		modelo_tabla_dias_desde_fcierre_fturno.setDataVector(datosTabla_dias_desde_fcierre_fturno, nombreColumnas_tabla_dias_desde_fcierre_fturno);
		modelo_tabla_dias_desde_fcierre_fturno.fireTableStructureChanged();
		//
		//Tabla dias desde frecurso fcierrre
		modelo_tabla_dias_desde_frecurso_fcierre = new DefaultTableModel();
		nombreColumnas_tabla_dias_desde_frecurso_fcierre = new Vector<String> ();
		anchos_tabla_dias_desde_frecurso_fcierre = new Vector<Integer>();
		

		nombreColumnas_tabla_dias_desde_frecurso_fcierre.add("ID Pedido");//0
		anchos_tabla_dias_desde_frecurso_fcierre.add(75);
		nombreColumnas_tabla_dias_desde_frecurso_fcierre.add("Numero Pedido");//1
		anchos_tabla_dias_desde_frecurso_fcierre.add(chico);
		nombreColumnas_tabla_dias_desde_frecurso_fcierre.add("Numero Pieza");//2
		anchos_tabla_dias_desde_frecurso_fcierre.add(chico);
		nombreColumnas_tabla_dias_desde_frecurso_fcierre.add("Descripcion");//3
		anchos_tabla_dias_desde_frecurso_fcierre.add(mediano);
		nombreColumnas_tabla_dias_desde_frecurso_fcierre.add("Numero Orden");//4
		anchos_tabla_dias_desde_frecurso_fcierre.add(chico);
		nombreColumnas_tabla_dias_desde_frecurso_fcierre.add("VIN");//5
		anchos_tabla_dias_desde_frecurso_fcierre.add(130);
		nombreColumnas_tabla_dias_desde_frecurso_fcierre.add("Registrante");//6
		anchos_tabla_dias_desde_frecurso_fcierre.add(grande);
		nombreColumnas_tabla_dias_desde_frecurso_fcierre.add("Fecha Solicitud Pedido");//7
		anchos_tabla_dias_desde_frecurso_fcierre.add(mediano);
		nombreColumnas_tabla_dias_desde_frecurso_fcierre.add("Fecha Recurso");//8
		anchos_tabla_dias_desde_frecurso_fcierre.add(mediano);
		nombreColumnas_tabla_dias_desde_frecurso_fcierre.add("Fecha Cierre Orden");//9
		anchos_tabla_dias_desde_frecurso_fcierre.add(mediano);
		nombreColumnas_tabla_dias_desde_frecurso_fcierre.add("Dias Desde Recurso a Cierre Orden");//
		anchos_tabla_dias_desde_frecurso_fcierre.add(grande);
		//
		
		datosTabla_dias_desde_frecurso_fcierre = new Vector<Vector<String>>();
		
		for (int i=0; i< pedidos_piezas.size();i++){
			if(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getFecha_cierre()!=null && pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden()!=null && pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getRecurso()!=null && pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getRecurso().getFecha_recurso()!=null ){
							Vector<String> row = new Vector<String> ();
							
				row.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
				row.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
				row.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
				row.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
				
				SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 
	
				if(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido()!=null){
					java.sql.Date fsp = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido().getTime());
					row.add(format2.format(fsp));//Fecha Solicitud Pedido
				}else{
					row.add("");
				}			    
				java.sql.Date frecurso = null;
				if (pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getRecurso().getFecha_recurso()!=null){
					frecurso = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getRecurso().getFecha_recurso().getTime());
					row.add(format2.format(frecurso));//Fecha recurso
				}else{
					row.add("");
				}
				java.sql.Date fcierre = null;
				if (pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getFecha_cierre()!=null){
					fcierre = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getFecha_cierre().getTime());
					row.add(format2.format(fcierre));//Fecha Cierre
				}else{
					row.add("");
				}
				if(frecurso!=null && fcierre!=null){
					final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 
					@SuppressWarnings("deprecation")
					Calendar calendar = new GregorianCalendar(frecurso.getYear(), frecurso.getMonth()-1, frecurso.getDay());
					long diferencia = ( fcierre.getTime() - frecurso.getTime() )/MILLSECS_PER_DAY;
					row.add(String.valueOf(diferencia));
				}else{
					row.add("");
				}	
				datosTabla_dias_desde_frecurso_fcierre.add(row);
			}
		}
		modelo_tabla_dias_desde_frecurso_fcierre.setDataVector(datosTabla_dias_desde_frecurso_fcierre, nombreColumnas_tabla_dias_desde_frecurso_fcierre);
		modelo_tabla_dias_desde_frecurso_fcierre.fireTableStructureChanged();
		////////////////// FIN	/////////////////
		
		////////////////////////////////////////
		//	TABLA DIAS DESDE FRF A FTURNO	  //
		////////////////////////////////////////
		modelo_tabla_dias_desde_frf_fturno = new DefaultTableModel();
		nombreColumnas_tabla_dias_desde_frf_fturno = new Vector<String> ();
		anchos_tabla_dias_desde_frf_fturno = new Vector<Integer>();

		nombreColumnas_tabla_dias_desde_frf_fturno.add("ID Pedido");//0
		anchos_tabla_dias_desde_frf_fturno.add(75);
		nombreColumnas_tabla_dias_desde_frf_fturno.add("Numero Pedido");//1
		anchos_tabla_dias_desde_frf_fturno.add(chico);
		nombreColumnas_tabla_dias_desde_frf_fturno.add("Numero Pieza");//2
		anchos_tabla_dias_desde_frf_fturno.add(chico);
		nombreColumnas_tabla_dias_desde_frf_fturno.add("Descripcion");//3
		anchos_tabla_dias_desde_frf_fturno.add(mediano);
		nombreColumnas_tabla_dias_desde_frf_fturno.add("Numero Orden");//4
		anchos_tabla_dias_desde_frf_fturno.add(chico);
		nombreColumnas_tabla_dias_desde_frf_fturno.add("VIN");//5
		anchos_tabla_dias_desde_frf_fturno.add(130);
		nombreColumnas_tabla_dias_desde_frf_fturno.add("Registrante");//6
		anchos_tabla_dias_desde_frf_fturno.add(grande);
		nombreColumnas_tabla_dias_desde_frf_fturno.add("Fecha Solicitud Pedido");//7
		anchos_tabla_dias_desde_frf_fturno.add(mediano);
		nombreColumnas_tabla_dias_desde_frf_fturno.add("Fecha Turno");//8
		anchos_tabla_dias_desde_frf_fturno.add(mediano);
		nombreColumnas_tabla_dias_desde_frf_fturno.add("Fecha Solicitud Fabrica");//9
		anchos_tabla_dias_desde_frf_fturno.add(mediano);
		nombreColumnas_tabla_dias_desde_frf_fturno.add("Fecha Recepcion Fabrica");//10
		anchos_tabla_dias_desde_frf_fturno.add(mediano);
		nombreColumnas_tabla_dias_desde_frf_fturno.add("Dias Desde Recepcion Fabrica a Fecha Turno");//11
		anchos_tabla_dias_desde_frf_fturno.add(grande);
		
		datosTabla_dias_desde_frf_fturno = new Vector<Vector<String>>();
												
		for (int i=0; i< pedidos_piezas.size();i++){
			boolean resp = false;
			if (mediador.esEntidad(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante())){
				resp = pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getDevolucion_pieza()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null && pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_turno()!=null;
			}	
			if(resp){
				
				Vector<String> row = new Vector<String> ();

				row.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
				row.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
				row.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
				row.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
				
				SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 

				if(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido()!=null){
					java.sql.Date fsp = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido().getTime());
					row.add(format2.format(fsp));//Fecha Solicitud Pedido
				}else{
					row.add("");
				}			    
				java.sql.Date fturno = null;
				if (pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_turno()!=null){
					fturno = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_turno().getTime());
					row.add(format2.format(fturno));//Fecha Turno
				}else{
					row.add("");
				}
				java.sql.Date fsf = null;
				if (pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null){
					fsf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica().getTime());
					row.add(format2.format(fsf));//Fecha solicitud Fabrica
				}else{
					row.add("");
				}
				java.sql.Date frf = null;
				if (pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null){
					frf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().getTime());
					row.add(format2.format(frf));//Fecha Recepcion Fabrica
				}else{
					row.add("");
				}
				if(fturno!=null && frf!=null){
					final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 
					@SuppressWarnings("deprecation")
					Calendar calendar = new GregorianCalendar(fturno.getYear(), fturno.getMonth()-1, fturno.getDay());
					long diferencia = (fturno.getTime() -  frf.getTime() )/MILLSECS_PER_DAY;
					row.add(String.valueOf(diferencia));
				}else{
					row.add("");
				}	
				datosTabla_dias_desde_frf_fturno.add(row);
			}
		}
		modelo_tabla_dias_desde_frf_fturno.setDataVector(datosTabla_dias_desde_frf_fturno, nombreColumnas_tabla_dias_desde_frf_fturno);
		modelo_tabla_dias_desde_frf_fturno.fireTableStructureChanged();
		////////////////// FIN	/////////////////
		
		//////////////////////////////////////////////
		//	TABLA DIAS DESDE FRECLAMO A FDEVOLUCION	//
		//////////////////////////////////////////////
		modelo_tabla_dias_desde_freclamo_fdevolucion = new DefaultTableModel();
		nombreColumnas_tabla_dias_desde_freclamo_fdevolucion = new Vector<String> ();
		anchos_tabla_dias_desde_freclamo_fdevolucion = new Vector<Integer>();

		nombreColumnas_tabla_dias_desde_freclamo_fdevolucion.add("ID Pedido");//0
		anchos_tabla_dias_desde_freclamo_fdevolucion.add(75);
		nombreColumnas_tabla_dias_desde_freclamo_fdevolucion.add("Numero Pedido");//1
		anchos_tabla_dias_desde_freclamo_fdevolucion.add(chico);
		nombreColumnas_tabla_dias_desde_freclamo_fdevolucion.add("Numero Pieza");//2
		anchos_tabla_dias_desde_freclamo_fdevolucion.add(chico);
		nombreColumnas_tabla_dias_desde_freclamo_fdevolucion.add("Descripcion");//3
		anchos_tabla_dias_desde_freclamo_fdevolucion.add(mediano);
		nombreColumnas_tabla_dias_desde_freclamo_fdevolucion.add("Numero Orden");//4
		anchos_tabla_dias_desde_freclamo_fdevolucion.add(chico);
		nombreColumnas_tabla_dias_desde_freclamo_fdevolucion.add("VIN");//5
		anchos_tabla_dias_desde_freclamo_fdevolucion.add(130);
		nombreColumnas_tabla_dias_desde_freclamo_fdevolucion.add("Registrante");//6
		anchos_tabla_dias_desde_freclamo_fdevolucion.add(grande);
		nombreColumnas_tabla_dias_desde_freclamo_fdevolucion.add("Fecha Reclamo");//7
		anchos_tabla_dias_desde_freclamo_fdevolucion.add(mediano);
		nombreColumnas_tabla_dias_desde_freclamo_fdevolucion.add("Fecha Pedido a Fabrica");//8
		anchos_tabla_dias_desde_freclamo_fdevolucion.add(mediano);
		nombreColumnas_tabla_dias_desde_freclamo_fdevolucion.add("Fecha Recepcion de Fabrica");//9
		anchos_tabla_dias_desde_freclamo_fdevolucion.add(mediano);
		nombreColumnas_tabla_dias_desde_freclamo_fdevolucion.add("Fecha Devolucion a Fabrica");//10
		anchos_tabla_dias_desde_freclamo_fdevolucion.add(mediano);
		nombreColumnas_tabla_dias_desde_freclamo_fdevolucion.add("Dias Desde Fecha Reclamo a Fecha Devolucion");//11
		anchos_tabla_dias_desde_freclamo_fdevolucion.add(grande);
		
		datosTabla_dias_desde_freclamo_fdevolucion = new Vector<Vector<String>>();
		
		for (int i=0; i< pedidos_piezas.size();i++){

			if(pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_reclamo()!=null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null && 
					pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getDevolucion_pieza()!=null && pedidos_piezas.elementAt(i).getDevolucion_pieza().getFecha_devolucion()!=null){
				
				Vector<String> row = new Vector<String> ();

				row.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
				row.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
				row.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
				row.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
				
				SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 
				java.sql.Date freclamo = null;
				if(pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_reclamo()!=null){
					freclamo = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_reclamo().getTime());
					row.add(format2.format(freclamo));//Fecha Reclamo
				}else{
					row.add("");
				}			    
				if (pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null){
					java.sql.Date fsf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica().getTime());
					row.add(format2.format(fsf));//Fecha Pedido Fabrica 
				}else{
					row.add("");
				}
				if (pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null){
					java.sql.Date frf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().getTime());
					row.add(format2.format(frf));//Fecha Recepcion Fabrica 
				}else{
					row.add("");
				}
				java.sql.Date fdf = null;
				if (pedidos_piezas.elementAt(i).getDevolucion_pieza().getFecha_devolucion()!=null){
					fdf = new java.sql.Date(pedidos_piezas.elementAt(i).getDevolucion_pieza().getFecha_devolucion().getTime());
					row.add(format2.format(fdf));//Fecha Devolucion Fabrica 
				}else{
					row.add("");
				}
				if(fdf!=null && freclamo!=null){
					final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 
					@SuppressWarnings("deprecation")
					Calendar calendar = new GregorianCalendar(fdf.getYear(), fdf.getMonth()-1, fdf.getDay());
					long diferencia = (fdf.getTime() - freclamo.getTime())/MILLSECS_PER_DAY;
					row.add(String.valueOf(diferencia));
				}else{
					row.add("");
				}	
				datosTabla_dias_desde_freclamo_fdevolucion.add(row);
			}
		}
		modelo_tabla_dias_desde_freclamo_fdevolucion.setDataVector(datosTabla_dias_desde_freclamo_fdevolucion, nombreColumnas_tabla_dias_desde_freclamo_fdevolucion);
		modelo_tabla_dias_desde_freclamo_fdevolucion.fireTableStructureChanged();
		////////////////// FIN	/////////////////
		
		//////////////////////////////////////////////
		//			TABLA RECLAMOS TURNOS 			//
		//////////////////////////////////////////////
		modelo_tabla_reclamos_turno_Reclamos = new DefaultTableModel();
		nombreColumnas_tabla_reclamos_turno_Reclamos = new Vector<String> ();
		anchos_tabla_reclamos_turno_Reclamos = new Vector<Integer>();

		nombreColumnas_tabla_reclamos_turno_Reclamos.add("ID Pedido");//0
		anchos_tabla_reclamos_turno_Reclamos.add(75);
		nombreColumnas_tabla_reclamos_turno_Reclamos.add("Numero Pedido");//1
		anchos_tabla_reclamos_turno_Reclamos.add(chico);
		nombreColumnas_tabla_reclamos_turno_Reclamos.add("Numero Pieza");//2
		anchos_tabla_reclamos_turno_Reclamos.add(chico);
		nombreColumnas_tabla_reclamos_turno_Reclamos.add("Descripcion");//3
		anchos_tabla_reclamos_turno_Reclamos.add(mediano);
		nombreColumnas_tabla_reclamos_turno_Reclamos.add("Numero Orden");//4
		anchos_tabla_reclamos_turno_Reclamos.add(chico);
		nombreColumnas_tabla_reclamos_turno_Reclamos.add("VIN");//5
		anchos_tabla_reclamos_turno_Reclamos.add(130);
		nombreColumnas_tabla_reclamos_turno_Reclamos.add("Registrante");//6
		anchos_tabla_reclamos_turno_Reclamos.add(grande);
		nombreColumnas_tabla_reclamos_turno_Reclamos.add("Fecha Reclamo");//7
		anchos_tabla_reclamos_turno_Reclamos.add(mediano);
		nombreColumnas_tabla_reclamos_turno_Reclamos.add("Fecha Turno");//8
		anchos_tabla_reclamos_turno_Reclamos.add(mediano);
		nombreColumnas_tabla_reclamos_turno_Reclamos.add("Fecha Solicitud a Fabrica");//9
		anchos_tabla_reclamos_turno_Reclamos.add(mediano);
		nombreColumnas_tabla_reclamos_turno_Reclamos.add("Fecha Recepcion de Fabrica");//10
		anchos_tabla_reclamos_turno_Reclamos.add(mediano);
		nombreColumnas_tabla_reclamos_turno_Reclamos.add("Fecha Devolucion a Fabrica");//11
		anchos_tabla_reclamos_turno_Reclamos.add(mediano);
		
		datos_tabla_reclamos_turno_Reclamos = new Vector<Vector<String>>();
		
		modelo_tabla_reclamos_turno_Turno = new DefaultTableModel();
		nombreColumnas_tabla_reclamos_turno_Turno = new Vector<String> ();
		anchos_tabla_reclamos_turno_Turno = new Vector<Integer>();

		nombreColumnas_tabla_reclamos_turno_Turno.add("ID Pedido");//0
		anchos_tabla_reclamos_turno_Turno.add(75);
		nombreColumnas_tabla_reclamos_turno_Turno.add("Numero Pedido");//1
		anchos_tabla_reclamos_turno_Turno.add(chico);
		nombreColumnas_tabla_reclamos_turno_Turno.add("Numero Pieza");//2
		anchos_tabla_reclamos_turno_Turno.add(chico);
		nombreColumnas_tabla_reclamos_turno_Turno.add("Descripcion");//3
		anchos_tabla_reclamos_turno_Turno.add(mediano);
		nombreColumnas_tabla_reclamos_turno_Turno.add("Numero Orden");//4
		anchos_tabla_reclamos_turno_Turno.add(chico);
		nombreColumnas_tabla_reclamos_turno_Turno.add("VIN");//5
		anchos_tabla_reclamos_turno_Turno.add(130);
		nombreColumnas_tabla_reclamos_turno_Turno.add("Registrante");//6
		anchos_tabla_reclamos_turno_Turno.add(grande);
		nombreColumnas_tabla_reclamos_turno_Turno.add("Fecha Reclamo");//7
		anchos_tabla_reclamos_turno_Turno.add(mediano);
		nombreColumnas_tabla_reclamos_turno_Turno.add("Fecha Turno");//8
		anchos_tabla_reclamos_turno_Turno.add(mediano);
		nombreColumnas_tabla_reclamos_turno_Turno.add("Fecha Solicitud a Fabrica");//9
		anchos_tabla_reclamos_turno_Turno.add(mediano);
		nombreColumnas_tabla_reclamos_turno_Turno.add("Fecha Recepcion de Fabrica");//10
		anchos_tabla_reclamos_turno_Turno.add(mediano);
		nombreColumnas_tabla_reclamos_turno_Turno.add("Fecha Devolucion a Fabrica");//11
		anchos_tabla_reclamos_turno_Turno.add(mediano);

		
		datos_tabla_reclamos_turno_Turno = new Vector<Vector<String>>();
		numero_reclamos = 0;
		numero_turnos = 0;
		for (int i=0; i< pedidos_piezas.size();i++){
			if(mediador.esEntidad(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante())){
				
				Vector<String> rowReclamo = new Vector<String> ();
				Vector<String> rowTurno = new Vector<String> ();
																
				if(pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_turno()!=null){
					rowReclamo.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
					rowTurno.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
					rowReclamo.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
					rowTurno.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
					rowReclamo.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
					rowTurno.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
					rowReclamo.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
					rowTurno.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
					rowReclamo.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
					rowTurno.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
					rowReclamo.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
					rowTurno.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
					rowReclamo.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
					rowTurno.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
					
					SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 
	
					if(pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_reclamo()!=null){
						java.sql.Date fr = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_reclamo().getTime());
						rowReclamo.add(format2.format(fr));//Fecha Reclamo
						rowTurno.add(format2.format(fr));//Fecha Reclamo
					}else{
						rowReclamo.add("");
						rowTurno.add("");
					}			    
					java.sql.Date fturno = null;
					if (pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_turno()!=null){
						fturno = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_turno().getTime());
						rowReclamo.add(format2.format(fturno));//Fecha Turno
						rowTurno.add(format2.format(fturno));//Fecha Turno
					}else{
						rowReclamo.add("");
						rowTurno.add("");
					}
					java.sql.Date fsf = null;
					if (pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null){
						fsf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica().getTime());
						rowReclamo.add(format2.format(fsf));//Fecha solicitud Fabrica
						rowTurno.add(format2.format(fsf));//Fecha solicitud Fabrica
					}else{
						rowReclamo.add("");
						rowTurno.add("");
					}
					java.sql.Date frf = null;
					if (pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null){
						frf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().getTime());
						rowReclamo.add(format2.format(frf));//Fecha Recepcion Fabrica
						rowTurno.add(format2.format(frf));//Fecha Recepcion Fabrica
					}else{
						rowReclamo.add("");
						rowTurno.add("");
					}
					java.sql.Date fdf = null;
					if (pedidos_piezas.elementAt(i).getDevolucion_pieza()!=null && pedidos_piezas.elementAt(i).getDevolucion_pieza().getFecha_devolucion()!=null){
						fdf = new java.sql.Date(pedidos_piezas.elementAt(i).getDevolucion_pieza().getFecha_devolucion().getTime());
						rowReclamo.add(format2.format(fdf));//Fecha Devolucion Fabrica 
						rowTurno.add(format2.format(fdf));//Fecha Devolucion Fabrica 
					}else{
						rowReclamo.add("");
						rowTurno.add("");
					}
					numero_reclamos++;
					numero_turnos++;
					datos_tabla_reclamos_turno_Turno.add(rowTurno);
					datos_tabla_reclamos_turno_Reclamos.add(rowReclamo);
				}else{
					rowReclamo.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
					rowReclamo.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
					rowReclamo.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
					rowReclamo.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
					rowReclamo.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
					rowReclamo.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
					rowReclamo.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
					
					SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 
	
					if(pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_reclamo()!=null){
						java.sql.Date fr = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_reclamo().getTime());
						rowReclamo.add(format2.format(fr));//Fecha Reclamo
					}else{
						rowReclamo.add("");
					}			    
					java.sql.Date fturno = null;
					if (pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_turno()!=null){
						fturno = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_turno().getTime());
						rowReclamo.add(format2.format(fturno));//Fecha Turno
					}else{
						rowReclamo.add("");
					}
					java.sql.Date fsf = null;
					if (pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null){
						fsf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica().getTime());
						rowReclamo.add(format2.format(fsf));//Fecha solicitud Fabrica
					}else{
						rowReclamo.add("");
					}
					java.sql.Date frf = null;
					if (pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null){
						frf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().getTime());
						rowReclamo.add(format2.format(frf));//Fecha Recepcion Fabrica
					}else{
						rowReclamo.add("");
					}
					java.sql.Date fdf = null;
					if (pedidos_piezas.elementAt(i).getDevolucion_pieza()!=null && pedidos_piezas.elementAt(i).getDevolucion_pieza().getFecha_devolucion()!=null){
						fdf = new java.sql.Date(pedidos_piezas.elementAt(i).getDevolucion_pieza().getFecha_devolucion().getTime());
						rowReclamo.add(format2.format(fdf));//Fecha Devolucion Fabrica 
					}else{
						rowReclamo.add("");
					}
					numero_reclamos++;
					datos_tabla_reclamos_turno_Reclamos.add(rowReclamo);
				}
			}
		}
		modelo_tabla_reclamos_turno_Reclamos.setDataVector(datos_tabla_reclamos_turno_Reclamos, nombreColumnas_tabla_reclamos_turno_Reclamos);
		modelo_tabla_reclamos_turno_Reclamos.fireTableStructureChanged();
		modelo_tabla_reclamos_turno_Turno.setDataVector(datos_tabla_reclamos_turno_Turno, nombreColumnas_tabla_reclamos_turno_Turno);
		modelo_tabla_reclamos_turno_Turno.fireTableStructureChanged();

		////////////////// FIN	/////////////////
		
		//////////////////////////////////////////////
		//	TABLA PIEZAS LLEGADAS PIEZAS DEVUELTAS	//
		//////////////////////////////////////////////
		modelo_tabla_Pllegadas_PDevuletas_LLegadas = new DefaultTableModel();
		nombreColumnas_tabla_Pllegadas_PDevuletas_LLegadas = new Vector<String> ();
		anchos_tabla_Pllegadas_PDevuletas_LLegadas = new Vector<Integer>();

		nombreColumnas_tabla_Pllegadas_PDevuletas_LLegadas.add("ID Pedido");//0
		anchos_tabla_Pllegadas_PDevuletas_LLegadas.add(75);
		nombreColumnas_tabla_Pllegadas_PDevuletas_LLegadas.add("Numero Pedido");//1
		anchos_tabla_Pllegadas_PDevuletas_LLegadas.add(chico);
		nombreColumnas_tabla_Pllegadas_PDevuletas_LLegadas.add("Numero Pieza");//2
		anchos_tabla_Pllegadas_PDevuletas_LLegadas.add(chico);
		nombreColumnas_tabla_Pllegadas_PDevuletas_LLegadas.add("Descripcion");//3
		anchos_tabla_Pllegadas_PDevuletas_LLegadas.add(mediano);
		nombreColumnas_tabla_Pllegadas_PDevuletas_LLegadas.add("Numero Orden");//4
		anchos_tabla_Pllegadas_PDevuletas_LLegadas.add(chico);
		nombreColumnas_tabla_Pllegadas_PDevuletas_LLegadas.add("VIN");//5
		anchos_tabla_Pllegadas_PDevuletas_LLegadas.add(130);
		nombreColumnas_tabla_Pllegadas_PDevuletas_LLegadas.add("Registrante");//6
		anchos_tabla_Pllegadas_PDevuletas_LLegadas.add(grande);
		nombreColumnas_tabla_Pllegadas_PDevuletas_LLegadas.add("Fecha Reclamo");//7
		anchos_tabla_Pllegadas_PDevuletas_LLegadas.add(mediano);
		nombreColumnas_tabla_Pllegadas_PDevuletas_LLegadas.add("Fecha Turno");//8
		anchos_tabla_Pllegadas_PDevuletas_LLegadas.add(mediano);
		nombreColumnas_tabla_Pllegadas_PDevuletas_LLegadas.add("Fecha Solicitud a Fabrica");//9
		anchos_tabla_Pllegadas_PDevuletas_LLegadas.add(mediano);
		nombreColumnas_tabla_Pllegadas_PDevuletas_LLegadas.add("Fecha Recepcion de Fabrica");//10
		anchos_tabla_Pllegadas_PDevuletas_LLegadas.add(mediano);
		nombreColumnas_tabla_Pllegadas_PDevuletas_LLegadas.add("Fecha Devolucion a Fabrica");//11
		anchos_tabla_Pllegadas_PDevuletas_LLegadas.add(mediano);
		
		datos_tabla_Pllegadas_PDevuletas_LLegadas = new Vector<Vector<String>>();
		
		modelo_tabla_Pllegadas_PDevuletas_Devueltas = new DefaultTableModel();
		nombreColumnas_tabla_Pllegadas_PDevuletas_Devueltas = new Vector<String> ();
		anchos_tabla_Pllegadas_PDevuletas_Devueltas = new Vector<Integer>();

		nombreColumnas_tabla_Pllegadas_PDevuletas_Devueltas.add("ID Pedido");//0
		anchos_tabla_Pllegadas_PDevuletas_Devueltas.add(75);
		nombreColumnas_tabla_Pllegadas_PDevuletas_Devueltas.add("Numero Pedido");//1
		anchos_tabla_Pllegadas_PDevuletas_Devueltas.add(chico);
		nombreColumnas_tabla_Pllegadas_PDevuletas_Devueltas.add("Numero Pieza");//2
		anchos_tabla_Pllegadas_PDevuletas_Devueltas.add(chico);
		nombreColumnas_tabla_Pllegadas_PDevuletas_Devueltas.add("Descripcion");//3
		anchos_tabla_Pllegadas_PDevuletas_Devueltas.add(mediano);
		nombreColumnas_tabla_Pllegadas_PDevuletas_Devueltas.add("Numero Orden");//4
		anchos_tabla_Pllegadas_PDevuletas_Devueltas.add(chico);
		nombreColumnas_tabla_Pllegadas_PDevuletas_Devueltas.add("VIN");//5
		anchos_tabla_Pllegadas_PDevuletas_Devueltas.add(130);
		nombreColumnas_tabla_Pllegadas_PDevuletas_Devueltas.add("Registrante");//6
		anchos_tabla_Pllegadas_PDevuletas_Devueltas.add(grande);
		nombreColumnas_tabla_Pllegadas_PDevuletas_Devueltas.add("Fecha Reclamo");//7
		anchos_tabla_Pllegadas_PDevuletas_Devueltas.add(mediano);
		nombreColumnas_tabla_Pllegadas_PDevuletas_Devueltas.add("Fecha Turno");//8
		anchos_tabla_Pllegadas_PDevuletas_Devueltas.add(mediano);
		nombreColumnas_tabla_Pllegadas_PDevuletas_Devueltas.add("Fecha Solicitud a Fabrica");//9
		anchos_tabla_Pllegadas_PDevuletas_Devueltas.add(mediano);
		nombreColumnas_tabla_Pllegadas_PDevuletas_Devueltas.add("Fecha Recepcion de Fabrica");//10
		anchos_tabla_Pllegadas_PDevuletas_Devueltas.add(mediano);
		nombreColumnas_tabla_Pllegadas_PDevuletas_Devueltas.add("Fecha Devolucion a Fabrica");//11
		anchos_tabla_Pllegadas_PDevuletas_Devueltas.add(mediano);

		
		datos_tabla_Pllegadas_PDevuletas_Devueltas = new Vector<Vector<String>>();
		
		numero_PiezasLlegadas = 0;
		numero_PiezasDevueltas = 0;
		for (int i=0; i< pedidos_piezas.size();i++){
																
			Vector<String> rowPLlegadas = new Vector<String> ();
			if(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null){
				rowPLlegadas.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
				rowPLlegadas.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
				rowPLlegadas.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
				rowPLlegadas.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
				rowPLlegadas.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
				rowPLlegadas.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
				rowPLlegadas.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
				
				SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 
	
				if(pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_reclamo()!=null){
					java.sql.Date fr = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_reclamo().getTime());
					rowPLlegadas.add(format2.format(fr));//Fecha Reclamo
				}else{
					rowPLlegadas.add("");
				}			    
				java.sql.Date fturno = null;
				if (pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_turno()!=null){
					fturno = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_turno().getTime());
					rowPLlegadas.add(format2.format(fturno));//Fecha Turno
				}else{
					rowPLlegadas.add("");
				}
				java.sql.Date fsf = null;
				if (pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null){
					fsf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica().getTime());
					rowPLlegadas.add(format2.format(fsf));//Fecha solicitud Fabrica
				}else{
					rowPLlegadas.add("");
				}
				java.sql.Date frf = null;
				if (pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null){
					frf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().getTime());
					rowPLlegadas.add(format2.format(frf));//Fecha Recepcion Fabrica
				}else{
					rowPLlegadas.add("");
				}
				java.sql.Date fdf = null;
				if (pedidos_piezas.elementAt(i).getDevolucion_pieza()!=null && pedidos_piezas.elementAt(i).getDevolucion_pieza().getFecha_devolucion()!=null){
					fdf = new java.sql.Date(pedidos_piezas.elementAt(i).getDevolucion_pieza().getFecha_devolucion().getTime());
					rowPLlegadas.add(format2.format(fdf));//Fecha Devolucion Fabrica 
				}else{
					rowPLlegadas.add("");
				}
				datos_tabla_Pllegadas_PDevuletas_LLegadas.add(rowPLlegadas);
				numero_PiezasLlegadas++;
			}
			Vector<String> rowPDevueltas = new Vector<String> ();
			if(pedidos_piezas.elementAt(i).getDevolucion_pieza()!=null && pedidos_piezas.elementAt(i).getDevolucion_pieza().getFecha_devolucion()!=null){
				rowPDevueltas.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
				rowPDevueltas.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
				rowPDevueltas.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
				rowPDevueltas.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
				rowPDevueltas.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
				rowPDevueltas.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
				rowPDevueltas.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
				
				SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 
	
				if(pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_reclamo()!=null){
					java.sql.Date fr = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_reclamo().getTime());
					rowPDevueltas.add(format2.format(fr));//Fecha Reclamo
				}else{
					rowPDevueltas.add("");
				}			    
				java.sql.Date fturno = null;
				if (pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_turno()!=null){
					fturno = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getReclamo().getFecha_turno().getTime());
					rowPDevueltas.add(format2.format(fturno));//Fecha Turno
				}else{
					rowPDevueltas.add("");
				}
				java.sql.Date fsf = null;
				if (pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null){
					fsf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica().getTime());
					rowPDevueltas.add(format2.format(fsf));//Fecha solicitud Fabrica
				}else{
					rowPDevueltas.add("");
				}
				java.sql.Date frf = null;
				if (pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null){
					frf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().getTime());
					rowPDevueltas.add(format2.format(frf));//Fecha Recepcion Fabrica
				}else{
					rowPDevueltas.add("");
				}
				java.sql.Date fdf = null;
				if (pedidos_piezas.elementAt(i).getDevolucion_pieza()!=null && pedidos_piezas.elementAt(i).getDevolucion_pieza().getFecha_devolucion()!=null){
					fdf = new java.sql.Date(pedidos_piezas.elementAt(i).getDevolucion_pieza().getFecha_devolucion().getTime());
					rowPDevueltas.add(format2.format(fdf));//Fecha Devolucion Fabrica 
				}else{
					rowPDevueltas.add("");
				}
				datos_tabla_Pllegadas_PDevuletas_Devueltas.add(rowPDevueltas);
				numero_PiezasDevueltas++;
			}
		}
		modelo_tabla_Pllegadas_PDevuletas_Devueltas.setDataVector(datos_tabla_Pllegadas_PDevuletas_Devueltas, nombreColumnas_tabla_Pllegadas_PDevuletas_Devueltas);
		modelo_tabla_Pllegadas_PDevuletas_Devueltas.fireTableStructureChanged();
		modelo_tabla_Pllegadas_PDevuletas_LLegadas.setDataVector(datos_tabla_Pllegadas_PDevuletas_LLegadas, nombreColumnas_tabla_Pllegadas_PDevuletas_LLegadas);
		modelo_tabla_Pllegadas_PDevuletas_LLegadas.fireTableStructureChanged();	
		////////////////// FIN	/////////////////
		
		////////////////////////////////////////
		//			TABLA MANO OBRA			  //
		////////////////////////////////////////
		modelo_tabla_mano_obra = new DefaultTableModel();
		nombreColumnas_tabla_mano_obra = new Vector<String> ();
		anchos_tabla_mano_obra = new Vector<Integer>();

		nombreColumnas_tabla_mano_obra.add("ID Pedido");//0
		anchos_tabla_mano_obra.add(75);
		nombreColumnas_tabla_mano_obra.add("Numero Pedido");//1
		anchos_tabla_mano_obra.add(chico);
		nombreColumnas_tabla_mano_obra.add("Numero Pieza");//2
		anchos_tabla_mano_obra.add(chico);
		nombreColumnas_tabla_mano_obra.add("Descripcion");//3
		anchos_tabla_mano_obra.add(mediano);
		nombreColumnas_tabla_mano_obra.add("Numero Orden");//4
		anchos_tabla_mano_obra.add(chico);
		nombreColumnas_tabla_mano_obra.add("VIN");//5
		anchos_tabla_mano_obra.add(130);
		nombreColumnas_tabla_mano_obra.add("Registrante");//6
		anchos_tabla_mano_obra.add(grande);
//		nombreColumnas_tabla_mano_obra.add("Mano Obra Reclamo");//7
//		anchos_tabla_mano_obra.add(mediano);
		nombreColumnas_tabla_mano_obra.add("ID Mano Obra");//8
		anchos_tabla_mano_obra.add(mediano);
		nombreColumnas_tabla_mano_obra.add("Codigo Mano Obra");//9
		anchos_tabla_mano_obra.add(mediano);
		nombreColumnas_tabla_mano_obra.add("Cantidad Mano Obra");//10
		anchos_tabla_mano_obra.add(mediano);
		nombreColumnas_tabla_mano_obra.add("Valor Mano Obra");//11
		anchos_tabla_mano_obra.add(mediano);
		
		datos_tabla_mano_obra = new Vector<Vector<String>>();
		
		
		hs_mano_obra = 0;
		preico_mano_obra = 0;
		for (int i=0; i< pedidos_piezas.size();i++){

			if(pedidos_piezas.elementAt(i).getMano_obra()!=null && mediador.esEntidad(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante())){
				
				Vector<String> row = new Vector<String> ();

				row.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
				row.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
				row.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
				row.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
				row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
				if (pedidos_piezas.elementAt(i).getMano_obra()!=null){
					row.add(pedidos_piezas.elementAt(i).getMano_obra().getId().toString());
					row.add(pedidos_piezas.elementAt(i).getMano_obra().getCodigo_mano_obra());
					row.add(String.valueOf(pedidos_piezas.elementAt(i).getMano_obra().getCantidad_horas()));
					hs_mano_obra += pedidos_piezas.elementAt(i).getMano_obra().getCantidad_horas(); 
					row.add(String.valueOf(pedidos_piezas.elementAt(i).getMano_obra().getValor_mano_obra()));
					preico_mano_obra += pedidos_piezas.elementAt(i).getMano_obra().getValor_mano_obra() * pedidos_piezas.elementAt(i).getMano_obra().getCantidad_horas();
				}else{
					row.add("");
					row.add("");
					row.add("");
					row.add("");
				}
				datos_tabla_mano_obra.add(row);
			}
		}
		modelo_tabla_mano_obra.setDataVector(datos_tabla_mano_obra, nombreColumnas_tabla_mano_obra);
		modelo_tabla_mano_obra.fireTableStructureChanged();
		////////////////// FIN	//////////////////
		
		//////////////////////////////////////////
		//	TABLA FECHA RECURSO - FECHA CIERRE ///
		//////////////////////////////////////////
		modelo_tabla_recurso_cierre = new DefaultTableModel();
		nombreColumnas_tabla_recurso_cierre = new Vector<String> ();
		anchos_tabla_recurso_cierre = new Vector<Integer>();

		nombreColumnas_tabla_recurso_cierre.add("ID Orden");//0
		anchos_tabla_recurso_cierre.add(mediano);
		nombreColumnas_tabla_recurso_cierre.add("ID Reclamo");//1
		anchos_tabla_recurso_cierre.add(mediano);
		nombreColumnas_tabla_recurso_cierre.add("Numero Orden");//3
		anchos_tabla_recurso_cierre.add(mediano);
		nombreColumnas_tabla_recurso_cierre.add("Fecha Apertura");//4
		anchos_tabla_recurso_cierre.add(mediano);
		nombreColumnas_tabla_recurso_cierre.add("Fecha Cierre Orden");//5
		anchos_tabla_recurso_cierre.add(mediano);
		nombreColumnas_tabla_recurso_cierre.add("ID Recurso");//6
		anchos_tabla_recurso_cierre.add(mediano);
		nombreColumnas_tabla_recurso_cierre.add("Numero Recurso");//7
		anchos_tabla_recurso_cierre.add(mediano);
		nombreColumnas_tabla_recurso_cierre.add("Fecha Recurso");//8
		anchos_tabla_recurso_cierre.add(mediano);
		nombreColumnas_tabla_recurso_cierre.add("Dias Desde Fecha Cierre Orden a Fecha Recurso");//9
		anchos_tabla_recurso_cierre.add(grande);
		
		datos_tabla_recurso_cierre = new Vector<Vector<String>>();
		
		Vector<ReclamoDTO> reclamos = mediador.obtenerReclamos();
		setN_casos(reclamos.size());
		setSum_frecurso_fcierre(0);
		SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy");
		for (int i=0; i< reclamos.size();i++){
			
				Vector<String> row = new Vector<String> ();

				row.add(reclamos.elementAt(i).getOrden().getId().toString());//ID Orden
				row.add(reclamos.elementAt(i).getId().toString());//ID Orden
				row.add(reclamos.elementAt(i).getOrden().getNumero_orden());//Numero Orden
				java.sql.Date fapertura = null;
				if(reclamos.elementAt(i).getOrden().getFecha_apertura()!=null){
					fapertura = new java.sql.Date(reclamos.elementAt(i).getOrden().getFecha_apertura().getTime());
					row.add(format2.format(fapertura));//Fecha Apertura
				}else{
					row.add("");
				}
				java.sql.Date fcierre = null;
				if(reclamos.elementAt(i).getOrden().getFecha_cierre()!=null){
					fcierre = new java.sql.Date(reclamos.elementAt(i).getOrden().getFecha_cierre().getTime());
					row.add(format2.format(fcierre));//Fecha Cierre
				}else{
					row.add("");
				}
				java.sql.Date frecurso = null;
				if(reclamos.elementAt(i).getOrden().getRecurso()!=null){
					row.add(reclamos.elementAt(i).getOrden().getRecurso().getId().toString());//ID Recurso
					row.add(reclamos.elementAt(i).getOrden().getRecurso().getNumero_recurso());//numero Recurso
					
					frecurso = new java.sql.Date(reclamos.elementAt(i).getOrden().getRecurso().getFecha_recurso().getTime());
					row.add(format2.format(frecurso));//Fecha Recurso
				}

				if(fcierre!=null && frecurso!=null){
					final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 
					@SuppressWarnings("deprecation")
					Calendar calendar = new GregorianCalendar(frecurso.getYear(), frecurso.getMonth()-1, frecurso.getDay());
					long diferencia = (frecurso.getTime() - fcierre.getTime())/MILLSECS_PER_DAY;
					row.add(String.valueOf(diferencia));
					setSum_frecurso_fcierre(getSum_frecurso_fcierre() + diferencia);
				}else{
					row.add("");
				}
				datos_tabla_recurso_cierre.add(row);
		}
		modelo_tabla_recurso_cierre.setDataVector(datos_tabla_recurso_cierre, nombreColumnas_tabla_recurso_cierre);
		modelo_tabla_recurso_cierre.fireTableStructureChanged();
		////////////////// FIN	/////////////////
		
	}

	private boolean conPedido(ReclamoDTO reclamo) {
		boolean resp = false;
		for (int i = 0; i< pedidos_piezas.size();i++){
			if(pedidos_piezas.elementAt(i).getPedido().getReclamo().getId().equals(reclamo.getId()))
				resp = true;
		}
		return resp;
	}

	private void initialize() {
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setTitle("REPORTES");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIReportes.class.getResource("/cliente/Resources/Icons/tablas.png")));
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane propios = new JTabbedPane(JTabbedPane.TOP);
		propios.setBounds(0, 0, 1239, 692);
		contentPane.add(propios);
		
		//GESTION

		JPanel pnGestion = new JPanel();
		propios.addTab("GESTION", null, pnGestion, null);
		pnGestion.setLayout(null);
		
		JTabbedPane gestion = new JTabbedPane(JTabbedPane.TOP);
		gestion.setBounds(0, 0, 1234, 664);
		pnGestion.add(gestion);
				
		JPanel pnControl = new JPanel();
		propios.addTab("CONTROL", null, pnControl, null);
		pnControl.setLayout(null);
		
		JTabbedPane control = new JTabbedPane(JTabbedPane.TOP);
		control.setBounds(0, 0, 1234, 664);
		pnControl.add(control);
		
		pnDiasDesdeFSolicitudFabirca = new JPanel();
		control.addTab("DIAS DESDE PEDIDO A FABRICA", null, pnDiasDesdeFSolicitudFabirca, null);
		pnDiasDesdeFSolicitudFabirca.setLayout(null);
		
		//Tabla diase desde FSF
		modelo_tabla_dias_desde_fsf = new DefaultTableModel(datosTabla_dias_desde_fsf, nombreColumnas_tabla_dias_desde_fsf);
		tablaDiasDesdeFSF = new JTable(modelo_tabla_dias_desde_fsf) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false,
					false, false, false,false, false,
					false, false,
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_tabla_dias_desde_fsf = new TableRowSorter<TableModel>(modelo_tabla_dias_desde_fsf);
		tablaDiasDesdeFSF.setRowSorter(ordenador_tabla_dias_desde_fsf);
		//
		tablaDiasDesdeFSF.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tablaDiasDesdeFSF.getColumnCount(); i++) {
			tablaDiasDesdeFSF.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_dias_desde_fsf.elementAt(i));
			tablaDiasDesdeFSF.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_dias_desde_fsf.elementAt(i));
		}
		tablaDiasDesdeFSF.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//se crea instancia a clase FormatoTable y se indica columna patron
        FormatoTablaDiasDesdeFSF ft = new FormatoTablaDiasDesdeFSF(9);
        tablaDiasDesdeFSF.setDefaultRenderer (Object.class, ft );
		
		scrollPane_dias_trascurridos_desde_pedido_fabrica= new JScrollPane(tablaDiasDesdeFSF);
		scrollPane_dias_trascurridos_desde_pedido_fabrica.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_dias_trascurridos_desde_pedido_fabrica.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_dias_trascurridos_desde_pedido_fabrica.setBounds(0, 200, 1230, 400);
		
		tablaDiasDesdeFSF.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				
		pnDiasDesdeFSolicitudFabirca.add(scrollPane_dias_trascurridos_desde_pedido_fabrica);

		///
		
		pnDiasDesdeFRecepcionFabirca = new JPanel();
		control.addTab("DIAS DESDE RECEPCION DE PEDIDO A FABRICA", null, pnDiasDesdeFRecepcionFabirca, null);
		
		//Tabla diase desde FRF
		modelo_tabla_dias_desde_frf = new DefaultTableModel(datosTabla_dias_desde_frf, nombreColumnas_tabla_dias_desde_frf);
		tablaDiasDesdeFRF = new JTable(modelo_tabla_dias_desde_frf) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false,
					false, false, false,false, false,
					false, false,false,
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_tabla_dias_desde_frf = new TableRowSorter<TableModel>(modelo_tabla_dias_desde_frf);
		tablaDiasDesdeFRF.setRowSorter(ordenador_tabla_dias_desde_frf);
		//
		tablaDiasDesdeFRF.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tablaDiasDesdeFRF.getColumnCount(); i++) {
			tablaDiasDesdeFRF.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_dias_desde_frf.elementAt(i));
			tablaDiasDesdeFRF.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_dias_desde_frf.elementAt(i));
		}
		tablaDiasDesdeFRF.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//se crea instancia a clase FormatoTable y se indica columna patron
        FormatoTablaDiasDesdeFRF fr = new FormatoTablaDiasDesdeFRF(10);
        tablaDiasDesdeFRF.setDefaultRenderer (Object.class, fr );
        pnDiasDesdeFRecepcionFabirca.setLayout(null);
		
        scrollPane_dias_trascurridos_desde_frf= new JScrollPane(tablaDiasDesdeFRF);
        scrollPane_dias_trascurridos_desde_frf.setBounds(0, 200, 1230, 400);
        scrollPane_dias_trascurridos_desde_frf.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_dias_trascurridos_desde_frf.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnDiasDesdeFRecepcionFabirca.add(scrollPane_dias_trascurridos_desde_frf);
		
		tablaDiasDesdeFRF.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				
	
		pnDiasDesdeFRecepcionFabricaFTurno = new JPanel();
		control.addTab("DIAS DESDE RECEPCION DE FABRICA Y  FECHA TURNO", null, pnDiasDesdeFRecepcionFabricaFTurno, null);
		pnDiasDesdeFRecepcionFabricaFTurno.setLayout(null);
		
		//tabla dias desde frf a fturno
		modelo_tabla_dias_desde_frf_fturno = new DefaultTableModel(datosTabla_dias_desde_frf_fturno, nombreColumnas_tabla_dias_desde_frf_fturno);
		tablaDiasDesdeFRFaFTurno = new JTable(modelo_tabla_dias_desde_frf_fturno) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false,
					false, false, false,false, false,
					false, false,false,false,false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_tabla_dias_desde_frf_fturno = new TableRowSorter<TableModel>(modelo_tabla_dias_desde_frf_fturno);
		tablaDiasDesdeFRFaFTurno.setRowSorter(ordenador_tabla_dias_desde_frf_fturno);
		//
		tablaDiasDesdeFRFaFTurno.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tablaDiasDesdeFRFaFTurno.getColumnCount(); i++) {
			tablaDiasDesdeFRFaFTurno.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_dias_desde_frf_fturno.elementAt(i));
			tablaDiasDesdeFRFaFTurno.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_dias_desde_frf_fturno.elementAt(i));
		}
		tablaDiasDesdeFRFaFTurno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//se crea instancia a clase FormatoTable y se indica columna patron
		FormatoTablaDiasDesdeFTrunoFCierre frfft = new FormatoTablaDiasDesdeFTrunoFCierre(11);
		tablaDiasDesdeFRFaFTurno.setDefaultRenderer (Object.class, frfft );
		
        scrollPane_dias_transcurridos_desde_frf_fturno= new JScrollPane(tablaDiasDesdeFRFaFTurno);
    	scrollPane_dias_transcurridos_desde_frf_fturno.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_dias_transcurridos_desde_frf_fturno.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_dias_transcurridos_desde_frf_fturno.setBounds(0, 200, 1230, 400);
		pnDiasDesdeFRecepcionFabricaFTurno.add(scrollPane_dias_transcurridos_desde_frf_fturno);
		
		tablaDiasDesdeFRFaFTurno.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//
		
		pnDiasDesdeFCierreFTurno = new JPanel();
		control.addTab("DIAS DESDE FECHA CIERRE ORDEN Y FECHA TURNO", null, pnDiasDesdeFCierreFTurno, null);
		pnDiasDesdeFCierreFTurno.setLayout(null);
		
		
		//Tabla diase desde FCierre y FTurno
		
		modelo_tabla_dias_desde_fcierre_fturno = new DefaultTableModel(datosTabla_dias_desde_fcierre_fturno, nombreColumnas_tabla_dias_desde_fcierre_fturno);
		tablaDiasDesdeFCierreOTaFTurno = new JTable(modelo_tabla_dias_desde_fcierre_fturno) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false,
					false, false, false,false, false,
					false, false,false,false,false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_tabla_dias_desde_fcierre_fturno = new TableRowSorter<TableModel>(modelo_tabla_dias_desde_fcierre_fturno);
		tablaDiasDesdeFCierreOTaFTurno.setRowSorter(ordenador_tabla_dias_desde_fcierre_fturno);
		//
		tablaDiasDesdeFCierreOTaFTurno.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tablaDiasDesdeFCierreOTaFTurno.getColumnCount(); i++) {
			tablaDiasDesdeFCierreOTaFTurno.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_dias_desde_fcierre_fturno.elementAt(i));
			tablaDiasDesdeFCierreOTaFTurno.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_dias_desde_fcierre_fturno.elementAt(i));
		}
		tablaDiasDesdeFCierreOTaFTurno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//se crea instancia a clase FormatoTable y se indica columna patron
		FormatoTablaDiasDesdeFTrunoFCierre fcft = new FormatoTablaDiasDesdeFTrunoFCierre(10);
        tablaDiasDesdeFCierreOTaFTurno.setDefaultRenderer (Object.class, fcft );
		
        scrollPane_dias_trasncurridos_desde_fcierre_fturno= new JScrollPane(tablaDiasDesdeFCierreOTaFTurno);
        scrollPane_dias_trasncurridos_desde_fcierre_fturno.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_dias_trasncurridos_desde_fcierre_fturno.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        scrollPane_dias_trasncurridos_desde_fcierre_fturno.setBounds(0, 200, 1230, 400);
        pnDiasDesdeFCierreFTurno.add(scrollPane_dias_trasncurridos_desde_fcierre_fturno);
		
		tablaDiasDesdeFCierreOTaFTurno.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//		PESTAÑA "DIAS DESDE FECHA RECURSO Y FECHA CIERRE ORDEN"		//
		pnDiasDesdeFRecursoFCierreOT = new JPanel();
		control.addTab("DIAS DESDE FECHA RECURSO Y FECHA CIERRE ORDEN", null, pnDiasDesdeFRecursoFCierreOT, null);
		pnDiasDesdeFRecursoFCierreOT.setLayout(null);
		

        //////////////////////////////////////////////////////        
		//		TABLA FECHA CIERRE A FECHA RECURSO			//
        //////////////////////////////////////////////////////
		modelo_tabla_dias_desde_frecurso_fcierre = new DefaultTableModel(datosTabla_dias_desde_frecurso_fcierre, nombreColumnas_tabla_dias_desde_frecurso_fcierre);
		tablaDiasDesdeFRecursoFCierreOT = new JTable(modelo_tabla_dias_desde_frecurso_fcierre) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false,
					false, false, false,false, false,
					false, false,false,false,false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_tabla_dias_desde_frecurso_fcierre = new TableRowSorter<TableModel>(modelo_tabla_dias_desde_fcierre_fturno);
		tablaDiasDesdeFRecursoFCierreOT.setRowSorter(ordenador_tabla_dias_desde_frecurso_fcierre);
		//
		tablaDiasDesdeFRecursoFCierreOT.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tablaDiasDesdeFRecursoFCierreOT.getColumnCount(); i++) {
			tablaDiasDesdeFRecursoFCierreOT.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_dias_desde_frecurso_fcierre.elementAt(i));
			tablaDiasDesdeFRecursoFCierreOT.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_dias_desde_frecurso_fcierre.elementAt(i));
		}
		tablaDiasDesdeFRecursoFCierreOT.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//se crea instancia a clase FormatoTable y se indica columna patron
		FormatoTablaDiasDesdeFTrunoFCierre frfc = new FormatoTablaDiasDesdeFTrunoFCierre(10);
		tablaDiasDesdeFRecursoFCierreOT.setDefaultRenderer (Object.class, frfc );
		
		scrollPane_dias_desde_frecurso_fcierre= new JScrollPane(tablaDiasDesdeFRecursoFCierreOT);
		scrollPane_dias_desde_frecurso_fcierre.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_dias_desde_frecurso_fcierre.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		scrollPane_dias_desde_frecurso_fcierre.setBounds(0, 200, 1230, 400);
		pnDiasDesdeFRecursoFCierreOT.add(scrollPane_dias_desde_frecurso_fcierre);
		
        tablaDiasDesdeFRecursoFCierreOT.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
       
        //		PESTAÑA "DIAS DESDE FECHA RECLAMO Y FECHA DEVOLUCION"		//
        
        pnDiasDesdeFReclamoFDevolucion = new JPanel();
        pnDiasDesdeFReclamoFDevolucion.setLayout(null);
        control.addTab("DIAS DESDE FECHA RECLAMO Y FECHA DEVOLUCION", null, pnDiasDesdeFReclamoFDevolucion, null);
        //////////////////////////////////////////////////////        
		//		TABLA FECHA RECLAMOS A FECHA DEVOLUCION		//
        //////////////////////////////////////////////////////
		modelo_tabla_dias_desde_freclamo_fdevolucion = new DefaultTableModel(datosTabla_dias_desde_freclamo_fdevolucion, nombreColumnas_tabla_dias_desde_freclamo_fdevolucion);
		tablaDiasDesdeFReclamoFDevolucion = new JTable(modelo_tabla_dias_desde_freclamo_fdevolucion) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false,
					false, false, false,false, false,
					false, false,false,false,false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_tabla_dias_desde_freclamo_fdevolucion = new TableRowSorter<TableModel>(modelo_tabla_dias_desde_freclamo_fdevolucion);
		tablaDiasDesdeFReclamoFDevolucion.setRowSorter(ordenador_tabla_dias_desde_freclamo_fdevolucion);
		//
		tablaDiasDesdeFReclamoFDevolucion.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tablaDiasDesdeFReclamoFDevolucion.getColumnCount(); i++) {
			tablaDiasDesdeFReclamoFDevolucion.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_dias_desde_freclamo_fdevolucion.elementAt(i));
			tablaDiasDesdeFReclamoFDevolucion.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_dias_desde_freclamo_fdevolucion.elementAt(i));
		}
		tablaDiasDesdeFReclamoFDevolucion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//se crea instancia a clase FormatoTable y se indica columna patron
		FormatoTablaDiasDesdeFTrunoFCierre frfd = new FormatoTablaDiasDesdeFTrunoFCierre(11);
		tablaDiasDesdeFReclamoFDevolucion.setDefaultRenderer (Object.class, frfd );
		
		scrollPane_dias_desde_freclamo_fdevolucion= new JScrollPane(tablaDiasDesdeFReclamoFDevolucion);
		scrollPane_dias_desde_freclamo_fdevolucion.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_dias_desde_freclamo_fdevolucion.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_dias_desde_freclamo_fdevolucion.setBounds(0, 200, 1230, 400);
        pnDiasDesdeFReclamoFDevolucion.add(scrollPane_dias_desde_freclamo_fdevolucion);
        
        tablaDiasDesdeFReclamoFDevolucion.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//		FIN		//

        //		PESTAÑA "RECLAMOS - TURNOS"		//
        pnReclamos_Turnos = new JPanel();
        control.addTab("RECLAMOS - TURNOS", null, pnReclamos_Turnos, null);
        pnReclamos_Turnos.setLayout(null);
        
        JPanel pnFiltrosReclamosTurnos = new JPanel();
        pnFiltrosReclamosTurnos.setBounds(10, 0, 868, 186);
        pnReclamos_Turnos.add(pnFiltrosReclamosTurnos);
        pnFiltrosReclamosTurnos.setLayout(null);
        
        rB_Intervalo_FReclamoTurno = new JRadioButton("Intervalo de Fechas");
        rB_Intervalo_FReclamoTurno.setBounds(6, 11, 150, 25);
        pnFiltrosReclamosTurnos.add(rB_Intervalo_FReclamoTurno);
        
        rB_Hoy_FReclamoTurno = new JRadioButton("Hoy");
        rB_Hoy_FReclamoTurno.setBounds(6, 41, 150, 25);
        pnFiltrosReclamosTurnos.add(rB_Hoy_FReclamoTurno);
        
        rB_USemana_FReclamoTurno = new JRadioButton("Ultima Semana");
        rB_USemana_FReclamoTurno.setBounds(6, 71, 150, 25);
        pnFiltrosReclamosTurnos.add(rB_USemana_FReclamoTurno);
        
        rB_UMes_FReclamoTurno = new JRadioButton("Ultimo Mes");
        rB_UMes_FReclamoTurno.setBounds(6, 101, 150, 25);
        pnFiltrosReclamosTurnos.add(rB_UMes_FReclamoTurno);
        
        rB_MesAnterior_FReclamoTurno = new JRadioButton("Mes Anterior");
        rB_MesAnterior_FReclamoTurno.setBounds(6, 131, 150, 25);
        pnFiltrosReclamosTurnos.add(rB_MesAnterior_FReclamoTurno);
        
        rB_UAnio_FReclamoTurno = new JRadioButton("Ultimo A\u00F1o");
        rB_UAnio_FReclamoTurno.setBounds(6, 161, 150, 25);
        pnFiltrosReclamosTurnos.add(rB_UAnio_FReclamoTurno);
        
        JLabel label = new JLabel("Fecha Inicio");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setEnabled(false);
        label.setBounds(161, 11, 120, 25);
        pnFiltrosReclamosTurnos.add(label);
        
        dC_FReclamoTurno_INICIO = new JDateChooser();
        dC_FReclamoTurno_INICIO.setEnabled(false);
        dC_FReclamoTurno_INICIO.setBounds(291, 11, 150, 25);
        pnFiltrosReclamosTurnos.add(dC_FReclamoTurno_INICIO);
        
        JLabel label_1 = new JLabel("Fecha Fin");
        label_1.setHorizontalAlignment(SwingConstants.CENTER);
        label_1.setEnabled(false);
        label_1.setBounds(461, 11, 120, 25);
        pnFiltrosReclamosTurnos.add(label_1);
        
        dC_FReclamoTruno_FIN = new JDateChooser();
        dC_FReclamoTruno_FIN.setEnabled(false);
        dC_FReclamoTruno_FIN.setBounds(591, 11, 150, 25);
        pnFiltrosReclamosTurnos.add(dC_FReclamoTruno_FIN);
        
        btnFiltrarReclamo_Turno = new JButton("Filtrar");
        btnFiltrarReclamo_Turno.setEnabled(false);
        btnFiltrarReclamo_Turno.setBounds(751, 12, 110, 25);
        pnFiltrosReclamosTurnos.add(btnFiltrarReclamo_Turno);
        
        //////////////////////////////////////////////////////        
		//		TABLA TURNOS - RECLAMOS	(RECLAMOS)			//
        //////////////////////////////////////////////////////
        modelo_tabla_reclamos_turno_Reclamos = new DefaultTableModel(datos_tabla_reclamos_turno_Reclamos , nombreColumnas_tabla_reclamos_turno_Reclamos );
        tabla_reclamos_turno_Reclamos = new JTable(modelo_tabla_reclamos_turno_Reclamos) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false,
					false, false, false,false, false,
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_tabla_reclamos_turno_Reclamos = new TableRowSorter<TableModel>(modelo_tabla_reclamos_turno_Reclamos);
		tabla_reclamos_turno_Reclamos.setRowSorter(ordenador_tabla_reclamos_turno_Reclamos);
		//
		tabla_reclamos_turno_Reclamos.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tabla_reclamos_turno_Reclamos.getColumnCount(); i++) {
			tabla_reclamos_turno_Reclamos.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_reclamos_turno_Reclamos.elementAt(i));
			tabla_reclamos_turno_Reclamos.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_reclamos_turno_Reclamos.elementAt(i));
		}
		tabla_reclamos_turno_Reclamos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane_tabla_reclamos_turno_Reclamos= new JScrollPane(tabla_reclamos_turno_Reclamos);
		scrollPane_tabla_reclamos_turno_Reclamos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_tabla_reclamos_turno_Reclamos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane_tabla_reclamos_turno_Reclamos.setBounds(10, 225, 1200, 170);
        pnReclamos_Turnos.add(scrollPane_tabla_reclamos_turno_Reclamos);	
        tabla_reclamos_turno_Reclamos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //////////////////////////////////////////////////////        
		//		TABLA TURNOS - RECLAMOS	(TURNOS)			//
        //////////////////////////////////////////////////////
		modelo_tabla_reclamos_turno_Turno = new DefaultTableModel(datos_tabla_reclamos_turno_Turno , nombreColumnas_tabla_reclamos_turno_Turno );
        tabla_reclamos_turno_Turnos = new JTable(modelo_tabla_reclamos_turno_Turno) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false,
					false, false, false,false, false,
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_tabla_reclamos_turno_Turno = new TableRowSorter<TableModel>(modelo_tabla_reclamos_turno_Turno);
		tabla_reclamos_turno_Turnos.setRowSorter(ordenador_tabla_reclamos_turno_Turno);
		//
		tabla_reclamos_turno_Turnos.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tabla_reclamos_turno_Turnos.getColumnCount(); i++) {
			tabla_reclamos_turno_Turnos.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_reclamos_turno_Turno.elementAt(i));
			tabla_reclamos_turno_Turnos.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_reclamos_turno_Turno.elementAt(i));
		}
		tabla_reclamos_turno_Turnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane_tabla_reclamos_turnos_Turno= new JScrollPane(tabla_reclamos_turno_Turnos);
		scrollPane_tabla_reclamos_turnos_Turno.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_tabla_reclamos_turnos_Turno.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane_tabla_reclamos_turnos_Turno.setBounds(10, 430, 1200, 170);
        pnReclamos_Turnos.add(scrollPane_tabla_reclamos_turnos_Turno);
        tabla_reclamos_turno_Turnos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);      
        //
        JLabel lblReclamos_Turnos = new JLabel("RECLAMOS / TURNOS");
        lblReclamos_Turnos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblReclamos_Turnos.setHorizontalAlignment(SwingConstants.CENTER);
        lblReclamos_Turnos.setBounds(888, 11, 200, 25);
        pnReclamos_Turnos.add(lblReclamos_Turnos);
        
        lblReclamoTurnos = new JLabel("");
        lblReclamoTurnos.setHorizontalAlignment(SwingConstants.CENTER);
		if(numero_reclamos==0 && numero_turnos==0){
			lblReclamoTurnos.setText("N/A");
	        lblReclamoTurnos.setBackground(Color.WHITE);
		}else{
			lblReclamoTurnos.setText(String.valueOf(numero_reclamos/numero_turnos));
			if((numero_reclamos/numero_turnos)<= 1){
				lblReclamoTurnos.setBackground(Color.GREEN);

			}else{
				if((numero_reclamos/numero_turnos)> 2){
					lblReclamoTurnos.setBackground(Color.RED);
				}else{
					lblReclamoTurnos.setBackground(Color.YELLOW);
				}
			}
		}
        lblReclamoTurnos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblReclamoTurnos.setBounds(1110, 11, 100, 25);
        pnReclamos_Turnos.add(lblReclamoTurnos);
        
        JLabel lblReclamosConTurno = new JLabel("NUMERO DE RECLAMOS CON TURNO");
        lblReclamosConTurno.setHorizontalAlignment(SwingConstants.CENTER);
        lblReclamosConTurno.setBounds(10, 400, 240, 25);
        pnReclamos_Turnos.add(lblReclamosConTurno);
        
        lblNum_ReclmaosConTurno = new JLabel("");
        lblNum_ReclmaosConTurno.setText(String.valueOf(numero_turnos));
        lblNum_ReclmaosConTurno.setHorizontalAlignment(SwingConstants.CENTER);
        lblNum_ReclmaosConTurno.setBounds(250, 400, 46, 25);
        pnReclamos_Turnos.add(lblNum_ReclmaosConTurno);
        
        lblNum_ReclamosSinTurno = new JLabel("");
        lblNum_ReclamosSinTurno.setText(String.valueOf(numero_reclamos));
        lblNum_ReclamosSinTurno.setHorizontalAlignment(SwingConstants.CENTER);
        lblNum_ReclamosSinTurno.setBounds(250, 195, 46, 25);
        pnReclamos_Turnos.add(lblNum_ReclamosSinTurno);
        
        JLabel lblNumeroDeReclamos = new JLabel("NUMERO DE RECLAMOS");
        lblNumeroDeReclamos.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumeroDeReclamos.setBounds(10, 195, 230, 25);
        pnReclamos_Turnos.add(lblNumeroDeReclamos);
        
        
        //		PESTAÑA "PIEZAS LLEGADAS - PIEZAS DEVUELTAS"		//        
        
        pnPiezasLlegadas_PiezasDevueltas = new JPanel();
        pnPiezasLlegadas_PiezasDevueltas.setLayout(null);
        control.addTab("PIEZAS LLEGADAS - PIEZAS DEVUELTAS", null, pnPiezasLlegadas_PiezasDevueltas, null);
        
        panel_filtros = new JPanel();
        panel_filtros.setLayout(null);
        panel_filtros.setBounds(10, 0, 746, 186);
        pnPiezasLlegadas_PiezasDevueltas.add(panel_filtros);
        
        rB_Intervalo_PLlegadasPDevueltas = new JRadioButton("Intervalo de Fechas");
        rB_Intervalo_PLlegadasPDevueltas.setBounds(6, 11, 150, 25);
        panel_filtros.add(rB_Intervalo_PLlegadasPDevueltas);
        
        rB_Hoy_PLlegadasPDevueltas = new JRadioButton("Hoy");
        rB_Hoy_PLlegadasPDevueltas.setBounds(6, 41, 150, 25);
        panel_filtros.add(rB_Hoy_PLlegadasPDevueltas);
        
        rB_USemana_PLlegadasPDevueltas = new JRadioButton("Ultima Semana");
        rB_USemana_PLlegadasPDevueltas.setBounds(6, 71, 150, 25);
        panel_filtros.add(rB_USemana_PLlegadasPDevueltas);
        
        rB_UMes_PLlegadasPDevueltas = new JRadioButton("Ultimo Mes");
        rB_UMes_PLlegadasPDevueltas.setBounds(6, 101, 150, 25);
        panel_filtros.add(rB_UMes_PLlegadasPDevueltas);
        
        rB_MPasado_PLlegadasPDevueltas = new JRadioButton("Mes Anterior");
        rB_MPasado_PLlegadasPDevueltas.setBounds(6, 131, 150, 25);
        panel_filtros.add(rB_MPasado_PLlegadasPDevueltas);
        
        rB_UAnio_PLlegadasPDevueltas = new JRadioButton("Ultimo A\u00F1o");
        rB_UAnio_PLlegadasPDevueltas.setBounds(6, 161, 150, 25);
        panel_filtros.add(rB_UAnio_PLlegadasPDevueltas);
        
        JLabel label_12 = new JLabel("Fecha Inicio");
        label_12.setHorizontalAlignment(SwingConstants.CENTER);
        label_12.setEnabled(false);
        label_12.setBounds(161, 11, 120, 25);
        panel_filtros.add(label_12);
        
        dC_FLlegadaFDevueltas_Inicio = new JDateChooser();
        dC_FLlegadaFDevueltas_Inicio.setEnabled(false);
        dC_FLlegadaFDevueltas_Inicio.setBounds(291, 11, 150, 25);
        panel_filtros.add(dC_FLlegadaFDevueltas_Inicio);
        
        JLabel label_13 = new JLabel("Fecha Fin");
        label_13.setHorizontalAlignment(SwingConstants.CENTER);
        label_13.setEnabled(false);
        label_13.setBounds(461, 11, 120, 25);
        panel_filtros.add(label_13);
        
        dC_FLlegadaFDevueltas_Fin = new JDateChooser();
        dC_FLlegadaFDevueltas_Fin.setEnabled(false);
        dC_FLlegadaFDevueltas_Fin.setBounds(591, 11, 150, 25);
        panel_filtros.add(dC_FLlegadaFDevueltas_Fin);
        
        //////////////////////////////////////////////////////        
		//TABLA PIEZAS LLEGADAS PIEZAS DEVUELTAS (LLEGADAS)	//
        //////////////////////////////////////////////////////
        modelo_tabla_Pllegadas_PDevuletas_LLegadas = new DefaultTableModel(datos_tabla_Pllegadas_PDevuletas_LLegadas , nombreColumnas_tabla_Pllegadas_PDevuletas_LLegadas );
        tabla_Pllegadas_PDevuletas_LLegadas = new JTable(modelo_tabla_Pllegadas_PDevuletas_LLegadas) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false,
					false, false, false,false, false,
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_tabla_Pllegadas_PDevuletas_LLegadas = new TableRowSorter<TableModel>(modelo_tabla_Pllegadas_PDevuletas_LLegadas);
		tabla_Pllegadas_PDevuletas_LLegadas.setRowSorter(ordenador_tabla_Pllegadas_PDevuletas_LLegadas);
		//
		tabla_Pllegadas_PDevuletas_LLegadas.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tabla_Pllegadas_PDevuletas_LLegadas.getColumnCount(); i++) {
			tabla_Pllegadas_PDevuletas_LLegadas.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_Pllegadas_PDevuletas_LLegadas.elementAt(i));
			tabla_Pllegadas_PDevuletas_LLegadas.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_Pllegadas_PDevuletas_LLegadas.elementAt(i));
		}
		tabla_Pllegadas_PDevuletas_LLegadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane_tabla_Pllegadas_PDevuletas_LLegadas= new JScrollPane(tabla_Pllegadas_PDevuletas_LLegadas);
        scrollPane_tabla_Pllegadas_PDevuletas_LLegadas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_tabla_Pllegadas_PDevuletas_LLegadas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane_tabla_Pllegadas_PDevuletas_LLegadas.setBounds(10, 225, 1200, 170);
        pnPiezasLlegadas_PiezasDevueltas.add(scrollPane_tabla_Pllegadas_PDevuletas_LLegadas);	
        tabla_Pllegadas_PDevuletas_LLegadas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //////////////////////////////////////////////////////        
		//TABLA PIEZAS LLEGADAS PIEZAS DEVUELTAS (DEVUELTAS)//
        //////////////////////////////////////////////////////
		modelo_tabla_Pllegadas_PDevuletas_Devueltas = new DefaultTableModel(datos_tabla_Pllegadas_PDevuletas_Devueltas , nombreColumnas_tabla_Pllegadas_PDevuletas_Devueltas );
		tabla_Pllegadas_PDevuletas_Devueltas = new JTable(modelo_tabla_Pllegadas_PDevuletas_Devueltas) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false,
					false, false, false,false, false,
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_tabla_Pllegadas_PDevuletas_Devueltas = new TableRowSorter<TableModel>(modelo_tabla_Pllegadas_PDevuletas_Devueltas);
		tabla_Pllegadas_PDevuletas_Devueltas.setRowSorter(ordenador_tabla_Pllegadas_PDevuletas_Devueltas);
		//
		tabla_Pllegadas_PDevuletas_Devueltas.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tabla_Pllegadas_PDevuletas_Devueltas.getColumnCount(); i++) {
			tabla_Pllegadas_PDevuletas_Devueltas.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_Pllegadas_PDevuletas_Devueltas.elementAt(i));
			tabla_Pllegadas_PDevuletas_Devueltas.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_Pllegadas_PDevuletas_Devueltas.elementAt(i));
		}
		tabla_Pllegadas_PDevuletas_Devueltas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane_tabla_Pllegadas_PDevuletas_Devueltas= new JScrollPane(tabla_Pllegadas_PDevuletas_Devueltas);
        scrollPane_tabla_Pllegadas_PDevuletas_Devueltas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_tabla_Pllegadas_PDevuletas_Devueltas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane_tabla_Pllegadas_PDevuletas_Devueltas.setBounds(10, 430, 1200, 170);
        pnPiezasLlegadas_PiezasDevueltas.add(scrollPane_tabla_Pllegadas_PDevuletas_Devueltas);
        tabla_Pllegadas_PDevuletas_Devueltas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
          
        JLabel lblPiezasLlegadas = new JLabel("PIEZAS DEVUELTAS / PIEZAS LLEGADAS");
        lblPiezasLlegadas.setHorizontalAlignment(SwingConstants.CENTER);
        lblPiezasLlegadas.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblPiezasLlegadas.setBounds(766, 11, 200, 25);
        pnPiezasLlegadas_PiezasDevueltas.add(lblPiezasLlegadas);
        
        lblLlegadaDevueltas = new JLabel("");
		if(numero_PiezasDevueltas==0 && numero_PiezasLlegadas==0){
			lblLlegadaDevueltas.setText("N/A");
			lblLlegadaDevueltas.setBackground(Color.WHITE);
		}else{
			lblLlegadaDevueltas.setText(String.valueOf(numero_PiezasDevueltas / numero_PiezasLlegadas));
			if((numero_PiezasDevueltas/numero_PiezasLlegadas) <= 0.90){
				lblLlegadaDevueltas.setBackground(Color.RED);

			}else{
				if((numero_PiezasDevueltas/numero_PiezasLlegadas)>0.90 && (numero_PiezasDevueltas/numero_PiezasLlegadas)<1.10){
					lblLlegadaDevueltas.setBackground(Color.GREEN);
				}else{
					lblLlegadaDevueltas.setBackground(Color.YELLOW);
				}
			}
		}
        lblLlegadaDevueltas.setHorizontalAlignment(SwingConstants.CENTER);
        lblLlegadaDevueltas.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblLlegadaDevueltas.setBounds(988, 11, 100, 25);
        pnPiezasLlegadas_PiezasDevueltas.add(lblLlegadaDevueltas);
        
        JLabel lblNumeroDePiezas_1 = new JLabel("NUMERO DE  PIEZAS DEVUELTAS");
        lblNumeroDePiezas_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumeroDePiezas_1.setBounds(10, 400, 200, 25);
        pnPiezasLlegadas_PiezasDevueltas.add(lblNumeroDePiezas_1);
        
        lblNum_PDevueltas = new JLabel("");
        lblNum_PDevueltas.setText(String.valueOf(numero_PiezasDevueltas));
        lblNum_PDevueltas.setHorizontalAlignment(SwingConstants.CENTER);
        lblNum_PDevueltas.setBounds(214, 400, 46, 25);
        pnPiezasLlegadas_PiezasDevueltas.add(lblNum_PDevueltas);
        
        lblNumPLlegadas = new JLabel("");
        lblNumPLlegadas.setText(String.valueOf(numero_PiezasLlegadas));
        lblNumPLlegadas.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumPLlegadas.setBounds(214, 195, 46, 25);
        pnPiezasLlegadas_PiezasDevueltas.add(lblNumPLlegadas);
        
        JLabel lblNumeroDePiezas = new JLabel("NUMERO DE PIEZAS LLEGADAS");
        lblNumeroDePiezas.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumeroDePiezas.setBounds(10, 195, 200, 25);
        pnPiezasLlegadas_PiezasDevueltas.add(lblNumeroDePiezas);
        
        lblPiezasLLegadas_PiezasDevueltas = new JLabel("");
        lblPiezasLLegadas_PiezasDevueltas.setText(String.valueOf(numero_PiezasDevueltas - numero_PiezasLlegadas));
		if((numero_PiezasLlegadas - numero_PiezasDevueltas)> 5){
			lblPiezasLLegadas_PiezasDevueltas.setBackground(Color.RED);
		}else{
			if((numero_PiezasLlegadas - numero_PiezasDevueltas)<= 0){
				lblPiezasLLegadas_PiezasDevueltas.setBackground(Color.GREEN);
			}else{
				lblPiezasLLegadas_PiezasDevueltas.setBackground(Color.YELLOW);
			}
		}
        lblPiezasLLegadas_PiezasDevueltas.setHorizontalAlignment(SwingConstants.CENTER);

        lblPiezasLLegadas_PiezasDevueltas.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblPiezasLLegadas_PiezasDevueltas.setBounds(988, 49, 100, 25);
        pnPiezasLlegadas_PiezasDevueltas.add(lblPiezasLLegadas_PiezasDevueltas);
               
        JLabel lblPiezasLlegadas_1 = new JLabel("PIEZAS LLEGADAS - PIEZAS DEVUELTAS");
        lblPiezasLlegadas_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblPiezasLlegadas_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblPiezasLlegadas_1.setBounds(766, 49, 200, 25);
        pnPiezasLlegadas_PiezasDevueltas.add(lblPiezasLlegadas_1);
        
        //		PESTAÑA "MANO DE OBRA"		//    
        pnManoObra = new JPanel();
        control.addTab("MANO DE OBRA", null, pnManoObra, null);
        pnManoObra.setLayout(null);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 746, 186);
        pnManoObra.add(panel);
        
        rB_Intervalo_MObra = new JRadioButton("Intervalo de Fechas");
        rB_Intervalo_MObra.setBounds(6, 11, 150, 25);
        panel.add(rB_Intervalo_MObra);
        
        rB_Hoy_ManoObra = new JRadioButton("Hoy");
        rB_Hoy_ManoObra.setBounds(6, 41, 150, 25);
        panel.add(rB_Hoy_ManoObra);
        
        rB_Usemana_ManoObra = new JRadioButton("Ultima Semana");
        rB_Usemana_ManoObra.setBounds(6, 71, 150, 25);
        panel.add(rB_Usemana_ManoObra);
        
        rB_UMes_ManoObra = new JRadioButton("Ultimo Mes");
        rB_UMes_ManoObra.setBounds(6, 101, 150, 25);
        panel.add(rB_UMes_ManoObra);
        
        rB_MAnterior_ManoObra = new JRadioButton("Mes Anterior");
        rB_MAnterior_ManoObra.setBounds(6, 131, 150, 25);
        panel.add(rB_MAnterior_ManoObra);
        
        rB_UAnio_ManoObra = new JRadioButton("Ultimo A\u00F1o");
        rB_UAnio_ManoObra.setBounds(6, 161, 150, 25);
        panel.add(rB_UAnio_ManoObra);
        
        JLabel label_14 = new JLabel("Fecha Inicio");
        label_14.setHorizontalAlignment(SwingConstants.CENTER);
        label_14.setEnabled(false);
        label_14.setBounds(161, 11, 120, 25);
        panel.add(label_14);
        
        dC_ManoObra_Inicio = new JDateChooser();
        dC_ManoObra_Inicio.setEnabled(false);
        dC_ManoObra_Inicio.setBounds(291, 11, 150, 25);
        panel.add(dC_ManoObra_Inicio);
        
        JLabel label_15 = new JLabel("Fecha Fin");
        label_15.setHorizontalAlignment(SwingConstants.CENTER);
        label_15.setEnabled(false);
        label_15.setBounds(461, 11, 120, 25);
        panel.add(label_15);
        
        dc_ManoObra_Fin = new JDateChooser();
        dc_ManoObra_Fin.setEnabled(false);
        dc_ManoObra_Fin.setBounds(591, 11, 150, 25);
        panel.add(dc_ManoObra_Fin);
        
        //////////////////////////////////////////////////////        
		//				TBLA MANO OBRA						//
        //////////////////////////////////////////////////////
		modelo_tabla_mano_obra = new DefaultTableModel(datos_tabla_mano_obra , nombreColumnas_tabla_mano_obra );
		tabla_mano_obra = new JTable(modelo_tabla_mano_obra) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false,
					false, false, false,false, false,
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_tabla_mano_obra = new TableRowSorter<TableModel>(modelo_tabla_mano_obra);
		tabla_mano_obra.setRowSorter(ordenador_tabla_mano_obra);
		//
		tabla_mano_obra.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tabla_mano_obra.getColumnCount(); i++) {
			tabla_mano_obra.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_mano_obra.elementAt(i));
			tabla_mano_obra.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_mano_obra.elementAt(i));
		}
		tabla_mano_obra.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane_mano_obra= new JScrollPane(tabla_mano_obra);
        scrollPane_mano_obra.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_mano_obra.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane_mano_obra.setBounds(0, 200, 1230, 400);
        pnManoObra.add(scrollPane_mano_obra);
        tabla_mano_obra.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        lblValorTotalDe = new JLabel("VALOR TOTAL DE MANO DE OBRA");
        lblValorTotalDe.setHorizontalAlignment(SwingConstants.CENTER);
        lblValorTotalDe.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblValorTotalDe.setBounds(756, 11, 299, 25);
        pnManoObra.add(lblValorTotalDe);
        
        lblHorasTotalesDe = new JLabel("HORAS TOTALES DE MANO DE OBRA");
        lblHorasTotalesDe.setHorizontalAlignment(SwingConstants.CENTER);
        lblHorasTotalesDe.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblHorasTotalesDe.setBounds(756, 49, 299, 25);
        pnManoObra.add(lblHorasTotalesDe);
        
        lbl_HsTotalesMO = new JLabel("");
        lbl_HsTotalesMO.setText(String.valueOf(hs_mano_obra)+"HS");
        lbl_HsTotalesMO.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_HsTotalesMO.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lbl_HsTotalesMO.setBounds(1077, 49, 100, 25);
        pnManoObra.add(lbl_HsTotalesMO);
        
        lbl_ValorTotalMO = new JLabel("");
        lbl_ValorTotalMO.setText("$"+String.valueOf(preico_mano_obra));
        lbl_ValorTotalMO.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_ValorTotalMO.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lbl_ValorTotalMO.setBounds(1077, 11, 100, 25);
        pnManoObra.add(lbl_ValorTotalMO);
        
        //		PESTAÑA "RECURSO - CIERRE ORDEN"		//    

        pnRecursoCierre = new JPanel();
        control.addTab("RECURSO - CIERRE ORDEN", null, pnRecursoCierre, null);
        pnRecursoCierre.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 1229, 193);
        pnRecursoCierre.add(panel_1);
        panel_1.setLayout(null);
        
        rb_Intervalo_RecursoCierre = new JRadioButton("Intervalo de Fechas");
        rb_Intervalo_RecursoCierre.setBounds(6, 11, 150, 25);
        panel_1.add(rb_Intervalo_RecursoCierre);
        
        rb_Hoy_RecursoCierre = new JRadioButton("Hoy");
        rb_Hoy_RecursoCierre.setBounds(6, 41, 150, 25);
        panel_1.add(rb_Hoy_RecursoCierre);
        
        rb_USemana_RecursoCierre = new JRadioButton("Ultima Semana");
        rb_USemana_RecursoCierre.setBounds(6, 71, 150, 25);
        panel_1.add(rb_USemana_RecursoCierre);
        
        rb_UMes_RecursoCierre = new JRadioButton("Ultimo Mes");
        rb_UMes_RecursoCierre.setBounds(6, 101, 150, 25);
        panel_1.add(rb_UMes_RecursoCierre);
        
        rb_MAnterior_RecursoCierre = new JRadioButton("Mes Anterior");
        rb_MAnterior_RecursoCierre.setBounds(6, 131, 150, 25);
        panel_1.add(rb_MAnterior_RecursoCierre);
        
        rb_UAnio_RecursoCierre = new JRadioButton("Ultimo A\u00F1o");
        rb_UAnio_RecursoCierre.setBounds(6, 161, 150, 25);
        panel_1.add(rb_UAnio_RecursoCierre);
        
        JLabel label_16 = new JLabel("Fecha Inicio");
        label_16.setHorizontalAlignment(SwingConstants.CENTER);
        label_16.setEnabled(false);
        label_16.setBounds(161, 11, 120, 25);
        panel_1.add(label_16);
        
        dc_Inicio_RecursoCierre = new JDateChooser();
        dc_Inicio_RecursoCierre.setEnabled(false);
        dc_Inicio_RecursoCierre.setBounds(291, 11, 150, 25);
        panel_1.add(dc_Inicio_RecursoCierre);
        
        JLabel label_17 = new JLabel("Fecha Fin");
        label_17.setHorizontalAlignment(SwingConstants.CENTER);
        label_17.setEnabled(false);
        label_17.setBounds(461, 11, 120, 25);
        panel_1.add(label_17);
        
        dc_Fin_RecursoCierre = new JDateChooser();
        dc_Fin_RecursoCierre.setEnabled(false);
        dc_Fin_RecursoCierre.setBounds(591, 11, 150, 25);
        panel_1.add(dc_Fin_RecursoCierre);
        
        JLabel lblPromediofrecurso = new JLabel("PROMEDIO (F.RECURSO - F.CIERRE ORDEN) / #CASOS");
        lblPromediofrecurso.setHorizontalAlignment(SwingConstants.CENTER);
        lblPromediofrecurso.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblPromediofrecurso.setBounds(778, 22, 299, 25);
        panel_1.add(lblPromediofrecurso);
        
    	JLabel lbl_PromFRecurso_FCierre = new JLabel("");
        if (sum_frecurso_fcierre!=0 && N_casos!=0){
        	lbl_PromFRecurso_FCierre.setText(String.valueOf(sum_frecurso_fcierre / N_casos));
        }else{
        	lbl_PromFRecurso_FCierre.setText("N/A");
        }
        lbl_PromFRecurso_FCierre.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_PromFRecurso_FCierre.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lbl_PromFRecurso_FCierre.setBounds(1099, 22, 100, 25);
        panel_1.add(lbl_PromFRecurso_FCierre);
        
        JLabel lbl_Sum_FRecurso_FCierre = new JLabel(String.valueOf(sum_frecurso_fcierre));
        lbl_Sum_FRecurso_FCierre.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Sum_FRecurso_FCierre.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lbl_Sum_FRecurso_FCierre.setBounds(1099, 60, 100, 25);
        panel_1.add(lbl_Sum_FRecurso_FCierre);
        
        JLabel lblSumatoriaFrecurso = new JLabel("SUMATORIA F.RECURSO - F.CIERRE");
        lblSumatoriaFrecurso.setHorizontalAlignment(SwingConstants.CENTER);
        lblSumatoriaFrecurso.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblSumatoriaFrecurso.setBounds(778, 60, 299, 25);
        panel_1.add(lblSumatoriaFrecurso);
        
        JLabel lblcasos = new JLabel("#CASOS");
        lblcasos.setHorizontalAlignment(SwingConstants.CENTER);
        lblcasos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblcasos.setBounds(778, 101, 299, 25);
        panel_1.add(lblcasos);
        
        JLabel lbl_N_Casos = new JLabel(String.valueOf(N_casos));
        lbl_N_Casos.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_N_Casos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lbl_N_Casos.setBounds(1099, 101, 100, 25);
        panel_1.add(lbl_N_Casos);
        
        //////////////////////////////////////////////////////        
		//				TABLA MANO OBRA						//
        //////////////////////////////////////////////////////
        
        modelo_tabla_recurso_cierre = new DefaultTableModel(datos_tabla_recurso_cierre , nombreColumnas_tabla_recurso_cierre);
        tabla_recurso_cierre = new JTable(modelo_tabla_recurso_cierre) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false,
					false, false, false,false, false,
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_tabla_recurso_cierre = new TableRowSorter<TableModel>(modelo_tabla_recurso_cierre);
		tabla_recurso_cierre.setRowSorter(ordenador_tabla_recurso_cierre);
		//
		tabla_recurso_cierre.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tabla_recurso_cierre.getColumnCount(); i++) {
			tabla_recurso_cierre.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_recurso_cierre.elementAt(i));
			tabla_recurso_cierre.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_recurso_cierre.elementAt(i));
		}
		tabla_recurso_cierre.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane_recurso_cierre= new JScrollPane(tabla_recurso_cierre);
		scrollPane_recurso_cierre.setBounds(0, 200, 1230, 400);
        pnRecursoCierre.add(scrollPane_recurso_cierre);
        scrollPane_recurso_cierre.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_recurso_cierre.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        tabla_recurso_cierre.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		
		//			
		//PIEZAS LLEGADAS
		pnPiezaLLegadas = new JPanel();
		gestion.addTab("PIEZAS LLEGADAS", null, pnPiezaLLegadas, null);
		pnPiezaLLegadas.setLayout(null);
		
		rBItervaloPLL = new JRadioButton("Intervalo de Fechas");
		rBItervaloPLL.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
					if(rBItervaloPLL.isSelected()){
						rBMAnteriorPLL.setSelected(false);
						dC_FInicioPLL.setEnabled(true);
						dC_FFinPLL.setEnabled(true);
						rBHoyPLL.setSelected(false);
						rBUltimaSemanaPLL.setSelected(false);
						rBUltimoMesPLL.setSelected(false);
						rBUltimoAnioPLL.setSelected(false);
						
						btnFiltrar_PLL.setEnabled(true);
					}else{
						dC_FInicioPLL.setEnabled(false);
						dC_FFinPLL.setEnabled(false);
						btnFiltrar_PLL.setEnabled(false);
					}
				}
		});

		rBItervaloPLL.setBounds(5, 10, 150, 25);
		pnPiezaLLegadas.add(rBItervaloPLL);
		
		rBHoyPLL = new JRadioButton("Hoy");
		rBHoyPLL.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
					if(rBHoyPLL.isSelected()){
						rBMAnteriorPLL.setSelected(false);
						dC_FInicioPLL.setEnabled(true);
						dC_FFinPLL.setEnabled(true);
						rBItervaloPLL.setSelected(false);
						rBUltimaSemanaPLL.setSelected(false);
						rBUltimoMesPLL.setSelected(false);
						rBUltimoAnioPLL.setSelected(false);
						btnFiltrar_PLL.setEnabled(false);

						filtrarHoyPLL();
						
					}
				}
		});

		rBHoyPLL.setBounds(5, 40, 150, 25);
		pnPiezaLLegadas.add(rBHoyPLL);
		
		rBUltimaSemanaPLL = new JRadioButton("Ultima Semana");
		rBUltimaSemanaPLL.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
					if(rBUltimaSemanaPLL.isSelected()){
						rBItervaloPLL.setSelected(false);
						dC_FInicioPLL.setEnabled(false);
						dC_FFinPLL.setEnabled(false);
						rBHoyPLL.setSelected(false);
						rBUltimoMesPLL.setSelected(false);
						rBMAnteriorPLL.setSelected(false);
						rBUltimoAnioPLL.setSelected(false);
						btnFiltrar_PLL.setEnabled(false);

						filtrarUSemanaPLL();
						
					}
				}
		});
		rBUltimaSemanaPLL.setBounds(5, 70, 150, 25);
		pnPiezaLLegadas.add(rBUltimaSemanaPLL);
		
		rBUltimoMesPLL = new JRadioButton("Ultimo Mes");
		rBUltimoMesPLL.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
					if(rBUltimoMesPLL.isSelected()){
						rBItervaloPLL.setSelected(false);
						dC_FInicioPLL.setEnabled(false);
						dC_FFinPLL.setEnabled(false);
						rBHoyPLL.setSelected(false);
						rBUltimaSemanaPLL.setSelected(false);
						rBMAnteriorPLL.setSelected(false);
						rBUltimoAnioPLL.setSelected(false);
						btnFiltrar_PLL.setEnabled(false);

						filtrarUMesPLL();
					}
				}
		});
		rBUltimoMesPLL.setBounds(5, 100, 150, 25);
		pnPiezaLLegadas.add(rBUltimoMesPLL);
		
		rBMAnteriorPLL = new JRadioButton("Mes Anterior");
		rBMAnteriorPLL.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rBMAnteriorPLL.isSelected()){
					rBItervaloPLL.setSelected(false);
					dC_FInicioPLL.setEnabled(false);
					dC_FFinPLL.setEnabled(false);
					rBHoyPLL.setSelected(false);
					rBUltimaSemanaPLL.setSelected(false);
					rBUltimoMesPLL.setSelected(false);
					rBUltimoAnioPLL.setSelected(false);
					btnFiltrar_PLL.setEnabled(false);

					filtrarMesAnteriorPLL();
				}
			}
		});
		rBMAnteriorPLL.setBounds(5, 130, 150, 25);
		pnPiezaLLegadas.add(rBMAnteriorPLL);
		
		rBUltimoAnioPLL = new JRadioButton("Ultimo A\u00F1o");
		rBUltimoAnioPLL.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
					if(rBUltimoAnioPLL.isSelected()){
						rBItervaloPLL.setSelected(false);
						dC_FInicioPLL.setEnabled(false);
						dC_FFinPLL.setEnabled(false);
						rBHoyPLL.setSelected(false);
						rBUltimaSemanaPLL.setSelected(false);
						rBUltimoMesPLL.setSelected(false);
						rBMAnteriorPLL.setSelected(false);
						btnFiltrar_PLL.setEnabled(false);

						filtrarUAnioPLL();
					}
				}
		});
		rBUltimoAnioPLL.setBounds(5, 160, 150, 25);
		pnPiezaLLegadas.add(rBUltimoAnioPLL);
				
		JLabel label_2 = new JLabel("Fecha Inicio");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setEnabled(false);
		label_2.setBounds(160, 11, 120, 25);
		pnPiezaLLegadas.add(label_2);
		
		dC_FInicioPLL = new JDateChooser();
		dC_FInicioPLL.setEnabled(false);
		dC_FInicioPLL.setBounds(290, 11, 150, 25);
		pnPiezaLLegadas.add(dC_FInicioPLL);
		
		JLabel label_3 = new JLabel("Fecha Fin");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setEnabled(false);
		label_3.setBounds(460, 11, 120, 25);
		pnPiezaLLegadas.add(label_3);
		
		dC_FFinPLL = new JDateChooser();
		dC_FFinPLL.setEnabled(false);
		dC_FFinPLL.setBounds(590, 11, 150, 25);
		pnPiezaLLegadas.add(dC_FFinPLL);
		
		//Tabla piezas llegadas

		modelo_tabla_piezas_llegadas = new DefaultTableModel(datosTabla_piezas_llegadas, nombreColumnas_piezas_llegadas);
		tablaPiezas_Llegadas = new JTable(modelo_tabla_piezas_llegadas) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false,
					false, false, false,false, false,
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_tabla_piezas_llegadas = new TableRowSorter<TableModel>(modelo_tabla_piezas_llegadas);
		tablaPiezas_Llegadas.setRowSorter(ordenador_tabla_piezas_llegadas);
		//
		tablaPiezas_Llegadas.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tablaPiezas_Llegadas.getColumnCount(); i++) {
			tablaPiezas_Llegadas.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_piezas_llegadas.elementAt(i));
			tablaPiezas_Llegadas.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_piezas_llegadas.elementAt(i));
		}
		tablaPiezas_Llegadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane_piezas_llegadas= new JScrollPane(tablaPiezas_Llegadas);
		scrollPane_piezas_llegadas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_piezas_llegadas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_piezas_llegadas.setBounds(0, 200, 1230, 420);
		
		tablaPiezas_Llegadas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				
		pnPiezaLLegadas.add(scrollPane_piezas_llegadas);
		
		btnFiltrar_PLL = new JButton("Filtrar");
		btnFiltrar_PLL.setEnabled(false);
		btnFiltrar_PLL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filtrarIntervaloPLL();
			}
		});
		btnFiltrar_PLL.setBounds(750, 11, 110, 25);
		pnPiezaLLegadas.add(btnFiltrar_PLL);

		// PIEZAS DEVUELTAS
		
		pnPiezasDevueltas = new JPanel();
		gestion.addTab("PIEZAS DEVUELTAS", null, pnPiezasDevueltas, null);
		pnPiezasDevueltas.setLayout(null);
		
		dcFechaInicioPDev = new JDateChooser();
		dcFechaInicioPDev.setEnabled(false);
		dcFechaInicioPDev.setBounds(290, 10, 150, 25);
		pnPiezasDevueltas.add(dcFechaInicioPDev);
		
		JLabel lblFechaDeste = new JLabel("Fecha Inicio");
		lblFechaDeste.setEnabled(false);
		lblFechaDeste.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaDeste.setBounds(160, 10, 120, 25);
		pnPiezasDevueltas.add(lblFechaDeste);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setEnabled(false);
		lblFechaFin.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaFin.setBounds(460, 10, 120, 25);
		pnPiezasDevueltas.add(lblFechaFin);
		
		dcFechaFinPDev = new JDateChooser();
		dcFechaFinPDev.setEnabled(false);
		dcFechaFinPDev.setBounds(590, 10, 150, 25);
		pnPiezasDevueltas.add(dcFechaFinPDev);
		
		rbIntervaloPDev = new JRadioButton("Intervalo de Fechas");
		rbIntervaloPDev.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rbIntervaloPDev.isSelected()){
					dcFechaFinPDev.setEnabled(true);
					dcFechaInicioPDev.setEnabled(true);
					
					rbHoyPDev.setSelected(false);
					rbUltimaSemanaPDev.setSelected(false);
					rbUltimoMesPDev.setSelected(false);
					rbMAnteriorPDev.setSelected(false);
					rbUltimoAnioPDev.setSelected(false);
				}else{
					dcFechaFinPDev.setEnabled(false);
					dcFechaInicioPDev.setEnabled(false);
				}
			}
		});
		rbIntervaloPDev.setBounds(5, 10, 150, 25);
		pnPiezasDevueltas.add(rbIntervaloPDev);
		
		rbHoyPDev = new JRadioButton("Hoy");
		rbHoyPDev.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rbHoyPDev.isSelected()){
					rbIntervaloPDev.setSelected(false);
					dcFechaFinPDev.setEnabled(false);
					dcFechaInicioPDev.setEnabled(false);
					rbUltimaSemanaPDev.setSelected(false);
					rbUltimoMesPDev.setSelected(false);
					rbMAnteriorPDev.setSelected(false);
					rbUltimoAnioPDev.setSelected(false);
					filtrarHoyPDev();
				}
			}
		});
		rbHoyPDev.setBounds(5, 40, 150, 25);
		pnPiezasDevueltas.add(rbHoyPDev);
		
		rbUltimaSemanaPDev = new JRadioButton("Ultima Semana");
		rbUltimaSemanaPDev.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rbUltimaSemanaPDev.isSelected()){
					rbIntervaloPDev.setSelected(false);
					dcFechaFinPDev.setEnabled(false);
					dcFechaInicioPDev.setEnabled(false);
					rbHoyPDev.setSelected(false);
					rbUltimoMesPDev.setSelected(false);
					rbMAnteriorPDev.setSelected(false);
					rbUltimoAnioPDev.setSelected(false);
					filtrarUSemanaPDev();
				}
			}
		});
		rbUltimaSemanaPDev.setBounds(5, 70, 150, 25);
		pnPiezasDevueltas.add(rbUltimaSemanaPDev);
		
		rbMAnteriorPDev = new JRadioButton("Mes Anterior");
		rbMAnteriorPDev.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rbMAnteriorPDev.isSelected()){
					rbIntervaloPDev.setSelected(false);
					dcFechaFinPDev.setEnabled(false);
					dcFechaInicioPDev.setEnabled(false);
					rbHoyPDev.setSelected(false);
					rbUltimaSemanaPDev.setSelected(false);
					rbUltimoMesPDev.setSelected(false);
					rbUltimoAnioPDev.setSelected(false);
					filtrarManteriorPDev();
				}
			}
		});
		rbMAnteriorPDev.setBounds(5, 130, 150, 25);
		pnPiezasDevueltas.add(rbMAnteriorPDev);
		
		rbUltimoMesPDev = new JRadioButton("Ultimo Mes");
		rbUltimoMesPDev.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rbUltimoMesPDev.isSelected()){
					rbIntervaloPDev.setSelected(false);
					dcFechaFinPDev.setEnabled(false);
					dcFechaInicioPDev.setEnabled(false);
					rbHoyPDev.setSelected(false);
					rbUltimaSemanaPDev.setSelected(false);
					rbMAnteriorPDev.setSelected(false);
					rbUltimoAnioPDev.setSelected(false);
					filtrarUMesPDev();
				}
			}
		});
		rbUltimoMesPDev.setBounds(5, 100, 150, 25);
		pnPiezasDevueltas.add(rbUltimoMesPDev);
		
		rbUltimoAnioPDev = new JRadioButton("Ultimo A\u00F1o");
		rbUltimoAnioPDev.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rbUltimoAnioPDev.isSelected()){
					rbIntervaloPDev.setSelected(false);
					dcFechaFinPDev.setEnabled(false);
					dcFechaInicioPDev.setEnabled(false);
					rbHoyPDev.setSelected(false);
					rbUltimaSemanaPDev.setSelected(false);
					rbUltimoMesPDev.setSelected(false);
					rbMAnteriorPDev.setSelected(false);
					filtrarUAnioPDev();
				}
			}
		});
		rbUltimoAnioPDev.setBounds(5, 160, 150, 25);
		pnPiezasDevueltas.add(rbUltimoAnioPDev);
		
		modelo_tabla_piezas_devueltas = new DefaultTableModel(datosTabla_piezas_devueltas, nombreColumnas_piezas_devueltas);
		tablaPiezasDevueltas = new JTable(modelo_tabla_piezas_devueltas) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false,
					false, false, false,false, false, 
					false, false, false,
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_tabla_piezas_devueltas = new TableRowSorter<TableModel>(modelo_tabla_piezas_devueltas);
		tablaPiezasDevueltas.setRowSorter(ordenador_tabla_piezas_devueltas);
		//
		tablaPiezasDevueltas.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tablaPiezasDevueltas.getColumnCount(); i++) {
			tablaPiezasDevueltas.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_piezas_devueltas.elementAt(i));
			tablaPiezasDevueltas.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_piezas_devueltas.elementAt(i));
		}
		tablaPiezasDevueltas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane_piezas_devueltas = new JScrollPane(tablaPiezasDevueltas);
		scrollPane_piezas_devueltas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_piezas_devueltas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_piezas_devueltas.setBounds(0, 200, 1230, 420);
		pnPiezasDevueltas.add(scrollPane_piezas_devueltas);

		tablaPiezasDevueltas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		btnFiltrarPDev = new JButton("Filtrar");
		btnFiltrarPDev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filtrarInervaloPDev();
			}
		});
		btnFiltrarPDev.setEnabled(false);
		btnFiltrarPDev.setBounds(750, 10, 110, 25);
		pnPiezasDevueltas.add(btnFiltrarPDev);
		
		// PIEZAS SIN LLEGAR
		pnPiezasPedidasSinLLegar = new JPanel();
		gestion.addTab("PIEZAS SIN LLEGAR", null, pnPiezasPedidasSinLLegar, null);
		pnPiezasPedidasSinLLegar.setLayout(null);
		
		dC_SLL_inicio = new JDateChooser();
		dC_SLL_inicio.setBounds(290, 10, 150, 25);
		dC_SLL_inicio.setEnabled(false);
		pnPiezasPedidasSinLLegar.add(dC_SLL_inicio);
		
		JLabel label_4 = new JLabel("Fecha Inicio");
		label_4.setBounds(160, 10, 120, 25);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setEnabled(false);
		pnPiezasPedidasSinLLegar.add(label_4);
		
		JLabel label_5 = new JLabel("Fecha Fin");
		label_5.setBounds(460, 10, 120, 25);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setEnabled(false);
		pnPiezasPedidasSinLLegar.add(label_5);
		
		dC_SLL_fin = new JDateChooser();
		dC_SLL_fin.setBounds(590, 10, 150, 25);
		dC_SLL_fin.setEnabled(false);
		pnPiezasPedidasSinLLegar.add(dC_SLL_fin);
		
		rB_SLL_Intervalo = new JRadioButton("Intervalo de Fechas");
		rB_SLL_Intervalo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_SLL_Intervalo.isSelected()){
					dC_SLL_inicio.setEnabled(true);
					dC_SLL_fin.setEnabled(true);
					
					rB_SLL_Hoy.setSelected(false);
					rB_SLL_Semana.setSelected(false);
					rB_SLL_Mes.setSelected(false);
					rB_SLL_MesPasado.setSelected(false);
					rB_SLL_Anio.setSelected(false);
					filtrarIntervaloSLL();
				}else{
					dC_SLL_inicio.setEnabled(false);
					dC_SLL_fin.setEnabled(false);	
				}
			}
		});
		rB_SLL_Intervalo.setBounds(5, 10, 150, 25);
		pnPiezasPedidasSinLLegar.add(rB_SLL_Intervalo);
		
		rB_SLL_Hoy = new JRadioButton("Hoy");
		rB_SLL_Hoy.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_SLL_Hoy.isSelected()){
					rB_SLL_Intervalo.setSelected(false);
					dC_SLL_inicio.setEnabled(false);
					dC_SLL_fin.setEnabled(false);
					rB_SLL_Semana.setSelected(false);
					rB_SLL_Mes.setSelected(false);
					rB_SLL_MesPasado.setSelected(false);
					rB_SLL_Anio.setSelected(false);
					filtrarHoySLL();
				}
			}
		});
		rB_SLL_Hoy.setBounds(5, 40, 150, 25);
		pnPiezasPedidasSinLLegar.add(rB_SLL_Hoy);
		
		rB_SLL_Semana = new JRadioButton("Ultima Semana");
		rB_SLL_Semana.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_SLL_Semana.isSelected()){
					rB_SLL_Intervalo.setSelected(false);
					dC_SLL_inicio.setEnabled(false);
					dC_SLL_fin.setEnabled(false);
					rB_SLL_Hoy.setSelected(false);
					rB_SLL_Mes.setSelected(false);
					rB_SLL_MesPasado.setSelected(false);
					rB_SLL_Anio.setSelected(false);
					filtrarSemanaSLL();
				}
			}
		});
		rB_SLL_Semana.setBounds(5, 70, 150, 25);
		pnPiezasPedidasSinLLegar.add(rB_SLL_Semana);
		
		rB_SLL_Mes = new JRadioButton("Ultimo Mes");
		rB_SLL_Mes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_SLL_Mes.isSelected()){
					rB_SLL_Intervalo.setSelected(false);
					dC_SLL_inicio.setEnabled(false);
					dC_SLL_fin.setEnabled(false);
					rB_SLL_Hoy.setSelected(false);
					rB_SLL_Semana.setSelected(false);
					rB_SLL_MesPasado.setSelected(false);
					rB_SLL_Anio.setSelected(false);
					filtrarMesSLL();
				}
			}
		});
		rB_SLL_Mes.setBounds(5, 100, 150, 25);
		pnPiezasPedidasSinLLegar.add(rB_SLL_Mes);
		
		rB_SLL_Anio = new JRadioButton("Ultimo A\u00F1o");
		rB_SLL_Anio.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_SLL_Anio.isSelected()){
					rB_SLL_Intervalo.setSelected(false);
					dC_SLL_inicio.setEnabled(false);
					dC_SLL_fin.setEnabled(false);
					rB_SLL_Hoy.setSelected(false);
					rB_SLL_Semana.setSelected(false);
					rB_SLL_Mes.setSelected(false);
					rB_SLL_MesPasado.setSelected(false);
					filtrarAnioSLL();
				}
			}
		});
		rB_SLL_Anio.setBounds(5, 160, 150, 25);
		pnPiezasPedidasSinLLegar.add(rB_SLL_Anio);
		
		rB_SLL_MesPasado = new JRadioButton("Mes Anterior");
		rB_SLL_MesPasado.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_SLL_MesPasado.isSelected()){
					rB_SLL_Intervalo.setSelected(false);
					dC_SLL_inicio.setEnabled(false);
					dC_SLL_fin.setEnabled(false);
					rB_SLL_Hoy.setSelected(false);
					rB_SLL_Semana.setSelected(false);
					rB_SLL_Mes.setSelected(false);
					rB_SLL_Anio.setSelected(false);
					filtrarMPasadoSLL();
				}
			}
		});
		rB_SLL_MesPasado.setBounds(5, 130, 150, 25);
		pnPiezasPedidasSinLLegar.add(rB_SLL_MesPasado);
		
		modelo_tabla_piezas_sin_llegar = new DefaultTableModel(datosTabla_piezas_sin_llegar, nombreColumnas_piezas_sin_llegar);
		tabla_piezas_sin_llegar = new JTable(modelo_tabla_piezas_sin_llegar) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false,
					false, false, false, false,
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_tabla_piezas_sin_llegar = new TableRowSorter<TableModel>(modelo_tabla_piezas_sin_llegar);
		tabla_piezas_sin_llegar.setRowSorter(ordenador_tabla_piezas_sin_llegar);
		//
		tabla_piezas_sin_llegar.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tabla_piezas_sin_llegar.getColumnCount(); i++) {
			tabla_piezas_sin_llegar.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_piezas_sin_llegar.elementAt(i));
			tabla_piezas_sin_llegar.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_piezas_sin_llegar.elementAt(i));
		}
		tabla_piezas_sin_llegar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane_pedidas_sin_llegar = new JScrollPane(tabla_piezas_sin_llegar);
		scrollPane_pedidas_sin_llegar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_pedidas_sin_llegar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_pedidas_sin_llegar.setBounds(0, 200, 1230, 420);
		pnPiezasPedidasSinLLegar.add(scrollPane_pedidas_sin_llegar);
		
		btonFiltrar_SLL = new JButton("Filtrar");
		btonFiltrar_SLL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btonFiltrar_SLL.setEnabled(false);
		btonFiltrar_SLL.setBounds(750, 10, 110, 25);
		pnPiezasPedidasSinLLegar.add(btonFiltrar_SLL);

		//tabla_piezas_sin_llegar.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//Tabla piezas llegadas sin turno
		pnPiezasLLegadasSinTurno = new JPanel();
		gestion.addTab("PIEZAS LLEGADAS SIN TURNO", null, pnPiezasLLegadasSinTurno, null);
		pnPiezasLLegadasSinTurno.setLayout(null);
		
		dCPiezasLLegadasST_Inicio = new JDateChooser();
		dCPiezasLLegadasST_Inicio.setEnabled(false);
		dCPiezasLLegadasST_Inicio.setBounds(290, 10, 150, 25);
		pnPiezasLLegadasSinTurno.add(dCPiezasLLegadasST_Inicio);
		
		JLabel label_6 = new JLabel("Fecha Inicio");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setEnabled(false);
		label_6.setBounds(160, 10, 120, 25);
		pnPiezasLLegadasSinTurno.add(label_6);
		
		JLabel label_7 = new JLabel("Fecha Fin");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setEnabled(false);
		label_7.setBounds(460, 10, 120, 25);
		pnPiezasLLegadasSinTurno.add(label_7);
		
		dCPiezasLLegadasST_Fin = new JDateChooser();
		dCPiezasLLegadasST_Fin.setEnabled(false);
		dCPiezasLLegadasST_Fin.setBounds(590, 10, 150, 25);
		pnPiezasLLegadasSinTurno.add(dCPiezasLLegadasST_Fin);
		
		rB_Intervalo_PLLST = new JRadioButton("Intervalo de Fechas");
		rB_Intervalo_PLLST.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_Intervalo_PLLST.isSelected()){
					dCPiezasLLegadasST_Inicio.setEnabled(true);
					dCPiezasLLegadasST_Fin.setEnabled(true);

					rB_Hoy_PLLST.setSelected(false);
					rB_USemana_PLLST.setSelected(false);
					rB_UMes_PLLST.setSelected(false);
					rBMesPasado_PLLST.setSelected(false);
					rB_UAnio_PLLST.setSelected(false);
				}else{
					dCPiezasLLegadasST_Inicio.setEnabled(false);
					dCPiezasLLegadasST_Fin.setEnabled(false);
				}
			}
		});
		rB_Intervalo_PLLST.setBounds(5, 10, 150, 25);
		pnPiezasLLegadasSinTurno.add(rB_Intervalo_PLLST);
		
		rB_Hoy_PLLST = new JRadioButton("Hoy");
		rB_Hoy_PLLST.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_Hoy_PLLST.isSelected()){
					rB_Intervalo_PLLST.setSelected(false);
					dCPiezasLLegadasST_Inicio.setEnabled(false);
					dCPiezasLLegadasST_Fin.setEnabled(false);
					rB_USemana_PLLST.setSelected(false);
					rB_UMes_PLLST.setSelected(false);
					rBMesPasado_PLLST.setSelected(false);
					rB_UAnio_PLLST.setSelected(false);
					filtraHoyPLLST();
				}
			}
		});
		rB_Hoy_PLLST.setBounds(5, 40, 150, 25);
		pnPiezasLLegadasSinTurno.add(rB_Hoy_PLLST);
		
		rB_USemana_PLLST = new JRadioButton("Ultima Semana");
		rB_USemana_PLLST.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_USemana_PLLST.isSelected()){
					rB_Intervalo_PLLST.setSelected(false);
					dCPiezasLLegadasST_Inicio.setEnabled(false);
					dCPiezasLLegadasST_Fin.setEnabled(false);
					rB_Hoy_PLLST.setSelected(false);
					rB_UMes_PLLST.setSelected(false);
					rBMesPasado_PLLST.setSelected(false);
					rB_UAnio_PLLST.setSelected(false);
					filtrarSemanaPLLST();
				}
			}
		});
		rB_USemana_PLLST.setBounds(5, 70, 150, 25);
		pnPiezasLLegadasSinTurno.add(rB_USemana_PLLST);
		
		rB_UMes_PLLST = new JRadioButton("Ultimo Mes");
		rB_UMes_PLLST.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_UMes_PLLST.isSelected()){
					rB_Intervalo_PLLST.setSelected(false);
					dCPiezasLLegadasST_Inicio.setEnabled(false);
					dCPiezasLLegadasST_Fin.setEnabled(false);
					rB_Hoy_PLLST.setSelected(false);
					rB_USemana_PLLST.setSelected(false);
					rBMesPasado_PLLST.setSelected(false);
					rB_UAnio_PLLST.setSelected(false);
					filtrarUMes();
				}
			}
		});
		rB_UMes_PLLST.setBounds(5, 100, 150, 25);
		pnPiezasLLegadasSinTurno.add(rB_UMes_PLLST);
		
		rBMesPasado_PLLST = new JRadioButton("Mes Anterior");
		rBMesPasado_PLLST.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rBMesPasado_PLLST.isSelected()){
					rB_Intervalo_PLLST.setSelected(false);
					dCPiezasLLegadasST_Inicio.setEnabled(false);
					dCPiezasLLegadasST_Fin.setEnabled(false);
					rB_Hoy_PLLST.setSelected(false);
					rB_USemana_PLLST.setSelected(false);
					rB_UMes_PLLST.setSelected(false);
					rB_UAnio_PLLST.setSelected(false);
					filtrarMesPasadoPLLST();
				}
			}
		});
		rBMesPasado_PLLST.setBounds(5, 130, 150, 25);
		pnPiezasLLegadasSinTurno.add(rBMesPasado_PLLST);
		
		rB_UAnio_PLLST = new JRadioButton("Ultimo A\u00F1o");
		rB_UAnio_PLLST.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_UAnio_PLLST.isSelected()){
					rB_Intervalo_PLLST.setSelected(false);
					dCPiezasLLegadasST_Inicio.setEnabled(false);
					dCPiezasLLegadasST_Fin.setEnabled(false);
					rB_Hoy_PLLST.setSelected(false);
					rB_USemana_PLLST.setSelected(false);
					rB_UMes_PLLST.setSelected(false);
					rBMesPasado_PLLST.setSelected(false);
					filtrarAnioPLLST();
				}
			}
		});
		rB_UAnio_PLLST.setBounds(5, 160, 150, 25);
		pnPiezasLLegadasSinTurno.add(rB_UAnio_PLLST);
		
		//////
		modelo_tabla_piezas_llegadas_sin_turno = new DefaultTableModel(datosTabla_piezas_llegadas_sin_turno, nombreColumnas_piezas_llegadas_sin_turno);
		tabla_piezas_llegadas_sin_turno = new JTable(modelo_tabla_piezas_llegadas_sin_turno) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false,
					false, false, false, false,
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_tabla_piezas_llegadas_sin_turno = new TableRowSorter<TableModel>(modelo_tabla_piezas_llegadas_sin_turno);
		tabla_piezas_llegadas_sin_turno.setRowSorter(ordenador_tabla_piezas_llegadas_sin_turno);
		//
		tabla_piezas_llegadas_sin_turno.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tabla_piezas_llegadas_sin_turno.getColumnCount(); i++) {
			tabla_piezas_llegadas_sin_turno.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_piezas_llegadas_sin_turno.elementAt(i));
			tabla_piezas_llegadas_sin_turno.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_piezas_llegadas_sin_turno.elementAt(i));
		}
		tabla_piezas_llegadas_sin_turno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane_piezas_llegadas_sin_turno = new JScrollPane(tabla_piezas_llegadas_sin_turno);
		scrollPane_piezas_llegadas_sin_turno.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_piezas_llegadas_sin_turno.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_piezas_llegadas_sin_turno.setBounds(0, 200, 1230, 420);
		pnPiezasLLegadasSinTurno.add(scrollPane_piezas_llegadas_sin_turno);

		tabla_piezas_llegadas_sin_turno.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		btnFiltrarPLLST = new JButton("Filtrar");
		btnFiltrarPLLST.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFiltrarPLLST.setEnabled(false);
		btnFiltrarPLLST.setBounds(750, 10, 110, 25);
		pnPiezasLLegadasSinTurno.add(btnFiltrarPLLST);
		////////		
		//ORDEN SIN SOLICITUD DE PEDIDO
		pnOrdenSinSDP = new JPanel();
		gestion.addTab("ORDEN SIN SOLICITUD DE PEDIDO", null, pnOrdenSinSDP, null);
		pnOrdenSinSDP.setLayout(null);
		
		dC_OSSDP_Inicio = new JDateChooser();
		dC_OSSDP_Inicio.setEnabled(false);
		dC_OSSDP_Inicio.setBounds(290, 10, 150, 25);
		pnOrdenSinSDP.add(dC_OSSDP_Inicio);
		
		JLabel label_8 = new JLabel("Fecha Inicio");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setEnabled(false);
		label_8.setBounds(160, 10, 120, 25);
		pnOrdenSinSDP.add(label_8);
		
		JLabel label_9 = new JLabel("Fecha Fin");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setEnabled(false);
		label_9.setBounds(460, 10, 120, 25);
		pnOrdenSinSDP.add(label_9);
		
		dC_OSSDP_Fin = new JDateChooser();
		dC_OSSDP_Fin.setEnabled(false);
		dC_OSSDP_Fin.setBounds(590, 10, 150, 25);
		pnOrdenSinSDP.add(dC_OSSDP_Fin);
		
		rB_Intervalo_OSSDP = new JRadioButton("Intervalo de Fechas");
		rB_Intervalo_OSSDP.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_Intervalo_OSSDP.isSelected()){
					dC_OSSDP_Inicio.setEnabled(true);
					dC_OSSDP_Fin.setEnabled(true);

					rB_Hoy_OSSDP.setSelected(false);
					rB_USemana_OSSDP.setSelected(false);
					rB_UMes_OSSDP.setSelected(false);
					rB_MesAnterior_OSSDP.setSelected(false);
					rB_UAnio_OSSDP.setSelected(false);
				}else{
					dC_OSSDP_Inicio.setEnabled(false);
					dC_OSSDP_Fin.setEnabled(false);
				}
			}
		});
		rB_Intervalo_OSSDP.setBounds(5, 10, 150, 25);
		pnOrdenSinSDP.add(rB_Intervalo_OSSDP);
		
		rB_Hoy_OSSDP = new JRadioButton("Hoy");
		rB_Hoy_OSSDP.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_Hoy_OSSDP.isSelected()){

					rB_Intervalo_OSSDP.setSelected(false);
					dC_OSSDP_Inicio.setEnabled(false);
					dC_OSSDP_Fin.setEnabled(false);

					rB_USemana_OSSDP.setSelected(false);
					rB_UMes_OSSDP.setSelected(false);
					rB_MesAnterior_OSSDP.setSelected(false);
					rB_UAnio_OSSDP.setSelected(false);
					
					filtarHoyOSSDP();
				}
			}
		});
		rB_Hoy_OSSDP.setBounds(5, 40, 150, 25);
		pnOrdenSinSDP.add(rB_Hoy_OSSDP);
		
		rB_USemana_OSSDP = new JRadioButton("Ultima Semana");
		rB_USemana_OSSDP.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_USemana_OSSDP.isSelected()){

					rB_Intervalo_OSSDP.setSelected(false);
					dC_OSSDP_Inicio.setEnabled(false);
					dC_OSSDP_Fin.setEnabled(false);

					rB_Hoy_OSSDP.setSelected(false);
					rB_UMes_OSSDP.setSelected(false);
					rB_MesAnterior_OSSDP.setSelected(false);
					rB_UAnio_OSSDP.setSelected(false);
					
					filtrarUSemanaOSSDP();
				}
			}
		});
		rB_USemana_OSSDP.setBounds(5, 70, 150, 25);
		pnOrdenSinSDP.add(rB_USemana_OSSDP);
		
		rB_UMes_OSSDP = new JRadioButton("Ultimo Mes");
		rB_UMes_OSSDP.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_UMes_OSSDP.isSelected()){

					rB_Intervalo_OSSDP.setSelected(false);
					dC_OSSDP_Inicio.setEnabled(false);
					dC_OSSDP_Fin.setEnabled(false);

					rB_Hoy_OSSDP.setSelected(false);
					rB_USemana_OSSDP.setSelected(false);
					rB_MesAnterior_OSSDP.setSelected(false);
					rB_UAnio_OSSDP.setSelected(false);
					
					filtrarUMesOSSDP();
				}
			}
		});
		rB_UMes_OSSDP.setBounds(5, 100, 150, 25);
		pnOrdenSinSDP.add(rB_UMes_OSSDP);
		
		rB_MesAnterior_OSSDP = new JRadioButton("Mes Anterior");
		rB_MesAnterior_OSSDP.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_MesAnterior_OSSDP.isSelected()){

					rB_Intervalo_OSSDP.setSelected(false);
					dC_OSSDP_Inicio.setEnabled(false);
					dC_OSSDP_Fin.setEnabled(false);

					rB_Hoy_OSSDP.setSelected(false);
					rB_USemana_OSSDP.setSelected(false);
					rB_UMes_OSSDP.setSelected(false);
					rB_UAnio_OSSDP.setSelected(false);
					
					filtrarMesAnteriorOSSDP();
				}
			}
		});
		rB_MesAnterior_OSSDP.setBounds(5, 130, 150, 25);
		pnOrdenSinSDP.add(rB_MesAnterior_OSSDP);
		
		rB_UAnio_OSSDP = new JRadioButton("Ultimo A\u00F1o");
		rB_UAnio_OSSDP.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_UAnio_OSSDP.isSelected()){

					rB_Intervalo_OSSDP.setSelected(false);
					dC_OSSDP_Inicio.setEnabled(false);
					dC_OSSDP_Fin.setEnabled(false);

					rB_Hoy_OSSDP.setSelected(false);
					rB_USemana_OSSDP.setSelected(false);
					rB_UMes_OSSDP.setSelected(false);
					rB_MesAnterior_OSSDP.setSelected(false);
					
					filtrarAnioOSSDP();
				}
			}
		});
		rB_UAnio_OSSDP.setBounds(5, 160, 150, 25);
		pnOrdenSinSDP.add(rB_UAnio_OSSDP);
		//TABLA ORDEN SIN SOLICITUD DE PEDIDO
		modelo_tabla_orden_sin_solicitud_pedido = new DefaultTableModel(datosTabla_orden_sin_solicitud_pedido, nombreColumnas_orden_sin_solicitud_pedido);
		tabla_orden_sin_solicitud_pedido = new JTable(modelo_tabla_orden_sin_solicitud_pedido) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false,
					false, false, false, false,
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_tabla_orden_sin_solicitud_pedido = new TableRowSorter<TableModel>(modelo_tabla_orden_sin_solicitud_pedido);
		tabla_orden_sin_solicitud_pedido.setRowSorter(ordenador_tabla_orden_sin_solicitud_pedido);
		//
		tabla_orden_sin_solicitud_pedido.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tabla_orden_sin_solicitud_pedido.getColumnCount(); i++) {
			tabla_orden_sin_solicitud_pedido.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_orden_sin_solicitud_pedido.elementAt(i));
			tabla_orden_sin_solicitud_pedido.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_orden_sin_solicitud_pedido.elementAt(i));
		}
		tabla_orden_sin_solicitud_pedido.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane_orden_sin_sdp = new JScrollPane(tabla_orden_sin_solicitud_pedido);
		scrollPane_orden_sin_sdp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_orden_sin_sdp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_orden_sin_sdp.setBounds(0, 200, 1230, 420);
		pnOrdenSinSDP.add(scrollPane_orden_sin_sdp);
		
		btnFiltrarOSSDP = new JButton("Filtrar");
		btnFiltrarOSSDP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFiltrarOSSDP.setEnabled(false);
		btnFiltrarOSSDP.setBounds(750, 10, 110, 25);
		pnOrdenSinSDP.add(btnFiltrarOSSDP);
		
		//tabla_orden_sin_solicitud_pedido.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//
		//Tabla SDP sin numero pedido
		pnSDPsinNumPedido = new JPanel();
		pnSDPsinNumPedido.setLayout(null);
		gestion.addTab("SOLICITUD DE PEDIDO SIN NUMERO DE PEDIDO", null, pnSDPsinNumPedido, null);
		
		dC_SDPSN_Inicio = new JDateChooser();
		dC_SDPSN_Inicio.setEnabled(false);
		dC_SDPSN_Inicio.setBounds(290, 10, 150, 25);
		pnSDPsinNumPedido.add(dC_SDPSN_Inicio);
		
		JLabel label_10 = new JLabel("Fecha Inicio");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setEnabled(false);
		label_10.setBounds(160, 10, 120, 25);
		pnSDPsinNumPedido.add(label_10);
		
		JLabel label_11 = new JLabel("Fecha Fin");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setEnabled(false);
		label_11.setBounds(460, 10, 120, 25);
		pnSDPsinNumPedido.add(label_11);
		
		dC_SDPSN_Fin = new JDateChooser();
		dC_SDPSN_Fin.setEnabled(false);
		dC_SDPSN_Fin.setBounds(590, 10, 150, 25);
		pnSDPsinNumPedido.add(dC_SDPSN_Fin);
		
		rB_Inetervalo_SDPSN = new JRadioButton("Intervalo de Fechas");
		rB_Inetervalo_SDPSN.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_Inetervalo_SDPSN.isSelected()){
					dC_SDPSN_Inicio.setEnabled(true);
					dC_SDPSN_Fin.setEnabled(true);

					rB_Hoy_SDPSN.setSelected(false);
					rB_USemana_SDPSN.setSelected(false);
					rB_UMes_SDPSN.setSelected(false);
					rB_MesPasado_SDPSN.setSelected(false);
					rB_UAnio_SDPSN.setSelected(false);
				}else{
					dC_SDPSN_Inicio.setEnabled(false);
					dC_SDPSN_Fin.setEnabled(false);
				}
			}
		});
		rB_Inetervalo_SDPSN.setBounds(5, 10, 150, 25);
		pnSDPsinNumPedido.add(rB_Inetervalo_SDPSN);
		
		rB_Hoy_SDPSN = new JRadioButton("Hoy");
		rB_Hoy_SDPSN.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_Hoy_SDPSN.isSelected()){
					rB_Inetervalo_SDPSN.setSelected(false);
					dC_SDPSN_Inicio.setEnabled(false);
					dC_SDPSN_Fin.setEnabled(false);;

					rB_USemana_SDPSN.setSelected(false);
					rB_UMes_SDPSN.setSelected(false);
					rB_MesPasado_SDPSN.setSelected(false);
					rB_UAnio_SDPSN.setSelected(false);
					filtrarHoySDPSN();
				}
			}
		});
		rB_Hoy_SDPSN.setBounds(5, 40, 150, 25);
		pnSDPsinNumPedido.add(rB_Hoy_SDPSN);
		
		rB_USemana_SDPSN = new JRadioButton("Ultima Semana");
		rB_USemana_SDPSN.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_USemana_SDPSN.isSelected()){
					rB_Inetervalo_SDPSN.setSelected(false);
					dC_SDPSN_Inicio.setEnabled(false);
					dC_SDPSN_Fin.setEnabled(false);;

					rB_Hoy_SDPSN.setSelected(false);
					rB_UMes_SDPSN.setSelected(false);
					rB_MesPasado_SDPSN.setSelected(false);
					rB_UAnio_SDPSN.setSelected(false);
					filtrarUSemanaSDPSN();
				}
			}
		});
		rB_USemana_SDPSN.setBounds(5, 70, 150, 25);
		pnSDPsinNumPedido.add(rB_USemana_SDPSN);
		
		rB_UMes_SDPSN = new JRadioButton("Ultimo Mes");
		rB_UMes_SDPSN.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_UMes_SDPSN.isSelected()){
					rB_Inetervalo_SDPSN.setSelected(false);
					dC_SDPSN_Inicio.setEnabled(false);
					dC_SDPSN_Fin.setEnabled(false);;

					rB_Hoy_SDPSN.setSelected(false);
					rB_USemana_SDPSN.setSelected(false);
					rB_MesPasado_SDPSN.setSelected(false);
					rB_UAnio_SDPSN.setSelected(false);
					
					filtrarMesSDPSN();
				}
			}
		});
		rB_UMes_SDPSN.setBounds(5, 100, 150, 25);
		pnSDPsinNumPedido.add(rB_UMes_SDPSN);
		
		rB_MesPasado_SDPSN = new JRadioButton("Mes Pasado");
		rB_MesPasado_SDPSN.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_MesPasado_SDPSN.isSelected()){
					rB_Inetervalo_SDPSN.setSelected(false);
					dC_SDPSN_Inicio.setEnabled(false);
					dC_SDPSN_Fin.setEnabled(false);;

					rB_Hoy_SDPSN.setSelected(false);
					rB_USemana_SDPSN.setSelected(false);
					rB_UMes_SDPSN.setSelected(false);
					rB_UAnio_SDPSN.setSelected(false);
					
					filtarMesPasadoSDPSN();
				}
			}
		});
		rB_MesPasado_SDPSN.setBounds(5, 130, 150, 25);
		pnSDPsinNumPedido.add(rB_MesPasado_SDPSN);
		
		rB_UAnio_SDPSN = new JRadioButton("Ultimo A\u00F1o");
		rB_UAnio_SDPSN.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rB_UAnio_SDPSN.isSelected()){
					rB_Inetervalo_SDPSN.setSelected(false);
					dC_SDPSN_Inicio.setEnabled(false);
					dC_SDPSN_Fin.setEnabled(false);;

					rB_Hoy_SDPSN.setSelected(false);
					rB_USemana_SDPSN.setSelected(false);
					rB_UMes_SDPSN.setSelected(false);
					rB_MesPasado_SDPSN.setSelected(false);
					
					filtrarAnioSDPSN();
				}
			}
		});
		rB_UAnio_SDPSN.setBounds(5, 160, 150, 25);
		pnSDPsinNumPedido.add(rB_UAnio_SDPSN);
		
		//Tabla
		modelo_tabla_sdp_sin_numero_pedido = new DefaultTableModel(datosTabla_sdp_sin_numero_pedido, nombreColumnas_sdp_sin_numero_pedido);
		tablaSdp_sin_numero_pedido = new JTable(modelo_tabla_sdp_sin_numero_pedido) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false,
					false, false, false,false, false, 
					false, false, false,
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_tabla_sdp_sin_numero_pedido = new TableRowSorter<TableModel>(modelo_tabla_sdp_sin_numero_pedido);
		tablaSdp_sin_numero_pedido.setRowSorter(ordenador_tabla_sdp_sin_numero_pedido);
		//
		tablaSdp_sin_numero_pedido.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tablaSdp_sin_numero_pedido.getColumnCount(); i++) {
			tablaSdp_sin_numero_pedido.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_sdp_sin_numero_pedido.elementAt(i));
			tablaSdp_sin_numero_pedido.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_sdp_sin_numero_pedido.elementAt(i));
		}
		tablaSdp_sin_numero_pedido.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane_sdp_sin_numero = new JScrollPane(tablaSdp_sin_numero_pedido);
		scrollPane_sdp_sin_numero.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_sdp_sin_numero.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_sdp_sin_numero.setBounds(0, 200, 1230, 420);
		pnSDPsinNumPedido.add(scrollPane_sdp_sin_numero);
		
		btnFiltrarSDPSN = new JButton("Filtrar");
		btnFiltrarSDPSN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFiltrarSDPSN.setEnabled(false);
		btnFiltrarSDPSN.setBounds(750, 10, 110, 25);
		pnSDPsinNumPedido.add(btnFiltrarSDPSN);

		//tablaSdp_sin_numero_pedido.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		

	
	}

	protected void filtrarAnioSDPSN() {
		
	}

	protected void filtarMesPasadoSDPSN() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarMesSDPSN() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarUSemanaSDPSN() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarHoySDPSN() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarAnioOSSDP() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarMesAnteriorOSSDP() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarUMesOSSDP() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarUSemanaOSSDP() {
		// TODO Auto-generated method stub
		
	}

	protected void filtarHoyOSSDP() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarAnioPLLST() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarMesPasadoPLLST() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarUMes() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarSemanaPLLST() {
		// TODO Auto-generated method stub
		
	}

	protected void filtraHoyPLLST() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarMPasadoSLL() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarAnioSLL() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarMesSLL() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarSemanaSLL() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarHoySLL() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarIntervaloSLL() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarUAnioPDev() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarUMesPDev() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarManteriorPDev() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarUSemanaPDev() {
		// TODO Auto-generated method stub
		
	}

	protected void filtrarHoyPDev() {
		
	}

	protected void filtrarInervaloPDev() {
		if(dC_FInicioPLL.getDate()!=null && dC_FFinPLL.getDate()!=null){
			SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy");
			datosTabla_piezas_llegadas= new Vector<Vector<String>>();
			
			for (int i=0; i< pedidos_piezas.size();i++){
				boolean resp = false;
				if (mediador.esEntidad(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante())){
					resp = pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getDevolucion_pieza()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null;
				}else{
					resp = pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getFecha_envio_agente()==null  && pedidos_piezas.elementAt(i).getDevolucion_pieza()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null;
				}					
				if(resp){
					Calendar c = new GregorianCalendar();
					c.setTime(dC_FInicioPLL.getDate());
					c.add(c.DAY_OF_MONTH, -1);
					if(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().after(c.getTime()) &&  pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().before(dC_FFinPLL.getDate())){
						Vector<String> row = new Vector<String> ();
		
						row.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
						row.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
						row.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
						row.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
						row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
						row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
						row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
						
						if(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido()!=null){
							java.sql.Date fsp = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido().getTime());
							row.add(format2.format(fsp));//Fecha Solicitud Pedido
						}else{
							row.add("");
						}			    
						
						if (pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null){
							java.sql.Date fsf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica().getTime());
							row.add(format2.format(fsf));//Fecha Solicitud Fabrica
						}else{
							row.add("");
						}
						if (pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null){
							java.sql.Date frf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().getTime());
							row.add(format2.format(frf));//Fecha Recepcion Fabrica
						}else{
							row.add("");
						}
						datosTabla_piezas_llegadas.add(row);
					}
				}
			}
			modelo_tabla_piezas_llegadas.setDataVector(datosTabla_piezas_llegadas, nombreColumnas_piezas_llegadas);
			modelo_tabla_piezas_llegadas.fireTableStructureChanged();
			
			for(int i = 0; i < tablaPiezas_Llegadas.getColumnCount(); i++) {
				tablaPiezas_Llegadas.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_piezas_llegadas.elementAt(i));
				tablaPiezas_Llegadas.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_piezas_llegadas.elementAt(i));
			}	
		}else{
			JOptionPane.showMessageDialog(this,"Algunos campos estan vacios.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
		}
	}

	//Piezas Llegadas
	@SuppressWarnings("deprecation")
	protected void filtrarUAnioPLL() {
		java.util.Date hoy = new java.util.Date();
		java.util.Date iniAnioPasado = new java.util.Date();
		iniAnioPasado.setYear(hoy.getYear()-1);
		iniAnioPasado.setMonth(1);
		iniAnioPasado.setDate(1);
		java.util.Date finAnioPasado = new java.util.Date();
		finAnioPasado.setYear(hoy.getYear()-1);
		finAnioPasado.setMonth(12);
		finAnioPasado.setDate(31);
		
		
		SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 
		datosTabla_piezas_llegadas= new Vector<Vector<String>>();
		
		for (int i=0; i< pedidos_piezas.size();i++){
			boolean resp = false;
			if (mediador.esEntidad(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante())){
				resp = pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getDevolucion_pieza()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null;
			}else{
				resp = pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getFecha_envio_agente()==null  && pedidos_piezas.elementAt(i).getDevolucion_pieza()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null;
			}					
			if(resp){
				
				if(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().after(iniAnioPasado) &&  pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().before(finAnioPasado)){
					Vector<String> row = new Vector<String> ();
	
					row.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
					row.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
					row.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
					row.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
					
					if(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido()!=null){
						java.sql.Date fsp = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido().getTime());
						row.add(format2.format(fsp));//Fecha Solicitud Pedido
					}else{
						row.add("");
					}			    
					
					if (pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null){
						java.sql.Date fsf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica().getTime());
						row.add(format2.format(fsf));//Fecha Solicitud Fabrica
					}else{
						row.add("");
					}
					if (pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null){
						java.sql.Date frf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().getTime());
						row.add(format2.format(frf));//Fecha Recepcion Fabrica
					}else{
						row.add("");
					}
	
					datosTabla_piezas_llegadas.add(row);
				}
			}
		}
		modelo_tabla_piezas_llegadas.setDataVector(datosTabla_piezas_llegadas, nombreColumnas_piezas_llegadas);
		modelo_tabla_piezas_llegadas.fireTableStructureChanged();
		
		for(int i = 0; i < tablaPiezas_Llegadas.getColumnCount(); i++) {
			tablaPiezas_Llegadas.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_piezas_llegadas.elementAt(i));
			tablaPiezas_Llegadas.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_piezas_llegadas.elementAt(i));
		}		
	}

	@SuppressWarnings("deprecation")
	protected void filtrarUMesPLL() {
		SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(c.SUNDAY);
		c.add(c.MONTH, -1);
		
		java.util.Date iniUltimoMes = c.getTime();
		iniUltimoMes.setDate(1);
		
		java.util.Date finUltimoMes = c.getTime();
		iniUltimoMes.setDate(c.getMaximum(c.DAY_OF_MONTH));
		
		datosTabla_piezas_llegadas= new Vector<Vector<String>>();
		
		for (int i=0; i< pedidos_piezas.size();i++){
			boolean resp = false;
			if (mediador.esEntidad(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante())){
				resp = pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getDevolucion_pieza()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null;
			}else{
				resp = pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getFecha_envio_agente()==null  && pedidos_piezas.elementAt(i).getDevolucion_pieza()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null;
			}					
			if(resp){
				
				if(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().after(iniUltimoMes) &&  pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().before(finUltimoMes)){
					Vector<String> row = new Vector<String> ();
	
					row.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
					row.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
					row.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
					row.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
					
					if(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido()!=null){
						java.sql.Date fsp = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido().getTime());
						row.add(format2.format(fsp));//Fecha Solicitud Pedido
					}else{
						row.add("");
					}			    
					
					if (pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null){
						java.sql.Date fsf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica().getTime());
						row.add(format2.format(fsf));//Fecha Solicitud Fabrica
					}else{
						row.add("");
					}
					if (pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null){
						java.sql.Date frf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().getTime());
						row.add(format2.format(frf));//Fecha Recepcion Fabrica
					}else{
						row.add("");
					}
	
					datosTabla_piezas_llegadas.add(row);
				}
			}
		}
		modelo_tabla_piezas_llegadas.setDataVector(datosTabla_piezas_llegadas, nombreColumnas_piezas_llegadas);
		modelo_tabla_piezas_llegadas.fireTableStructureChanged();
		
		for(int i = 0; i < tablaPiezas_Llegadas.getColumnCount(); i++) {
			tablaPiezas_Llegadas.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_piezas_llegadas.elementAt(i));
			tablaPiezas_Llegadas.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_piezas_llegadas.elementAt(i));
		}
	}

	protected void filtrarUSemanaPLL() {
		SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(c.SUNDAY);
		c.add(c.WEEK_OF_YEAR, -1);
		
		Calendar d = Calendar.getInstance();
		d.setFirstDayOfWeek(d.SUNDAY);
		d.add(d.WEEK_OF_YEAR, -1);

		c.set(c.DAY_OF_WEEK,c.MONDAY);
		java.util.Date iniSemanaPasado = c.getTime();
		
		d.set(d.DAY_OF_WEEK,d.FRIDAY);
		
		java.util.Date finSemanaPasado = d.getTime();
		
		
		datosTabla_piezas_llegadas= new Vector<Vector<String>>();
		
		for (int i=0; i< pedidos_piezas.size();i++){
			boolean resp = false;
			if (mediador.esEntidad(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante())){
				resp = pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getDevolucion_pieza()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null;
			}else{
				resp = pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getFecha_envio_agente()==null  && pedidos_piezas.elementAt(i).getDevolucion_pieza()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null;
			}					
			if(resp){
				
				if(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().after(iniSemanaPasado) &&  pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().before(finSemanaPasado)){
					Vector<String> row = new Vector<String> ();
	
					row.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
					row.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
					row.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
					row.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
					
					if(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido()!=null){
						java.sql.Date fsp = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido().getTime());
						row.add(format2.format(fsp));//Fecha Solicitud Pedido
					}else{
						row.add("");
					}			    
					
					if (pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null){
						java.sql.Date fsf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica().getTime());
						row.add(format2.format(fsf));//Fecha Solicitud Fabrica
					}else{
						row.add("");
					}
					if (pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null){
						java.sql.Date frf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().getTime());
						row.add(format2.format(frf));//Fecha Recepcion Fabrica
					}else{
						row.add("");
					}
	
					datosTabla_piezas_llegadas.add(row);
				}
			}
		}
		modelo_tabla_piezas_llegadas.setDataVector(datosTabla_piezas_llegadas, nombreColumnas_piezas_llegadas);
		modelo_tabla_piezas_llegadas.fireTableStructureChanged();
		
		for(int i = 0; i < tablaPiezas_Llegadas.getColumnCount(); i++) {
			tablaPiezas_Llegadas.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_piezas_llegadas.elementAt(i));
			tablaPiezas_Llegadas.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_piezas_llegadas.elementAt(i));
		}	
		
	}

	@SuppressWarnings("deprecation")
	protected void filtrarHoyPLL() {
		java.sql.Date hoy = new java.sql.Date(new java.util.Date().getTime());
		SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 
		datosTabla_piezas_llegadas= new Vector<Vector<String>>();
		
		for (int i=0; i< pedidos_piezas.size();i++){
			boolean resp = false;
			if (mediador.esEntidad(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante())){
				resp = pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getDevolucion_pieza()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null;
			}else{
				resp = pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getFecha_envio_agente()==null  && pedidos_piezas.elementAt(i).getDevolucion_pieza()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null;
			}					
			if(resp){
				if(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().getDate()==hoy.getDate() &&
						pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().getMonth()==hoy.getMonth() &&
							pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().getYear()==hoy.getYear()){
					Vector<String> row = new Vector<String> ();
	
					row.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
					row.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
					row.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
					row.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
					
					if(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido()!=null){
						java.sql.Date fsp = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido().getTime());
						row.add(format2.format(fsp));//Fecha Solicitud Pedido
					}else{
						row.add("");
					}			    
					
					if (pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null){
						java.sql.Date fsf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica().getTime());
						row.add(format2.format(fsf));//Fecha Solicitud Fabrica
					}else{
						row.add("");
					}
					if (pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null){
						java.sql.Date frf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().getTime());
						row.add(format2.format(frf));//Fecha Recepcion Fabrica
					}else{
						row.add("");
					}
	
					datosTabla_piezas_llegadas.add(row);
				}
			}
		}
		modelo_tabla_piezas_llegadas.setDataVector(datosTabla_piezas_llegadas, nombreColumnas_piezas_llegadas);
		modelo_tabla_piezas_llegadas.fireTableStructureChanged();
		
		for(int i = 0; i < tablaPiezas_Llegadas.getColumnCount(); i++) {
			tablaPiezas_Llegadas.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_piezas_llegadas.elementAt(i));
			tablaPiezas_Llegadas.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_piezas_llegadas.elementAt(i));
		}
	}

	protected void filtrarMesAnteriorPLL() {
		SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(c.SUNDAY);
		c.add(c.MONTH, -1);
		Calendar d = Calendar.getInstance();
		d.setFirstDayOfWeek(d.SUNDAY);
		d.add(d.MONTH, -1);

		c.set(c.DAY_OF_MONTH,1);
		java.util.Date iniMesPasado = c.getTime();
		
		d.set(d.DAY_OF_MONTH,d.getMaximum(d.DAY_OF_MONTH));
		
		java.util.Date finMesPasado = d.getTime();
		 
		datosTabla_piezas_llegadas= new Vector<Vector<String>>();
		
		for (int i=0; i< pedidos_piezas.size();i++){
			boolean resp = false;
			if (mediador.esEntidad(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante())){
				resp = pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getDevolucion_pieza()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null;
			}else{
				resp = pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getFecha_envio_agente()==null  && pedidos_piezas.elementAt(i).getDevolucion_pieza()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null;
			}					
			if(resp){
				
				if(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().after(iniMesPasado) &&  pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().before(finMesPasado)){
					Vector<String> row = new Vector<String> ();
	
					row.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
					row.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
					row.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
					row.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
					row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
					
					if(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido()!=null){
						java.sql.Date fsp = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido().getTime());
						row.add(format2.format(fsp));//Fecha Solicitud Pedido
					}else{
						row.add("");
					}			    
					
					if (pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null){
						java.sql.Date fsf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica().getTime());
						row.add(format2.format(fsf));//Fecha Solicitud Fabrica
					}else{
						row.add("");
					}
					if (pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null){
						java.sql.Date frf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().getTime());
						row.add(format2.format(frf));//Fecha Recepcion Fabrica
					}else{
						row.add("");
					}
	
					datosTabla_piezas_llegadas.add(row);
				}
			}
		}
		modelo_tabla_piezas_llegadas.setDataVector(datosTabla_piezas_llegadas, nombreColumnas_piezas_llegadas);
		modelo_tabla_piezas_llegadas.fireTableStructureChanged();
		
		for(int i = 0; i < tablaPiezas_Llegadas.getColumnCount(); i++) {
			tablaPiezas_Llegadas.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_piezas_llegadas.elementAt(i));
			tablaPiezas_Llegadas.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_piezas_llegadas.elementAt(i));
		}		
	}
	
	private void filtrarIntervaloPLL() {
		if(dC_FInicioPLL.getDate()!=null && dC_FFinPLL.getDate()!=null){
			SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy");
			datosTabla_piezas_llegadas= new Vector<Vector<String>>();
			
			for (int i=0; i< pedidos_piezas.size();i++){
				boolean resp = false;
				if (mediador.esEntidad(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante())){
					resp = pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getDevolucion_pieza()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null;
				}else{
					resp = pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null && pedidos_piezas.elementAt(i).getFecha_envio_agente()==null  && pedidos_piezas.elementAt(i).getDevolucion_pieza()==null && pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null;
				}					
				if(resp){
					Calendar c = new GregorianCalendar();
					c.setTime(dC_FInicioPLL.getDate());
					c.add(c.DAY_OF_MONTH, -1);
					if(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().after(c.getTime()) &&  pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().before(dC_FFinPLL.getDate())){
						Vector<String> row = new Vector<String> ();
		
						row.add(pedidos_piezas.elementAt(i).getPedido().getId().toString());//ID Pedido
						row.add(pedidos_piezas.elementAt(i).getNumero_pedido());//Numero Pedido
						row.add(pedidos_piezas.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
						row.add(pedidos_piezas.elementAt(i).getPieza().getDescripcion());//Descripcion Pieza
						row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
						row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getVehiculo().getVin());//VIN
						row.add(pedidos_piezas.elementAt(i).getPedido().getReclamo().getRegistrante().getNombre_registrante());//Registrante
						
						if(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido()!=null){
							java.sql.Date fsp = new java.sql.Date(pedidos_piezas.elementAt(i).getPedido().getFecha_solicitud_pedido().getTime());
							row.add(format2.format(fsp));//Fecha Solicitud Pedido
						}else{
							row.add("");
						}			    
						
						if (pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica()!=null){
							java.sql.Date fsf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_solicitud_fabrica().getTime());
							row.add(format2.format(fsf));//Fecha Solicitud Fabrica
						}else{
							row.add("");
						}
						if (pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica()!=null){
							java.sql.Date frf = new java.sql.Date(pedidos_piezas.elementAt(i).getFecha_recepcion_fabrica().getTime());
							row.add(format2.format(frf));//Fecha Recepcion Fabrica
						}else{
							row.add("");
						}
						datosTabla_piezas_llegadas.add(row);
					}
				}
			}
			modelo_tabla_piezas_llegadas.setDataVector(datosTabla_piezas_llegadas, nombreColumnas_piezas_llegadas);
			modelo_tabla_piezas_llegadas.fireTableStructureChanged();
			
			for(int i = 0; i < tablaPiezas_Llegadas.getColumnCount(); i++) {
				tablaPiezas_Llegadas.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_piezas_llegadas.elementAt(i));
				tablaPiezas_Llegadas.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_piezas_llegadas.elementAt(i));
			}	
		}else{
			JOptionPane.showMessageDialog(this,"Algunos campos estan vacios.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	//Fin filtros
	
	//gettes and setters
	public MediadorReportes getMediador() {
		return mediador;
	}

	public void setMediador(MediadorReportes mediador) {
		this.mediador = mediador;
	}

	public float getSum_frecurso_fcierre() {
		return sum_frecurso_fcierre;
	}

	public void setSum_frecurso_fcierre(float sum_frecurso_fcierre) {
		this.sum_frecurso_fcierre = sum_frecurso_fcierre;
	}

	public float getN_casos() {
		return N_casos;
	}

	public void setN_casos(float n_casos) {
		N_casos = n_casos;
	}
}
