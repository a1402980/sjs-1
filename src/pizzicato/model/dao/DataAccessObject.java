package pizzicato.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataAccessObject {

	protected static Connection getConnection() {
		Connection connection = null;
		
//tarkasta viel� n�m�
		String dbUsername = Accounts.DBUSERNAME;
		String dbPassword = Accounts.DBPASSWORD;
		String url = "jdbc:mysql://localhost:3306/projekti";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
			
			connection = DriverManager.getConnection(url, dbUsername, dbPassword);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return connection;
	}
	
	protected static void close2(Statement stmt, Statement stmt2, Connection connection) {
		close2 (null, stmt, stmt2, connection);
	}
	
	protected static void close2(ResultSet rs, Statement stmt, Statement stmt2, Connection conn) {
		
		try {
			if (rs !=null) {
				rs.close();
			}
			if (stmt !=null) {
				stmt.close();
			}
			if (stmt2 !=null) {
				stmt2.close();
			}
			if (conn !=null) {
				conn.close();
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	protected static void close3(Statement stmt, Statement stmt2, Statement stmt3, Connection connection) {
		close3 (null, stmt, stmt2, connection);
	}
	
	protected static void close3(ResultSet rs, Statement stmt, Statement stmt2, Statement stmt3, Connection conn) {
		
		try {
			if (rs !=null) {
				rs.close();
			}
			if (stmt !=null) {
				stmt.close();
			}
			if (stmt2 !=null) {
				stmt2.close();
			}
			if (stmt3 !=null) {
				stmt3.close();
			}
			if (conn !=null) {
				conn.close();
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	protected static void close(Statement stmt, Connection connection) {
		close (null, stmt, connection);
	}
	
	protected static void close(ResultSet rs, Statement stmt, Connection conn) {
		
		try {
			if (rs !=null) {
				rs.close();
			}
			if (stmt !=null) {
				stmt.close();
			}
			
			if (conn !=null) {
				conn.close();
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

}


