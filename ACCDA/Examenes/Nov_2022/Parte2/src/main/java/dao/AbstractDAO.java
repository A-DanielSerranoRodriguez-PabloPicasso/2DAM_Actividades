package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
	private final String DB_URL = "jdbc:mysql://localhost:3306", DB_USER = "accda", DB_PASSWD = "accda";
	protected Connection CONN;

	/**
	 * Constructor abstracto para conectarse a la base de datos
	 * 
	 * @throws SQLException
	 */
	protected AbstractDAO() throws SQLException {
		CONN = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
	}

	/**
	 * Se obtiene un Statement
	 * 
	 * @return Statement
	 * @throws SQLException
	 */
	protected Statement getStatement() throws SQLException {
		return CONN.createStatement();
	}

	/**
	 * Se obtiene un PreparedStatement
	 * 
	 * @param stmt String con la sentencia SQL a ejecutar
	 * @return PreparedStatement
	 * @throws SQLException
	 */
	protected PreparedStatement getPreparedStatement(String stmt) throws SQLException {
		return CONN.prepareStatement(stmt);
	}
}
