package common;

public class RootAndIp {

	/* Valores por defecto - verificar el conf.ini */
	private static String ip_servidor="localhost";
	private static String ip_cliente="";
	private static String db="MYSQL";
	private static String username = "root";
	private static String password = "root";

	public static void setConf(String nameFile) {
		if ((nameFile == null)||(nameFile.trim().length() == 0)){
			nameFile = "conf.ini";
		}
		IniFile ini = new IniFile(nameFile);
		ip_servidor = ini.getParameters("ip_servidor");
		ip_cliente= ini.getParameters("ip_cliente");
		db = ini.getParameters("db");
		username = ini.getParameters("username");
		password = ini.getParameters("password");
	}

	public static String getIp_servidor() {
		return ip_servidor;
	}

	public static void setIp_servidor(String ip_servidor) {
		RootAndIp.ip_servidor = ip_servidor;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		RootAndIp.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		RootAndIp.password = password;
	}

	public static String getDb() {
		return db;
	}

	public static void setDb(String db) {
		RootAndIp.db = db;
	}

	public static String getIp_cliente() {
		return ip_cliente;
	}

	public static void setIp_cliente(String ip_cliente) {
		RootAndIp.ip_cliente = ip_cliente;
	}
	
}

