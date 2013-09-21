package cliente;

import javax.swing.JOptionPane;

import common.DTOs.NotificacionDTO;
import common.DTOs.UsuarioDTO;
import common.GestionarUsuario.IControlUsuario;
import cliente.GestionarDevoluviones.MediadorDevoluciones;
import cliente.GestionarNotificacion.MediadorNotificacion;
import cliente.GestionarPedido.MediadorPedido;
import cliente.GestionarReclamante.MediadorReclamante;
import cliente.GestionarReclamo.MediadorReclamo;
import cliente.GestionarRecurso.MediadorRecurso;
import cliente.GestionarRegistrante.MediadorRegistrante;
import cliente.GestionarUsuario.MediadorUsuario;
import cliente.GestionarVehiculo.MediadorVehiculo;
import cliente.Reclamo.MediadoReclamos;
import cliente.Reporte.MediadorReporte;
import cliente.Repuesto.MediadorRepuesto;
import cliente.login.GUILogin;


public class MediadorPrincipal{

	protected GUIMenu_Principal gui_menu_Principal;
	protected GUILogin gui_login; 
	protected MediadorUsuario mediadorUsuario;
	protected MediadorRegistrante mediadorRegistrante; 
	protected MediadorReclamante mediadorReclamante;
	protected MediadorVehiculo mediadorVehiculos;
	protected MediadorPedido mediadorPedidos;
	protected MediadorReclamo mediadorReclamos;
	protected MediadorRecurso mediadorRecursos;
	protected MediadorDevoluciones mediadorDevoluciones;
	protected MediadorNotificacion mediadorNotificaciones;
	
	protected MediadorRepuesto mediadorRepuestos;
	protected MediadoReclamos mediadorReclamoCompleto;
	protected MediadorReporte mediadorReportes;
	
	protected UsuarioDTO usuario;
	
	public MediadorPrincipal() throws Exception{
		gui_login = new GUILogin(this);
		gui_login.setVisible(true);
	}

