package cliente.GestionarUsuario;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class GUIAltaUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFnombre_usuario;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirm;
	private JTextField tFemail;
	private MediadorUsuario medidador;
	private JComboBox<String> comboBox;
	private String[] tiposUsuarios;

	/**
	 * @wbp.parser.constructor
	 */
	public GUIAltaUsuario(final MediadorUsuario medidador, String nombre_usuario, String email, String tipo) {
		this.medidador = medidador;
		tiposUsuarios = new String[] {"Administrativo", "Encargado Repuesto"};
		
		initialize();
		
		tFnombre_usuario.setText(nombre_usuario);
		tFemail.setText(email);
		comboBox.setSelectedItem(tipo);
		
		SetVisible(true);
	}
	
	public GUIAltaUsuario(final MediadorUsuario medidador) {
		this.medidador = medidador;
		tiposUsuarios = new String[] {"Administrativo", "Encargado Repuesto"};

		initialize();
		SetVisible(true);
	}
	
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIAltaUsuario.class.getResource("/cliente/imagenes/add_user.ico")));
		setTitle("AGREGAR USUARIO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 410, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre De Usuario");
		lblNombreDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDeUsuario.setBounds(0, 10, 130, 20);
		contentPane.add(lblNombreDeUsuario);
		
		tFnombre_usuario = new JTextField();
		tFnombre_usuario.setBounds(135, 10, 250, 20);
		contentPane.add(tFnombre_usuario);
		tFnombre_usuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setBounds(0, 40, 130, 20);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(135, 40, 250, 20);
		contentPane.add(passwordField);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setBounds(135, 70, 250, 20);
		contentPane.add(passwordFieldConfirm);
		
		JLabel lblConfirmar = new JLabel("Confirmar Contrase\u00F1a");
		lblConfirmar.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmar.setBounds(0, 70, 130, 20);
		contentPane.add(lblConfirmar);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(0, 100, 130, 20);
		contentPane.add(lblEmail);
		
		tFemail = new JTextField();
		tFemail.setBounds(135, 100, 250, 20);
		contentPane.add(tFemail);
		tFemail.setColumns(10);
		
		JButton btnCrearUsuario = new JButton("Crear");
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tFnombre_usuario.getText().isEmpty() || passwordField.getText().isEmpty() || tFemail.getText().isEmpty()){
					JOptionPane.showMessageDialog(contentPane,"Algunos campos estan vacios.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
				}else{
					if (chequearContraseña()){
						medidador.nuevoUsuario(tFnombre_usuario.getText(), passwordField.getText(), tFemail.getText(),"Administrativo");
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

		JLabel lblTipoUsuario = new JLabel("Tipo Usuario");
		lblTipoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoUsuario.setBounds(10, 131, 120, 20);
		contentPane.add(lblTipoUsuario);
		contentPane.setVisible(true);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(tiposUsuarios));
		comboBox.setBounds(135, 131, 154, 20);
		contentPane.add(comboBox);
		
	}
		
	private boolean chequearContraseña() {
		return (passwordField.getText().equals(passwordFieldConfirm.getText()));
	}
	public void SetVisible(boolean visible){
		contentPane.setVisible(visible);
	}

	public String[] getTiposUsuarios() {
		return tiposUsuarios;
	}

	public void setTiposUsuarios(String[] tiposUsuarios) {
		this.tiposUsuarios = tiposUsuarios;
	}
}
