package cliente.GestionarUsuario;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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

	/**
	 * @wbp.parser.constructor
	 */
	public GUIAltaUsuario(final MediadorUsuario medidador, String nombre_usuario, String email) {
		this.medidador = medidador;
		initialize();
		tFnombre_usuario.setText(nombre_usuario);
		tFemail.setText(email);
		SetVisible(true);
	}
	
	public GUIAltaUsuario(final MediadorUsuario medidador) {
		this.medidador = medidador;
		initialize();
	}
	
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIAltaUsuario.class.getResource("/cliente/imagenes/add_user.ico")));
		setTitle("AGREGAR USUARIO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 410, 210);
		setResizable(false);
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
					if (chequearContrase�a()){
						medidador.nuevoUsuario(tFnombre_usuario.getText(), passwordField.getText(), tFemail.getText());
					}else{
						JOptionPane.showMessageDialog(contentPane,"Las contrase�as no coinciden.","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnCrearUsuario.setBounds(225, 140, 110, 20);
		contentPane.add(btnCrearUsuario);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(50, 140, 110, 20);
		contentPane.add(btnCancelar);

		contentPane.setVisible(true);
		
	}
		
	private boolean chequearContrase�a() {
		return (passwordField.getText().equals(passwordFieldConfirm.getText()));
	}
	public void SetVisible(boolean visible){
		contentPane.setVisible(visible);
	}
}
