package cliente.GestionarPedido;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import com.toedter.calendar.JDateChooser;

import common.DTOs.PiezaDTO;
import common.DTOs.ProveedorDTO;
import common.DTOs.ReclamoDTO;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class GUIAltaPedidoAgente extends JFrame{

	private static final long serialVersionUID = 1L;
	private MediadorPedido mediador;
	private JDateChooser fecha_solicitud_pedido;
	private JTextField tfNumero_Pedido;
	private JTextField tfReclamo;
	private JButton btnCancelar;
	private JButton btnCrear;
	private JButton btnBuscarReclamo;
	private JLabel lblNumeroPieza;
	private JTextField tfNumero_Pieza;
	private JTextArea taDescripcion;
	private JComboBox cb_proveedor;
	private JComboBox cbPiezas;
	private JButton btnAgregar;
	private JButton btnQuitar;
	
	private Vector<String> proveedores;
	private Vector<String> numeros_piezas;
 	private DefaultComboBoxModel<String> cmbProveedor;
 	private DefaultComboBoxModel<String> cmbPieza;
	private Vector<PiezaDTO> piezas;
	private ReclamoDTO reclamo;
	
	public GUIAltaPedidoAgente(final MediadorPedido medidador) {
		this.setMedidador(medidador);
		cargarDatos();
		initialize();
		SetVisible(true);
	}
	
	private void cargarDatos() {
		proveedores = new Vector<String> ();
		numeros_piezas = new Vector<String>();
		piezas = new Vector<PiezaDTO>();
		proveedores = mediador.obtenerProveedores();
		
	}

	private void initialize() {
		setTitle("AGREGAR PEDIDO AGENTE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIAltaPedidoAgente.class.getResource("/cliente/Resources/Icons/add_pedido_agente.png")));
		setBounds(100, 100, 446, 362);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
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
		
		JLabel lblReclamo = new JLabel("Reclamo");
		lblReclamo.setHorizontalAlignment(SwingConstants.CENTER);
		lblReclamo.setBounds(0, 72, 130, 20);
		getContentPane().add(lblReclamo);
		
		tfReclamo = new JTextField();
		tfReclamo.setEditable(false);
		tfReclamo.setBounds(138, 72, 163, 20);
		getContentPane().add(tfReclamo);
		tfReclamo.setColumns(10);
		
		btnBuscarReclamo = new JButton("Buscar");
		btnBuscarReclamo.setIcon(new ImageIcon(GUIAltaPedidoAgente.class.getResource("/cliente/Resources/Icons/1find.png")));
		btnBuscarReclamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mediador.buscarReclamoAgente();
			}
		});
		btnBuscarReclamo.setBounds(307, 72, 110, 20);
		getContentPane().add(btnBuscarReclamo);
		
		JLabel lblPiezas = new JLabel("Piezas");
		lblPiezas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPiezas.setBounds(0, 103, 130, 20);
		getContentPane().add(lblPiezas);
		
		cbPiezas = new JComboBox();
		cmbPieza = new DefaultComboBoxModel<String>(numeros_piezas);
		cbPiezas.setModel(cmbPieza);
		cbPiezas.setBounds(138, 103, 163, 20);
		getContentPane().add(cbPiezas);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(GUIAltaPedidoAgente.class.getResource("/cliente/Resources/Icons/add.png")));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregar();
			}
		});
		btnAgregar.setBounds(307, 103, 110, 20);
		getContentPane().add(btnAgregar);
		
		btnQuitar = new JButton("Quitar");
		btnQuitar.setIcon(new ImageIcon(GUIAltaPedidoAgente.class.getResource("/cliente/Resources/Icons/delete.png")));
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				quitar();
			}
		});
		btnQuitar.setBounds(307, 127, 110, 20);
		getContentPane().add(btnQuitar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(GUIAltaPedidoAgente.class.getResource("/cliente/Resources/Icons/cancel.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(55, 283, 110, 20);
		getContentPane().add(btnCancelar);
		
		btnCrear = new JButton("Crear");
		btnCrear.setIcon(new ImageIcon(GUIAltaPedidoAgente.class.getResource("/cliente/Resources/Icons/add.png")));
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crear();
			}
		});
		btnCrear.setBounds(272, 283, 110, 20);
		getContentPane().add(btnCrear);
		
		lblNumeroPieza = new JLabel("Numero Pieza");
		lblNumeroPieza.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroPieza.setBounds(0, 134, 130, 20);
		getContentPane().add(lblNumeroPieza);
		
		tfNumero_Pieza = new JTextField();
		tfNumero_Pieza.setColumns(10);
		tfNumero_Pieza.setBounds(138, 134, 163, 20);
		getContentPane().add(tfNumero_Pieza);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblProveedor.setBounds(0, 165, 130, 20);
		getContentPane().add(lblProveedor);
		
		cb_proveedor = new JComboBox();
		cmbProveedor = new DefaultComboBoxModel<String>(proveedores);
		cb_proveedor.setModel(cmbProveedor);
		cb_proveedor.setBounds(138, 165, 163, 20);
		getContentPane().add(cb_proveedor);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcion.setBounds(0, 196, 130, 20);
		getContentPane().add(lblDescripcion);
		
		taDescripcion = new JTextArea(4, 31);
		taDescripcion.setLineWrap(true);
		taDescripcion.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		taDescripcion.setBounds(138, 196, 256, 72);
		getContentPane().add(taDescripcion);
		
	}
		
	protected void crear() {
		if(tfNumero_Pedido.getText().isEmpty()||fecha_solicitud_pedido.getDate()==null||tfReclamo.getText().isEmpty()|| cbPiezas.getItemCount()<1){
			JOptionPane.showMessageDialog(this,"Algunos campos estan vacios.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
		}else{
			SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy"); 
			String fecha = format2.format(fecha_solicitud_pedido.getDate());
		    java.sql.Date fsp = new java.sql.Date(fecha_solicitud_pedido.getDate().getTime());
	
			if (mediador.nuevoPedido(tfNumero_Pedido.getText(),fsp,reclamo,piezas)){
				JOptionPane.showMessageDialog(null,"Reclamo Agregado.","Notificacion",JOptionPane.INFORMATION_MESSAGE);
				mediador.actualizarDatosGestion();
				dispose();
			}else{
				JOptionPane.showMessageDialog(null,"Error al agregar. Inente nuevamente.","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

	protected void agregar() {		
		if (tfNumero_Pieza.getText().isEmpty()|| cb_proveedor.getSelectedItem()==null){
			JOptionPane.showMessageDialog(this,"Algunos campos estan vacios.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
		}else{
			
			String numero_pieza = tfNumero_Pieza.getText();
			
			if (!numeros_piezas.contains(numero_pieza)){
				ProveedorDTO proveedor = mediador.obtenerProveedor(cb_proveedor.getSelectedItem().toString());
				PiezaDTO pieza = new PiezaDTO(numero_pieza, taDescripcion.getText(), proveedor);
				piezas.add(pieza);
				numeros_piezas.add(numero_pieza);
				cmbPieza = new DefaultComboBoxModel<String>(numeros_piezas);
				cbPiezas.setModel(cmbPieza);
				cbPiezas.setSelectedIndex(-1);
				cb_proveedor.setSelectedIndex(0);
				tfNumero_Pieza.setText("");
				taDescripcion.setText("");
			}else{
				JOptionPane.showMessageDialog(this,"Ya existe la pieza.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
			}
				
		}
		
	}

	protected void quitar() {
		if (numeros_piezas.contains((String)cbPiezas.getSelectedItem())){
			numeros_piezas.remove((String)cbPiezas.getSelectedItem());
			for (int i=0; i<piezas.size();i++){
				if (piezas.elementAt(i).getNumero_pieza().equals((String)cbPiezas.getSelectedItem())){
					piezas.remove(i);
				}
			}
			cmbPieza = new DefaultComboBoxModel<String>(numeros_piezas);
			cbPiezas.setModel(cmbPieza);
			cbPiezas.setSelectedIndex(-1);					
		}
		
	}

	public void SetVisible(boolean visible){
	}

	public MediadorPedido getMedidador() {
		return mediador;
	}

	public void setMedidador(MediadorPedido medidador) {
		this.mediador = medidador;
	}

	public void setReclamo(ReclamoDTO reclamo) {
		this.reclamo = reclamo;
		tfReclamo.setText(" [ID: "+reclamo.getId()+"]");
	}
}

