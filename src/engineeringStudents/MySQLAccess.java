package engineeringStudents;

import java.sql.*;


public class MySQLAccess {

	private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/university";
	private static final String username = "root";
	private static final String password = "bruce001";
	
	public static Connection getConnection() throws SQLException{
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connected to the university datadase");
		}catch(ClassNotFoundException e) {
			throw new SQLException("Driver not found", e);
		}	
		
		return DriverManager.getConnection(JDBC_URL, username, password);
		
	
	}
	
}
