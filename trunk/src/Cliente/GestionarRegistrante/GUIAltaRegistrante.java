package cliente.GestionarRegistrante;

import java.awt.Choice;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GUIAltaRegistrante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFnombre_usuario;
	private MediadorRegistrante medidador;
	private Choice choiceTipo;

	public GUIAltaRegistrante(final MediadorRegistrante medidador, String nombre_usuario, String tipo) {
		this.medidador = medidador;
		initialize();
		tFnombre_usuario.setText(nombre_usuario);
		SetVisible(true);
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public GUIAltaRegistrante(final MediadorRegistrante medidador) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIAltaRegistrante.class.getResource("/cliente/imagenes/del_user.ico")));
		this.medidador = medidador;
		initialize();
	}
	
	private void initialize() {
		setTitle("AGREGAR REGISTRANTE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 410, 210);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDelRegistrante = new JLabel("Nombre Del Registrante");
		lblNombreDelRegistrante.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDelRegistrante.setBounds(0, 10, 130, 20);
		contentPane.add(lblNombreDelRegistrante);
		
		tFnombre_usuario = new JTextField();
		tFnombre_usuario.setBounds(135, 10, 250, 20);
		contentPane.add(tFnombre_usuario);
		tFnombre_usuario.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setBounds(0, 40, 130, 20);
		contentPane.add(lblTipo);
		
		JButton btnCrearUsuario = new JButton("Crear");
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

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
		
		choiceTipo = new Choice();
		choiceTipo.setBounds(135, 40, 250, 20);
		contentPane.add(choiceTipo);

		contentPane.setVisible(true);
		
	}

	public void SetVisible(boolean visible){
		contentPane.setVisible(visible);
	}

}
