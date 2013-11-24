package cliente.GestionarReclamante;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

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
import javax.swing.ImageIcon;



public class GUIVerReclamante extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFnombre_reclamante;
	private JTextField tFEmail;
	private JComboBox<String> comboBox_telefonos; 
	private Vector<String> telefonos;
	private MediadorReclamante medidador;
	private JLabel lblDni;
	private JTextField tfDni;

	public GUIVerReclamante(final MediadorReclamante medidador, String nombre_reclamante, String email, String dni, Vector<String> telefonos) {
		this.setMedidador(medidador);
		this.telefonos = new Vector<String>();
		initialize();
		
		tFnombre_reclamante.setText(nombre_reclamante);
		tFEmail.setText(email);
		tfDni.setText(dni);
		DefaultComboBoxModel<String> comboBOX_Modelo = new DefaultComboBoxModel<String>(telefonos);
		comboBox_telefonos.setModel(comboBOX_Modelo);

		SetVisible(true);
	}

	/**
	 * @wbp.parser.constructor
	 */
	public GUIVerReclamante(final MediadorReclamante medidador) {
		this.setMedidador(medidador);
		telefonos = new Vector<String>();
		initialize();
		SetVisible(true);
	}
	
	private void initialize() {
		setTitle("VER RECLAMANTE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 410, 240);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIVerReclamante.class.getResource("/cliente/Resources/Icons/1find.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreReclamante = new JLabel("Nombre");
		lblNombreReclamante.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreReclamante.setBounds(0, 10, 130, 20);
		contentPane.add(lblNombreReclamante);
		
		tFnombre_reclamante = new JTextField();
		tFnombre_reclamante.setEditable(false);
		tFnombre_reclamante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StringSelection copiar = new StringSelection(tFnombre_reclamante.getText());
				Clipboard cp = Toolkit.getDefaultToolkit().getSystemClipboard();
				cp.setContents(copiar, null);
				JOptionPane.showMessageDialog(contentPane,"Copiado al portapapeles.", "Copiado...", JOptionPane.PLAIN_MESSAGE);
			}
		});
		tFnombre_reclamante.setBounds(135, 10, 250, 20);
		contentPane.add(tFnombre_reclamante);
		tFnombre_reclamante.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(0, 40, 130, 20);
		contentPane.add(lblEmail);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon(GUIVerReclamante.class.getResource("/cliente/Resources/Icons/back.png")));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVolver.setBounds(152, 167, 110, 20);
		contentPane.add(btnVolver);

		JLabel lblTelefonos = new JLabel("Telefonos");
		lblTelefonos.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefonos.setBounds(0, 102, 130, 20);
		contentPane.add(lblTelefonos);
		contentPane.setVisible(true);
		
		comboBox_telefonos = new JComboBox<String>();
		comboBox_telefonos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if ((String)comboBox_telefonos.getSelectedItem() != ""){
					StringSelection copiar = new StringSelection((String)comboBox_telefonos.getSelectedItem());
					Clipboard cp = Toolkit.getDefaultToolkit().getSystemClipboard();
					cp.setContents(copiar, null);
					JOptionPane.showMessageDialog(contentPane,"Copiado al portapapeles.", "Copiado...",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		DefaultComboBoxModel<String> comboBOX_Modelo = new DefaultComboBoxModel<String>(telefonos);
		comboBox_telefonos.setModel(comboBOX_Modelo);
		comboBox_telefonos.setBounds(135, 102, 152, 20);
		contentPane.add(comboBox_telefonos);
		
		tFEmail = new JTextField();
		tFEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StringSelection copiar = new StringSelection(tFEmail.getText());
				Clipboard cp = Toolkit.getDefaultToolkit().getSystemClipboard();
				cp.setContents(copiar, null);
				JOptionPane.showMessageDialog(contentPane,"Copiado al portapapeles.", "Copiado...",JOptionPane.PLAIN_MESSAGE);
			}
		});
		tFEmail.setEditable(false);
		tFEmail.setBounds(135, 40, 250, 20);
		contentPane.add(tFEmail);
		tFEmail.setColumns(10);
		
		lblDni = new JLabel("Dni");
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		lblDni.setBounds(0, 71, 130, 20);
		contentPane.add(lblDni);
		
		tfDni = new JTextField();
		tfDni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StringSelection copiar = new StringSelection(tfDni.getText());
				Clipboard cp = Toolkit.getDefaultToolkit().getSystemClipboard();
				cp.setContents(copiar, null);
				JOptionPane.showMessageDialog(contentPane,"Copiado al portapapeles.", "Copiado...", JOptionPane.PLAIN_MESSAGE);
			}
		});
		tfDni.setEditable(false);
		tfDni.setColumns(10);
		tfDni.setBounds(135, 71, 152, 20);
		contentPane.add(tfDni);
	}

	public void SetVisible(boolean visible){
		this.setVisible(true);
		contentPane.setVisible(visible);
	}

	public MediadorReclamante getMedidador() {
		return medidador;
	}

	public void setMedidador(MediadorReclamante medidador) {
		this.medidador = medidador;
	}
}
