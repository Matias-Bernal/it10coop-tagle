package cliente.GestionarReclamo;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import common.DTOs.EntidadDTO;
import common.DTOs.ReclamoDTO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

public class GUIGestionReclamoEntidad extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private MediadorReclamo mediador;
	private JComboBox entidad;
	private JDateChooser fecha_reclamo;
	private JDateChooser fecha_turno;
	private JTextField nombre_reclamante;
	private JTextField dni_reclamante;
	private JTextField nombre_titular;
	private JTextField dominio;
	private JTextField vin;
	private JTextField numero_orden;
	private JComboBox estado_reclamo;
	private DefaultTableModel modelo;
	private JTable tableRegistrantes;
	private Vector<Vector<String>> datosTabla;
	private Vector nombreColumnas;
	private Vector<String> entidades;
	private Vector<String> estados_reclamo;
	private DefaultComboBoxModel<String> cmbEstado_reclamo;
	private DefaultComboBoxModel<String> cmbEntidad;

	public GUIGestionReclamoEntidad(MediadorReclamo mediadorReclamo) {
		this.setMediadorReclamo(mediadorReclamo);
		cargarDatos();
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setTitle("GESTIONAR RECLAMO ENTIDAD");
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEntidad = new JLabel("Entidad");
		lblEntidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntidad.setBounds(10, 11, 130, 20);
		contentPane.add(lblEntidad);
		
		entidad = new JComboBox();
		cmbEntidad = new DefaultComboBoxModel<String>(entidades);
		entidad.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				filtrarPorEntidad();
			}
		});
		entidad.setModel(cmbEntidad);
		entidad.setBounds(161, 11, 185, 20);
		contentPane.add(entidad);
		
		JLabel label = new JLabel("Fecha Reclamo");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(356, 44, 130, 20);
		contentPane.add(label);
		
		fecha_reclamo = new JDateChooser();
		fecha_reclamo.setBounds(506, 44, 130, 20);
		contentPane.add(fecha_reclamo);
		
		JLabel lblFechaTurno = new JLabel("Fecha Turno");
		lblFechaTurno.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaTurno.setBounds(356, 75, 130, 20);
		contentPane.add(lblFechaTurno);
		
		fecha_turno = new JDateChooser();
		fecha_turno.setBounds(506, 75, 130, 20);
		contentPane.add(fecha_turno);
		
		JLabel lblEstadoReclamo = new JLabel("Estado Reclamo");
		lblEstadoReclamo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadoReclamo.setBounds(356, 11, 130, 20);
		contentPane.add(lblEstadoReclamo);
		
		estado_reclamo = new JComboBox();
		cmbEstado_reclamo = new DefaultComboBoxModel<String>(estados_reclamo);
		estado_reclamo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				filtrarPorEstado_Pedido();
			}
		});
		estado_reclamo.setModel(cmbEstado_reclamo);
		estado_reclamo.setBounds(507, 11, 185, 20);
		contentPane.add(estado_reclamo);
		
		JLabel lblNombreReclamante = new JLabel("Nombre Reclamante");
		lblNombreReclamante.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreReclamante.setBounds(10, 42, 130, 20);
		contentPane.add(lblNombreReclamante);
		
		nombre_reclamante = new JTextField();
		nombre_reclamante.setBounds(161, 42, 185, 20);
		contentPane.add(nombre_reclamante);
		nombre_reclamante.setColumns(10);
		
		JLabel lblDniReclamante = new JLabel("DNI Reclamante");
		lblDniReclamante.setHorizontalAlignment(SwingConstants.CENTER);
		lblDniReclamante.setBounds(10, 75, 130, 20);
		contentPane.add(lblDniReclamante);
		
		dni_reclamante = new JTextField();
		dni_reclamante.setColumns(10);
		dni_reclamante.setBounds(161, 75, 130, 20);
		contentPane.add(dni_reclamante);
		
		JLabel lblNombreTitular = new JLabel("Nombre Titular");
		lblNombreTitular.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreTitular.setBounds(10, 106, 130, 20);
		contentPane.add(lblNombreTitular);
		
		nombre_titular = new JTextField();
		nombre_titular.setColumns(10);
		nombre_titular.setBounds(161, 106, 185, 20);
		contentPane.add(nombre_titular);
		
		JLabel lblDominio = new JLabel("Dominio");
		lblDominio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDominio.setBounds(10, 139, 130, 20);
		contentPane.add(lblDominio);
		
		dominio = new JTextField();
		dominio.setColumns(10);
		dominio.setBounds(161, 139, 130, 20);
		contentPane.add(dominio);
		
		JLabel lblVin = new JLabel("VIN");
		lblVin.setHorizontalAlignment(SwingConstants.CENTER);
		lblVin.setBounds(10, 170, 130, 20);
		contentPane.add(lblVin);
		
		vin = new JTextField();
		vin.setColumns(10);
		vin.setBounds(161, 170, 130, 20);
		contentPane.add(vin);
		
		JLabel lblNumeroOrden = new JLabel("Numero Orden");
		lblNumeroOrden.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroOrden.setBounds(356, 106, 130, 20);
		contentPane.add(lblNumeroOrden);
		
		numero_orden = new JTextField();
		numero_orden.setColumns(10);
		numero_orden.setBounds(507, 106, 130, 20);
		contentPane.add(numero_orden);
		
		modelo = new DefaultTableModel(datosTabla, nombreColumnas);
		
		tableRegistrantes = new JTable(modelo) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tableRegistrantes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getClickCount() == 2)
					verReclamante();
			    else{
			    	e.consume();
			    }   
			}
		});
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador = new TableRowSorter<TableModel>(modelo);
		tableRegistrantes.setRowSorter(ordenador);
		//
		tableRegistrantes.getTableHeader().setReorderingAllowed(false);
		tableRegistrantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableRegistrantes.setBounds(0, 0, 765, 320);
		
		JScrollPane scrollPaneTabla = new JScrollPane(tableRegistrantes);
		scrollPaneTabla.setBounds(10, 202, 1254, 426);
		contentPane.add(scrollPaneTabla);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizarDatos();
			}
		});
		btnActualizar.setBounds(920, 136, 315, 23);
		contentPane.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminar();
			}
		});
		btnEliminar.setBounds(920, 102, 315, 23);
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificar();
			}
		});
		btnModificar.setBounds(920, 68, 315, 23);
		contentPane.add(btnModificar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarNuevoReclamoEntidad();
			}
		});
		btnAgregar.setBounds(920, 33, 315, 23);
		contentPane.add(btnAgregar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVolver.setBounds(810, 639, 150, 23);
		contentPane.add(btnVolver);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tableRegistrantes.print();
				} catch (PrinterException ex) {
					JOptionPane.showMessageDialog(contentPane,"Error al imprimir.","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnImprimir.setBounds(562, 639, 150, 23);
		contentPane.add(btnImprimir);
		
		JButton btnVer = new JButton("Ver Reclamante");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verReclamante();
			}
		});
		btnVer.setBounds(320, 639, 150, 23);
		contentPane.add(btnVer);
	}
	
	protected void filtrarPorEntidad() {
		String filtro = entidad.getSelectedItem().toString().toLowerCase();
		Vector<Vector<String>> datos = new Vector<Vector<String>>();
		for (int i=0; i< datosTabla.size();i++){
			Vector<String> reclamo = datosTabla.elementAt(i);
			
			Pattern pat = Pattern.compile(".*"+filtro+".*");
			Matcher mat = pat.matcher(reclamo.elementAt(4).toLowerCase());
			if (mat.find()) {
				datos.add(reclamo);
			} 
		}
		modelo.setDataVector(datos, nombreColumnas);
		modelo.fireTableStructureChanged();
	}

	protected void filtrarPorEstado_Pedido() {
		String filtro = entidad.getSelectedItem().toString().toLowerCase();
		Vector<Vector<String>> datos = new Vector<Vector<String>>();
		for (int i=0; i< datosTabla.size();i++){
			Vector<String> reclamo = datosTabla.elementAt(i);
			
			Pattern pat = Pattern.compile(".*"+filtro+".*");
			Matcher mat = pat.matcher(reclamo.elementAt(3).toLowerCase());
			if (mat.find()) {
				datos.add(reclamo);
			} 
		}
		modelo.setDataVector(datos, nombreColumnas);
		modelo.fireTableStructureChanged();
	}

	protected void verReclamante() {
		int row = tableRegistrantes.getSelectedRow();
		if (row >= 0) {
			String dni = tableRegistrantes.getValueAt(row, 6).toString();
			mediador.verRegistrante(dni);
		}else{
			JOptionPane.showMessageDialog(contentPane,"Seleccione un reclamante primero.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
		}
	}

	protected void agregarNuevoReclamoEntidad() {

	}

	protected void eliminar() {
		int row = tableRegistrantes.getSelectedRow();
		if (row >= 0) {
			Long id = new Long (tableRegistrantes.getValueAt(row, 0).toString());
			if (JOptionPane.showConfirmDialog(null, "┐Eliminar Reclamo [ID:"+id+"]?, Esto eliminara todos sus componenetes.", "Confirmar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){ 
				mediador.eliminarReclamoEntidad(id);
				actualizarDatos();
			}
		}else{
			JOptionPane.showMessageDialog(contentPane,"Seleccione un reclamante primero.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
		}
	}

	protected void modificar() {
		int row = tableRegistrantes.getSelectedRow();
		if (row >= 0) {
			int aux = tableRegistrantes.convertRowIndexToModel(row);
			Long id = new Long (tableRegistrantes.getValueAt(aux, 0).toString());
			if (JOptionPane.showConfirmDialog(null, "┐Modificar Reclamo [ID:"+id+"]?", "Confirmar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){ 
				mediador.modificarReclamoEntidad(id);;
				actualizarDatos();
			}
		}else{
			JOptionPane.showMessageDialog(contentPane,"Seleccione un regsitrante primero.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

	public void SetVisible(boolean visible){
		contentPane.setVisible(visible);
	}

	public MediadorReclamo getMediadorReclamo() {
		return mediador;
	}

	public void setMediadorReclamo(MediadorReclamo mediadorReclamo) {
		this.mediador = mediadorReclamo;
	}

	private void cargarDatos() {
		
		entidades = new Vector<String>();
		entidades.add("");
		Vector<EntidadDTO> entidadesDTO = mediador.obtenerEntidades();
		for (int i=0; i< entidadesDTO.size();i++){
			entidades.add(entidadesDTO.elementAt(i).getNombre_registrante());
		};

		nombreColumnas = new Vector<String> ();
		nombreColumnas.add("ID Reclamo");
		nombreColumnas.add("Fecha Reclamo");
		nombreColumnas.add("Fecha Turno");
		nombreColumnas.add("Estado Reclamo");
		nombreColumnas.add("Entidad");
		nombreColumnas.add("Nombre Reclamante");
		nombreColumnas.add("DNI Reclamante");
		nombreColumnas.add("Nombre Titular");
		nombreColumnas.add("Dominio");
		nombreColumnas.add("VIN");
		nombreColumnas.add("Inmovilizado");
		nombreColumnas.add("Peligroso");
		nombreColumnas.add("Numero Orden");
		
		estados_reclamo = new Vector<String>();
		estados_reclamo.add("");
		estados_reclamo.add("ABIERTO/SIN PEDIDO/SIN TURNO");
		estados_reclamo.add("ABIERTO/SIN PEDIDO/CON TURNO");
		estados_reclamo.add("ABIERTO/CON PEDIDO/SIN TURNO");
		estados_reclamo.add("ABIERTO/CON PEDIDO/CON TURNO");
		estados_reclamo.add("CERRADO");
				
		modelo = new DefaultTableModel();
		datosTabla = new Vector<Vector<String>>();
		Vector<ReclamoDTO> reclamos = mediador.obtenerReclamos();
		for (int i=0; i< reclamos.size();i++){
			if (reclamos.elementAt(i).getRegistrante()!=null && mediador.esEntidad(reclamos.elementAt(i).getRegistrante())){
				Vector<String> row = new Vector<String> ();
				
				row.add(reclamos.elementAt(i).getId().toString());
				if(reclamos.elementAt(i).getFecha_reclamo()!=null){
					row.add(reclamos.elementAt(i).getFecha_reclamo().toString());
				}else{
					row.add("");
				}
				if(reclamos.elementAt(i).getFecha_turno()!=null){
					row.add(reclamos.elementAt(i).getFecha_turno().toString());
				}else{
					row.add("");
				}
				row.add(reclamos.elementAt(i).getEstado_reclamo());
				row.add(reclamos.elementAt(i).getRegistrante().getNombre_registrante());
				if(reclamos.elementAt(i).getReclamante()!=null){
					row.add(reclamos.elementAt(i).getReclamante().getNombre_apellido());
					row.add(reclamos.elementAt(i).getReclamante().getDni());
				}else{
					row.add("");
					row.add("");
				}
				if(reclamos.elementAt(i).getVehiculo()!=null){
					row.add(reclamos.elementAt(i).getVehiculo().getNombre_titular());
					row.add(reclamos.elementAt(i).getVehiculo().getDominio());
					row.add(reclamos.elementAt(i).getVehiculo().getVin());
				}else{
					row.add("");
					row.add("");
					row.add("");
				}
				if(reclamos.elementAt(i).getInmovilizado()!=null){
					if(reclamos.elementAt(i).getInmovilizado()){
						row.add("SI");
					}else{
						row.add("NO");
					}
				}else{
					row.add("");
				}
				if(reclamos.elementAt(i).getPeligroso()!=null){
					if(reclamos.elementAt(i).getPeligroso()){
						row.add("SI");
					}else{
						row.add("NO");
					}	
				}else{
					row.add("");
				}
				if(reclamos.elementAt(i).getOrden()!=null){
					row.add(reclamos.elementAt(i).getOrden().getNumero_orden());
				}else{
					row.add("");
				}
				datosTabla.add(row);
			}
		}	
		modelo.setDataVector(datosTabla, nombreColumnas);
		tableRegistrantes = new JTable(modelo) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		
	}

	public void actualizarDatos() {
		datosTabla = new Vector<Vector<String>>();
		Vector<ReclamoDTO> reclamos = mediador.obtenerReclamos();
		for (int i=0; i< reclamos.size();i++){
			if (reclamos.elementAt(i).getRegistrante()!=null && mediador.esEntidad(reclamos.elementAt(i).getRegistrante())){
				Vector<String> row = new Vector<String> ();
				
				row.add(reclamos.elementAt(i).getId().toString());
				if(reclamos.elementAt(i).getFecha_reclamo()!=null){
					row.add(reclamos.elementAt(i).getFecha_reclamo().toString());
				}else{
					row.add("");
				}
				if(reclamos.elementAt(i).getFecha_turno()!=null){
					row.add(reclamos.elementAt(i).getFecha_turno().toString());
				}else{
					row.add("");
				}
				row.add(reclamos.elementAt(i).getEstado_reclamo());
				row.add(reclamos.elementAt(i).getRegistrante().getNombre_registrante());
				if(reclamos.elementAt(i).getReclamante()!=null){
					row.add(reclamos.elementAt(i).getReclamante().getNombre_apellido());
					row.add(reclamos.elementAt(i).getReclamante().getDni());
				}else{
					row.add("");
					row.add("");
				}
				if(reclamos.elementAt(i).getVehiculo()!=null){
					row.add(reclamos.elementAt(i).getVehiculo().getNombre_titular());
					row.add(reclamos.elementAt(i).getVehiculo().getDominio());
					row.add(reclamos.elementAt(i).getVehiculo().getVin());
				}else{
					row.add("");
					row.add("");
					row.add("");
				}
				if(reclamos.elementAt(i).getInmovilizado()!=null){
					if(reclamos.elementAt(i).getInmovilizado()){
						row.add("SI");
					}else{
						row.add("NO");
					}
				}else{
					row.add("");
				}
				if(reclamos.elementAt(i).getPeligroso()!=null){
					if(reclamos.elementAt(i).getPeligroso()){
						row.add("SI");
					}else{
						row.add("NO");
					}	
				}else{
					row.add("");
				}
				if(reclamos.elementAt(i).getOrden()!=null){
					row.add(reclamos.elementAt(i).getOrden().getNumero_orden());
				}else{
					row.add("");
				}
				datosTabla.add(row);
			}
		}	
		modelo.setDataVector(datosTabla, nombreColumnas);
		modelo.fireTableStructureChanged();
		entidad.setSelectedIndex(0);
		estado_reclamo.setSelectedIndex(0);;
		
		nombre_reclamante.setText("");
		dni_reclamante.setText("");
		nombre_titular.setText("");
		dominio.setText("");
		vin.setText("");
		fecha_reclamo.setDate(null);
		fecha_turno.setDate(null);
		numero_orden.setText("");
		}
}
