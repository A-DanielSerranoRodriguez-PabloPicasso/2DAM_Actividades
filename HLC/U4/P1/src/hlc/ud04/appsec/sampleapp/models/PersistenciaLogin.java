package hlc.ud04.appsec.sampleapp.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import hlc.ud04.appsec.core.GestorPersistenciaException;

public class PersistenciaLogin implements GestorLogin {

	private static final String JDBC_PREFIX = "jdbc:sqlite:";

	private String database;

	public PersistenciaLogin(String database) {
		this.database = database;
	}

	@Override
	public Login getLogin(String numeroCuenta) {
		// Conexión (hay que crearla aqui para poderla usar en finaly)
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			Statement statement = conn.createStatement();
			rs = statement.executeQuery("select id, secreto from login where id = '" + numeroCuenta + "'");
			rs.next();
			Login login = new Login(rs.getString(1), rs.getString(2));
			return login;
		} catch (SQLException e) {
			// Si hay excepción, la cambia por una nuestra
			throw new GestorPersistenciaException(e);
		} finally {
			// En cualquier caso hay que intentar cerrar la conexión
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_PREFIX + database);
	}

}
