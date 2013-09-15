package cliente.GestionarRegistrante;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GUIAltaRegistrante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFnombre_usuario;
	private MediadorRegistrante medidador;
	private JComboBox<String> comboBox;
	private String[] tiposRegistrantes;

	public GUIAltaRegistrante(final MediadorRegistrante medidador, String nombre_usuario, String tipo) {
		this.medidador = medidador;
		tiposRegistrantes = new String[] {"Entidad", "Agente"};
		initialize();
		tFnombre_usuario.setText(nombre_usuario);
		comboBox.setSelectedItem(tipo);
		SetVisible(true);
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public GUIAltaRegistrante(final MediadorRegistrante medidador) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIAltaRegistrante.class.getResource("/cliente/imagenes/del_user.ico")));
		this.medidador = medidador;
		tiposRegistrantes = new String[] {"Entidad", "Agente"};
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
				if (tFnombre_usuario.getText().isEmpty() ){
					JOptionPane.showMessageDialog(contentPane,"Nombre de Registrante vacio.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
				}else{
					
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
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(tiposRegistrantes));
		comboBox.setBounds(135, 41, 253, 20);
		contentPane.add(comboBox);

		contentPane.setVisible(true);
		
	}

	public void SetVisible(boolean visible){
		contentPane.setVisible(visible);
	}
}
