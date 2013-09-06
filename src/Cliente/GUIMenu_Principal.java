package cliente;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class GUIMenu_Principal extends JFrame{

	private static final long serialVersionUID = 1L;
	private MediadorPrincipal mediadorPrincipal;
	private JFrame frmCambiarAca;

	public GUIMenu_Principal(MediadorPrincipal mediadorPrincipal) {
		this.mediadorPrincipal= mediadorPrincipal;
		initialize();
	}

	private void initialize() {
		frmCambiarAca = new JFrame();
		String titulo = "USUARIO: "+mediadorPrincipal.getUsuario().getNombre_usuario().toString() +" [ID: "+mediadorPrincipal.getUsuario().getId().toString()+" ]";
		frmCambiarAca.setTitle(titulo);
		frmCambiarAca.setIconImage(Toolkit.getDefaultToolkit().getImage(GUIMenu_Principal.class.getResource("/cliente/imagenes/tagle.ico")));
		frmCambiarAca.setResizable(false);
		frmCambiarAca.setBounds(100, 100, 800, 600);
		frmCambiarAca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmCambiarAca.setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		JMenuItem mntmDesconectar = new JMenuItem("Desconectar");
		mntmDesconectar.setIcon(new ImageIcon(GUIMenu_Principal.class.getResource("/cliente/imagenes/disconnect.ico")));
		mntmDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				mediadorPrincipal.reiniciar();
				System.out.println("Desconectar presionado");
			}
		});
		mnInicio.add(mntmDesconectar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(GUIMenu_Principal.class.getResource("/cliente/imagenes/exit.ico")));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				mediadorPrincipal.salir();
				System.out.println("Salir presionado");	
			}
		});
		mnInicio.add(mntmSalir);
		
		
		// MENU USUARIOS //
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmAltaUsuario = new JMenuItem("Alta Usuario");
		mntmAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				mediadorPrincipal.altaUsuario();
				System.out.println("Alta Usuario presionado");	
			}
		});
		mnUsuarios.add(mntmAltaUsuario);
		
		JMenuItem mntmGestionUsuario = new JMenuItem("Gestionar Usuarios");
		mntmGestionUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				mediadorPrincipal.gestionarUsuario();
				System.out.println("Gestionar Usuario presionado");	
			}
		});
		mnUsuarios.add(mntmGestionUsuario);
		
		// MENU REGISTRANTES //
		JMenu mnRegistrantes = new JMenu("Registrantes");
		menuBar.add(mnRegistrantes);
		
		JMenuItem mntmAltaRegistrante = new JMenuItem("Alta Registrante");
		mntmAltaRegistrante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				mediadorPrincipal.altaRegistrante();
				System.out.println("Alta Regsitrante presionado");	
			}
		});
		mnRegistrantes.add(mntmAltaRegistrante);
		
		JMenuItem mntmGestionRegistrante = new JMenuItem("Gestionar Registrantes");
		mntmGestionRegistrante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				mediadorPrincipal.gestionarRegistrante();
				System.out.println("Gestionar Registrante presionado");	
			}
		});
		mnRegistrantes.add(mntmGestionRegistrante);
		
		JMenu mnReclamantes = new JMenu("Reclamantes");
		menuBar.add(mnReclamantes);
		
		JMenuItem mntmAltaReclamante = new JMenuItem("Alta Reclamante");
		mnReclamantes.add(mntmAltaReclamante);
		
		JMenuItem mntmGestionReclamante = new JMenuItem("Gestionar Reclamantes");
		mnReclamantes.add(mntmGestionReclamante);
		
		JMenu mnVehiculos = new JMenu("Vehiculos");
		menuBar.add(mnVehiculos);
		
		JMenuItem mntmAltaVehiculo = new JMenuItem("Alta Vehiculo");
		mnVehiculos.add(mntmAltaVehiculo);
		
		JMenuItem mntmGestionVehiculo = new JMenuItem("Gestionar Vehiculos");
		mnVehiculos.add(mntmGestionVehiculo);
		
		JMenu mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);
		
		JMenuItem mntmAltaPedido = new JMenuItem("Alta Pedido");
		mnPedido.add(mntmAltaPedido);
		
		JMenuItem mntmGestionPedido = new JMenuItem("Gestionar Pedidos");
		mnPedido.add(mntmGestionPedido);
		
		JMenuItem mntmDevolucion = new JMenuItem("Devolucion/es");
		mnPedido.add(mntmDevolucion);
		
		JMenu mnReclamos = new JMenu("Reclamos");
		menuBar.add(mnReclamos);
		
		JMenuItem mntmAltaReclamo = new JMenuItem("Alta Reclamo");
		mnReclamos.add(mntmAltaReclamo);
		
		JMenuItem mntmGestionReclamo = new JMenuItem("Gestionar Reclamos");
		mnReclamos.add(mntmGestionReclamo);
		
		JMenu mnRecursos = new JMenu("Recursos");
		menuBar.add(mnRecursos);
		
		JMenu mnDevoluciones = new JMenu("Devoluciones");
		menuBar.add(mnDevoluciones);
		
		JMenuItem mntmAltaDevolucion = new JMenuItem("Alta Devolucion");
		mnDevoluciones.add(mntmAltaDevolucion);
		
		JMenuItem mntmGestiondevolucion = new JMenuItem("Gestionar Devoluciones");
		mnDevoluciones.add(mntmGestiondevolucion);
		
		JMenu mnAlertas = new JMenu("Alertas");
		menuBar.add(mnAlertas);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mnAlertas.add(mntmModificar);
		
		JMenuItem mntmActualizar = new JMenuItem("Actualizar");
		mnAlertas.add(mntmActualizar);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mnAyuda.add(mntmAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de..");
		mnAyuda.add(mntmAcercaDe);
		frmCambiarAca.getContentPane().setLayout(null);
		
		JButton btnReclamos = new JButton("RECLAMOS");
		btnReclamos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnReclamos.setBounds(104, 189, 250, 23);
		frmCambiarAca.getContentPane().add(btnReclamos);
		
		JButton btnRepuestos = new JButton("REPUESTOS");
		btnRepuestos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRepuestos.setBounds(104, 249, 250, 23);
		frmCambiarAca.getContentPane().add(btnRepuestos);
		
		JButton btnReportes = new JButton("REPORTES");
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReportes.setBounds(104, 310, 250, 23);
		frmCambiarAca.getContentPane().add(btnReportes);
		
		JPanel panel = new JPanel();
		panel.setBounds(433, 43, 331, 373);
		frmCambiarAca.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		List lista_tareas = new List();
		panel.add(lista_tareas, BorderLayout.CENTER);
		
		JLabel lblActividades = new JLabel("ACTIVIDADES");
		lblActividades.setHorizontalAlignment(SwingConstants.CENTER);
		lblActividades.setHorizontalTextPosition(SwingConstants.CENTER);
		lblActividades.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblActividades.setBounds(524, 11, 126, 21);
		frmCambiarAca.getContentPane().add(lblActividades);
		
		JButton btnCompletado = new JButton("Completada");
		btnCompletado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompletado.setBounds(433, 455, 138, 23);
		frmCambiarAca.getContentPane().add(btnCompletado);
		
		JButton btnPosponer = new JButton("Posponer");
		btnPosponer.setBounds(626, 455, 138, 23);
		frmCambiarAca.getContentPane().add(btnPosponer);
	}

	public void setVisible(boolean b) {
		frmCambiarAca.setVisible(b);
	}

	public MediadorPrincipal getMediadorPrincipal() {
		return mediadorPrincipal;
	}

	public void setMediadorPrincipal(MediadorPrincipal mediadorPrincipal) {
		this.mediadorPrincipal = mediadorPrincipal;
	}

	public void reiniciar() {
		setVisible(false);
	}
	public void show() {
		// TODO Auto-generated method stub
	}
}
