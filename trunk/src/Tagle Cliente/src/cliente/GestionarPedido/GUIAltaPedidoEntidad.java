package cliente.GestionarPedido;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class GUIAltaPedidoEntidad extends JFrame {

	private static final long serialVersionUID = 1L;
	private MediadorPedido medidador;
	private JDateChooser fecha_solicitud_pedido;
	private JDateChooser fecha_solicitud_fabrica;
	private JDateChooser fecha_recepcion_fabrica;
	private JTextField tfNumero_Pedido;
	private JLabel lblFechaSolicitudFabrica;
	private JLabel lblFechaRecepcionFabrica;
	private JLabel lblPnc;
	private JTextField tfPNC;
	private JTextField tfReclamo;
	private JButton btnCancelar;
	private JButton btnCrear;
	private JButton btnBuscarReclamo;
	private JLabel lblNumeroPieza;
	private JTextField tfNumero_Pieza;
	private JTextArea taDescripcion;
	private JComboBox cb_proveedor;
	private JComboBox comboBox;
	private JButton btnAgregar;
	private JButton btnQuitar;
	
	public GUIAltaPedidoEntidad(final MediadorPedido medidador, String nombre_reclamante, String email, String telefono) {
		this.setMedidador(medidador);
		initialize();
		SetVisible(true);
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public GUIAltaPedidoEntidad(final MediadorPedido medidador) {
		this.setMedidador(medidador);		
		initialize();
		SetVisible(true);
	}
	
	private void initialize() {
		setTitle("AGREGAR PEDIDO ENTIDAD");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 446, 484);
		getContentPane().setLayout(null);
		
		JLabel lblNumeroPedido = new JLabel("Numero Pedido");
		lblNumeroPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroPedido.setBounds(0, 10, 130, 20);
		getContentPane().add(lblNumeroPedido);
		
		tfNumero_Pedido = new JTextField();
		tfNumero_Pedido.setBounds(138, 10, 256, 20);
		getContentPane().add(tfNumero_Pedido);
		tfNumero_Pedido.setColumns(10);
		
		JLabel lblFechaSolicitud = new JLabel("Fecha Solicitud Pedido");
		lblFechaSolicitud.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaSolicitud.setBounds(0, 41, 130, 20);
		getContentPane().add(lblFechaSolicitud);
		
		fecha_solicitud_pedido = new JDateChooser();
		//fecha_solicitud_pedido.setDate(new Date());
		fecha_solicitud_pedido.setBounds(138, 41, 163, 20);
		getContentPane().add(fecha_solicitud_pedido);
		
		lblFechaSolicitudFabrica = new JLabel("Fecha Solicitud Fabrica");
		lblFechaSolicitudFabrica.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaSolicitudFabrica.setBounds(0, 72, 130, 20);
		getContentPane().add(lblFechaSolicitudFabrica);
		
		fecha_solicitud_fabrica = new JDateChooser();
		//fecha_solicitud_fabrica.setDate(new Date());
		fecha_solicitud_fabrica.setBounds(138, 72, 163, 20);
		getContentPane().add(fecha_solicitud_fabrica);
		
		lblFechaRecepcionFabrica = new JLabel("Fecha Recepcion Fabrica");
		lblFechaRecepcionFabrica.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaRecepcionFabrica.setBounds(0, 103, 130, 20);
		getContentPane().add(lblFechaRecepcionFabrica);
		
		fecha_recepcion_fabrica = new JDateChooser();
		//fecha_recepcion_fabrica.setDate(new Date());
		fecha_recepcion_fabrica.setBounds(138, 103, 163, 20);
		getContentPane().add(fecha_recepcion_fabrica);
		
		lblPnc = new JLabel("PNC");
		lblPnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblPnc.setBounds(0, 134, 130, 20);
		getContentPane().add(lblPnc);
		
		tfPNC = new JTextField();
		tfPNC.setBounds(138, 134, 256, 20);
		getContentPane().add(tfPNC);
		tfPNC.setColumns(10);
		
		JLabel lblReclamo = new JLabel("Reclamo");
		lblReclamo.setHorizontalAlignment(SwingConstants.CENTER);
		lblReclamo.setBounds(0, 165, 130, 20);
		getContentPane().add(lblReclamo);
		
		tfReclamo = new JTextField();
		tfReclamo.setEditable(false);
		tfReclamo.setBounds(138, 165, 163, 20);
		getContentPane().add(tfReclamo);
		tfReclamo.setColumns(10);
		
		btnBuscarReclamo = new JButton("Buscar");
		btnBuscarReclamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarReclamo.setBounds(307, 165, 87, 22);
		getContentPane().add(btnBuscarReclamo);
		
		JLabel lblPiezas = new JLabel("Piezas");
		lblPiezas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPiezas.setBounds(0, 196, 130, 20);
		getContentPane().add(lblPiezas);
		
		comboBox = new JComboBox();
		comboBox.setBounds(138, 196, 163, 20);
		getContentPane().add(comboBox);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregar();
			}
		});
		btnAgregar.setBounds(307, 196, 89, 20);
		getContentPane().add(btnAgregar);
		
		btnQuitar = new JButton("Quitar");
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				quitar();
			}
		});
		btnQuitar.setBounds(307, 217, 89, 20);
		getContentPane().add(btnQuitar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(92, 409, 110, 20);
		getContentPane().add(btnCancelar);
		
		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crear();
			}
		});
		btnCrear.setBounds(230, 409, 110, 20);
		getContentPane().add(btnCrear);
		
		lblNumeroPieza = new JLabel("Numero Pieza");
		lblNumeroPieza.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroPieza.setBounds(0, 222, 130, 20);
		getContentPane().add(lblNumeroPieza);
		
		tfNumero_Pieza = new JTextField();
		tfNumero_Pieza.setColumns(10);
		tfNumero_Pieza.setBounds(138, 222, 163, 20);
		getContentPane().add(tfNumero_Pieza);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblProveedor.setBounds(0, 248, 130, 20);
		getContentPane().add(lblProveedor);
		
		cb_proveedor = new JComboBox();
		cb_proveedor.setBounds(138, 248, 163, 20);
		getContentPane().add(cb_proveedor);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcion.setBounds(0, 279, 130, 20);
		getContentPane().add(lblDescripcion);
		
		taDescripcion = new JTextArea(4, 31);
		taDescripcion.setLineWrap(true);
		taDescripcion.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		taDescripcion.setBounds(138, 279, 256, 72);
		getContentPane().add(taDescripcion);
		
	}
		
	protected void crear() {
		// TODO Auto-generated method stub
		
	}

	protected void agregar() {
		// TODO Auto-generated method stub
		
	}

	protected void quitar() {
		// TODO Auto-generated method stub
		
	}

	public void SetVisible(boolean visible){
	}

	public MediadorPedido getMedidador() {
		return medidador;
	}

	public void setMedidador(MediadorPedido medidador) {
		this.medidador = medidador;
	}
}