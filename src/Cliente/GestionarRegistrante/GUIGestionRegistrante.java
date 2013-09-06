package cliente.GestionarRegistrante;

import java.awt.Choice;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import common.DTOs.RegistranteDTO;

public class GUIGestionRegistrante extends JFrame {

	protected MediadorRegistrante mediador;
	
	private JPanel contentPane;
	
	private JTextField tFnombre_registrante;
	private JButton btnModificar;
	private JButton btnEliminar;
	private Object[][] datosTabla;
	private String[] nombreColumnas;
	private JTable tableRegistrantes;
	
	private JButton btnAgregar;
	private JButton btnImprimir;
	private JButton btnVolver;
	private JButton btnListarRegistrantes;

	public GUIGestionRegistrante(MediadorRegistrante mediadorRegistrante) {
		this.mediador = mediadorRegistrante;
		initialize();
	}
	
	public void initialize(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("GESTIONAR REGISTRANTE");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tFnombre_registrante = new JTextField();
		tFnombre_registrante.addKeyListener(new KeyListener() {
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
		tFnombre_registrante.setBounds(192, 37, 230, 20);
		contentPane.add(tFnombre_registrante);
		tFnombre_registrante.setColumns(10);
		
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
		
		JLabel lbl_nombre_registrante = new JLabel("Nombre del Registrante");
		lbl_nombre_registrante.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lbl_nombre_registrante.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nombre_registrante.setBounds(31, 35, 141, 24);
		contentPane.add(lbl_nombre_registrante);
		
		JLabel lbl_tipo_registrante = new JLabel("Tipo");
		lbl_tipo_registrante.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lbl_tipo_registrante.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tipo_registrante.setBounds(31, 70, 141, 24);
		contentPane.add(lbl_tipo_registrante);
		
		ScrollPane scrollPaneTabla = new ScrollPane();
		scrollPaneTabla.setBounds(10, 182, 764, 318);
		contentPane.add(scrollPaneTabla);
		
		// usuario de prueba
		RegistranteDTO registratedto = new RegistranteDTO("Matias");
		registratedto.setId(new Long(1));
		//
		
		datosTabla =  new Object[][]{
				{new Long(0L), "Matias", "Administacion"},
				{new Long(1L), "Matias", "Administacion"},
				{new Long(2L), "Matias", "Administacion"},
				{new Long(3L), "Matias", "Administacion"},
				{new Long(4L), "Matias", "Area Repuestos"},
				{new Long(5L), "Matias", "Area Repuestos"},
				{new Long(6L), "Matias", "Area Repuestos"},
				{new Long(7L), "Matias", "Area Repuestos"},
				{new Long(8L), "Matias", "matias@matias.com"},
				{new Long(9L), "Matias", "matias@matias.com"},
				{new Long(10L), "Matias", "matias@matias.com"},
				{new Long(11L), "Matias", "matias@matias.com"},
				{new Long(12L), "Matias", "matias@matias.com"},
				{new Long(13L), "Matias", "matias@matias.com"},
				{new Long(14L), "Matias", "matias@matias.com"},
				{new Long(15L), "Matias", "matias@matias.com"},
				{new Long(16L), "Matias", "matias@matias.com"},
				{new Long(17L), "Matias", "matias@matias.com"},
				{new Long(18L), "Matias", "matias@matias.com"},
				{new Long(19L), "Matias", "matias@matias.com"},
				{new Long(20L), "Matias", "matias@matias.com"},
				{new Long(21L), "Matias", "matias@matias.com"},
				{new Long(22L), "Matias", "matias@matias.com"},
		};
		nombreColumnas = new String []{
			"Id Registrante", "Nombre Usuario", "Tipo"
		};
		
		DefaultTableModel modelo = new DefaultTableModel(datosTabla, nombreColumnas);
		tableRegistrantes = new JTable(modelo) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tableRegistrantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableRegistrantes.setBounds(0, 0, 765, 320);
		scrollPaneTabla.add(tableRegistrantes);

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mediador.altaRegistrante(tFnombre_registrante.getText(), "administrativo");
			}
		});
		btnAgregar.setBounds(493, 34, 220, 23);
		contentPane.add(btnAgregar);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(237, 528, 150, 23);
		contentPane.add(btnImprimir);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(397, 528, 150, 23);
		contentPane.add(btnVolver);
		
		btnListarRegistrantes = new JButton("Listar Registrantes");
		btnListarRegistrantes.setBounds(493, 137, 220, 23);
		contentPane.add(btnListarRegistrantes);
		
		Choice choice_tipo_registrante = new Choice();
		choice_tipo_registrante.setBounds(192, 72, 230, 20);
		contentPane.add(choice_tipo_registrante);

	}

}
