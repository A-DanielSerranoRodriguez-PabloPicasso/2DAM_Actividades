package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
	/**
	 * Se define la conexion a la base de datos, junto al usuario y su contraseña de
	 * forma que no se puedan modificar.
	 * 
	 * Se establece una conexion estatica a la base de datos para un uso sencillo de
	 * esta.
	 */
	private final String DB_URL = "jdbc:mysql://localhost:3306/bd_neptuno2", DB_USER = "accda", DB_PASSWD = "accda";
	protected static Connection CONN;

	/**
	 * Crea una conexion al sistema gestor de base de datos.
	 * 
	 * @throws SQLException
	 */
	protected AbstractDAO() throws SQLException {
		openCONN();
	}

	/**
	 * Cierra la conexion con el gestor de base de datos
	 * 
	 * @throws SQLException
	 */
	protected void closeCONN() throws SQLException {
		CONN.close();
	}

	/**
	 * Abre la conexion con el gestor de base de datos
	 * 
	 * @throws SQLException
	 */
	protected void openCONN() throws SQLException {
		CONN = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);

	}

	/**
	 * Crea un Statement para realizar sentencias SQL.
	 * 
	 * @return Statement
	 * @throws SQLException
	 */
	protected Statement getStatement() throws SQLException {
		return CONN.createStatement();
	}

	/**
	 * Crea un PreparedStatement para realizar sentencias SQL.
	 * 
	 * @param stmt String con la sentencia SQL.
	 * @return PreparedStatement
	 * @throws SQLException
	 */
	protected PreparedStatement getPreparedStatement(String stmt) throws SQLException {
		return CONN.prepareStatement(stmt);
	}

	/**
	 * Crea un CallableStatement para procedimientos.
	 * 
	 * @param stmt String con la llamada al procedimiento.
	 * @return CallableStatement
	 * @throws SQLException
	 */
	protected CallableStatement getCallableStatement(String stmt) throws SQLException {
		return CONN.prepareCall(stmt);
	}
}
