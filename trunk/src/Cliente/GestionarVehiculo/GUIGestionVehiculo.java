package cliente.GestionarVehiculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

public class GUIGestionVehiculo extends JFrame{
	private static final long serialVersionUID = 1L;

	protected MediadorVehiculo mediador;
	
	private JPanel contentPane;
	
	private JTextField tFnombre_titular;
	private JButton btnModificar;
	private JButton btnEliminar;
	private Object[][] datosTabla;
	private String[] nombreColumnas;
	private JTable tableRegistrantes;
	
	private JButton btnAgregar;
	private JButton btnImprimir;
	private JButton btnVolver;
	private JButton btnListarRegistrantes;

	private JTextField tFDominio;
	private JLabel lblVin;
	private JTextField tFVin;
	private JLabel lblMarca;
	private JLabel lblModelo;
	private JComboBox<String> comboBox_marca;
	private JComboBox<String> comboBox_modelo;
	private Vector<String> modelos;
	private Vector<String> marcas;


	public GUIGestionVehiculo(MediadorVehiculo mediadorRegistrante) {
		this.mediador = mediadorRegistrante;
		modelos = new Vector<String>();
		modelos.add("Steep Way");
		marcas = new Vector<String>();
		marcas.add("Renault");
		initialize();
		
	}
	
	public void initialize(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("GESTIONAR VEHICULO");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tFnombre_titular = new JTextField();
		tFnombre_titular.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub				
			}
		});
		tFnombre_titular.setBounds(190, 30, 230, 20);
		contentPane.add(tFnombre_titular);
		tFnombre_titular.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setBounds(493, 69, 220, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(493, 103, 220, 23);
		contentPane.add(btnEliminar);
		
		JLabel lbl_nombre_titular = new JLabel("Nombre del Titular");
		lbl_nombre_titular.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lbl_nombre_titular.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nombre_titular.setBounds(30, 30, 140, 20);
		contentPane.add(lbl_nombre_titular);
		
		JLabel lbl_dominio = new JLabel("Dominio");
		lbl_dominio.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lbl_dominio.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_dominio.setBounds(30, 60, 140, 20);
		contentPane.add(lbl_dominio);
		
		datosTabla =  new Object[][]{
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
				{new Long(0L), "Matias", "1234", "1234567", "Renault", "Steepway"},
		};
		nombreColumnas = new String []{
			"ID Vehiculo", "Nombre Titular", "Dominio", "VIN", "Marca", "Modelo"
		};
		
		DefaultTableModel modelo = new DefaultTableModel(datosTabla, nombreColumnas);
		tableRegistrantes = new JTable(modelo) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tableRegistrantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableRegistrantes.setBounds(0, 0, 765, 320);
		
		JScrollPane scrollPaneTabla = new JScrollPane(tableRegistrantes);
		scrollPaneTabla.setBounds(10, 182, 764, 318);
		contentPane.add(scrollPaneTabla);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mediador.altaVehiculo(tFnombre_titular.getText(), tFDominio.getText(), tFVin.getText(), (String)comboBox_marca.getSelectedItem(), (String)comboBox_modelo.getSelectedItem());
			}
		});
		btnAgregar.setBounds(493, 34, 220, 23);
		contentPane.add(btnAgregar);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnImprimir.setBounds(237, 528, 150, 23);
		contentPane.add(btnImprimir);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(397, 528, 150, 23);
		contentPane.add(btnVolver);
		
		btnListarRegistrantes = new JButton("Listar Registrantes");
		btnListarRegistrantes.setBounds(493, 137, 220, 23);
		contentPane.add(btnListarRegistrantes);
		
		tFDominio = new JTextField();
		tFDominio.setColumns(10);
		tFDominio.setBounds(190, 60, 100, 20);
		contentPane.add(tFDominio);
		
		lblVin = new JLabel("VIN");
		lblVin.setHorizontalAlignment(SwingConstants.CENTER);
		lblVin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblVin.setBounds(30, 90, 140, 20);
		contentPane.add(lblVin);
		
		tFVin = new JTextField();
		tFVin.setColumns(10);
		tFVin.setBounds(190, 90, 230, 20);
		contentPane.add(tFVin);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblMarca.setBounds(30, 120, 140, 20);
		contentPane.add(lblMarca);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblModelo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblModelo.setBounds(30, 150, 140, 20);
		contentPane.add(lblModelo);
		
		comboBox_marca = new JComboBox<String>();
		DefaultComboBoxModel<String> cmbMarcas = new DefaultComboBoxModel<String>(marcas);
		comboBox_marca.setModel(cmbMarcas);
		comboBox_marca.setBounds(190, 120, 230, 20);
		contentPane.add(comboBox_marca);
		
		comboBox_modelo = new JComboBox<String>();
		DefaultComboBoxModel<String> cmbModelos = new DefaultComboBoxModel<String>(modelos);
		comboBox_modelo.setModel(cmbModelos);
		comboBox_modelo.setBounds(190, 150, 230, 20);
		contentPane.add(comboBox_modelo);
		


	}

}