package cliente.GestionarReclamante;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import common.DTOs.ReclamanteDTO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIGestionReclamante extends JFrame {


	private static final long serialVersionUID = 1L;

	protected MediadorReclamante mediador;
	
	private JPanel contentPane;
	
	private JTextField tFnombre_reclamante;
	private JButton btnModificar;
	private JButton btnEliminar;
	private Object[][] datosTabla;
	private String[] nombreColumnas;
	private JTable tableRegistrantes;
	
	private JButton btnAgregar;
	private JButton btnImprimir;
	private JButton btnVolver;
	private JButton btnListarRegistrantes;
	private JLabel lblTelefono;
	private JTextField tFEmail;
	private JTextField tFTelefono;

	public GUIGestionReclamante(MediadorReclamante mediador) {
		this.mediador = mediador;
		initialize();

	}
	
	public void initialize(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("GESTIONAR RECLAMANTE");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tFnombre_reclamante = new JTextField();
		tFnombre_reclamante.addKeyListener(new KeyListener() {
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
		tFnombre_reclamante.setBounds(192, 37, 230, 20);
		contentPane.add(tFnombre_reclamante);
		tFnombre_reclamante.setColumns(10);
		
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
		
		JLabel lbl_nombre_reclamante = new JLabel("Nombre del Registrante");
		lbl_nombre_reclamante.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lbl_nombre_reclamante.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nombre_reclamante.setBounds(31, 35, 141, 24);
		contentPane.add(lbl_nombre_reclamante);
		
		JLabel lbl_email = new JLabel("Email");
		lbl_email.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lbl_email.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_email.setBounds(31, 70, 141, 24);
		contentPane.add(lbl_email);
		
		// usuario de prueba
		ReclamanteDTO reclamantedto = new ReclamanteDTO("Matias Bernal", "Matias@matias.com");
		reclamantedto.setId(new Long(1));
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
			"ID Reclamante", "Nombre Reclamante", "Email"
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
		tableRegistrantes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getClickCount() == 2)
					verRegistrante();
			    else{
			    	e.consume();
			    }   
			}
		});
		tableRegistrantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableRegistrantes.setBounds(0, 0, 765, 320);
		
		JScrollPane scrollPaneTabla = new JScrollPane(tableRegistrantes);
		scrollPaneTabla.setBounds(10, 182, 764, 318);
		contentPane.add(scrollPaneTabla);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mediador.altaReclamante(tFnombre_reclamante.getText(),tFEmail.getText(), tFTelefono.getText());
			}
		});
		btnAgregar.setBounds(493, 34, 220, 23);
		contentPane.add(btnAgregar);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnImprimir.setBounds(317, 528, 150, 23);
		contentPane.add(btnImprimir);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVolver.setBounds(537, 528, 150, 23);
		contentPane.add(btnVolver);
		
		btnListarRegistrantes = new JButton("Listar Registrantes");
		btnListarRegistrantes.setBounds(493, 137, 220, 23);
		contentPane.add(btnListarRegistrantes);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblTelefono.setBounds(31, 107, 141, 24);
		contentPane.add(lblTelefono);
		
		tFEmail = new JTextField();
		tFEmail.setColumns(10);
		tFEmail.setBounds(192, 70, 230, 20);
		contentPane.add(tFEmail);
		
		tFTelefono = new JTextField();
		tFTelefono.setColumns(10);
		tFTelefono.setBounds(192, 109, 230, 20);
		contentPane.add(tFTelefono);
		
		JButton btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verRegistrante();
			}
		});
		btnVer.setBounds(98, 528, 150, 23);
		contentPane.add(btnVer);
		
	}
	
	private void verRegistrante() {
		int row = tableRegistrantes.getSelectedRow();
		if (row >= 0) {
			Long id = new Long (tableRegistrantes.getValueAt(row, 0).toString());
			mediador.verRegistrante(id);
		}else{
			JOptionPane.showMessageDialog(contentPane,"Seleccione un reclamante primero.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void reiniciar() {
		tFnombre_reclamante.setText("");
		tFEmail.setText("");
		tFTelefono.setText("");
	}
}
