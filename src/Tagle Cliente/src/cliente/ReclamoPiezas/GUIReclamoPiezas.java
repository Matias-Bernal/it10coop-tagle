package cliente.ReclamoPiezas;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import common.DTOs.Pedido_PiezaDTO;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIReclamoPiezas extends JFrame{

	private static final long serialVersionUID = 1L;
	private MediadorReclamoPiezas mediador;
	private NuevoReclamoFabrica reclamo_fabrica;
	private NuevoReclamoAgente reclamo_agente;
	
	private JTable tabla_reclamos_fabrica_A;
	private Vector<Vector<String>> datosTabla_A;
	private Vector<String> nombreColumnas_A;
	private DefaultTableModel modelo_A;
	private Vector<Integer> anchos_A;
	private Vector<Pedido_PiezaDTO> pedidos_piezas_A;
	
	
	private JTable tabla_reclamos_fabrica_E;
	private Vector<Vector<String>> datosTabla_E;
	private Vector<String> nombreColumnas_E;
	private DefaultTableModel modelo_E;
	private Vector<Integer> anchos_E;
	private Vector<Pedido_PiezaDTO> pedidos_piezas_E;

	
	public GUIReclamoPiezas(MediadorReclamoPiezas mediadorRepuesto) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIReclamoPiezas.class.getResource("/cliente/imagenes/tagle.ico")));
		setResizable(false);
		mediador = mediadorRepuesto;
		cargarDatos();
		initialize();
	}
	
	private void cargarDatos() {

		int chico = 100;
		int mediano = 150;
		int grande = 230;
		
		anchos_A = new Vector<Integer>();
		anchos_E = new Vector<Integer>();
		
		nombreColumnas_A = new Vector<String>();
		nombreColumnas_E = new Vector<String>();
		
		nombreColumnas_A.add("ID Pedido_Pieza");//0
		anchos_A.add(75);
		nombreColumnas_A.add("Numero Pedido");//1
		anchos_A.add(mediano);		
		nombreColumnas_A.add("Numero Pieza");//2
		anchos_A.add(mediano);		
		nombreColumnas_A.add("Descripcion");//3
		anchos_A.add(grande);		
		nombreColumnas_A.add("Numero Orden");//4
		anchos_A.add(mediano);
		nombreColumnas_A.add("Fecha Solicitud Fabrica");//5
		anchos_A.add(mediano);		
		nombreColumnas_A.add("Fecha Recepcion Fabrica");//6
		anchos_A.add(mediano);
		nombreColumnas_A.add("Fecha Envio Agente");//7
		anchos_A.add(mediano);
		nombreColumnas_A.add("Fecha Recepcion Agente");//8
		anchos_A.add(mediano);		
		nombreColumnas_A.add("Cantidad de Reclamos Fabrica");//9
		anchos_A.add(chico);
		nombreColumnas_A.add("Fecha Ultimo Reclamo Fabrica");//10
		anchos_A.add(grande);		
		nombreColumnas_A.add("Cantidad de Reclamos Agente");//11
		anchos_A.add(chico);
		nombreColumnas_A.add("Fecha Ultimo Reclamo Agente");//12
		anchos_A.add(grande);
		
		nombreColumnas_E.add("ID Pedido_Pieza");//0
		anchos_E.add(75);
		nombreColumnas_E.add("Numero Pedido");//1
		anchos_E.add(mediano);
		nombreColumnas_E.add("Numero Pieza");//2
		anchos_E.add(mediano);
		nombreColumnas_E.add("Descripcion");//3
		anchos_E.add(grande);
		nombreColumnas_E.add("Numero Orden");//4
		anchos_E.add(mediano);
		nombreColumnas_E.add("Fecha Solicitud Fabrica");//5
		anchos_E.add(mediano);
		nombreColumnas_E.add("Fecha Recepcion Fabrica");//6
		anchos_E.add(mediano);
		nombreColumnas_E.add("Cantidad de Reclamos Fabrica");//7
		anchos_E.add(chico);
		nombreColumnas_E.add("Fecha Ultimo Reclamo Fabrica");//8
		anchos_E.add(grande);
		

		
		modelo_A = new DefaultTableModel();
		modelo_E = new DefaultTableModel();
		
		datosTabla_A = new Vector<Vector<String>>();
		datosTabla_E = new Vector<Vector<String>>();

		pedidos_piezas_A = mediador.obtenerPedido_Pieza_Agente();
		pedidos_piezas_E = mediador.obtenerPedido_Pieza_Entidad();
		
		for (int i=0; i< pedidos_piezas_E.size();i++){
			Vector<String> row = new Vector<String> ();
			SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy");
			
			row.add(pedidos_piezas_E.elementAt(i).getId().toString());//ID Pedido_Pieza
			row.add(pedidos_piezas_E.elementAt(i).getNumero_pedido());//Numero Pedido
			row.add(pedidos_piezas_E.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
			row.add(pedidos_piezas_E.elementAt(i).getPieza().getDescripcion());//Descripcion
			row.add(pedidos_piezas_E.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
			
			if(pedidos_piezas_E.elementAt(i).getFecha_solicitud_fabrica()!=null){
				java.sql.Date fSf = new java.sql.Date(pedidos_piezas_E.elementAt(i).getFecha_solicitud_fabrica().getTime());
				row.add(format2.format(fSf));//Fecha Solicitud Fabrica
			}else{
				row.add("");
			}
			
			if(pedidos_piezas_E.elementAt(i).getFecha_recepcion_fabrica()!=null){
				java.sql.Date fRf = new java.sql.Date(pedidos_piezas_E.elementAt(i).getFecha_recepcion_fabrica().getTime());
				row.add(format2.format(fRf));//Fecha Recepcion Fabrica
			}else{
				row.add("");
			}
			
			row.add(mediador.cantidadReclamosFabrica(pedidos_piezas_E.elementAt(i)).toString());
						
			Date fecha_ultimo_reclamo_fabrica = mediador.obtenerUltimoReclamoFabrica(pedidos_piezas_E.elementAt(i));
			if(fecha_ultimo_reclamo_fabrica!=null){
				row.add(format2.format(fecha_ultimo_reclamo_fabrica.getTime()));//Fecha Ultimo Reclamo Fabrica
			}else{
				row.add("");
			}
			
			datosTabla_E.add(row);
		}
		modelo_E.setDataVector(datosTabla_E, nombreColumnas_E);
		modelo_E.fireTableStructureChanged();
		
		for (int i=0; i< pedidos_piezas_A.size();i++){
			Vector<String> row = new Vector<String> ();
			
			SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy");
			
			row.add(pedidos_piezas_A.elementAt(i).getId().toString());//ID Pedido_Pieza
			row.add(pedidos_piezas_A.elementAt(i).getNumero_pedido());//Numero Pedido
			row.add(pedidos_piezas_A.elementAt(i).getPieza().getNumero_pieza());//Numero Pieza
			row.add(pedidos_piezas_A.elementAt(i).getPieza().getDescripcion());//Descripcion
			row.add(pedidos_piezas_A.elementAt(i).getPedido().getReclamo().getOrden().getNumero_orden());//Numero Orden
			
			if(pedidos_piezas_A.elementAt(i).getFecha_solicitud_fabrica()!=null){
				java.sql.Date fSf = new java.sql.Date(pedidos_piezas_A.elementAt(i).getFecha_solicitud_fabrica().getTime());
				row.add(format2.format(fSf));//Fecha Solicitud Fabrica
			}else{
				row.add("");
			}
			
			if(pedidos_piezas_A.elementAt(i).getFecha_recepcion_fabrica()!=null){
				java.sql.Date fRf = new java.sql.Date(pedidos_piezas_A.elementAt(i).getFecha_recepcion_fabrica().getTime());
				row.add(format2.format(fRf));//Fecha Recepcion Fabrica
			}else{
				row.add("");
			}
			
			if(pedidos_piezas_A.elementAt(i).getFecha_envio_agente()!=null){
				java.sql.Date fEa = new java.sql.Date(pedidos_piezas_A.elementAt(i).getFecha_envio_agente().getTime());
				row.add(format2.format(fEa));//Fecha Envio Agente
			}else{
				row.add("");
			}
			
			if(pedidos_piezas_A.elementAt(i).getFecha_recepcion_agente()!=null){
				java.sql.Date fRa = new java.sql.Date(pedidos_piezas_A.elementAt(i).getFecha_recepcion_agente().getTime());
				row.add(format2.format(fRa));//Fecha Recepcion Agente
			}else{
				row.add("");
			}
			
			row.add(mediador.cantidadReclamosFabrica(pedidos_piezas_A.elementAt(i)).toString()); //Cantidad Reclamos Fabrica
			
			Date fecha_ultimo_reclamo_fabrica = mediador.obtenerUltimoReclamoFabrica(pedidos_piezas_A.elementAt(i));
			if(fecha_ultimo_reclamo_fabrica!=null){
				row.add(format2.format(fecha_ultimo_reclamo_fabrica.getTime()));//Fecha Ultimo Reclamo Fabrica
			}else{
				row.add("");
			}
			
			row.add(mediador.cantidadReclamosAgente(pedidos_piezas_A.elementAt(i)).toString());//Cantidad Reclamos Agente
			
			Date fecha_ultimo_reclamo_agente = mediador.obtenerUltimoReclamoAgente(pedidos_piezas_A.elementAt(i));
			if(fecha_ultimo_reclamo_agente!=null){
				row.add(format2.format(fecha_ultimo_reclamo_agente.getTime()));//Fecha Ultimo Reclamo Agente
			}else{
				row.add("");
			}
			datosTabla_A.add(row);
		}
		modelo_A.setDataVector(datosTabla_A, nombreColumnas_A);
		modelo_A.fireTableStructureChanged();
	}
	
	public void initialize(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1161, 680);
		setTitle("RECLAMOS");
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 1134, 620);
		getContentPane().add(tabbedPane);
		
		JPanel entidad = new JPanel();
		tabbedPane.addTab("ENTIDAD", null, entidad, null);
		entidad.setLayout(null);
			
		modelo_E = new DefaultTableModel(datosTabla_E, nombreColumnas_E);
		
		tabla_reclamos_fabrica_E = new JTable(modelo_E) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
//		tabla_reclamos_fabrica_E.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				if (e.getClickCount() == 2)
//					
//					//verReclamante();
//			    else{
//			    	e.consume();
//			    }   
//			}
//		});
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_E = new TableRowSorter<TableModel>(modelo_E);
		tabla_reclamos_fabrica_E.setRowSorter(ordenador_E);
		//
		tabla_reclamos_fabrica_E.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tabla_reclamos_fabrica_E.getColumnCount(); i++) {
			tabla_reclamos_fabrica_E.getColumnModel().getColumn(i).setPreferredWidth(anchos_E.elementAt(i));
			tabla_reclamos_fabrica_E.getColumnModel().getColumn(i).setMinWidth(anchos_E.elementAt(i));
		}
		tabla_reclamos_fabrica_E.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPaneTabla_E = new JScrollPane(tabla_reclamos_fabrica_E);
		scrollPaneTabla_E.setViewportView(tabla_reclamos_fabrica_E);
		tabla_reclamos_fabrica_E.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		scrollPaneTabla_E.setBounds(0, 90, 1129, 503);
		entidad.add(scrollPaneTabla_E);
		
		JButton btnModificarReclamoA = new JButton("Modificar Reclamo a Fabrica");
		btnModificarReclamoA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificarReclamoA.setBounds(215, 11, 195, 25);
		entidad.add(btnModificarReclamoA);
		
		JButton btnHacerReclamoFabrica = new JButton("Crear Reclamo a Fabrica");
		btnHacerReclamoFabrica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearReclamoFabricaE();
			}
		});
		btnHacerReclamoFabrica.setBounds(10, 11, 195, 25);
		entidad.add(btnHacerReclamoFabrica);
		
		JButton btnEliminarReclamoA = new JButton("Eliminar Reclamo a Fabrica");
		btnEliminarReclamoA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminarReclamoA.setBounds(420, 11, 195, 25);
		entidad.add(btnEliminarReclamoA);
		
		JButton button_3 = new JButton("Actualizar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setBounds(965, 11, 150, 25);
		entidad.add(button_3);
		
		JButton btnVerReclamosA = new JButton("Ver Reclamo/s a Fabrica");
		btnVerReclamosA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerReclamosA.setBounds(625, 11, 195, 25);
		entidad.add(btnVerReclamosA);
		
		JPanel agente = new JPanel();
		tabbedPane.addTab("AGENTE", null, agente, null);
		agente.setLayout(null);
				
		modelo_A = new DefaultTableModel(datosTabla_A, nombreColumnas_A);
		
		tabla_reclamos_fabrica_A = new JTable(modelo_A) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
//		tabla_reclamos_fabrica_A.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				if (e.getClickCount() == 2)
//					
//					//verReclamante();
//			    else{
//			    	e.consume();
//			    }   
//			}
//		});
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_A = new TableRowSorter<TableModel>(modelo_A);
		tabla_reclamos_fabrica_A.setRowSorter(ordenador_A);
		//
		tabla_reclamos_fabrica_A.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tabla_reclamos_fabrica_A.getColumnCount(); i++) {
			tabla_reclamos_fabrica_A.getColumnModel().getColumn(i).setPreferredWidth(anchos_A.elementAt(i));
			tabla_reclamos_fabrica_A.getColumnModel().getColumn(i).setMinWidth(anchos_A.elementAt(i));
		}
		tabla_reclamos_fabrica_A.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPaneTabla_A = new JScrollPane(tabla_reclamos_fabrica_A);
		scrollPaneTabla_A.setViewportView(tabla_reclamos_fabrica_A);
		tabla_reclamos_fabrica_A.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		scrollPaneTabla_A.setBounds(0, 90, 1129, 502);
		agente.add(scrollPaneTabla_A);
		
		JButton button = new JButton("Ver Reclamo/s a Fabrica");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(625, 11, 195, 25);
		agente.add(button);
		
		JButton button_1 = new JButton("Actualizar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(965, 11, 150, 25);
		agente.add(button_1);
		
		JButton button_2 = new JButton("Crear Reclamo a Fabrica");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(10, 11, 195, 25);
		agente.add(button_2);
		
		JButton button_4 = new JButton("Modificar Reclamo a Fabrica");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_4.setBounds(215, 11, 195, 25);
		agente.add(button_4);
		
		JButton button_5 = new JButton("Eliminar Reclamo a Fabrica");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_5.setBounds(420, 11, 195, 25);
		agente.add(button_5);
		
		JButton btnVerReclamosA_1 = new JButton("Ver Reclamo/s a Agente");
		btnVerReclamosA_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerReclamosA_1.setBounds(625, 47, 195, 25);
		agente.add(btnVerReclamosA_1);
		
		JButton btnCrearReclamoA = new JButton("Crear Reclamo a Agente");
		btnCrearReclamoA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tabla_reclamos_fabrica_A.getSelectedRow();
				if (row >= 0) {
					int aux = tabla_reclamos_fabrica_A.convertRowIndexToModel(row);
					Long id = new Long (tabla_reclamos_fabrica_A.getValueAt(aux, 0).toString());

					Pedido_PiezaDTO pedido_pieza = mediador.buscarPedido_Pieza(id);
					if(pedido_pieza!=null)
						reclamo_agente = new NuevoReclamoAgente(mediador, pedido_pieza, mediador.getMediadorPrincipal().getUsuario());
						reclamo_agente.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null,"Seleccione un usuario primero.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnCrearReclamoA.setBounds(10, 47, 195, 25);
		agente.add(btnCrearReclamoA);
		
		JButton btnModificarReclamoA_1 = new JButton("Modificar Reclamo a Agente");
		btnModificarReclamoA_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificarReclamoA_1.setBounds(215, 47, 195, 25);
		agente.add(btnModificarReclamoA_1);
		
		JButton btnEliminarReclamoA_1 = new JButton("Eliminar Reclamo a Agente");
		btnEliminarReclamoA_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminarReclamoA_1.setBounds(420, 47, 195, 25);
		agente.add(btnEliminarReclamoA_1);
	}

	protected void crearReclamoFabricaE() {
		int row = tabla_reclamos_fabrica_E.getSelectedRow();
		if (row >= 0) {
			int aux = tabla_reclamos_fabrica_E.convertRowIndexToModel(row);
			Long id = new Long (tabla_reclamos_fabrica_E.getValueAt(aux, 0).toString());

			Pedido_PiezaDTO pedido_pieza = mediador.buscarPedido_Pieza(id);
			if(pedido_pieza!=null)
				reclamo_fabrica = new NuevoReclamoFabrica(mediador, pedido_pieza, mediador.getMediadorPrincipal().getUsuario());
				reclamo_fabrica.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(null,"Seleccione un usuario primero.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
}