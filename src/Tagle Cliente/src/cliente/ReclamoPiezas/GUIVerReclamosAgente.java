package cliente.ReclamoPiezas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import common.DTOs.Pedido_PiezaDTO;
import common.DTOs.Pedido_Pieza_Reclamo_AgenteDTO;
import common.DTOs.Reclamo_AgenteDTO;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class GUIVerReclamosAgente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MediadorReclamoPiezas mediador;
	private Pedido_PiezaDTO pedido_pieza;
	private JTable tabla_reclamos;
	private JButton btnVerReclamo;
	private JButton btnVolver;
	private DefaultTableModel modelo_tabla_reclamos;
	private Vector<Vector<String>> datosTabla_tabla_reclamos;
	private Vector<String> nombreColumnas_tabla_reclamos;
	private Vector<Integer> anchos_tabla_reclamos;
	private Vector<Pedido_Pieza_Reclamo_AgenteDTO> reclamos_agente;


	public GUIVerReclamosAgente(MediadorReclamoPiezas mediador, Pedido_PiezaDTO pedido_pieza) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIVerReclamosAgente.class.getResource("/cliente/Resources/Icons/registrante_solo.png")));
		setResizable(false);
		setTitle("RECLAMOS A AGENTE");
		this.mediador = mediador;
		this.pedido_pieza = pedido_pieza;
		cargarDatos();
		initialize();
	}
	private void cargarDatos() {
		int mediano = 150;
		int grande = 230;
		
		//TABLA RECLAMOS FABRICA
		anchos_tabla_reclamos = new Vector<Integer>();	
		nombreColumnas_tabla_reclamos = new Vector<String>();

		nombreColumnas_tabla_reclamos.add("ID Reclamo Agente");//0
		anchos_tabla_reclamos.add(75);
		nombreColumnas_tabla_reclamos.add("Numero Pedido");//1
		anchos_tabla_reclamos.add(mediano);
		nombreColumnas_tabla_reclamos.add("Numero Pieza");//2
		anchos_tabla_reclamos.add(mediano);
		nombreColumnas_tabla_reclamos.add("Descripcion Pieza");//4
		anchos_tabla_reclamos.add(grande);
		nombreColumnas_tabla_reclamos.add("Agente");//5
		anchos_tabla_reclamos.add(grande);
		nombreColumnas_tabla_reclamos.add("Fecha Reclamo");//6
		anchos_tabla_reclamos.add(grande);
		nombreColumnas_tabla_reclamos.add("Descripcion Reclamo");//7
		anchos_tabla_reclamos.add(grande);
		nombreColumnas_tabla_reclamos.add("Usuario");//8
		anchos_tabla_reclamos.add(grande);
		
		modelo_tabla_reclamos = new DefaultTableModel();
		datosTabla_tabla_reclamos = new Vector<Vector<String>>();
		reclamos_agente = mediador.obtenerReclamoAgente(pedido_pieza);
		
		for (int i=0; i< reclamos_agente.size();i++){
			Vector<String> row = new Vector<String> ();
			SimpleDateFormat format2=new SimpleDateFormat("dd/MM/yyyy");
			
			row.add(reclamos_agente.elementAt(i).getId().toString());//ID Reclamo Agente
			row.add(pedido_pieza.getNumero_pedido());//Numero Pedido
			row.add(pedido_pieza.getPieza().getNumero_pieza());//Numero Pieza
			row.add(pedido_pieza.getPieza().getDescripcion());//Decripcion Pieza
			row.add(pedido_pieza.getPedido().getReclamo().getRegistrante().getNombre_registrante());//Agente
			if(reclamos_agente.elementAt(i).getReclamo_agente().getFecha_reclamo_agente()!=null){
				java.sql.Date freclamo = new java.sql.Date(reclamos_agente.elementAt(i).getReclamo_agente().getFecha_reclamo_agente().getTime());
				row.add(format2.format(freclamo));//Fecha Reclamo
			}else{
				row.add("");
			}
			row.add(reclamos_agente.elementAt(i).getReclamo_agente().getDescripcion());//Decripcion Reclamo
			row.add(reclamos_agente.elementAt(i).getReclamo_agente().getUsuario().getNombre_usuario());//Usuario
			
			datosTabla_tabla_reclamos.add(row);
		}
		modelo_tabla_reclamos.setDataVector(datosTabla_tabla_reclamos, nombreColumnas_tabla_reclamos);
		modelo_tabla_reclamos.fireTableStructureChanged();

	}
	public void initialize(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		modelo_tabla_reclamos = new DefaultTableModel(datosTabla_tabla_reclamos, nombreColumnas_tabla_reclamos);
		
		tabla_reclamos = new JTable(modelo_tabla_reclamos) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false,false,
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tabla_reclamos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getClickCount() == 2)
					verReclamo();
			    else{
			    	e.consume();
			    }   
			}
		});
		// Agregamos el ordenador para las tablas de los usuarios
		TableRowSorter<TableModel> ordenador_reclamos_fabrica = new TableRowSorter<TableModel>(modelo_tabla_reclamos);
		tabla_reclamos.setRowSorter(ordenador_reclamos_fabrica);
		//
		tabla_reclamos.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tabla_reclamos.getColumnCount(); i++) {
			tabla_reclamos.getColumnModel().getColumn(i).setPreferredWidth(anchos_tabla_reclamos.elementAt(i));
			tabla_reclamos.getColumnModel().getColumn(i).setMinWidth(anchos_tabla_reclamos.elementAt(i));
		}
		tabla_reclamos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPaneTabla_reclamos_fabrica = new JScrollPane(tabla_reclamos);
		scrollPaneTabla_reclamos_fabrica.setViewportView(tabla_reclamos);
		tabla_reclamos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		scrollPaneTabla_reclamos_fabrica.setBounds(10, 11, 664, 394);
		contentPane.add(scrollPaneTabla_reclamos_fabrica);
				
		btnVerReclamo = new JButton("Ver Reclamo");
		btnVerReclamo.setIcon(new ImageIcon(GUIVerReclamosAgente.class.getResource("/cliente/Resources/Icons/find_reclamo.png")));
		btnVerReclamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verReclamo();
			}
		});
		btnVerReclamo.setBounds(180, 430, 130, 25);
		contentPane.add(btnVerReclamo);
		
		btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon(GUIVerReclamosAgente.class.getResource("/cliente/Resources/Icons/back.png")));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVolver.setBounds(400, 430, 130, 25);
		contentPane.add(btnVolver);
	}
	protected void verReclamo() {
		int row = tabla_reclamos.getSelectedRow();
		if (row >= 0) {
			int aux = tabla_reclamos.convertRowIndexToModel(row);
			Long id = new Long (tabla_reclamos.getValueAt(aux, 0).toString());
			Reclamo_AgenteDTO reclamo_agente = mediador.buscarReclamoAgente(id);
			mediador.verReclamoAgente(reclamo_agente);
		}else{
			JOptionPane.showMessageDialog(null,"Seleccione un reclamo primero.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
		}
	}
}