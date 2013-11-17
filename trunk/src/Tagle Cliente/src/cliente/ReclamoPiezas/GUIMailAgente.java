package cliente.ReclamoPiezas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import common.DTOs.UsuarioDTO;

public class GUIMailAgente extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private NuevoReclamoAgente reclamo;
	private UsuarioDTO usuario;
	private JPanel contentPane;
	private JEditorPane epCuerpo;
	private JTextField tfFrom;
	private JTextField tfTo;
	private JTextField tfAsunto;
	private JPasswordField pw_email;

	public GUIMailAgente (NuevoReclamoAgente reclamo, UsuarioDTO usuario) {
		this.reclamo = reclamo;
		this.setUsuario(usuario);
		initialize();
		//tfFrom.setText(usuario.getEmail());
		//pw_email.setText(usuario.getClave());

		tfFrom.setText("payomaty666@gmail.com");
		pw_email.setText("pass011235word");

	}
	
	public void initialize(){
		setTitle("ENVIAR RECLAMO AGENTE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 547, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(260, 10, 90, 20);
		contentPane.add(lblContrasea);
		
		pw_email = new JPasswordField();
		pw_email.setBounds(360, 10, 140, 20);
		contentPane.add(pw_email);
	
		epCuerpo = new JEditorPane();
		epCuerpo.setText("hola viste soy un test de email");
		epCuerpo.setBounds(0, 0, 106, 20);
		
		JScrollPane scrollPane = new JScrollPane(epCuerpo);
		scrollPane.setBounds(10, 138, 511, 159);
		contentPane.add(scrollPane);
		
		JLabel lblDe = new JLabel("De:");
		lblDe.setBounds(10, 10, 60, 20);
		contentPane.add(lblDe);
		
		JLabel lblA = new JLabel("A:");
		lblA.setBounds(10, 35, 60, 20);
		contentPane.add(lblA);
		
		JLabel lblAsunto = new JLabel("Asunto:");
		lblAsunto.setBounds(10, 60, 60, 20);
		contentPane.add(lblAsunto);
		
		tfFrom = new JTextField();
		tfFrom.setBounds(80, 10, 140, 20);
		contentPane.add(tfFrom);
		tfFrom.setColumns(10);
		
		tfTo = new JTextField();
		tfTo.setText("matiasbernal.it10@gmail.com");
		tfTo.setBounds(80, 35, 180, 20);
		contentPane.add(tfTo);
		tfTo.setColumns(10);
		
		tfAsunto = new JTextField();
		tfAsunto.setText("Test de envio de Email");
		tfAsunto.setBounds(80, 60, 250, 20);
		contentPane.add(tfAsunto);
		tfAsunto.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(enviarMail()){
					JOptionPane.showMessageDialog(contentPane,"Reclamo enviado.","Informacion",JOptionPane.INFORMATION_MESSAGE);
					reclamo.guardarReclamo();
					dispose();
				}else{
					JOptionPane.showMessageDialog(contentPane,"No se ha podido enviar..","Erro",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEnviar.setBounds(311, 308, 89, 23);
		contentPane.add(btnEnviar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(131, 308, 89, 23);
		contentPane.add(btnCancelar);
	}

    @SuppressWarnings("deprecation")
	public boolean enviarMail (){
        /* Se obtienen las propiedades del Sistema */
        String smtpHost = "smtp.gmail.com";
        String port = "465";
        Properties props = new Properties();
        props.put("mail.smtp.user", tfFrom.getText());
        props.put("mail.smtp.password", pw_email.getText());
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.debug", "false");
        props.put("mail.smtp.socketFactory.port", port);
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        /*Se Obtiene una seesion con las propiedades anteririor mente definidas*/
        Session session = Session.getDefaultInstance(props,null);
        session.setDebug(false);
        try {
            /* Se crea el mensaje vacio */
            MimeMessage mensaje = new MimeMessage(session);
            
			String destinos[] = tfTo.getText().split(",");
			Address [] receptores = new Address [ destinos.length ];
			int j = 0;
			while(j<destinos.length){ 
				receptores[j] = new InternetAddress ( destinos[j] ) ; 
				j++; 
			}
			mensaje.addRecipients(Message.RecipientType.TO, receptores);

            
            mensaje.setFrom(new InternetAddress( tfFrom.getText() ));
			mensaje.setSubject(tfAsunto.getText() );

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(epCuerpo.getText());
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			mensaje.setContent(multipart);
			     
            Transport t = session.getTransport("smtp");
            t.connect(smtpHost,tfFrom.getText(), pw_email.getText());
            t.sendMessage(mensaje,mensaje.getAllRecipients());
            t.close();
            return true;
        }
        catch (MessagingException e){
            System.out.println("\n\n\n\n ERROR \n\n\n\n\n");
            System.err.println(e.getMessage());
            return false;
        }
    }

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

}
