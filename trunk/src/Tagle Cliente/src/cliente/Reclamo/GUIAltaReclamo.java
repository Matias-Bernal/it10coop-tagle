package cliente.Reclamo;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import com.toedter.calendar.JDateChooser;

import common.DTOs.OrdenDTO;
import common.DTOs.ReclamanteDTO;
import common.DTOs.VehiculoDTO;

public class GUIAltaReclamo extends JFrame{

	private static final long serialVersionUID = 1L;
	private MediadoReclamoRapido mediador;
	
	private JTextField tfEmail_E;
	private JTextField tfNombreReclamante_E;
	private JTextField tfDni_E;
	private JTextField tfNombreTitular_E;
	private JTextField tfDominio_E;
	private JTextField tfVin_E;
	private JTextField tfNumeroOrden_E;
	private JTextField tfNumeroOrden_A;
	private JTextField tfEmail_A;
	private JTextField tfNombreReclamante_A;
	private JTextField tfDni_A;
	private JTextField tfNombreTitular_A;
	private JTextField tfDominio_A;
	private JTextField tfVin_A;


	private JButton btnCrear_E;
	private JButton btnCancelar_E;
	private JButton btnCrear_A;
	private JButton btnCancelar_A;
	private JComboBox<String> cbEntidad;
	private Vector<String> entidades;
	private JComboBox<String> cbTelefonos_E;
	private Vector<String> telefonos;
	private JButton btnAgregarTelefono_E;
	private JButton btnBuscarReclamante_E;
	private boolean reclamante_desdeEntidad;
	private JButton btnQuitarTelefono_E;
	private JRadioButton rbCelular_E;
	private JRadioButton rbFijo_E;

	private JButton btnBuscarVehiculo_E;
	private boolean vehiculo_desdeEntidad;
	private JComboBox<String> cbMarca_E;
	private Vector<String> marcas;
	private JCheckBox cBPeligroso;
	private JComboBox<String> cbModelo_E;
	private Vector<String> modelos;
	private JCheckBox cBInmovilizado;

	private JDateChooser dCFecha_Apertura_E;
	private JButton btnBuscarOrden_E;
	private boolean orden_desdeEntidad;
	private JDateChooser dCFecha_Reclamo_E;
	private JTextArea tADescripcion_E;
	private JComboBox<String> cbAgente;
	private Vector<String> agentes;
	private JButton btnBuscarReclamante_A;
	private JComboBox<String> cbTelefonos_A;
	private JButton btnAgregarTelefono_A;
	private JButton btnQuitarTelefono_A;
	private JRadioButton rbCelular_A;
	private JRadioButton rbFijo_A;
	private JButton btnBuscarVehiculo_A;
	private JComboBox<String> cbMarca_A;
	private JComboBox<String> cbModelo_A;
	private JDateChooser dCFecha_Apertura_A;
	private JDateChooser dCFecha_Reclamo_A;
	private JTextArea tADescripcion_A;
	private JButton btnLimpiar_E;
	private JButton btnLimpiar_A;
	
	public GUIAltaReclamo(MediadoReclamoRapido mediadoReclamoRapido) {
		this.mediador = mediadoReclamoRapido;
		cargarDatos();
		initialize();
	}
	
	private void cargarDatos() {
		entidades = mediador.obtenerNombresEntidades();
		agentes = mediador.obtenerNombresAgentes();
		marcas = mediador.obtenerNombresMarcas();
		modelos = mediador.obtenerNombresModelos();
	}
	
	public void initialize(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1037, 500);
		setTitle("ALTA RECLAMO");
		setResizable(false);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setSize(new Dimension(111, 0));
		tabbedPane.setBounds(10, 11, 1015, 450);
		getContentPane().add(tabbedPane);
		
		JPanel entidad = new JPanel();
		tabbedPane.addTab("ENTIDAD", null, entidad, null);
		entidad.setLayout(null);
		
		JPanel selecEntidad = new JPanel();
		selecEntidad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		selecEntidad.setBounds(10, 11, 490, 42);
		entidad.add(selecEntidad);
		selecEntidad.setLayout(null);
		
		JLabel lblEntidad = new JLabel("ENTIDAD");
		lblEntidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntidad.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEntidad.setBounds(10, 11, 140, 19);
		selecEntidad.add(lblEntidad);
		
