package servidor;

import servidor.GestionarAgente.ControlAgente;
import servidor.GestionarBdg.ControlBdg;
import servidor.GestionarDevolucion_Pieza.ControlDevolucion_Pieza;
import servidor.GestionarEntidad.ControlEntidad;
import servidor.GestionarEstado_Pedido.ControlEstado_Pedido;
import servidor.GestionarMTelefono.ControlMTelefono;
import servidor.GestionarMano_Obra.ControlMano_Obra;
import servidor.GestionarMarca.ControlMarca;
import servidor.GestionarModelo.ControlModelo;
import servidor.GestionarMuleto.ControlMuleto;
import servidor.GestionarNotificacion.ControlNotificacion;
import servidor.GestionarNotificacion_Usuario.ControlNotificacion_Usuario;
import servidor.GestionarOrden.ControlOrden;
import servidor.GestionarOrden_Recurso.ControlOrden_Recurso;
import servidor.GestionarPedido.ControlPedido;
import servidor.GestionarPedido_Pieza.ControlPedido_Pieza;
import servidor.GestionarPedido_Pieza_Reclamo_Fabrica.ControlPedido_Pieza_Reclamo_Fabrica;
import servidor.GestionarPieza.ControlPieza;
import servidor.GestionarReclamante.ControlReclamante;
import servidor.GestionarReclamante_Reclamo.ControlReclamante_Reclamo;
import servidor.GestionarReclamo.ControlReclamo;
import servidor.GestionarReclamo_Fabrica.ControlReclamo_Fabrica;
import servidor.GestionarRecurso.ControlRecurso;
import servidor.GestionarRegistrante.ControlRegistrante;
import servidor.GestionarUsuario.ControlUsuario;
import servidor.GestionarVehiculo.ControlVehiculo;


public class Main {  
  
	public static void main(String[] args) {
		String conf = "";
		if ((args != null) && (args.length > 0)) {
			conf = args[0];
		}
		try {
			ControlAgente controlAgente = new ControlAgente();
			ControlBdg controlBdg = new ControlBdg();
			ControlDevolucion_Pieza controlDevolucion_Pieza = new ControlDevolucion_Pieza();
			ControlEntidad controlEntidad = new ControlEntidad();
			ControlEstado_Pedido controlEstado_Pedido = new ControlEstado_Pedido();
			ControlMano_Obra controlMano_Obra = new ControlMano_Obra();
			ControlMarca controlMarca = new ControlMarca();
			ControlModelo controlModelo = new ControlModelo();
			ControlMTelefono controlMTelefono = new ControlMTelefono();
			ControlMuleto controlMuleto = new ControlMuleto();
			ControlNotificacion controlNotificacion = new ControlNotificacion();
			ControlNotificacion_Usuario controlNotificacion_Usuario = new ControlNotificacion_Usuario();
			ControlOrden controlOrden = new ControlOrden();
			ControlOrden_Recurso controlOrden_Recurso = new ControlOrden_Recurso();
			ControlPedido controlPedido = new ControlPedido();
			ControlPedido_Pieza controlPedido_Pieza = new ControlPedido_Pieza();
			ControlPedido_Pieza_Reclamo_Fabrica controlPedido_Pieza_Reclamo_Fabrica = new ControlPedido_Pieza_Reclamo_Fabrica();
			ControlPieza controlPieza = new ControlPieza();
			ControlReclamante controlReclamante = new ControlReclamante();
			ControlReclamante_Reclamo controlReclamante_Reclamo = new ControlReclamante_Reclamo();
			ControlReclamo controlReclamo = new ControlReclamo();
			ControlReclamo_Fabrica controlReclamo_Fabrica = new ControlReclamo_Fabrica();
			ControlRecurso controlRecurso = new ControlRecurso();
			ControlRegistrante controlRegistrante = new ControlRegistrante();
			ControlUsuario controlUsuario = new ControlUsuario();
			ControlVehiculo controlVehiculo = new ControlVehiculo();

			Servidor servidor = new Servidor();
			SingletonConexion c = new SingletonConexion();
			
			servidor.setControlAgente(controlAgente);
			servidor.setControlBdg(controlBdg);
			servidor.setControlDevolucion_Pieza(controlDevolucion_Pieza);
			servidor.setContolEntidad(controlEntidad);
			servidor.setControlEstado_Pedido(controlEstado_Pedido);
			servidor.setControlMano_Obra(controlMano_Obra);
			servidor.setControlMarca(controlMarca);
			servidor.setControlModelo(controlModelo);
			servidor.setControlMTelefono(controlMTelefono);
			servidor.setControlMuleto(controlMuleto);
			servidor.setControlNotificacion(controlNotificacion);
			servidor.setControlNotificacion_Usuario(controlNotificacion_Usuario);
			servidor.setControlOrden(controlOrden);
			servidor.setControlOrden_Recurso(controlOrden_Recurso);
			servidor.setControlPedido(controlPedido);
			servidor.setControlPedido_Pieza(controlPedido_Pieza);
			servidor.setControlPedido_Pieza_Reclamo_Fabrica(controlPedido_Pieza_Reclamo_Fabrica);
			servidor.setControlPieza(controlPieza);
			servidor.setControlReclamante(controlReclamante);
			servidor.setControlReclamante_Reclamo(controlReclamante_Reclamo);
			servidor.setControlReclamo(controlReclamo);
			servidor.setControlReclamo_Fabrica(controlReclamo_Fabrica);
			servidor.setControlRecurso(controlRecurso);
			servidor.setControlRegistrante(controlRegistrante);
			servidor.setControlUsuario(controlUsuario);
			servidor.setControlVehiculo(controlVehiculo);
			
			servidor.iniciar();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
  
}
