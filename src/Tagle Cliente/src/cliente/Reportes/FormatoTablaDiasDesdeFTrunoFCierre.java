package cliente.Reportes;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class FormatoTablaDiasDesdeFTrunoFCierre extends DefaultTableCellRenderer{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int columna_patron ;

    public FormatoTablaDiasDesdeFTrunoFCierre(int Colpatron)
    {
        this.columna_patron = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column )
    {        
        setBackground(Color.white);//color de fondo
        table.setForeground(Color.black);//color de texto
        //Si la celda corresponde a los dias desde frf esta entre [7;15), se cambia el color de fondo a amarillo
        if(Float.parseFloat(table.getValueAt(row,columna_patron).toString())>=7 && Float.parseFloat(table.getValueAt(row,columna_patron).toString())<15)
        {
            setBackground(Color.yellow);
        }else{
            //Si la celda corresponde a los dias desde frf es mayor igual a 15), se cambia el color de fondo a rojo
        	if(Float.parseFloat(table.getValueAt(row,columna_patron).toString())>=15)
        		setBackground(Color.red);
        }
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        return this;
 }

}