package cliente.principal;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUILogin {

	private JFrame LoginFrame;
	private JTextField tf_nombre_usuario;
	private JPanel jPanel_sur;
	private JPasswordField pf_contrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUILogin window = new GUILogin();
					window.LoginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUILogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LoginFrame = new JFrame();
		LoginFrame.setTitle("LOGIN");
		LoginFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Matyas\\Pictures\\tagle.ico"));
		LoginFrame.setResizable(false);
		LoginFrame.setMinimumSize(new Dimension(375, 225));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {60, 230, 60};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 54, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		LoginFrame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario");
		GridBagConstraints gbc_lblNombreDeUsuario = new GridBagConstraints();
		gbc_lblNombreDeUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeUsuario.gridx = 1;
		gbc_lblNombreDeUsuario.gridy = 1;
		LoginFrame.getContentPane().add(lblNombreDeUsuario, gbc_lblNombreDeUsuario);
		
		tf_nombre_usuario = new JTextField();
		tf_nombre_usuario.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_tf_nombre_usuario = new GridBagConstraints();
		gbc_tf_nombre_usuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_nombre_usuario.insets = new Insets(0, 0, 5, 5);
		gbc_tf_nombre_usuario.gridx = 1;
		gbc_tf_nombre_usuario.gridy = 2;
		LoginFrame.getContentPane().add(tf_nombre_usuario, gbc_tf_nombre_usuario);
		tf_nombre_usuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 3;
		LoginFrame.getContentPane().add(lblContrasea, gbc_lblContrasea);
		
		pf_contrasenia = new JPasswordField();
		pf_contrasenia.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_pf_contrasenia = new GridBagConstraints();
		gbc_pf_contrasenia.insets = new Insets(0, 0, 5, 5);
		gbc_pf_contrasenia.fill = GridBagConstraints.HORIZONTAL;
		gbc_pf_contrasenia.gridx = 1;
		gbc_pf_contrasenia.gridy = 4;
		LoginFrame.getContentPane().add(pf_contrasenia, gbc_pf_contrasenia);
		
		jPanel_sur = new JPanel();
		jPanel_sur.setBorder(null);
		GridBagConstraints gbc_jPanel_sur = new GridBagConstraints();
		gbc_jPanel_sur.insets = new Insets(0, 0, 5, 5);
		gbc_jPanel_sur.fill = GridBagConstraints.HORIZONTAL;
		gbc_jPanel_sur.gridx = 1;
		gbc_jPanel_sur.gridy = 5;
		LoginFrame.getContentPane().add(jPanel_sur, gbc_jPanel_sur);
		GridBagLayout gbl_jPanel_sur = new GridBagLayout();
		gbl_jPanel_sur.columnWidths = new int[] {90, 35, 90, 0};
		gbl_jPanel_sur.rowHeights = new int[]{30, 0, 23, 0};
		gbl_jPanel_sur.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_jPanel_sur.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		jPanel_sur.setLayout(gbl_jPanel_sur);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 0;
		gbc_btnAceptar.gridy = 1;
		jPanel_sur.add(btnAceptar, gbc_btnAceptar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginFrame.dispose();
			}
		});
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSalir.insets = new Insets(0, 0, 5, 0);
		gbc_btnSalir.gridx = 2;
		gbc_btnSalir.gridy = 1;
		jPanel_sur.add(btnSalir, gbc_btnSalir);
	}

	public void setVisible(boolean b) {
		LoginFrame.setVisible(b);		
	}
}
