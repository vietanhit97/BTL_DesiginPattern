import java.sql.Connection;

public class Test {
	public static void main(String[] args) {
		 Connection con
	        = JDBCUtil.getConnection();
		 System.out.println(con);
	}
}
