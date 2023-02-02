package hlc.ud04.appsec.sampleapp.hotp.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import hlc.ud04.appsec.core.GestorPersistenciaException;

public class PersistenciaLoginHOTP implements GestorLoginHOTP {

	private static final String JDBC_PREFIX = "jdbc:sqlite:";

	private String database;

	public PersistenciaLoginHOTP(String database) {
		this.database = database;
	}

	@Override
	public LoginHOTP getLogin(String usuario) {
		// Conexión (hay que crearla aqui para poderla usar en finaly)
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			Statement statement = conn.createStatement();
			System.out.println(usuario);
			rs = statement.executeQuery("select id, usuario, secreto from loginhotp where usuario = '" + usuario + "'");
			rs.next();
			LoginHOTP login = new LoginHOTP(rs.getInt(1), rs.getString(2), rs.getString(3));
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
