package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
	private final String DB_URL = "jdbc:mysql://localhost:3306/ej4jdbc", DB_USER = "accda", DB_PASSW = "accda";
	protected Connection CONN;

	/**
	 * General connection to the database
	 * @throws SQLException
	 */
	protected AbstractDAO() throws SQLException {
		CONN = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSW);
		CONN.setAutoCommit(false);
	}

	/**
	 * Closes the connection
	 * @throws SQLException
	 */
	protected void closeConn() throws SQLException {
		CONN.close();
	}

	/**
	 * Generates a Statement
	 * @return Statement
	 * @throws SQLException
	 */
	protected Statement getStatement() throws SQLException {
		return CONN.createStatement();
	}

	/**
	 * Generates a specified PreparedStatement
	 * @param stmt String
	 * @return PreparedStatement
	 * @throws SQLException
	 */
	protected PreparedStatement getPreparedStatement(String stmt) throws SQLException {
		return CONN.prepareStatement(stmt,PreparedStatement.RETURN_GENERATED_KEYS);
	}

}
