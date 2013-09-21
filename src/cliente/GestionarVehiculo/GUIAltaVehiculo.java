package cliente.GestionarVehiculo;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import cliente.GestionarUsuario.MediadorUsuario;

import java.awt.Toolkit;
import java.util.Vector;

public class GUIAltaVehiculo extends JFrame {
	public GUIAltaVehiculo() {
	}
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFnombre_titular;
	private JComboBox<String> comboBox_marca;
	private JComboBox<String> comboBox_modelo;
	private Vector<String> tiposMarcas;
	private Vector<String> tiposModelos;
	private JTextField tFDominio;
	private JTextField tFVin;
	
	private MediadorVehiculo medidador;
	private int limiteVin = 17;
	private int limiteDominio = 6;

	/**
	 * @wbp.parser.constructor
	 */
	public GUIAltaVehiculo(final MediadorVehiculo medidador, String nombre_titular, String dominio, String vin, String marca, String modelo) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIAltaVehiculo.class.getResource("/cliente/imagenes/del_user.ico")));
		this.medidador = medidador;
		tiposMarcas = new Vector<String>();
		tiposModelos = new Vector<String>();
		initialize();
		tFnombre_titular.setText(nombre_titular);
		if (dominio.length()<= 6)
			tFDominio.setText(dominio);
		if(vin.length()<=17)
			tFVin.setText(vin);
		tiposMarcas.add(marca);
		tiposModelos.add(modelo);
		comboBox_marca.setSelectedItem(marca);
		comboBox_modelo.setSelectedItem(modelo);
		SetVisible(true);
	}
	
	public GUIAltaVehiculo(final MediadorVehiculo mediadorVehiculo) {
		this.medidador = mediadorVehiculo;
		tiposMarcas = new Vector<String>();
		tiposModelos = new Vector<String>();
		initialize();
		SetVisible(true);
	}
	
	private void initialize() {
		setTitle("AGREGAR VEHICULO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 410, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreTitular = new JLabel("Nombre del Titular");
		lblNombreTitular.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreTitular.setBounds(0, 10, 130, 20);
		contentPane.add(lblNombreTitular);
		
		tFnombre_titular = new JTextField();
		tFnombre_titular.setBounds(135, 10, 250, 20);
		contentPane.add(tFnombre_titular);
		tFnombre_titular.setColumns(10);
		
		JLabel lblDominio = new JLabel("Dominio");
		lblDominio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDominio.setBounds(0, 40, 130, 20);
		contentPane.add(lblDominio);
		
		JLabel lblVIN = new JLabel("VIN");
		lblVIN.setHorizontalAlignment(SwingConstants.CENTER);
		lblVIN.setBounds(0, 70, 130, 20);
		contentPane.add(lblVIN);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblModelo.setBounds(0, 131, 130, 20);
		contentPane.add(lblModelo);
		
		JButton btnCrearUsuario = new JButton("Crear");
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarVehiculo();
			}
		});
		btnCrearUsuario.setBounds(226, 169, 110, 20);
		contentPane.add(btnCrearUsuario);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(51, 169, 110, 20);
		contentPane.add(btnCancelar);

		JLabel lblTipoMarca = new JLabel("Marca");
		lblTipoMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoMarca.setBounds(0, 101, 130, 20);
		contentPane.add(lblTipoMarca);
		
		comboBox_modelo = new JComboBox<String>();
		comboBox_modelo.setModel(new DefaultComboBoxModel<String>(tiposModelos));
		comboBox_modelo.setBounds(135, 101, 154, 20);
		contentPane.add(comboBox_modelo);
		
		tFDominio = new JTextField();
		tFDominio.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if (tFDominio.getText().length()>=limiteDominio){
					e.consume();					
				}
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER){
					agregarVehiculo();
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		tFDominio.setBounds(135, 40, 79, 20);
		contentPane.add(tFDominio);
		tFDominio.setColumns(10);
		
		tFVin = new JTextField();
		tFVin.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if (tFVin.getText().length()>=limiteVin){
					e.consume();					
				}
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER){
					agregarVehiculo();
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		tFVin.setBounds(135, 71, 154, 20);
		contentPane.add(tFVin);
		tFVin.setColumns(10);
		
		comboBox_marca = new JComboBox<String>();
		comboBox_marca.setModel(new DefaultComboBoxModel<String>(tiposMarcas));
		comboBox_marca.setBounds(135, 131, 154, 20);
		contentPane.add(comboBox_marca);
		
	}
		
	private void agregarVehiculo() {
		// TODO Auto-generated method stub
		
	}

	private boolean chequearVehiculo() {
		return true;
	}
	public void SetVisible(boolean visible){
		contentPane.setVisible(visible);
	}
	

}
