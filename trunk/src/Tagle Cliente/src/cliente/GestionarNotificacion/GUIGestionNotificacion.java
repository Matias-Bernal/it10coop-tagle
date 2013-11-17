package cliente.GestionarNotificacion;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import common.DTOs.UsuarioDTO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIGestionNotificacion extends JFrame{

	private static final long serialVersionUID = 1L;
	private MediadorNotificacion mediadorNotificacion;
	private UsuarioDTO usuario;
	
	private JCheckBox chTurnos;
	private JCheckBox chContencion;
	private JCheckBox chReclamoFabrica;
	private JCheckBox chSugerencias;
	private JCheckBox cbReclamoAgente;
	
	public GUIGestionNotificacion(MediadorNotificacion mediadorNotificacion, UsuarioDTO usuario) {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 260);
		this.setMediadorNotificacion(mediadorNotificacion);
		this.setUsuario(usuario);
		setLocationRelativeTo(null);
		
		setTitle("MODIFICAR NOTIFICACIONES");
		getContentPane().setLayout(null);
			
		JLabel lblNotificacionesAdministrativas = new JLabel("NOTIFICACIONES ADMINISTRATIVAS");
		lblNotificacionesAdministrativas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotificacionesAdministrativas.setBounds(10, 11, 207, 20);
		getContentPane().add(lblNotificacionesAdministrativas);
		
		JLabel lblNotificacionesRepuestos = new JLabel("NOTIFICACIONES AREA REPUESTOS");
		lblNotificacionesRepuestos.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotificacionesRepuestos.setBounds(10, 92, 207, 20);
		getContentPane().add(lblNotificacionesRepuestos);
		
		chTurnos = new JCheckBox("Gestion Turnos");
		chTurnos.setBounds(109, 38, 207, 23);
		getContentPane().add(chTurnos);
		
		chContencion = new JCheckBox("Contencion Cliente");
		chContencion.setBounds(109, 64, 207, 23);
		getContentPane().add(chContencion);
		
		chReclamoFabrica = new JCheckBox("Reclamos a Fabrica");
		chReclamoFabrica.setBounds(109, 136, 207, 23);
		getContentPane().add(chReclamoFabrica);
		
		chSugerencias = new JCheckBox("Sugerencias");
		chSugerencias.setBounds(109, 162, 207, 23);
		getContentPane().add(chSugerencias);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarNotificaciones();
			}
		});
		btnActualizar.setBounds(10, 192, 120, 23);
		getContentPane().add(btnActualizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(184, 192, 120, 23);
		getContentPane().add(btnCancelar);
		
		cbReclamoAgente = new JCheckBox("Reclamos a Agente");
		cbReclamoAgente.setBounds(109, 110, 207, 23);
		getContentPane().add(cbReclamoAgente);
		
		if (mediadorNotificacion.esAdministrativo(usuario)){
			chTurnos.setSelected(true);
			chContencion.setSelected(true);
		}else{
			chReclamoFabrica.setSelected(true);
			chSugerencias.setSelected(true);
		}
	}

	protected void actualizarNotificaciones() {
		if (mediadorNotificacion.setTiposNotificaciones(chTurnos.isSelected(),chContencion.isSelected(),cbReclamoAgente.isSelected(),chReclamoFabrica.isSelected(),chSugerencias.isSelected())){
			JOptionPane.showMessageDialog(this,"Notificaciones Modificadas.","Notificacion",JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}else{
			JOptionPane.showMessageDialog(this,"Error al modificar. Inente nuevamente.","Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public MediadorNotificacion getMediadorNotificacion() {
		return mediadorNotificacion;
	}

	public void setMediadorNotificacion(MediadorNotificacion mediadorNotificacion) {
		this.mediadorNotificacion = mediadorNotificacion;
	}
}
