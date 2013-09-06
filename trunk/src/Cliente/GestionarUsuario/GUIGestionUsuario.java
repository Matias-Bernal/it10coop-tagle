package cliente.GestionarUsuario;

import java.awt.ScrollPane;
import java.awt.Toolkit;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import common.DTOs.UsuarioDTO;
import javax.swing.ListSelectionModel;

public class GUIGestionUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private MediadorUsuario mediador;
	private JPanel contentPane;
	private JTextField tFnombre_usuario;
	private JTextField tFemail;
	private JTable tableUsuarios;
	private Object[][] datosTabla;
	private String [] nombreColumnas;
	
	private JButton btnModificar; 
	private JButton btnEliminar; 
	private JButton btnAgregar; 
	private JButton btnImprimir; 
	private JButton btnVolver; 
	private JButton btnListarUsuarios; 
	

	public GUIGestionUsuario(MediadorUsuario mediador) {
		this.mediador = mediador;
		initialize();
	}
	
	@SuppressWarnings("serial")
	public void initialize(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIGestionUsuario.class.getResource("/cliente/imagenes/find_user.ico")));
		setTitle("GESTIONAR USUARIOS");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tFnombre_usuario = new JTextField();
		tFnombre_usuario.addKeyListener(new KeyListener() {
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
		tFnombre_usuario.setBounds(192, 37, 230, 20);
		contentPane.add(tFnombre_usuario);
		tFnombre_usuario.setColumns(10);
		
		tFemail = new JTextField();
		tFemail.setBounds(192, 72, 230, 20);
		contentPane.add(tFemail);
		tFemail.setColumns(10);
		
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
		
		JLabel lbl_nombre_usuario = new JLabel("Nombre de Usuario");
		lbl_nombre_usuario.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lbl_nombre_usuario.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nombre_usuario.setBounds(31, 35, 141, 24);
		contentPane.add(lbl_nombre_usuario);
		
		JLabel lbl_email = new JLabel("Email");
		lbl_email.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lbl_email.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_email.setBounds(31, 70, 141, 24);
		contentPane.add(lbl_email);
		
		ScrollPane scrollPaneTabla = new ScrollPane();
		scrollPaneTabla.setBounds(10, 182, 764, 318);
		contentPane.add(scrollPaneTabla);
		
		// usuario de prueba
		UsuarioDTO usuariodto = new UsuarioDTO("Matias", "pass", "matias@matias.com");
		usuariodto.setId(new Long(1));
		//
		
		datosTabla =  new Object[][]{
				{new Long(0L), "Matias", "matias@matias.com"},
				{new Long(1L), "Matias", "matias@matias.com"},
				{new Long(2L), "Matias", "matias@matias.com"},
				{new Long(3L), "Matias", "matias@matias.com"},
				{new Long(4L), "Matias", "matias@matias.com"},
				{new Long(5L), "Matias", "matias@matias.com"},
				{new Long(6L), "Matias", "matias@matias.com"},
				{new Long(7L), "Matias", "matias@matias.com"},
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
			"Id Usuario", "Nombre Usuario", "Email"
		};
		
		DefaultTableModel modelo = new DefaultTableModel(datosTabla, nombreColumnas);
		tableUsuarios = new JTable(modelo) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tableUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableUsuarios.setBounds(0, 0, 765, 320);
		scrollPaneTabla.add(tableUsuarios);

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mediador.altaUsuario(tFnombre_usuario.getText(), tFemail.getText());
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
		
		btnListarUsuarios = new JButton("Listar Usuarios");
		btnListarUsuarios.setBounds(493, 137, 220, 23);
		contentPane.add(btnListarUsuarios);

	}
}
