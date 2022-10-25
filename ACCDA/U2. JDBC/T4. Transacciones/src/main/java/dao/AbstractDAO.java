package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
	private final String DB_URL = "jdbc:mysql://localhost:3306", DB_USER = "accda", DB_PASSW = "accda";
	private Connection CONN;
	
	protected AbstractDAO() throws SQLException {
		CONN = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSW);
	}
	
	protected void closeConn() throws SQLException {
		CONN.close();
	}
	
	protected Statement getStatement() throws SQLException {
		return CONN.createStatement();
	}
}
