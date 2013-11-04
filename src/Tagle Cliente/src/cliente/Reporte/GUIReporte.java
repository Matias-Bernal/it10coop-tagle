package cliente.Reporte;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class GUIReporte extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private MediadorReporte mediador;

	private JPanel contentPane;
	private JDateChooser dcFechaInicioPDev;
	private JDateChooser dcFechaFinPDev;
	private JRadioButton rbIntervaloPDev;
	private JRadioButton rbUltimoAnioPDev;
	private JTable tablaPiezasDevueltas;
	private JRadioButton rbHoyPDev;
	private JRadioButton rbUltimaSemanaPDev;
	private JRadioButton rbUltimoMesPDev;
	private JTable tablaDiasDesdeFRF;
	private JTable tablaDiasDesdeFSF;
	private JTable tablaDiff_FCierreOT_FTruno;
	private JDateChooser dC_SLL_fin;
	private JDateChooser dC_SLL_inicio;
	private JRadioButton rB_SLL_Intervalo;
	private JRadioButton rB_SLL_Hoy;
	private JRadioButton rB_SLL_Semana;
	private JRadioButton rB_SLL_Mes;
	private JRadioButton rB_SLL_Anio;
	private JRadioButton rB_SLL_MesPasado;
	private JTable tabla_piezas_sin_llegar;

	public GUIReporte() {
		initialize();
	}

	public GUIReporte(MediadorReporte mediadorReporte) {
		setMediador(mediadorReporte);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setTitle("REPORTES");
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane propios = new JTabbedPane(JTabbedPane.TOP);
		propios.setBounds(0, 0, 1239, 681);
		contentPane.add(propios);
		
		JPanel pnControl = new JPanel();
		propios.addTab("CONTROL", null, pnControl, null);
		pnControl.setLayout(null);
		
		JTabbedPane conrol = new JTabbedPane(JTabbedPane.TOP);
		conrol.setBounds(0, 0, 1234, 653);
		pnControl.add(conrol);
		
		JPanel pnDiasDesdeFSF = new JPanel();
		conrol.addTab("DIAS TRANSCURRIDOS DESDE EL PEDIDO A FABRICA", null, pnDiasDesdeFSF, null);
		pnDiasDesdeFSF.setLayout(null);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(0, 0, 1229, 625);
		pnDiasDesdeFSF.add(scrollPane_6);
		
		tablaDiasDesdeFSF = new JTable();
		scrollPane_6.setViewportView(tablaDiasDesdeFSF);
		
		JPanel pnDiasDesdeFRF = new JPanel();
		conrol.addTab("DIAS TRANSCURRIDOS DESDE LA RECEPCION DEL PEDIDO A FABRICA", null, pnDiasDesdeFRF, null);
		pnDiasDesdeFRF.setLayout(null);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(0, 0, 1229, 625);
		pnDiasDesdeFRF.add(scrollPane_7);
		
		tablaDiasDesdeFRF = new JTable();
		scrollPane_7.setViewportView(tablaDiasDesdeFRF);
		
		JPanel pnReclamosVsPedidos = new JPanel();
		conrol.addTab("NUMERO RECLAMOS VS NUMERO PEDIDOS", null, pnReclamosVsPedidos, null);
		pnReclamosVsPedidos.setLayout(null);
		
		JRadioButton radioButton = new JRadioButton("Intervalo de Fechas");
		radioButton.setBounds(6, 11, 150, 25);
		pnReclamosVsPedidos.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Hoy");
		radioButton_1.setBounds(6, 41, 150, 25);
		pnReclamosVsPedidos.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("Ultima Semana");
		radioButton_2.setBounds(6, 71, 150, 25);
		pnReclamosVsPedidos.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("Ultimo Mes");
		radioButton_3.setBounds(6, 101, 150, 25);
		pnReclamosVsPedidos.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("Ultimo A\u00F1o");
		radioButton_4.setBounds(6, 131, 150, 25);
		pnReclamosVsPedidos.add(radioButton_4);
		
		JLabel label = new JLabel("Fecha Inicio");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setEnabled(false);
		label.setBounds(161, 11, 120, 25);
		pnReclamosVsPedidos.add(label);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setEnabled(false);
		dateChooser.setBounds(291, 11, 150, 25);
		pnReclamosVsPedidos.add(dateChooser);
		
		JLabel label_1 = new JLabel("Fecha Fin");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setEnabled(false);
		label_1.setBounds(461, 11, 120, 25);
		pnReclamosVsPedidos.add(label_1);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setEnabled(false);
		dateChooser_1.setBounds(591, 11, 150, 25);
		pnReclamosVsPedidos.add(dateChooser_1);
		
		JPanel pnDiasDesdeFCierreyFturno = new JPanel();
		conrol.addTab("DIAS TRASNCURRIDOS DESDE F.CIERRE ORDEN Y F.TURNO", null, pnDiasDesdeFCierreyFturno, null);
		pnDiasDesdeFCierreyFturno.setLayout(null);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(0, 0, 1229, 625);
		pnDiasDesdeFCierreyFturno.add(scrollPane_8);
		
		tablaDiff_FCierreOT_FTruno = new JTable();
		scrollPane_8.setViewportView(tablaDiff_FCierreOT_FTruno);
		
		JPanel pnProm_FRecurso_FCierreOT = new JPanel();
		conrol.addTab("DIAS ENTRE F.RECURSO Y F.ORDEN", null, pnProm_FRecurso_FCierreOT, null);
		pnProm_FRecurso_FCierreOT.setLayout(null);
		
		JPanel pnGestion = new JPanel();
		propios.addTab("GESTION", null, pnGestion, null);
		pnGestion.setLayout(null);
		
		JTabbedPane gestion = new JTabbedPane(JTabbedPane.TOP);
		gestion.setBounds(0, 0, 1234, 653);
		pnGestion.add(gestion);
		
		JPanel pnPiezasPedidasSinLLegar = new JPanel();
		gestion.addTab("PIEZAS PEDIDAS SIN LLEGAR", null, pnPiezasPedidasSinLLegar, null);
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
		rB_SLL_Intervalo.setBounds(5, 10, 150, 25);
		pnPiezasPedidasSinLLegar.add(rB_SLL_Intervalo);
		
		rB_SLL_Hoy = new JRadioButton("Hoy");
		rB_SLL_Hoy.setBounds(5, 40, 150, 25);
		pnPiezasPedidasSinLLegar.add(rB_SLL_Hoy);
		
		rB_SLL_Semana = new JRadioButton("Ultima Semana");
		rB_SLL_Semana.setBounds(5, 70, 150, 25);
		pnPiezasPedidasSinLLegar.add(rB_SLL_Semana);
		
		rB_SLL_Mes = new JRadioButton("Ultimo Mes");
		rB_SLL_Mes.setBounds(5, 100, 150, 25);
		pnPiezasPedidasSinLLegar.add(rB_SLL_Mes);
		
		rB_SLL_Anio = new JRadioButton("Ultimo A\u00F1o");
		rB_SLL_Anio.setBounds(5, 160, 150, 25);
		pnPiezasPedidasSinLLegar.add(rB_SLL_Anio);
		
		rB_SLL_MesPasado = new JRadioButton("Mes Anterior");
		rB_SLL_MesPasado.setBounds(5, 130, 150, 25);
		pnPiezasPedidasSinLLegar.add(rB_SLL_MesPasado);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(0, 200, 1229, 465);
		pnPiezasPedidasSinLLegar.add(scrollPane_5);
		
		tabla_piezas_sin_llegar = new JTable();
		scrollPane_5.setViewportView(tabla_piezas_sin_llegar);
		
		JPanel pnPiezasDevueltas = new JPanel();
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
		rbIntervaloPDev.setBounds(5, 10, 150, 25);
		pnPiezasDevueltas.add(rbIntervaloPDev);
		
		rbHoyPDev = new JRadioButton("Hoy");
		rbHoyPDev.setBounds(5, 40, 150, 25);
		pnPiezasDevueltas.add(rbHoyPDev);
		
		rbUltimaSemanaPDev = new JRadioButton("Ultima Semana");
		rbUltimaSemanaPDev.setBounds(5, 70, 150, 25);
		pnPiezasDevueltas.add(rbUltimaSemanaPDev);
		
		rbUltimoMesPDev = new JRadioButton("Ultimo Mes");
		rbUltimoMesPDev.setBounds(5, 100, 150, 25);
		pnPiezasDevueltas.add(rbUltimoMesPDev);
		
		rbUltimoAnioPDev = new JRadioButton("Ultimo A\u00F1o");
		rbUltimoAnioPDev.setBounds(5, 130, 150, 25);
		pnPiezasDevueltas.add(rbUltimoAnioPDev);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 160, 1229, 465);
		pnPiezasDevueltas.add(scrollPane);
		
		tablaPiezasDevueltas = new JTable();
		scrollPane.setViewportView(tablaPiezasDevueltas);
		
		JPanel pnPiezaLLegadas = new JPanel();
		gestion.addTab("PIEZAS LLEGADAS", null, pnPiezaLLegadas, null);
		pnPiezaLLegadas.setLayout(null);
		
		JRadioButton radioButton_5 = new JRadioButton("Intervalo de Fechas");
		radioButton_5.setBounds(5, 11, 150, 25);
		pnPiezaLLegadas.add(radioButton_5);
		
		JRadioButton radioButton_6 = new JRadioButton("Hoy");
		radioButton_6.setBounds(5, 41, 150, 25);
		pnPiezaLLegadas.add(radioButton_6);
		
		JRadioButton radioButton_7 = new JRadioButton("Ultima Semana");
		radioButton_7.setBounds(5, 71, 150, 25);
		pnPiezaLLegadas.add(radioButton_7);
		
		JRadioButton radioButton_8 = new JRadioButton("Ultimo Mes");
		radioButton_8.setBounds(5, 101, 150, 25);
		pnPiezaLLegadas.add(radioButton_8);
		
		JRadioButton radioButton_9 = new JRadioButton("Ultimo A\u00F1o");
		radioButton_9.setBounds(5, 131, 150, 25);
		pnPiezaLLegadas.add(radioButton_9);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 161, 1229, 465);
		pnPiezaLLegadas.add(scrollPane_3);
		
		JLabel label_2 = new JLabel("Fecha Inicio");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setEnabled(false);
		label_2.setBounds(160, 11, 120, 25);
		pnPiezaLLegadas.add(label_2);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setEnabled(false);
		dateChooser_2.setBounds(290, 11, 150, 25);
		pnPiezaLLegadas.add(dateChooser_2);
		
		JLabel label_3 = new JLabel("Fecha Fin");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setEnabled(false);
		label_3.setBounds(460, 11, 120, 25);
		pnPiezaLLegadas.add(label_3);
		
		JDateChooser dateChooser_3 = new JDateChooser();
		dateChooser_3.setEnabled(false);
		dateChooser_3.setBounds(590, 11, 150, 25);
		pnPiezaLLegadas.add(dateChooser_3);
		
		JPanel pnPiezasLLegadasSinTurno = new JPanel();
		gestion.addTab("PIEZAS LLEGADAS SIN TURNO", null, pnPiezasLLegadasSinTurno, null);
		pnPiezasLLegadasSinTurno.setLayout(null);
		
		JDateChooser dateChooser_6 = new JDateChooser();
		dateChooser_6.setEnabled(false);
		dateChooser_6.setBounds(290, 10, 150, 25);
		pnPiezasLLegadasSinTurno.add(dateChooser_6);
		
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
		
		JDateChooser dateChooser_7 = new JDateChooser();
		dateChooser_7.setEnabled(false);
		dateChooser_7.setBounds(590, 10, 150, 25);
		pnPiezasLLegadasSinTurno.add(dateChooser_7);
		
		JRadioButton radioButton_15 = new JRadioButton("Intervalo de Fechas");
		radioButton_15.setBounds(5, 10, 150, 25);
		pnPiezasLLegadasSinTurno.add(radioButton_15);
		
		JRadioButton radioButton_16 = new JRadioButton("Hoy");
		radioButton_16.setBounds(5, 40, 150, 25);
		pnPiezasLLegadasSinTurno.add(radioButton_16);
		
		JRadioButton radioButton_17 = new JRadioButton("Ultima Semana");
		radioButton_17.setBounds(5, 70, 150, 25);
		pnPiezasLLegadasSinTurno.add(radioButton_17);
		
		JRadioButton radioButton_18 = new JRadioButton("Ultimo Mes");
		radioButton_18.setBounds(5, 100, 150, 25);
		pnPiezasLLegadasSinTurno.add(radioButton_18);
		
		JRadioButton radioButton_19 = new JRadioButton("Ultimo A\u00F1o");
		radioButton_19.setBounds(5, 130, 150, 25);
		pnPiezasLLegadasSinTurno.add(radioButton_19);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(0, 160, 1229, 465);
		pnPiezasLLegadasSinTurno.add(scrollPane_9);
		
		JPanel pnOrdenSinSDP = new JPanel();
		gestion.addTab("ORDEN SIN SOLICITUD DE PEDIDO", null, pnOrdenSinSDP, null);
		pnOrdenSinSDP.setLayout(null);
		
		JDateChooser dateChooser_8 = new JDateChooser();
		dateChooser_8.setEnabled(false);
		dateChooser_8.setBounds(290, 10, 150, 25);
		pnOrdenSinSDP.add(dateChooser_8);
		
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
		
		JDateChooser dateChooser_9 = new JDateChooser();
		dateChooser_9.setEnabled(false);
		dateChooser_9.setBounds(590, 10, 150, 25);
		pnOrdenSinSDP.add(dateChooser_9);
		
		JRadioButton radioButton_20 = new JRadioButton("Intervalo de Fechas");
		radioButton_20.setBounds(5, 10, 150, 25);
		pnOrdenSinSDP.add(radioButton_20);
		
		JRadioButton radioButton_21 = new JRadioButton("Hoy");
		radioButton_21.setBounds(5, 40, 150, 25);
		pnOrdenSinSDP.add(radioButton_21);
		
		JRadioButton radioButton_22 = new JRadioButton("Ultima Semana");
		radioButton_22.setBounds(5, 70, 150, 25);
		pnOrdenSinSDP.add(radioButton_22);
		
		JRadioButton radioButton_23 = new JRadioButton("Ultimo Mes");
		radioButton_23.setBounds(5, 100, 150, 25);
		pnOrdenSinSDP.add(radioButton_23);
		
		JRadioButton radioButton_24 = new JRadioButton("Ultimo A\u00F1o");
		radioButton_24.setBounds(5, 130, 150, 25);
		pnOrdenSinSDP.add(radioButton_24);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(0, 160, 1229, 465);
		pnOrdenSinSDP.add(scrollPane_4);
		
		JPanel pnSDPsinNumPedido = new JPanel();
		pnSDPsinNumPedido.setLayout(null);
		gestion.addTab("SOLICITUD DE PEDIDO SIN NUMERO DE PEDIDO", null, pnSDPsinNumPedido, null);
		
		JDateChooser dateChooser_10 = new JDateChooser();
		dateChooser_10.setEnabled(false);
		dateChooser_10.setBounds(290, 10, 150, 25);
		pnSDPsinNumPedido.add(dateChooser_10);
		
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
		
		JDateChooser dateChooser_11 = new JDateChooser();
		dateChooser_11.setEnabled(false);
		dateChooser_11.setBounds(590, 10, 150, 25);
		pnSDPsinNumPedido.add(dateChooser_11);
		
		JRadioButton radioButton_25 = new JRadioButton("Intervalo de Fechas");
		radioButton_25.setBounds(5, 10, 150, 25);
		pnSDPsinNumPedido.add(radioButton_25);
		
		JRadioButton radioButton_26 = new JRadioButton("Hoy");
		radioButton_26.setBounds(5, 40, 150, 25);
		pnSDPsinNumPedido.add(radioButton_26);
		
		JRadioButton radioButton_27 = new JRadioButton("Ultima Semana");
		radioButton_27.setBounds(5, 70, 150, 25);
		pnSDPsinNumPedido.add(radioButton_27);
		
		JRadioButton radioButton_28 = new JRadioButton("Ultimo Mes");
		radioButton_28.setBounds(5, 100, 150, 25);
		pnSDPsinNumPedido.add(radioButton_28);
		
		JRadioButton radioButton_29 = new JRadioButton("Ultimo A\u00F1o");
		radioButton_29.setBounds(5, 130, 150, 25);
		pnSDPsinNumPedido.add(radioButton_29);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 160, 1229, 465);
		pnSDPsinNumPedido.add(scrollPane_2);
		
	}

	public MediadorReporte getMediador() {
		return mediador;
	}

	public void setMediador(MediadorReporte mediador) {
		this.mediador = mediador;
	}
}
