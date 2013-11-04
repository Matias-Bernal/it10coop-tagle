package cliente;

import javax.swing.JOptionPane;

import common.DTOs.NotificacionDTO;
import common.DTOs.UsuarioDTO;
import common.GestionarUsuario.IControlUsuario;
import cliente.GestionOrden.MediadorOrden;
import cliente.GestionarNotificacion.MediadorNotificacion;
import cliente.GestionarPedido.MediadorPedido;
import cliente.GestionarReclamante.MediadorReclamante;
import cliente.GestionarReclamo.MediadorReclamo;
import cliente.GestionarRegistrante.MediadorRegistrante;
import cliente.GestionarUsuario.MediadorUsuario;
import cliente.GestionarVehiculo.MediadorVehiculo;
import cliente.Reclamo.MediadoReclamoRapido;
import cliente.Reporte.MediadorReporte;
import cliente.Repuesto.MediadorReclamos;


public class MediadorPrincipal{

	protected GUIMenu_Principal gui_menu_Principal;
	protected GUILogin gui_login; 
	protected MediadorUsuario mediadorUsuario;
	protected MediadorRegistrante mediadorRegistrante; 
	protected MediadorReclamante mediadorReclamante;
	protected MediadorVehiculo mediadorVehiculos;
	protected MediadorPedido mediadorPedidos;
	protected MediadorReclamo mediadorReclamos;
	protected MediadorNotificacion mediadorNotificaciones;
	protected MediadorOrden mediadorOrden;

	
	protected MediadorReclamos mediadorRepuestos;
	protected MediadoReclamoRapido mediadorReclamoRapido;
	protected MediadorReporte mediadorReporte;
	
	protected UsuarioDTO usuario;
	private MediadorReclamos mediadorRepuesto;
	
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
	public void altaReclamante(String nombre_reclamante, String email, String dni){
		mediadorReclamante = new MediadorReclamante(this);
		mediadorReclamante.altaReclamante(nombre_reclamante,email, dni);
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
	public void gestionarPedidoEntidad() {
		mediadorPedidos = new MediadorPedido(this);
		mediadorPedidos.gestionarPedidoEntidad();
	}

	public void altaPedidoEntidad() {
		mediadorPedidos = new MediadorPedido(this);
		mediadorPedidos.altaPedidoEntidad();
	}

	public void gestionarPedidoAgente() {
		mediadorPedidos = new MediadorPedido(this);
		mediadorPedidos.gestionarPedidoAgente();
	}

	public void altaPedidoAgente() {
		mediadorPedidos = new MediadorPedido(this);
		mediadorPedidos.altaPedidoAgente();
	}
	
	// Reclamo //
	public void altaReclamoAgente(){
		mediadorReclamos = new MediadorReclamo(this);
		mediadorReclamos.altaReclamoAgente();
	}
	public void altaReclamoEntidad() {
		mediadorReclamos = new MediadorReclamo(this);
		mediadorReclamos.altaReclamoEntidad();		
	}

	public void gestionarReclamoAgente(){
		mediadorReclamos = new MediadorReclamo(this);
		mediadorReclamos.gestionReclamoAgente();
	}
	
	public void gestionarReclamoEntidad(){
		mediadorReclamos = new MediadorReclamo(this);
		mediadorReclamos.gestionReclamoEntidad();
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


	//ORDEN//
	public void altaOrden() {
		mediadorOrden = new MediadorOrden(this);
		mediadorOrden.altaOrden();
	}

	public void gestionarOrden() {
		mediadorOrden = new MediadorOrden(this);
		mediadorOrden.gestionarOrden();		
	}
	
	// RECLAMOS //
	public void reclamos() {
		mediadorReclamoRapido= new MediadoReclamoRapido(this);
		mediadorReclamoRapido.altaReclamo();
		
	}
	// REPUESTOS //
	public void repuestos() {
		mediadorRepuesto = new MediadorReclamos(this);
		mediadorRepuesto.mostrarRepuesto();
	}
	// REPORTES //
	public void reportes() {
		mediadorReporte = new MediadorReporte(this);
		mediadorReporte.mostrarReportes();
		
	}

	public void setTiposNotificaciones(boolean turnos, boolean contencion,boolean reclamos, boolean sugerencias) {
		// TODO Auto-generated method stub
		
	}


	
	
	

}
