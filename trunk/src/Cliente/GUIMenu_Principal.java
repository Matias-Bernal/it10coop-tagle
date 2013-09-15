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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class GUIMenu_Principal extends JFrame{

	private static final long serialVersionUID = 1L;
	private MediadorPrincipal mediadorPrincipal;
	private JFrame frmPrincipal;

	public GUIMenu_Principal(MediadorPrincipal mediadorPrincipal) {
		this.mediadorPrincipal= mediadorPrincipal;
		initialize();
	}

	private void initialize() {
		frmPrincipal = new JFrame();
		String titulo = "USUARIO: "+mediadorPrincipal.getUsuario().getNombre_usuario().toString() +" [ID: "+mediadorPrincipal.getUsuario().getId().toString()+" ]";
		frmPrincipal.setTitle(titulo);
		frmPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(GUIMenu_Principal.class.getResource("/cliente/imagenes/tagle.ico")));
		frmPrincipal.setResizable(false);
		frmPrincipal.setBounds(100, 100, 800, 600);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmPrincipal.setJMenuBar(menuBar);
		
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
		mntmAltaReclamante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				mediadorPrincipal.altaReclamante();
				System.out.println("Alta Reclamante presionado");	
			}
		});
		mnReclamantes.add(mntmAltaReclamante);
		
		JMenuItem mntmGestionReclamante = new JMenuItem("Gestionar Reclamantes");
		mntmGestionReclamante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				mediadorPrincipal.gestionarReclamante();
				System.out.println("Gestionar Reclamantes presionado");	
			}
		});
		mnReclamantes.add(mntmGestionReclamante);
		
		JMenu mnVehiculos = new JMenu("Vehiculos");
		menuBar.add(mnVehiculos);
		
		JMenuItem mntmAltaVehiculo = new JMenuItem("Alta Vehiculo");
		mntmAltaVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				mediadorPrincipal.altaVehiculo();
				System.out.println("Alta Vehiculo presionado");	
			}
		});
		mnVehiculos.add(mntmAltaVehiculo);
		
		JMenuItem mntmGestionVehiculo = new JMenuItem("Gestionar Vehiculos");
		mntmGestionVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				mediadorPrincipal.gestionarVehiculo();
				System.out.println("Gestionar Vehiculo presionado");	
			}
		});
		mnVehiculos.add(mntmGestionVehiculo);
		
		JMenu mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);
		
		JMenuItem mntmAltaPedido = new JMenuItem("Alta Pedido");
		mntmAltaPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				mediadorPrincipal.altaPedido();
				System.out.println("Alta Pedido presionado");	
			}
		});
		mnPedido.add(mntmAltaPedido);
		
		JMenuItem mntmGestionPedido = new JMenuItem("Gestionar Pedidos");
		mntmGestionPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				mediadorPrincipal.gestionarPedido();
				System.out.println("Gestionar Pedido presionado");	
			}
		});
		mnPedido.add(mntmGestionPedido);
		
		JMenu mnReclamos = new JMenu("Reclamos");
		menuBar.add(mnReclamos);
		
		JMenuItem mntmAltaReclamo = new JMenuItem("Alta Reclamo");
		mntmAltaReclamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				mediadorPrincipal.altaReclamo();
				System.out.println("Alta Reclamo presionado");	
			}
		});
		mnReclamos.add(mntmAltaReclamo);
		
		JMenuItem mntmGestionReclamo = new JMenuItem("Gestionar Reclamos");
		mntmGestionReclamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				mediadorPrincipal.gestionarReclamo();
				System.out.println("Gestionar Reclamo presionado");	
			}
		});
		mnReclamos.add(mntmGestionReclamo);
		
		JMenu mnRecursos = new JMenu("Recursos");
		menuBar.add(mnRecursos);
		
		JMenuItem mntmAltaRecurso = new JMenuItem("Alta Recursos");
		mntmAltaRecurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				mediadorPrincipal.altaRecurso();
				System.out.println("Alta Recurso presionado");	
			}
		});
		mnRecursos.add(mntmAltaRecurso);
		
		JMenuItem mntmGestionRecurso = new JMenuItem("Gestionar Recursos");
		mntmGestionRecurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				mediadorPrincipal.gestionarRecurso();
				System.out.println("Gestionar Recurso presionado");	
			}
		});
		mnRecursos.add(mntmGestionRecurso);
		
		JMenu mnDevoluciones = new JMenu("Devoluciones");
		menuBar.add(mnDevoluciones);
		
		JMenuItem mntmAltaDevolucion = new JMenuItem("Alta Devolucion");
		mntmAltaDevolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				mediadorPrincipal.altaDevolucion();
				System.out.println("Alta Devolucion presionado");	
			}
		});
		mnDevoluciones.add(mntmAltaDevolucion);
		
		JMenuItem mntmGestiondevolucion = new JMenuItem("Gestionar Devoluciones");
		mntmGestiondevolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				mediadorPrincipal.gestionarDevolucion();
				System.out.println("Gestionar Devolucion presionado");	
			}
		});
		mnDevoluciones.add(mntmGestiondevolucion);
		
		JMenu mnNotificaciones = new JMenu("Notificaciones");
		menuBar.add(mnNotificaciones);
		
		JMenuItem mntmModificarNotificacio = new JMenuItem("Modificar Notificaciones");
		mntmModificarNotificacio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				mediadorPrincipal.gestionarNotificaciones();
				System.out.println("Gestionar Notificacion presionado");	
			}
		});
		mnNotificaciones.add(mntmModificarNotificacio);
		
		JMenuItem mntmActualizar = new JMenuItem("Actualizar");
		mntmActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				mediadorPrincipal.actualizarNotificaciones();
				System.out.println("Actualizar Notiicaciones presionado");	
			}
		});
		mnNotificaciones.add(mntmActualizar);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				mediadorPrincipal.ayuda();
				System.out.println("Ayuda presionado");	
			}
		});
		mnAyuda.add(mntmAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de..");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				JOptionPane.showMessageDialog(frmPrincipal,"IT 10 Cooperativa","Acerca de..",JOptionPane.INFORMATION_MESSAGE);
				System.out.println("Ayuda presionado");	
			}
		});
		mnAyuda.add(mntmAcercaDe);
		frmPrincipal.getContentPane().setLayout(null);
		
		JButton btnReclamos = new JButton("RECLAMOS");
		btnReclamos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				//mediadorPrincipal.
				System.out.println("Reclamos presionado");	
			}
		});
		btnReclamos.setBounds(104, 189, 250, 23);
		frmPrincipal.getContentPane().add(btnReclamos);
		
		JButton btnRepuestos = new JButton("REPUESTOS");
		btnRepuestos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				//mediadorPrincipal.
				System.out.println("Repuestos presionado");	
			}
		});
		btnRepuestos.setBounds(104, 249, 250, 23);
		frmPrincipal.getContentPane().add(btnRepuestos);
		
		JButton btnReportes = new JButton("REPORTES");
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				//mediadorPrincipal.
				System.out.println("Reportes presionado");	
			}
		});
		btnReportes.setBounds(104, 310, 250, 23);
		frmPrincipal.getContentPane().add(btnReportes);
		
		JPanel panel = new JPanel();
		panel.setBounds(433, 43, 331, 373);
		frmPrincipal.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		List lista_notificaciones = new List();
		panel.add(lista_notificaciones, BorderLayout.CENTER);
		
		JLabel lblNotificaciones = new JLabel("NOTIFICACIONES");
		lblNotificaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotificaciones.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNotificaciones.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNotificaciones.setBounds(524, 11, 126, 21);
		frmPrincipal.getContentPane().add(lblNotificaciones);
		
		JButton btnCompletado = new JButton("Completada");
		btnCompletado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompletado.setBounds(433, 455, 138, 23);
		frmPrincipal.getContentPane().add(btnCompletado);
		
		JButton btnPosponer = new JButton("Posponer");
		btnPosponer.setBounds(626, 455, 138, 23);
		frmPrincipal.getContentPane().add(btnPosponer);
	}

	public void setVisible(boolean b) {
		frmPrincipal.setVisible(b);
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