		cbEntidad = new JComboBox<String>();
		cbEntidad.setModel(new DefaultComboBoxModel<String>(entidades));
		cbEntidad.setBounds(160, 11, 200, 20);
		selecEntidad.add(cbEntidad);
		
		JPanel selectReclamanteEntidad = new JPanel();
		selectReclamanteEntidad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		selectReclamanteEntidad.setLayout(null);
		selectReclamanteEntidad.setBounds(10, 55, 490, 181);
		entidad.add(selectReclamanteEntidad);
		
		JLabel lbnombreReclamante_E = new JLabel("Nombre Del Reclamante");
		lbnombreReclamante_E.setHorizontalAlignment(SwingConstants.CENTER);
		lbnombreReclamante_E.setBounds(10, 11, 139, 20);
		selectReclamanteEntidad.add(lbnombreReclamante_E);
		
		JLabel lblEmail_E = new JLabel("Email");
		lblEmail_E.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail_E.setBounds(10, 42, 139, 20);
		selectReclamanteEntidad.add(lblEmail_E);
		
		tfEmail_E = new JTextField();
		tfEmail_E.setColumns(10);
		tfEmail_E.setBounds(160, 42, 200, 20);
		selectReclamanteEntidad.add(tfEmail_E);
		
		tfNombreReclamante_E = new JTextField();
		tfNombreReclamante_E.setColumns(10);
		tfNombreReclamante_E.setBounds(160, 11, 200, 20);
		selectReclamanteEntidad.add(tfNombreReclamante_E);
		
		JLabel lblDni_E = new JLabel("DNI");
		lblDni_E.setHorizontalAlignment(SwingConstants.CENTER);
		lblDni_E.setBounds(10, 72, 139, 20);
		selectReclamanteEntidad.add(lblDni_E);
		
		JLabel lblTelefonos_E = new JLabel("Telefonos");
		lblTelefonos_E.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefonos_E.setBounds(10, 103, 139, 20);
		selectReclamanteEntidad.add(lblTelefonos_E);
		
		cbTelefonos_E = new JComboBox<String>();
		cbTelefonos_E.setEditable(true);
		cbTelefonos_E.setBounds(160, 103, 120, 20);
		selectReclamanteEntidad.add(cbTelefonos_E);
		
		tfDni_E = new JTextField();
		tfDni_E.setColumns(10);
		tfDni_E.setBounds(160, 72, 120, 20);
		selectReclamanteEntidad.add(tfDni_E);
		
		btnAgregarTelefono_E = new JButton("Agregar");
		btnAgregarTelefono_E.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregarTelefono_E.setBounds(290, 102, 90, 23);
		selectReclamanteEntidad.add(btnAgregarTelefono_E);
		
		btnQuitarTelefono_E = new JButton("Quitar");
		btnQuitarTelefono_E.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnQuitarTelefono_E.setBounds(290, 129, 90, 23);
		selectReclamanteEntidad.add(btnQuitarTelefono_E);
		
		rbCelular_E = new JRadioButton("Celular");
		rbCelular_E.setBounds(160, 129, 120, 23);
		selectReclamanteEntidad.add(rbCelular_E);
		
		rbFijo_E = new JRadioButton("Fijo");
		rbFijo_E.setBounds(160, 155, 120, 23);
		selectReclamanteEntidad.add(rbFijo_E);
		
