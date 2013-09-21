package cliente.GestionarReclamante;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cliente.GestionarUsuario.GUIAltaUsuario;

public class GUIAltaReclamante extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFnombre_reclamante;
	private MediadorReclamante medidador;
	private JTextField tFEmail;
	private JComboBox<String> comboBox_telefonos; 
	private Vector<String> telefonos;
	private JRadioButton rdbtnFijo;
	private JRadioButton rdbtnCelular;

	public GUIAltaReclamante(final MediadorReclamante medidador, String nombre_reclamante, String email, String telefono) {
		this.medidador = medidador;
		telefonos = new Vector<String>();
		initialize();
		
		tFnombre_reclamante.setText(nombre_reclamante);
		tFEmail.setText(email);
		telefonos = new Vector<String>();
		telefonos.add(telefono);
		comboBox_telefonos.setSelectedItem(telefono);

		SetVisible(true);
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public GUIAltaReclamante(final MediadorReclamante medidador) {
		this.medidador = medidador;
		telefonos = new Vector<String>();
		initialize();
		SetVisible(true);
	}
	
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIAltaUsuario.class.getResource("/cliente/imagenes/add_user.ico")));
		setTitle("AGREGAR RECLAMANTE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 410, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreReclamante = new JLabel("Nombre Del Reclamante");
		lblNombreReclamante.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreReclamante.setBounds(0, 10, 130, 20);
		contentPane.add(lblNombreReclamante);
		
		tFnombre_reclamante = new JTextField();
		tFnombre_reclamante.setBounds(135, 10, 250, 20);
		contentPane.add(tFnombre_reclamante);
		tFnombre_reclamante.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(0, 40, 130, 20);
		contentPane.add(lblEmail);
		
		JButton btnCrearUsuario = new JButton("Crear");
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tFnombre_reclamante.getText().isEmpty()){
					JOptionPane.showMessageDialog(contentPane,"Algunos campos estan vacios.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
				}else{
					if (chequearContraseña()){
						medidador.reiniciar();
					}else{
						JOptionPane.showMessageDialog(contentPane,"Las contraseñas no coinciden.","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
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

		JLabel lblTelefonos = new JLabel("Telefonos");
		lblTelefonos.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefonos.setBounds(0, 70, 130, 20);
		contentPane.add(lblTelefonos);
		contentPane.setVisible(true);
		
		comboBox_telefonos = new JComboBox<String>();
		
		DefaultComboBoxModel<String> comboBOX_Modelo = new DefaultComboBoxModel<String>(telefonos);
		comboBox_telefonos.setModel(comboBOX_Modelo);
		comboBox_telefonos.setEditable(true);
		comboBox_telefonos.setBounds(133, 71, 152, 20);
		contentPane.add(comboBox_telefonos);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nuevo_telefono = (String)comboBox_telefonos.getSelectedItem();
				if (!telefonos.contains(nuevo_telefono) && nuevo_telefono != null){
					if (rdbtnFijo.isSelected()){
						nuevo_telefono += " (Fijo)";
						telefonos.add(nuevo_telefono);
						DefaultComboBoxModel<String> comboBOX_Modelo = new DefaultComboBoxModel<String>(telefonos);
						comboBox_telefonos.setModel(comboBOX_Modelo);
						comboBox_telefonos.setSelectedIndex(-1);
						rdbtnFijo.setSelected(false);
					}else{
						if (rdbtnCelular.isSelected()){
							nuevo_telefono +=" (Celular)";
							telefonos.add(nuevo_telefono);
							DefaultComboBoxModel<String> comboBOX_Modelo = new DefaultComboBoxModel<String>(telefonos);
							comboBox_telefonos.setModel(comboBOX_Modelo);
							comboBox_telefonos.setSelectedIndex(-1);
							rdbtnCelular.setSelected(false);
						}else{
							JOptionPane.showMessageDialog(contentPane,"Seleccione el tipo de telefono.","Advertencia",JOptionPane.INFORMATION_MESSAGE);

						}
					}					
				}
			}
		});
		btnAgregar.setBounds(295, 71, 82, 23);
		contentPane.add(btnAgregar);
		
		JButton btnQuitar = new JButton("Quitar");
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (telefonos.contains((String)comboBox_telefonos.getSelectedItem())){
						telefonos.remove((String)comboBox_telefonos.getSelectedItem());
						DefaultComboBoxModel<String> comboBOX_Modelo = new DefaultComboBoxModel<String>(telefonos);
						comboBox_telefonos.setModel(comboBOX_Modelo);
						comboBox_telefonos.setSelectedIndex(-1);
						rdbtnFijo.setSelected(false);
						rdbtnCelular.setSelected(false);					
				}
			}
		});
		btnQuitar.setBounds(295, 97, 82, 23);
		contentPane.add(btnQuitar);
		
		tFEmail = new JTextField();
		tFEmail.setBounds(135, 40, 250, 20);
		contentPane.add(tFEmail);
		tFEmail.setColumns(10);
		
		rdbtnCelular = new JRadioButton("Celular");
		rdbtnCelular.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnCelular.isSelected()){
					rdbtnFijo.setSelected(false);
				}
			}
		});

		
		rdbtnCelular.setBounds(133, 97, 109, 23);
		contentPane.add(rdbtnCelular);
		
		rdbtnFijo = new JRadioButton("Fijo");
		rdbtnFijo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnFijo.isSelected()){
					rdbtnCelular.setSelected(false);
				}
			}
		});

		rdbtnFijo.setBounds(135, 123, 109, 23);
		contentPane.add(rdbtnFijo);
		
	}
		
	private boolean chequearContraseña() {
		return true;
	}
	public void SetVisible(boolean visible){
		contentPane.setVisible(visible);
	}
}