	// Geters y Seters // 
	
	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
	public boolean acceso(String usuario, String contrasenia) throws Exception {
		boolean result = false;
		try{
			IControlUsuario iControlUsuario = MediadorAccionesIniciarPrograma.getControlUsuarios();
			if (iControlUsuario.login(usuario, contrasenia)){
				setUsuario(iControlUsuario.buscarUsuario(usuario));
				gui_menu_Principal = new GUIMenu_Principal(this);
				gui_menu_Principal.setVisible(true);
				result = true;
			}
		}catch (Exception e){
			JOptionPane.showMessageDialog(gui_login,"Error de conexion.","Error",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		return result;
	}
	
	public void reiniciar(){
		gui_menu_Principal.dispose();
		gui_login = new GUILogin(this);
		gui_login.setVisible(true);
	}

	public void salir() {
		gui_menu_Principal.dispose();
		gui_login.dispose();
		System.exit(0);
	}
	
	// Usuarios //
	
	public void altaUsuario(){
		mediadorUsuario = new MediadorUsuario(this);
		mediadorUsuario.altaUsuario();
	}

	public void gestionarUsuario(){
		mediadorUsuario = new MediadorUsuario(this);
		mediadorUsuario.gestioUsuario();
	}
	public void altaUsuario(String nombre_usuario, String email, String tipo){
		mediadorUsuario = new MediadorUsuario(this);
		mediadorUsuario.altaUsuario(nombre_usuario, email, tipo);
	}
	
	// Registrantes //
	public void altaRegistrante(){
		mediadorRegistrante = new MediadorRegistrante(this);
		mediadorRegistrante.altaRegistrante();
	}

	public void gestionarRegistrante(){
		mediadorRegistrante = new MediadorRegistrante(this);
		mediadorRegistrante.gestioRegistrante();
	}
	public void altaRegistrante(String nombre_registrante, String tipo){
		mediadorRegistrante = new MediadorRegistrante(this);
		mediadorRegistrante.altaRegistrante(nombre_registrante, tipo);
	}
	
	// Reclamantes //
	public void altaReclamante(){
		mediadorReclamante = new MediadorReclamante(this);
		mediadorReclamante.altaReclamante();
	}

	public void gestionarReclamante(){
		mediadorReclamante = new MediadorReclamante(this);
		mediadorReclamante.gestionReclamante();
	}
	public void altaReclamante(String nombre_reclamante, String email, String telefono){
		mediadorReclamante = new MediadorReclamante(this);
		mediadorReclamante.altaReclamante(nombre_reclamante,email, telefono);
	}
	
	// Vehiculo //
	public void altaVehiculo(){
		mediadorVehiculos = new MediadorVehiculo(this);
		mediadorVehiculos.altaVehiculo();
	}

	public void gestionarVehiculo(){
		mediadorVehiculos = new MediadorVehiculo(this);
		mediadorVehiculos.gestionVehiculo();
	}
	public void altaVehiculo(String nombre_titular, String dominio, String vin, String marca, String modelo){
		mediadorVehiculos = new MediadorVehiculo(this);
		mediadorVehiculos.altaVehiculo(nombre_titular,dominio,vin,marca,modelo);
	}
	
	// Pedido //
	public void altaPedido(){
		mediadorPedidos = new MediadorPedido(this);
		mediadorPedidos.altaPedido();
	}

	public void gestionarPedido(){
		mediadorPedidos = new MediadorPedido(this);
		mediadorPedidos.gestionPedido();
	}
	public void altaPedido(String nombre_registrante, String tipo){
		mediadorPedidos = new MediadorPedido(this);
		mediadorPedidos.altaPedido(nombre_registrante,tipo);
	}
	
	// Reclamo //
	public void altaReclamo(){
		mediadorReclamos = new MediadorReclamo(this);
		mediadorReclamos.altaReclamo();
	}

	public void gestionarReclamo(){
		mediadorReclamos = new MediadorReclamo(this);
		mediadorReclamos.gestionReclamo();
	}
	public void altaReclamo(String nombre_registrante, String tipo){
		mediadorReclamos = new MediadorReclamo(this);
		mediadorReclamos.altaReclamo(nombre_registrante,tipo);
	}
	
	// Recurso //
	public void altaRecurso(){
		mediadorRecursos = new MediadorRecurso(this);
		mediadorRecursos.altaRecurso();
	}

	public void gestionarRecurso(){
		mediadorRecursos = new MediadorRecurso(this);
		mediadorReclamos.gestionRecurso();
	}
	public void altaRecurso(String nombre_registrante, String tipo){
		mediadorRecursos = new MediadorRecurso(this);
		mediadorReclamos.altaRecurso(nombre_registrante,tipo);
	}
	
	// Devoluciones //
	public void altaDevolucion(){
		mediadorDevoluciones = new MediadorDevoluciones(this);
		mediadorDevoluciones.altaDevolucion();
	}

	public void gestionarDevolucion(){
		mediadorDevoluciones = new MediadorDevoluciones(this);
		mediadorDevoluciones.gestionDevolucion();
	}
	public void altaDevolucion(String nombre_registrante, String tipo){
		mediadorDevoluciones = new MediadorDevoluciones(this);
		mediadorDevoluciones.altaDevolucion(nombre_registrante,tipo);
	}
	
	// Notificacion //
	public void gestionarNotificaciones(){
		mediadorNotificaciones = new MediadorNotificacion(this);
		mediadorNotificaciones.gestionNotificacion();
	}
	public void actualizarNotificaciones(){
		mediadorNotificaciones = new MediadorNotificacion(this);
		mediadorNotificaciones.actualizarNotificaciones();
	}
	public void notificacionCompletadad(NotificacionDTO notificacionDTO){
		mediadorNotificaciones = new MediadorNotificacion(this);
		mediadorNotificaciones.notificacionCompletada(notificacionDTO);
	}
	public void posponetNotificacion(NotificacionDTO notificacionDTO){
	}
	
	// Ayuda //
	public void ayuda(){
		
	}
	
	// RECLAMOS //
	
	// REPUESTOS //
	
	// REPORTES //

}
