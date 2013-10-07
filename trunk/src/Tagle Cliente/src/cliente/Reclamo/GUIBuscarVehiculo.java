package cliente.Reclamo;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import common.DTOs.VehiculoDTO;

public class GUIBuscarVehiculo extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MediadoReclamoRapido mediador;
	
	private Vector<Vector<String>> datosTabla;
	private Vector<String> nombreColumnas;
	private JTable tablavehiculos;
	private DefaultTableModel modelo;
	
	
	public GUIBuscarVehiculo(MediadoReclamoRapido mediadorReclamo) {

		this.mediador = mediadorReclamo;
		cargarDatos();
		initialize();
		SetVisible(true);
	}
	
	public void initialize() {
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 612, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		modelo = new DefaultTableModel(datosTabla, nombreColumnas);
		tablavehiculos = new JTable(modelo) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		TableRowSorter<TableModel> ordenador = new TableRowSorter<TableModel>(modelo);
		tablavehiculos.setRowSorter(ordenador);
		//
		tablavehiculos.getTableHeader().setReorderingAllowed(false);

		tablavehiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablavehiculos.setBounds(0, 0, 765, 320);
		tablavehiculos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getClickCount() == 2)
					buscarVehiculo();
			    else{
			    	e.consume();
			    }   
			}
		});
		
		JScrollPane scrollPaneTabla = new JScrollPane(tablavehiculos);
		scrollPaneTabla.setBounds(10, 182, 764, 318);
		contentPane.add(scrollPaneTabla);
		
	}

private void cargarDatos() {
		
		modelo = new DefaultTableModel();

		nombreColumnas = new Vector<String> ();
		nombreColumnas.add("ID Vehiculo");
		nombreColumnas.add("Nombre Titular");
		nombreColumnas.add("Dominio");
		nombreColumnas.add("VIN");
		nombreColumnas.add("Marca");
		nombreColumnas.add("Modelo");
	
		datosTabla = new Vector<Vector<String>>();
		Vector<VehiculoDTO> vehiculos = mediador.obtenerVehiculos();
		for (int i=0; i< vehiculos.size();i++){
			Vector<String> row = new Vector<String> ();
			
			row.add(vehiculos.elementAt(i).getId().toString());
			row.add(vehiculos.elementAt(i).getNombre_titular());
			row.add(vehiculos.elementAt(i).getDominio());
			row.add(vehiculos.elementAt(i).getVin());
			row.add(vehiculos.elementAt(i).getMarca().getNombre_marca());
			row.add(vehiculos.elementAt(i).getModelo().getNombre_modelo());
			datosTabla.add(row);
		}
		modelo.setDataVector(datosTabla, nombreColumnas);
		tablavehiculos = new JTable(modelo) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
	}
	public void actualizarPantalla(){ 
		modelo.fireTableStructureChanged();
	}


	public void buscarVehiculo() {
		int row = tablavehiculos.getSelectedRow();
		if (row >= 0) {		
			mediador.setVehiculo(tablavehiculos.getValueAt(row, 0).toString());
			dispose();
		}
	}
	
	private void SetVisible(boolean b) {
		setVisible(true);
	}

}
