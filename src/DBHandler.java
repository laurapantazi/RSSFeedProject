import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {
	// JDBC driver name και database URL
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/projectDB";

	// Στοιχεία εισόδου στην βάση
	static final String USER = "postgres";
	static final String PASS = "1234";

	private Connection conn = null;
	private static DBHandler instance=null;
	
	private DBHandler() throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
	}
	
	//method openConnection() that returns the connection with the database
	//if there is no connection or the connection is closed, it creates a new one
	public static Connection openConnection() throws ClassNotFoundException, SQLException{
		if(instance==null||instance.conn.isClosed()){
			instance=new DBHandler();
		}
		return instance.conn;
	}
	
}