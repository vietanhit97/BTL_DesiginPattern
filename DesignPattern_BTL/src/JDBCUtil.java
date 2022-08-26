import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	 private static Connection con = null;
	  
	    static
	    {
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=ontap;encrypt=true;trustServerCertificate=true";
	        String user = "sa";
	        String pass = "sa";
	        try {
	           DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
	            con = DriverManager.getConnection(url, user, pass);
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public static Connection getConnection()
	    {
	        return con;
	    }
}
