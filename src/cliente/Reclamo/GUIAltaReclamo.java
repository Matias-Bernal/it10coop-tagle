package cliente.Reclamo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GUIAltaReclamo extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAltaReclamo window = new GUIAltaReclamo();
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
	public GUIAltaReclamo() {
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblFechaDelReclamo = new JLabel("Fecha del Reclamo");
		lblFechaDelReclamo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaDelReclamo.setBounds(0, 34, 125, 25);
		getContentPane().add(lblFechaDelReclamo);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("ALTA RECLAMO");
		frame = new JFrame();
	}
}
