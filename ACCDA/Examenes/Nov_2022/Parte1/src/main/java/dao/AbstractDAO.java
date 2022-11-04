package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
	/**
	 * URL del sistema gestor de base de datos, junto al usuario y su contraseña
	 * para la conexion.
	 * 
	 * Se declara la conexion estatica para un uso mas facil.
	 */
	private final String DB_URL = "jdbc:mysql://localhost:3306", DB_USER = "accda", DB_PASS = "accda";
	protected static Connection CONN;

	/**
	 * Crea una conexion al sistema gestor de base de datos.
	 * 
	 * @throws SQLException
	 */
	protected AbstractDAO() throws SQLException {
		CONN = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}

	/**
	 * Crea un Statment.
	 * 
	 * @return Statement
	 * @throws SQLException
	 */
	protected Statement getStatement() throws SQLException {
		return CONN.createStatement();
	}

	/**
	 * Crea un PreparedStatement.
	 * 
	 * @param sql String con la sentencia SQL
	 * @return PreparedStatement
	 * @throws SQLException
	 */
	protected PreparedStatement getPreparedStatement(String sql) throws SQLException {
		return CONN.prepareStatement(sql);
	}
}
