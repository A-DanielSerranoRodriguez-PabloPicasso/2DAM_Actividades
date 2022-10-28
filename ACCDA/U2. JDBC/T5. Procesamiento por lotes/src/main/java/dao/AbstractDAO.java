package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
	private final String DB_URL = "jdbc:mysql://localhost:3306/bd_neptuno2", DB_USER = "accda", DB_PASSWD = "accda";
	protected static Connection CONN;

	protected AbstractDAO() throws SQLException {
		CONN = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
	}

	protected Statement getStatement() throws SQLException {
		return CONN.createStatement();
	}
	
	protected PreparedStatement getPreparedStatement(String stmt) throws SQLException {
		return CONN.prepareStatement(stmt);
	}
}
