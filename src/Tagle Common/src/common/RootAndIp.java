package common;

public class RootAndIp {

	/* Valores por defecto - verificar el conf.ini */
	private static String ip_servidor="localhost";
	private static String ip_cliente="";
	private static int port= 43210;
	private static String db="MYSQL";
	private static String username = "root";
	private static String password = "root";
	private static float valor_mano_obra_renault = new Float(199.80);
	private static float valor_mano_obra_nissan = new Float(186.57);

	public static void setConf(String nameFile) {
		if ((nameFile == null)||(nameFile.trim().length() == 0)){
			nameFile = "conf.ini";
		}
		IniFile ini = new IniFile(nameFile);
		ip_servidor = ini.getParameters("ip_servidor");
		ip_cliente= ini.getParameters("ip_cliente");
		db = ini.getParameters("db");
		port = Integer.parseInt(ini.getParameters("port"));
		username = ini.getParameters("username");
		password = ini.getParameters("password");
		valor_mano_obra_renault = Float.parseFloat(ini.getParameters("valor_mano_obra_renault"));
		valor_mano_obra_nissan = Float.parseFloat(ini.getParameters("valor_mano_obra_nissan"));
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

	public static int getPort() {
		return port;
	}

	public static void setPort(int port) {
		RootAndIp.port = port;
	}

	public static float getValor_mano_obra_nissan() {
		return valor_mano_obra_nissan;
	}

	public static void setValor_mano_obra_nissan(float valor_mano_obra_nissan) {
		RootAndIp.valor_mano_obra_nissan = valor_mano_obra_nissan;
	}

	public static float getValor_mano_obra_renault() {
		return valor_mano_obra_renault;
	}

	public static void setValor_mano_obra_renault(float valor_mano_obra_renault) {
		RootAndIp.valor_mano_obra_renault = valor_mano_obra_renault;
	}
	
}

