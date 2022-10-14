package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
	private final String dbUrl = "jdbc:mysql://localhost:3306/sakila", dbUser = "accda", dbPasswd = "accda";
	private static Connection CONN;

	protected AbstractDAO() throws SQLException {
		CONN = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
	}

	protected Connection getConn() {
		return CONN;
	}

	protected void resetConn() {
		try {
			CONN = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected Statement getStatement() throws SQLException {
		return CONN.createStatement();
	}

	protected void closeConn() throws SQLException {
		CONN.close();
	}
}
