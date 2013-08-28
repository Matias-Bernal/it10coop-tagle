package cliente.principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.AbstractListModel;
import java.awt.BorderLayout;
import java.awt.List;
import java.awt.Choice;

public class GUIMenu_Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMenu_Principal window = new GUIMenu_Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIMenu_Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		JMenuItem mntmDesconectar = new JMenuItem("Desconectar");
		mnInicio.add(mntmDesconectar);
		
		JMenuItem mntmUsusarios = new JMenuItem("Ususarios");
		mnInicio.add(mntmUsusarios);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnInicio.add(mntmSalir);
		
		JMenu mnRegistrantes = new JMenu("Registrantes");
		menuBar.add(mnRegistrantes);
		
		JMenuItem mntmAltaRegistrante = new JMenuItem("Alta Registrante");
		mnRegistrantes.add(mntmAltaRegistrante);
		
		JMenuItem mntmBajaRegistrante = new JMenuItem("Baja Registrante");
		mnRegistrantes.add(mntmBajaRegistrante);
		
		JMenuItem mntmModificarRegistrante = new JMenuItem("Modificar Registrante");
		mnRegistrantes.add(mntmModificarRegistrante);
		
		JMenuItem mntmBuscarRegistrante = new JMenuItem("Buscar Registrante");
		mnRegistrantes.add(mntmBuscarRegistrante);
		
		JMenu mnVehiculos = new JMenu("Vehiculos");
		menuBar.add(mnVehiculos);
		
		JMenuItem mntmAltaVehiculo = new JMenuItem("Alta Vehiculo");
		mnVehiculos.add(mntmAltaVehiculo);
		
		JMenuItem mntmBajaVehiculo = new JMenuItem("Baja Vehiculo");
		mnVehiculos.add(mntmBajaVehiculo);
		
		JMenuItem mntmModificarVehiculo = new JMenuItem("Modificar Vehiculo");
		mnVehiculos.add(mntmModificarVehiculo);
		
		JMenuItem mntmBuscarVehiculo = new JMenuItem("Buscar Vehiculo");
		mnVehiculos.add(mntmBuscarVehiculo);
		
		JMenu mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);
		
		JMenuItem mntmAltaPedido = new JMenuItem("Alta Pedido");
		mnPedido.add(mntmAltaPedido);
		
		JMenuItem mntmBajaPedido = new JMenuItem("Baja Pedido");
		mnPedido.add(mntmBajaPedido);
		
		JMenuItem mntmModificarPedido = new JMenuItem("Modificar Pedido");
		mnPedido.add(mntmModificarPedido);
		
		JMenuItem mntmBuscarPedido = new JMenuItem("Buscar Pedido");
		mnPedido.add(mntmBuscarPedido);
		
		JMenuItem mntmDevolucion = new JMenuItem("Devolucion/es");
		mnPedido.add(mntmDevolucion);
		
		JMenuItem mntmActualizarEstado = new JMenuItem("Actualizar Estado");
		mnPedido.add(mntmActualizarEstado);
		
		JMenuItem mntmReclamoAFabrica = new JMenuItem("Reclamo a Fabrica");
		mnPedido.add(mntmReclamoAFabrica);
		
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
		frame.getContentPane().setLayout(null);
		
		JButton btnReclamos = new JButton("RECLAMOS");
		btnReclamos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnReclamos.setBounds(104, 189, 250, 23);
		frame.getContentPane().add(btnReclamos);
		
		JButton btnRepuestos = new JButton("REPUESTOS");
		btnRepuestos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRepuestos.setBounds(104, 249, 250, 23);
		frame.getContentPane().add(btnRepuestos);
		
		JButton btnReportes = new JButton("REPORTES");
		btnReportes.setBounds(104, 310, 250, 23);
		frame.getContentPane().add(btnReportes);
		
		JPanel panel = new JPanel();
		panel.setBounds(433, 43, 331, 373);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		List lista_tareas = new List();
		panel.add(lista_tareas, BorderLayout.CENTER);
		
		JLabel lblActividades = new JLabel("ACTIVIDADES");
		lblActividades.setHorizontalAlignment(SwingConstants.CENTER);
		lblActividades.setHorizontalTextPosition(SwingConstants.CENTER);
		lblActividades.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblActividades.setBounds(524, 11, 126, 21);
		frame.getContentPane().add(lblActividades);
		
		JButton btnCompletado = new JButton("Completado");
		btnCompletado.setBounds(480, 455, 89, 23);
		frame.getContentPane().add(btnCompletado);
		
		JButton btnPosponer = new JButton("Posponer");
		btnPosponer.setBounds(636, 455, 89, 23);
		frame.getContentPane().add(btnPosponer);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
