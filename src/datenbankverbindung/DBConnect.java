package datenbankverbindung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect {
	//Attribute für die Verbindung mit einer Datenbank
	protected static Connection instance;
	private static final String DB_SERVER = "207.154.234.136:5432";
	private static final String DB_NAME = "1819-Praktikumsdatenbank-01";
	private static final String DB_USER = "1819-Praktikumsdatenbank-01";
	private static final String DB_PASSWORD = "96e3076b52457197fd61b248a8c7659d";
	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://" + DB_SERVER + "/" + DB_NAME;
	
	//Die Connection Instanz wird mit DriverManager.getConnection() mit  den Zugangsdaten der Datenbank definiert.
	private static Connection init() {
		try {
			Class.forName(DB_DRIVER);
			instance = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			return instance;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	//Wenn die Connection Instanz leer oder geschlossen ist, wird die Funktion init() aufgerufen. 
	//Bei einer Exception wird diese gecatcht und trotzdem init() aufgerufen
	public static Connection getConnection() {
		try {
			return (instance == null || instance.isClosed()) ? init() : instance;
		} catch (SQLException e) {
			e.printStackTrace();
			return init();
		}
	}
	//Die vorhandene Connection Instanz wird mit close() geschlossen.
	public static void closeConnection() {
		try {
			instance.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
