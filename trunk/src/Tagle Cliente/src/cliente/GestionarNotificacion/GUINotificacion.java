package cliente.GestionarNotificacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class GUINotificacion extends JFrame {

	private MediadorEjecutarNotificacion mediador;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea tA_textoNotificacion;
	private JButton btnPosponer;
	private JButton btnCompletada;

	public GUINotificacion(MediadorEjecutarNotificacion mediador,String titulo, String text) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				posponer();
			}
		});
		this.setMediador(mediador);
		initialize();
		setVisible(false);
		tA_textoNotificacion.setText(text);
		setTitle(titulo);
	}
	private void initialize(){
		setResizable(false);
		setType(Type.POPUP);
		setBounds(100, 100, 375, 270);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnCompletada = new JButton("COMPLETADA");
		btnCompletada.setBounds(10, 208, 124, 23);
		btnCompletada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mediador.setCompletada(true);
				mediador.guardarNotificacion();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnCompletada);
		
		btnPosponer = new JButton("POSPONER");
		btnPosponer.setBounds(236, 208, 124, 23);
		btnPosponer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				posponer();
			}
		});
		contentPane.add(btnPosponer);
		
		tA_textoNotificacion = new JTextArea();
		tA_textoNotificacion.setEditable(false);
		tA_textoNotificacion.setLineWrap(true);
		tA_textoNotificacion.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tA_textoNotificacion.setBounds(10, 11, 350, 186);
		contentPane.add(tA_textoNotificacion);
	}
	
	public void posponer(){
		mediador.setPosponer(true);
		setVisible(false);
	}
	
	public MediadorEjecutarNotificacion getMediador() {
		return mediador;
	}
	public void setMediador(MediadorEjecutarNotificacion mediador) {
		this.mediador = mediador;
	}
}
