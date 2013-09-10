package servidor;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUIServidor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmServidorTagle;
	private JTextField txtIp;
	private String ip;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIServidor window = new GUIServidor();
					window.frmServidorTagle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GUIServidor() throws UnknownHostException {
		ip = InetAddress.getLocalHost().getHostAddress();
		initialize();
	}

	private void initialize() throws UnknownHostException {
		frmServidorTagle = new JFrame();
		frmServidorTagle.setResizable(false);
		frmServidorTagle.setTitle("SERVIDOR TAGLE");
		frmServidorTagle.setBounds(100, 100, 400, 250);
		frmServidorTagle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmServidorTagle.getContentPane().setLayout(null);
		
		JLabel lblIniciado = new JLabel("El servidor ha iniciado correctamente");
		lblIniciado.setFont(new Font("Consolas", Font.BOLD, 15));
		lblIniciado.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciado.setBounds(15, 11, 363, 36);
		frmServidorTagle.getContentPane().add(lblIniciado);
		
		JLabel lblEjecucionCliente = new JLabel("Habilitado para ejecuci\u00F3n en red");
		lblEjecucionCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblEjecucionCliente.setFont(new Font("Consolas", Font.BOLD, 16));
		lblEjecucionCliente.setBounds(15, 58, 363, 36);
		frmServidorTagle.getContentPane().add(lblEjecucionCliente);
		
		JLabel lblcliente = new JLabel("Ya se puede ejecutar el programa cliente");
		lblcliente.setFont(new Font("Consolas", Font.BOLD, 16));
		lblcliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblcliente.setBounds(15, 152, 363, 36);
		frmServidorTagle.getContentPane().add(lblcliente);
		
		JLabel lblIPservidor = new JLabel("IP:");
		lblIPservidor.setHorizontalAlignment(SwingConstants.CENTER);
		lblIPservidor.setFont(new Font("Consolas", Font.BOLD, 16));
		lblIPservidor.setBounds(82, 105, 45, 26);
		frmServidorTagle.getContentPane().add(lblIPservidor);
		
		txtIp = new JTextField();
		txtIp.setEditable(false);
		txtIp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StringSelection copiar = new StringSelection(ip);
				Clipboard cp = Toolkit.getDefaultToolkit().getSystemClipboard();
				cp.setContents(copiar, null);
				JOptionPane.showMessageDialog(frmServidorTagle,"Copiado al portapapeles.","Copiado...",JOptionPane.PLAIN_MESSAGE);
			}
		});
		txtIp.setText(ip);
		txtIp.setBounds(137, 105, 119, 26);
		frmServidorTagle.getContentPane().add(txtIp);
		txtIp.setColumns(10);
	}
	
	public void show(){
		this.show();
	}
}
