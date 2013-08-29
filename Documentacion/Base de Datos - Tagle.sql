drop schema if exists Tagle cascade;
CREATE schema Tagle;
set search_path='Tagle';
-- ENTIDADES ---
DROP TABLE IF EXISTS REGISTRANTE;
CREATE TABLE REGISTRANTE (
		nombre_registrante varchar(40) NOT NULL,
		CONSTRAINT pk_registrante PRIMARY KEY (nombre_registrante)
);
DROP TABLE IF EXISTS ENTIDAD;
CREATE SEQUENCE ENTIDAD_id_seq MINVALUE 1;
CREATE TABLE ENTIDAD (
		id_entidad int DEFAULT NEXTVAL('ENTIDAD_id_seq') NOT NULL,
		nombre_registrante varchar(40) NOT NULL,
		CONSTRAINT pk_entidad PRIMARY KEY (id_entidad),
		CONSTRAINT fk_nombre_registrante FOREIGN KEY (nombre_registrante) REFERENCES REGISTRANTE (nombre_registrante)
);
DROP TABLE IF EXISTS AGENTE;
CREATE SEQUENCE AGENTE_id_seq MINVALUE 1;
CREATE TABLE AGENTE (
		id_agente int DEFAULT NEXTVAL('AGENTE_id_seq') NOT NULL,
		nombre_registrante varchar(40) NOT NULL,
		CONSTRAINT pk_agente PRIMARY KEY (id_agente),
		CONSTRAINT fk_nombre_registrante FOREIGN KEY (nombre_registrante) REFERENCES REGISTRANTE (nombre_registrante)
);
DROP TABLE IF EXISTS RECLAMANTE;
CREATE SEQUENCE RECLAMANTE_id_seq MINVALUE 1;
CREATE TABLE RECLAMANTE (
		id_reclamante int DEFAULT NEXTVAL('RECLAMANTE_id_seq') NOT NULL,
		nombre_apellido varchar(40) NOT NULL,
		email varchar(40),
		CONSTRAINT pk_reclamante PRIMARY KEY (id_reclamante)
);
-- TABLA PARA EL MULTIVALUADO TELEFONO DELRECLAMANTE
DROP TABLE IF EXISTS MTELEFONO;
CREATE TABLE MTELEFONO (
		id_reclamante int NOT NULL,
		telefono varchar(40) NOT NULL,
		CONSTRAINT pk_mtelefono PRIMARY KEY (id_reclamante, telefono),
		CONSTRAINT fk_reclamante FOREIGN KEY (id_reclamante) REFERENCES RECLAMANTE (id_reclamante)
);
DROP TABLE IF EXISTS MARCA;
CREATE TABLE MARCA (
		nombre_marca varchar(40) NOT NULL,
		CONSTRAINT pk_marca PRIMARY KEY (nombre_marca)
);
DROP TABLE IF EXISTS MODELO;
CREATE TABLE MODELO (
		nombre_modelo varchar(40) NOT NULL,
		nombre_marca varchar(40) NOT NULL,
		CONSTRAINT pk_modelo PRIMARY KEY (nombre_modelo),
		CONSTRAINT fk_nombre_marca FOREIGN KEY (nombre_marca) REFERENCES MARCA (nombre_marca)
);
DROP TABLE IF EXISTS VEHICULO;
CREATE TABLE VEHICULO (
		dominio varchar(40) NOT NULL,
		vin varchar(40) NOT NULL,
		nombre_titular varchar(40) NOT NULL,
		nombre_marca varchar(40) NOT NULL,
		nombre_modelo varchar(40) NOT NULL,
		CONSTRAINT pk_vehiculo PRIMARY KEY (dominio),
		CONSTRAINT fk_nombre_marca FOREIGN KEY (nombre_marca) REFERENCES MARCA (nombre_marca),
		CONSTRAINT fk_nombre_modelo FOREIGN KEY (nombre_modelo) REFERENCES MODELO (nombre_modelo)
);
DROP TABLE IF EXISTS USUARIO;
CREATE TABLE USUARIO (
		nombre_usuario varchar(40) NOT NULL,
		clave varchar(40) NOT NULL,
		email varchar(40) NOT NULL,
		CONSTRAINT pk_usuario PRIMARY KEY (nombre_usuario)
);
DROP TABLE IF EXISTS ADMINISTRATIVO;
CREATE SEQUENCE ADMINISTRATIVO_id_seq MINVALUE 1;
CREATE TABLE ADMINISTRATIVO (
		id_administrativo int DEFAULT NEXTVAL('ADMINISTRATIVO_id_seq') NOT NULL,
		nombre_usuario varchar(40) NOT NULL,
		CONSTRAINT pk_administrativo PRIMARY KEY (id_administrativo),
		CONSTRAINT fk_nombre_usuario FOREIGN KEY (nombre_usuario) REFERENCES USUARIO (nombre_usuario)
);
DROP TABLE IF EXISTS ENCARGADO_REPUESTO;
CREATE SEQUENCE ENCARGADO_REPUESTO_id_seq MINVALUE 1;
CREATE TABLE ENCARGADO_REPUESTO (
		id_encargado_repuesto int DEFAULT NEXTVAL('ENCARGADO_REPUESTO_id_seq') NOT NULL,
		nombre_usuario varchar(40) NOT NULL,
		CONSTRAINT pk_encargado_repuesto PRIMARY KEY (id_encargado_repuesto),
		CONSTRAINT fk_nombre_usuario FOREIGN KEY (nombre_usuario) REFERENCES USUARIO (nombre_usuario)
);
DROP TABLE IF EXISTS RECLAMO;
CREATE SEQUENCE RECLAMO_id_seq MINVALUE 1;
CREATE TABLE RECLAMO (
		id_reclamo int DEFAULT NEXTVAL('RECLAMO_id_seq') NOT NULL,
		fecha_reclamo date NOT NULL,
		fecha_turno date,
		estado_reclamo varchar(40) NOT NULL,
		nombre_registrante varchar(40) NOT NULL,
		id_reclamante int NOT NULL,
		dominio varchar(40) NOT NULL,
		inmovilizado boolean DEFAULT False, 
		peligroso boolean DEFAULT False,
		nombre_usuario varchar(40) NOT NULL,
		CONSTRAINT pk_reclamo PRIMARY KEY (id_reclamo),
		CONSTRAINT fk_nombre_registrante FOREIGN KEY (nombre_registrante) REFERENCES REGISTRANTE (nombre_registrante),
		CONSTRAINT fk_id_reclamante FOREIGN KEY (id_reclamante) REFERENCES RECLAMANTE (id_reclamante),
		CONSTRAINT fk_dominio FOREIGN KEY (dominio) REFERENCES VEHICULO (dominio),
		CONSTRAINT fk_nombre_usuario FOREIGN KEY (nombre_usuario) REFERENCES USUARIO (nombre_usuario)
);
DROP TABLE IF EXISTS PIEZA;
CREATE TABLE PIEZA (
		numero_pieza varchar(40) NOT NULL,
		descripcion varchar(40) NOT NULL,
		CONSTRAINT pk_pieza PRIMARY KEY (numero_pieza)
);
DROP TABLE IF EXISTS ESTADO_PEDIDO;
CREATE TABLE ESTADO_PEDIDO (
		estado_pedido varchar(40) NOT NULL,
		CONSTRAINT pk_estado_pedido PRIMARY KEY (estado_pedido)
);
DROP TABLE IF EXISTS PEDIDO;
--CREATE SEQUENCE PEDIDO_id_seq MINVALUE 1;
CREATE TABLE PEDIDO (
		numero_pedido varchar(40) NOT NULL, --int DEFAULT NEXTVAL('PEDIDO_id_seq') NOT NULL,
		fecha_solicitud_pedido date,
		fecha_solicitud_fabrica date,
		fecha_recepcion_fabrica date,
		numero_orden_trabajo varchar(40),
		pnc varchar(40),
		estado_pedido varchar(40) NOT NULL,
		id_reclamo int NOT NULL,
		CONSTRAINT pk_pedido PRIMARY KEY (numero_pedido),
		CONSTRAINT fk_reclamo FOREIGN KEY (id_reclamo) REFERENCES RECLAMO (id_reclamo),
		CONSTRAINT fk_estado_pedido FOREIGN KEY (estado_pedido) REFERENCES ESTADO_PEDIDO (estado_pedido)
);
DROP TABLE IF EXISTS MULETO;
CREATE SEQUENCE MULETO_id_seq MINVALUE 1;
CREATE TABLE MULETO (
		id_muleto int DEFAULT NEXTVAL('MULETO_id_seq') NOT NULL,
		descripcion varchar(40) NOT NULL,
		vin varchar(40) NOT NULL,
		numero_pedido varchar(40) NOT NULL,
		numero_pieza varchar(40) NOT NULL,
		CONSTRAINT pk_muleto PRIMARY KEY (id_muleto),
		CONSTRAINT fk_numero_pedido FOREIGN KEY (numero_pedido) REFERENCES PEDIDO (numero_pedido),
		CONSTRAINT fk_numero_pieza FOREIGN KEY (numero_pieza) REFERENCES PIEZA (numero_pieza)
);
DROP TABLE IF EXISTS DEVOLUCION_PIEZA;
CREATE SEQUENCE DEVOLUCION_PIEZA_id_seq MINVALUE 1;
CREATE TABLE DEVOLUCION_PIEZA (
		id_devolucion_pieza int DEFAULT NEXTVAL('DEVOLUCION_PIEZA_id_seq') NOT NULL,
		numero_remito varchar(40) NOT NULL,
		fecha_devolucion date NOT NULL,
		transporte varchar(40) NOT NULL,
		CONSTRAINT pk_devolucion_pieza PRIMARY KEY (id_devolucion_pieza)
);
DROP TABLE IF EXISTS MANO_OBRA;
CREATE SEQUENCE MANO_OBRA_id_seq MINVALUE 1;
CREATE TABLE MANO_OBRA (
		id_mano_obra int DEFAULT NEXTVAL('MANO_OBRA_id_seq') NOT NULL,
		cantidad_horas double precision DEFAULT 0,
		valor_mano_obra double precision DEFAULT 0,
		codigo_mano_obra varchar(40),
		id_reclamo int NOT NULL,
		CONSTRAINT pk_mano_obra PRIMARY KEY (id_mano_obra),
		CONSTRAINT fk_reclamo FOREIGN KEY (id_reclamo) REFERENCES RECLAMO (id_reclamo)
);
DROP TABLE IF EXISTS RECURSO;
CREATE SEQUENCE RECURSO_id_seq MINVALUE 1;
CREATE TABLE RECURSO (
		id_recurso int DEFAULT NEXTVAL('RECURSO_id_seq') NOT NULL,
		fecha_recurso date,
		numero_recurso varchar(40),
		CONSTRAINT pk_recurso PRIMARY KEY (id_recurso)
);
-- NOTIFICACIONES --
DROP TABLE IF EXISTS NOTIFICACION;
CREATE SEQUENCE NOTIFICACION_id_seq MINVALUE 1;
CREATE TABLE NOTIFICACION (
		id_notificacion int DEFAULT NEXTVAL('NOTIFICACION_id_seq') NOT NULL,
		fecha_notificacion date NOT NULL,
		concretada_notificacion boolean DEFAULT False,
		texto_notificacion varchar(40) NOT NULL,
		CONSTRAINT pk_notificacion PRIMARY KEY (id_notificacion)
);
DROP TABLE IF EXISTS NOTIFICACION_AREA_ADMINISTRACION;
CREATE SEQUENCE NOTIFICACION_AREA_ADMINISTRACION_id_seq MINVALUE 1;
CREATE TABLE NOTIFICACION_AREA_ADMINISTRACION (
		id_area_administracion int DEFAULT NEXTVAL('NOTIFICACION_AREA_ADMINISTRACION_id_seq') NOT NULL,
		id_notificacion int NOT NULL,
		CONSTRAINT pk_area_administracion PRIMARY KEY (id_area_administracion),
		CONSTRAINT fk_id_notificacion FOREIGN KEY (id_notificacion) REFERENCES NOTIFICACION (id_notificacion)
);
DROP TABLE IF EXISTS NOTIFICACION_AREA_REPUESTO;
CREATE SEQUENCE NOTIFICACION_AREA_REPUESTO_id_seq MINVALUE 1;
CREATE TABLE NOTIFICACION_AREA_REPUESTO (
		id_area_repuesto int DEFAULT NEXTVAL('NOTIFICACION_AREA_REPUESTO_id_seq') NOT NULL,
		id_notificacion int NOT NULL,
		CONSTRAINT pk_area_repuesto PRIMARY KEY (id_area_repuesto),
		CONSTRAINT fk_id_notificacion FOREIGN KEY (id_notificacion) REFERENCES NOTIFICACION (id_notificacion)
);
DROP TABLE IF EXISTS NOTIFICACION_ASIGNACION_TURNOS;
CREATE SEQUENCE NOTIFICACION_ASIGNACION_TURNOS_id_seq MINVALUE 1;
CREATE TABLE NOTIFICACION_ASIGNACION_TURNOS(
		id_asignacion_turnos int DEFAULT NEXTVAL('NOTIFICACION_ASIGNACION_TURNOS_id_seq') NOT NULL,
		id_area_administracion int NOT NULL,
		id_notificacion int NOT NULL,
		CONSTRAINT pk_asignacion_turnos PRIMARY KEY (id_asignacion_turnos),
		CONSTRAINT fk_id_notificacion FOREIGN KEY (id_notificacion) REFERENCES NOTIFICACION (id_notificacion),
		CONSTRAINT fk_id_area_administracion FOREIGN KEY (id_area_administracion) REFERENCES NOTIFICACION_AREA_ADMINISTRACION (id_area_administracion)
);
DROP TABLE IF EXISTS NOTIFICACION_CONTENCION_CLIENTE;
CREATE SEQUENCE NOTIFICACION_CONTENCION_CLIENTE_id_seq MINVALUE 1;
CREATE TABLE NOTIFICACION_CONTENCION_CLIENTE (
		id_contencion_cliente int DEFAULT NEXTVAL('NOTIFICACION_CONTENCION_CLIENTE_id_seq') NOT NULL,
		id_area_administracion int NOT NULL,
		id_notificacion int NOT NULL,
		CONSTRAINT pk_contencion_cliente PRIMARY KEY (id_contencion_cliente),
		CONSTRAINT fk_id_notificacion FOREIGN KEY (id_notificacion) REFERENCES NOTIFICACION (id_notificacion),
		CONSTRAINT fk_id_area_administracion FOREIGN KEY (id_area_administracion) REFERENCES NOTIFICACION_AREA_ADMINISTRACION (id_area_administracion)
);
DROP TABLE IF EXISTS NOTIFICACION_RECLAMO_FABRICA;
CREATE SEQUENCE NOTIFICACION_RECLAMO_FABRICA_id_seq MINVALUE 1;
CREATE TABLE NOTFICACION_RECLAMO_FABRICA (
		id_reclamo_fabrica int DEFAULT NEXTVAL('NOTIFICACION_RECLAMO_FABRICA_id_seq') NOT NULL,
		id_area_repuesto int NOT NULL,
		id_notificacion int NOT NULL,
		CONSTRAINT pk_notificacion_reclamo_fabrica PRIMARY KEY (id_reclamo_fabrica),
		CONSTRAINT fk_id_notificacion FOREIGN KEY (id_notificacion) REFERENCES NOTIFICACION (id_notificacion),
		CONSTRAINT fk_area_repuesto FOREIGN KEY (id_area_repuesto) REFERENCES NOTIFICACION_AREA_REPUESTO (id_area_repuesto)
);
DROP TABLE IF EXISTS NOTIFICACION_SUGERENCIA;
CREATE SEQUENCE NOTIFICACION_SUGERENCIA_id_seq MINVALUE 1;
CREATE TABLE NOTIFICACION_SUGERENCIA (
		id_sugerencia int DEFAULT NEXTVAL('NOTIFICACION_SUGERENCIA_id_seq') NOT NULL,
		id_area_repuesto int NOT NULL,
		id_notificacion int NOT NULL,
		CONSTRAINT pk_sugerencia PRIMARY KEY (id_sugerencia),
		CONSTRAINT fk_id_notificacion FOREIGN KEY (id_notificacion) REFERENCES NOTIFICACION (id_notificacion),
		CONSTRAINT fk_area_repuesto FOREIGN KEY (id_area_repuesto) REFERENCES NOTIFICACION_AREA_REPUESTO (id_area_repuesto)
);
-- FIN NOTIFICACIONES --
DROP TABLE IF EXISTS RECLAMO_FABRICA;
CREATE SEQUENCE RECLAMO_FABRICA_id_seq MINVALUE 1;
CREATE TABLE RECLAMO_FABRICA (
		id_reclamo_fabrica int DEFAULT NEXTVAL('RECLAMO_FABRICA_id_seq') NOT NULL,
		fecha_reclamo_fabrica date NOT NULL,
		numero_pieza varchar(40) NOT NULL,
		numero_pedido varchar(40) NOT NULL,
		nombre_usuario varchar(40) NOT NULL,
		CONSTRAINT pk_reclamo_fabrica PRIMARY KEY (id_reclamo_fabrica),
		CONSTRAINT fk_numero_pieza FOREIGN KEY (numero_pieza) REFERENCES PIEZA (numero_pieza),
		CONSTRAINT fk_numero_pedido FOREIGN KEY (numero_pedido) REFERENCES PEDIDO (numero_pedido),
		CONSTRAINT fk_nombre_usuario FOREIGN KEY (nombre_usuario) REFERENCES USUARIO (nombre_usuario)
);
DROP TABLE IF EXISTS BDG;
CREATE SEQUENCE BDG_id_seq MINVALUE 1;
CREATE TABLE BDG (
		id_bdg int DEFAULT NEXTVAL('BDG_id_seq') NOT NULL,
		fecha_bdg date,
		numero_pieza varchar(40) NOT NULL,
		numero_pedido varchar(40) NOT NULL,
		CONSTRAINT pk_bdg PRIMARY KEY (id_bdg),
		CONSTRAINT fk_numero_pieza FOREIGN KEY (numero_pieza) REFERENCES PIEZA (numero_pieza),
		CONSTRAINT fk_numero_pedido FOREIGN KEY (numero_pedido) REFERENCES PEDIDO (numero_pedido)
);
-- RELACIONES --
DROP TABLE IF EXISTS RECLAMANTE_RECLAMO;
CREATE TABLE RECLAMANTE_RECLAMO (
		id_reclamante int NOT NULL,
		id_reclamo int NOT NULL,
		CONSTRAINT pk_reclamante_reclamo PRIMARY KEY (id_reclamante,id_reclamo),		
		CONSTRAINT fk_reclamante FOREIGN KEY (id_reclamante) REFERENCES RECLAMANTE (id_reclamante),
		CONSTRAINT fk_reclamo FOREIGN KEY (id_reclamo) REFERENCES RECLAMO (id_reclamo)
);
DROP TABLE IF EXISTS NOTIFICACION_USUARIO;
CREATE TABLE NOTIFICACION_USUARIO (
		id_notificacion int NOT NULL,
		nombre_usuario varchar(40) NOT NULL,
		CONSTRAINT pk_notificacion_ususario PRIMARY KEY (id_notificacion,nombre_usuario),		
		CONSTRAINT fk_notificacion FOREIGN KEY (id_notificacion) REFERENCES NOTIFICACION (id_notificacion),
		CONSTRAINT fk_nombre_usuario FOREIGN KEY (nombre_usuario) REFERENCES USUARIO (nombre_usuario)
);
DROP TABLE IF EXISTS PEDIDO_PIEZA;
CREATE TABLE PEDIDO_PIEZA (
		numero_pedido varchar(40) NOT NULL,
		numero_pieza varchar(40) NOT NULL,
		stock boolean DEFAULT False,
		propio boolean DEFAULT False,
		id_muleto int NOT NULL,
		id_devolucion_pieza int NOT NULL,
		estado_pedido varchar(40) NOT NULL,
		fecha_estado date,
		id_bdg int NOT NULL,
		id_recurso int NOT NULL,
		id_mano_obra int NOT NULL,
		CONSTRAINT pk_pedido_pieza PRIMARY KEY (numero_pedido,numero_pieza),
		CONSTRAINT fk_numero_pedido FOREIGN KEY (numero_pedido) REFERENCES PEDIDO (numero_pedido),
		CONSTRAINT fk_numero_pieza FOREIGN KEY (numero_pieza) REFERENCES PIEZA (numero_pieza),
		CONSTRAINT fk_muleto FOREIGN KEY (id_muleto) REFERENCES MULETO (id_muleto),
		CONSTRAINT fk_devolucion_pieza FOREIGN KEY (id_devolucion_pieza) REFERENCES DEVOLUCION_PIEZA (id_devolucion_pieza),
		CONSTRAINT fk_estado_pedido FOREIGN KEY (estado_pedido) REFERENCES ESTADO_PEDIDO (estado_pedido),
		CONSTRAINT fk_bdg FOREIGN KEY (id_bdg) REFERENCES BDG (id_bdg),
		CONSTRAINT fk_recurso FOREIGN KEY (id_recurso) REFERENCES RECURSO (id_recurso),
		CONSTRAINT fk_mano_obra FOREIGN KEY (id_mano_obra) REFERENCES MANO_OBRA (id_mano_obra)
);
DROP TABLE IF EXISTS PEDIDO_PIEZA_RECLAMO_FABRICA;
CREATE TABLE PEDIDO_PIEZA_RECLAMO_FABRICA (
		numero_pedido varchar(40) NOT NULL,
		numero_pieza varchar(40) NOT NULL,
		id_reclamo_fabrica int NOT NULL,
		CONSTRAINT pk_pedido_pieza_reclamo_fabrica PRIMARY KEY (numero_pedido,numero_pieza,id_reclamo_fabrica),
		CONSTRAINT fk_numero_pedido FOREIGN KEY (numero_pedido) REFERENCES PEDIDO (numero_pedido),
		CONSTRAINT fk_numero_pieza FOREIGN KEY (numero_pieza) REFERENCES PIEZA (numero_pieza),
		CONSTRAINT fk_reclamo_fabrica FOREIGN KEY (id_reclamo_fabrica) REFERENCES RECLAMO_FABRICA (id_reclamo_fabrica)
);
-- funcion auditoria que guarda la lista eliminada, la fecha y el usuario que la elimino
-- CREATE FUNCTION funcion_auditoria() returns opaque as 'begin INSERT INTO PEDIDOS_ELIMINADOS (numero_pedido,fecha,nombre_usuario) VALUES 
-- (old.numero_pedido,now(),old.nombre_usuario);
-- return null;
-- end;'
-- LANGUAGE 'plpgsql';
-- creamos el trigget que llama a nuestra funcion auditoria
-- CREATE TRIGGER trigger_funcion_auditoria AFTER DELETE ON LISTA FOR EACH ROW
--	EXECUTE PROCEDURE funcion_auditoria();