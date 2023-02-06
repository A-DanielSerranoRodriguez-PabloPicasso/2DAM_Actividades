package hlc.ud04.appsec.sampleapp.passwd.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import hlc.ud04.appsec.core.GestorPersistenciaException;

public class PersistenciaPasswdPermisos implements GestorPasswdPermisos {

	private static final String JDBC_PREFIX = "jdbc:sqlite:";

	private String database;

	public PersistenciaPasswdPermisos(String database) {
		this.database = database;
	}

	@Override
	public PasswdPermisos getUsuario(long usuario) {
		// Conexión (hay que crearla aqui para poderla usar en finaly)
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			Statement statement = conn.createStatement();
			rs = statement.executeQuery("select permiso from passwdpermisos where usuario = '" + usuario + "'");
			rs.next();
			PasswdPermisos login = new PasswdPermisos(usuario, rs.getString(1));
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