		btnBuscarReclamante_E = new JButton("Buscar");
		btnBuscarReclamante_E.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reclamante_desdeEntidad = true;
				mediador.buscarReclamante();
			}
		});
		btnBuscarReclamante_E.setBounds(366, 10, 89, 23);
		selectReclamanteEntidad.add(btnBuscarReclamante_E);
		
		JPanel selectVehiculoEntidad = new JPanel();
		selectVehiculoEntidad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		selectVehiculoEntidad.setBounds(10, 241, 490, 175);
		entidad.add(selectVehiculoEntidad);
		selectVehiculoEntidad.setLayout(null);
		
		JLabel lblNombreTitular_E = new JLabel("Nombre del Titular");
		lblNombreTitular_E.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreTitular_E.setBounds(10, 12, 130, 20);
		selectVehiculoEntidad.add(lblNombreTitular_E);
		
		tfNombreTitular_E = new JTextField();
		tfNombreTitular_E.setColumns(10);
		tfNombreTitular_E.setBounds(160, 12, 200, 20);
		selectVehiculoEntidad.add(tfNombreTitular_E);
		
		tfDominio_E = new JTextField();
		tfDominio_E.setColumns(10);
		tfDominio_E.setBounds(160, 42, 79, 20);
		selectVehiculoEntidad.add(tfDominio_E);
		
		JLabel lblDominio_E = new JLabel("Dominio");
		lblDominio_E.setHorizontalAlignment(SwingConstants.CENTER);
		lblDominio_E.setBounds(10, 42, 130, 20);
		selectVehiculoEntidad.add(lblDominio_E);
		
		JLabel lvlVin_E = new JLabel("VIN");
		lvlVin_E.setHorizontalAlignment(SwingConstants.CENTER);
		lvlVin_E.setBounds(10, 72, 130, 20);
		selectVehiculoEntidad.add(lvlVin_E);
		
		tfVin_E = new JTextField();
		tfVin_E.setColumns(10);
		tfVin_E.setBounds(160, 73, 155, 20);
		selectVehiculoEntidad.add(tfVin_E);
		
		JLabel label_3 = new JLabel("Marca");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(10, 103, 130, 20);
		selectVehiculoEntidad.add(label_3);
		
		cbMarca_E = new JComboBox<String>();
		cbMarca_E.setModel(new DefaultComboBoxModel<String>(marcas));
		cbMarca_E.setBounds(160, 103, 155, 20);
		selectVehiculoEntidad.add(cbMarca_E);
		
		JLabel label_4 = new JLabel("Modelo");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(10, 133, 130, 20);
		selectVehiculoEntidad.add(label_4);
		
		cbModelo_E = new JComboBox<String>();
		cbModelo_E.setModel(new DefaultComboBoxModel<String>(modelos));
		cbModelo_E.setBounds(160, 133, 155, 20);
		selectVehiculoEntidad.add(cbModelo_E);
		
		btnBuscarVehiculo_E = new JButton("Buscar");
		btnBuscarVehiculo_E.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vehiculo_desdeEntidad = true;
				mediador.buscarVehiculo();
			}
		});
		btnBuscarVehiculo_E.setBounds(366, 11, 89, 23);
		selectVehiculoEntidad.add(btnBuscarVehiculo_E);
		
		cBPeligroso = new JCheckBox("PELIGROSO");
		cBPeligroso.setBounds(358, 103, 126, 23);
		selectVehiculoEntidad.add(cBPeligroso);
		
		cBInmovilizado = new JCheckBox("INMOVILIZADO");
		cBInmovilizado.setBounds(358, 133, 126, 23);
		selectVehiculoEntidad.add(cBInmovilizado);
		
		JPanel selectOrdenEntidad = new JPanel();
		selectOrdenEntidad.setBounds(510, 11, 490, 85);
		entidad.add(selectOrdenEntidad);
		selectOrdenEntidad.setLayout(null);
		selectOrdenEntidad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel label_2 = new JLabel("Fecha Apertura");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(10, 42, 130, 20);
		selectOrdenEntidad.add(label_2);
		
		dCFecha_Apertura_E = new JDateChooser();
		dCFecha_Apertura_E.setBounds(160, 42, 155, 20);
		selectOrdenEntidad.add(dCFecha_Apertura_E);
		
		tfNumeroOrden_E = new JTextField();
		tfNumeroOrden_E.setColumns(10);
		tfNumeroOrden_E.setBounds(160, 11, 200, 20);
		selectOrdenEntidad.add(tfNumeroOrden_E);
		
		JLabel label_10 = new JLabel("Numero Orden");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(10, 12, 130, 20);
		selectOrdenEntidad.add(label_10);
		
		btnBuscarOrden_E = new JButton("Buscar");
		btnBuscarOrden_E.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orden_desdeEntidad = true;
				mediador.buscarOrden();
			}
		});
		btnBuscarOrden_E.setBounds(366, 10, 89, 23);
		selectOrdenEntidad.add(btnBuscarOrden_E);
		
		JPanel selectReclamoEntidad = new JPanel();
		selectReclamoEntidad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		selectReclamoEntidad.setBounds(510, 100, 490, 121);
		entidad.add(selectReclamoEntidad);
		selectReclamoEntidad.setLayout(null);
		
		dCFecha_Reclamo_E = new JDateChooser();
		dCFecha_Reclamo_E.setDate(new Date());
		dCFecha_Reclamo_E.setBounds(160, 11, 160, 20);
		selectReclamoEntidad.add(dCFecha_Reclamo_E);
		
		JLabel label_11 = new JLabel("Fecha Reclamo");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(10, 11, 130, 20);
		selectReclamoEntidad.add(label_11);
		
		JLabel label_12 = new JLabel("Descripcion");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(10, 44, 130, 20);
		selectReclamoEntidad.add(label_12);
		
		tADescripcion_E = new JTextArea(4, 31);
		tADescripcion_E.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tADescripcion_E.setLineWrap(true);
		tADescripcion_E.setBounds(160, 42, 256, 72);
		selectReclamoEntidad.add(tADescripcion_E);
		
		btnCrear_E = new JButton("Crear");
		btnCrear_E.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearReclamoEntidad();
			}
		});
		btnCrear_E.setBounds(600, 300, 130, 23);
		entidad.add(btnCrear_E);
		
		btnCancelar_E = new JButton("Cancelar");
		btnCancelar_E.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar_E.setBounds(780, 300, 130, 23);
		entidad.add(btnCancelar_E);
		
		btnLimpiar_E = new JButton("Limpiar");
		btnLimpiar_E.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiar();
			}
		});
		btnLimpiar_E.setBounds(780, 342, 130, 23);
		entidad.add(btnLimpiar_E);
				
		JPanel agente = new JPanel();
		tabbedPane.addTab("AGENTE", null, agente, null);
		agente.setLayout(null);
		
		JPanel selectAgente = new JPanel();
		selectAgente.setBounds(10, 11, 490, 42);
		agente.add(selectAgente);
		selectAgente.setLayout(null);
		selectAgente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblAgente = new JLabel("AGENTE");
		lblAgente.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAgente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgente.setBounds(10, 11, 140, 19);
		selectAgente.add(lblAgente);
		
		cbAgente = new JComboBox<String>();
		cbAgente.setModel(new DefaultComboBoxModel<String>(agentes));
		cbAgente.setBounds(160, 11, 200, 20);
		selectAgente.add(cbAgente);
		
		JPanel selectReclamanteAgente = new JPanel();
		selectReclamanteAgente.setBounds(10, 55, 490, 181);
		agente.add(selectReclamanteAgente);
		selectReclamanteAgente.setLayout(null);
		selectReclamanteAgente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel label_8 = new JLabel("Nombre Del Reclamante");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(10, 11, 139, 20);
		selectReclamanteAgente.add(label_8);
		
		JLabel label_9 = new JLabel("Email");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(10, 42, 139, 20);
		selectReclamanteAgente.add(label_9);
		
		tfEmail_A = new JTextField();
		tfEmail_A.setColumns(10);
		tfEmail_A.setBounds(160, 42, 200, 20);
		selectReclamanteAgente.add(tfEmail_A);
		
		tfNombreReclamante_A = new JTextField();
		tfNombreReclamante_A.setColumns(10);
		tfNombreReclamante_A.setBounds(160, 11, 200, 20);
		selectReclamanteAgente.add(tfNombreReclamante_A);
		
		JLabel label_13 = new JLabel("DNI");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBounds(10, 72, 139, 20);
		selectReclamanteAgente.add(label_13);
		
		JLabel label_14 = new JLabel("Telefonos");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(10, 103, 139, 20);
		selectReclamanteAgente.add(label_14);
		
		cbTelefonos_A = new JComboBox<String>();
		cbTelefonos_A.setEditable(true);
		cbTelefonos_A.setBounds(160, 103, 120, 20);
		selectReclamanteAgente.add(cbTelefonos_A);
		
		tfDni_A = new JTextField();
		tfDni_A.setColumns(10);
		tfDni_A.setBounds(160, 72, 120, 20);
		selectReclamanteAgente.add(tfDni_A);
		
		btnAgregarTelefono_A = new JButton("Agregar");
		btnAgregarTelefono_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregarTelefono_A.setBounds(290, 102, 90, 23);
		selectReclamanteAgente.add(btnAgregarTelefono_A);
		
		btnQuitarTelefono_A = new JButton("Quitar");
		btnQuitarTelefono_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnQuitarTelefono_A.setBounds(290, 129, 90, 23);
		selectReclamanteAgente.add(btnQuitarTelefono_A);
		
		rbCelular_A = new JRadioButton("Celular");
		rbCelular_A.setBounds(160, 129, 120, 23);
		selectReclamanteAgente.add(rbCelular_A);
		
		rbFijo_A = new JRadioButton("Fijo");
		rbFijo_A.setBounds(160, 155, 120, 23);
		selectReclamanteAgente.add(rbFijo_A);
		
		btnBuscarReclamante_A = new JButton("Buscar");
		btnBuscarReclamante_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reclamante_desdeEntidad = false;
				mediador.buscarReclamante();
			}
		});
		btnBuscarReclamante_A.setBounds(366, 10, 89, 23);
		selectReclamanteAgente.add(btnBuscarReclamante_A);
		
		JPanel selectVehiculoAgente = new JPanel();
		selectVehiculoAgente.setBounds(10, 241, 490, 175);
		agente.add(selectVehiculoAgente);
		selectVehiculoAgente.setLayout(null);
		selectVehiculoAgente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel label_15 = new JLabel("Nombre del Titular");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setBounds(10, 12, 130, 20);
		selectVehiculoAgente.add(label_15);
		
		tfNombreTitular_A = new JTextField();
		tfNombreTitular_A.setColumns(10);
		tfNombreTitular_A.setBounds(160, 12, 200, 20);
		selectVehiculoAgente.add(tfNombreTitular_A);
		
		tfDominio_A = new JTextField();
		tfDominio_A.setColumns(10);
		tfDominio_A.setBounds(160, 42, 79, 20);
		selectVehiculoAgente.add(tfDominio_A);
		
		JLabel label_16 = new JLabel("Dominio");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setBounds(10, 42, 130, 20);
		selectVehiculoAgente.add(label_16);
		
		JLabel label_17 = new JLabel("VIN");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setBounds(10, 72, 130, 20);
		selectVehiculoAgente.add(label_17);
		
		tfVin_A = new JTextField();
		tfVin_A.setColumns(10);
		tfVin_A.setBounds(160, 73, 155, 20);
		selectVehiculoAgente.add(tfVin_A);
		
		JLabel label_18 = new JLabel("Marca");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setBounds(10, 103, 130, 20);
		selectVehiculoAgente.add(label_18);
		
		cbMarca_A = new JComboBox<String>();
		cbMarca_A.setModel(new DefaultComboBoxModel<String>(marcas));
		cbMarca_A.setBounds(160, 103, 155, 20);
		selectVehiculoAgente.add(cbMarca_A);
		
		JLabel label_19 = new JLabel("Modelo");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setBounds(10, 133, 130, 20);
		selectVehiculoAgente.add(label_19);
		
		cbModelo_A = new JComboBox<String>();
		cbModelo_A.setModel(new DefaultComboBoxModel<String>(modelos));
		cbModelo_A.setBounds(160, 133, 155, 20);
		selectVehiculoAgente.add(cbModelo_A);
		
		btnBuscarVehiculo_A = new JButton("Buscar");
		btnBuscarVehiculo_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vehiculo_desdeEntidad = false;
				mediador.buscarVehiculo();
			}
		});
		btnBuscarVehiculo_A.setBounds(366, 11, 89, 23);
		selectVehiculoAgente.add(btnBuscarVehiculo_A);
		
		JPanel selectOrdenAgente = new JPanel();
		selectOrdenAgente.setLayout(null);
		selectOrdenAgente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		selectOrdenAgente.setBounds(510, 11, 490, 85);
		agente.add(selectOrdenAgente);
		
		JLabel label_5 = new JLabel("Fecha Apertura");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(10, 42, 130, 20);
		selectOrdenAgente.add(label_5);
		
		dCFecha_Apertura_A = new JDateChooser();
		dCFecha_Apertura_A.setBounds(160, 42, 155, 20);
		selectOrdenAgente.add(dCFecha_Apertura_A);
		
		tfNumeroOrden_A = new JTextField();
		tfNumeroOrden_A.setColumns(10);
		tfNumeroOrden_A.setBounds(160, 11, 200, 20);
		selectOrdenAgente.add(tfNumeroOrden_A);
		
		JLabel label_6 = new JLabel("Numero Orden");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(10, 12, 130, 20);
		selectOrdenAgente.add(label_6);
		
		JButton btnBuscarOrden_A = new JButton("Buscar");
		btnBuscarOrden_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orden_desdeEntidad = false;
				mediador.buscarOrden();
			}
		});
		btnBuscarOrden_A.setBounds(366, 10, 89, 23);
		selectOrdenAgente.add(btnBuscarOrden_A);
		
		JPanel selectReclamoAgente = new JPanel();
		selectReclamoAgente.setBounds(510, 100, 490, 121);
		agente.add(selectReclamoAgente);
		selectReclamoAgente.setLayout(null);
		selectReclamoAgente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		dCFecha_Reclamo_A = new JDateChooser();
		dCFecha_Reclamo_A.setDate(new Date());
		dCFecha_Reclamo_A.setBounds(160, 11, 160, 20);
		selectReclamoAgente.add(dCFecha_Reclamo_A);
		
		JLabel label_22 = new JLabel("Fecha Reclamo");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setBounds(10, 11, 130, 20);
		selectReclamoAgente.add(label_22);
		
		JLabel label_23 = new JLabel("Descripcion");
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setBounds(10, 44, 130, 20);
		selectReclamoAgente.add(label_23);
		
		tADescripcion_A = new JTextArea(4, 31);
		tADescripcion_A.setLineWrap(true);
		tADescripcion_A.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tADescripcion_A.setBounds(160, 42, 256, 72);
		selectReclamoAgente.add(tADescripcion_A);
		
		btnCrear_A = new JButton("Crear");
		btnCrear_A.setBounds(600, 300, 130, 23);
		agente.add(btnCrear_A);
		
		btnCancelar_A = new JButton("Cancelar");
		btnCancelar_A.setBounds(780, 300, 130, 23);
		agente.add(btnCancelar_A);
		
		btnLimpiar_A = new JButton("Limpiar");
		btnLimpiar_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar_A.setBounds(780, 342, 130, 23);
		agente.add(btnLimpiar_A);
		btnCancelar_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCrear_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearReclamoAgente();
			}
		});
	}
	
	public boolean chequearCamposEntidad(){
		boolean res = false;
		res = (cbEntidad.getSelectedItem()==null || tfNombreReclamante_E.getText().isEmpty() || tfDni_E.getText().isEmpty() 
				|| cbTelefonos_E.getModel().getSize()<1 || tfNombreTitular_E.getText().isEmpty() || tfDominio_E.getText().isEmpty()
				|| tfVin_E.getText().isEmpty() || cbMarca_E.getModel().getSize()<1 || cbModelo_E.getModel().getSize()<1 
				|| tfNumeroOrden_E.getText().isEmpty() || dCFecha_Apertura_E.getDate()==null || dCFecha_Reclamo_E.getDate()==null);
		return res;
	}

	protected void crearReclamoEntidad() {
		if (chequearCamposEntidad()){
			JOptionPane.showMessageDialog(this,"Algunos campos estan vacios.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
		}else{
			
			SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 
			String fecha = format2.format(dCFecha_Apertura_E.getDate());
		    java.sql.Date fechaApertura = new java.sql.Date(dCFecha_Apertura_E.getDate().getTime());
		    
			fecha = format2.format(dCFecha_Reclamo_E.getDate());
		    java.sql.Date fechaReclamo = new java.sql.Date(dCFecha_Reclamo_E.getDate().getTime());
		    
		    Vector<String> telefonos_reclamante = new Vector<String>();
		    for (int i = 0;i< cbTelefonos_E.getModel().getSize(); i++){
		    	telefonos_reclamante.add(cbTelefonos_E.getModel().getElementAt(i).toString());
		    }
			if (mediador.nuevoReclamoEntidad(cbEntidad.getSelectedItem().toString(),tfNombreReclamante_E.getText(),tfDni_E.getText(), tfEmail_E.getText(),
				telefonos_reclamante, tfNombreTitular_E.getText(),tfDominio_E.getText(),tfVin_E.getText(),
				cbMarca_E.getSelectedItem().toString(), cbModelo_E.getSelectedItem().toString(),tfNumeroOrden_E.getText(),
				fechaApertura,fechaReclamo,tADescripcion_E.getText(),cBPeligroso.isSelected(),cBInmovilizado.isSelected())){
				JOptionPane.showMessageDialog(this,"Reclamo Agregado.","Notificacion",JOptionPane.INFORMATION_MESSAGE);
				limpiar();
			}else{
				JOptionPane.showMessageDialog(this,"Error al agregar. Inente nuevamente.","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void limpiar() {
		//ENTIDAD
		cbEntidad.setSelectedIndex(0);
		
		tfNombreReclamante_E.setText("");
		tfEmail_E.setText("");
		tfDni_E.setText("");
		telefonos.removeAllElements();
		DefaultComboBoxModel<String> comboBOX_Modelo_E = new DefaultComboBoxModel<String>(telefonos);
		cbTelefonos_E.setModel(comboBOX_Modelo_E);
		
		rbCelular_E.setSelected(false);
		rbFijo_E.setSelected(false);
		reclamante_desdeEntidad=false;
				
		tfNombreTitular_E.setText("");
		tfDominio_E.setText("");
		tfVin_E.setText("");
		cBInmovilizado.setSelected(false);
		cBPeligroso.setSelected(false);
		cbMarca_E.setSelectedIndex(0);
		cbModelo_E.setSelectedIndex(0);
		vehiculo_desdeEntidad=false;
		
		tfNumeroOrden_E.setText("");
		dCFecha_Apertura_E.setDate(null);
		orden_desdeEntidad=false;
		
		dCFecha_Reclamo_E.setDate(new Date());
		tADescripcion_E.setText("");
		//AGENTE
		cbAgente.setSelectedIndex(0);
		
		tfNombreReclamante_A.setText("");
		tfEmail_A.setText("");
		tfDni_A.setText("");
		DefaultComboBoxModel<String> comboBOX_Modelo_A = new DefaultComboBoxModel<String>(telefonos);
		cbTelefonos_A.setModel(comboBOX_Modelo_A);
		rbCelular_A.setSelected(false);
		rbFijo_A.setSelected(false);
				
		tfNombreTitular_A.setText("");
		tfDominio_A.setText("");
		tfVin_A.setText("");
		cbMarca_A.setSelectedIndex(0);
		cbModelo_A.setSelectedIndex(0);
				
		tfNumeroOrden_A.setText("");
		dCFecha_Apertura_A.setDate(null);
				
		dCFecha_Reclamo_A.setDate(new Date());
		tADescripcion_A.setText("");
	}

	public boolean chequearCamposAgente(){
		boolean res = false;
		res = (cbAgente.getSelectedItem()==null || tfNombreReclamante_A.getText().isEmpty() || tfDni_A.getText().isEmpty()
				|| cbTelefonos_A.getModel().getSize()<1 || tfNombreTitular_A.getText().isEmpty() || tfDominio_A.getText().isEmpty()
				|| tfVin_A.getText().isEmpty() || cbMarca_A.getModel().getSize()<1 || cbModelo_A.getModel().getSize()<1 
				|| tfNumeroOrden_A.getText().isEmpty() || dCFecha_Apertura_A.getDate()==null || dCFecha_Reclamo_A.getDate()==null
				|| tADescripcion_A.getText().isEmpty());
		return res;
	}

	protected void crearReclamoAgente() {
		if (chequearCamposAgente()){
			JOptionPane.showMessageDialog(this,"Algunos campos estan vacios.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
		}else{
			
			SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 
			String fecha = format2.format(dCFecha_Apertura_A.getDate());
		    java.sql.Date fechaApertura = new java.sql.Date(dCFecha_Apertura_A.getDate().getTime());
		    
			fecha = format2.format(dCFecha_Reclamo_A.getDate());
		    java.sql.Date fechaReclamo = new java.sql.Date(dCFecha_Reclamo_A.getDate().getTime());
		    
		    Vector<String> telefonos_reclamante = new Vector<String>();
		    for (int i = 0;i< cbTelefonos_A.getModel().getSize(); i++){
		    	telefonos_reclamante.add(cbTelefonos_A.getModel().getElementAt(i).toString());
		    }
			if (mediador.nuevoReclamoEntidad(cbAgente.getSelectedItem().toString(),tfNombreReclamante_A.getText(),tfDni_A.getText(), tfEmail_A.getText(),
				telefonos_reclamante, tfNombreTitular_A.getText(),tfDominio_A.getText(),tfVin_A.getText(),
				cbMarca_A.getSelectedItem().toString(), cbModelo_A.getSelectedItem().toString(),tfNumeroOrden_A.getText(),
				fechaApertura,fechaReclamo,tADescripcion_A.getText(),null,null)){
				JOptionPane.showMessageDialog(this,"Reclamo Agregado.","Notificacion",JOptionPane.INFORMATION_MESSAGE);
				limpiar();
			}else{
				JOptionPane.showMessageDialog(this,"Error al agregar. Inente nuevamente.","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	public boolean isReclamante_desdeEntidad() {
		return reclamante_desdeEntidad;
	}

	public void setReclamante_desdeEntidad(boolean reclamante_desdeEntidad) {
		this.reclamante_desdeEntidad = reclamante_desdeEntidad;
	}

	public boolean isVehiculo_desdeEntidad() {
		return vehiculo_desdeEntidad;
	}

	public void setVehiculo_desdeEntidad(boolean vehiculo_desdeEntidad) {
		this.vehiculo_desdeEntidad = vehiculo_desdeEntidad;
	}

	public boolean isOrden_desdeEntidad() {
		return orden_desdeEntidad;
	}

	public void setOrden_desdeEntidad(boolean orden_desdeEntidad) {
		this.orden_desdeEntidad = orden_desdeEntidad;
	}

	public void setOrdenEntidad(OrdenDTO orden) {
		tfNumeroOrden_E.setText(orden.getNumero_orden());
		dCFecha_Apertura_E.setDate(orden.getFecha_apertura());	
	}

	public void setOrdenAgente(OrdenDTO orden) {
		tfNumeroOrden_A.setText(orden.getNumero_orden());
		dCFecha_Apertura_A.setDate(orden.getFecha_apertura());			
	}

	public void setReclamanteEntidad(ReclamanteDTO reclamante) {
		tfNombreReclamante_E.setText(reclamante.getNombre_apellido());
		tfEmail_E.setText(reclamante.getEmail());
		tfDni_E.setText(reclamante.getDni());
		telefonos = mediador.obtenerTelefonos(reclamante);
		DefaultComboBoxModel<String> comboBOX_Modelo = new DefaultComboBoxModel<String>(telefonos);
		cbTelefonos_E.setModel(comboBOX_Modelo);
	}

	public void setReclamanteAgente(ReclamanteDTO reclamante) {
		tfNombreReclamante_A.setText(reclamante.getNombre_apellido());
		tfEmail_A.setText(reclamante.getEmail());
		tfDni_A.setText(reclamante.getDni());
		telefonos = mediador.obtenerTelefonos(reclamante);
		DefaultComboBoxModel<String> comboBOX_Modelo = new DefaultComboBoxModel<String>(telefonos);
		cbTelefonos_A.setModel(comboBOX_Modelo);
	}

	public void setVehiculoEntidad(VehiculoDTO vehiculo) {
		tfNombreTitular_E.setText(vehiculo.getNombre_titular());
		tfDominio_E.setText(vehiculo.getDominio());
		tfVin_E.setText(vehiculo.getVin());
		cbMarca_E.setSelectedItem(vehiculo.getMarca().getNombre_marca());
		cbModelo_E.setSelectedItem(vehiculo.getModelo().getNombre_modelo());
	}

	public void setVehiculoAgente(VehiculoDTO vehiculo) {
		tfNombreTitular_A.setText(vehiculo.getNombre_titular());
		tfDominio_A.setText(vehiculo.getDominio());
		tfVin_A.setText(vehiculo.getVin());
		cbMarca_A.setSelectedItem(vehiculo.getMarca().getNombre_marca());
		cbModelo_A.setSelectedItem(vehiculo.getModelo().getNombre_modelo());
	}

	public Vector<String> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Vector<String> telefonos) {
		this.telefonos = telefonos;
	}
}
